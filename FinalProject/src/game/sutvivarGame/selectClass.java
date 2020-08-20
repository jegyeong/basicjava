package game.sutvivarGame;

import java.util.Scanner;

public class selectClass {

	boolean start = false;
	Scanner c = new Scanner(System.in);
	void select() {
		FIgthClass f = FIgthClass.getInstance();
		Character1 c1 = Character1.getInstance();
		Character2 c2 = Character2.getInstance();
		Character3 c3 = new Character3();

		int choice = 0;
		// 공격은 갖고 있는 포인트가 없어진다.
		System.out.println("캐릭터를 생성해주세요.");
		System.out.println("1.박정민 (정보 : 11)");
		System.out.println("2.김준우 (정보 : 22)");
		System.out.println("3.박기완 (정보 : 33)");

		while (start == false) {

			
			int choose = c.nextInt();
			switch (choose) {
			case 1:
				choice = 1;
				start = true;
				break;
			case 11:
				c1.info();

				break;
			case 2:
				choice = 2;
				start = true;
				break;
			case 22:
				c2.info();
				break;
			case 3:
				choice = 3;
				start = true;
				break;
			case 33:
				c3.info();
				break;
			}
		}

		if (choice == 1) { // 유저 a가 캐릭터를 선택했을때
			f.a_char = choice;
			f.a_health = c1.health;
			f.a_maxhp = c1.health;
			f.a_attack = c1.power;
			f.a_point = c1.point;
			f.a_skillpoint = c1.skillpoint;

			System.out.println("박정민을 고르셨습니다!!");
		}
		if (choice == 2) {
			f.a_char = choice;
			f.a_health = c2.health;
			f.a_maxhp = c2.health;
			f.a_attack = c2.power;
			f.a_point = c2.point;
			f.a_skillpoint = c2.skillpoint;

			System.out.println("김준우을 고르셨습니다.");
		}
		if (choice == 3) {
			f.a_char = choice;
			f.a_health = c3.health;
			f.a_maxhp = c3.health;
			f.a_attack = c3.power;
			f.a_point = c3.point;
			f.a_skillpoint = c3.skillpoint;

			System.out.println("박기완을 고르셨습니다.");
		}

		start = false;

		System.out.println("컴퓨터가 캐릭터를 고르고 있습니다.");
		int choice2 = 0;
		while (start == false) {

			int random = (int) (Math.random() * 1) + 1;
			switch (random) {
			case 1:
				choice2 = 1;
				start = true;
				break;
			case 11:
				c1.info();

				break;

			}
		}

		if (choice2 == 1) {
			f.b_char = choice2;
			f.b_health = c1.health;
			f.b_maxhp = c1.health;
			f.b_attack = c1.power;
			f.b_point = c1.point;
			f.b_skillpoint = c1.skillpoint;

			System.out.println("박정민을 고르셨습니다.");
		}
		if (choice2 == 2) {
			f.b_char = choice2;
			f.b_health = c2.health;
			f.b_maxhp = c2.health;
			f.b_attack = c2.power;
			f.b_point = c2.point;
			f.b_skillpoint = c2.skillpoint;

			System.out.println("김준우을 고르셨습니다.");
		}
		if (choice2 == 3) {
			f.b_char = choice;
			f.b_health = c3.health;
			f.b_maxhp = c3.health;
			f.b_attack = c3.power;
			f.b_point = c3.point;
			f.b_skillpoint = c3.skillpoint;

			System.out.println("김기완을 고르셨습니다.");
		}

	}
}
