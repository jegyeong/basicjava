package service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import vo.CarOptionVo;
import vo.CoVehicleVo;
import vo.CompanyVo;
import vo.UserRentVo;
import vo.VehicleNameVo;
import vo.VehicleSeriesVo;
import Session.UserSession;
import dao.CoVehicleDao;
import dao.CompanyDao;
import dao.ReviewDao;
import dao.UserDao;
import database.Database;


public class CompanyService {
   UserService us2 = new UserService();
   Scanner scan = new Scanner(System.in);
   Database db = Database.getInstance();
   CoVehicleDao codao = new CoVehicleDao();
   UserSession session = new UserSession();
   
   public ArrayList<CompanyVo> getRentCompInfos(HashMap<String, String> map) {
		String series = map.get("series");
		String name = map.get("name");
		ArrayList<String> serialArray = codao.rentableCompany(series, name);
		
		CompanyDao cdao = new CompanyDao();
		ArrayList<CompanyVo> compArray = cdao.getCompanyList();
		ArrayList<CompanyVo> temp = new ArrayList<>();
		for(int i = 0; i< serialArray.size(); i++){
			for(int j = 0; j<compArray.size(); j++ ){
				if(serialArray.get(i).equals(compArray.get(j).getCoSerialNum())){
//					 
						CompanyVo cvo = new CompanyVo();
						cvo.setCoAddr(compArray.get(j).getCoAddr());
						cvo.setCoName(compArray.get(j).getCoName());
						cvo.setCoNum(compArray.get(j).getCoNum());
						cvo.setCoSerialNum(compArray.get(j).getCoSerialNum());
						cvo.setCoTel(compArray.get(j).getCoTel());
						cvo.setUserId(compArray.get(j).getUserId());
						temp.add(cvo);
//					
				}
			}
			
		}
		return temp;
		
	   
	   
	}
   
   
   public void createCompanyInfos(String userId) {
         CompanyVo cvo = new CompanyVo();
         CompanyDao cdao = new CompanyDao();
         System.out.println("\n 회사 정보를 입력하는 창 입니다.");
         System.out.println(" 사용하실 회사 이름을 적어주세요.");
         System.out.print(" 회사이름 : ");
         String coName = scan.nextLine();
         boolean correct = false;
         String coTel = chkCoTel();
         System.out.println("회사 주소를 입력해 주세요.");
         String coAddr = scan.nextLine();
        
         String coNum = chkCoNum();
         Date today = new Date();      
         DateFormat sdft = new SimpleDateFormat("yyyyMMdd");
         String coSerialNum = String.valueOf(sdft.format(today)) + coNum;
         cvo.setUserId(userId);
         cvo.setCoName(coName);
         cvo.setCoTel(coTel);
         cvo.setCoAddr(coAddr);
         cvo.setCoNum(coNum);
         cvo.setCoSerialNum(coSerialNum);
         cdao.insertCompany(cvo);
         System.out.println(" 업체 정보 등록이 완료 되었습니다.");
   }
   private String chkCoTel() {
		String coTel = null;
		do {
			System.out.println("\n 회사 전화번호를 입력해 주세요. \n");
			System.out.print(" 회사번호 : ");
			coTel = scan.nextLine();
			us2.chkPattern(coTel,4);
			if(us2.chkPattern(coTel,4)==true){
				coTel = coTel.replace("-", "");
				System.out.println(" 인증 완료\n");
				return coTel;
			}else{
				System.out.println(" 올바른 형식의 번호가 아닙니다.");
				coTel = null;
			}
			}while(coTel == null);
		return null;
	}
	
	private String chkCoNum() {
		String coNum = null;
		do {
			System.out.println("\n 사업자 번호를 입력해 주세요. \n");
			System.out.print(" 사업자 번호 : ");
			coNum = scan.nextLine();
			us2.chkPattern(coNum,5);
			if(us2.chkPattern(coNum,5)==true){
				coNum = coNum.replace("-", "");
				System.out.println(" 인증 완료\n");
				return coNum;
			}else{
				System.out.println("올바른 형식의 번호가 아닙니다.");
				coNum = null;
			}
			}while(coNum == null);
		return null;
	}
	
