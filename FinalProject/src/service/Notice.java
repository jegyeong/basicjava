package service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import vo.NoticeVo;
import dao.NoticeDao;
import data.Session;

public class Notice {
	static Scanner s = new Scanner(System.in);
	public static void notiveUser() {
		NoticeDao noticedao = NoticeDao.getInstance();
		ArrayList<NoticeVo> noticeList =noticedao.selectNoticeList();
		if (noticedao.selectNoticeList().size() == 0) {
			System.out.println("공지사항이 없습니다.");
			return;
			// 되돌아가기 구현.
		}
		boolean check = false;
		
		String temp = "";
		do {
			noticeView();
			System.out.println("0. 종료");
			System.out.println("-----------------------------------------------");
			System.out.println("자세히 보실 공지사항을 선택해주세요.");
			temp = s.nextLine().trim();
			check = IntegerCheck.checkInt(temp, 0, noticeList.size());
		}while(!check);
		if(Integer.parseInt(temp)==0){
			return;
		}
		
		int noticeKey = noticeList.get(Integer.parseInt(temp)-1).getNo();
		System.out.println("-----------------------------------------------");	
		System.out.print(noticeList.get(noticeKey).getSubject()+ "\t");
		System.out.println(noticeList.get(noticeKey).getId() + "\t");
		System.out.println("-----------------------------------------------");
		System.out.println(noticeList.get(noticeKey).getContents());
		System.out.println("-----------------------------------------------");
	}
	
