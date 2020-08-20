package game.sutvivarGame;

import java.util.Date;
import java.util.Scanner;

import vo.MileageVo;
import vo.UserVo;
import dao.MileageDao;
import data.Session;

public class FIgthClass {

	private static FIgthClass instance; // instance가 변수

	private FIgthClass() {
	}

	public static FIgthClass getInstance() {
		if (instance == null) {
			instance = new FIgthClass();
		}
		return instance;

	}

	Character2 c2 = Character2.getInstance();
	Scanner s = new Scanner(System.in);
	int stage;
	int turn = 1;
	int point;

	int a_maxhp;
	int a_char;
	int a_health;
	int a_attack;
	int a_point;
	int a_skillpoint;
	int a_mode;
	int a_modeattack;
	boolean a_win;

	int b_maxhp;
	int b_char;
	int b_health;
	int b_attack;
	int b_point;
	int b_skillpoint;
	int b_mode;
	int b_modeattack;
	boolean b_win;

	int user1;
	int user2;

	boolean skillstop = true;

	void aUserpoint() {

		a_point++;

	}

	void attack() {
		if (user1 == 1) {
			a_point--;
			if (user2 == 2) {
				System.out.println("상대방의 공격을 막았습니다");
			} else {
				b_health = b_health - a_attack;
			}
		}
		if (user2 == 1) {
			b_point--;
			if (user1 == 2) {
				System.out.println("상대방의 공격을 막았습니다");
			} else {
				a_health = a_health - b_attack;
			}
		}
	}

	void bUserpoint() {

		b_point++;

	}

	public void mainFight() {
		MileageDao mileageDao = MileageDao.getInstance();
		int sum = mileageDao.searchUserMileageSum(Session.loginUser.getId());
		if(sum<=500){
			System.out.println("게임을 진행하기 위해서는 500마일리지 이상 필요합니다.");
			return;
		}
		StartClas s = new StartClas();
		   
		   s.Start();
		
		  selectClass s1 = new selectClass();
		   
		   s1.select();

		boolean result = false;

		do {
			turn++;
			// boolean skillstop = true;

			modesetting();
			user_1();
			user_2();// user1 선택 끝
			attack();

			if (user1 == 4)
				a_skillselect();
			if (user1 == 4 && user2 == 4 && a_char == b_char) {

			} else {

				if (user2 == 4)
					b_skillselect();
			}

			view();

			if (a_health <= 0 && b_health <= 0) {
				System.out.println("비겼습니다.");
			} else if (a_health <= 0) {
				System.out.println("컴퓨터의 승리입니다.");
				b_win = true;
				result = !result;
			} else if (b_health <= 0) {
				System.out.println(" 승리하셨습니다!!");
				a_win = true;
				result = !result;
			}

		} while (!result);
		
		if(b_win == true){
			System.out.println("포인트 -1000 차감");
			MileageDao mileagedao = MileageDao.getInstance();
			UserVo user = Session.loginUser;
			String userKey = user.getId();
			MileageVo mileageInfo = new MileageVo();

			Date date = new Date();

			mileageInfo.setDate(date);// 게임 종료 시간 입력
			mileageInfo.setId(userKey);// 유저 아이디
			mileageInfo.setMiliage(-200);// 획득마일리지
			mileageInfo.setContents("격투게임 승리");
			mileagedao.insertMileage(mileageInfo); // 마일리지 정보 넣어주기
			mileagedao.searchUserMileage(Session.loginUser.getId());// 마일리지 정보 최신화
			
		}
		if(a_win == true && turn < 10){
			System.out.println("포인트 1000 획득!");
			MileageDao mileagedao = MileageDao.getInstance();
			UserVo user = Session.loginUser;
			String userKey = user.getId();
			MileageVo mileageInfo = new MileageVo();

			Date date = new Date();

			mileageInfo.setDate(date);// 게임 종료 시간 입력
			mileageInfo.setId(userKey);// 유저 아이디
			mileageInfo.setMiliage(1000);// 획득마일리지
			mileageInfo.setContents("격투게임 승리");
			mileagedao.insertMileage(mileageInfo); // 마일리지 정보 넣어주기
			mileagedao.searchUserMileage(Session.loginUser.getId());// 마일리지 정보 최신화

		}
		if(a_win == true && turn >= 10){
			System.out.println("포인트 500 획득!");
			MileageDao mileagedao = MileageDao.getInstance();
			UserVo user = Session.loginUser;
			String userKey = user.getId();
			MileageVo mileageInfo = new MileageVo();

			Date date = new Date();

			mileageInfo.setDate(date);// 게임 종료 시간 입력
			mileageInfo.setId(userKey);// 유저 아이디
			mileageInfo.setMiliage(500);// 획득마일리지
			mileageInfo.setContents("격투게임 승리");
			mileagedao.insertMileage(mileageInfo); // 마일리지 정보 넣어주기
			mileagedao.searchUserMileage(Session.loginUser.getId());// 마일리지 정보 최신화

		}

	} // 끝

