package e_oop;

import java.util.Scanner;

public class Soccer {
	int ball; // 한국 볼 //일본 볼
	int kscore; // 한국 점수
	int jscore; // 일본 점수
	int random70; //
	int random40;
	int shot;
	int defend;
	int random70d;
	int random40d;
	int exit;
	Scanner s = new Scanner(System.in);

	Soccer() {
		ball = 3;
		kscore = 0;
		jscore = 0;
		random70 = 0;
		random40 = 0;
		shot = 0;
		defend = 0;
		random70d = 0;
		random40d = 0;
		exit = 0;

	}

	void kball0() {
		ball = 0;
		System.out.println("한국 골키퍼 조현우 " + ball + " 이 공을 갖고 있습니다.");
		System.out.println("ShortPass(70%확률로 한국 수비수 1에게 패스)/ "
				+ "LongPass(40%확률로 한국 미드필더 2에게 패스)★LongPass실패시 -1★");
		System.out.println("ShortPass하시려면 S/ " + "LongPass하시려면 L 을 누르세요");
		String answer = s.nextLine().trim();
		while(true){
		if (answer.equalsIgnoreCase("s")) {
			random70();
			if (ball == 2) {
				kball1();
			} else if (ball == -1) {
				jball6();
			}
		} else if (answer.equalsIgnoreCase("l")) {
			random40();
			if (ball == 2) {
				kball2();
			} else if (ball == -1) {
				shot();
			}
		}else{
			System.out.println("다시 입력하세요.");
		}
	}
	}

	void kball1() {
		ball = 1;
		System.out.println("한국 수비수 " + ball + " 이 공을 갖고 있습니다.");
		System.out.println("ShortPass(70%확률로 한국 수비수 2에게 패스)/ "
				+ "LongPass(40%확률로 한국 미드필더 3에게 패스)★LongPass실패시 -1★");
		System.out.println("ShortPass하시려면 S/ " + "LongPass하시려면 L 을 누르세요");
		String answer = s.nextLine().trim();
		while(true){
		if (answer.equalsIgnoreCase("s")) {
			random70();
			if (ball == 3) {
				kball2();
			} else if (ball == 0) {
				jball5();
			}
		} else if (answer.equalsIgnoreCase("l")) {
			random40();
			if (ball == 3) {
				kball3();
			} else if (ball == 0) {
				jball6();
			}
		}
		else{
			System.out.println("다시 입력하세요.");
		}
	}
	}

	void kball2() {
		ball = 2;
		System.out.println("한국 수비수 " + ball + " 이 공을 갖고 있습니다.");
		System.out.println("ShortPass(70%확률로 한국 수비수 3에게 패스)/ "
				+ "LongPass(40%확률로 한국 미드필더 4에게 패스)★LongPass실패시 -1★");
		System.out.println("ShortPass하시려면 S/ " + "LongPass하시려면 L 을 누르세요");
		String answer = s.nextLine().trim();
		while(true){
		if (answer.equalsIgnoreCase("s")) {
			random70();
			if (ball == 4) {
				kball3();
			} else if (ball == 1) {
				jball4();
			}
		} else if (answer.equalsIgnoreCase("l")) {
			random40();
			if (ball == 4) {
				kball4();
			} else if (ball == 1) {
				jball5();
			}
		}else{
			System.out.println("다시 입력하세요.");
		}
	}
	}

	void kball3() {
		ball = 3;
		System.out.println("한국 미드필더 " + ball + " 이 공을 갖고 있습니다.");
		System.out.println("ShortPass(70%확률로 한국 미드필더 4에게 패스)/ "
				+ "LongPass(40%확률로 한국 미드필더 5에게 패스)★LongPass실패시 -1★");
		System.out.println("ShortPass하시려면 S/ " + "LongPass하시려면 L 을 누르세요");
		String answer = s.nextLine().trim();
		while(true){
		if (answer.equalsIgnoreCase("s")) {
			random70();
			if (ball == 5) {
				kball4();
			} else if (ball == 2) {
				jball3();
			}
		} else if (answer.equalsIgnoreCase("l")) {
			random40();
			if (ball == 5) {
				kball5();
			} else if (ball == 2) {
				jball4();
			}
		}else{
			System.out.println("다시 입력하세요.");
		}
	}
	}

