package dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import vo.ReviewVo;
import Session.UserSession;
import database.Database;

public class ReviewDao {
   Date setToday = new Date();
   Scanner s = new Scanner(System.in);
   Database db = Database.getInstance();
   ReviewVo rvo = new ReviewVo();
   
   public void makeReview() {
      
      ArrayList<ReviewVo> inputReview = db.reviewList; 
      UserSession session = new UserSession();
      rvo = new ReviewVo();
      int tempRNum = 0;
      
      for(int i = 0; i < db.companyList.size(); i++){ 
         System.out.println(i + 1 + ". " + db.companyList.get(i).getCoName());   
      }
      int selectCoName = Integer.parseInt(s.nextLine());
      rvo.setCoName(db.companyList.get(selectCoName - 1).getCoName());      
      
      System.out.println(db.companyList.get(selectCoName - 1).getCoName() + " 업체에 대한 리뷰를 작성해주세요: ");
      String inputRContents = s.nextLine();
      rvo.setReviewContent(inputRContents);   //입력받은 값 리뷰 내용 등록
      
      System.out.println("리뷰가 성공적으로 등록되었습니다!");    
      
      rvo.setReviewDate(setToday);      //리뷰 날짜 입력
      
      /////////////reviewNum계산////////////
      for (int i = 0; i < db.reviewList.size(); i++) {
         if(db.companyList.get(selectCoName-1).getCoName().equals(db.reviewList.get(i).getCoName())){
            tempRNum =db.reviewList.get(i).getReviewNum();
            tempRNum ++;
         }
      }       
      
      rvo.setReviewNum(tempRNum++);      
      //여기까지 reviewNum 끝
      
      rvo.setUserId(session.loginUserId);   
   
    
      inputReview.add(rvo);  //ReviewVo의 형식대로 DB의 reviewList에 넣음         
   
   }
   
   

   public void showReviewList(int comSel) {    //(비회원/회원)차량검색->해당 차 보유한 업체선택-> 01로 리뷰보기  
         
        SimpleDateFormat sdft = new SimpleDateFormat("yy/MM/dd/HH:MM"); //뽑아낼때 리뷰 작성 날짜 이쁘게 하기 위해
        int rnum = 0;
        
        if(db.reviewList.size()==0){                 //리뷰리스트에 리뷰가 완전 0일때
           System.out.println(" 작성된 리뷰가 없습니다!");
        }    
                                                                        //리뷰리스트에도 리뷰가 있고 해당업체에도 리뷰가 있을때
              for (int i = 0; i < db.reviewList.size(); i++) {              //해당업체의 해당리뷰를 뽑아내기 위해 검색하는 for문 ->해당 i를 reviewListgetComNum에 넣음
                 String rid = "", rcontents = "", rdate = "";
                 //String rcoName = ""; //해당하는 업체에 제대로 들어가는지 확인하기 위해 쓴 변수
                 
                    if(db.companyList.get(comSel - 1).getCoName().equals(db.reviewList.get(i).getCoName())){
             
                       for (int j = 0; j < db.reviewList.size(); j++) {
                          rid = db.reviewList.get(i).getUserId();
                          rcontents = db.reviewList.get(i).getReviewContent();
                          rnum = db.reviewList.get(i).getReviewNum()+1;
                          rdate = sdft.format(db.reviewList.get(i).getReviewDate());
                          //rcoName = db.reviewList.get(i).getCoName();               
                       }
                       System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
                       System.out.println(rnum + ". "+ rid + "    " +  rdate +" \t" + rcontents );
                    }        
              } 
              
              if(rnum == 0) {
                 System.out.println();
              }else {
                 System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓\n\n");
                 System.out.println(" 뒤로가시려면 아무키나 입력해 주세요.");
                 s = new Scanner(System.in);
                 String str = s.nextLine();
              }
          
         
      }
   
   public void updateReview(int select, String content){
      db.reviewList.get(select).setReviewContent(content);
   }
   
   public void deleteReview(int select){
      db.reviewList.remove(select);
   }



public void myComShowReview(String id) {     //메인메뉴>>사업자>>자회사리뷰보기에서 회사 선택하는 창
   for (int i = 0; i < db.companyList.size(); i++) {
      if(id.equals(db.companyList.get(i).getUserId())) {
         showReviewList(i+1);
      }      
   }   
}
   
   
}