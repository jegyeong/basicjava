package e_oop;

import java.util.Scanner;

public class Tomato {

	int water;// 물
	int sun;// 햇빛
	int wind;// 바람

	Tomato() {
		water = 0;
		sun = 0;
		wind = 0;
	}

	void waterUp() {
		if (water < 10) {
			water++;
		}else{
			System.out.println("물이 최대치입니다");
		}
	}

	void waterDown() {
		if (water > 0) {
			water--;
		}else{
			System.out.println("물이 없습니다");
		}
	}

	void sunUp() {
		if (sun < 10) {
			sun++;
		}else{
			System.out.println("햇빛이 최대치입니다");
		}
	}

	void sunDown() {
		if (sun > 0) {
			sun--;
		}else{
			System.out.println("어둠 입니다");
		}
	}

	void windUp() {
		if (wind < 10) {
			wind++;
		}else{
			System.out.println("바람이 최대치입니다");
		}
	}

	void windDown() {
		if (wind > 0) {
			wind--;
		}else{
			System.out.println("바람이 없습니다");
		}
	}

	public static void main(String[] args) {

		Tomato tomato = new Tomato();

		int comWater, comSun, comWind;
		comWater = (int) (Math.random() * 9) + 1;

		do {
			comSun = (int) (Math.random() * 9) + 1;

		} while (comWater == comSun);

		do {
			comWind = (int) (Math.random() * 9) + 1;
		} while (comWind == comWater || comWind == comSun);

		System.out.println("맛있는 토마토가 나오는  물의 조건 : " + comWater);
		System.out.println("맛있는 토마토가 나오는  햇빛의 조건 :" + comSun);
		System.out.println("맛있는 토마토가 나오는 바람의 조건 : " + comWind);
		System.out.println("---------------------------------");


		
		System.out.println("1.물 +\n2.물-\n3.햇빛+\n4.햇빛-\n5.바람+\n6.바람-\n7.영양분공급을 마칩니다.");
		System.out.println("영양분을 공급해주세요");

		Scanner sc = new Scanner(System.in);

		do {
			int input = sc.nextInt();

			switch (input) {

			case 1:
				tomato.waterUp();
				System.out.println("물의 수량: " + tomato.water);
				break;
			case 2:
				tomato.waterDown();
				System.out.println("물의 수량" + tomato.water);
				break;
			case 3:
				tomato.sunUp();
				System.out.println("햇빛의 일조량" + tomato.sun);
				break;
			case 4:
				tomato.sunDown();
				System.out.println("햇빛의 일조량" + tomato.sun);
				break;
			case 5:
				tomato.windUp();
				System.out.println("바람의 세기" + tomato.wind);
				break;
			case 6:
				tomato.windDown();
				System.out.println("바람의 세기" + tomato.wind);
				break;
			case 7:
				System.out.println("영양분 공급을 마칩니다.");
				if (comWater == tomato.water && comSun == tomato.sun && comWind == tomato.wind) {
					System.out.println("맛있는 토마토가 자랐습니다.");
				} else {
					System.out.println("영양분이 부족해 토마토가 죽었습니다 ㅠㅠ");
				}
			
				break;
			}
		} while (true);

		
	}
}