	void kball4() {
		ball = 4;
		System.out.println("한국 미드필더 " + ball + " 이 공을 갖고 있습니다.");
		System.out.println("ShortPass(70%확률로 한국 미드필더 5에게 패스)/ "
				+ "LongPass(40%확률로 한국 미드필더 6에게 패스)★LongPass실패시 -1★");
		System.out.println("ShortPass하시려면 S/ " + "LongPass하시려면 L 을 누르세요");
		String answer = s.nextLine().trim();
		while(true){
		if (answer.equalsIgnoreCase("s")) {
			random70();
			if (ball == 6) {
				kball5();
			} else if (ball == 3) {
				jball2();
			}
		} else if (answer.equalsIgnoreCase("l")) {
			random40();
			if (ball == 6) {
				kball6();
			} else if (ball == 3) {
				jball3();
			}
		}else{
			System.out.println("다시 입력하세요.");
		}
	}
	}

	void kball5() {
		ball = 5;
		System.out.println("한국 공격수 " + ball + " 이 공을 갖고 있습니다.");
		System.out.println("ShortPass(70%확률로 한국 미드필더 6에게 패스)/ "
				+ "LongPass(40%확률로 슈팅 성공)★LongPass실패시 -1★");
		System.out.println("ShortPass하시려면 S/ " + "LongPass하시려면 L 을 누르세요");
		String answer = s.nextLine().trim();
		while(true){
		if (answer.equalsIgnoreCase("s")) {
			random70();
			if (ball == 7) {
				kball6();
			} else if (ball == 4) {
				jball1();
			}
		} else if (answer.equalsIgnoreCase("l")) {
			random40();
			if (ball == 7) {
				shot();
			} else if (ball == 4) {
				jball2();
			}
		}else{
			System.out.println("다시 입력하세요.");
		}
	}
	}

	void kball6() {
		ball = 6;
		System.out.println("한국 공격수 손흥민 " + ball + " 이 공을 갖고 있습니다.");
		System.out.println("LSHOT(50%확률로 골)/ " + "RSHOT(50%확률로 골)");
		System.out.println("LSHOT하시려면 L/ " + "RSHOT하시려면 R 을 누르세요");
		String answer = s.nextLine().trim();
		while(true){
		if (answer.equalsIgnoreCase("r")) {
			shot();
			if (ball == 7) {
				shot();
			} else if (ball == 5) {
				jball0();
			}
		} else if (answer.equalsIgnoreCase("l")) {
			shot();
			if (ball == 7) {
				shot();
			} else if (ball == 5) {
				jball1();
			}
		}else{
			System.out.println("다시 입력하세요.");
		}
	}
	}

	// ------------------------------------------------
	void jball0() {
		while(true){
		ball = 0;
		System.out.println("일본 골키퍼 " + ball + " 이 공을 갖고 있습니다.");
		System.out
				.println("PhysicalFight(40%확률로 한국 공격수 손흥민 6가 공을 뺏음)★PhysicalFight실패시-1★/ "
						+ "BackTackle(70%확률로 한국 공격수 손흥민 6가 공을 뺏음)★BackTackle실패시 -2★");
		System.out.println("PhysicalFight하시려면 P/ " + "BackTackle하시려면 B 을 누르세요");
		String answer = s.nextLine().trim();
		if (answer.equalsIgnoreCase("B")) {
			random70d();
			if (ball == 1) {
				kball6();
			} else if (ball == -1) {
				jball1();
			}
		} else if (answer.equalsIgnoreCase("P")) {
			random40d();
			if (ball == 3) {
				kball6();
			} else if (ball == -1) {
				jball2();
			}
		}else{
			System.out.println("다시 입력하세요.");
		}

	}}