	public void showcovehicleMenu() { //차량 등록 메뉴
		int select;
		do{
			
		System.out.println("〓〓〓〓〓   차량 등록 메뉴   〓〓〓〓〓");
		System.out.println(" 1. 차량 등록");
		System.out.println(" 0. 뒤로가기");
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");

		select = Integer.parseInt(scan.nextLine());
			switch(select){
			case 0: 
				break;
			case 1: 
				covehicleInsert(); 
				break;
			default:
				break;
			}
		}while(select != 0);
	}
	
	public void covehicleInsert() { //차량 등록
	      
	      CoVehicleVo covvo = new CoVehicleVo();
	      
	      String coVNumber;
	      
	      boolean isCheckcoVNumber = false;
	      
	      do{
	         System.out.println("〓〓〓〓〓〓   차량 등록   〓〓〓〓〓〓");
	         System.out.print(" 차번 : "); //기본키
	         coVNumber = scan.nextLine();
	         String regex = "^\\d{2}[허|하|호]\\d{4}/*$";
	         Pattern p = Pattern.compile(regex);
	         Matcher m = p.matcher(coVNumber);
	         if(m.matches()){
	            isCheckcoVNumber = true;
	            covvo.setCoVNumber(coVNumber);
	         }else{   
	            System.out.println("잘못 입력 하셨습니다.");
	         }
	      }while(isCheckcoVNumber == false);
	      
	      VehicleService vs = new VehicleService();
	      VehicleSeriesVo vo = vs.gettingSeries();
	      String vSeries = vo.getvSeries();
	      System.out.println(" 시리즈 : " + vo.getvSeries());
	      System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
	      covvo.setvSeries(vo.getvSeries());
	      VehicleNameVo cvnvo = vs.gettingVName(vo.getIndex());
	      String vName = cvnvo.getvName();
	      System.out.println(" 차종 : " + cvnvo.getvName());
	      System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
	      covvo.setvName(cvnvo.getvName());
	      
	         System.out.print(" 금액 : ");
	         int rentPrice = Integer.parseInt(scan.nextLine());
	         covvo.setRentPrice(rentPrice);
	         
	         covvo.setCoSerialNum(null);
	         System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
	         System.out.println("옵션이 있으면 1 없으면 0을 입력해주세요.");
	         ArrayList<CarOptionVo> carOptionList = codao.settingCarOptionList();
	         CarOptionVo cvo = new CarOptionVo();
	            cvo.setRentVNUm(coVNumber);
	            // 1 : 옵션이 있다.  0 : 옵션이 없다.
	               System.out.print("운전석에어백 : ");
	               int a = Integer.parseInt(scan.nextLine());
	               cvo.setDriveAirBag(a);
	          
	               System.out.print("조수석에어백 : ");
	               int a1 = Integer.parseInt(scan.nextLine());
	               cvo.setAssistantAirBag(a1);
	              
	               System.out.print("후방카메라 : ");
	               int a2 = Integer.parseInt(scan.nextLine());
	               cvo.setRearCamera(a2);
	             
	               System.out.print("후방센서 : ");
	               int a3 = Integer.parseInt(scan.nextLine());
	               cvo.setRearSensor(a3);
	             
	               System.out.print("블랙박스 : ");
	               int a4 = Integer.parseInt(scan.nextLine());
	               cvo.setBlackBox(a4);
	             
	               System.out.print("후륜구동: ");
	               int a5 = Integer.parseInt(scan.nextLine());
	               cvo.setFourWD(a5);
	              
	               System.out.print("네비게이션 : ");
	               int a6 = Integer.parseInt(scan.nextLine());
	               cvo.setNavigation(a6);
	               
	               System.out.print("리모트키 : ");
	               int a7 = Integer.parseInt(scan.nextLine());
	               cvo.setRemoteKey(a7);
	               
	               System.out.print("스마트키 : ");
	               int a8 = Integer.parseInt(scan.nextLine());
	               cvo.setSmartKey(a8);
	             
	               System.out.print("열선시트 : ");
	               int a9 = Integer.parseInt(scan.nextLine());
	               cvo.setHeatingSeat(a9);
	             
	               System.out.print("통풍시트 : ");
	               int a10 = Integer.parseInt(scan.nextLine());
	               cvo.setCoolingSeat(a10);
	              
	               System.out.print("선루프 : ");
	               int a11 = Integer.parseInt(scan.nextLine());
	               cvo.setSunRoof(a11);
	              
	               System.out.print("블루투스 : ");
	               int a12 = Integer.parseInt(scan.nextLine());
	               cvo.setBluetooth(a12);
	             
	            carOptionList.add(cvo);
	         String coSerialNum = codao.getCoSerialNum(session.loginUserId);
	         covvo.setCoSerialNum(coSerialNum);
	      
	         db.coVehicleList.add(covvo);
	         System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
	         System.out.println(vSeries + " : " + vName + " 차번 : " +coVNumber +  " 가격 : " + rentPrice + " 정보의 차량이 등록되었습니다.");
	         System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
	         
	         codao.getCarOptionList(covvo.getCoVNumber());
//	         System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
	         System.out.println("차량 등록 메뉴로 이동합니다.");
	      }
	
