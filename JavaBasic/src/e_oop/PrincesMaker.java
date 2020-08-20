package e_oop;

import java.util.Scanner;

public class PrincesMaker {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("프린세스 메이커 게임을 시작합니다");
		System.out.println("딸의 이름을 입력해주세요>");
		String name =  s.nextLine();
		
		
		System.out.println(name + "은 10살입니다");
		System.out.println("딸이 20살이 될때까지 잘 보살펴주세요");
		System.out.println("당신의 결정에 따라서 딸의 운명이 달라집니다\t능력치를 골라주세요>");
		System.out.println("1 :예절교실 \t2 : 미술수업 \t3 : 학교가기 \t4 : 교회 \t5 : 아르바이트 \t 6 : 무술교실  >");
		
		//왜 안돌아가지?
		
		
		
		int input;
		
		int count = 1;
		int age = 10;

		//딸의 이름 입력하는 공간 만들기 
		
//		//배열 2개 만들기
//		String [] activity =  {"예절", "예술성", "지식", "도덕성", "매력", "체력"};
//		String [] option = {"한복", "화구세트", "강연입장권", "책", "화장품", "아령", "음식"};
//		

			
		Activity ac = new Activity();
		
		
	//스텟 세는 변수를 만들기 
		do{
			input =  Integer.parseInt(s.nextLine());
			ac.Activity(input); 
			for(int i = 0; i <= 20; i++){
				count++;
			}
			
			
			System.out.println("능력치를 골라주세요");
			System.out.println("1 :예절교실 \t2 : 미술수업 \t3 : 학교가기 \t4 : 교회 \t5 : 아르바이트 \t 6 : 무술교실  >");
			
//			System.out.println("딸의 능력치가 올랐습니다. 다음 반년동안의 딸의 행동을 선택해주세요 ");
			
			
			
			
			////반년씩 지나는 코드 만들기
			for(int i = 10; i <= 20; i++){
				if (i % 2 == 0){
					age = (age + 1);
				}else{
					age = age;
				}
				
			}
			
//			String[] present = {"한복", "화구세트", "강연입장권", "책", "화장품", "아령"};
			int option =  Integer.parseInt(s.nextLine());
			//선물주긔
//			if(option == 1){
//				for(int i = 0; i <= 6; i++){
//					System.out.println(" '1:한복', '2:화구세트', '3:강연입장권', '4:책', '5:화장품', '6:아령' ");
//					System.out.println("딸에게" + present[i] + "을(를) 선물합니다");
//					
//					System.out.println();
//				}
//				}else if(option == 2){
//					ac.satiety++;
//				}
			
		
			System.out.println("당신의 딸은 " + age + "살입니다");
			
			//사망엔딩
//			if(satiety <= 0){
//				break;
//				System.out.println("당신의 딸이 영양실조로 사망했습니다\n *****Bad Ending****");
//			}
						
		}while(count > 20);
		
		//능력치세기 == 여러가지 비교는?-- 뭘로하지?ㅠㅠ
		
//		if()
//		manners; 가 가장 높다면 >  "당신의 딸은 옆나라의 왕비가 되었습니다\n딸의 결혼식에 참석해주세요 \n****Empress Ending****" 
//		
//		int artistry; //예술성> "당신의 딸은 예술가가 되었습니다\n딸의 작품을 감상하세요\n****Artist Ending****"
//		int brains;//지식 >"당신의 딸은 여왕이 되었습니다\n딸의 통치력을 감상해보세요\n****Queen Ending****"
//		int morality;//도덕성 >"당신의 딸은 수녀가 되었습니다\n수녀원으로 딸을 방문해보세요\n****Nun Ending****"
//		int stamina; //체력 >"당신의 딸은 장군이 되었습니다\n전쟁에서의 딸의 용맹함을 지켜보세요\n****General Ending****"
//		int charm; //매력  > 이 높으면 결혼함 manners를 제외하고 
		
		
//		System.out.println();
		
		//swich 
		
		
		
		
		
		

	}

}
