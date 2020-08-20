package dao;

import java.util.ArrayList;

import vo.FoodVo;
import data.Database;

public class FoodDao {
	private static FoodDao instance;

	private FoodDao() {
		
	}

	public static FoodDao getInstance() {
		if (instance == null) {
			instance = new FoodDao();
		}
		return instance;

	}

	Database database = Database.getInstance();


	
	public void insertFood(FoodVo food) {
		if(!database.tb_food.isEmpty()){
			food.setNo(database.tb_food.get(database.tb_food.size()-1).getNo()+1);//중복없이 기본키를 입력한다.			
		}else{
			food.setNo(0);
		}
		database.tb_food.add(food);
		
	}
	public void deleteFood(FoodVo food) {
		database.tb_food.remove(food);
	}
	public ArrayList<FoodVo> selectFoodList() {

		return database.tb_food;
	}
	
	public FoodVo searchFoodNoInfo(int no) {//int형 no의 값을 받아 데이터베이스에 저장되어있는 pk인 no값과 동일한 foodvo의 값을 반환한다.
		for(int i = 0;i<database.tb_food.size();i++){
			if(database.tb_food.get(i).getNo()==no){
				return database.tb_food.get(i);
			}
		}
		return null;
	}
	public ArrayList<Integer> searchFoodInfo(int categoryKey) {//선택된 카테고리에 있는 음식을 array에 담아서 반환
		
		ArrayList<Integer> arrayList = new ArrayList<>();

		for(int i = 0 ; i<database.tb_food.size();i++){
			if(database.tb_food.get(i).getCategory() == categoryKey&&database.tb_food.get(i).isState()){
				arrayList.add(database.tb_food.get(i).getNo());
			}
		}
		return arrayList;// Integer형 Arraylist를 반환한다..
	}
	
	public ArrayList<Integer> searchFoodInfo2(int categoryKey) {//선택된 카테고리에 있는 음식을 array에 담아서 반환
		
		ArrayList<Integer> arrayList = new ArrayList<>();

		for(int i = 0 ; i<database.tb_food.size();i++){
			if(database.tb_food.get(i).getCategory() == categoryKey){
				arrayList.add(database.tb_food.get(i).getNo());
			}
		}
		return arrayList;// Integer형 Arraylist를 반환한다..
	}
	
	
	public ArrayList<Integer> searchFoodHomeless() {//선택된 카테고리에 있는 음식을 array에 담아서 반환
		
		ArrayList<Integer> arrayList = new ArrayList<>();

		for(int i = 0 ; i<database.tb_food.size();i++){
			if(!database.tb_food.get(i).isState()){
				arrayList.add(database.tb_food.get(i).getNo());
			}
		}
		return arrayList;// Integer형 Arraylist를 반환한다..
	}
}

