package controller;




import java.util.Scanner;






import service.Category;
import service.IntegerCheck;
import service.Menu;
import service.Notice;
import service.Payment;
import service.RMenuService;
import service.Table;
import service.UserService;
import data.Session;

public class AdminController {

	private static AdminController instance;

	private AdminController() {
	}

	public static AdminController getInstance() {
		if (instance == null) {
			instance = new AdminController();
		}
		return instance;

	}

	
	
    
	public static boolean login_state = true;
	static Scanner s = new Scanner(System.in);
	public static void select() {// 로그인 후 화면

	do{
		int select;
		boolean check = false;
		String temp = "";
	
		do {
			System.out.println("---------------------------------------------------");
			System.out.println("관리자 페이지");
			System.out.println("---------------------------------------------------");
			System.out.println("1. 카테고리 관리 ");
			System.out.println("2. 메뉴 관리 ");
			System.out.println("3. 추천메뉴 관리");
			System.out.println("4. 공지사항 관리");
			System.out.println("5. 매출리스트");
			System.out.println("6. 회원관리");
			System.out.println("7. 테이블관리");
			System.out.println("0. 종료");
			System.out.println("---------------------------------------------------");
			System.out.println("입력해주세요! > ");
			
			temp = s.nextLine().trim();
			check = IntegerCheck.checkInt(temp);

		} while (!check);

		select = Integer.parseInt(temp);

		switch (select) {
		case 1: // 카테고리관리
			Category.categoryManagement();
			break;
		case 2: // 메뉴관리
			Menu.menuManagement();
			break;
		case 3: // 추천메뉴 관리
			RMenuService.adminManagement();
			break;
		case 4: // 공지사항관리
			Notice.NoticeModify();
			break;
		case 5:// 매출리스트
			Payment.saleListManegement();
			break;
		case 6:// 유저관리
			UserService.userManagement();
			break;
		case 7 : // 테이블관리
		    Table.tablecotrol();
		    break;
		case 0: // 로그아웃
			Session.loginUser = null;
			login_state = false;
			System.out.println("로그아웃 되셨습니다.");
			break;
		default:
			System.out.println("해당메뉴는 없습니다.");
			break;

		}
	}while(login_state);
	}






}
