package dao;

import java.util.ArrayList;


import vo.MenuCategoryVo;
import data.Database;

public class CartegoryDao {
	private static CartegoryDao instance;

	private CartegoryDao() {
		
	}

	public static CartegoryDao getInstance() {
		if (instance == null) {
			instance = new CartegoryDao();
		}
		return instance;

	}

	Database database = Database.getInstance();
	
	public int insertCategory(MenuCategoryVo category) {
		if(!database.tb_cartegory.isEmpty()){
			category.setNo(database.tb_cartegory.get(database.tb_cartegory.size()-1).getNo()+1);//중복없이 기본키를 입력한다.
		}else{
			category.setNo(0);
		}
		database.tb_cartegory.add(category);
		
		return category.getNo();
	}
	public void deleteCategory(MenuCategoryVo category) {
		database.tb_cartegory.remove(category);
	}
	public ArrayList<MenuCategoryVo> selectCartegoryList() { //모든 cartVo를 불러온다.
		return database.tb_cartegory;
	}
	
	public MenuCategoryVo searchCategoryNoInfo(int no){//MenuCategoryVo의 기본키를 매개변수에 입력하면 해당 기본키를 갖은 MenuCategoryVo값 리턴
		for(int i = 0;i<database.tb_cartegory.size();i++){
			if(database.tb_cartegory.get(i).getNo()==no){
				return database.tb_cartegory.get(i);
			}
		}
		return null;
	}
	public ArrayList<Integer> searchCategoryInfo() {//카테고리의 기본키를 list로 리턴
		
		ArrayList<Integer> arrayList = new ArrayList<>();
		
		for(int i = 0;i<database.tb_cartegory.size();i++){
			if(database.tb_cartegory.get(i).getNo()!=99&&database.tb_cartegory.get(i).isState()){
				arrayList.add(database.tb_cartegory.get(i).getNo());
			}
		}
		
		for(int i = 0;i<database.tb_cartegory.size();i++){
			if(database.tb_cartegory.get(i).getNo()==99&&database.tb_cartegory.get(i).isState()){
				arrayList.add(database.tb_cartegory.get(i).getNo());
				break;
			}
		}
		
		return arrayList;// Integer형 Arraylist를 반환한다..
	}
}
