package service;

import java.util.*;

import vo.ReadingRoomListVO;
import vo.ReadingRoomVO;
import dao.ReadingRoomDao;
import dao.ReadingRoomListDao;

public class AdminLib {

   private static AdminLib instance;

   private AdminLib() {
   }

   public static AdminLib getInstance() {
      if (instance == null) {
         instance = new AdminLib();
      }
      return instance;
   }

   Scanner s = new Scanner(System.in);
   ReadingRoomDao RRD = ReadingRoomDao.getInstance();
   ReadingRoomVO readvo = new ReadingRoomVO();
   ReadingRoomListDao RRLD = ReadingRoomListDao.getInstance();
   ReadingRoomListVO readlvo = new ReadingRoomListVO();

   public void main() { // 메인
      int a = -1;
      // seatlist();
      // Scanner s = new Scanner(System.in);
      AdminLib ad = new AdminLib();
      do {
         System.out.println("-----[열람실]-----");
         System.out.println("1.좌석등록");
         System.out.println("2.좌석수정");
         System.out.println("3.좌석삭제");
         System.out.println("4.강제퇴장");
         System.out.println("0.뒤로가기");
         System.out.println("----------------");
         System.out.print("번호 > ");
         try {
            a = Integer.parseInt(s.nextLine());
         } catch (Exception e) {
         }
         if (!(a == 1 || a == 2 || a == 3 || a == 4 || a == 0)) // 괄호
         {
            System.out.println("[ 잘못된 값을 입력하였습니다 ]");
            s.nextLine();
         }
      } while (!(a == 1 || a == 2 || a == 3 || a == 4 || a == 0));

      switch (a) {
      case 1:
         ad.register();
         break;
      case 2:
         ad.edit();
         break;
      case 3:
         ad.delete();
         break;
      case 4:
         ad.Exdelete();
         break;
      case 0:
         break;
      }

   }

   public void seatlist() {
      // 좌석을 보여주는 메소드

      // boolean check = true;

      for (int i = 0; i < RRD.selectroom().size(); i++) {
         // 사용자가자리를 받았을 때 빈좌석과 비교해서 사용자 가 고른 좌석과 빈좌석의
         // 빈좌석의 seatnum를 비교해서 같으면
         System.out.print("[" + RRD.selectroom().get(i).getSeatNum() + "."

         + RRD.selectroom().get(i).getWhat() + "]" + "\t");
         if ((i + 1) % 5 == 0) {
            System.out.println();
         }

      }
      System.out.println();
   }

   public void register() { // 좌석등록
      int num = -1;

      seatlist();
      do {
         System.out.println();
         System.out.print("생성시킬좌석의 수를 입력하세요 > ");
         try {
            num = Integer.parseInt(s.nextLine());
         } catch (Exception e) {
         }
         if (num < 0) {
            System.out.println("[ 잘못된 값을 입력하였습니다 ]");
            s.nextLine();
         }
      } while (num < 0);

      for (int i = 0; i < num; i++) {
         ReadingRoomVO seatNum = new ReadingRoomVO();
         seatNum.setSeatNum(RRD.selectroom()
               .get(RRD.selectroom().size() - 1).getSeatNum() + 1);
         RRD.insertRoom(seatNum);
      }

      seatlist();

      main();

   }

   public void edit() { // 좌석수정
      int a = -1;
      do {
         seatlist();
         System.out.printf("\n수정할 좌석의 번호를 입력해주세요 > "); // 좌석번호 입력
         try {
            a = Integer.parseInt(s.nextLine());
         } catch (Exception e) {
         }
         if (a < 0) {
            System.out.println("[ 잘못된 값을 입력하였습니다 ]");
            s.nextLine();
         }
      } while (a < 0);

      for (int i = 0; i < RRD.selectroom().size(); i++) {
         if (RRD.selectroom().get(i).getSeatNum() == a) {
            a = i;
            break;
         }
      }

      String content;
      System.out.print("수정할 내용을 입력해주세요> "); // 내용 입력
      content = s.nextLine();
      // 입력받은 문자열 길이 조절
      if (content.length() <= 3) {
         content = (content + "\t");
         // System.out.println("수정할내용이 짧으므로 수정되었습니다.");

      } else if (content.length() >= 8) {
         content = content.substring(0, 5);
         System.out.println("[ 수정할내용이 길어 수정되었습니다 ]");
      }

      // 문자열로 내용 수정
      ReadingRoomVO room = RRD.selectroom().get(a);
      room.setWhat(content);

      RRD.setState(room, a);
      seatlist();

      main();

   }

   public void Exdelete() { // 사용자강제퇴출

      int a = -1;

      seatlist();
      do {
         System.out.println("[ 퇴출시킬 좌석 번호를 입력하세요  ]");
         try {
            a = Integer.parseInt(s.nextLine());
         } catch (Exception e) {
         }
         if (a < 0) {
            System.out.println("[ 잘못된 값을 입력하였습니다 ]");
            s.nextLine();
         }
      } while (a < 0);

      // String Id = Session.loginUser.getUserID();

      for (int i = 0; i < RRD.selectroom().size(); i++) {
         if (RRD.selectroom().get(i).getSeatNum() == a) {
            RRD.selectroom().get(i).setWhat("사용가능");
            break;
         }
      }
      boolean check = false;

      for (int i = 0; i < RRLD.selectroom().size(); i++) {

         if (RRLD.selectroom().get(i).getEndTime() == null && RRLD.selectroom().get(i).getSeatNum() == a) {

            RRLD.selectroom().get(i).setEndTime(new Date());
            check = true;
            break;

         }

      }

      if (check == false) {
         System.out.println("[ 잘뭇된 선택을 하셨습니다 ]");
      }
      System.out.println();
      System.out.println("[ 사용자가 퇴출되었습니다 ]");

   }

   public void delete() { // 좌석삭제
      int a = -1;
      seatlist();
      do {
         System.out.printf("\n삭제할 좌석의 번호를 입력해주세요 > ");
         try {
            a = Integer.parseInt(s.nextLine());
         } catch (Exception e) {
         }
         if (a < 0) {
            System.out.println("[ 잘못된 값을 입력하였습니다 ]");
            s.nextLine();
         }
      } while (a < 0);

      // String Id = Session.loginUser.getUserID();

      for (int i = 0; i < RRD.selectroom().size(); i++) {
         if (RRD.selectroom().get(i).getSeatNum() == a) {
            a = i;
            break;
         }
      }

      if (RRLD.selectroom().size() == 0) {
         ReadingRoomVO delete = RRD.selectroom().get(a);
         delete.setWhat("   X   ");

         RRD.setState(delete, a);

      }

      boolean check = false;
      for (int i = 0; i < RRLD.selectroom().size(); i++) {
         // if(RRD.selectroom().get(i).equals(a)){
         if (RRD.selectroom().get(a).getSeatNum() == RRLD.selectroom()
               .get(i).getSeatNum()) {

            System.out.println("[ 사용중입니다 ]");
            check = true;
            break;
         }

      }

      if (check == false) {
         ReadingRoomVO delete = RRD.selectroom().get(a);
         delete.setWhat("   X   ");

         RRD.setState(delete, a);

      }

      main();

   }

}