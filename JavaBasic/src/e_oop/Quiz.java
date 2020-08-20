package e_oop;

import java.util.Scanner;

public class Quiz {

	Scanner s = new Scanner(System.in);
	String name = "이혁진";

	void q1() {
		System.out
				.println("1 번 : 유교의 도덕적 사상에서 기본이 되는 3가지의 강령과 5가지의 인륜을 무엇이라 할까요? [3가지의 도리 / 5가지의 덕목]");
		String answer = s.nextLine();
		if (answer.equals("삼강오륜")) {
			q2();
		} else {
			System.out.println(name + "씨 탈락입니다. 다시 도전하겠습니까?(Y/N)");
			answer = s.nextLine();

			if (answer.equalsIgnoreCase("Y")) {
				q1();
			} else {
				System.out.println(name +"씨 수고하셨습니다.");
			}
		}

	}

	void q2() {
		System.out
				.println("2 번 : 미국 캘리포니아주 남서부 애너하임에 위치해 있는 세계적인 유원지이자, 대규모의 오락시설인 이곳은 어디일까요?");
		String answer = s.nextLine();
		if (answer.equals("디즈니랜드")) {
			q3();
		} else {
			System.out.println(name + "씨 탈락입니다. 다시 도전하겠습니까?(Y/N)");
			answer = s.nextLine();
			if (answer.equalsIgnoreCase("Y")) {
				q2();
			} else {
				System.out.println(name +"씨 수고하셨습니다.");
			}

		}

	}

	void q3() {
		System.out.println("3 번(넌센스) : 세상에서 가장 잘 깨지는 창문의 이름은 무엇일까요? ");
		String answer = s.nextLine();
		if (answer.equals("와장창")) {
			q4();
		} else {
			System.out.println(name + "씨 탈락입니다. 다시 도전하겠습니까?(Y/N)");
			answer = s.nextLine();
			if (answer.equalsIgnoreCase("Y")) {
				q3();
			} else {
				System.out.println(name +"씨 수고하셨습니다.");
			}

		}

	}

	void q4() {
		System.out
				.println("4 번 : 한 입 크기로 만든 중국의 만두로 3,000년 전 부터 중국 남부 광둥(광동)지방에서 만들어 먹기 시작한 이것은 무엇일까요?");
		String answer = s.nextLine();
		if (answer.equals("딤섬")) {
			q5();
		} else {
			System.out.println(name + "씨 탈락입니다. 다시 도전하겠습니까?(Y/N)");
			answer = s.nextLine();
			if (answer.equalsIgnoreCase("Y")) {
				q4();
			} else {
				System.out.println(name +"씨 수고하셨습니다.");
			}

		}

	}

	void q5() {
		System.out
				.println("5 번 : 서울특별시 광진구 자양동과 송파구 신천동을 잇는 한강의 다리이며, 1972년 7월에 준공 하였습니다 이곳은 어디일까요?");
		String answer = s.nextLine();
		if (answer.equals("잠실대교")) {
			q6();
		} else {
			System.out.println(name + "씨 탈락입니다. 다시 도전하겠습니까?(Y/N)");
			answer = s.nextLine();
			if (answer.equalsIgnoreCase("Y")) {
				q5();
			} else {
				System.out.println(name +"씨 수고하셨습니다.");
			}

		}

	}

	void q6() {
		System.out
				.println("6 번 : 흉측한 얼굴을 가면으로 가린 괴신사가 아름다운 프리마돈나를 짝사랑하는 내용이 담긴 이 뮤지컬의 이름은 무엇일까요?");
		String answer = s.nextLine();
		if (answer.equals("오페라의유령")) {
			q7();
		} else {
			System.out.println(name + "씨 탈락입니다. 다시 도전하겠습니까?(Y/N)");
			answer = s.nextLine();
			if (answer.equalsIgnoreCase("Y")) {
				q6();
			} else {
				System.out.println(name +"씨 수고하셨습니다.");
			}

		}

	}

	void q7() {
		System.out
				.println("7 번 :한국 청동기 시대의 대표적인 무덤 양식으로, 지석묘라고도 불리는 이것은 무엇일까요?");
		String answer = s.nextLine();
		if (answer.equals("고인돌")) {
			q8();
		} else {
			System.out.println(name + "씨 탈락입니다. 다시 도전하겠습니까?(Y/N)");
			answer = s.nextLine();
			if (answer.equalsIgnoreCase("Y")) {
				q7();
			} else {
				System.out.println(name +"씨 수고하셨습니다.");
			}

		}

	}

	void q8() {
		System.out.println("8 번(넌센스) :사람의 몸무게가 가장 많이 나갈 때는 언제일까요?");
		String answer = s.nextLine();
		if (answer.equals("철들때")) {
			q9();
		} else {
			System.out.println(name + "씨 탈락입니다. 다시 도전하겠습니까?(Y/N)");
			answer = s.nextLine();
			if (answer.equalsIgnoreCase("Y")) {
				q8();
			} else {
				System.out.println(name +"씨 수고하셨습니다.");
			}

		}

	}

	void q9() {
		System.out.println("9 번 : 대한민국에서 면적이 가장 큰 지역은 어디일까요?");
		String answer = s.nextLine();
		if (answer.equals("경상북도")) {
			q10();
		} else {
			System.out.println(name + "씨 탈락입니다. 다시 도전하겠습니까?(Y/N)");
			answer = s.nextLine();
			if (answer.equalsIgnoreCase("Y")) {
				q9();
			} else {
				System.out.println(name +"씨 수고하셨습니다.");
			}

		}

	}

	void q10() {
		System.out.println("10 번 : 옛 조선시대에서 '얼음'을 관리하던 관아(부서)의 이름은 무엇일까요?");
		String answer = s.nextLine();
		if (answer.equals("빙고")) {
			win();
		} else {
			System.out.println(name + "씨 탈락입니다. 다시 도전하겠습니까?(Y/N)");
			answer = s.nextLine();
			if (answer.equalsIgnoreCase("Y")) {
				q10();
			} else {
				System.out.println(name +"씨 수고하셨습니다.");
			}
		}

	}

	void win() {
		System.out.println(name + "씨 축하드립니다!! 모든 문제를 풀었습니다!!!");

	}

	public static void main(String[] args) {

		Quiz q = new Quiz();
		q.q1();
	}

}
