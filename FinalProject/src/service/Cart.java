package service;

import java.util.ArrayList;
import java.util.Scanner;

import vo.CartVo;
import dao.CartDao;
import dao.FoodDao;
import dao.PaymentDao;


public class Cart {
	static Scanner s = new Scanner(System.in);
	public static int printCart() {//주문내역
		PaymentDao paymentDao = PaymentDao.getInstance();
		FoodDao foodDao = FoodDao.getInstance();	
		int sum = 0;
		System.out.println("---------------------------------------------------");
		System.out.println("\t\t주문내역\t\t");
		System.out.println("---------------------------------------------------");
		System.out.println("상품명\t\t가격\t\t수량");
		ArrayList<CartVo> notPayment = paymentDao.notPaymentList();
 
		//계산 안된 애들만 출력
		
		for(int i =0 ;i<notPayment.size();i++){
			int foodNo = notPayment.get(i).getFoodNo();//음식의 PK값	
			String name = foodDao.searchFoodNoInfo(foodNo).getName();
			String sub_temp = "";
			
			int condition = 10;
			boolean check = false;
			
			if(name.length()>condition){
				sub_temp = name.substring(0,condition);
				name = name.substring(condition-1,name.length());			
				System.out.println(sub_temp+"\t"+foodDao.searchFoodNoInfo(foodNo).getPrice()+"\t\t"+notPayment.get(i).getCount());
				sum += foodDao.searchFoodNoInfo(foodNo).getPrice() * notPayment.get(i).getCount();
			}else{
				check = true;
				if(name.length() >= 6){
					name=name+"\t";
				}else{
					name=name+"\t\t";
				}
					
				System.out.println(name+foodDao.searchFoodNoInfo(foodNo).getPrice()+"\t\t"+notPayment.get(i).getCount());
				sum += foodDao.searchFoodNoInfo(foodNo).getPrice() * notPayment.get(i).getCount();
			}
			if(!check){
				do{
					if(name.length()>condition){
					sub_temp = name.substring(0,condition);
					name = name.substring(condition-1,name.length());	
					System.out.println(sub_temp);
					}else {
						System.out.println(name);
						check = true;
					}
				}while(!check);
			}
		}
		System.out.println("합계 :" + sum);
		return sum;
	}
	public static void orderModify(){
		CartDao cartDao = CartDao.getInstance();
	
		FoodDao foodDao = FoodDao.getInstance();
		
		boolean check =false;
		String temp = "";
		do{
			ArrayList<CartVo> cartList = cartDao.selectCartList();
		do{
			
		System.out.println("-------------------------------------");
		System.out.println("수정하시거나 취소할 메뉴를 선택해주세요.");
		System.out.println("-------------------------------------");
		System.out.println("순번\t음식명\t\t수량");
			for (int i = 0; i < cartList.size(); i++) {

				int foodNo = cartList.get(i).getFoodNo();
				String name = foodDao.searchFoodNoInfo(foodNo).getName();
				String sub_temp = "";

				int condition = 8;
				check = false;

				if (name.length() > condition) {
					sub_temp = name.substring(0, condition);
					name = name.substring(condition - 1, name.length());
					System.out.print(i + 1 + "\t" + sub_temp);
					System.out.println("\t" + cartList.get(i).getCount());
				} else {
					check = true;
					if (name.length() >= 6) {
						name = name + "\t";
					} else {
						name = name + "\t\t";
					}
					System.out.print(i + 1 + "\t" + name);
					System.out.println(cartList.get(i).getCount());
				}
				if (!check) {
					do {
						if (name.length() > condition) {
							sub_temp = name.substring(0, condition);
							name = name.substring(condition - 1, name.length());
							System.out.println("\t" + sub_temp);
						} else {
							System.out.println("\t" + name);
							check = true;
						}
					} while (!check);
				}

			}
			System.out.println("0. 이전 메뉴로 이동");
		System.out.println("-------------------------------------");
		temp=s.nextLine().trim();
		check = IntegerCheck.checkInt(temp, 0, cartList.size());
		}while(!check);
		
		if(temp.equals("0")){
			return;
		}
		
		int pos = cartList.get(Integer.parseInt(temp)-1).getNo();
		
		do{
			System.out.println(foodDao.searchFoodNoInfo(cartDao.searchCartNoInfo(pos).getFoodNo()).getName()+"가 선택되었습니다.");
			System.out.println("-------------------------------------");
			System.out.println("1. 수량 수정");
			System.out.println("2. 주문 취소");
			System.out.println("0. 이전 메뉴로 이동");
			System.out.println("-------------------------------------");
			temp = s.nextLine().trim();
			check = IntegerCheck.checkInt(temp, 0,2);
		}while(!check);
		
		if(!temp.equals("0")){
			int menu = Integer.parseInt(temp);
			switch(menu){
			case 1: 
				do{
					System.out.println("-------------------------------------");
				System.out.println("현재 수량은 "+cartDao.searchCartNoInfo(pos).getCount()+"개 입니다.");
				System.out.println("몇개로 수정하시겠습니까 ? ");
				System.out.println("-------------------------------------");
				temp=s.nextLine().trim();
				check = IntegerCheck.checkInt(temp);
				 if(Integer.parseInt(temp)<1){
					 System.out.println("-------------------------------------");
					 System.out.println("수량을 1개 이상으로 입력해주세요.");
					 System.out.println("-------------------------------------");
					 check = false;
				 }
				}while(!check);
				
				int count = Integer.parseInt(temp);
				cartDao.searchCartNoInfo(pos).setCount(count);
				System.out.println("-------------------------------------");
				System.out.println("성공적으로 주문내역을 수정하였습니다.");
				System.out.println("-------------------------------------");
				break;
			case 2:
				do{
					System.out.println("------------------------------------------------");
				System.out.println(foodDao.searchFoodNoInfo(cartDao.searchCartNoInfo(pos).getFoodNo()).getName()+"을 삭제하시겠습니까?");
				System.out.println("1. 삭제");
				System.out.println("0. 삭제취소");
				System.out.println("------------------------------------------------");
				temp=s.nextLine().trim();
				check = IntegerCheck.checkInt(temp,0,1);
				}while(!check);
				
				menu = Integer.parseInt(temp);
				
				switch(menu){
				case 1:
					System.out.println(foodDao.searchFoodNoInfo(cartDao.searchCartNoInfo(pos).getFoodNo()).getName()+"의 주문내역을 성공적으로 삭제하였습니다.");
					cartDao.deleteCart(cartDao.searchCartNoInfo(pos));
					break;
				case 2:
					return;
				}
				break;
			}
			
		}else {
			check = true;
		}
		} while(check);
		
		
	}
	public static boolean paymentstate(){
		CartDao cartDao = CartDao.getInstance();
		ArrayList<CartVo> cartList = cartDao.selectCartList();
		

		boolean state = true;
		
		if(cartList.size()>0){
			state = false;
		}
	
		return state;
	}		
}
