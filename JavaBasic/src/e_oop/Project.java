package e_oop;

import java.util.Arrays;
import java.util.Scanner;

public class Project {
	// 학생정보 테이블
	// 석차 출력
	// 입력된 학생들 의 성적 출력
	// 선택출력
	// 학생 성적 정보 입력하기
	Scanner scan = new Scanner(System.in);
	String[] name = { "임수진", "박혜진", "강현철", "김종완", "박기완", "김준우", "이혁진", "심주영" };
	String[] subject = { "java", "Oracle", "HTML", "CSS", "JQuery", "JSP" };
	double[][] score = new double[name.length][subject.length + 3];

	Project() {
		{
			for (int i = 0; i < name.length; i++) {
				for (int j = 0; j < subject.length; j++) {
					score[i][j] = (int) (Math.random() * 100) + 1;
					score[i][6] += score[i][j];
				}
				score[i][7] = (int) (score[i][6] / subject.length * 100 + 0.5) / 100.0;
				score[i][8] = 1;
			}
		}
	}

	int count_null() {
		int pos = 0;
		for (int i = 0; i < name.length; i++) {
			if (name[i] == null) {
				pos = name.length - i;
				break;
			}
		}
		return pos;
	}

	void searchName() {
		int pos = count_null();
		System.out.print("학생의 이름을 입력해주세요. : ");
		String searchName = scan.nextLine().trim();
		boolean[] searchData = new boolean[name.length];
		int count = 0;
		for (int i = 0; i < name.length - pos; i++) {
			if (name[i].equals(searchName)) {
				searchData[i] = true;
				count++;
			} else
				searchData[i] = false;

		}
		if (count >= 1) {
			System.out.print("이름\t");
			for (int j = 0; j < subject.length; j++) {
				System.out.print(subject[j] + "\t");
			}
			System.out.println("총합\t평균");
			for (int i = 0; i < name.length; i++) {
				if (searchData[i] == true) {
					System.out.print(name[i] + "\t");
					for (int j = 0; j < subject.length + 1; j++) {
						System.out.print((int) score[i][j] + "\t");
					}
					System.out.println(score[i][subject.length + 1] + "\t");
				}
			}
		} else {
			System.out.println(searchName + "의 학생은 존재하지않습니다.");
		}
	}

	void partSort() {
		System.out.println("과목번호를 선택해주세요.");
		for (int i = 0; i < subject.length; i++)
			System.out.println((i + 1) + ". " + subject[i]);
		double[][] sort = new double[name.length + 1][2];
		String[] copyName = new String[name.length];

		int menu = Integer.parseInt(scan.nextLine());

		if (menu >= 1 && menu <= 6) {
			for (int i = 0; i < name.length; i++) {
				sort[i][1] = score[i][menu - 1];
				sort[name.length][1] += sort[i][1];
				sort[i][0] = 1;
				copyName[i] = name[i];
			}

			sort[name.length][1] = (int) (sort[name.length][1] / name.length
					* 100 + 0.5) / 100.0;

			for (int i = 0; i < name.length; i++) {
				for (int j = 0; j < name.length; j++) {
					if (sort[i][0] < sort[j][0]) {
						sort[i][0] += 1.0;
					}
					if (j != i && sort[i][0] == sort[j][0])
						sort[j][0] += 1.0;
				}
			}

			for (int i = 0; i < name.length - 1; i++) {
				boolean changed = false;
				for (int j = 0; j < name.length - i - 1; j++) {
					if (sort[j][0] > sort[j + 1][0]) {
						double[] double_temp = sort[j + 1];
						sort[j + 1] = sort[j];
						sort[j] = double_temp;
						String string_temp = copyName[j + 1];
						copyName[j + 1] = copyName[j];
						copyName[j] = string_temp;
					}
				}
				if (!changed)
					break;
			}
			int pos = count_null();

			System.out
					.println("--------------------------------------------------------------------------------");
			System.out.println("석차\t이름\t" + subject[menu - 1]);
			for (int i = 0; i < sort.length - 1 - pos; i++) {
				System.out.println((int) sort[i][0] + "\t" + copyName[i] + "\t"
						+ (int) sort[i][1]);
			}
			System.out.println("평균 점수 : " + sort[name.length][1]);
		}

		System.out
				.println("--------------------------------------------------------------------------------");
	}

	void printAll() {
		int pos = count_null();

		System.out
				.println("--------------------------------------------------------------------------------");
		System.out.print("이름\t");
		for (int i = 0; i < subject.length; i++) {
			System.out.print(subject[i] + "\t");
		}
		System.out.println("총합\t평균");
		for (int i = 0; i < name.length - pos; i++) {
			System.out.print(name[i] + "\t");
			for (int j = 0; j < subject.length + 1; j++) {
				System.out.print((int) score[i][j] + "\t");
			}
			System.out.println(score[i][subject.length + 1] + "\t");
		}
		System.out
				.println("--------------------------------------------------------------------------------");
	}

