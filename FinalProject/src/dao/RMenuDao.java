package dao;

import java.util.ArrayList;

import vo.FoodVo;
import vo.RecommendedMenuVo;
import data.Database;

public class RMenuDao {
   private static RMenuDao instance;

   private RMenuDao() {
   }

   public static RMenuDao getInstance() {
      if (instance == null) {
         instance = new RMenuDao();
      }
      return instance;

   }
   Database database = Database.getInstance();
   FoodDao fooddao = FoodDao.getInstance();
   
   public void insertRMenu(RecommendedMenuVo rmenu) {
		if (!database.tb_rmenu.isEmpty()) {
			rmenu.setNo(database.tb_rmenu.get(database.tb_rmenu.size() - 1)
					.getNo() + 1);// 중복없이 기본키를 입력한다.
		} else {
			rmenu.setNo(0);
		}
		database.tb_rmenu.add(rmenu);

	}
   public ArrayList<RecommendedMenuVo> selectRecommendedMenu(){ //추천메뉴 어리이리스트에 저장
      return database.tb_rmenu;
   }
   public FoodVo searchRecommendedMenuNo(int no){
      for(int i =0; i<database.tb_food.size();i++){  //(추천메뉴에 저장)추천메뉴의 foodvo 랑 food의 pk값 비교 해서 같으면 데이터베이스에 추가
         if(database.tb_food.get(i).getNo()==no){
            return database.tb_food.get(i);
         }
      }
      return null;
   }
   public void deleteRMenu(RecommendedMenuVo rMenu){ // 추천메뉴에 있는 메뉴를 푸드 데이터베이스랑비교해서 삭제
      database.tb_rmenu.remove(rMenu);
   } 
   public RecommendedMenuVo searchRMenuNoInfo(int no){ //int형 값을받아 데이터베이스에 저장된 값과 같으면 출력
      for(int i =0; i<database.tb_rmenu.size(); i++){  //주문시 출력
         if(database.tb_rmenu.get(i).getNo()==no){
            return database.tb_rmenu.get(i);
         }
      }
      return null;
   } 
}




















