package controller;


import java.util.Scanner;

import service.Cart;
import service.IntegerCheck;
import service.Menu;
import service.Mileage;
import service.Notice;
import service.Payment;
import service.RMenuService;
import service.Table;


public class UserController {
	
	
	private static UserController instance;

	private UserController() {
	}

	public static UserController getInstance() {
		if (instance == null) {
			instance = new UserController();
		}
		return instance;

	}
	public static boolean login_state = true;
	
	static Scanner s = new Scanner(System.in);
	public static void select(){//로그인 후 화면
		
		int select ;
		boolean check = false;
		String temp;
		
		do{
			login_state=true;
			System.out.println("---------------------------------------------------");
			System.out.println("Young갬성 202호 뽀짝끝판왕에 오신걸 환영합니다;D");
			System.out.println("취객환영! 만취환영!");
			System.out.println("---------------------------------------------------");
			System.out.println("1. 게임선택 ");
			System.out.println("2. 주문하기 ");
			System.out.println("3. 추천메뉴 확인하기 ");
			System.out.println("4. 주문내역 확인 /수정 및 결제"); 
			System.out.println("5. 공지사항 ");
			System.out.println("6. 마일리지 내역"); 
			System.out.println("7. 로그아웃"); 
			System.out.println("---------------------------------------------------");
			System.out.println("입력해주세요! > ");
			
			temp = s.nextLine().trim();
			check = IntegerCheck.checkInt(temp);
			
		}while(!check);
		
		select= Integer.parseInt(temp);
		
		switch (select) {
		case 1 : //게임선택
			GameController.Game();
			break;
		case 2 : //주문하기
			Menu.selectMenu();
			break;
		case 3 : //추천메뉴 확인하기
			RMenuService.userManagement();
			break;
		case 4 : //장바구니
			Payment.paymentManagement();
			break;
		case 5 : //공지사항 보기
			Notice.noticeUser();
			break;
		case 6 : //마일리지내역
			Mileage.printMileageInfo();
			break;
		
		case 7 : //로그아웃
			if(Cart.paymentstate()){
				Table.tableOut();
				System.out.println("로그아웃 되셨습니다.");
				
				login_state = false;
			}else{
				System.out.println("계산하기 전입니다.");
			}
			break; 

		default :
			System.out.println("잘못된 입력입니다.");
		}
		
		
	}
}
