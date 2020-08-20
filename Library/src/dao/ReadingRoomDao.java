package dao;

import java.util.ArrayList;

import data.Database;
import vo.ReadingRoomVO;


public class ReadingRoomDao {
	
private static ReadingRoomDao instance;
	
	private ReadingRoomDao(){}
	
	public static ReadingRoomDao getInstance(){
		if(instance == null){
			instance = new ReadingRoomDao();
		}
		return instance;
	}
	
	Database database = Database.getInstance();
	
	
	public void insertRoom(ReadingRoomVO seatNum) {
		database.tb_readingroom.add(seatNum);
	}

	public ArrayList<ReadingRoomVO> selectroom(){

		return database.tb_readingroom;
	}
	
	public void setState(ReadingRoomVO room, int num){
		database.tb_readingroom.set(num,room);
		
	}
	
	
	
	
	
}
