package dao;

import java.util.ArrayList;

import data.Database;
import vo.ReadingRoomListVO;

public class ReadingRoomListDao {
	
private static ReadingRoomListDao instance;
	
	private ReadingRoomListDao(){}
	
	public static ReadingRoomListDao getInstance(){
		if(instance == null){
			instance = new ReadingRoomListDao();
		}
		return instance;
	}
	
	
	
	Database database = Database.getInstance();
	
	public void insertroom(ReadingRoomListVO setSeatNum) {
		database.tb_readingroomlist.add(setSeatNum);
		
	}

	public ArrayList<ReadingRoomListVO> selectroom() {
		
		return database.tb_readingroomlist;
	}
	public int SelectUser(String id){
		
		for(int i = 0; i < database.tb_readingroomlist.size(); i++){
			if(database.tb_readingroomlist.get(i).getUserId() == id){
				return i;	
			}
		}
		return -1;
	}
	
	public void deleteUser(int dele){
		database.tb_readingroomlist.remove(dele);
		
	}
	

public void insertUser(int index, int seatnum){
	database.tb_readingroomlist.get(index).setSeatNum(seatnum);
}
}
