package service;

import java.util.Scanner;

import vo.UserVO;
import dao.UserDao;
//import data.Session;
import data.Session;

public class AdminService {
   
   
private static AdminService instance;
   
   private AdminService(){}
   
   public static AdminService getInstance(){
      if(instance == null){
         instance = new AdminService();
      }
      return instance;
   }

   
   Scanner s = new Scanner(System.in);
   
   private UserDao userDao = UserDao.getInstance();

   
   //로그인
   public void login(){
      //아이디, 비밀번호를 입력
      System.out.print("관리자 아이디 > ");
      String id = s.nextLine();
      System.out.print("관리자 비밀번호 > ");
      String password = s.nextLine();
      
      UserVO user = new UserVO();
      
      user.setUserID(id);
      user.setUserPass(password);
      
      UserVO userCheck = userDao.selectUser(user);
      
      //없으면 로그인 실패
      if(userCheck == null || !userCheck.isUserType()){
         System.out.println("[ 아이디 혹은 비밀번호를 잘못 입력하셨습니다 ]");
         s.nextLine();
      }else{
         //있으면 로그인
         Session.loginUser = userCheck;
         adminMain();
      }
   }
   
   //관리자 메인 화면
   public void adminMain() {
      int a=-1;
      do {
         System.out.println();
         System.out.println("--------[ Admin 로그인 되었습니다 ]-------");
         System.out.println("1.회원 관리");
         System.out.println("2.도서 관리");
         System.out.println("3.공지사항 관리");
         System.out.println("4.열람실 관리");
         System.out.println("0.로그아웃"); // 첫화면으로돌아가도록
         System.out.println("--------------------------------------");
         System.out.print("번호 > ");
         try{
            a = Integer.parseInt(s.nextLine());
         }catch(Exception e){
            }
         switch (a) {
         case 1:
            AdminUserService.getInstance().usermanage();
            break;
         case 2:
            AdminBookService.getInstance().bookS();
            break;
         case 3:
            NoticeService.getInstance().NoticeStart();
            break;
         case 4:
        	 AdminLib.getInstance().main();
            break;            
         case 0:
            System.out.println("[ 로그아웃되었습니다 ]");
               Session.loginUser = null;
            break;
            default:
               System.out.println("[ 잘못된 값을 입력하였습니다 ]");
               s.nextLine();
         }
      } while (a != 0);
   }

}