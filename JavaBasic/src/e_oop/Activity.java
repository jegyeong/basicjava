package e_oop;

import java.util.Scanner;

public class Activity {
	
	Scanner sc = new Scanner(System.in);
	
	//메인은 출력만 하는곳 
	//다른 곳에서 가져오는것 
	
	//Activity
	
//	초기화
//	AirConditioner(){ //처음에 들어가는 값으로 초기화해준다
//		power = false;
//		temerature = 24;
//		airVolume = 1;
//	}

	
	
	int statistics; //스텟
//	int money; //돈
	int satiety; //포만감
	int futures; //선물 
	//Y는 음식 N는 선물
	int option;
	
	//스텟
	int manners; //예절
	int charm; //매력
	int artistry; //예술성
	int brains;//지식
	int morality;//도덕성
	int stamina; //체력
	int count;
//	String[] present = {"한복", "화구세트", "강연입장권", "책", "화장품", "아령"};//for 문
	
	
	//활동
	int activity; //1 2 3 4 5 6 을 하나씩 선택하면 
	//직업
//	int job; //제일 높은 점수에 따라서 직업이 정해진다
	
	//매력이 30이 넘으면 결혼을 할 수 있다
	
	//활동하기
	//1 :예절교실  2 : 미술수업  3 : 학교가기  4 : 교회  5 : 아르바이트    6 : 무술교실  
	//   예절		예술성		지식		  도덕성		매력			체력	
	
	//스텟 
	//"반년이 지났습니다." , "다음반년동안의 딸에게 시킬 활동을 선택해주세요"
	//능력치 소개
	//메서드를 만들어서 
	
	
	
	
	void mannersUp(){ //한번 누를때마다  한번씩 올라감
		manners++;		
	}
	
	void charmUp(){
		charm++;
	}
	
	void artistryUp(){
		artistry++;
	}
	
	void brainsUp(){
		brains++;
	}
	
	void moralityUp(){
		morality++;
	}
	
	void staminaUp(){
		stamina++;
	}
	
	void satietyUp(){
		satiety++;
	}

	//변수 
	void Activity(int input){	
//		if (activity == 1){
//			/*return*/ manners++;
//			System.out.println("예절이 1 증가했습니다");
//		}
//	
//		if (activity == 2){
//			charm++;
//			System.out.println("매력이 1 증가했습니다");
//		}
//	
//		if (activity == 3){
//			artistry++;
//			System.out.println("예술성이 1 증가했습니다");
//		}
//	
//		if (activity == 4){
//			brains++;
//			System.out.println("지식이 1 증가했습니다");
//		}
//	
//		if (activity == 5){
//			morality++;
//			System.out.println("도덕성이 1 증가했습니다");
//		}
//	
//		if (activity == 6){
//			stamina++;
//			System.out.println("체력이 1 증가했습니다");
//		}
		
		switch(activity){
			case 1 :manners++;
				System.out.println("예절이 1 증가했습니다");
			case 2 : charm++;
				System.out.println("매력이 1 증가했습니다");
			case 3 : artistry++;
				System.out.println("예술성이 1 증가했습니다");
			case 4 : brains++;
				System.out.println("지식이 1 증가했습니다");
			case 5 : morality++;
				System.out.println("도덕성이 1 증가했습니다");
			case 6 : stamina++;
			System.out.println("체력이 1 증가했습니다");
		}
	
		
//		String [] option = {"한복", "화구세트", "강연입장권", "책", "화장품", "아령", "음식"};
		switch(option){
			case 1 : manners++;
				System.out.println("예절이 1 증가했습니다");
			case 2 : charm++;
				System.out.println("매력이 1 증가했습니다");
			case 3 : artistry++;
				System.out.println("예술성이 1 증가했습니다");
			case 4 : brains++;
				System.out.println("지식이 1 증가했습니다");	
			case 5 : morality++;
				System.out.println("도덕이 1 증가했습니다");
			case 6 : stamina++;
				System.out.println("체력7 1 증가했습니다");
		
		}
		
		System.out.println("다음 옵션 중 하나만 선택해 주세요");
		System.out.println("딸에게 선물주기 VS 딸에게 음식주기");
		System.out.println("단, 한가지를 선택하면 다른 한가지를 선택할 수 없습니다");
		System.out.println("선물은 1번, 음식은 2번을 선택해주세요");
		

		
		
		
		
		
	}
}

