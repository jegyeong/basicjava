package e_oop;

import java.util.Scanner;

public class Baskin {
	int position = 0;
	Scanner scan = new Scanner(System.in);
	String[] baskinNum = new String[31];
	static Baskin b = new Baskin();
	boolean finish = false;
	
	public static void main(String[] arg){
		System.out.println("베스킨 라빈스 써리원!");
		System.out.println("귀엽고 깜찍하게 써리원!");
		b.playGame();
	}
	
	void playGame(){	// 게임 실행
		do {
			String userStr = scan.nextLine();
			if (position == 0) {
				for (int i = 0; i < userStr.length(); i++) {
					baskinNum[i] = String.valueOf(userStr.charAt(i)); //valueof => int를 string으로 반환, userstr의 i번째 인덱스위치의 문자열을 반환 입력값이 반환되서 배열에 쌓임
					position++;										  //입력값+1 증가	
				}
			} else {
				for (int i = 0; i < userStr.length(); i++) {
					if (position > 9) {
						if (i % 2 == 0) {
							baskinNum[position] = userStr.substring(i, i+2);	//substring => 해당범위의 문자열을 반환
							position+=1;
						}	
					}else{
						baskinNum[position] = String.valueOf(userStr.charAt(i));		//123     position = 2;
						position +=1;			//012
					}
				}
			}
			
			if (position == 31) {	// 숫자가 31일 때
				System.out.println("컴퓨터가 이겼습니다!!!");
				finish = true;		// false => true
				position = 0;		// 숫자 0 초기화
				break;				//탈출
			}
			b.cpuGame();
		} while (finish == false);
	}
	
	void cpuGame(){
		int com = (int)(Math.random()*3+1);		// 랜덤 1~3 추가할 숫자 생성
		System.out.println("컴퓨터 입력 숫자");
		System.out.println("-------");
		for(int i = 0; i < com; i++){	//i는 0부터 시작해서 com(랜덤숫자)보다 작을 때
			baskinNum[position] = String.valueOf(position + 1);
			position += 1;

			System.out.print(position + " ");

			if (position == 31) {
				System.out.println("\n 사용자가 이겼습니다!!!");
				position = 0;
				finish = true;
				break;
			}
		}
		System.out.println();
	}

}