	public void showControlMenu(){ //차량 관리 메뉴
		int select;
		do{
			System.out.println("〓〓〓〓〓   차량 관리 메뉴   〓〓〓〓〓");
			System.out.println(" 1.차량 수정");
			System.out.println(" 2.차량 삭제");
			System.out.println(" 0.뒤로가기");
			
		select = Integer.parseInt(scan.nextLine());
			switch(select){
			case 0: 
				select=0;
				break;
			case 1: 
				coVehicleUpdate();
				break;
			case 2: 
				covehicleRemove(); 
				break;
			default:
				break;
			}
		}while(select != 0);
	}
	
	public void covehicleRemove() { //차량 삭제	
		boolean isremove = false;
		String coSerialNum = codao.getCoSerialNum(session.loginUserId);
		do {
			if (codao.getCoVehicleList(coSerialNum).size() != 0) {
				isremove = true;
				ArrayList<CoVehicleVo> tempList = codao.getCoVehicleList(coSerialNum);
				for(int i = 0; i < tempList.size(); i++ ){
					System.out.print(i + 1 + "." + tempList.get(i).getCoVNumber());
					System.out.print("\t"+tempList.get(i).getvSeries());
					System.out.print("\t"+tempList.get(i).getvName());
					System.out.print("\t"+tempList.get(i).getRentPrice());
					System.out.println();
				}
				
				System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
				System.out.println(" 삭제하고자 하는 번호를 선택해주세요.");
				int select = Integer.parseInt(scan.nextLine());
				if (select <= codao.getCoVehicleList(coSerialNum).size()) {
					System.out.println(codao.getCoVehicleList(coSerialNum).get(select - 1)
							.getCoVNumber() + "차량의 정보를 선택하셨습니다.");
				}else {
					System.out.println(" 잘못 입력하여 되돌아갑니다.");
					covehicleRemove();
					break;
				}

				System.out.println(" 한번 삭제하면 복구되지 않습니다. 그래도 삭제하시겠습니까?");
				System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓");
				System.out.println(" 1.예");
				System.out.println(" 2.아니오");
				System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓");

				int delete = Integer.parseInt(scan.nextLine());

				switch (delete) {
				case 1:
					for(int i = 0; i< codao.getCoVehicleList().size(); i++){
						if(codao.getCoVehicleList(coSerialNum).get(select -1).getCoSerialNum() == codao.getCoVehicleList().get(i).getCoSerialNum()){
							codao.deleteCoVehicle(i);		
						}
					}
					
					System.out.println(" 해당 차량의 정보가 삭제되었습니다.");
					isremove = true;
					break;
				case 2:
					System.out.println(" 상위 메뉴로 돌아갑니다.");
					showControlMenu();
					break;
					default: break;
				}
			}else if(codao.getCoVehicleList(coSerialNum).size() == 0){
				System.out.println(" 삭제할 차량의 정보가 없습니다. \n상위 메뉴로 돌아갑니다.");
				break;
			}
	}while(isremove == false);
	}
	