	public static void noticeView(){
		NoticeDao noticedao = NoticeDao.getInstance();
		ArrayList<NoticeVo> noticeList =noticedao.selectNoticeList();
		if (noticeList.isEmpty()) {
			System.out.println("공지사항이 없습니다.");
			return;
			// 되돌아가기 구현.
		}
	
	

		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		System.out.println("--------------------------------------------------------------");
		System.out.println("\t\t공지사항");
		System.out.println("순번\t\t제목\t\t\t작성자\t\t날짜");
		System.out.println("--------------------------------------------------------------");
		for (int i = 0; i < noticeList.size(); i++) {
			String subject = noticeList.get(i).getSubject();
			int num = 4-subject.length()/6;
			for(int j = 0 ; j < num ; j++){
				subject += "\t";
			}
			
			System.out.print(i+1+"\t");
			System.out.print(subject);
			System.out.print(noticeList.get(i).getId() + "\t    ");
			System.out.println(format1.format(noticeList.get(i).getDate()) + "\t");
		}
		
	    
	}
	public static void noticeUser() {
		NoticeDao noticedao = NoticeDao.getInstance();
		ArrayList<NoticeVo> noticeList =noticedao.selectNoticeList();
		if (noticedao.selectNoticeList().size() == 0) {
			System.out.println("공지사항이 없습니다.");
			return;
			// 되돌아가기 구현.
		}
		boolean check = false;
		
		String temp = "";
		
		do {
			do {
				noticeView();
				System.out.println("0\t이전 메뉴로 이동");
				System.out.println("--------------------------------------------------------------");
				System.out.println("자세히 보실 공지사항을 선택해주세요.");
				temp = s.nextLine().trim();
				check = IntegerCheck.checkInt(temp, 0, noticeList.size());
			} while (!check);
			if (Integer.parseInt(temp) == 0) {
				return;
			}

			int noticeKey = noticeList.get(Integer.parseInt(temp) - 1).getNo();
			System.out.println("--------------------------------------------------------------------------------------------------");
			System.out.print(noticeList.get(noticeKey).getSubject() + "\t");
			System.out.println("작성자 ID : "+noticeList.get(noticeKey).getId() + "\t");
			System.out.println("--------------------------------------------------------------------------------------------------");
			System.out.println(noticeList.get(noticeKey).getContents());
		

		}while(check);

		
	}
	static void NoticeCreat() {
	

	// 관리자 급만 만들수 있게 설정해줘야 하는 거

	NoticeDao noticedao = NoticeDao.getInstance();

	NoticeVo notice = new NoticeVo();

	
	String Subject = "";
	String Content = "";
	boolean stop = true;
	do {
		stop = true;
		System.out.println("제목을 입력하세요.");
		Subject = s.nextLine().trim();
		
		if (!(Subject.length() <= 15&&Subject.length() >= 2)) {
			System.out.println("2~15글자로 제목을 정해주세요.");
			stop = false;
		}
		
	} while (!stop);

	stop = false;
	do {
		System.out.println("내용을  15자 이상 입력하세요.");
		Content = s.nextLine();

		if (Content.length() >= 15) {
			stop = true;
		}
	} while (!stop);

	notice.setDate(new Date());
	notice.setSubject(Subject);
	notice.setContents(Content);
	notice.setId(Session.loginUser.getId());
	noticedao.insertNotice(notice);

}
 	public static void NoticeModify() {
	
	String temp = "";
	boolean check = false;
		do {
			do {		
				noticeView();
				System.out.println("------------------------------------------");
				System.out.println("1. 공지사항 보기");
				System.out.println("2. 공지사항 추가");
				System.out.println("3. 공지사항 삭제");
				System.out.println("4. 제목수정");
				System.out.println("5. 내용수정");
				System.out.println("0. 이전 메뉴로 이동");
				System.out.println("------------------------------------------");
				temp = s.nextLine().trim();
				check = IntegerCheck.checkInt(temp, 0, 5);

			} while (!check);

			int menu = Integer.parseInt(temp);
			switch (menu) {
			case 1:
				noticeUser();
				break;
			case 2:
				NoticeCreat();
				break;
			case 3:
				Noticedelete(modifyPos());
				break;
			case 4:
				modifySub(modifyPos());
				break;
			case 5:
				modifyCentent(modifyPos());
				break;
			case 0:
				System.out.println("이전 메뉴로 돌아갑니다.");
				check = false;
			}
		}while(check);
				
	
}
 	static int modifyPos(){
	
	NoticeDao noticeDao = NoticeDao.getInstance();
	ArrayList<Integer> noticList = noticeDao.NoticeList();
	
	String temp = "";
	boolean check = false;
	
	do{
		System.out.println("--------------------------------------------------------------------------------------------------");
		System.out.println("수정하고 싶은 게시판의 숫자를 입력해주세요.");
		noticeView();
		System.out.println("0. 종료");
		System.out.println("--------------------------------------------------------------------------------------------------");
		temp = s.nextLine().trim();
		check = IntegerCheck.checkInt(temp,0,noticList.size());
	
	}while(!check);

	if(temp.equals("0")){
		return -1;
	}
	
	return noticeDao.NoticeList().get(Integer.parseInt(temp)-1);
}
	static void Noticedelete(int no) {
		if(no == -1){
			return;
		}else {
		
		NoticeDao noticedao = NoticeDao.getInstance();
		for(int i = 0 ; i < noticedao.selectNoticeList().size();i++){
			if(noticedao.selectNoticeList().get(i).getNo()==no){
				System.out.println(i+1+"번의 공지사항을 삭제하였습니다.");
			}
		}
		noticedao.deleteNotice(noticedao.searchNoiceNoInfo(no));
	}
	
}
	static void modifySub(int no){
	if(no == -1){
		return;
	} else {
		NoticeDao noticedao = NoticeDao.getInstance();
		boolean check =false;
		int number = 0;
		for(int i = 0 ; i < noticedao.selectNoticeList().size();i++){
			if(noticedao.selectNoticeList().get(i).getNo()==no){
				number=i+1;
				break;
			}
		}
		
		do {
			System.out.println(number+"번의 공지사항을 선택하셨습니다.");
			System.out.println("제목을 수정하시겠습니까? Y/N");
			String temp = s.nextLine().trim();
			if (temp.equalsIgnoreCase("Y") || temp.equalsIgnoreCase("y")) {
					do {
						check = true;
						System.out.println("수정하고 싶은 제목을 입력하세요.");
						temp = s.nextLine();
						if (!(temp.length() <= 15 && temp.length() >= 2)) {
							System.out.println("2~15글자로 제목을 정해주세요.");
							check = false;
						}
						
					}while(!check);
				noticedao.searchNoiceNoInfo(no).setSubject(temp);
				
				
			}else if(temp.equalsIgnoreCase("N")|| temp.equalsIgnoreCase("n")){
				System.out.println("메뉴로 돌아갑니다.");
				check = true;
				
			}else{
				System.out.println("잘못된 입력입니다.");
				check = false;
			}
		}while(!check);
	}
	
 }
	static void modifyCentent(int no) {
		NoticeDao noticedao = NoticeDao.getInstance();
		
		if (no == -1) {
			return;
		}else {
			boolean check = false;
			int number = 0;
			for(int i = 0 ; i < noticedao.selectNoticeList().size();i++){
				if(noticedao.selectNoticeList().get(i).getNo()==no){
					number=i+1;
					break;
				}
			}
			do {
				System.out.println(number + "번의 공지사항을 선택하셨습니다.");
				System.out.println("내용을 수정을 하시겠습니까? Y/N");
				String temp = s.nextLine().trim();
				if (temp.equalsIgnoreCase("Y") || temp.equalsIgnoreCase("y")) {
					do{
						check = true;
						System.out.println("수정하고 싶은 내용을 입력하세요.");
						temp = s.nextLine();
						
						if (!(temp.length() >= 15)) {
							System.out.println("15글자 이상으로 내용을 입력해주세요.");
							check = false;
						}
					}while(!check);

					noticedao.searchNoiceNoInfo(no).setContents(temp);
					
				} else if (temp.equalsIgnoreCase("N")|| temp.equalsIgnoreCase("n")) {
					System.out.println("메뉴로 돌아갑니다.");
					check = true;
				} else {
					System.out.println("잘못된 입력입니다.");
					check = false;
				}
			} while (!check);

		}
	}
	
}
