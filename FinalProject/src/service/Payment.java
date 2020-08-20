package service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import vo.MileageVo;
import vo.PaymentVo;
import dao.CartDao;
import dao.FoodDao;
import dao.MileageDao;
import dao.PaymentDao;
import data.Session;

public class Payment {
	static int sum = 0;//합계를 저장하고있는  
	static Scanner s = new Scanner(System.in);
	public static void paymentManagement() {
		
		CartDao cartDao = CartDao.getInstance();
		if(cartDao.selectCartList().isEmpty()){
			System.out.println("-----------------------------------");
			System.out.println("주문내역이 없습니다.");
			System.out.println("-----------------------------------");
			return;
		
		}
			
		
		boolean check = false;
		String temp = "";
		do{
			do {
				sum = Cart.printCart();// 결제해야할 내역을 보여준다.
				System.out.println("--------------------------------------------");
				System.out.println("주문 내역 결제 및 추가삭제 선택");
				System.out.println("1. 주문내역 수정 및 취소");
				System.out.println("2. 결제하기");
				System.out.println("0. 이전 메뉴로 이동");
				System.out.println("--------------------------------------------");
				temp = s.nextLine().trim();
				check = IntegerCheck.checkInt(temp, 0, 2);
			} while (!check);
			int menu = Integer.parseInt(temp);
			
			switch(menu){
			case 1 : 
				Cart.orderModify();
				break;
			case 2 : 
				payment();
				check = false;
				break;
			case 0 :
				System.out.println("이전 메뉴로 돌아갑니다.");
				check = false;
			}
		}while(check);
		
		
	}
	public static ArrayList<Integer> useMileage() {
		ArrayList<Integer> output = new ArrayList<>();
		
		MileageDao mileageDao = MileageDao.getInstance();
		// 유저데이터에서 마일리지를 가져오고
		// 총결제금액에서 10%까지만 마일리지로 계산

		int mileage = mileageDao.searchUserMileageSum(Session.loginUser.getId()); // 로그인 된 유저가 가지고 있는 마일리지

		// 로그인된 유저가 가지고 있는 마일리지(mileage)로 합계(sum)에서 10%만 계산 할 수 있게 만들거야
		int percent = (int) (sum * 0.1); // percent는 합계의 10%
		int mileage_payment = percent - mileage; // 마일리지 계산 = 합계의 10% - 사용자 마일리지
													// //이거 자체가 마일리지로 10%만 계산 할
													// 수 있게 만들어 놓은거

		boolean check = false;
		String temp = "";

		if (mileage_payment > 0) {
			do {
				System.out.println("------------------------------------------------------");
				System.out.println("총 금액의 10%까지만 마일리지를 사용할 수 있습니다. 마일리지를 사용하시겠습니까 ?");
				System.out.println("결제 가능한 마일리지 : " + percent);
				System.out.println("사용가능한 마일리지 : " + mileage);
				System.out.println("1. 예.");
				System.out.println("2. 아니요.");
				System.out.println("------------------------------------------------------");
				temp = s.nextLine();
				check = IntegerCheck.checkInt(temp, 1, 2);
			} while (!check);
			int input = Integer.parseInt(temp);
			switch (input) {
			case 1:
			    do{
			    System.out.println("------------------------------------------------------");
				System.out.println("마일리지 얼마를 사용하시겠습니까? ");
				System.out.println("------------------------------------------------------");
				temp = s.nextLine();
				check = IntegerCheck.checkInt(temp,1,mileage);
				}while(!check);
				input = Integer.parseInt(temp);
				System.out.println("------------------------------------------------------");
				System.out.println(input+"의 마일리지를 사용하셨습니다.");
				System.out.println("------------------------------------------------------");
				output.add(input);
				output.add(sum - input);
				break;
			case 2:
				output.add(0);
				output.add(sum);
				break;
			}
		} else if (mileage_payment < 0) {
			do {
				System.out.println("------------------------------------------------------");
				System.out.println("마일리지를 사용하시겠습니까 ?");
				System.out.println("결제 가능한 마일리지 : " + percent);
				System.out.println("사용가능한 마일리지 : " + percent);
				System.out.println("1. 예.");
				System.out.println("2. 아니요.");
				System.out.println("------------------------------------------------------");
				temp = s.nextLine();
				check = IntegerCheck.checkInt(temp, 1, percent);
			} while (!check);
			int input = Integer.parseInt(temp);
			switch (input) {
			case 1:
				do{
				System.out.println("------------------------------------------------------");
				System.out.println("마일리지 얼마를 사용하시겠습니까? ");
				System.out.println("------------------------------------------------------");
				temp = s.nextLine();
				check = IntegerCheck.checkInt(temp,percent);
				}while(!check);
				input = Integer.parseInt(temp);
				System.out.println("------------------------------------------------------");
				System.out.println(input+"의 마일리지를 사용하셨습니다.");
				System.out.println("------------------------------------------------------");
				output.add(input);
				output.add(sum - input);
				break;
			case 2:
				output.add(0);
				output.add(sum);
				break;
			}
		}
		return output;
	}
	public static void payment(){
		PaymentDao paymentDao = PaymentDao.getInstance();
		if(paymentDao.notPaymentList().size()!=0){
		PaymentVo paymentvo = new PaymentVo();
		MileageDao mileageDao = MileageDao.getInstance();
	
		
		int mileage = mileageDao.searchUserMileageSum(Session.loginUser.getId());
		boolean check = false;
		String temp = "";
		
		do {System.out.println("--------------------------------------------");
				System.out.println("결제하실 금액은 " + sum + "원 입니다.");
				System.out.println("결제하실 방법을 선택해주세요.");
				System.out.println("1. 카드");
				System.out.println("2. 현금");
				System.out.println("--------------------------------------------");
				temp = s.nextLine().trim();
				check = IntegerCheck.checkInt(temp, 1, 2);
				
			} while (!check);

			int input = Integer.parseInt(temp);
			String card = "";

			Pattern p;
			Matcher m;
			
			ArrayList<Integer> mileageOutput = new ArrayList<>();
			switch (input) {
			case 1 : // 카드로 결제할때
				do {
					System.out.println("--------------------------------------------");
					System.out.println("가진 마일리지가" + mileage+ "원 있습니다. 마일리지를 사용하시겠습니까 ?");
					System.out.println("1. 예");
					System.out.println("2. 아니오.");
					System.out.println("--------------------------------------------");
					temp = s.nextLine().trim();
					check = IntegerCheck.checkInt(temp, 1, 2);
				} while (!check);

				input = Integer.parseInt(temp);

				switch (input) {
				case 1:
					mileageOutput = useMileage();
					break;
				case 2:
					mileageOutput.add(0);
					mileageOutput.add(sum);
					break;
				}

				do {
					System.out.println("------------------------------------------------------");
					System.out.println("결제하실 금액 : "+ mileageOutput.get(1));
					System.out.println("예) 1234-1234-1234-1341");
					System.out.println("카드번호를 입력해 주세요 ");
					System.out.println("종료하고싶으면 0번을 입력해주세요");
					System.out.println("------------------------------------------------------");
					card = s.nextLine();
					check = true;
					for (int i = 0; i < card.length(); i++) {
						if (card.charAt(i) < '0' && card.charAt(i) > '9') {
							check = false;
							break;
						}
					}
					if (check && card.length() == 1) {
						if (Integer.parseInt(card) == 0) {
							System.out.println("------------------------------------------------------");
							System.out.println("메뉴로 돌아갑니다.");
							System.out.println("------------------------------------------------------");
							return;
						}
					}

					String cardNum = "[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{4}";
					p = Pattern.compile(cardNum);
					m = p.matcher(card);
					if (!m.matches()) {
						System.out.println("------------------------------------------------------");
						System.out.println("형식과 다릅니다.");
						System.out.println("------------------------------------------------------");
					}

				} while (!m.matches());

				System.out.println("------------------------------------------------------");
				System.out.println("결제가 완료되었습니다.");
				System.out.println("------------------------------------------------------");
				if (mileageOutput.get(0) != 0) {
					MileageVo mileageVo = new MileageVo();
					mileageVo.setContents("마일리지사용(결제)");
					mileageVo.setDate(new Date());
					mileageVo.setId(Session.loginUser.getId());
					mileageVo.setMiliage(-mileageOutput.get(0));
					mileageDao.insertMileage(mileageVo);
				}
				
				MileageVo mileageVo = new MileageVo();
				mileageVo.setContents("마일리지 적립");
				mileageVo.setDate(new Date());
				mileageVo.setId(Session.loginUser.getId());
				mileageVo.setMiliage(mileageOutput.get(1)/100);
				mileageDao.insertMileage(mileageVo);
				
				paymentvo = new PaymentVo();
				paymentvo.setDate(new Date()); // 결제한 날짜
				paymentvo.setMilieage(mileageOutput.get(0)); // 마일리지 유저데이터에서
																// 가져와서 처리한 값 =>
																// 을 넣어주기
				paymentvo.setRequests("카드결제");// 현금결제인지 카드결제인지
				paymentDao.insertPayment(paymentvo);
				break;

			case 2: // 금액
				do{
					System.out.println("------------------------------------------------------");
					System.out.println("가진 마일리지가" + mileage + "원 있습니다. 마일리지를 사용하시겠습니까 ?");
					System.out.println("1. 예");
					System.out.println("2. 아니오.");
					System.out.println("------------------------------------------------------");
					temp = s.nextLine().trim();
					check = IntegerCheck.checkInt(temp,1,2);
				} while (!check);
				
				int menu = Integer.parseInt(temp);
				
				switch (menu) {
				case 1:
					mileageOutput = useMileage();
					break;
				case 2:
					mileageOutput.add(0);
					mileageOutput.add(sum);
					break;
				}
				
				
				do{
					System.out.println("------------------------------------------------------");
					System.out.println("결제하실 금액은 "+ mileageOutput.get(1) +"원 입니다.");
					System.out.println("내실 돈을 입력 해 주세요");
					System.out.println("------------------------------------------------------");
					temp = s.nextLine().trim();
					check = IntegerCheck.checkInt(temp);
					
				} while (!check);

				input = Integer.parseInt(temp);

				int change;
				change = input - mileageOutput.get(1);
				if (change > 0) {
					System.out.println("------------------------------------------------------");
					System.out.println(input + "원 내셨습니다. 거스름돈은 " + change + "원 입니다.");
					System.out.println("------------------------------------------------------");
				
				
				}  else if (change <= 0) {
					while (-change > 0) {
						System.out.println("------------------------------------------------------");
						System.out.println("지불하신 돈이 모자랍니다요 ~ " + -change+ "원 추가 결제를 해주세요");
						System.out.println("------------------------------------------------------");
						input = Integer.parseInt(s.nextLine());
						change = change + input;
					}
							System.out.println("------------------------------------------------------");
							if(change != 0){
								System.out.println("거스름돈은 "+(-change)+"원 입니다.");
							}
							System.out.println("결제가 완료 되셨습니다.");
							System.out.println("------------------------------------------------------");		
					}
				if(mileageOutput.get(0) != 0){
					mileageVo = new MileageVo();
					mileageVo.setContents("마일리지사용(결제)");
					mileageVo.setDate(new Date());
					mileageVo.setId(Session.loginUser.getId());
					mileageVo.setMiliage(-mileageOutput.get(0));
					mileageDao.insertMileage(mileageVo);
				}
				
				mileageVo = new MileageVo();
				mileageVo.setContents("마일리지 적립");
				mileageVo.setDate(new Date());
				mileageVo.setId(Session.loginUser.getId());
				mileageVo.setMiliage(mileageOutput.get(1)/100);
				mileageDao.insertMileage(mileageVo);
				
				paymentvo = new PaymentVo();
				paymentvo.setDate(new Date());
				paymentvo.setRequests("현금결제");
				paymentDao.insertPayment(paymentvo);
			}
		}else{
			System.out.println("--------------------------------------------");
			System.out.println("결제하실 내역이 없습니다.");
			System.out.println("--------------------------------------------");
		}
		
	}
	public static void selectSalesList(){		
		PaymentDao paymentdao = PaymentDao.getInstance();
		ArrayList<PaymentVo> paymentList =  paymentdao.selectPaymentList();
		CartDao cartDao = CartDao.getInstance();

		FoodDao foodDao = FoodDao.getInstance();

		Calendar cal = Calendar.getInstance();
		
		int year = 0;
		int month = 0;
		int day = 0;
		String temp = "";
		
		boolean check=false;
		Date date = null;
		
		do{
			System.out.println("----------------------------------------------");
			temp = UserService.formCheck("예)2020\n년도를 입력해주세요.","(19|20)\\d{2}");
			if(!temp.equals("")){
				check = true;
			}
		}while(!check);
		year = Integer.parseInt(temp);
		do {
			check = false;
			System.out.println("----------------------------------------------");
			temp = UserService.formCheck("예)08\n월을 입력해주세요", "(0[1-9]|1[012])");
			
			if (Integer.parseInt(temp) <= 12 && Integer.parseInt(temp) >= 0) {
				check = true;
			} else {
				System.out.println("01~12 사이로 입력해주세요.");
			}
		} while (!check);
		month = Integer.parseInt(temp);
			
			cal.set(year,month-1, 1);
		
			do {
				check = false;
				System.out.println("----------------------------------------------");
				temp = UserService.formCheck("예)12\n일을 입력해주세요.","(0[1-9]|[12][0-9]|3[01])");
				
				if (Integer.parseInt(temp) <= cal.getActualMaximum(Calendar.DAY_OF_MONTH) && Integer.parseInt(temp) >= 1) {
					check = true;
				}else{
					System.out.println(month+"월 에는  "+Integer.parseInt(temp)+"가 존재하지 않습니다.");
					System.out.println("1 ~ "+ cal.getActualMaximum(Calendar.DAY_OF_MONTH)+" 사이로 입력해주세요" );
				}			
			} while (!check);
			day = Integer.parseInt(temp);
			
			cal.set(year,month-1, day,00,00,00);
			cal.set(Calendar.MILLISECOND, 0);
			date = cal.getTime();
		
			
		int total = 0;
		int mileageTotal = 0;
		SimpleDateFormat format = new SimpleDateFormat ( "yyyy/MM/dd");
		String paymnet_date = format.format(date);
		System.out.println("-------------------------------------------------------------------");
		System.out.println("결제날짜 : "+paymnet_date);
		System.out.println("결제번호\t\t결제방법\t\t금액\t\t사용마일리지");
		System.out.println("-------------------------------------------------------------------");
		for(int i = 0 ; i<paymentList.size();i++){
			SimpleDateFormat year_format = new SimpleDateFormat ( "yyyy");
			SimpleDateFormat month_format = new SimpleDateFormat ( "MM");
			SimpleDateFormat day_format = new SimpleDateFormat ( "dd");
			String paymnet_year = year_format.format(paymentList.get(i).getDate());
			String paymnet_month = month_format.format(paymentList.get(i).getDate());
			String paymnet_day = day_format.format(paymentList.get(i).getDate());
			
			temp = paymnet_year+paymnet_month+paymnet_day;
			Date payment_date = null;
			
			try {
				payment_date = new SimpleDateFormat("yyyyMMdd").parse(temp);
			} catch (ParseException e) {
				System.out.println("날짜형으로 변환을 실패하셨습니다.");
			}
			
			

			if(payment_date.compareTo(date)==0){
				int sum = 0;
				System.out.print(paymentList.get(i).getPaymentNo()+"\t\t"+paymentList.get(i).getRequests());
				for(int  j = 0 ; j < cartDao.selectPaymentNoCartList(paymentList.get(i).getPaymentNo()).size();j++){
					sum += foodDao.searchFoodNoInfo(cartDao.selectPaymentNoCartList(paymentList.get(i).getPaymentNo()).get(j).getFoodNo()).getPrice()*
							cartDao.selectPaymentNoCartList(paymentList.get(i).getPaymentNo()).get(j).getCount();
				}
				System.out.print("\t\t"+sum);
				System.out.println("\t\t"+paymentList.get(i).getMilieage());
				total+=sum;
				mileageTotal +=paymentList.get(i).getMilieage();
			}
		}
		System.out.println("사용된 마일리지 : "+mileageTotal + "원 ");
		System.out.println("매출액 : "+total + "원 ");
		System.out.println("사용된 마일리지를 제외한 매출액 : "+(total-mileageTotal) + "원 ");
		
	}
	public static void monthSalesList(){		
		PaymentDao paymentdao = PaymentDao.getInstance();
		ArrayList<PaymentVo> paymentList =  paymentdao.selectPaymentList();
		CartDao cartDao = CartDao.getInstance();
		FoodDao foodDao = FoodDao.getInstance();
		Calendar cal = Calendar.getInstance();
		String temp = "";
		boolean check = false;
		
		int max = 12;
		do{
			System.out.println("----------------------------------------------");
			System.out.println("월매출을 보고싶은 년도를 입력해주세요.");
			temp = UserService.formCheck("예)2020\n년도를 입력해주세요.","(19|20)\\d{2}");
			if(!temp.equals("")){
				check = true;
			}
		}while(!check);
		
		int year = Integer.parseInt(temp);

		System.out.println("--------------------------------------------------------------");
		System.out.println("월\t매출액\t\t사용마일리지\t사용 마일리지를 제외한 매출액");
		System.out.println("--------------------------------------------------------------");
			for(int i = 0 ; i < max ; i++)
			{
				cal.set(year,i,1,00,00,00);
				cal.set(Calendar.MILLISECOND, 0);
				
				int total = 0;
				int mileageTotal = 0;
				for(int j = 0 ; j<paymentList.size();j++){
					SimpleDateFormat year_format = new SimpleDateFormat ( "yyyy");
					SimpleDateFormat month_format = new SimpleDateFormat ( "MM");
					String paymnet_year = year_format.format(paymentList.get(j).getDate());
					String paymnet_month = month_format.format(paymentList.get(j).getDate());
					temp = paymnet_year+paymnet_month;
					Date payment_date = null;
					
					try {
						payment_date = new SimpleDateFormat("yyyyMM").parse(temp);
					} catch (ParseException e) {
						System.out.println("날짜형으로 변환을 실패하셨습니다.");
					}
					
					if(payment_date.compareTo(cal.getTime())==0){
						int sum = 0;			
						for(int  k = 0 ; k < cartDao.selectPaymentNoCartList(paymentList.get(j).getPaymentNo()).size();k++){
							int paymentNo = paymentList.get(j).getPaymentNo();
							int foodNo = cartDao.selectPaymentNoCartList(paymentNo).get(k).getFoodNo();
							
							sum += foodDao.searchFoodNoInfo(foodNo).getPrice()*
									cartDao.selectPaymentNoCartList(paymentNo).get(k).getCount();
						}
						total+=sum;
						mileageTotal += paymentList.get(j).getMilieage();
					}
				}
				System.out.println(i+1+"월\t"+total+"원\t\t"+mileageTotal+"원\t\t"+(total-mileageTotal)+"원");
			
			}
	}
	public static void saleListManegement(){
		
		boolean check = false;
		String temp = "";
		do {
			do {
				System.out.println("--------------------------------------------");
				System.out.println("매출내역출력 메뉴");
				System.out.println("1. 월별 매출내역 출력");
				System.out.println("2. 날짜 입력하여 매출내역 출력");
				System.out.println("3. 결제번호로 결제관련 내역 출력");
				System.out.println("0. 이전 메뉴로 이동");
				System.out.println("--------------------------------------------");
				temp = s.nextLine().trim();
				check = IntegerCheck.checkInt(temp, 0, 3);
			} while (!check);
			int menu = Integer.parseInt(temp);

			switch (menu) {
			case 1:
				monthSalesList();
				break;
			case 2:
				selectSalesList();
				break;
			case 3:
				searchPaymentNoList();
				break;
			case 0:
				System.out.println("이전 메뉴로 돌아갑니다.");
				check = false;
			}
		}while(check);
	}
	public static void searchPaymentNoList(){
		CartDao cartDao = CartDao.getInstance();
		PaymentDao paymentDao = PaymentDao.getInstance();
		FoodDao foodDao = FoodDao.getInstance();
		ArrayList<PaymentVo> paymentList = paymentDao.selectPaymentList();
	
		boolean check = true;
		String temp = "";
		int paymentNo = 0;
		
		do {
			do {
				check = true;
				System.out.println("----------------------------------------------");
				System.out.println("\t\t매출내역");
				System.out.println("----------------------------------------------");
				System.out.println("결제번호\t결제금액\t결제방법\t결제날짜");
				System.out.println("----------------------------------------------");
				for (int i = 0; i < paymentList.size(); i++) {
					SimpleDateFormat format = new SimpleDateFormat ( "yyyy/MM/dd");
					int sum = 0;
					for (int j = 0; j < cartDao.selectPaymentNoCartList(
							paymentList.get(i).getPaymentNo()).size(); j++) {
						sum += foodDao.searchFoodNoInfo(
								cartDao.selectPaymentNoCartList(
										paymentList.get(i).getPaymentNo())
										.get(j).getFoodNo()).getPrice()
								* cartDao
										.selectPaymentNoCartList(
												paymentList.get(i)
														.getPaymentNo()).get(j)
										.getCount();
					}
					String paymnet_date = format.format(paymentList.get(i).getDate());
				
					System.out.println(paymentList.get(i).getPaymentNo() + "\t"
							+ sum + "\t" + paymentList.get(i).getRequests()+"\t"+paymnet_date);
				}
				System.out.println("0 : 종료하기");
				System.out.println("----------------------------------------------");
				
				System.out.println("결제번호를 입력해주세요.");
				temp = s.nextLine().trim();
				check = IntegerCheck.checkInt(temp);
			
			} while (!check);
			
			if(temp.equals("0")){
				return;
			}
			
			paymentNo = Integer.parseInt(temp);
			check = false;
			for (int i = 0; i < paymentDao.selectPaymentList().size(); i++) {
				if (paymentDao.selectPaymentList().get(i).getPaymentNo() == paymentNo) {
					check = true;
					break;
				}
			}
			if(!check){
				System.out.println("---------------------------------------------");
				System.out.println("해당되는 결제 번호가 없습니다.");
				System.out.println("---------------------------------------------");				
			}
		}while(!check);
		
		
		int total = 0;
		
		
		System.out.println("---------------------------------------------");
		System.out.println("선택한 결제번호의 결제내역");
		System.out.println("음식명\t\t수량\t\t가격");
		System.out.println("---------------------------------------------");
		for(int i = 0; i < cartDao.selectPaymentNoCartList(paymentNo).size();i++){
			
			int foodNo = cartDao.selectPaymentNoCartList(paymentNo).get(i).getFoodNo();
			
			String name = foodDao.searchFoodNoInfo(foodNo).getName();
			String sub_temp = "";
			
			int condition = 10;
			check = false;
			
			if(name.length()>condition){
				sub_temp = name.substring(0,condition);
				name=name.substring(condition-1,name.length());			
				System.out.print(sub_temp+"\t"+cartDao.selectPaymentNoCartList(paymentNo).get(i).getCount());
				System.out.println("\t\t"+foodDao.searchFoodNoInfo(foodNo).getPrice()*cartDao.selectPaymentNoCartList(paymentNo).get(i).getCount());
			}else{
				check = true;
				if(name.length()>= 6){
					name=name+"\t";
				}else{
					name=name+"\t\t";
				}
				System.out.print(name+cartDao.selectPaymentNoCartList(paymentNo).get(i).getCount());
				System.out.println("\t\t"+foodDao.searchFoodNoInfo(foodNo).getPrice()*cartDao.selectPaymentNoCartList(paymentNo).get(i).getCount());
			}
			if(!check){
				do{
					if(name.length()>condition){
					sub_temp = name.substring(0,condition);
					name=name.substring(condition-1,name.length());	
					System.out.println(sub_temp);
					}else {
						System.out.println(name);
						check = true;
					}
				}while(!check);
			}
			
			total+=foodDao.searchFoodNoInfo(foodNo).getPrice()*cartDao.selectPaymentNoCartList(paymentNo).get(i).getCount();
		}	
		System.out.println("---------------------------------------------");
		System.out.println("사용된 마일리지 : "+paymentDao.searchPaymentNoInfo(paymentNo).getMilieage() + "원 ");
		System.out.println("매출액 : "+total + "원 ");
		System.out.println("사용된 마일리지를 제외한 매출액 : "+(total-paymentDao.searchPaymentNoInfo(paymentNo).getMilieage()) + "원 ");
		
		
		
		
		
		
	}
}
			

