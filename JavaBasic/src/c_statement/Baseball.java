package c_statement;

import java.util.Scanner;

public class Baseball {

	public static void main(String[] args) {
		//숫자야구게임을 만들어주세요.
		//3자리의 중복되지 않는 숫자를 발생시킨다.(1~9)
		int a1, a2, a3;
		a1 = (int)(Math.random() * 9) + 1; //1 ~ 9까지 램덤수
		
		do{
			a2 = (int)(Math.random() * 9) + 1; //1 ~ 9까지 램덤수
		}while(a1 == a2);
		
		do{
			a3 = (int)(Math.random() * 9) + 1; //1 ~ 9까지 램덤수
		}while(a1 == a3 || a2 == a3);
		
		Scanner s = new Scanner(System.in);
		int count = 0;
		
		while(true){
			System.out.println("3자리의 숫자를 입력해주세요>");
			int input = Integer.parseInt(s.nextLine());
			int i3 = input % 10;
			input /= 10;
			int i2 = input % 10;
			input /= 10;
			int i1 = input % 10;
			
			int strike = 0;
			int ball = 0;
			int out = 0;
			
			if(a1 == i1) strike++;
			if(a2 == i2) strike++;
			if(a3 == i3) strike++;
			
			if(a1 == i2 || a1 == i3) ball++;
			if(a2 == i1 || a2 == i3) ball++;
			if(a3 == i1 || a3 == i2) ball++;
			
			out = 3 - strike - ball;
			
			System.out.println(++count + "차 시도(" + i1 + i2 + i3 + ") : "
					+ strike + "S " + ball + "B " + out + "O)");
			System.out.println("----------------");
			if(strike == 3){
				System.out.println("정답입니다!!");
				break;
			}
		}
		
		//사용자에게 3개의 숫자를 입력받는다.
		
		//사용자가 입력한 값과 정답을 비교해 SBO를 카운팅한다.
		
		//3S인 경우 정답이므로 프로그램을 종료한다.
	}

}



