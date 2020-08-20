package e_oop;

import java.util.Scanner;

public class Tms_main {

	public static void main(String[] args) {
		
		// 발표 : 프로그램 주제, 기능, 메서드 구성, 시연
		
		//프로그램 주제 : 음악추천 프로그램
		//프로그램 기능 : 그 날의 기분에 따라 음악을 추천해주는 프로그램
		//프로그램 메서드 구성 : ignore(), happy(), sweet(), sad(), excit()
		//				   Crush(), Zico(), Dean(), Penomeco(), Millic()
		//프로그램 시연 : ---
		
		/*
		 *
		 * --------------------------------------
		 * Music Is My Life ~ ♬
		 * 당신의 오늘을 위한 Choice 시간!!
		 * --------------------------------------
		 * 당신의 지금 mood는??!
		 * 
		 * 1. 분노, 부들부들
		 * 2. 즐거움, 룰루랄라
		 * 3. 달달, 하늘을 나는 기분
		 * 4. 우울, ㄴr는 가r끔 눈물을 흘린ㄷr,,,♪
		 * 5. 흥분, 흥폭발! 오늘은 흔들어 제껴~~
		 * =======================================
		 * 0. 종료
		 * ----------------------------------------
		 * 당신의 선택은 ? -> 
		 * 
		 */
		
		//clss 받아오기
		TodayMoodSong tms = new TodayMoodSong();
		
		//숫자 받아오기
		Scanner sc = new Scanner(System.in);
		
		int num;
		boolean keep = true;
		
		//반복
		
			//오늘의 기분 선택
			System.out.println("--------------------------------------");
			System.out.println("Music is My Life ~ ♬");
			System.out.println("당신의 오늘을 위한 Choice 시간!!");
			System.out.println("--------------------------------------");
			System.out.println("당신의 지금 mood는??!");
			System.out.println("");
			System.out.println("1. 분노, 부들부들");
			System.out.println("2. 즐거움, 룰루랄라");
			System.out.println("3. 달달, 하늘을 나는 기분");
			System.out.println("4. 우울, ㄴr는 가r끔 눈물을 흘린ㄷr,,,♪");
			System.out.println("5. 흥분, 흥폭발! 오늘은 흔들어 제껴~~");
			System.out.println("======================================");
			System.out.println("0. 종료");
			System.out.println("--------------------------------------");
			System.out.println("당신의 선택은 ? ->");
			num = Integer.parseInt(sc.nextLine());
			
			if (num == 0) {
				System.out.println("종료.");
			} else if (num == 1) {
				tms.ignore();
				System.out.println("당신의 오늘 Mood is 분노");
			} else if (num == 2) {
				tms.happy();
				System.out.println("당신의 오늘 Mood is 즐거움");
			} else if (num == 3) {
				tms.sweet();
				System.out.println("당신의 오늘 Mood is 달달");
			} else if (num == 4) {
				tms.sad();
				System.out.println("당신의 오늘 Mood is 우울");
			} else if (num == 5) {
				tms.excit();
				System.out.println("당신의 오늘 Mood is 흥분");
			}

		

		
	}

}