	void printSort() {
		double[][] copyScore = new double[name.length][subject.length + 3];
		String[] copyName = new String[name.length];

		int pos = 0;
		for (int i = 0; i < name.length; i++) {
			copyName[i] = name[i];
			for (int j = 0; j < subject.length + 3; j++) {
				copyScore[i][j] = score[i][j];
			}
		}

		for (int i = 0; i < name.length; i++) {
			if (copyName[i] == null) {
				pos = name.length - i;
				break;
			}
		}

		for (int i = 0; i < name.length - pos; i++) {
			for (int j = 0; j < name.length - pos; j++) {
				if (copyScore[i][6] < copyScore[j][6]) {
					copyScore[i][8] += 1.0;
				}
				if (j != i && copyScore[i][6] == copyScore[j][6])
					copyScore[j][8] += 1.0;
			}
		}

		for (int i = 0; i < name.length - 1 - pos; i++) {
			boolean changed = false;
			for (int j = 0; j < name.length - i - 1 - pos; j++) {
				if (copyScore[j][8] > copyScore[j + 1][8]) {
					double[] double_temp = copyScore[j + 1];
					copyScore[j + 1] = copyScore[j];
					copyScore[j] = double_temp;

					String string_name = copyName[j + 1];
					copyName[j + 1] = copyName[j];
					copyName[j] = string_name;
					changed = true;

				}
			}
			if (!changed)
				break;
		}
		System.out
				.println("--------------------------------------------------------------------------------");
		System.out.print("석차\t이름");
		for (int i = 0; i < subject.length; i++) {
			System.out.print("\t" + subject[i]);
		}
		System.out.println("\t종합\t평균");
		for (int i = 0; i < name.length - pos; i++) {
			System.out.print((int) copyScore[i][8] + "\t" + copyName[i]);
			for (int j = 0; j < subject.length + 1; j++) {
				System.out.print("\t" + (int) copyScore[i][j]);
			}
			System.out.print("\t" + copyScore[i][7]);
			System.out.println();
		}
		System.out
				.println("--------------------------------------------------------------------------------");
	}

	void addStudent() {

		int pos = this.name.length;

		for (int i = 0; i < this.name.length; i++) {
			if (this.name[i] == (null)) {
				pos = i;
				break;
			}
		}

		if (this.name.length == pos) {
			String[] string_Temp = new String[this.name.length + 4];
			for (int i = 0; i < this.name.length; i++) {
				string_Temp[i] = this.name[i];
			}
			this.name = new String[string_Temp.length];
			for (int i = 0; i < this.name.length; i++) {
				this.name[i] = string_Temp[i];
			}

			double[][] int_Temp = new double[this.score.length + 4][subject.length + 3];
			for (int i = 0; i < this.score.length; i++) {
				for (int j = 0; j < this.subject.length + 3; j++) {
					int_Temp[i][j] = this.score[i][j];
				}
			}
			this.score = new double[int_Temp.length][subject.length + 3];
			for (int i = 0; i < this.score.length; i++) {
				for (int j = 0; j < this.subject.length + 3; j++) {
					this.score[i][j] = int_Temp[i][j];
				}
			}

		}
		System.out.print("학생의 이름을  입력하세요 :");
		this.name[pos] = scan.nextLine().trim();

		for (int i = 0; i < subject.length; i++) {
			boolean num = true;

			System.out.print(subject[i] + "의 점수를 입력해주세요.");
			this.score[pos][i] = Integer.parseInt(scan.nextLine().trim());
		}

		for (int i = 0; i < subject.length; i++) {
			this.score[pos][6] += this.score[pos][i];
		}

		this.score[pos][7] = (int) (this.score[pos][6] / subject.length * 100 + 0.5) / 100.0;
		this.score[pos][8] = 1;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Project pj = new Project();
		while (true) {
			System.out.println("메뉴를 선택하세요.");
			System.out.println("1. 학생추가");
			System.out.println("2. 전체출력");
			System.out.println("3. 전체석차출력");
			System.out.println("4. 부분석차출력");
			System.out.println("5. 이름검색");
			System.out.println("0. 종료");
			int menu = Integer.parseInt(scan.nextLine().trim());
			if (menu == 1) {
				pj.addStudent();
			} else if (menu == 2) {
				pj.printAll();
			} else if (menu == 3) {
				pj.printSort();
			} else if (menu == 4) {
				pj.partSort();
			} else if (menu == 5) {
				pj.searchName();
			} else if (menu == 0) {
				break;
			}
		}

	}

}
