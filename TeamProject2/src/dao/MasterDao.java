package dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

import service.UserService;
import vo.CompanyVo;
import vo.NoticeVo;
import vo.UserVo;
import database.Database;

public class MasterDao {

   static Scanner s = new Scanner(System.in);
   static int count = 0;    //NoticeNum 수 static화(메서드 돌때랑 상관없이 ++)
   UserVo uv = new UserVo();
   CompanyVo cv = new CompanyVo();
   Database db = Database.getInstance();
   NoticeVo nvo = new NoticeVo();
      
   public void modifyCompany() {   //업체 정보 수정하는 메서드
      UserService usv = new UserService();
      
      boolean isCompanyEmpty = false;      
      do{
         
         if(db.companyList.size() !=0 ){
            isCompanyEmpty = true;
            System.out.println("\n\n업체명\t\t업체연락처\t\t업체주소\t\t\t사업자번호");
            for (int i = 0; i < db.companyList.size(); i++) {        //companyList의 업체 목록을 보여줌
               String name = db.companyList.get(i).getCoName();
               String tel = db.companyList.get(i).getCoTel();
               String addr = db.companyList.get(i).getCoAddr();
               String coNum = db.companyList.get(i).getCoNum();
               System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
               System.out.println(Integer.toString(i+1) +". "+ name + "\t" + tel +"\t"+ addr + "\t" + coNum);
            }
            System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓\n");
            System.out.println("수정하고자 하는 업체 번호를 골라주세요.");         
            int getComNum = Integer.parseInt(s.nextLine());
      
            if(getComNum <= db.companyList.size() ){
               System.out.println("( " + db.companyList.get(getComNum-1).getCoName() + " ) 업체를 선택하셨습니다.");
            }else{
               System.out.println("잘못된 입력입니다. 다시 선택해주세요");
               modifyCompany();
               break;
            }
      
            System.out.println(" 수정하고자 하는 정보를 선택해주세요.");
            System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
            System.out.println(" 1.업체 명");
            System.out.println(" 2.업체 연락처");
            System.out.println(" 3.업체 주소");
            System.out.println(" 4.사업자 번호");
            System.out.println(" 5.뒤로 가기");
            System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
            
            int selModifyNum = Integer.parseInt(s.nextLine());
            boolean isFinish = false;
      
            switch(selModifyNum) {
      
            
               case 1 : System.out.print(" 업체 명을 수정해주세요: ");
               
               String modComName = s.nextLine();
               db.companyList.get(getComNum-1).setCoName(modComName);   
               System.out.println(" 업체 명이 성공적으로 변경되었습니다!");
               isFinish = true;
               break;               
      
               case 2 : System.out.print(" 업체 연락처를 수정해주세요: ");
               do{
               String modComTel = s.nextLine();
               if(usv.chkPattern(modComTel, 4)){   //사업자 연락처 조건
               db.companyList.get(getComNum-1).setCoTel(modComTel);
               System.out.println(" 성공적으로 변경되었습니다!");
               isFinish = true;
               break;
               }else{
                  System.out.println(" 올바른 형식의 연락처가 아닙니다.\n다시 시도해주세요.");
               }
               }while(!isFinish);
               break;
               case 3 : System.out.println(" 업체 주소를 수정해주세요: ");
               
               String modComAddr = s.nextLine();      
               db.companyList.get(getComNum-1).setCoAddr(modComAddr);
               System.out.println(" 업체 주소가 성공적으로 변경되었습니다!");
               isFinish = true;
               break;
               
               case 4 :System.out.println("사업자 등록번호를 수정해주세요: ");
               do{
               String modCoNum = s.nextLine();
               if(usv.chkPattern(modCoNum, 5)){   //사업자 등록번호 조건   
               db.companyList.get(getComNum-1).setCoNum(modCoNum);
               System.out.println(" 성공적으로 변경되었습니다!");
               isFinish = true;
               break;
               }else{
               System.out.println(" 올바른 형식의 사업자 등록번호가 아닙니다. \n 10자리 숫자를 등록해주세요.");
               }
               }while(!isFinish);
               
               case 5 : System.out.println(" 상위 메뉴로 돌아갑니다"); 
               break;
             
               default : System.out.println(" 잘못 입력하셨습니다. \n 상위 메뉴로 돌아갑니다.");
               break;
            }
         }else{
            
         System.out.println("\n 업체가 존재하질 않습니다!\n 상위메뉴로 돌아갑니다");
         break;
         }
         
      }while(!isCompanyEmpty);
            
   }

