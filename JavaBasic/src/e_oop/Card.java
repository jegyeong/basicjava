package e_oop;

import java.util.Scanner;

public class Card {
	Scanner s = new Scanner(System.in);
	int x = 4;
	int[][] deck = new int[x][x];
	String res = "";
		
	//번호 부여
	void num() {
		for (int i = 0; i < deck.length; i++) {
			for (int j = 0; j < deck[i].length; j++) {
				deck[i][j] = j + 1 + (int) (i / 2) * deck[i].length;
			}
		}
	}

	
	// 셔플
	void shuffle() {
		for (int i = 0; i < deck.length; i++) {
			for (int j = 0; j < deck[i].length; j++) {
				int a = (int) (Math.random() * deck.length);
				int b = (int) (Math.random() * deck[i].length);
				int tmp;
				tmp = deck[i][j];
				deck[i][j] = deck[a][b];
				deck[a][b] = tmp;
			}
		}
	}
	
	
	// 상태 표시
	
	void present() {
		for (int i = 0; i < deck.length; i++) {
			for (int j = 0; j < deck[i].length; j++) {
				res = "";
				if (deck[i][j] == 0)
					res += "[ O ] ";
				else
					res += "[   ] ";
				System.out.print(res);
			}
			System.out.println();
		}
	}
	
	
	
	
	public static void main(String[] args) {
		boolean x = true;
		Card card = new Card();
		card.num();
		card.shuffle();
		System.out.println("2장 숫자 맞추기 게임");
		while (x) {
			x = !x;
			card.present();
			card.play();
			for (int i = 0; i < card.deck.length; i++) {
				for (int j = 0; j < card.deck[i].length; j++) {
					if (card.deck[i][j] != 0) x = true;
				}
			}
		}
		card.present();
		System.out.println("당신의 근성에 박수를 보낸다.");
	}
	
	
	
	// 맞추기
		void play(){
		System.out.println("첫번째 행 번호 입력");
		int a1 = Integer.parseInt(s.nextLine()) - 1;
		System.out.println("첫번째 열 번호 입력");
		int b1 = Integer.parseInt(s.nextLine()) - 1;

		System.out.println("두번째 행 번호 입력");
		int a2 = Integer.parseInt(s.nextLine()) - 1;
		System.out.println("두번째 열 번호 입력");
		int b2 = Integer.parseInt(s.nextLine()) - 1;
		
		if(deck[a1][b1] == deck[a2][b2]){
			System.out.println("맞췄습니다");
			System.out.println(a1 + 1 + " 행 " + (b1 + 1) + " 열  숫자는 : " + deck[a1][b1]);
			System.out.println(a2 + 1 + " 행 " + (b2 + 1) + " 열  숫자는 : " + deck[a2][b2]);
			deck[a1][b1] = deck[a2][b2] = 0;
		}
		else{
			System.out.println("틀렸습니다");
			System.out.println(a1 + 1 + " 행 " + (b1 + 1) + " 열  숫자는 : " + deck[a1][b1]);
			System.out.println(a2 + 1 + " 행 " + (b2 + 1) + " 열  숫자는 : " + deck[a2][b2]);
		}
		}
}

