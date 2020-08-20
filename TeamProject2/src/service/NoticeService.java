package service;
import java.util.Scanner;

import dao.NoticeDao;

public class NoticeService {
	   
	   NoticeDao ndo = new NoticeDao();
	   Scanner s = new Scanner(System.in);
	   
	   public void showNoticeList () {      //일반회원 , 사업자, 비회원에게 공지사항 목록을 뿌려주는 메서드
	      try{
	         System.out.println("공지사항을 불러오고 있습니다.\n");
	         Thread.sleep(500);         
	         ndo.showNoticeList();      
	         }catch (Exception e) {
	            e.printStackTrace();
	         }      
	   }

	   public void returnMainmenu() {
	      System.out.println("\n\n다음으로 수행할 작업을 입력해주세요.\n");
	      System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
	      System.out.println("1. 메인 메뉴 ");
	      System.out.println("2. 공지 목록으로");
	      System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
	      
	      int goMain = Integer.parseInt(s.nextLine());
	      
	      switch(goMain){
	         
	      case 1 : 
	         try{
	            System.out.println("메인으로 돌아갑니다.\n");
	            Thread.sleep(300);         
	         
	            }catch (Exception e) {
	               e.printStackTrace();
	            }break;
	      case 2 : try{
	            Thread.sleep(300);         
	            showNoticeList();
	            }catch (Exception e) {
	               e.printStackTrace();
	            }break;
	      default : break;
	      }
	   }
	}