   public void delCompany() {    //업체 삭제하는 메서드 
      boolean isCompanyEmpty = false;
      do{
         if(db.companyList.size() !=0 ){
            isCompanyEmpty = true;
            System.out.println("\n\n업체명\t\t업체연락처\t\t업체주소\t\t\t사업자번호");
            for (int i = 0; i < db.companyList.size(); i++) {        //companyList의 업체 목록을 보여줌
               String name = db.companyList.get(i).getCoName();
               String tel = db.companyList.get(i).getCoTel();
               String addr = db.companyList.get(i).getCoAddr();
               String coNum = db.companyList.get(i).getCoNum();
               System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
               System.out.println(Integer.toString(i+1) +". "+ name + "\t" + tel +"\t"+ addr + "\t" + coNum);
            }
            System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓\n");
            System.out.println(" 삭제하고자 하는 업체를 골라주세요.");    
            int getComNum = Integer.parseInt(s.nextLine());
            if(getComNum <= db.companyList.size() ){
               System.out.println("( " + db.companyList.get(getComNum-1).getCoName() + " ) 업체를 선택하셨습니다.");
            }else{
               System.out.println(" 잘못된 입력입니다. 다시 선택해주세요");
               delCompany();
               break;
            }
            System.out.println(" 한번 삭제하면 복구되지 않습니다. 그래도 삭제하시겠습니까?");
            System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
            System.out.println(" 1.예");
            System.out.println(" 2.아니오(뒤로가기)");
            System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
            int selIsDel= Integer.parseInt(s.nextLine());
            switch(selIsDel) {
               case 1:
                     String getRemovedUserName = "";
                     String getRemovedCoName = "";
                     for (int i = 0; i < db.userList.size(); i++) {
                        if( db.companyList.get(getComNum-1).getUserId().equals(db.userList.get(i).getUserId()) ){
                           getRemovedCoName = db.companyList.get(getComNum-1).getCoName();
                           getRemovedUserName = db.userList.get(i).getUserName();      
                           
                           for (int j = 0; j < db.coVehicleList.size(); j++) {
                              if( db.companyList.get(getComNum-1).getCoSerialNum().equals(db.coVehicleList.get(j).getCoSerialNum())) {
                                 for (int k = 0; k < db.carOptionList.size(); k++) {
                                    if ( db.coVehicleList.get(j).getCoVNumber().equals(db.carOptionList.get(k).getRentVNUm())) {
                                       db.carOptionList.remove(k);
                                    }
                                 }                                 
                              }
                       } 
                           
                           
                           
                           
                           ArrayList<Integer> savedDelCarIndex = new ArrayList<>();
                           for (int j = 0; j < db.coVehicleList.size(); j++) {
                              if( db.companyList.get(getComNum-1).getCoSerialNum().equals(db.coVehicleList.get(j).getCoSerialNum())) {
                                 savedDelCarIndex.add(j);      
                                 
                                
                              }
                           }
                           for(int j = 0;j< savedDelCarIndex.size(); j++) {
                              db.coVehicleList.remove(savedDelCarIndex.get(j)-j);
                            
                           }
                                                      
                           
                           
                           
                           db.companyList.remove(getComNum-1);
                           db.userList.remove(i);
                        }                     
                     }
                     System.out.println(" 업체 ( "+getRemovedCoName+ " )와 ( "+getRemovedUserName+" ) 님의 대표자 계정이 정상 삭제되었습니다.");
               break;
               case 2: System.out.println(" 상위 메뉴로 돌아갑니다.");
               break;
               default : System.out.println(" 잘못 입력하셨습니다. 상위메뉴로 돌아갑니다.");
               break;   
            }      
         }else{
            System.out.println("\n 업체가 존재하질 않습니다! \n상위메뉴로 돌아갑니다");
            break;
         }
      }while(!isCompanyEmpty);
   }

