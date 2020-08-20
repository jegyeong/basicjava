package e_oop;

import java.util.Scanner;

/*
 	발표 : 프로그램 주제, 기능, 메서드 구성, 시연
 	 - 가위바위보게임
		1. 가위  
		2. 바위 
		3. 보
		랜덤생성
		사용자와 컴퓨터가 가위바위보를 한다.
		50점을 가지고 시작한다.
		사용자는 이기면 +5점을 받고 지면 -5점을 받는다.
		0점이 되면 탈락.
		100점이 되면 승자가 된다.
		
		
*/
public class RSP {
	int scissor;
	int rock;
	int paper;
	int score;
	
	RSP(){
		scissor = 1;
		rock = 2;
		paper = 3;
		score =  50;
	}
	
	String gababo(int a){
		if(a == 1){
			return "가위";
		}
		else if(a == 2){
			return "바위";
		}
		else if(a == 3){
			return "보";
		}else{
			return "바보야 가위바위보 중에서 골라야지 ~ ";
		}
	}
	
	void score(){
		score = score;
	}
	
	void scoreUp(){
		score += 20;
	}
	void scoreDown(){
		score -= 20;
	}
	
	
	public static void main(String[] args) {
		
		RSP rsp = new RSP();
		
		Scanner s = new Scanner(System.in);
		
		System.out.println(" ********** 나를 이겨봐 ~~! **********");
		System.out.println(" ********** 인간 vs 컴퓨터  **********");

		
		System.out.println(" 안녕! 나는 히야야 너는 이름이 뭐야 ? ");
		String sa = s.nextLine();
		System.out.println(" " + sa + "!! 예쁜 이름이야 ~~ 나랑 가위바위보 하자 !");	
		System.out.println(" 시작 ~~~! 시작하려면 엔터를 눌러줘 !");
		String start = s.nextLine();
	    System.out.println(start);
		
		while(true){
				
			System.out.println(" 가위 ~ 바위 ~ 보 ~ !  (가위 => 1 , 바위  => 2, 보 => 3) ");
			
			
			int random =(int)(Math.random() * 3 ) + 1; 

			int input = Integer.parseInt(s.nextLine());

			System.out.println("♥ 히야  : " + rsp.gababo(random));
			System.out.println("♥ " + sa + " : " + rsp.gababo(input));
			
			if(random ==  input ){
				System.out.println("비겼엉 ㅠㅠ 0점이야 ~ 다시해봐 ~");
				rsp.score();
				System.out.println("사용자 현재 점수 : " + rsp.score);
			}else if(random == 1 && input == 2){
				System.out.println("뭐야 이겼어? 5점 줄게 ~");
				rsp.scoreUp();
				System.out.println("사용자 현재 점수  : " + rsp.score );
			}else if(random == 1 && input == 3){
				System.out.println("졌네 ~~~ 5점 가져갈게 ~~~");
				rsp.scoreDown();
				System.out.println("사용자 현재 점수 : " + rsp.score);
			}
			else if(random == 2 && input == 1){
				System.out.println("졌네 ~~~ 5점 가져갈게 ~~~");
				rsp.scoreDown();
				System.out.println("사용자 현재 점수 : " + rsp.score);
			}else if(random == 2 && input == 3){
				System.out.println("뭐야 이겼어? 5점 줄게 ~");
				rsp.scoreUp();
				System.out.println("사용자 현재 점수  : " + rsp.score );
			}
			else if(random == 3 && input == 1){
				System.out.println("뭐야 이겼어? 5점 줄게 ~");
				rsp.scoreUp();
				System.out.println("사용자 현재 점수  : " + rsp.score );
			}else if(random == 3 && input == 2){
				System.out.println("졌네 ~~~ 5점 가져갈게 ~~~");
				rsp.scoreDown();
				System.out.println("사용자 현재 점수 : " + rsp.score);
			}System.out.println();
			
			
			if(rsp.score == 0){
				System.out.println("0점 이네 ~~~~ 너는 컴퓨터한테 진 인간이야 ~~~~~~");
				break;
			}
			if(rsp.score == 100){
				System.out.println("100점 !!!!! 니가 이겼어.. 히야는 인간을 못이겨 ㅠ ㅅ ㅠ ");
				break;
			}
		
		}
		
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
