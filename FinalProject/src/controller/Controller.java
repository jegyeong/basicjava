package controller;


import java.util.Scanner;

import data.Session;
import service.IntegerCheck;
import service.Table;
import service.UserService;

public class Controller {

	public static void main(String[] args) {

		start();

	}
	static boolean longin_state = false;
	static Scanner s = new Scanner(System.in);
static void start() {

		


		int menu;
		
		boolean check = false;
		String temp = "";
		do {
			do {
				
				System.out.println("---------------------------------------------------");
				System.out.println("Young갬성 202호 뽀짝끝판왕에 오신걸 환영합니다;D");
				System.out.println("취객환영! 만취환영!");
				System.out.println("---------------------------------------------------");
				System.out.println("1. 왈왈! 개가 돼보자! 그전에 => '회원가입'해주세요! (회원가입시 1000 마일리지 지급)");
				System.out.println("2. 신난다! 재미난다!! => 저 세상 텐션으로 '로그인' ");
				System.out.println("0. 오늘은 건전하게(ㅠ),,, ㅈㅗㅇㄹㅛ,,,,");
				System.out.println("---------------------------------------------------");
				System.out.println("입력해주세요! > ");
				
				temp = s.nextLine().trim();
				check = IntegerCheck.checkInt(temp);
			} while (!check);

			menu = Integer.parseInt(temp);
			
			switch (menu) {
			case 1: // 회원가입
				UserService.join();
				break;
			case 2: // 로그인
				UserService.login();                       //로그인 했을떄
				if (Session.loginUser != null) {           //
					longin_state = true; 
					if(Session.loginUser.isMode()){
						while (longin_state) {
							AdminController.select();
							longin_state = AdminController.login_state;
						}
					}else{
						if(!Table.tableEnter()){
							break;
						}
						while (longin_state) {
							UserController.select();
							longin_state = UserController.login_state;
						}
					}
					
				}
		
				break;
			case 0: // 프로그램종료
				System.out.println("무사히 귀가하십쇼!!!");
				break;
			default:
				System.out.println("잘못된 입력입니다.");
			}
			
		} while (menu != 0);

	}
	




}