   public void modifyUser() {    //사용자 정보 수정하는 메서드
      UserService usv = new UserService();
      boolean isUserEmpty = false;
      do{
         if(db.userList.size() !=0 ){
            isUserEmpty = true;
            System.out.println("\n\n아이디\t\t이름\t휴대전화\t\t마일리지");
            for (int i = 0; i < db.userList.size(); i++) {        //userList의 사용자 아이디 목록을 보여줌
               String id = db.userList.get(i).getUserId();
               String name = db.userList.get(i).getUserName();
               String phone = db.userList.get(i).getUserPhone();
               int mileage = db.userList.get(i).getUserMileage();
               System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
               System.out.println(" "+Integer.toString(i+1) +". "+ id + "\t" + name +"\t"+phone + "\t" + mileage);
            }
            System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓\n");
            System.out.println(" 수정하고자 하는 사용자 목록를 골라주세요.");    
            int getUserNum = Integer.parseInt(s.nextLine());
            if(getUserNum <= db.userList.size() ){
               System.out.println("( " + db.userList.get(getUserNum-1).getUserId() +" ) 회원을 선택하셨습니다.");
            }else{
               System.out.println(" 잘못된 입력입니다. 다시 선택해주세요");
               modifyUser();
               break;
            }
         System.out.println("수정하고자 하는 정보를 선택해주세요.");
         System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
         System.out.println(" 1.사용자 비밀번호");
         System.out.println(" 2.사용자 이름");
         System.out.println(" 3.사용자 번호");
         System.out.println(" 4.마일리지 조작");
         System.out.println(" 5.뒤로 가기");
         System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
               
         int selModifyNum = Integer.parseInt(s.nextLine());
         boolean isFinish = false;
         switch(selModifyNum) {         
            case 1: System.out.print("사용자 비밀번호를 수정해주세요: ");
            do{
               String modUserPass = s.nextLine();               
               if(usv.chkPattern(modUserPass, 2)){
               db.userList.get(getUserNum-1).setUserPass(modUserPass);
               System.out.println(" 비밀번호가 성공적으로 변경되었습니다!");
               isFinish = true;
               break;
               }else{
                  System.out.println(" 10~20자리의 영문 대소문자와 숫자, 특수기호 1개이상만 사용 가능합니다.\n 다시 시도해주세요.");
               }
            }while(!isFinish);
            break;
               
            case 2: System.out.print("사용자 이름를 수정해주세요: ");
            do{
               String modUserName = s.nextLine();
               if(usv.chkPattern(modUserName, 3)){
               db.userList.get(getUserNum-1).setUserName(modUserName);
               System.out.println(" 이름이 성공적으로 변경되었습니다!");
               isFinish = true;
               break;
               }else{
                  System.out.println(" 한글만 사용가능합니다.\n 다시 시도해주세요.");
               }
            }while(!isFinish);
            break;
            case 3: System.out.print(" 사용자 연락처를 수정해주세요: ");
            do{
               String modUserPhone = s.nextLine();
               if(usv.chkPattern(modUserPhone, 4)){
               db.userList.get(getUserNum-1).setUserPhone(modUserPhone);
               System.out.println(" 연락처가 성공적으로 변경되었습니다!");
               isFinish = true;
               break;
               }else{
                  System.out.println(" 올바른 형식의 번호가 아닙니다.\n 다시 시도해주세요.");
               }
            }while(!isFinish);
            break;
            case 4: System.out.print(" 사용자의 마일리지를 수정해주세요: ");
            do{
               try{
                  int modUserMileage = Integer.parseInt(s.nextLine());
                  if( !Character.isDigit(modUserMileage) ){
                     db.userList.get(getUserNum-1).setUserMileage(modUserMileage);
                     System.out.println(" 마일리지 보유 정보가 성공적으로 변경되었습니다!");
                     isFinish = true;
                     break;
                  }
               }
               catch(NumberFormatException e){
                  System.out.println("\n Warning: 마일리지는 숫자만 입력하셔야 합니다!! 다시 입력해주세요!");
               }
            }while(!isFinish);
            break;
            case 5: System.out.println(" 상위 메뉴로 돌아갑니다.");
                 break;
            default : System.out.println(" 잘못 입력하셨습니다. 상위메뉴로 돌아갑니다.");
                 break;   
         }
         }else{
            System.out.println(" 사용자가 존재하질 않습니다! \n 상위메뉴로 돌아갑니다");
            break;
         }
      }while(!isUserEmpty);   
   }
   
