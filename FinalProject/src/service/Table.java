package service;

import java.util.ArrayList;
import java.util.Scanner;

import vo.TableVo;
import dao.TableDao;
import data.Session;


public class Table {


	static TableDao tabledao = TableDao.getInstance();
	   
	                                  
	 

	
	static int count = 1;
	static Scanner s = new Scanner(System.in);
	
	public static void tablecotrol() {
		
		
		String temp = "";
		boolean check = false;
		boolean check1 = false;
		do{
		do {
			System.out.println("------------------------------------------");
			System.out.println("1. 현재 테이블 상태보기");
			System.out.println("2. 테이블 생성하기");
			System.out.println("3. 테이블 삭제하기");
			System.out.println("4. 테이블 초기화하기");
			System.out.println("0. 이전 메뉴로 돌아가기");

			System.out.println("------------------------------------------");
			temp = s.nextLine().trim();
			check = IntegerCheck.checkInt(temp, 0, 4);

		} while (!check);

		
		
		
		int menu = Integer.parseInt(temp);
		switch (menu) {
		case 1:
			tableview();
			break;
		case 2:
            tablecreate();
			break;
		case 3:
			tabledelete();
			break;
		case 4:
			tableReset();
			break;
		case 0:
			System.out.println("이전 메뉴로 돌아갑니다.");
			check1 = !check1;
			break;
			
		}
		}while(!check1);
	}
	public static void tableview(){
		if(tabledao.selectTable().size()== 0 ){
			System.out.println("테이블이 존재하지 않습니다.");
		}
		
		for (int i = 0; i < tabledao.selectTable().size(); i++) {
			
			int EnterPeople = tabledao.selectTable().get(i).getEnterpeople();
			int Possiblepeople = tabledao.selectTable().get(i).getPossiblepeople();
			String state = "";
			if(EnterPeople > 0){
				state = "사용중";
			}else{
				state = "사용가능";
			}
			System.out.println("테이블 번호 : " + (i + 1)+" ==> "+state);
			tableshape(Possiblepeople, EnterPeople);

		}
		

	
		System.out.println(" 다시 되돌아가려면 아무키나 누르세요!");
		 s.nextLine();
		
	}
	public static boolean tableEnter() {
		if(tabledao.selectTable().isEmpty()){
			System.out.println("-------------------------------------");
			System.out.println("테이블이 존재하지 않습니다.");
			System.out.println("-------------------------------------");
			return false;
		}
		
		boolean check = false;
		int enterPerson = 0;
		int tableNo = 0;
		String temp = "";

		do {
			System.out.println("-------------------------------------");
			System.out.println("몇 명 입장하시겠습니까?");
			System.out.println("-------------------------------------");
			temp = s.nextLine().trim();
			check = IntegerCheck.checkInt(temp);
		} while (!check);
		
		enterPerson = Integer.parseInt(temp);
		
		ArrayList<TableVo> notUsingTableList  = tabledao.notUsingTableList(enterPerson);
		
		if(notUsingTableList.isEmpty()){
			System.out.println("-------------------------------------");
			System.out.println(enterPerson+"명이  앉을 테이블이 없습니다.");
			System.out.println("-------------------------------------");
			return false;
		}
		
		
	

		do {
			for (int i = 0; i < notUsingTableList.size(); i++) {
				int EnterPeople = notUsingTableList.get(i).getEnterpeople();
				int Possiblepeople = notUsingTableList.get(i).getPossiblepeople();

				System.out.println("테이블 번호 : " + (notUsingTableList.get(i).getTablenumber()));
				tableshape(Possiblepeople, EnterPeople);
			}
			
			System.out.println("-------------------------------------");
			System.out.println("몇 번 테이블에 입장하시겠습니까?");
			System.out.println("-------------------------------------");
			temp = s.nextLine().trim();
			check = IntegerCheck.checkInt(temp);

			if (check) {
				check = false;
				for (int i = 0; i < notUsingTableList.size(); i++) {
					if (notUsingTableList.get(i).getTablenumber() == Integer.parseInt(temp)) {
						check = true;
						break;
					}
				}
				if(!check){
					System.out.println("-------------------------------------");
					System.out.println("해당 테이블은 존재하지 않습니다.");
					System.out.println("다시 입력해주세요.");
					System.out.println("-------------------------------------");
				}

			}
		}while(!check);
		
		tableNo = Integer.parseInt(temp); 
		
		tabledao.searchTalbeNoInfo(tableNo).setEnterpeople(enterPerson);
		tabledao.searchTalbeNoInfo(tableNo).setUserId(Session.loginUser.getId());
		
		return true;

	}
	public static void tableshape(int Possiblepeople, int EnterPeople) {

		System.out.println(" ┌──────────────┐");

		if (EnterPeople > 0 && Possiblepeople % 2 == 0
				&& Possiblepeople - EnterPeople != 0) { // 테이블이 짝수개에
			if (EnterPeople % 2 == 0) {
				for (int a = 0; a < EnterPeople / 2; a++) {
					System.out.println(" │              │ ");
					System.out.println(" │  ☻        ☻  │ ");
					System.out.println(" │              │ ");
				}
				for (int s = 0; s < (Possiblepeople / 2 - EnterPeople / 2); s++) {
					System.out.println(" │              │ ");
					System.out.println(" │  ☺        ☺  │ ");
					System.out.println(" │              │ ");
				}
			} else { // 입장수가 홀수고, 테이블이 짝수일때.
				if (EnterPeople == 1) {
					if (Possiblepeople != 1) {
						System.out.println(" │              │ ");
						System.out.println(" │  ☻        ☺  │ ");
						System.out.println(" │              │ ");

						for (int i = 0; i < Possiblepeople / 2 - 1; i++) {
							System.out.println(" │              │ ");
							System.out.println(" │  ☺        ☺  │ ");
							System.out.println(" │              │ ");
						}

					}

				} else {
					for (int a = 0; a < EnterPeople / 2; a++) {
						System.out.println(" │              │ ");
						System.out.println(" │  ☻        ☻  │ ");
						System.out.println(" │              │ ");
					}
					System.out.println(" │              │ ");
					System.out.println(" │  ☻        ☺  │ ");
					System.out.println(" │              │ ");

					if ((Possiblepeople / 2 - EnterPeople / 2) - 1 > 0) {
						for (int s = 0; s < (Possiblepeople / 2 - EnterPeople / 2) - 1; s++) {
							System.out.println(" │              │ ");
							System.out.println(" │  ☺        ☺  │ ");
							System.out.println(" │              │ ");

						}
					}
				}

			}
		}
		if (EnterPeople > 0 && Possiblepeople % 2 != 0
				&& Possiblepeople - EnterPeople != 0) { // 테이블이 홀수고
			if (EnterPeople % 2 == 0) { // 테이블이 홀수이고, 입장하는 사람이 짝수이다.
				for (int a = 0; a < EnterPeople / 2; a++) {
					System.out.println(" │              │ ");
					System.out.println(" │  ☻        ☻  │ ");
					System.out.println(" │              │ ");
				}
				for (int s = 0; s < Possiblepeople / 2 - EnterPeople / 2; s++) {
					System.out.println(" │              │ ");
					System.out.println(" │  ☺        ☺  │ ");
					System.out.println(" │              │ ");
				}
				System.out.println(" │              │ ");
				System.out.println(" │       ☺      │ ");
				System.out.println(" │              │ ");

			} else { // 입장수가 홀수고, 테이블이 홀수일때.

				if (EnterPeople == 1) {
					if (Possiblepeople == 1) {
						System.out.println(" │              │ ");
						System.out.println(" │       ☻      │ ");
						System.out.println(" │              │ ");
					} else {
						System.out.println(" │              │ ");
						System.out.println(" │  ☻        ☺  │ ");
						System.out.println(" │              │ ");
						for (int i = 0; i < Possiblepeople / 2 - 1; i++) {
							System.out.println(" │              │ ");
							System.out.println(" │  ☺        ☺  │ ");
							System.out.println(" │              │ ");
						}
						System.out.println(" │              │ ");
						System.out.println(" │       ☺      │ ");
						System.out.println(" │              │ ");

					}
				} else {
					for (int a = 0; a < EnterPeople / 2; a++) {
						System.out.println(" │              │ ");
						System.out.println(" │  ☻        ☻  │ ");
						System.out.println(" │              │ ");
					}
					System.out.println(" │              │ ");
					System.out.println(" │  ☻        ☺  │ ");
					System.out.println(" │              │ ");

					for (int s = 0; s < (Possiblepeople / 2 - EnterPeople / 2) - 1; s++) {
						System.out.println(" │              │ ");
						System.out.println(" │  ☺        ☺  │ ");
						System.out.println(" │              │ ");
					}

					System.out.println(" │              │ ");
					System.out.println(" │       ☺      │ ");
					System.out.println(" │              │ ");

				}
			}
		}

		if (Possiblepeople % 2 == 0 && EnterPeople == 0) {
			for (int j = 0; j < Possiblepeople / 2; j++) {
				System.out.println(" │              │ ");
				System.out.println(" │  ☺        ☺  │ ");
				System.out.println(" │              │ ");
			}
		}

		if (Possiblepeople % 2 != 0 && EnterPeople == 0) {

			for (int j = 0; j < Possiblepeople / 2; j++) {
				System.out.println(" │              │ ");
				System.out.println(" │  ☺        ☺  │ ");
				System.out.println(" │              │ ");
			}
			System.out.println(" │              │ ");
			System.out.println(" │       ☺      │ ");
			System.out.println(" │              │ ");

		}

		if (Possiblepeople % 2 != 0 && Possiblepeople - EnterPeople == 0) { // 테이블
																			// 수가
																			// 홀수이면서
																			// 자리가
																			// 꽉찼다면.
			for (int j = 0; j < Possiblepeople / 2; j++) {
				System.out.println(" │              │ ");
				System.out.println(" │  ☻        ☻  │ ");
				System.out.println(" │              │ ");
			}
			System.out.println(" │              │ ");
			System.out.println(" │       ☻      │ ");
			System.out.println(" │              │ ");

		}
		if (Possiblepeople % 2 == 0 && Possiblepeople - EnterPeople == 0) { // 테이블
																			// 수가
																			// 홀수이면서
																			// 자리가
																			// 꽉찼다면.
			for (int j = 0; j < Possiblepeople / 2; j++) {
				System.out.println(" │              │ ");
				System.out.println(" │  ☻        ☻  │ ");
				System.out.println(" │              │ ");
			}

		}

		System.out.println(" └──────────────┘");

	}
	public static void tabledelete() {
		boolean check = false;
		String temp = "";
		if(tabledao.selectTable().isEmpty()){
			System.out.println("테이블이 존재하지 않습니다.");
			return;
		}
		
		for (int i = 0; i < tabledao.selectTable().size(); i++) {
			if(tabledao.selectTable().get(i).getEnterpeople() != 0 ){
				System.out.println("테이블이 전부 비어있는 상태에서 삭제하세요.");
	            return;
			}
	            
		}
		
		do {
		for (int i = 0; i < tabledao.selectTable().size(); i++) {

			int EnterPeople = tabledao.selectTable().get(i).getEnterpeople();
			int Possiblepeople = tabledao.selectTable().get(i).getPossiblepeople();

			System.out.println("테이블 번호 : " + (i + 1));
			tableshape(Possiblepeople, EnterPeople);

		}
			System.out.println("------------------------------------");
			System.out.println("삭제하고 싶은 테이블 번호를 입력하세요.");
			System.out.println("------------------------------------");
			temp = s.nextLine().trim();
			check=IntegerCheck.checkInt(temp);
			
			if (check) {
				check = false;
				for (int i = 0; i < tabledao.selectTable().size(); i++) {
					if (tabledao.selectTable().get(i).getTablenumber() == Integer.parseInt(temp)) {
						check = true;
						break;
					}
				}
				if(!check){
					System.out.println("-------------------------------------");
					System.out.println("해당 테이블은 존재하지 않습니다.");
					System.out.println("다시 입력해주세요.");
					System.out.println("-------------------------------------");
				}

			}
			
			
		} while (!check);

		int tableNum = Integer.parseInt(temp);
		
		System.out.println(tableNum+"번째 테이블을 삭제하였습니다.");
		tabledao.deleteTable(tabledao.searchTalbeNoInfo(tableNum));
		

	}
	public static void tablecreate() {
		String temp;
		boolean check = false;

		if (tabledao.selectTable().isEmpty()) {
			System.out.println("테이블이 존재하지 않습니다.");
			return;
		}
		do {
			System.out.println("테이블을 생성하시겠습니까?");
			System.out.println("1.예");
			System.out.println("2.아니요");
			temp = s.nextLine().trim();

			check = IntegerCheck.checkInt(temp, 1, 2);

		} while (!check);

		if (temp.equals("1")) {
			do {
				System.out.println("생성하실 테이블의 최대 인원수를 설정해주세요!");
				temp = s.nextLine().trim();
				check = IntegerCheck.checkInt(temp);

			} while (!check);

			int MaxPeople = Integer.parseInt(temp);

			TableVo table = new TableVo();
			table.setPossiblepeople(MaxPeople);
			tabledao.tablecreate(table);

			System.out.println(" 테이블이 생성되었습니다.  ");
		} else {
			return;
		}
	}

	public static void tableOut() {
		for(int i = 0 ; i < tabledao.selectTable().size();i++){
			if(tabledao.selectTable().get(i).getUserId() != null)
			if( tabledao.selectTable().get(i).getUserId().equals(Session.loginUser.getId())){
				tabledao.selectTable().get(i).setEnterpeople(0);
				tabledao.selectTable().get(i).setUserId(null);
				Session.loginUser = null;
				break;

			}
		}
	}
	
	public static void tableReset() {
		boolean check = false;
		String temp = "";
		do {
		System.out.println("현재 테이블 모든 내용들을 초기화합니다. 초기화하게 되면 모든 테이블의 정보가 날라갑니다!");

			System.out.println("1.예");
			System.out.println("2.아니오");
			temp = s.nextLine().trim();

			check = IntegerCheck.checkInt(temp, 1, 2);
		} while (!check);

		if (temp.equals("1")) {

			for (int i = 0; i < tabledao.selectTable().size(); i++) {
				TableVo table  = tabledao.selectTable().get(i);
				table.setEnterpeople(0);
				table.setUserId(null);
			}
		} else {
			return;
		}
		

	}

}