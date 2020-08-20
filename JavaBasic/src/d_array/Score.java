package d_array;

public class Score {

	public static void main(String[] args) {
		/*
		 * 우리반 모두의 Java, Oracle, HTML, CSS, JQuery, JSP 점수를 50 ~ 100까지
		 * 랜덤으로 생성시켜주시고, 석차순으로 석차, 이름, 과목별 점수, 총점, 평균을 출력해주세요.
		 * 
		 * 석차	이름		Java	Oracle	HTML	CSS	JQuery	JSP	총점	평균
		 * 1	홍길동	80		90		100		90	70		60	500	80
		 * 2	홍길동	80		90		100		90	70		60	500	80
		 * 3	홍길동	80		90		100		90	70		60	500	80
		 * 4	홍길동	80		90		100		90	70		60	500	80
		 * 5	홍길동	80		90		100		90	70		60	500	80
		 */
		
		String[] students = {"박기완", "김준우", "이혁진", "남아름", "김우경", "전다희"};
		String[] subjects = {"Java", "Oracle", "HTML", "CSS", "JQuery", "JSP"};
		double[][] scores = new double[students.length][subjects.length + 3];
		
		//점수를 입력한다.
		for(int i = 0; i < scores.length; i++){
			scores[i][0] = 1;
			/*   석차, 과목별 점수,               총점, 평균
			 * { {1, 50, 100, 80, 50, 100, 80, 0, 0}
			 * , {1, 50, 100, 80, 50, 100, 80, 0, 0} 
			 * , {1, 50, 100, 80, 50, 100, 80, 0, 0} 
			 * , {1, 50, 100, 80, 50, 100, 80, 0, 0} 
			 * , {1, 50, 100, 80, 50, 100, 80, 0, 0}}
			 */
			for(int j = 0; j < subjects.length; j++){
				scores[i][j + 1] = (int)(Math.random() * 51) + 50;
			}
		}
		
		//총점과 평균을 구한다.
		for(int i = 0; i < scores.length; i++){
			for(int j = 0; j < subjects.length; j++){
				scores[i][scores[i].length - 2] += scores[i][j + 1]; //총점
			}
			scores[i][scores[i].length - 1]
					= (int)((double)scores[i][scores[i].length - 2]
							/ subjects.length * 100 + 0.5) / 100.0; //평균
		}
		
		//석차를 구한다.
		for(int i = 0; i < scores.length; i++){
			for(int j = 0; j < scores.length; j++){
				if(scores[i][scores[i].length - 1] < scores[j][scores[j].length - 1]){
					scores[i][0]++;
				}
			}
		}
		
		//석차순으로 정렬한다.
		for(int i = 0; i < scores.length - 1; i++){
			for(int j = i + 1; j < scores.length; j++){
				if(scores[i][0] > scores[j][0]){
					double[] temp = scores[i];
					scores[i] = scores[j];
					scores[j] = temp;
					
					String tempName = students[i];
					students[i] = students[j];
					students[j] = tempName;
				}
			}
		}
		
		//출력한다.
		System.out.print("석차\t이름");
		for(int i = 0; i < subjects.length; i++){
			System.out.print("\t" + subjects[i]);
		}
		System.out.println("\t총점\t평균");
		for(int i = 0; i < scores.length; i++){
			System.out.print((int)scores[i][0] + "\t" + students[i]);
			for(int j = 1; j < scores[i].length; j++){
				if(j == scores[i].length - 1){
					System.out.print("\t" + scores[i][j]);
				}else{
					System.out.print("\t" + (int)scores[i][j]);
				}
			}
			System.out.println();
		}
	}

}











