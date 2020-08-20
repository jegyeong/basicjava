package e_oop;

import java.util.Scanner;

public class Test {
	void q1() {
		System.out.println("안경을 쓰고있다");

	}

	void q2() {
		System.out.println("성별은 여자이다");
	}

	void q3() {
		System.out.println("우엉차를 마신다");
	}

	void q4() {
		System.out.println("쌍커풀이 있다");
	}

	void q5() {
		System.out.println("라식을 했다");
	}

	public static void main(String[] args) {

		String comAnswer = "연지은"; // 컴터가 정한 값
		Scanner sc = new Scanner(System.in);
		// Test객체를 만들기
		Test t = new Test();

		t.q1();
		String userAnswer = sc.nextLine(); // 내가 입력하는 퀴즈 정답
		if (userAnswer.equals(comAnswer)) {
			System.out.println("정답입니다.");
			System.exit(0);
			// 정답을맞췃다
		} else {
			System.out.println("오답입니다");
		}

		t.q2();
		String userAnswer2 = sc.nextLine();
		if (userAnswer.equals("맞습니다.")) {
			System.out.println("정답입니다.");
			System.exit(0);
			// 정답을맞췃다
		} else {
			System.out.println("오답입니다");
		}
			

		t.q3();
		String userAnswer3 = sc.nextLine(); // 내가 입력하는 퀴즈 정답
		if (userAnswer3.equals(comAnswer)) {
			System.out.println("정답입니다.");
			System.exit(0);
			// 정답을맞췃다
		} else {
			System.out.println("오답입니다");
		}
		
		t.q4();
		String userAnswer4 = sc.nextLine();
		if (userAnswer4.equals(comAnswer)) {
			System.out.println();
			System.out.println("정답입니다.");
			System.exit(0);
		}
		
		t.q5();
		String userAnswer5 = sc.nextLine();
		if (userAnswer5.equals(comAnswer)) {
			System.out.println(t);
			System.out.println("정답입니다.");
			System.exit(0);
		}

		/*
		 * void a1(){ System.out.println("머리가 단발이다"(Y/N)"); String answer =
		 * s.nextLine(); if(answer.equals("Y")){q2();} else
		 * if(answer.equals("N")){q4();} }
		 */

	}
}
