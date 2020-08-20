package service;

import java.text.SimpleDateFormat;
import java.util.*;

import vo.ReadingRoomListVO;
import vo.ReadingRoomVO;
import dao.ReadingRoomDao;
import dao.ReadingRoomListDao;
import data.Session;

public class UserLib {

	private static UserLib instance;

	private UserLib() {
	}

	public static UserLib getInstance() {
		if (instance == null) {
			instance = new UserLib();
		}
		return instance;
	}

	// private UserDao userDao = UserDao.getInstance();

	Scanner s = new Scanner(System.in);
	ReadingRoomDao RRD = ReadingRoomDao.getInstance();
	ReadingRoomListDao RRLD = ReadingRoomListDao.getInstance();
	ReadingRoomVO readao = new ReadingRoomVO();
	ReadingRoomListVO reddao = new ReadingRoomListVO();

	public void usermain() { // 메인화면
		int a = -1;

		do {
			System.out.println();
			System.out.println("-----[열람실]-----");
			System.out.println("1. 좌석 발급");
			System.out.println("2. 좌석 반납");
			System.out.println("0. 뒤로가기");
			System.out.println("-----------------");
			System.out.print("번호 > ");
			try {
				a = Integer.parseInt(s.nextLine());
			} catch (Exception e) {
			}
			if (!(a == 1 || a == 2 || a==0)) {
				System.out.println("[ 잘못된 값을 입력하였습니다 ]");
				s.nextLine();
			}

		} while (!(a == 1 || a == 2 || a == 0));
		switch (a) {

		case 1:
			userenter();
			break;
		case 2:
			retseat();
			break;
		case 0:
			break;

		}

	}

	public static void sysdate() { // 시간출력
		Date Today = new Date();
		System.out.println(Today);
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf1.format(Today);
		// String today = sdf1.format(Today);
	}

	public void userenter() { // 유저 발급
		int a = -1;
		String Id = null; // 세션에서 받아올 아이디 추가
		String Name = null; // 세션에서 받아올 이름 추가
		ReadingRoomListVO v = new ReadingRoomListVO(); // 유저 좌석 객체화
		// 시간
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MM.dd HH:mm");
		Date Today = new Date();
		String today = sdf1.format(Today);
		try {
			today = sdf1.format(Today); // 스트링 타입으로 start타입에 넣으려고 변수에 넣음
		} catch (Exception e) {

		}
		AdminLib.getInstance().seatlist();
		do {
			System.out.print("발급받을 좌석을 입력해주세요 > ");
			try {
				a = Integer.parseInt(s.nextLine());
			} catch (Exception e) {
			}
			if (a <= 0) {
				System.out.println("[ 잘못된 값을 입력하였습니다 ]");
				s.nextLine();
			}
		} while (a <= 0);

		for (int i = 0; i < RRD.selectroom().size(); i++) {
			if (RRD.selectroom().get(a - 1).getWhat().equals("사용가능")) {
				Id = Session.loginUser.getUserID(); // 세션 로그인 아이디 넣기
				Name = Session.loginUser.getUserName();
				v.setSeatNum(a); // 스캐너로 입력
				v.setUserId(Id);// 세션에서 받은 아이디
				v.setStartTime(Today); // 포맷날짜
				System.out.println("---------------------");
				System.out.println("[ " + Name + "님의 좌석 발급이 완료되었습니다 ]");
				System.out.println("[ 발급 받은 좌석:" + a + "번 좌석 ]");
				System.out.println("[ 좌석 발급  시간: " + today + " ]");
				RRLD.insertroom(v);
				RRD.selectroom().get(a - 1).setWhat(Id);
				break;

			} else if (RRLD.selectroom().get(i).getSeatNum() == RRD
					.selectroom().get(a).getSeatNum()) {
				System.out.println("[ 이미 발급되어 있는 좌석입니다 ]");
				break;
			}

			// }
		}
		System.out.println();
		AdminLib.getInstance().seatlist();

		usermain();

	}

	public void retseat() {
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MM.dd HH:mm");
		Date Today = new Date();
		String today = sdf1.format(Today);
		try {
			today = sdf1.format(Today); // 스트링 타입으로 start타입에 넣으려고 변수에 넣음
		} catch (Exception e) {

		}

		for (int i = 0; i < RRD.selectroom().size(); i++) {

			ReadingRoomVO v = new ReadingRoomVO();

			v = RRD.selectroom().get(i);
			// v 에 내가 비교할려고 하는 객체를 담는다.

			if (RRD.selectroom().get(i).getWhat()
					.equals(Session.loginUser.getUserID())) {
				v.setWhat("사용가능");
				System.out.println();
				System.out.println("[ 좌석이 반납되었습니다 ]");
				System.out.println("[ 퇴실시간 " + today + " ]");

				AdminLib.getInstance().seatlist();
				
				return;
			}
		}
		
			System.out.println("[ 반납할 좌석이 없습니다 ]");
			
			

	}

}