	void jball1() {
		ball = 1;
		System.out.println("일본 수비수 " + ball + " 이 공을 갖고 있습니다.");
		System.out
				.println("PhysicalFight(40%확률로 한국 공격수 5가 공을 뺏음)★PhysicalFight실패시-1★/ "
						+ "BackTackle(70%확률로 한국 공격수 5가 공을 뺏음)★BackTackle실패시 -2★");
		System.out.println("PhysicalFight하시려면 P/ " + "BackTackle하시려면 B 을 누르세요");
		String answer = s.nextLine().trim();
		while(true){
		if (answer.equalsIgnoreCase("B")) {
			random70d();
			if (ball == 2) {
				kball5();
			} else if (ball == 0) {
				jball2();
			}
		} else if (answer.equalsIgnoreCase("P")) {
			random40d();
			if (ball == 3) {
				kball5();
			} else if (ball == 0) {
				jball3();
			}
		}else{
			System.out.println("다시 입력하세요.");
		}

	}}

	void jball2() {
		ball = 2;
		System.out.println("일본 수비수 " + ball + " 이 공을 갖고 있습니다.");
		System.out
				.println("PhysicalFight(40%확률로 한국 미드필더 4가 공을 뺏음)★PhysicalFight실패시-1★/ "
						+ "BackTackle(70%확률로 한국 미드필더 4가 공을 뺏음)★BackTackle실패시 -2★");
		System.out.println("PhysicalFight하시려면 P/ " + "BackTackle하시려면 B 을 누르세요");
		String answer = s.nextLine().trim();
		while(true){
		if (answer.equalsIgnoreCase("B")) {
			random70d();
			if (ball == 3) {
				kball4();
			} else if (ball == 1) {
				jball3();
			}
		} else if (answer.equalsIgnoreCase("P")) {
			random40d();
			if (ball == 4) {
				kball4();
			} else if (ball == 1) {
				jball4();
			}
		}else{
			System.out.println("다시 입력하세요.");
		}
	}
	}

	void jball3() {
		ball = 3;
		System.out.println("일본 미드필더 " + ball + " 이 공을 갖고 있습니다.");
		System.out
				.println("PhysicalFight(40%확률로 한국 미드필더 3가 공을 뺏음)★PhysicalFight실패시-1★/ "
						+ "BackTackle(70%확률로 한국 미드필더 3가 공을 뺏음)★BackTackle실패시 -2★");
		System.out.println("PhysicalFight하시려면 P/ " + "BackTackle하시려면 B 을 누르세요");
		String answer = s.nextLine().trim();
		while(true){
		if (answer.equalsIgnoreCase("B")) {
			random70d();
			if (ball == 4) {
				kball3();
			} else if (ball == 2) {
				jball4();
			}
		} else if (answer.equalsIgnoreCase("P")) {
			random40d();
			if (ball == 5) {
				kball3();
			} else if (ball == 2) {
				jball5();
			}
		}else{
			System.out.println("다시 입력하세요.");
		}
	}
	}

	void jball4() {
		ball = 4;
		System.out.println("일본 미드필더 " + ball + " 이 공을 갖고 있습니다.");
		System.out
				.println("PhysicalFight(40%확률로 한국 수비수 2가 공을 뺏음)★PhysicalFight실패시-1★/ "
						+ "BackTackle(70%확률로 한국 수비수 2가 공을 뺏음)★BackTackle실패시 -2★");
		System.out.println("PhysicalFight하시려면 P/ " + "BackTackle하시려면 B 을 누르세요");
		String answer = s.nextLine().trim();
		while(true){
		if (answer.equalsIgnoreCase("B")) {
			random70d();
			if (ball == 5) {
				kball2();
			} else if (ball == 3) {
				jball5();
			}
		} else if (answer.equalsIgnoreCase("P")) {
			random40d();
			if (ball == 6) {
				kball2();
			} else if (ball == 3) {
				jball6();
			}
		}else{
			System.out.println("다시 입력하세요.");
		}
	}
	}

