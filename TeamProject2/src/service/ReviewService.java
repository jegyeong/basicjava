package service;


import Session.UserSession;
import dao.ReviewDao;


public class ReviewService {
   ReviewDao rdao = new ReviewDao();
   UserSession session = new UserSession();
   
   public void writeReview() {
      ReviewDao rdo = new ReviewDao();
      System.out.println("※허위 사실 기재시 서비스 이용에 제한이 있을 수 있습니다※ 신중히 작성해 주십시오!\n");
      rdo.makeReview();      
   }   

   public void searchReview(int comSel) {
      if( comSel == 0 ) {                 //메인메뉴>>사업자>>자회사리뷰보기
         try{
             String input = session.loginUserId;
               System.out.println("회사에 남겨진 리뷰들을 불러오고 있습니다.\n");
               Thread.sleep(300); 
               rdao.myComShowReview(input);               
               }catch (Exception e) {
                  e.printStackTrace();
               }         
      }else {                             //SearchService에서 접근할 때
         try{
               System.out.println("해당 업체의 리뷰를 불러오고 있습니다.\n");
               Thread.sleep(300);         
               rdao.showReviewList(comSel);
               System.out.println("해당 기능을 끝내고 업체 목록으로 돌아갑니다.\n");
               }catch (Exception e) {
                  e.printStackTrace();
               }
      }
   }
   
}