	void process() {
		if (user2 == 2 || user1 == 2) {

		}

	}

	void view() {

		System.out.println("================================");
		System.out.print("\n나의 HP   : ");
		for (int i = 0; i < a_health; i++) {
			System.out.print("■");
		}
		for (int i = 0; i < a_maxhp - a_health; i++) {
			System.out.print("□");
		}
		System.out.print("\n나의 MP   :" + a_point);
		System.out.println("\n================================");
		if (a_mode > turn)
			System.out.println("변신모드 : " + (a_mode - turn));
		System.out.print("\n상대방의 HP : ");
		for (int i = 0; i < b_health; i++) {
			System.out.print("■");
		}
		for (int i = 0; i < b_maxhp - b_health; i++) {
			System.out.print("□");
		}
		System.out.print("\n상대방의 MP   :" + b_point);
		if (b_mode > turn)
			System.out.println("\n변신모드 : " + (b_mode - turn));
		System.out.println("\n================================");
	}

	void Char1Skill() {
		System.out.println("엄청나 굉장해 쌔게 때리기!");
		System.out.println("아플걸??");
		if (user1 == 4) {
			if (user2 == 2) {
				b_health -= a_attack;
			} else {
				b_health -= a_attack * 2;
			}
		}

		if (user2 == 4) {
			if (user1 == 2) {
				a_health -= b_attack;
			} else {
				a_health -= b_attack * 2;
			}
		}

	}

	void modesetting() {
		if (a_mode == turn) {

			a_attack = a_modeattack;

		}
		if (b_mode == turn) {
			b_attack = b_modeattack;
		}

	}

	void Char2Skill() {
		System.out.println("물약 모드로 변신");

		if (user1 == 4) {
			a_mode = turn + 2;
			a_modeattack = c2.power;
			a_attack *= 2;
		}

		if (user2 == 4) {
			b_mode = turn + 2;
			b_modeattack = c2.power;
			b_attack *= 2;

		}

	}

	void user_1() {
		skillstop = true;

		while (skillstop == true) {
			
			System.out.println("\n1. 공격하기");
			System.out.println("2. 방어하기"); //
			System.out.println("3. 기모으기");
			System.out.println("4. 스킬쓰기");
			user1 = s.nextInt();
			switch (user1) {
			case 1:
				if (a_point > 0) {
					// aUserattack(a_attack);
					System.out.println("그냥 공격하기");
					skillstop = false;
				} else {
					System.out.println("공격 포인트가 부족합니다!");
				}
				break;

			case 2:

				System.out.println("그냥 막아버리기!");
				skillstop = false;
				break;
			case 3:
				aUserpoint();
				System.out.println("기 모으기!");
				skillstop = false;
				break;
			case 4:
				if (a_point >= a_skillpoint) {
					System.out.println("특수 공격하기!");
					a_point -= a_skillpoint;
					skillstop = false;
				} else {
					System.out.println("아직 포인트가 부족합니다. 포인트가 " + a_skillpoint
							+ " 이상이어야 합니다.");
					skillstop = true;
				}

			}
		}
	}

	void user_2() {
		skillstop = true;
		while (skillstop == true) {
			
			user2 = (int) (Math.random() * 4) + 1;
			System.out.println("1. 공격하기");
			System.out.println("2. 방어하기");
			System.out.println("3. 스킬쓰기");
			switch (user2) {
			case 1:
				if (b_point > 0) {
					// bUserattack(b_attack);
					System.out.println("그냥 공격하기");
					skillstop = false;
				} else {
					System.out.println("공격 포인트가 부족합니다!");
				}
				break;

			case 2:

				System.out.println("그냥 막아버리기!");
				skillstop = false;
				break;
			case 3:
				bUserpoint();
				System.out.println("기 모으기!");
				skillstop = false;
				break;
			case 4:
				if (b_point >= b_skillpoint) {
					System.out.println("특수 공격하기!");
					b_point -= b_skillpoint;
					skillstop = false;
				} else {
					System.out.println("아직 포인트가 부족합니다. 포인트가 " + b_skillpoint
							+ " 이상이어야 합니다.");
					skillstop = true;
				}

			}
		}

	}

	void a_skillselect() {

		switch (a_char) {
		case 1:
			Char1Skill();

			break;

		case 2:
			Char2Skill();
			break;
		case 3:
			Char3Skill();

			break;
		
		}
	}

	void b_skillselect() {

		switch (b_char) {
		case 1:
			Char1Skill();

			break;

		case 2:
			Char2Skill();
			break;
		case 3:
			Char3Skill();
			break;
		
		}
	}


    void Char3Skill(){
    	System.out.println("체력회복하기!");
    	
    	if (user1 == 4) {
			a_health += 3;
		}

		if (user2 == 4) {
			b_health += 3;

		}
    }









}
