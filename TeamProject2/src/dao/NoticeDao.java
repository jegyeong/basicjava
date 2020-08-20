package dao;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import service.NoticeService;
import database.Database;
public class NoticeDao {
	
	
	
	
	
	Database db = Database.getInstance();  
	SimpleDateFormat sdft = new SimpleDateFormat("yyyyMMdd");
	   Scanner s = new Scanner(System.in);
	      
	   public void showNoticeList(){
	      boolean isNoticeEmpty = false;
	      do{
	         if(db.noticeList.size() !=0 ){
	            isNoticeEmpty = true;
	            System.out.println("\n\n제목\t\t\t게시날짜\t\t\t글번호");
	            for (int i = 0; i < db.noticeList.size(); i++) {        //noticeList의 공지 목록을 보여줌
	               String title = db.noticeList.get(i).getNoticeTitle();
	               String date = sdft.format(db.noticeList.get(i).getNotiDate());
	               String number = db.noticeList.get(i).getNoticeNum();
	               System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
	               System.out.println(Integer.toString(i+1) +". "+ title  +"\t\t"+ date + "\t\t" + number);
	            }
	            System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓\n");
	            System.out.println(" 열람하실 공지사항의 번호를 골라주세요.");
	            boolean isFinish = false;
	            do {
	               int getNoticeNum = Integer.parseInt(s.nextLine());
	               if(getNoticeNum <= db.noticeList.size() ){
	                  System.out.println("제목: ( " + db.noticeList.get(getNoticeNum-1).getNoticeTitle() + " ) 를 선택하셨습니다.\n\n");
	                  makeNoticeTitleForm(getNoticeNum);
	                  isFinish = true;
	               }else{
	               System.out.println(" 잘못된 입력입니다. 다시 선택해주세요");      
	               }
	            }while(!isFinish);
	         }else {
	            try{
	            System.out.println(" 등록된 공지사항이 없습니다! 메인메뉴로 돌아갑니다.\n");
	            Thread.sleep(700);
	            break;
	            }catch (Exception e) {
	               e.printStackTrace();
	            }
	         }         
	      }while(!isNoticeEmpty);
	   }
	   
	   public void makeNoticeTitleForm (int getNum){
	   
	      try{
	         System.out.println(" 선택하신 공지를 가져오고 있습니다....\n 잠시만 기다려주십시오.\n");
	         Thread.sleep(500);         
	         }catch (Exception e) {
	            e.printStackTrace();
	         }
	      int contentLength = db.noticeList.get(getNum-1).getNoticeContent().length();
	      int titleLength = db.noticeList.get(getNum-1).getNoticeTitle().length();
	            
	      if(contentLength>titleLength){
	      noticeRectangle(contentLength/titleLength+3,contentLength+15,getNum);
	      }else{
	    	  noticeRectangle(titleLength/contentLength+3, titleLength+10, getNum);
	      }
	   }   
	   
	   void noticeRectangle(int height, int width, int getNum)   {
	      NoticeService nsv = new NoticeService();
	      
	      for (int i = 1; i <= height; i++)   {
	         for (int j = 1; j <= width; j++)   {
	            if (i==1 || i==height )   
	               System.out.print("▒");
	            else{
	               if(i==2){
	                  System.out.println("No: " + db.noticeList.get(getNum-1).getNoticeNum()); 
	                  //제목 끝을채우는 로직
	                  System.out.print("제목: " + db.noticeList.get(getNum-1).getNoticeTitle()); 
	                  System.out.println("\n");
	                  //3번째 칸 끝을 채우는 로직
	                  System.out.print("내용: " + db.noticeList.get(getNum-1).getNoticeContent()); 
	                  //내용줄 끝을 채우는 로직
	                  break;                  
	               }
	               System.out.print(" ");                  
	            }
	         }
	            System.out.print("\n");
	      }      
	      nsv.returnMainmenu();
	   }

	   public static String rightPadding(String str, int num) {
	      
	      
	        return String.format("%1$-" + num + "s", str);
	        
	        
	    }   
	      
	}