   public void delUser() {   //사용자 정보 삭제하는 메서드 
      boolean isUserEmpty = false;
      do{
         if(db.userList.size() !=0 ){
            isUserEmpty = true;
            System.out.println("\n\n아이디\t\t이름\t휴대전화\t\t마일리지");
            for (int i = 0; i < db.userList.size(); i++) {        //userList의 사용자 아이디 목록을 보여줌
               String id = db.userList.get(i).getUserId();
               String name = db.userList.get(i).getUserName();
               String phone = db.userList.get(i).getUserPhone();
               int mileage = db.userList.get(i).getUserMileage();
               System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
               System.out.println(Integer.toString(i+1) +". "+ id + "\t" + name +"\t"+phone + "\t" + mileage);
            }
            System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓\n");
            System.out.println(" 삭제하고자 하는 사용자 아이디 목록를 골라주세요.");         
            int getUserNum = Integer.parseInt(s.nextLine());
            if(getUserNum <= db.userList.size() ){
               System.out.println("( " + db.userList.get(getUserNum-1).getUserId() + " ) 회원을 선택하셨습니다.");
            }else{
               System.out.println(" 잘못된 입력입니다. 다시 선택해주세요");
               delUser();
               break;
            }
            
            System.out.println(" 한번 삭제하면 복구되지 않습니다. 그래도 삭제하시겠습니까?");
            System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
            System.out.println(" 1.예");
            System.out.println(" 2.아니오(뒤로가기)");
            System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
            int selIsDel= Integer.parseInt(s.nextLine());
            switch(selIsDel) {               
               case 1: 
                  if(db.userList.get(getUserNum-1).getUserType()==1){
                     db.userList.remove(getUserNum-1);
                     System.out.println(" 해당 아이디는 성공적으로 삭제되었습니다!");
                  }else{
                     String getRemovedUserName = "";
                     String getRemovedCoName = "";
                     for (int i = 0; i < db.companyList.size(); i++) {
                        if( db.userList.get(getUserNum-1).getUserId().equals(db.companyList.get(i).getUserId()) ){
                           getRemovedUserName = db.userList.get(getUserNum-1).getUserName();
                           getRemovedCoName = db.companyList.get(i).getCoName();                        
                           

                           for (int j = 0; j < db.coVehicleList.size(); j++) {
                              if( db.companyList.get(i).getCoSerialNum().equals(db.coVehicleList.get(j).getCoSerialNum())) {
                                 for (int k = 0; k < db.carOptionList.size(); k++) {
                                    if ( db.coVehicleList.get(j).getCoVNumber().equals(db.carOptionList.get(k).getRentVNUm())) {
                                       db.carOptionList.remove(k);
                                    }
                                 }                                 
                              }
                       } 
                                
                           ArrayList<Integer> savedDelCarIndex = new ArrayList<>();
                           for (int j = 0; j < db.coVehicleList.size(); j++) {
                              if( db.companyList.get(i).getCoSerialNum().equals(db.coVehicleList.get(j).getCoSerialNum())) {
                                 savedDelCarIndex.add(j);      
                                 
                                
                              }
                           }
                           for(int j = 0;j< savedDelCarIndex.size(); j++) {
                              db.coVehicleList.remove(savedDelCarIndex.get(j)-j);
                            
                           }
                           
                           db.userList.remove(getUserNum-1);
                           db.companyList.remove(i);
                           break;
                        }
                     }
                     System.out.println(" 사업자 회원 ( " + getRemovedUserName + " ) 님 의 ( "+ getRemovedCoName + " ) 업체가 정삭적으로 삭제되었습니다!");
                  }
               break;
               case 2: System.out.println(" 상위 메뉴로 돌아갑니다.");break;
               default : System.out.println(" 잘못 입력하셨습니다. 상위메뉴로 돌아갑니다.");break;   
            }
         }else{
         System.out.println(" 사용자가 존재하질 않습니다! \n 상위메뉴로 돌아갑니다.");
         break;
         }
      }while(!isUserEmpty);
   }   
   
