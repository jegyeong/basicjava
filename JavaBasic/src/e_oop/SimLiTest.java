package e_oop;

import java.util.Scanner;

public class SimLiTest {
	
	String q1 = "나는 금사빠다.(Y/N)";
	String q2 = "연애할 때 끌려다니는 타입이다.(Y/N)";
	String q3 = "데이트 코스는 미리 짜는게 편하다.(Y/N)";
	String q4 = "감정기복이 크지 않다.(Y/N)";
	String q5 = "감정 표현에 솔직한 편이다.(Y/N)";
	String q6 = "활동적인 데이트가 좋다.(Y/N)";
	String q7 = "연락이 없어도 믿고 기다리는 편이다.(Y/N)";
	String q8 = "이성친구는 존재할 수 없다.(Y/N)";
	String q9 = "아무것도 아닌 일에 쉽게 섭섭함이 쌓인다.(Y/N)";
	
	String typeA = "서로에 대한 신뢰감이 깊고, 존중해주는 어른스러운 연애를 하는 타입!";
	String typeB = "구속을 하는 것도, 받는 것도 싫은 자유로운 연애를 하는 타입!";
	String typeC = "이것은 의리인가 사랑인가... 친구같이 편안한 연애를 하는 타입!";
	String typeD = "무조건 잘해주고, 무조건 맞춰주는 다 퍼주는 연애를 하는 타입!";

	Scanner s = new Scanner(System.in);
	
	void q1(){
		System.out.println(q1);
		String answer = s.nextLine();
		
		if(answer.equalsIgnoreCase("Y")){
			q2();
		}else if(answer.equalsIgnoreCase("N")){
			q4();
		}
	}
	
	void q2(){
		System.out.println(q2);
		String answer = s.nextLine();
		
		if(answer.equalsIgnoreCase("Y")){
			q5();
		}else if(answer.equalsIgnoreCase("N")){
			q3();
		}
	}
	
	void q3(){
		System.out.println(q3);
		String answer = s.nextLine();
		
		if(answer.equalsIgnoreCase("Y")){
			q6();
		}else if(answer.equalsIgnoreCase("N")){
			q5();
		}
	}
	
	void q4(){
		System.out.println(q4);
		String answer = s.nextLine();
		
		if(answer.equalsIgnoreCase("Y")){
			q7();
		}else if(answer.equalsIgnoreCase("N")){
			q5();
		}
	}
	
	void q5(){
		System.out.println(q5);
		String answer = s.nextLine();
		
		if(answer.equalsIgnoreCase("Y")){
			q8();
		}else if(answer.equalsIgnoreCase("N")){
			q6();
		}
	}
	
	void q6(){
		System.out.println(q6);
		String answer = s.nextLine();
		
		if(answer.equalsIgnoreCase("Y")){
			q8();
		}else if(answer.equalsIgnoreCase("N")){
			q9();
		}
	}
	
	void q7(){
		System.out.println(q7);
		String answer = s.nextLine();
		
		if(answer.equalsIgnoreCase("Y")){
			System.out.println(typeA);
		}else if(answer.equalsIgnoreCase("N")){
			q8();
		}
	}
	
	void q8(){
		System.out.println(q8);
		String answer = s.nextLine();
		
		if(answer.equalsIgnoreCase("Y")){
			q9();
		}else if(answer.equalsIgnoreCase("N")){
			System.out.println(typeB);
		}
	}
	
	void q9(){
		System.out.println(q9);
		String answer = s.nextLine();
		
		if(answer.equalsIgnoreCase("Y")){
			System.out.println(typeD);
		}else if(answer.equalsIgnoreCase("N")){
			System.out.println(typeC);
		}
	}
	
}







