package service;

import java.util.Date;
import java.util.Scanner;

import vo.CompanyVo;
import Session.UserSession;
import dao.MasterDao;

public class MasterService extends UserService{
		

	MasterDao mdo = new MasterDao();
	CompanyVo cv = new CompanyVo();
	Date today = new Date();
	UserSession session = new UserSession();
	boolean backpage = false;
	
	static Scanner s = new Scanner(System.in);

//	public void showNotice() {
//		int select = 0;
//		NoticeDao ndao = new NoticeDao();
//		System.out.println("----------공지사항----------");
//		do {
//			if(ndao.getNoticeSize()==0) {
//				System.out.println("등록된 공지사항이 없습니다.");
//				try {
//					Thread.sleep(1000);
//					System.out.println("메인화면으로 이동합니다.");
//					Thread.sleep(1000);
//					break;
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}else {
//				
//				ndao.getNoticeTitle();
//			}
//		System.out.println("0. 뒤로가기");
//		select = Integer.parseInt(s.nextLine());
//		if(select==0) {
//			System.out.println("메인화면으로 이동합니다.");
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}else if(select>0 && select<=ndao.getNoticeSize()) {
//			int back;
//			
//			String content = ndao.showNoticeContent(select);
//			System.out.println(content);	//20자 마다 끊기 긔긔
//			System.out.println("0. 뒤로가기");
//			do{
//				back = Integer.parseInt(s.nextLine());
//			if(back==0) {
//				System.out.println("공지리스트로 이동합니다.");
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}else {
//				System.out.println("뒤로가기만 가능합니다. 0을 입력해 주세요.");
//			}
//			
//			}while(back !=0);
//			
//		}else {
//			System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
//		}
//		}while(select!=0);
//	}
//	
	
	//마스터 관련 부분 - 영수
	public void companyManagement() {         //1.업체관리 메뉴
		System.out.println("업체 관리 메뉴입니다. 기능을 선택해 주십시오.");
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
		System.out.println("1.업체 수정");
		System.out.println("2.업체 삭제");
		System.out.println("3.뒤로가기");
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
		int a = Integer.parseInt(s.nextLine());
		switch (a) {
			case 1:
				System.out.println("업체 수정을 선택하셨습니다.");
				mdo.modifyCompany();
				break;
			case 2:
				System.out.println("업체 삭제를 선택하셨습니다.");
				mdo.delCompany();
				break;
			case 3: System.out.println("상위 메뉴로 돌아갑니다");
					break;
			default : System.out.println("잘못 입력하셨습니다. \n 상위 메뉴로 돌아갑니다.");
					break;
		}	
	}
	public void userManagement() {      //2.사용자 관리 메뉴
		System.out.println("사용자 관리 메뉴입니다. 기능을 선택해 주십시오.");
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
		System.out.println("1.사용자 수정");
		System.out.println("2.사용자 삭제");
		System.out.println("3.뒤로가기");
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
		int a = Integer.parseInt(s.nextLine());
		switch (a) {
			case 1:
				System.out.println("사용자 수정을 선택하셨습니다.");
				mdo.modifyUser();
				break;
			case 2:
				System.out.println("사용자 삭제를 선택하셨습니다.");
				mdo.delUser();
				break;
			case 3: System.out.println("상위 메뉴로 돌아갑니다");
				break;
				default : System.out.println("잘못 입력하셨습니다. \n 상위 메뉴로 돌아갑니다.");
				break;
		}		
	}
	public void noticeManagement() {    //3.공지사항 관리 메뉴
		System.out.println("공지사항 관리 메뉴입니다. 기능을 선택해 주십시오.");
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
		System.out.println("1.공지사항 작성");
		System.out.println("2.공지사항 수정");
		System.out.println("3.공지사항 삭제");
		System.out.println("4.뒤로가기");
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
		int a = Integer.parseInt(s.nextLine());
		switch (a) {
			case 1:
				System.out.println("공지사항 작성을 선택하셨습니다.");
				mdo.writeNotice();			
				break;
			case 2:
				System.out.println("공지사항 수정을 선택하셨습니다.");
				mdo.modifyNotice();
				break;
			case 3:
				System.out.println("공지사항 삭제를 선택하셨습니다.");
				mdo.delNotice();
				break;
			case 4:	System.out.println("상위 메뉴로 돌아갑니다");
					break;	
			default : System.out.println("잘못 입력하셨습니다. \n 상위 메뉴로 돌아갑니다.");
	 		  		break;
			}		
	}
	public void masterLogout() {
		session.loginUserId = "guest";
		session.loginUserPass = "guest123";
		session.loginUserType = 0;
	}
}