	void jball5() {
		ball = 5;
		System.out.println("일본 공격수 " + ball + " 이 공을 갖고 있습니다.");
		System.out
				.println("PhysicalFight(40%확률로 한국 수비수 1가 공을 뺏음)★PhysicalFight실패시-1★/ "
						+ "BackTackle(70%확률로 한국 수비수 1가 공을 뺏음)★BackTackle실패시 실점★");
		System.out.println("PhysicalFight하시려면 P/ " + "BackTackle하시려면 B 을 누르세요");
		String answer = s.nextLine().trim();
		while(true){
		if (answer.equalsIgnoreCase("B")) {
			random70d();
			if (ball == 6) {
				kball1();
			} else if (ball == 4) {
				jball6();
			}
		} else if (answer.equalsIgnoreCase("P")) {
			random40d();
			if (ball == 7) {
				kball1();
			} else if (ball == 4) {
				defend();
			}
		}else{
			System.out.println("다시 입력하세요.");
		}
	}
	}

	void jball6() {
		ball = 6;
		System.out.println("일본 공격수 " + ball + " 이 공을 갖고 있습니다.");
		System.out.println("Rdefend(50%확률로 한국 골키퍼 0가 공을 막음)★defend실패시-1점★/ "
				+ "Ldefend(50%확률로 한국 골키퍼0가 공을 막음)★defend실패시 -1점★");
		System.out.println("Rdefend하시려면 R/ " + "Ldefend하시려면 L 을 누르세요");
		String answer = s.nextLine().trim();
		while(true){
		if (answer.equalsIgnoreCase("R")) {
			defend();
			if (ball == 7) {
				kball1();
			} else if (ball == 5) {
				defend();
			}
		} else if (answer.equalsIgnoreCase("L")) {
			defend();
			if (ball == 7) {
				kball1();
			} else if (ball == 5) {
				defend();
			}
		}else{
			System.out.println("다시 입력하세요.");
		}
	}
	}

	// -------------------------------------------
	void random70d() {
		int[] probability = new int[10];
		for (int i = 0; i < probability.length; i++) {
			probability[i] = (int) (Math.random() * 10) + 1;
		}

		if (probability[1] < 8) {
			System.out.println("막기 성공!");
			++ball;

		} else {
			System.out.println("막기 실패!");
			--ball;
		}
	}

	void random40d() {
		int[] probability = new int[10];
		for (int i = 0; i < probability.length; i++) {
			probability[i] = (int) (Math.random() * 10) + 1;
		}

		if (probability[1] < 5) {
			System.out.println("막기 성공!");
			ball += 2;
		} else {
			System.out.println("막기 실패!");
			--ball;
		}

	}

	void random70() {
		int[] probability = new int[10];
		for (int i = 0; i < probability.length; i++) {
			probability[i] = (int) (Math.random() * 10) + 1;
		}

		if (probability[1] < 8) {
			System.out.println("패스 성공!");
			ball += 2;

		} else {
			System.out.println("패스 실패!");
			--ball;
		}
	}

	void random40() {
		int[] probability = new int[10];
		for (int i = 0; i < probability.length; i++) {
			probability[i] = (int) (Math.random() * 10) + 1;
		}

		if (probability[1] < 5) {
			System.out.println("패스 성공!");
			ball += 2;
		} else {
			System.out.println("패스 실패!");
			--ball;
		}

	}

	void shot() {
		int[] probability = new int[10];
		for (int i = 0; i < probability.length; i++) {
			probability[i] = (int) (Math.random() * 10) + 1;
		}
		if (probability[1] < 6) {
			System.out.println("GOOL!");
			++ball;
			++kscore;
		} else {
			System.out.println("NO GOOL...");
			--ball;
		}
		System.out.println("한국:" + kscore + "일본:" + jscore);

		if (kscore == 3) {

			exit();
		}
		kball3();
	}

	void exit() {
		System.exit(0);
	}

	void defend() {
		int[] probability = new int[10];
		for (int i = 0; i < probability.length; i++) {
			probability[i] = (int) (Math.random() * 10) + 1;
		}
		if (probability[1] < 6) {
			System.out.println("실점!");
			++ball;
			++jscore;
		} else {
			System.out.println("방어성공");
			--ball;
		}
		System.out.println("한국:" + kscore + "일본:" + jscore);

		if (jscore == 3) {
			exit();
			kball3();
		}
	}

	public static void main(String[] args) {
		Soccer sss = new Soccer();
		sss.kball3();

	}

}
