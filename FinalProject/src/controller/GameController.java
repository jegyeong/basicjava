package controller;

import java.util.Scanner;





import service.IntegerCheck;
import game.Gbv;
import game.Minesweeper;
import game.YouCanDo;
import game.sutvivarGame.FIgthClass;

public class GameController {



	private static GameController instance;

	private GameController() {
	}

	public static GameController getInstance() {
		if (instance == null) {
			instance = new GameController();
		}
		return instance;

	}
	static Scanner s = new Scanner(System.in);
	// 게임선택
	public static void Game() {
		
		boolean check = false;
		String tmep = "";
		do{
			
		
		do{
			System.out.println("---------------------------------------------------");
			System.out.println("Young갬성 202호 뽀짝끝판왕에 오신걸 환영합니다;D");
			System.out.println("취객환영! 만취환영!");
			System.out.println("---------------------------------------------------");
			System.out.println("1. 묵찌빠! ");
			System.out.println("2. 지뢰찾기! ");
			System.out.println("3. 살아남기! ");
			System.out.println("4. 타자연습게임! ");
			System.out.println("0. 오늘은 건전하게(ㅠ),,, ㅈㅗㅇㄹㅛ,,,,");
			System.out.println("---------------------------------------------------");
			System.out.println("입력해주세요! > ");
			
			tmep = s.nextLine().trim();
			check = IntegerCheck.checkInt(tmep,0,4);
			
		}while(!check);
		
		int menu =Integer.parseInt(tmep);
		
		switch (menu) {
		case 1: // 묵찌빠
			Gbv g = Gbv.getInstance();
			g.start();
			break;
		case 2: // 지뢰찾기
			Minesweeper mineGame = new Minesweeper(); 
			mineGame.start();
			break;
		case 3: // 살아남기
			FIgthClass fight = FIgthClass.getInstance();
			fight.mainFight();
			break;
		case 4 : // 타자연습게임
			YouCanDo youCanDo = YouCanDo.getInstance();
			youCanDo.start1();
			break;
		case 0: // 프로그램종료
			System.out.println("무사히 귀가하십쇼!!!");
			check = false;
			break;
		}
		}while(check);

	}

}
