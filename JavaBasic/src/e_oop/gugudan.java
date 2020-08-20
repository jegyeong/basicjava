package e_oop;

import java.util.*;

public class gugudan {

	// 구구단 10문제 맞추기
	// 난이도를 선택할수있고 정답을 맞춘횟수를 마지막에 출력합니다.
	// 게임을 종료할것인지 아닌지를 선택하고 다시 게임을 실행한다면 난이도부터 다시 선택할수있도록 설정

	 

		public static void main(String[] args) {

			int a, b;

			int count = 0;

			boolean stop = false;

			Scanner s = new Scanner(System.in);

			while (!stop) {

				System.out.println();
				System.out.println("난이도를 입력하세요 > (1.쉬움 2.보통 3.어려움)");

				String in = s.nextLine();
	 
				if (in.equals("1")) {

					for (int i = 0; i <= 10; i++) {

						a = (int) (Math.random() * 9) + 1;
						b = (int) (Math.random() * 9) + 1;

						int num = a * b;
 
						System.out.println();
						System.out.println(a + "단 문제 \t");

						System.out.println(a + " * " + b + " = ");

						System.out.print("답 > ");

						int input = Integer.parseInt(s.nextLine());
						if (num == input) {

							System.out.println("정답");

							count++;

						} else {

							System.out.println("오답! 정답은 " + num + "입니다.");

						}

					}

	 

					System.out.println();
					System.out.println("총 10문제중에" + count + "문제 맞았습니다.");
					System.out.println();
					System.out.println("계속 하시겠습니까? (Y/N)");

					String in2 = s.nextLine();

					if (in2.equalsIgnoreCase("y")) {

						continue;

					} else if (in2.equalsIgnoreCase("n")) {

						System.out.println("게임을 종료합니다.");

						break;

					}

	 

				}

	 

				else if (in.equals("2")) {

					for (int i = 0; i <= 10; i++) {

						a = (int) (Math.random() * 99) + 1;
						b = (int) (Math.random() * 9) + 1;
	 
						int num = a * b;

	 					System.out.println();
						System.out.println(a + "단 문제 \t");
						System.out.println(a + " * " + b + " = ");
						System.out.print("답 > ");

						int input = Integer.parseInt(s.nextLine());

	 

						if (num == input) {
							System.out.println("정답");
							count++;

						} else {
							System.out.println("오답! 정답은 " + num + "입니다.");

						}

					}

	 				System.out.println();
					System.out.println("총 10문제중에" + count + "문제 맞았습니다.");
					System.out.println();
					System.out.println("계속 하시겠습니까? (Y/N)");
					String in2 = s.nextLine();

					if (in2.equalsIgnoreCase("y")) {

						continue;

					} else if (in2.equalsIgnoreCase("n")) {

						System.out.println("게임을 종료합니다.");

						break;

					}

				}

	 

				else if (in.equals("3")) {

					for (int i = 0; i <= 10; i++) {
						a = (int) (Math.random() * 99) + 1;
						b = (int) (Math.random() * 99) + 1;

						int num = a * b;

						System.out.println();
						System.out.println(a + "단 문제 \t");
						System.out.println(a + " * " + b + " = ");
						System.out.print("답 > ");

						int input = Integer.parseInt(s.nextLine());

						if (num == input) {
							System.out.println("정답");
							count++;

						} else {
							System.out.println("오답! 정답은 " + num + "입니다.");

						}

					} 

					System.out.println();
					System.out.println("총 10문제중에" + count + "문제 맞았습니다.");
					System.out.println();
					System.out.println("계속 하시겠습니까? (Y/N)");
					String in2 = s.nextLine();

					if (in2.equalsIgnoreCase("y")) {

						continue;

					} else if (in2.equalsIgnoreCase("n")) {

						System.out.println("게임을 종료합니다.");

						break;

					}				

				}

			}

		}

}