	public void coVehicleUpdate(){ //차량 수정	
		boolean isUpdateCovehicle = false;
		String coSerialNum = codao.getCoSerialNum(session.loginUserId);
		do{
			if(codao.getCoVehicleList(coSerialNum).size() != 0){
				isUpdateCovehicle = true;
				System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
				ArrayList<CoVehicleVo> tempList = codao.getCoVehicleList(coSerialNum);
				for(int i = 0; i < tempList.size(); i++ ){
					System.out.print(i + 1 + "." + tempList.get(i).getCoVNumber());
					System.out.print("\t"+tempList.get(i).getvSeries());
					System.out.print("\t"+tempList.get(i).getvName());
					System.out.print("\t"+tempList.get(i).getRentPrice());
					System.out.println();
				}
				System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
				System.out.println(" 수정하고자 하는 번호를 선택해주세요.");
				int select = Integer.parseInt(scan.nextLine());
				if(select <= codao.getCoVehicleList(coSerialNum).size()){
					System.out.println(codao.getCoVehicleList(coSerialNum).get(select - 1).getCoVNumber() + "차량의 정보를 선택하셨습니다.");
				}else{
					System.out.println("잘못 입력하여 되돌아갑니다.");
					coVehicleUpdate();
					break;
				}
				System.out.println("수정하고자 하는 차량정보를 선택해주세요.");
				System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
				System.out.println(" 1.차번");
				System.out.println(" 2.시리즈 / 차종");
				System.out.println(" 3.금액");
				System.out.println(" 0.뒤로가기");
				System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
				
				int selectNum = Integer.parseInt(scan.nextLine());
				
				
				switch(selectNum){
				case 0:
					System.out.println(" 상위 메뉴로 돌아갑니다.");
					break;
				case 1:
					System.out.print(" 차번을 수정해주세요: ");
					String updateCoVNumber = scan.nextLine();
					String regex = "^\\d{2}[허|하|호]\\d{4}/*$";
					Pattern p = Pattern.compile(regex);
					Matcher m = p.matcher(updateCoVNumber);
					if(m.matches()){
						isUpdateCovehicle = true;
					}else{	
						System.out.println(" 잘못 입력 하셨습니다.");
					}
					codao.updateCoVehileNumber(select - 1, updateCoVNumber);
					System.out.println(" 변경을 완료하였습니다!!");
					break;
				case 2:
					System.out.println("시리즈와 차종을 수정해주세요.");
					VehicleService vs = new VehicleService();
					VehicleSeriesVo vo = vs.gettingSeries();
					VehicleNameVo cvnvo = vs.gettingVName(vo.getIndex());
					System.out.println(" 시리즈 : " + vo.getvSeries() +" "+ "차종 : " + cvnvo.getvName());
					String updateVseries = vo.getvSeries();
					String updateVname = cvnvo.getvName();
					codao.updateCoVehile(select - 1, updateVseries, updateVname);
					System.out.println(" 변경을 완료하였습니다!!");
					break;
				case 3:
					System.out.print(" 금액을 수정해주세요: ");
					int updateRentPrice = Integer.parseInt(scan.nextLine());
					codao.updateCoVehilePrice(select - 1, updateRentPrice);
					System.out.println(" 변경을 완료하였습니다!!");
					break;
				default:
					break;
				}
			}else{
				System.out.println(" 정보가 존재하지 않습니다.");
				break;
			}
		}while(isUpdateCovehicle == false);
	}

	public void showReturnMenu() { //차량 반납 메뉴
	      ReviewDao rdo = new ReviewDao();
	      int select;
	      do{
	         System.out.println("〓〓〓〓〓   차량 반납 메뉴   〓〓〓〓〓");
	         System.out.println(" 1.차량 반납");
	         System.out.println(" 2.리뷰 쓰기");
	         System.out.println(" 3.리뷰 수정");
	         System.out.println(" 4.리뷰 삭제");
	         System.out.println(" 0.뒤로가기");
	         System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
	         
	         select = Integer.parseInt(scan.nextLine());
	         
	         switch(select){
	         case 0:
	            break;
	         case 1:
	            coVehicleReturn();
	            
	            break;
	         case 2:
	            rdo.makeReview(); break;
	         case 3:
	            updateReview(); break;
	         case 4:
	            deleteReview(); break;
	         default :
	            break;
	         }
	      }while(select != 0);
	   }
	
