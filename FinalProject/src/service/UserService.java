package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import vo.MileageVo;
import vo.UserVo;
import dao.MileageDao;
import dao.UserDao;
import data.Session;


public class UserService {
	static Scanner s = new Scanner(System.in);

	public static void join() {
		UserDao userDao = UserDao.getInstance();
		UserVo user = new UserVo();

		String id;
		UserVo userCheck;

		do {
			System.out
					.println("----------------------------------------------");
			id = formCheck("아이디(영문,숫자 5자 이상 20자이하 ) : ", "[A-Za-z0-9_-]{5,20}");
			user.setId(id);
			userCheck = userDao.selectUser(user);
			if (userCheck != null) {
				System.out
						.println("----------------------------------------------");
				System.out.println("중복된 아이디가 있습니다.");
				System.out
						.println("----------------------------------------------");
			} else {
				System.out
						.println("----------------------------------------------");
				System.out.println("해당 아이디를 사용하실수 있습니다.");
				System.out
						.println("----------------------------------------------");
			}
		} while (userCheck != null);

		if (userCheck == null) {
			System.out
					.println("----------------------------------------------");
			String password = formCheck("비밀번호(영문5자이하, 숫자 20자이하 포함) : ",
					"[A-Za-z0-9_-]{5,20}");
			System.out
					.println("----------------------------------------------");
			String name = formCheck("이름 : ", "^[A-Za-z가-힣]*$");
			System.out
					.println("----------------------------------------------");
			String num = formCheck("핸드폰 번호('-'포함 입력) : ",
					"^0\\d{1,3}-\\d{3,4}-\\d{4}");
			System.out
					.println("----------------------------------------------");
			String birth = formCheck("생년월일(6자리) : ", "[0-9]{6}");

			user.setPassword(password);
			user.setName(name);
			user.setNum(num);
			user.setBirth(birth);
			userDao.insertUser(user);

			MileageVo mileage = new MileageVo();
			mileage.setContents("회원가입");
			mileage.setDate(new Date());
			mileage.setId(id);
			mileage.setMiliage(1000);
			MileageDao mileageDao = MileageDao.getInstance();
			mileageDao.insertMileage(mileage);

			System.out.println("합석해주셔서 갑사합니다0.<!");
		}
	}

	public static String formCheck(String contents, String form) {
		Pattern pattern;
		Matcher matcher;
		boolean check;
		String temp;
		do {

			System.out.println(contents);
			System.out
					.println("----------------------------------------------");
			temp = s.nextLine().trim();

			pattern = Pattern.compile(form);
			matcher = pattern.matcher(temp);

			if (matcher.matches()) {
				check = true;
			} else {
				System.out.println("형식에 맞게 입력해주세요.");
				check = false;
			}

		} while (!check);

		return temp;
	}

	public static void login() {
		// 아이디, 비밀번호를 입력
		UserDao userDao = UserDao.getInstance();

		System.out.println("아이디 : ");
		String id = s.nextLine().trim();
		System.out.println("비밀번호 : ");
		String password = s.nextLine().trim();

		UserVo user = new UserVo();
		user.setId(id);
		user.setPassword(password);

		UserVo userCheck = userDao.selectUser(user);

		// 없으면 로그인 실패
		if (userCheck == null) {
			System.out.println("잘못 입력하셨습니다! 벌써 취하셨나요??ㅠㅠ");
		} else {
			// 있으면 로그인
			System.out.println("술잔 준비 완료!!!");
			System.out.println(userCheck.getName() + "취객 +1~!");
			Session.loginUser = userCheck;
			MileageDao mileageDao = MileageDao.getInstance();
			// Mileage.deleteMilegaeData();// 30일 지난 마일리지는 삭제된다.
			mileageDao.searchUserMileage(Session.loginUser.getId());
		}
	}

	public static void userManagement() {

		boolean check = true;
		String temp = "";
		do {
			do {
				System.out.println("----------------------------------------");
				System.out.println("유저관리 메뉴입니다.");
				System.out.println("1. 회원 목록 출력");
				System.out.println("2. 관리자 및 유저 등급부여");
				System.out.println("3. 회원 삭제");		
				System.out.println("0. 이전 메뉴로 이동");
				System.out.println("----------------------------------------");

				temp = s.nextLine();
				check = IntegerCheck.checkInt(temp, 0, 3);

			} while (!check);
			check = false;
			int menu = Integer.parseInt(temp);

			switch (menu) {
			case 1:
				userList();
				break;
			case 2:// 등급관리
				adminPermission();
				break;
			case 3:
				deleteUser();
				break;
			case 0:
				System.out.println("이전 메뉴로 돌아갑니다.");
				check = true;
			}
		} while (!check);

	}

	public static void userList() {
		// 회원 전체 조회
		UserDao userDao = UserDao.getInstance();
		ArrayList<UserVo> userArray = userDao.selectUserList();
		// 출력
		System.out
				.println("-------------------------------------------------------------------------------");
		System.out.println("번호\t아이디\t\t\t이름\t전화번호\t\t생년월일");
		System.out
				.println("-------------------------------------------------------------------------------");
		for (int i = 0; i < userDao.selectUserList().size(); i++) {

			String id = userArray.get(i).getId();
			
			int count = 3-id.length()/7;
			for(int j = 0 ; j < count ;j++){
				id += "\t";
			}
		
			System.out.println(i + 1 + "\t" + id + userArray.get(i).getName()
					+ "\t" + userArray.get(i).getNum() + "\t"
					+ userArray.get(i).getBirth());

		}
		System.out
				.println("-------------------------------------------------------------------------------");

	}

