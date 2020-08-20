package dao;

import java.util.ArrayList;


import vo.TableVo;
import data.Database;

public class TableDao {
	
		private static TableDao instance;

		private TableDao() {
		}

		public static TableDao getInstance() {
			if (instance == null) {
				instance = new TableDao();
			}
			return instance;

		}
		
		Database database = Database.getInstance();
		
		public int maxPeople(){
			int max = 0;
			for(int i = 0; i < database.tb_table.size(); i++){
			 max+=database.tb_table.get(i).getPossiblepeople()-database.tb_table.get(i).getEnterpeople();
			}
			return  max;
		}
		public ArrayList<TableVo> selectTable(){//모든 테이블리스트를 리턴해준다.
			return database.tb_table;
		}
		public ArrayList<TableVo> notUsingTableList(int enterNum){ //매개변수로 입력받은 인원가 입장이 가능한 테이블리스트를 리턴해준다.			
			ArrayList<TableVo> Tablelist = new ArrayList<>();
			for(int i = 0; i < database.tb_table.size(); i++){
				if(database.tb_table.get(i).getPossiblepeople()>=enterNum&&database.tb_table.get(i).getEnterpeople()==0)
				Tablelist.add(database.tb_table.get(i));
			}			
			return Tablelist;	
		}
		
		public TableVo searchTalbeNoInfo(int tableNo){ //매개변수로 입력받은 테이블번호의 정보를 리턴한다.			
			
			for(int i = 0; i < database.tb_table.size(); i++){
				if(database.tb_table.get(i).getTablenumber()==tableNo)
					return database.tb_table.get(i);
			}			
			return null;	
		}
		
		
		
		public void setTable(TableVo table,int num){	
			database.tb_table.set(num,table);	
		}
		public void deleteTable(TableVo TableVo){
			database.tb_table.remove(TableVo);		
			}
		public void tablecreate(TableVo table){
			if(database.tb_table.size()>0){
				table.setTablenumber(database.tb_table.get(database.tb_table.size()-1).getTablenumber()+1);//중복없이 기본키를 입력한다.
				database.tb_table.add(table);
			}else{
				table.setTablenumber(0);//중복없이 기본키를 입력한다.
				database.tb_table.add(table);
			}		
		}
}
