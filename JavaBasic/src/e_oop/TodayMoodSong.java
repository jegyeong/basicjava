package e_oop;

import java.util.Scanner;

public class TodayMoodSong {

	Tms_main tm = new Tms_main();

	Scanner sc = new Scanner(System.in);

	int num2;

	// 1번선택(분노)
	void ignore() {
		
		Tms_singer ts = new Tms_singer();
		
		System.out.println("--------------------------------------");
		System.out.println("Music is My Life ~ ♬");
		System.out.println("당신의 오늘을 위한 Choice 시간!!");
		System.out.println("--------------------------------------");
		System.out.println(" 오늘의 mood ☞ '분노'를 선택하신 당신!");
		System.out.println("오늘의 Artist!");
		System.out.println("1. Crush 2. Zico 3. Dean 4. Penomeco 5. Millic");
		System.out.println("======================================");
		System.out.println("9. 전단계로 이동");
		System.out.println("--------------------------------------");
		System.out.println("당신의 선택은 ? ->");
		num2 = Integer.parseInt(sc.nextLine());
		
		if (num2 == 9) {
			System.out.println(tm);
		} else if (num2 == 1) {
			ts.Crush();
		} else if (num2 == 2) {
			ts.Zico();
		} else if (num2 == 3) {
			ts.Dean();
		} else if (num2 == 4) {
			ts.Penomeco();
		} else if (num2 == 5) {
			ts.Millic();
		} 
		
		
	}


	// 2번선택(즐거움)
	void happy() {

		Tms_singer ts = new Tms_singer();
		
		System.out.println("--------------------------------------");
		System.out.println("Music is My Life ~ ♬");
		System.out.println("당신의 오늘을 위한 Choice 시간!!");
		System.out.println("--------------------------------------");
		System.out.println(" 오늘의 mood ☞ '즐거움'을 선택하신 당신!");
		System.out.println("오늘의 Artist!");
		System.out.println("1. Crush 2. Zico 3. Dean 4. Penomeco 5. Millic");
		System.out.println("======================================");
		System.out.println("9. 전단계로 이동");
		System.out.println("--------------------------------------");
		System.out.println("당신의 선택은 ? ->");
		num2 = Integer.parseInt(sc.nextLine());
		
		if (num2 == 9) {
			System.out.println(tm);
		} else if (num2 == 1) {
			ts.Crush();
		} else if (num2 == 2) {
			ts.Zico();
		} else if (num2 == 3) {
			ts.Dean();
		} else if (num2 == 4) {
			ts.Penomeco();
		} else if (num2 == 5) {
			ts.Millic();
		} 

	}

	// 3번선택(달달)
	void sweet() {

		Tms_singer ts = new Tms_singer();
		
		System.out.println("--------------------------------------");
		System.out.println("Music is My Life ~ ♬");
		System.out.println("당신의 오늘을 위한 Choice 시간!!");
		System.out.println("--------------------------------------");
		System.out.println(" 오늘의 mood ☞ '달달'을 선택하신 당신!");
		System.out.println("오늘의 Artist!");
		System.out.println("1. Crush 2. Zico 3. Dean 4. Penomeco 5. Millic");
		System.out.println("======================================");
		System.out.println("9. 전단계로 이동");
		System.out.println("--------------------------------------");
		System.out.println("당신의 선택은 ? ->");
		num2 = Integer.parseInt(sc.nextLine());
		
		if (num2 == 9) {
			System.out.println(tm);
		} else if (num2 == 1) {
			ts.Crush();
		} else if (num2 == 2) {
			ts.Zico();
		} else if (num2 == 3) {
			ts.Dean();
		} else if (num2 == 4) {
			ts.Penomeco();
		} else if (num2 == 5) {
			ts.Millic();
		} 

	}

	// 4번선택(슬픔)
	void sad() {
		
		Tms_singer ts = new Tms_singer();

		System.out.println("--------------------------------------");
		System.out.println("Music is My Life ~ ♬");
		System.out.println("당신의 오늘을 위한 Choice 시간!!");
		System.out.println("--------------------------------------");
		System.out.println(" 오늘의 mood ☞ '우울'을 선택하신 당신!");
		System.out.println("오늘의 Artist!");
		System.out.println("1. Crush 2. Zico 3. Dean 4. Penomeco 5. Millic");
		System.out.println("======================================");
		System.out.println("9. 전단계로 이동");
		System.out.println("--------------------------------------");
		System.out.println("당신의 선택은 ? ->");
		num2 = Integer.parseInt(sc.nextLine());
		
		if (num2 == 9) {
			System.out.println(tm);
		} else if (num2 == 1) {
			ts.Crush();
		} else if (num2 == 2) {
			ts.Zico();
		} else if (num2 == 3) {
			ts.Dean();
		} else if (num2 == 4) {
			ts.Penomeco();
		} else if (num2 == 5) {
			ts.Millic();
		} 

	}

	// 5번선택(흥분)
	void excit() {
		
		Tms_singer ts = new Tms_singer();

		System.out.println("--------------------------------------");
		System.out.println("Music is My Life ~ ♬");
		System.out.println("당신의 오늘을 위한 Choice 시간!!");
		System.out.println("--------------------------------------");
		System.out.println(" 오늘의 mood ☞ '흥분'을 선택하신 당신!");
		System.out.println("오늘의 Artist!");
		System.out.println("1. Crush 2. Zico 3. Dean 4. Penomeco 5. Millic");
		System.out.println("======================================");
		System.out.println("9. 전단계로 이동");
		System.out.println("--------------------------------------");
		System.out.println("당신의 선택은 ? ->");
		num2 = Integer.parseInt(sc.nextLine());
		
		if (num2 == 9) {
			System.out.println(tm);
		} else if (num2 == 1) {
			ts.Crush();
		} else if (num2 == 2) {
			ts.Zico();
		} else if (num2 == 3) {
			ts.Dean();
		} else if (num2 == 4) {
			ts.Penomeco();
		} else if (num2 == 5) {
			ts.Millic();
		} 

	}

}