	public static void deleteUser() {
		UserDao userDao = UserDao.getInstance();
		ArrayList<UserVo> userArray = userDao.selectUserList(false);

		boolean check = true;
		String temp = "";
		System.out.println("---------------------------------------------------");
		System.out.println("번호\t아이디\t\t\t이름");
		System.out.println("---------------------------------------------------");
		do {
			for (int i = 0; i < userArray.size(); i++) {
				String id = userArray.get(i).getId();
				
				int count = 3-id.length()/7;
				for(int j = 0 ; j < count ;j++){
					id += "\t";
				}
				
				
				System.out.println(i + 1 + "\t" + id
						+ userArray.get(i).getName() + "\t");

			}
			System.out.println("0.  종료하기");
			System.out
					.println("---------------------------------------------------");
			System.out.println("삭제하고자하는 회원의 번호를 입력해주세요.");
			System.out
					.println("---------------------------------------------------");
			temp = s.nextLine().trim();
			check = IntegerCheck.checkInt(temp, 0, userArray.size());

		} while (!check);
		if (temp.equals("0")) {
			return;
		}
		String pos = userArray.get(Integer.parseInt(temp) - 1).getId();
		System.out.println(pos);

		do {
			System.out.println("-----------------------------------------------");
			System.out.println("ID : " + userDao.searchUserNoInfo(pos).getId() + "를 삭제하시겠습니까?");
			System.out.println("삭제 : 1");
			System.out.println("취소 : 0");
			System.out.println("-----------------------------------------------");

			temp = s.nextLine().trim();
			check = IntegerCheck.checkInt(temp);

		} while (!check);

		if (Integer.parseInt(temp) == 1) {
			userDao.deleteUser(userDao.searchUserNoInfo(pos));
		} else {
			System.out.println("작업을 취소합니다.");
			return;
		}
	}

	public static void adminPermission() {
		UserDao userDao = UserDao.getInstance();
		ArrayList<UserVo> notAdminList = userDao.searchNotAdminNoInfo();
		String temp = "";
		boolean check = false;

		if (!Session.loginUser.getId().equals("admin")) {
			System.out.println("해당 아이디는 접근할 수 없습니다.");
		} else {
			do{
			do {
				System.out.println("---------------------------------------");
				System.out.println("등급을 번경할 아이디를 선택해주세요.");
				System.out.println("---------------------------------------");
				System.out.println("번호\t아이디\t\t\t등급");
				System.out.println("---------------------------------------");
				for (int i = 0; i < notAdminList.size(); i++) {
					String id = notAdminList.get(i).getId();
					int count = 3-id.length()/7;
					for(int j = 0 ; j < count ;j++){
						id += "\t";
					}
					
					
					
					
				
					

					System.out.print(i + 1 + "\t ");
					System.out.print(id);
					if (notAdminList.get(i).isMode()) {
						System.out.println("관리자");
					} else {
						System.out.println("유저");
					}
				}
				System.out.println("0. 이전 메뉴로 이동");
				System.out.println("---------------------------------------");
				temp = s.nextLine().trim();
				check = IntegerCheck.checkInt(temp, 0, notAdminList.size());
			} while (!check);

			if (temp.equals("0")) {
				return;
			}

			UserVo userInfo = notAdminList.get(Integer.parseInt(temp) - 1);

			do {
				System.out.println("-------------------------------------------------");
				System.out.print(userInfo.getId() + "의 현재 등급은 ");
				if (userInfo.isMode()) {
					System.out.println("관리자");
				} else {
					System.out.println("유저");
				}
				System.out.println("입니다.");
				System.out.println("변경할 등급을 선택해주세요.");
				System.out.println("1. 유저");
				System.out.println("2. 관리자");
				System.out.println("0. 이전 메뉴로 이동");
				System.out.println("-------------------------------------------------");
				temp = s.nextLine().trim();
				check = IntegerCheck.checkInt(temp, 0, 2);
			} while (!check);

			if (temp.equals("0")) {
				check = true;
			} else {

				int pos = Integer.parseInt(temp);

				switch (pos) {
				case 1:
					System.out.println("-------------------------------------------------");
					userDao.selectUser(userInfo).setMode(true);
					System.out.print(userDao.selectUser(userInfo).getId() + "의 등급");
					if (userDao.selectUser(userInfo).isMode()) {
						System.out.println("이 유저로 변경되었습니다.");
						userDao.selectUser(userInfo).setMode(false);

					} else {
						System.out.println("의 변경을 실패하였습니다.");
					}

					System.out.println("-------------------------------------------------");
					break;
				case 2:
					System.out.println("-------------------------------------------------");
					System.out.print(userDao.selectUser(userInfo).getId()+ "의 등급");
					if (!userDao.selectUser(userInfo).isMode()) {
						System.out.println("이 관리자로 변경되었습니다.");
						userDao.selectUser(userInfo).setMode(true);
					} else {
						System.out.println("의 변경을 실패하였습니다.");
					}
					System.out.println("-------------------------------------------------");
					break;

				}
				check = false;
			}

		}while(check);
	}
}
}