   public void writeNotice() {    //공지사항 작성+ noticeVo에 있는 인자들 값 넣는 메소드
      Date settoday = new Date();      
      nvo = new NoticeVo();
      ArrayList<NoticeVo> inputNotice = db.noticeList;  
      
      System.out.println("\n 공지사항을 작성하는 메뉴입니다."); 
      String modNoticeTitle = "";
      boolean titleCheck = false;
         
      do{                                              //제목의 글자수 체크
         System.out.println(" 제목을 입력해주세요: ");
         modNoticeTitle = s.nextLine();

         String titleMake = "^[가-힣a-zA-Z\\d\\s!@#$%^&*(),.?\\\":{}|<>]{3,15}$"; //한글,문자포함 3~15자까지
         boolean titleChk = Pattern.matches(titleMake, modNoticeTitle);
         if(titleChk==true){
            titleCheck = true;           
            break;
         }else{
            System.out.println("제목은 <<한글,문자포함 3~15자까지>>입니다. 다시 작성해주세요!");
         }
      }while(!titleCheck);
      System.out.println(" 제목이 성공적으로 작성되었습니다!");
      nvo.setNoticeTitle(modNoticeTitle);
   
      System.out.println(" 내용을 작성하는 메뉴입니다.");    
      System.out.println(" 내용을 입력해주세요: ");
      String inputContents = s.nextLine();
      nvo.setNoticeContent(inputContents);
      System.out.println(" 공지사항이 성공적으로 등록되었습니다!");    // 여기까지 공지사항 제목/내용
      nvo.setNotiDate(settoday);      
      //하위항목은 NoticeNum 구하는 코드  여기부터
      String getNoticeNum = "";
      DateFormat sdft = new SimpleDateFormat("yyyyMMdd");
      String today = sdft.format(settoday);
      getNoticeNum = "n-" ;
      getNoticeNum = getNoticeNum.concat(today);  //n-와 오늘 날짜 병합 (ex:n-20200121)까지
      count++;   //메서드 한번 실행될때마다 count++, 게시글의 번호는 메서드 실행 횟수로 계산됨
      String.valueOf(count);   //count값을 스트링화
      String countNotice = "";   //count를 스트링화 시킨 값을 담는 변수
      countNotice = String.format("%03d", count);      //스트링화 된 count를 세자리의 꼴로 변환 시킴
      getNoticeNum = getNoticeNum.concat(countNotice);
      nvo.setNoticeNum(getNoticeNum);      
      //여기까지 noticeNum 끝
      inputNotice.add(nvo);  //NoticeVo의 형식대로 DB의 noticeList에 넣음   
   }
   