	public void coVehicleReturn() { //차량 반납
		UserDao udao = new UserDao();
		boolean isreturn = false;
		
		do {
			ArrayList<UserRentVo> rentedList = udao.userRentList(session.loginUserId);
			ArrayList<Integer> removeIndex  = new ArrayList<>();
			for(int i = 0; i<rentedList.size(); i++) {
				
				if(rentedList.get(i).getActualReturnDate()!="") {
					removeIndex.add(i);
					
				}	
				
			}	
			for(int i = 0; i<removeIndex.size(); i++) {
				rentedList.remove(removeIndex.get(i)-i);
			}
			
			if(rentedList.size()!=0){
				for(int i = 0; i<rentedList.size();i++){
					
						System.out.println(i+1 + ". " + rentedList.get(i).getvName() + "  |  " + rentedList.get(i).getRentVNum());
						
				
				}
					
				System.out.println("반납하실 차량 번호를 눌러주십시요");
				int choice = Integer.parseInt(scan.nextLine());
				UserRentVo urvo = rentedList.get(choice-1);
				System.out.println("〓〓〓〓〓〓   차량 상세 내역   〓〓〓〓〓〓");
				udao.rentVehicleInfo(urvo.getUserId(),urvo.getRentVNum());
				ArrayList<CoVehicleVo> tempa = codao.getCoVehicleList();
				String coSerialNum = null;
				for(int i = 0; i<tempa.size(); i++){
					if(tempa.get(i).getCoVNumber().equals(urvo.getRentVNum())){
						coSerialNum = tempa.get(i).getCoSerialNum();
						break;
					}
				}
				udao.rentCompInfo(coSerialNum);
				System.out.println();
				udao.durationInfo(urvo);
				String rentDate = urvo.getRentDate();
				String rentTime = urvo.getRentTime();
				String returnDate = urvo.getReturnDate();
				String returnTime = urvo.getReturnTime();
				long rentTerm = chekRentTerm(rentDate,rentTime,returnDate,returnTime);
				int price = (int)(urvo.getRentPrice()/rentTerm);
				//사용기간을 시간화 한것
				
				//오늘기준으로 지난 시간 확인
				long overTime = checkOverTime(returnDate,returnTime);
				// chkOverPrice();
				if(overTime != 0){
					//이건 대여금액
//					long overPay = (overPrice/24)*rentTerm;
//					//이건 총금액
//					long overPay = (overPrice/24)*rentTerm + (overPrice/24)*overTime;
					//이건 추가금액
					long overPay = price*overTime;
					System.out.println("추가요금이 존재합니다.");
					System.out.println("추가 시간은 총 " + overTime + " 입니다.");
					System.out.println("추가 요금은 "+overPay + "원 입니다.");
					System.out.println("결제를 진행하시겠습니까?");
					System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓");
					System.out.println("1.예");
					System.out.println("2.아니오");
					System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓");
					int selectNum = Integer.parseInt(scan.nextLine());
					switch (selectNum) {
					case 1:
						System.out.println("결제 창으로 넘어갑니다.");
						PayService psv = new PayService();
						Date date = new Date();
						SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd",Locale.KOREA);
						SimpleDateFormat format2 = new SimpleDateFormat("HH:mm",Locale.KOREA);
						
						String actualReturnDate = format.format(date);
						String actualReturnTime = format2.format(date);
						
						System.out.println("format : " + actualReturnTime);
						urvo.setActualReturnDate(actualReturnDate);
						urvo.setActualReturnTime(actualReturnTime);
						psv.paymentOverPrice(urvo,overPay);
						isreturn = true;
						break;
					case 2:
						System.out.println("상위 메뉴로 돌아갑니다.");
						isreturn = true;
						break;
					default:
						break;
					}
				}else{
					System.out.println("반납되었습니다.");
					SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd",Locale.KOREA);
					SimpleDateFormat format2 = new SimpleDateFormat("HH:mm",Locale.KOREA);
					Date date = new Date();
					String actualReturnDate = format.format(date);
					String actualReturnTime = format2.format(date);
					urvo.setActualReturnDate(actualReturnDate);
					urvo.setActualReturnTime(actualReturnTime);
					udao.setUserAcutalRentVo(urvo);
					//actualDate,actualTime 인풋 
					isreturn = true;
					break;
					
				}
			} else {
				System.out.println();
				System.out.println("반납할 차량이 없습니다.");
				System.out.println("상위 메뉴로 돌아갑니다.");
				System.out.println();
				isreturn = true;
				break;
			}
		} while (isreturn == false);
		
		
	}


