package e_oop;

import java.util.Scanner;

public class DrinkingGame {

	//발표 : 프로그램, 기능, 메서드 구성, 시연
	
	/*
	 * 회식게임
	 * 
	 * 1. 참여자 수와 이름 및 개인별 주량을 입력한다.
	 * 2. 참여자에게 랜덤번호를 부여한다.
	 * 3. 랜덤으로 번호를 뽑는다.
	 * 4. 걸린 사람은 술을 마시고 마실수록 남은 주량이 줄어든다.
	 * 5. 주량이 다 하면 집에 보낸다.
	 */
	
	//사람 변수 선언
	String[] person;
	
	//랜덤번호 생성
	int RandomNum(){
		int random = (int)((Math.random() * person.length) + 1);
		return random;
	}
	
	
	//실행
	public static void main(String[] args) {
		
		//생성자 
		DrinkingGame dg = new DrinkingGame();
		
		Scanner sc = new Scanner(System.in);
		
		//사람 수 및 주량 선언
		int people;
		int[] drinking_capacity;
		int need_GoHome = 0; //집에 가야하는 사람의 수
		
		//사람 수 입력받기
		System.out.println("사람의 수를 입력해주세요");
			int input_num = Integer.parseInt(sc.nextLine());
			people = input_num;
			
		//이름 및 주량 입력받기
		dg.person = new String[people];
		drinking_capacity = new int[people];
		for(int i = 0; i < people; i++){
			System.out.println("이름을 입력해 주세요 : ");
			String input = sc.nextLine();
			dg.person[i] = input;
			
			System.out.println("주량을 입력해주세요 : ");
			int input2 = Integer.parseInt(sc.nextLine());
			drinking_capacity[i] = input2;
		}
		
		
		while(need_GoHome < 1){
			System.out.println("게임을 시작할까요? (Y)");
			String start = sc.nextLine();
			if(start.equalsIgnoreCase("Y")){
			
				//랜덤 번호 부여
				int[] person_num = new int[people];
				for(int i = 0; i < people; i++){
					person_num[i] = dg.RandomNum();
				}
				
				//번호 확인
				for(int i = 0; i < people; i++){
					System.out.println(dg.person[i] + "님의 번호 : " + person_num[i]);
				}
				
				System.out.println();
				System.out.println("과연 행운의 번호는~? (확인하시려면 Y를 입력하세요)");
				String check = sc.nextLine();
				if(check.equalsIgnoreCase("Y")){
				
					//당첨 번호 뽑기
					System.out.println();
					int random_num = dg.RandomNum(); 
					System.out.println("랜덤 번호 : " + random_num);
					for(int i = 0; i < people; i++){
						if(person_num[i] == random_num){
							System.out.println(dg.person[i] + "님 당첨!!");
						}
					}
					
					//남은주량 
					System.out.println();
					for(int i = 0; i < people; i++){
						if(person_num[i] == random_num){
							drinking_capacity[i]--;
						}
						System.out.println(dg.person[i] + "님의 남은 주량은 "
								+ drinking_capacity[i] + "병입니다.");
					}

					// 집에 보내기
					System.out.println();
					for (int i = 0; i < people; i++) {
						if (drinking_capacity[i] == 0) {
							System.out.println(dg.person[i]
									+ "님의  주량이 끝났습니다 귀가하세요.");
							need_GoHome++;
						}
					}
				} 
				else {
					System.out.println("게임을 종료합니다");
					break;
				}
			}
			else {
				System.out.println("게임을 종료합니다");
				break;
			}
		}
	}
}
