package service;

import java.util.ArrayList;
import java.util.Scanner;

import vo.BookVO;
import vo.OutBookVO;
import vo.UserVO;
import dao.BookDao;
import dao.OutBookDao;
import dao.UserDao;
import data.Session;

public class UserService {
	private static UserService instance;

	private UserService() {
	}

	public static UserService getInstance() {
		if (instance == null) {
			instance = new UserService();
		}
		return instance;
	}

	Scanner s = new Scanner(System.in);

	private UserDao userDao = UserDao.getInstance();

	// 로그인
	public void login() {
		// 아이디, 비밀번호를 입력
		System.out.print("사용자 아이디 > ");
		String id = s.nextLine();
		System.out.print("사용자 비밀번호 > ");
		String password = s.nextLine();

		UserVO user = new UserVO();

		user.setUserID(id);
		user.setUserPass(password);

		UserVO userCheck = userDao.selectUser(user);

		// 없으면 로그인 실패
		if (userCheck == null || userCheck.isUserType()) {
			System.out.println("[ 아이디 혹은 비밀번호를 잘못 입력하셨습니다 ]");
			s.nextLine();
		} else {
			// 있으면 로그인
			Session.loginUser = userCheck;
			userMain();
		}
	}

	public void userMain() {
		int a = -1;
		do {
			System.out.println();
			System.out.println("--------------- [ "
					+ Session.loginUser.getUserName()
					+ "님 환영합니다 ] ---------------");
			BookService.getInstance().newBook();
			BookService.getInstance().best();
			System.out
					.println("--------------[ 이용하실 서비스 선택해주세요 ]-------------");
			System.out.println("1. 도서 서비스");
			System.out.println("2. 열람실 서비스");
			System.out.println("3. 마이페이지");
			System.out.println("0. 로그아웃");
			System.out
					.println("---------------------------------------------------");
			System.out.print("번호 > ");
			try {
				a = Integer.parseInt(s.nextLine());
			} catch (Exception e) {
			}

			switch (a) {
			case 1:
				book();
				break;
			case 2:
				UserLib.getInstance().usermain();
				break;
			case 3:
				mypage();
				mypage2();
				break;
			case 0:
				System.out.println("[ 로그아웃되었습니다 ]");
				Session.loginUser = null;
				break;
			default:
				System.out.println("[ 잘못된 값을 입력하였습니다 ]");
				s.nextLine();
			}

		} while (a != 0);
	}

	public void mypage() {

		System.out.println("ID : " + Session.loginUser.getUserID() + "\n"
				+ "PW : " + Session.loginUser.getUserPass() + "\n" + "NAME : "
				+ Session.loginUser.getUserName() + "\n" + "PHONE : "
				+ Session.loginUser.getUserPhone() + "\n" + "ADD : "
				+ Session.loginUser.getUserAddress());

	}

	public void mypage2() {

		ArrayList<OutBookVO> oBook = OutBookDao.getInstance().checkOutBookall(
				Session.loginUser);
		System.out.println("--------------------[대여 내역]--------------------");
		for (int i = 0; i < oBook.size(); i++) {
			BookVO booktitle = BookDao.getInstance().selectBook(oBook.get(i));
			System.out.println("\t" + "도서명 : "+booktitle.getTitle());
			System.out.print("대여 날짜 " + oBook.get(i).getRentDate() + " ~ ");

			if (oBook.get(i).getReturnDate() == null) {
				System.out.println("대여중  / 반납예정일 : "
						+ oBook.get(i).getGiveDate());
			} else {
				System.out.println("반납날짜" + oBook.get(i).getReturnDate());

			}
		}
		System.out.println("이전 페이지로 > ('0')");
		s.nextLine();

	}

	public void book() {
		int a = -1;
		do {
			System.out.println("-----[도서 서비스]-----");
			System.out.println("1. 검색/대여");
			System.out.println("2. 반납/연장");
			System.out.println("0. 뒤로가기");
			System.out.println("---------------------");
			System.out.print("번호 > ");
			try {
				a = Integer.parseInt(s.nextLine());
			} catch (Exception e) {
			}

			switch (a) {

			case 1:
				BookService.getInstance().Search();
				break;
			case 2:
				BookService.getInstance().myRent();
				break;
			case 0:

				break;
			default:
				System.out.println("[ 잘못된 값을 입력하였습니다 ]");
				s.nextLine();

			}

		} while (a != 0);

	}

}