	private long chekRentTerm(String rentDate, String rentTime,String returnDate,String returnTime) {
		String myRent = rentDate + " " + rentTime;
		String myReturn = returnDate + " " + returnTime;
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd HH:mm",Locale.KOREA);
		Date rentT = new Date();
		Date returnT = new Date();
		
		try {
			rentT = format.parse(myRent);
			returnT = format.parse(myReturn);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long term = (returnT.getTime()-rentT.getTime())/(60*60*1000);
		return term;
	}


	private long checkOverTime(String returnDate,String returnTime) {
		String myReturn = returnDate + " " + returnTime;
		Date today = new Date();
		Date returnD = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd HH:mm",Locale.KOREA);
		try {
			returnD = format.parse(myReturn);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(today.getTime()>= returnD.getTime()){
			//추가요금 발생
			long overCash = (today.getTime()-returnD.getTime())/(60*60*1000);
			return overCash;
		}else{
			return 0;
		}
	
	}
	 public void updateReview(){ //리뷰 수정
	      boolean isupdate = false;
	      SimpleDateFormat sdft = new SimpleDateFormat("yy/MM/dd/HH:MM");
	      ReviewDao rdo = new ReviewDao();
	      int comSelect = 0;
	      do{
	         if(db.reviewList.size() != 0){
	            isupdate = true;
	            System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
	            for(int i = 0; i < db.reviewList.size(); i++){
	               System.out.print(i + 1 + "." + db.reviewList.get(i).getCoName());
	               System.out.println("\t" + db.reviewList.get(i).getUserId());
	               System.out.print("\t" + sdft.format(db.reviewList.get(i).getReviewDate()));
	               System.out.print("\t" + db.reviewList.get(i).getReviewContent());
	               System.out.println();
	            }
	            
	            System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
	            System.out.println("수정하고자 하는 리뷰를 선택해주세요.");            
	            int select = Integer.parseInt(scan.nextLine());
	            comSelect = select;            
	            if(select <= db.reviewList.size()){
	               System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
	               System.out.println(db.reviewList.get(select - 1).getCoName() + " 리뷰를 선택하셨습니다. \n 수정하시겠습니까?");
	            }
	            System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
	            System.out.println("1. 예");
	            System.out.println("2. 아니오(뒤로가기)");
	            System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
	            
	            select = Integer.parseInt(scan.nextLine());
	            
	            switch(select){
	            case 1:
	            if(session.loginUserId.equals(db.reviewList.get(comSelect-1).getUserId())){
	               System.out.print("내용을 수정해주세요: ");
	               String updateContent = scan.nextLine();
	               rdo.updateReview(comSelect - 1, updateContent);
	               System.out.println("변경을 완료하였습니다!!");
	               break;
	            }else{
	               System.out.println("회원님이 등록한 리뷰가 아니므로 변경할 수 없습니다!\n");
	               break;
	            }
	            case 2:
	               break;
	            }
	         }else{
	            System.out.println("수정할 리뷰가 없습니다.");
	            break;
	         }
	      }while(isupdate == false);
	   }
	   
   public void deleteReview(){
     UserSession session = new UserSession();
      boolean isdelete = false;
      SimpleDateFormat sdft = new SimpleDateFormat("yy/MM/dd/HH:MM");
      ReviewDao rdo = new ReviewDao();
      int comSelect = 0;
      do{
         if(db.reviewList.size() != 0){
            isdelete = true;
            System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
            for(int i = 0; i < db.reviewList.size(); i++){
               System.out.print(i + 1 + "." + db.reviewList.get(i).getCoName());
               System.out.println("\t" + db.reviewList.get(i).getUserId());
               System.out.print("\t" + sdft.format(db.reviewList.get(i).getReviewDate()));
               System.out.print("\t" + db.reviewList.get(i).getReviewContent());
               System.out.println();
            }
            System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
            System.out.println("삭제하고자 하는 리뷰를 선택해주세요.");
            int select = Integer.parseInt(scan.nextLine());
            comSelect = select;
            if(select <= db.reviewList.size()){
               System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
               System.out.println(db.reviewList.get(select - 1).getCoName() + " 리뷰를 선택하셨습니다. \n 삭제하시겠습니까?");
            }
            System.out.println("-〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
            System.out.println("1. 예");
            System.out.println("2. 아니오(뒤로가기)");
            System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
            
            select = Integer.parseInt(scan.nextLine());
            
            switch(select){
            case 1:
               if(session.loginUserId.equals(db.reviewList.get(comSelect-1).getUserId())){
               rdo.deleteReview(comSelect - 1);
               System.out.println("삭제되었습니다!!");
               break;
               }else{
                  System.out.println("회원님이 등록한 리뷰가 아니므로 삭제할 수 없습니다!\n");
                  break;
               }
            case 2:
               break;
            }
         }else{
            System.out.println("삭제할 리뷰가 없습니다.");
            break;
         }
      }while(isdelete == false);
   }

   public void showReservations() {
	   ArrayList<UserRentVo> reserved = reservationCars(session.loginUserId);
	   if(reserved.size() == 0) {
		   System.out.println("예약된 차량이 없습니다.");
		   System.out.println("메인화면으로 돌아갑니다.");
		   return;
	   }else {
		   System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
		   System.out.println("순번\t차량번호\t\t 대여일\t\t반납일");
		   System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
		   for(int i = 0; i<reserved.size(); i++) {
			   
			   System.out.println(" " + (i + 1) +"\t"+ reserved.get(i).getRentVNum() + "\t\t" + reserved.get(i).getRentDate() + "\t" + reserved.get(i).getReturnDate());
			 
			   
		   }
		   System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
		   System.out.println("뒤로 가시려면 아무키나 입력해 주세요.");
		   String str = scan.nextLine();
		   return;
	   }
   }
   
   public ArrayList<UserRentVo> reservationCars(String userId) {
	   CoVehicleDao cvdao = new CoVehicleDao();
	   UserDao udao = new UserDao();
	   String coSerialNum = cvdao.getCoSerialNum(userId);
	   UserRentVo vo;
	   ArrayList<CoVehicleVo> comVehicle =  cvdao.getCoVehicleList(coSerialNum);
	   ArrayList<UserRentVo> returnArray = new ArrayList<>();
	   for(int i = 0; i< comVehicle.size(); i++) {
		   boolean isPutIn = false;
		   int getJ = 0;
		   for(int j = 0; j < udao.allRentedList().size(); j++) {
			   if(comVehicle.get(i).getCoVNumber().equals(udao.allRentedList().get(j).getRentVNum())) {
				   //차량 번호와 렌트 리스트에 번호가 같다면 
				   if(udao.allRentedList().get(j).getActualReturnDate()=="" 
					  && checkOldDay(udao.allRentedList().get(j).getRentDate())== true) {
					   getJ = j;
					   isPutIn = true;
					   
					   break;
				   }
				   
				   
			   }
			   
			   
		   }
		   if(isPutIn == true) {
			   //input 
			   vo = new UserRentVo();
				vo.setActualReturnDate(udao.allRentedList().get(getJ).getActualReturnDate());
				vo.setActualReturnTime(udao.allRentedList().get(getJ).getActualReturnTime());
				vo.setRentDate(udao.allRentedList().get(getJ).getRentDate());
				vo.setRentNum(udao.allRentedList().get(getJ).getRentNum());
				vo.setRentPrice(udao.allRentedList().get(getJ).getRentPrice());
				vo.setRentTime(udao.allRentedList().get(getJ).getRentTime());
				vo.setRentVNum(udao.allRentedList().get(getJ).getRentVNum());
				vo.setReturnDate(udao.allRentedList().get(getJ).getReturnDate());
				vo.setReturnTime(udao.allRentedList().get(getJ).getReturnTime());
				vo.setUserId(udao.allRentedList().get(getJ).getUserId());
				vo.setvName(udao.allRentedList().get(getJ).getvName());
				vo.setvSeries(udao.allRentedList().get(getJ).getvSeries());
				returnArray.add(vo);
				
			   
		   }
	   }
	   return returnArray;
	   
   }
   public boolean checkOldDay(String str){
	   boolean isTrue = false;
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd",Locale.KOREA);
		Date rentDate = null;
		try {
			
			rentDate = sdf.parse(str);
			date = sdf.parse(sdf.format(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(rentDate.getTime()>=date.getTime()) {
			isTrue = true;
		}
		
		return isTrue;
	}


}

