package service;

import java.util.ArrayList;
import java.util.Scanner;

import vo.UserVO;
import dao.UserDao;

public class AdminUserService {

	private static AdminUserService instance;

	private AdminUserService() {
	}

	public static AdminUserService getInstance() {
		if (instance == null) {
			instance = new AdminUserService();
		}
		return instance;
	}

	Scanner s = new Scanner(System.in);

	private UserDao userDao = UserDao.getInstance();

	public void usermanage() {
		int a = -1;
		do {
			// 회원목록이 띄워져 있어야한다.
			userList();
			do {
				System.out.println("----[회원관리]----");
				System.out.println("1.회원등록");
				System.out.println("2.회원수정/삭제");
				System.out.println("0.뒤로가기");
				System.out.println("----------------");
				System.out.print("번호 > ");
				try {
					a = Integer.parseInt(s.nextLine());
				} catch (Exception e) {
				}
				if (!(a == 1 || a == 2 || a == 0)) {
					System.out.println("[ 잘못된 값을 입력하였습니다 ]");
					s.nextLine();
				}
			} while (!(a == 1 || a == 2 || a == 0));

			switch (a) {
			case 1:
				userjoin();
				break;
			case 2:
				useredit();
				break;
			case 0:
				break;
			}
		} while (a != 0);
	}

	public void userjoin() {
		UserVO user = new UserVO();
		System.out.println("----[회원등록]----");
		System.out.println("아이디 > ");
		String id = s.nextLine();

		user.setUserID(id);
		UserVO userCheck = userDao.selectUser(user);

		if (userCheck == null) {
			System.out.println("비밀번호 > ");
			String pw = s.nextLine();
			user.setUserPass(pw);
			System.out.println("이름 > ");
			String name = s.nextLine();
			user.setUserName(name);
			System.out.println("전화번호 > ");
			String pn = s.nextLine();
			user.setUserPhone(pn);
			System.out.println("주소 > ");
			String juso = s.nextLine();
			user.setUserAddress(juso);
			System.out.println("[ 가입이 완료되었습니다 ]");
			UserDao.getInstance().insertUser(user);
		} else {
			System.out.println("[ 이미 사용중인 아이디 입니다 ]");
			s.nextLine();
		}
	}

	public void useredit()
	// 검색해서 수정할 부분
	{
		int a = -1;
		String z;
		System.out.println();
		System.out.print("수정/삭제 할 회원의 아이디 >");
		z = s.nextLine();
		UserDao user = UserDao.getInstance();
		UserVO searchuser2 = new UserVO();

		searchuser2.setUserID(z);
		searchuser2 = user.selectUser(searchuser2);

		if (searchuser2 != null) {
			System.out.println();
			System.out.println("회원의 ID : " + searchuser2.getUserID() + "\n"
					+ "회원의 PW : " + searchuser2.getUserPass() + "\n"
					+ "회원의 이름 : " + searchuser2.getUserName() + "\n"
					+ "회원의 전화번호 : " + searchuser2.getUserPhone() + "\n"
					+ "회원의 주소 : " + searchuser2.getUserAddress());
			do {
				do {
					System.out.println();
					System.out.println("-----[회원수정/삭제]-----");
					System.out.println("1. 회원정보 수정");
					System.out.println("2. 회원정보 삭제");
					System.out.println("0. 뒤로가기");
					System.out.print("번호 > ");
					try {
						a = Integer.parseInt(s.nextLine());
					} catch (Exception e) {
					}
					if (!(a == 1 || a == 2 || a == 0))
						{System.out.println("[ 잘못된 값을 입력하였습니다 ]");
					s.nextLine();}
				} while (!(a == 1 || a == 2 || a == 0));

				switch (a) {
				case 1:
					do {
						System.out.println();
						System.out.println("------[ 무엇을 수정하시겠습니까 ]------");
						System.out.println("1. 비밀번호");
						System.out.println("2. 이름");
						System.out.println("3. 휴대전화");
						System.out.println("4. 주소");
						System.out.println("0. 뒤로가기");
						System.out.println("----------------------");
						System.out.print("번호 > ");
						do {
							try {
								a = Integer.parseInt(s.nextLine());
							} catch (Exception e) {
							}
							if (!(a == 1 || a == 2 || a == 3 || a == 4 || a == 0))
							{	System.out.println("[ 잘못된 값을 입력하였습니다 ]");
							s.nextLine();}
						} while (!(a == 1 || a == 2 || a == 3 || a == 4 || a == 0));

						System.out.println("수정할 내용> ");
						switch (a) {
						case 1:
							passedit(searchuser2);
							break;
						case 2:
							nameedit(searchuser2);
							break;
						case 3:
							pnedit(searchuser2);
							break;
						case 4:
							addedit(searchuser2);
							break;

						case 0:
							break;

						}
						System.out.println("수정된 회원의 ID : "
								+ searchuser2.getUserID() + "\n"
								+ "수정된 회원의 PW : " + searchuser2.getUserPass()
								+ "\n" + "수정된 회원의 이름 : "
								+ searchuser2.getUserName() + "\n"
								+ "수정된 회원의 전화번호 : "
								+ searchuser2.getUserPhone() + "\n"
								+ "수정된 회원의 주소 : "
								+ searchuser2.getUserAddress());
					} while (a != 0);
					break;
				case 2:
					userdel(searchuser2);
					return;
				}

			} while (a != 0);
		} else {
			System.out.println();
			System.out.println("[ 검색결과가 없습니다 ]");
			s.nextLine();
		}

	}

	public void passedit(UserVO searchuser2) {
		String b1;
		b1 = s.nextLine();
		searchuser2.setUserPass(b1);
		System.out.println("[ 수정되었습니다.  비밀번호 : " + searchuser2.getUserPass()
				+ "]");
	}

	public void nameedit(UserVO searchuser2) {
		String b2;
		b2 = s.nextLine();
		searchuser2.setUserName(b2);
		System.out.println("[ 수정되었습니다.  이름 : " + searchuser2.getUserName()
				+ "]");
	}

	public void pnedit(UserVO searchuser2) {
		String b3;
		b3 = s.nextLine();
		searchuser2.setUserPhone(b3);
		System.out.println("[ 수정되었습니다.  전화번호 : " + searchuser2.getUserPhone()
				+ "]");
	}

	public void addedit(UserVO searchuser2) {
		String b4;
		b4 = s.nextLine();
		searchuser2.setUserAddress(b4);
		System.out.println("[ 수정되었습니다.  주소 : " + searchuser2.getUserAddress()
				+ "]");
	}

	public void userdel(UserVO searchuser) {
		UserDao.getInstance().deleteUser(searchuser);
		System.out.println("[ " + searchuser.getUserID() + " 님이 삭제되었습니다]");
		s.nextLine();
		System.out.println();
		System.out.println("------------수정/삭제 반영된 회원목록--------------");
	}

	public void userList() {
		ArrayList<UserVO> userList = userDao.selectUserList();

		System.out
				.println("--------------------------------------------------");
		System.out.println("아이디\t이름\t전화번호\t\t주소");
		System.out
				.println("--------------------------------------------------");
		// 대여중인 도서명 출력되도록
		for (int i = 0; i < userList.size(); i++) {
			UserVO user = userList.get(i);
			System.out
					.println(user.getUserID() + "\t" + user.getUserName()
							+ "\t" + user.getUserPhone() + "\t"
							+ user.getUserAddress());
		}
		System.out.println("------------------------------------");
	}

}