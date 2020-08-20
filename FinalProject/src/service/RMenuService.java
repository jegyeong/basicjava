package service;

import java.util.ArrayList;
import java.util.Scanner;

import vo.CartVo;
import vo.RecommendedMenuVo;
import dao.CartDao;
import dao.CartegoryDao;
import dao.FoodDao;
import dao.RMenuDao;


public class RMenuService {


	// 전역변수
	static Scanner s = new Scanner(System.in);
	
	public static void userManagement(){
		
		String temp = "";
		boolean check = false;
		do{
		printRMenu();
		System.out.println("----------------------------------------------");
		System.out.println("1. 추천메뉴 주문");
		System.out.println("0. 종료");
		System.out.println("----------------------------------------------");
		
		temp = s.nextLine().trim();
		check = IntegerCheck.checkInt(temp,0,1);
		}while(!check);
		
		int menu = Integer.parseInt(temp);
		
		switch(menu){
		case 1:
			orderRMenu();
			break;
		case 0:
			System.out.println("메뉴로 이동합니다.");
			break;
		}
		
	}
	public static void adminManagement(){
		
		String temp = "";
		boolean check = false;
		do {

			do {
				printRMenu();
				System.out.println("----------------------------------------------");
				System.out.println("1. 추천메뉴 추가");
				System.out.println("2. 추천메뉴 삭제");
				System.out.println("3. 추천메뉴  내용 수정");
				System.out.println("0. 종료");
				System.out.println("----------------------------------------------");

				temp = s.nextLine().trim();
				check = IntegerCheck.checkInt(temp, 0, 3);
			} while (!check);

			int menu = Integer.parseInt(temp);

			switch (menu) {
			case 1:
				insertRMenu();
				break;
			case 2:
				deleteRMenu();
				break;
			case 3:
				contentsModify();
				break;
			case 0:
				System.out.println("메뉴로 이동합니다.");
				check = false;
			}
		}while(check);
		
	}	
	public static void printRMenu(){// 추가할 메뉴 리스트 전체를 보여줌
		RMenuDao rmenuDao = RMenuDao.getInstance();
		FoodDao foodDao = FoodDao.getInstance();
		ArrayList<RecommendedMenuVo> rmenuList = rmenuDao.selectRecommendedMenu();
		System.out.println("----------------------------------------------");
		System.out.println("\t\t\t추천 메뉴 목록");
		System.out.println("----------------------------------------------");
		for(int i = 0; i<rmenuList.size();i++){
			System.out.print(i+1+". ");
			System.out.println(foodDao.searchFoodNoInfo(rmenuList.get(i).getFoodNo()).getName());
			System.out.println("추천 내용 : "+ rmenuList.get(i).getContents());
			System.out.println("가격 : "+ foodDao.searchFoodNoInfo(rmenuList.get(i).getFoodNo()).getPrice()+"원");
		}
		System.out.println("----------------------------------------------");
		
		
	}
	public static void orderRMenu(){//추천메뉴 주문하기
		
		RMenuDao rmenuDao = RMenuDao.getInstance();
		ArrayList<RecommendedMenuVo> rmenuList = rmenuDao.selectRecommendedMenu();
		CartDao cartDao = CartDao.getInstance();
		String temp = "";
		boolean check = false;
		do{
			printRMenu();
			System.out.println("주문하실 추천메뉴의 번호를 입력해주세요.");
			temp = s.nextLine().trim();
			check = IntegerCheck.checkInt(temp,0,rmenuList.size());
		}while(!check);
		
		int pos = rmenuList.get(Integer.parseInt(temp)-1).getFoodNo();
		CartVo cartVo = new CartVo(); 
		cartVo.setFoodNo(pos);
		do{
			System.out.println("수량을 입력해주세요.");
			temp = s.nextLine().trim();
			check = IntegerCheck.checkInt(temp);
		}while(!check);
		
		cartVo.setCount(Integer.parseInt(temp));
		cartDao.insertCart(cartVo);
	}
	public static void insertRMenu() {
		FoodDao foodDao = FoodDao.getInstance();
		RMenuDao rMenuDao = RMenuDao.getInstance();
		CartegoryDao categoryDao = CartegoryDao.getInstance();
		RecommendedMenuVo rMenuVo = new RecommendedMenuVo();
		ArrayList<Integer> indexSpace = new ArrayList<>();


		Boolean check = false;
		String temp = "";
		do{
		do {
			indexSpace=categoryDao.searchCategoryInfo();

			// 추천메뉴 카테고리 출력
			System.out.println("=======================================");
			
			for (int i = 0; i < indexSpace.size(); i++) {
				if (categoryDao.searchCategoryNoInfo(indexSpace.get(i)).isState()) {
					System.out.print(i+1+". ");
					System.out.println(categoryDao.searchCategoryNoInfo(indexSpace.get(i)).getMenu() + "\t");
				}
			}
			System.out.println("0. 이전 메뉴로 이동");
			System.out.println("=======================================");
			System.out.println("추가할 카테고리메뉴를 선택해주세요.");
			// 추천메뉴 no 입력
			
			temp= s.nextLine().trim();
			check = IntegerCheck.checkInt(temp,0,indexSpace.size()); 
		}while(!check);
		if(Integer.parseInt(temp)==0){
			return;
		}
		
		int categoryKey =indexSpace.get(Integer.parseInt(temp)-1); 

		indexSpace = foodDao.searchFoodInfo(categoryKey);
		
		do{
			System.out.println("=======================================");
			for (int i = 0; i < indexSpace.size(); i++) {

				int foodNo = foodDao.searchFoodNoInfo(indexSpace.get(i)).getNo();
				String name = foodDao.searchFoodNoInfo(foodNo).getName();
				int won = foodDao.searchFoodNoInfo(foodNo).getPrice();
				String sub_temp = "";

				int condition = 8;
				check = false;

				if (name.length() > condition) {
					sub_temp = name.substring(0, condition);
					name = name.substring(condition - 1, name.length());
					System.out.print(i + 1 + ". " + sub_temp);
					System.out.println("\t" + won+"원");
				} else {
					check = true;
					if (name.length() >= 4) {
						name = name + "\t";
					} else {
						name = name + "\t\t";
					}
					System.out.print(i + 1 + ". "+ name);
					System.out.println(won+"원");
				}
				if (!check) {
					do {
						if (name.length() > condition) {
							sub_temp = name.substring(0, condition);
							name = name.substring(condition - 1, name.length());
							System.out.println("       " + sub_temp);
						} else {
							System.out.println("       " + name);
							check = true;
						}
					} while (!check);
				}
			
			
			
			
			
			
			
			
			}
			System.out.println("0. 이전 메뉴로 이동");
			System.out.println("=======================================");

			System.out.println("추가할 추천메뉴 선택해주세요.");
			temp= s.nextLine().trim();
			check = IntegerCheck.checkInt(temp,0,indexSpace.size());
		} while (!check);
		if(Integer.parseInt(temp)==0){
			check = true;
		}else{
			int foodKey = indexSpace.get(Integer.parseInt(temp)-1);
			
			
			rMenuVo.setFoodNo(foodKey); // 푸드 키값 비교 해서 선택
			System.out.println("추천내용을 적어주세요 : ");
			rMenuVo.setContents(s.nextLine()); // 메뉴추가 정보입력
			
			
			rMenuDao.insertRMenu(rMenuVo); // 만들어진 기본키값을 넣어줌
			System.out.println("추가가 완료!");
			return;
		}
		  
		
		}while(check);
		
	}
	public static void deleteRMenu() {
		RMenuDao rMenuDao = RMenuDao.getInstance();
		ArrayList<RecommendedMenuVo> rMenuList = rMenuDao.selectRecommendedMenu();
		Boolean check = false;
		String temp = "";
		do {

			System.out.println("=======================================");
			for (int i = 0; i < rMenuList.size(); i++) {
				System.out.print(i+1+". ");
				System.out.print(rMenuDao.searchRecommendedMenuNo(
						rMenuList.get(i).getFoodNo()).getName()
						+ "\t");
				System.out.println(rMenuList.get(i).getContents());
			}
			System.out.println("0. 이전 메뉴로 이동");
			System.out.println("=======================================");
			temp = s.nextLine().trim();
			check = IntegerCheck.checkInt(temp,0,rMenuList.size());
		} while (!check);
		if(Integer.parseInt(temp)==0){
			return;
		}
		
		int pos = rMenuList.get(Integer.parseInt(temp)-1).getNo();
		rMenuDao.deleteRMenu(rMenuDao.searchRMenuNoInfo(pos));
		System.out.println("-------------------------------------------");
		System.out.println("성공적으로 삭제하였습니다.");
		System.out.println("-------------------------------------------");
		
	}
	public static void contentsModify() {
		RMenuDao rMenuDao = RMenuDao.getInstance();
		ArrayList<RecommendedMenuVo> rMenuList = rMenuDao.selectRecommendedMenu();
		Boolean check = false;
		String temp = "";
		do {	
			System.out.println("=======================================");
			System.out.println("내용을 수정하실 추천메뉴를 선택해주세요.");
			System.out.println("=======================================");
			for (int i = 0; i < rMenuList.size(); i++) {
				System.out.print(i+1+". ");
				System.out.print(rMenuDao.searchRecommendedMenuNo(
						rMenuList.get(i).getFoodNo()).getName()
						+ "\t");
				System.out.println(rMenuList.get(i).getContents());
			}
			System.out.println("0. 이전 메뉴로 이동");
			System.out.println("=======================================");
			temp = s.nextLine().trim();
			check = IntegerCheck.checkInt(temp,0,rMenuList.size());
		} while (!check);
		if(Integer.parseInt(temp)==0){
			return;
		}
		int pos = rMenuList.get(Integer.parseInt(temp)-1).getNo();
		System.out.println("-------------------------------------------");
		System.out.println("수정하실 내용을 입력해주세요.");
		System.out.println("-------------------------------------------");
		
		temp = s.nextLine();
		rMenuDao.searchRMenuNoInfo(pos).setContents(temp);
		
		System.out.println("-------------------------------------------");
		System.out.println("수정이 완료되었습니다.");
		System.out.println("-------------------------------------------");
		

	}
}
