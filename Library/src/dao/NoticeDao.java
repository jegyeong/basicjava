package dao;

import java.util.ArrayList;

import vo.NoticeVO;
import data.Database;

public class NoticeDao {
   
   Database database = Database.getInstance();
   private static NoticeDao instance;
   
   private NoticeDao() {}

   public static NoticeDao getInstance() {
      if (instance == null) {
         instance = new NoticeDao();
      }
      return instance;
   }
   
   
   public void insertNotice(NoticeVO notice) {
      database.tb_notice.add(notice);

   }
   
   public void noticeedit(NoticeVO notice){
	   
   }
   
   public NoticeVO selectnotice(NoticeVO notice)
   {
	   for(int i = 0; i<database.tb_notice.size();i++)
	   {
		   if(notice.getNoticeNum()==database.tb_notice.get(i).getNoticeNum())
		   {
			   return database.tb_notice.get(i);
		   }
	   }
	   return null;
   }
   
   public ArrayList<NoticeVO> selectNoticeList() {
   return database.tb_notice;
   }

   public void deleteNotice(NoticeVO notice){ //공지제거
      database.tb_notice.remove(notice);
   }
   


}