   public void modifyNotice() {   //공지사항을 수정하는 메서드
      DateFormat sdft = new SimpleDateFormat("yyyyMMdd");
      boolean isNoticeEmpty = false;
      do{
         if(db.noticeList.size() !=0 ){
            isNoticeEmpty = true;
            System.out.println(" \n\n제목\t\t\t게시날짜\t\t\t글번호");
            
            for (int i = 0; i < db.noticeList.size(); i++) {        //noticeList의 공지 목록을 보여줌
               String title = db.noticeList.get(i).getNoticeTitle();
               String date = sdft.format(db.noticeList.get(i).getNotiDate());
               String number = db.noticeList.get(i).getNoticeNum();
               System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
               System.out.println(Integer.toString(i+1) +". "+ title  +"\t\t"+ date + "\t\t" + number);
            }
            System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓\n");
            System.out.println(" 수정하고자 하는 공지사항 번호를 골라주세요.");         
            int getNoticeNum = Integer.parseInt(s.nextLine());
            if(getNoticeNum <= db.noticeList.size() ){
               System.out.println("제목: ( " + db.noticeList.get(getNoticeNum-1).getNoticeTitle() + " ) 를 선택하셨습니다.");
            }else{
               System.out.println(" 잘못된 입력입니다. 다시 선택해주세요");
               modifyNotice();
               break;
            }
            System.out.println(" 수정하고자 하는 항목를 선택해주세요.");
            System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
            System.out.println(" 1.제목");
            System.out.println(" 2.내용");   
            System.out.println(" 3.뒤로 가기");
            System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
            int selModifyNum = Integer.parseInt(s.nextLine());
            switch(selModifyNum) {
               case 1: 
                  String modNoticeTitle = "";
                  boolean titleCheck = false;
                  do{                                              //제목의 글자수 체크
                     System.out.println(" 제목을 입력해주세요: ");
                     modNoticeTitle = s.nextLine();
         
                     String titleMake = "^[가-힣a-zA-Z\\d\\s!@#$%^&*(),.?\\\":{}|<>]{3,20}$"; //한글,문자포함 3~20자까지
                     boolean titleChk = Pattern.matches(titleMake, modNoticeTitle);
                     if(titleChk==true){
                        titleCheck = true;           
                        break;
                     }else{
                        System.out.println(" 제목은 <<한글,문자포함 3~20자까지>>입니다. 다시 작성해주세요!");
                     }
                  }while(!titleCheck);
                     db.noticeList.get(getNoticeNum-1).setNoticeTitle(modNoticeTitle);
                     System.out.println(" 제목이 성공적으로 변경되었습니다!");
                     break;
               case 2:   System.out.print(" 내용을 수정해주세요: ");
               String modNoticeContents = s.nextLine();
               db.noticeList.get(getNoticeNum-1).setNoticeContent(modNoticeContents);
               System.out.println(" 내용이 성공적으로 변경되었습니다!");
               break;
               case 3: System.out.println(" 상위 항목으로 이동합니다."); break;
            }
         }else{
            System.out.println("\n 공지사항이 존재하질 않습니다! \n 상위메뉴로 돌아갑니다");
            break;
         }
      }while(!isNoticeEmpty);
   }
   
   public void delNotice() {    //공지사항을 제목에 따라 삭제하는 메서드
      DateFormat sdft = new SimpleDateFormat("yyyyMMdd");
      boolean isNoticeEmpty = false;
      do{
         if(db.noticeList.size() !=0 ){         
            isNoticeEmpty = true;
            System.out.println("\n\n제목\t\t\t게시날짜\t\t\t글번호");
            
            for (int i = 0; i < db.noticeList.size(); i++) {        //noticeList의 공지 목록을 보여줌
               String title = db.noticeList.get(i).getNoticeTitle();
               String date = sdft.format(db.noticeList.get(i).getNotiDate());
               String number = db.noticeList.get(i).getNoticeNum();
               System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
               System.out.println(Integer.toString(i+1) +". "+ title + "\t\t"+ date + "\t\t" + number);
            }
            System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓\n");
            System.out.println(" 삭제하고자 하는 공지사항의 제목을 골라주세요.");         
            int getNoticeNum = Integer.parseInt(s.nextLine());
               if(getNoticeNum <= db.noticeList.size() ){
               System.out.println("제목이 ( " + db.noticeList.get(getNoticeNum-1).getNoticeTitle() + " ) 글을 선택하셨습니다.");
               }else{
                  System.out.println(" 잘못된 입력입니다. 다시 선택해주세요");
                  delNotice();
                  break;
               }
               System.out.println(" 한번 삭제하면 복구되지 않습니다. 그래도 삭제하시겠습니까?");
               System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
               System.out.println(" 1.예");
               System.out.println(" 2.아니오(뒤로가기)");
               System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
               int selIsDel= Integer.parseInt(s.nextLine());
               switch(selIsDel) {
               case 1: db.noticeList.remove(getNoticeNum-1);
               System.out.println(" 해당 글은 성공적으로 삭제되었습니다!");
               break;
               case 2: System.out.println(" 상위 메뉴로 돌아갑니다.");
               break;
               default : System.out.println(" 잘못 입력하셨습니다. 상위메뉴로 돌아갑니다.");
               break;
               }
         }else{
            System.out.println("\n 공지사항이 존재하질 않습니다! \n 상위메뉴로 돌아갑니다");
            break;
         }
      }while(!isNoticeEmpty);
   }
   
}