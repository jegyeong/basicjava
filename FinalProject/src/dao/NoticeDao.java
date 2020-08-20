package dao;

import java.util.ArrayList;

import vo.NoticeVo;
import data.Database;

public class NoticeDao {
	private static NoticeDao instance;

	private NoticeDao() {

	}

	public static NoticeDao getInstance() {
		if (instance == null) {
			instance = new NoticeDao();
		}
		return instance;

	}
	Database database = Database.getInstance();
	
	public void insertNotice(NoticeVo notice){
		
		if(!database.tb_notice.isEmpty()){
			notice.setNo(database.tb_notice.get(database.tb_notice.size()-1).getNo()+1);
		} else{
			notice.setNo(0);
		}
		
		database.tb_notice.add(notice);	
		
		
	} 
	
	public NoticeVo searchNoiceNoInfo(int noticeNo){
		
		for(int i = 0 ; i < database.tb_notice.size();i++){
			if(database.tb_notice.get(i).getNo() == noticeNo)
				return database.tb_notice.get(i);
		}
		
		
		return null;
	}
	
	public void deleteNotice(NoticeVo NoticeVo){
		database.tb_notice.remove(NoticeVo);
	}
	
	
	public ArrayList<NoticeVo> selectNoticeList() {
		return database.tb_notice;
	}
	
	
	public ArrayList<Integer> NoticeList(){
		ArrayList<Integer> indexLiset  = new ArrayList<>();
		for(int i = 0 ; i < database.tb_notice.size();i++){
			indexLiset.add(database.tb_notice.get(i).getNo());
			}
		
		return indexLiset;
	}
}
