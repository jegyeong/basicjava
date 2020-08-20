package service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import vo.CoVehicleVo;
import vo.UserRentVo;
import Session.UserSession;
import dao.CoVehicleDao;
import dao.UserDao;

public class PayService {
	UserSession session = new UserSession();
	UserDao udao = new UserDao();
	Scanner scan = new Scanner(System.in);
	public int paymentForRent(CoVehicleVo vo, String rentDate, String rentTime, String returnDate,
			String returnTime) {
		//결제 하는 부분
		// 완료 시에  userRentVo 에 정보를 저장
		
		startingThread();
		int finalPrice = 0;
		System.out.println(" 결제창입니다.");
		System.out.println(session.loginUserId + " 님이 선택하신 결제하실 총 금액은 " + vo.getRentPrice() + "원 입니다.");
		int mileage = selectUseMileage();
		if(mileage != 0){
			finalPrice = (int) (vo.getRentPrice() - mileage);
			System.out.println("마일리지를 사용하여 결제금액은 " +finalPrice+ "입니다.");
		}else{
			finalPrice = vo.getRentPrice();
		}
		System.out.println(" 결제 방법은 카드 결제입니다 진행하시겠습니까?");
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
		System.out.println(" 1. 결제하기");
		System.out.println(" 2. 취소하기");
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
		
		int select = Integer.parseInt(scan.nextLine());
		switch (select) {
		case 1:
			
			int payconfirm = gettingCardNum();
			if(payconfirm == 1){
				System.out.println("결제가 완료 되었습니다.");
				System.out.println("대여하신 차량은 자동차 대여내역에서 확인 가능합니다.");
				UserRentVo urvo = new UserRentVo();
				CoVehicleDao codao = new CoVehicleDao();
				codao.getCoVehicleList();
				Date date = new Date();
				SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd",Locale.KOREA);
				String today = format.format(date);
				urvo.setUserId(session.loginUserId);
				
				urvo.setRentDate(rentDate);
				urvo.setRentTime(rentTime);
				
				urvo.setReturnDate(returnDate);
				urvo.setReturnTime(returnTime);
				
				urvo.setActualReturnDate("");
				urvo.setActualReturnTime("");
				
				urvo.setvName(vo.getvName());
				urvo.setvSeries(vo.getvSeries());
				urvo.setRentVNum(vo.getCoVNumber());
				urvo.setRentPrice(vo.getRentPrice());
//				
				urvo.setRentNum(session.loginUserId + today + vo.getCoVNumber());
				udao.insertUserRentVo(urvo);
				startingThread();
				System.out.println(" 메인화면으로 이동합니다.");
				return 0;
			}
			
			break;
		case 2:
			
			break;
		default:
			break;
		}
		return 1;
		
		
		
	}
	UserService usv = new UserService();
	private int gettingCardNum() {
		boolean isCorrect;
		int done = 0;
		do{
		System.out.println("〓〓〓〓〓〓   카드 번호   〓〓〓〓〓〓");
		System.out.println("카드번호 16자리를 입력해 주세요. ex)1234 2222 3333 4444");
		System.out.println();
		String str = scan.nextLine();
		
		isCorrect = usv.chkPattern(str, 6);
		if(isCorrect == true){
			gettingCardYYMM();
			done = 1;
		}else{
			System.out.println("다시 입력해 주세요.");
			System.out.println();
			
		}
		}while(done == 0);
		return done;
	}
	private void gettingCardYYMM(){
		boolean isCorrect;
		do{
			System.out.println("〓〓〓〓〓〓   유효년월    〓〓〓〓〓〓");
			System.out.println("카드의 유효 기간을 입력해 주세요.ex) mm/yy");
			System.out.println();
			String str = scan.nextLine();
			isCorrect = usv.chkPattern(str, 7);
			if(isCorrect == true){
				gettingCVC();
				
			}else{
				System.out.println("다시 입력해 주세요.");
				System.out.println();
			}
			
		}while(isCorrect == false);
	}
	private void gettingCVC(){
		boolean isCorrect;
		do{
		System.out.println("〓〓〓〓〓〓   CVC번호   〓〓〓〓〓〓");
		System.out.println("카드뒷면의 CVC번호를 입력해 주세요. ");
		System.out.println();
		String str = scan.nextLine();
		isCorrect = usv.chkPattern(str, 8);
		if(isCorrect == true){
			System.out.println("결제처리중입니다.");
			startingThread();
		}else{
			System.out.println("다시 입력해 주세요.");
			System.out.println();
		}
		
	}while(isCorrect == false);
	}
	 private int selectUseMileage(){
		 
		 int mileage = 0;
		 int mileageInput = 0;
		 mileage = udao.getUserMileage(session.loginUserId);
		    System.out.println("마일리지가 존재합니다.");
		    System.out.println("마일리지를 사용하시겠습니까?");
		    System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓");
		    System.out.println("1.네 사용하겠습니다.");
		    System.out.println("2. 아니요 사용하지 않습니다.");
		    System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓");
		    int select = Integer.parseInt(scan.nextLine());
		             switch(select){
		             case 1:System.out.println("보유하신 마일리지는 총 " + mileage + "점 입니다.");
		             boolean isDone =false;
		             do{
		             System.out.println("사용하실 마일리지를 입력해 주세요");
		             mileageInput = Integer.parseInt(scan.nextLine());
		             if(mileageInput>0 && mileageInput<=mileage){
		            	System.out.println("마일리지를 사용합니다.");
		            	System.out.println("사용하실 마일리지는 " + mileageInput + "입니다.");
		            	mileage = mileage - mileageInput;
		            	udao.setUserMileage(session.loginUserId,mileage);
		            	isDone = true;
		             }else if(mileageInput == 0){
		            	 System.out.println("마일리지 사용을 취소합니다.");
		            	 isDone = true;
		             }else{
		            	 System.out.println("가지고 계신 마일리지 보다 큽니다.");
		             }
		             }while(isDone == false);
		             break;
		             case 2:
		             mileageInput = 0;
		             break;
		             
		             default :break;
		             }
		 	
		             return mileageInput;
		 }
	public void paymentOverPrice(UserRentVo urvo,long overPrice){
		startingThread();
		int finalPrice = 0;
		System.out.println("결제창입니다.");
		System.out.println(session.loginUserId  + " 님의 추가요금은 " + overPrice + "원 입니다.");
		int mileage = selectUseMileage();
		if(mileage != 0){
			finalPrice = (int) (overPrice - mileage);
			System.out.println("마일리지를 사용하여 결제금액은 " +finalPrice+ "입니다.");
		}else{
			finalPrice = (int) overPrice;
		}
		
		System.out.println("결제 방법은 카드 결제입니다 진행하시겠습니까?");
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
		System.out.println("1. 결제하기");
		System.out.println("2. 취소하기");
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");

		int select = Integer.parseInt(scan.nextLine());
		if(select == 1){
			int pay = gettingCardNum();
			if(pay == 1){
				System.out.println(overPrice +" 원 결제가 완료 되었습니다.");
				// 유저렌트vo 가져와서 actualReturn 추가하기 
				udao.setUserAcutalRentVo(urvo);
				System.out.println("상위화면으로 이동합니다");
				startingThread();
			}else{
				startingThread();
				System.out.println("오류가 발생했습니다. 메인화면으로 이동합니다.");
			}
		}else{
			startingThread();
			System.out.println("상위화면으로 이동합니다.");
		}
		
				
	}

	private void startingThread(){
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
