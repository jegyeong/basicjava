package service;

import java.util.ArrayList;
import java.util.Scanner;







import vo.CartVo;
import vo.FoodVo;
import dao.CartDao;
import dao.CartegoryDao;
import dao.FoodDao;

public class Menu {
	static Scanner s = new Scanner(System.in);
	public static void deleteMenu(){
		CartegoryDao categoryDao = CartegoryDao.getInstance();
	
		FoodDao foodDao = FoodDao.getInstance();
		
	
		System.out.println("-----------------------------------------------");
		System.out.println("삭제하실 메뉴의 카테고리를 선택해주세요.");
		System.out.println("-----------------------------------------------");
		
		ArrayList<Integer> categoryList = categoryDao.searchCategoryInfo();
		String temp = "";
		Boolean check = false;
		do {
			
			for (int i = 0; i < categoryList.size(); i++) {
				System.out.println(i+ 1+ ". "
						+ categoryDao.searchCategoryNoInfo(categoryList.get(i)).getMenu());
			}
			System.out.println("0. 종료");
			System.out.println("-----------------------------------------------");
			
			
			temp = s.nextLine().trim();
			check = IntegerCheck.checkInt(temp,0,categoryList.size());
			
		} while (!check);
		
		if (Integer.parseInt(temp)==0){
			return;
		}
		
		int categoryNo = categoryList.get(Integer.parseInt(temp)-1);
		
		ArrayList<Integer>foodList = foodDao.searchFoodInfo(categoryNo);
		
		if(foodList.isEmpty()){
			System.out.println("-----------------------------------------------");
			System.out.println("해당 카테고리의 메뉴는 없습니다.");
			System.out.println("-----------------------------------------------");
			return;
		}
		
		do {
			System.out.println("-----------------------------------------------");
			System.out.println("제거할 메뉴를 선택해주세요.");
			for (int i = 0; i < foodList.size(); i++) {
				FoodVo foodvo = foodDao.searchFoodNoInfo(foodList.get(i));
				System.out.println(i + 1 + ". " + foodvo.getName());
			}
			System.out.println("0. 종료");
			System.out.println("-----------------------------------------------");
			
			temp = s.nextLine().trim();
			check = IntegerCheck.checkInt(temp,0,foodList.size());
			
		} while (!check);
		
		if (Integer.parseInt(temp)==0){
			return;
		}
		
		int foodNo = foodList.get(Integer.parseInt(temp)-1);
		
		do {
			System.out.println("-----------------------------------------------");

			System.out.println(foodDao.searchFoodNoInfo(foodNo).getName()+"을 삭제하시겠습니까?");
			System.out.println("삭제 : 1");
			System.out.println("취소 : 0");
			System.out.println("-----------------------------------------------");
			
			temp = s.nextLine().trim();
			check = IntegerCheck.checkInt(temp, 1);
			
		} while (!check);
		
		if(Integer.parseInt(temp)==1){
			foodDao.searchFoodNoInfo(foodNo).setState(false);

		}else{
			System.out.println("작업을 취소합니다.");
			return;
		}
		
	}
	public static void addMenu(){
	
		FoodDao foodDao = FoodDao.getInstance();
		CartegoryDao categoryDao = CartegoryDao.getInstance();
		ArrayList<Integer> categoryList = categoryDao.searchCategoryInfo();
		FoodVo foodvo = new FoodVo();
		Boolean check = false;
		
		System.out.println("-----------------------------------------------");
		System.out.println("추가 하실 메뉴명을 입력해주세요.");
		System.out.println("종료 하시려면 0을 입력해주세요.");
		System.out.println("-----------------------------------------------");
		String temp = s.nextLine().trim();
		
		for(int i = 0; i < foodDao.selectFoodList().size();i++){
			if(foodDao.selectFoodList().get(i).getName().equals(temp)){
				System.out.println("데이터 베이스에 중복된 정보가 존재합니다.\n기존의 정보로 메뉴를 생성합니다.");
				foodDao.selectFoodList().get(i).setState(true);
				return;
			}
		}
		
		if(temp.equals("0")){
			return;
		}else{
			foodvo.setName(temp);
		}
		
		
		System.out.println("-----------------------------------------------");
		System.out.println("메뉴의 카테고리를 선택해주세요.");
		System.out.println("-----------------------------------------------");
		
		do {
			for (int i = 0; i < categoryList.size(); i++) {

				System.out.println(i+1	
						+ ". "
						+ categoryDao.searchCategoryNoInfo(categoryList.get(i))
								.getMenu());

			}
			System.out.println("0. 종료");
			System.out.println("-----------------------------------------------");

			temp = s.nextLine().trim();
			check = IntegerCheck.checkInt(temp, 0,categoryList.size());

		} while (!check);

		
		
		
		if (Integer.parseInt(temp)==0){
			return;
		}
		
		int categoryNo = categoryList.get(Integer.parseInt(temp)-1);
		
		foodvo.setCategory(categoryNo);
		
		do {
			System.out.println("-----------------------------------------------");
			System.out.println("가격을 입력해주세요.");
			System.out.println("-----------------------------------------------");
			temp = s.nextLine().trim();
			check = IntegerCheck.checkInt(temp);
		} while (!check);
		
		foodvo.setPrice(Integer.parseInt(temp));
		System.out.println(categoryDao.searchCategoryNoInfo(foodvo.getCategory()).getMenu()+"에 "+foodvo.getName()+"의 메뉴가"+foodvo.getPrice()+"원으로 추가되었습니다.");
		foodDao.insertFood(foodvo);
		
	}
	public static void selectMenu() {
		FoodDao foodDao = FoodDao.getInstance();	
		CartDao cartDao = CartDao.getInstance();
		CartegoryDao categoryDao = CartegoryDao.getInstance();
		ArrayList<Integer> categoryList = categoryDao.searchCategoryInfo();
		
		String temp = "";
		boolean check = false;
		while(true){
		 do {
			System.out.println("-----------------------------------------------");
			System.out.println(" 주문 하시겠습니까 ??? "); // 주문
			System.out.println(" 원하시는 메뉴의 카테고리를 선택해 번호를 입력 해 주세요. ");
			
			for (int i = 0; i < categoryList.size(); i++) {
				int categoryNo  = categoryList.get(i);
				System.out.println(i+ 1+ ". "
						+ categoryDao.searchCategoryNoInfo(categoryNo).getMenu());
			}
			System.out.println("0. 그만 담기");
			System.out.println("-----------------------------------------------");

			temp = s.nextLine().trim();
			check = IntegerCheck.checkInt(temp,0,categoryList.size());
			
		} while (!check);
		 
		if(Integer.parseInt(temp) == 0){
			return;
		}
		
		int categoryNo = categoryList.get(Integer.parseInt(temp) - 1);//찾은 카테고리의 PK값인 No를 저장한다.
		ArrayList<Integer> foodList = foodDao.searchFoodInfo(categoryNo);//input에 저장되어있는 카테고리의pk값을 갖고 해당 카테고리의 음식을 추가시킨다.
		
		do {	
			if(foodList.isEmpty()){
				System.out.println("-----------------------------------------------");
				System.out.println("해당 카테고리 메뉴는 없습니다.");
				System.out.println("뒤로 돌아갑니다.");
				System.out.println("-----------------------------------------------");
				
			} else{
				System.out.println("-----------------------------------------------");
				System.out.println(categoryDao.searchCategoryNoInfo(categoryNo).getMenu() + "메뉴입니다.");
				System.out.println("원하시는 메뉴를 선택 해주세요");
				
				for(int i = 0 ; i < foodList.size();i++){
					int foodNo = foodList.get(i);
					String name = foodDao.searchFoodNoInfo(foodNo).getName();
					String sub_temp = "";
					
					int condition = 8;
					check = false;
					
					if(name.length() > condition){
						sub_temp = name.substring(0,condition);
						name=name.substring(condition-1,name.length());			
						System.out.print(i+1+". "+sub_temp);
						System.out.println("\t"+foodDao.searchFoodNoInfo(foodNo).getPrice()+"원");
					}else{
						check = true;
						if(name.length()>= 4){
							name=name+"\t";
						}else{
							name=name+"\t\t";
						}
						System.out.print(i+1+". "+name);
						System.out.println(foodDao.searchFoodNoInfo(foodNo).getPrice()+"원");
					}
					if(!check){
						do{
							if(name.length()>condition){
							sub_temp = name.substring(0,condition);
							name=name.substring(condition-1,name.length());	
							System.out.println("       "+sub_temp);
							}else {
								System.out.println("       "+name);
								check = true;
							}
						}while(!check);
					}
				}
				System.out.println("0. 이전 메뉴로 이동");
				System.out.println("-----------------------------------------------");

				temp = s.nextLine().trim();
				check = IntegerCheck.checkInt(temp,0,foodList.size());
			}
		} while (!check);
			
		if (!foodList.isEmpty()&&Integer.parseInt(temp)!=0){

				int foodNo = foodList.get(Integer.parseInt(temp) - 1);
				
				do {
					System.out.println("-----------------------------------------------");
					System.out.println(foodDao.searchFoodNoInfo(foodNo).getName() + "을 선택하셨습니다. \n몇개 주문 하시겠습니까?");
					System.out.println("입력 범위 (1 ~ 999)");
					System.out.println("-----------------------------------------------");
					temp = s.nextLine().trim();
					check = IntegerCheck.checkInt(temp,1,999);
				} while (!check);

				int count = Integer.parseInt(temp);

				CartVo cart;

				cart = new CartVo();
				cart.setCount(count);
				cart.setFoodNo(foodNo);
				cartDao.insertCart(cart);
				
			}
		
		}
		
	}
	public static void HomelessMenu() {
		boolean check = false;
		String temp = "";
		FoodDao foodDao = FoodDao.getInstance();

		CartegoryDao categoryDao = CartegoryDao.getInstance();
		do{
		// 카테고리가 없는 음식의 pk
		ArrayList<Integer> homelessList = foodDao.searchFoodHomeless();
		if(homelessList.isEmpty()){
			System.out.println("-----------------------------------------------");
			System.out.println("존재하지 않는 카테고리를 들고있는 메뉴가 없습니다.");
			System.out.println("-----------------------------------------------");
			return;
		}
		
		do {
			System.out.println("-----------------------------------------------");
			System.out.println("카테고리를 설정할 음식을 선택해주세요.");
			System.out.println("-----------------------------------------------");
			for (int i = 0; i < homelessList.size(); i++) {
				
				int foodNo = homelessList.get(i);
				String name = foodDao.searchFoodNoInfo(foodNo).getName();
				String sub_temp = "";
				
				int condition = 8;
				check = false;
				
				if(name.length() > condition){
					sub_temp = name.substring(0,condition);
					name=name.substring(condition-1,name.length());			
					System.out.print(i+1+". "+sub_temp);
					System.out.println("\t"+foodDao.searchFoodNoInfo(foodNo).getPrice()+"원");
				}else{
					check = true;
					if(name.length()>= 4){
						name=name+"\t";
					}else{
						name=name+"\t\t";
					}
					System.out.print(i+1+". "+name);
					System.out.println(foodDao.searchFoodNoInfo(foodNo).getPrice()+"원");
				}
				if(!check){
					do{
						if(name.length()>condition){
						sub_temp = name.substring(0,condition);
						name=name.substring(condition-1,name.length());	
						System.out.println("       "+sub_temp);
						}else {
							System.out.println("       "+name);
							check = true;
						}
					}while(!check);
				}
				
			
				
			}
			System.out.println("0. 이전 메뉴로 이동");
			System.out.println("-----------------------------------------------");
			// 새로운 집으로 넣어주는 코딩
			// true인 카테고리에

			temp = s.nextLine().trim();
			check = IntegerCheck.checkInt(temp, 0, homelessList.size());

		} while (!check);
		// 음식의 값

		if (Integer.parseInt(temp) == 0) {
			return;
		}

		int foodNo = homelessList.get(Integer.parseInt(temp) - 1);

		// 존재하는 카테고리의 pk
		ArrayList<Integer> CategoryList = categoryDao.searchCategoryInfo();
		
		

		do {
			System.out.println("-----------------------------------------------");
			System.out.println("선택한 음식의 변경할 카테고리를 선택해주세요.");
			System.out.println("-----------------------------------------------");
			for (int i = 0; i < CategoryList.size(); i++) {
				System.out.print(i + 1 + ". ");
				System.out.println(categoryDao.searchCategoryNoInfo(CategoryList.get(i)).getMenu());

			}
			System.out.println("0. 이전 메뉴로 이동");
			System.out.println("-----------------------------------------------");
			temp = s.nextLine().trim();
			check = IntegerCheck.checkInt(temp, 0, CategoryList.size());

		} while (!check);

		if (Integer.parseInt(temp) == 0) {
			check = true;
		}else{
		
		int categoryNo = CategoryList.get(Integer.parseInt(temp) - 1);

		foodDao.searchFoodNoInfo(foodNo).setCategory(categoryDao.searchCategoryNoInfo(categoryNo).getNo());
		foodDao.searchFoodNoInfo(foodNo).setState(true);
		System.out.println("-----------------------------------------------------------");
		System.out.print(foodDao.searchFoodNoInfo(foodNo).getName());
		System.out.print("의 카테고리가 ");
		System.out.print(categoryDao.searchCategoryNoInfo(categoryNo).getMenu());
		System.out.println("로 변경되었습니다.");
		System.out.println("-----------------------------------------------------------");
	}
	}while(check);
	}
	public static void priceModify(){
		
		CartegoryDao categoryDao = CartegoryDao.getInstance();
		
		FoodDao foodDao = FoodDao.getInstance();
		
		Boolean check = false;
		
		
		do{
			ArrayList<Integer> categoryList = categoryDao.searchCategoryInfo();
			
		System.out.println("-----------------------------------------------");
		System.out.println("수정하실 메뉴의 카테고리를 선택해주세요.");
	
		String temp = "";
		
		do {
			for (int i = 0; i < categoryList.size(); i++) {
				System.out.println(i+ 1+ "."
						+ categoryDao.searchCategoryNoInfo(categoryList.get(i)).getMenu());
			}
			System.out.println("0. 이전 메뉴로 이동");

			System.out.println("-----------------------------------------------");
			
			
			temp = s.nextLine().trim();
			check = IntegerCheck.checkInt(temp,0,categoryList.size());
			
		} while (!check);
		
		if(temp.equals("0")){
			return;
		}
		
		
		int categoryNo = categoryList.get(Integer.parseInt(temp)-1);
		
		ArrayList<Integer> foodList = foodDao.searchFoodInfo(categoryNo);
		
		if(foodList.isEmpty()){
			System.out.println("-----------------------------------------------");
			System.out.println("해당 카테고리의 메뉴는 없습니다.");
			System.out.println("-----------------------------------------------");
			return;
		}
		
		do {
			System.out.println("-----------------------------------------------");
			System.out.println("수정할 메뉴를 선택해주세요.");
			for (int i = 0; i < foodList.size(); i++) {
				
				
				int foodNo = foodList.get(i);
				String name = foodDao.searchFoodNoInfo(foodNo).getName();
				String sub_temp = "";
				
				int condition = 8;
				check = false;
				
				if(name.length() > condition){
					sub_temp = name.substring(0,condition);
					name=name.substring(condition-1,name.length());			
					System.out.print(i+1+". "+sub_temp);
					System.out.println("\t"+foodDao.searchFoodNoInfo(foodNo).getPrice()+"원");
				}else{
					check = true;
					if(name.length()>= 4){
						name=name+"\t";
					}else{
						name=name+"\t\t";
					}
					System.out.print(i+1+". "+name);
					System.out.println(foodDao.searchFoodNoInfo(foodNo).getPrice()+"원");
				}
				if(!check){
					do{
						if(name.length()>condition){
						sub_temp = name.substring(0,condition);
						name=name.substring(condition-1,name.length());	
						System.out.println("       "+sub_temp);
						}else {
							System.out.println("       "+name);
							check = true;
						}
					}while(!check);
				}
				
				
			}
			System.out.println("0. 이전 메뉴로 이동");
			System.out.println("-----------------------------------------------");

			temp = s.nextLine().trim();
			check = IntegerCheck.checkInt(temp, 0, foodList.size());

		} while (!check);
		
		if (Integer.parseInt(temp) == 0) {
			check = true;
		}else{
		
		int foodNo = foodList.get(Integer.parseInt(temp)-1);
		
		
		do {
			System.out.println(foodDao.searchFoodNoInfo(foodNo).getPrice() + "-> 변경할 가격을 입력해주세요.");
			temp = s.nextLine().trim();
			check = IntegerCheck.checkInt(temp);
		} while (!check);
		

		foodDao.searchFoodNoInfo(foodNo).setPrice(Integer.parseInt(temp));
	
		System.out.println(categoryDao.searchCategoryNoInfo(categoryNo).getMenu()
				+ "에 " + foodDao.searchFoodNoInfo(foodNo).getName() + "의 메뉴가 " 
				+ foodDao.searchFoodNoInfo(foodNo).getPrice() + "원으로 변경되었습니다.");
		
		return;
		}
		}while(check);
	}
	public static void menuModify() {	
		
		CartegoryDao categoryDao = CartegoryDao.getInstance();
		ArrayList<Integer> categoryList = categoryDao.searchCategoryInfo();
		FoodDao foodDao = FoodDao.getInstance();
		FoodVo foodvo = new FoodVo();
		
	
		String temp = "";
		Boolean check = false;
		do{
		do {
			System.out.println("-----------------------------------------------");
			System.out.println("수정하실 메뉴의 카테고리를 선택해주세요.");
			for (int i = 0; i < categoryList.size(); i++) {
				System.out.println(i + 1+ "."
						+ categoryDao.searchCategoryNoInfo(categoryList.get(i)).getMenu() + "  ");
			}
			System.out.println("0. 이전 메뉴로 이동");
			System.out.println("-----------------------------------------------");
			
			temp = s.nextLine().trim();
			check = IntegerCheck.checkInt(temp,0,categoryList.size());
			
		} while (!check);
		
		if (Integer.parseInt(temp) == 0) {
			return;
		}
		
		int categoryNo = categoryList.get(Integer.parseInt(temp)-1);
		
		ArrayList<Integer> foodList = foodDao.searchFoodInfo(categoryNo);
		
		if(foodList.isEmpty()){
			System.out.println("-----------------------------------------------");
			System.out.println("해당 카테고리의 메뉴는 없습니다.");
			System.out.println("-----------------------------------------------");
			return;
		}
		
		do {
			System.out.println("-----------------------------------------------");
			System.out.println("수정할 메뉴를 선택해주세요.");
			for (int i = 0; i < foodList.size(); i++) {
				foodvo = foodDao.searchFoodNoInfo(foodList.get(i));
				System.out.println(i + 1 + ". " + foodvo.getName());
			}
			System.out.println("0. 이전 메뉴로이동");
			System.out.println("-----------------------------------------------");
			
			temp = s.nextLine().trim();
			check = IntegerCheck.checkInt(temp, 0, foodList.size());

		} while (!check);
		
		if (Integer.parseInt(temp) == 0) {
			check = true;
		}else{
		// 수정된 이름이 들어갈 자리
			
			
	
		int foodNo = foodList.get(Integer.parseInt(temp) - 1);

		
		System.out.println("-----------------------------------------------");
		System.out.println(foodDao.searchFoodNoInfo(foodNo).getName() + "의 변경할 이름을 입력해주세요.");
		System.out.println("-----------------------------------------------");
		temp = s.nextLine().trim();
	
		
		System.out.println("-----------------------------------------------");
		System.out.print(categoryDao.searchCategoryNoInfo(categoryNo).getMenu()
				+ "에 " + foodDao.searchFoodNoInfo(foodNo).getName());
		foodDao.searchFoodNoInfo(foodNo).setName(temp);
		System.out.println("의 메뉴가 " + foodDao.searchFoodNoInfo(foodNo).getName() + "으로 변경되었습니다.");
		System.out.println("-----------------------------------------------");
		
		}
		}while(check);
	}
	public static void menuManagement(){
		
		boolean check = true;
		String temp = "";
		do{
			do {
				System.out.println("----------------------------------------");
				System.out.println("메뉴관리 메뉴입니다.");
				System.out.println("1. 메뉴 추가");
				System.out.println("2. 메뉴 삭제");
				System.out.println("3. 판매중인 메뉴 이름 수정");
				System.out.println("4. 판매중인 메뉴 가격 수정");
				System.out.println("5. 카테고리가 없는 메뉴 설정");
				System.out.println("0. 이전 메뉴로 이동");
				System.out.println("----------------------------------------");

				temp = s.nextLine();
				check = IntegerCheck.checkInt(temp,0,5);
				
			} while (!check);
	        int menu = Integer.parseInt(temp);
			
			switch (menu) {
			case 1:
				addMenu();
				break;
			case 2:
				deleteMenu();
				break;
			case 3:
				menuModify();
				break;
			case 4:
				priceModify();
				break;
			case 5 : 
				HomelessMenu();
				break; 
			case 0:
				System.out.println("이전 메뉴로 돌아갑니다.");
				check = false;	
			}
		}while(check);
		
		
	}
}
 