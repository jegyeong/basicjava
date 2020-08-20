package start;

import java.util.Scanner;

import service.AdminService;
import service.NoticeService;
import service.UserService;
import vo.NoticeVO;
import dao.NoticeDao;

public class Start {

	public static void main(String[] args) {
		new Start().library();
	}

	Scanner s = new Scanner(System.in);

	void library() {

		int menu = -1;
		AdminService admin = AdminService.getInstance();
		UserService user = UserService.getInstance();
		do {
			System.out.println();
			System.out.println("해바라기 도서관 입니다. 무엇을 도와드릴까요?");
			NoticeVO notice = NoticeDao.getInstance().selectNoticeList()
					.get(NoticeDao.getInstance().selectNoticeList().size() - 1);
			System.out.println();
			// 데이터 베이스에서 불러오는 거니까 Notice VO
			// 객체 생성해서 다오를 통해서 그 인덱스 사이즈에서 1을 빼면 가장 숫자가 큰 공지가 따라옴
			System.out.println("\t\t-최신 공지사항-");
			System.out
					.println(notice.getTitle() + " - " + notice.getContents());
			System.out.println("---------------------------------------");
			System.out.println("1. 관리자 로그인");
			System.out.println("2. 회원 로그인");
			System.out.println("3. 공지사항");
			System.out.println("0. 종료");
			System.out.println("---------------------------------------");
			System.out.print("번호 입력 > ");

			do {
				try {
					menu = Integer.parseInt(s.nextLine());
				} catch (Exception e) {
				}
				if (!(menu == 1 || menu == 2 || menu == 3 || menu == 0)) {
					System.out.println("[ 잘못된 값을 입력하였습니다 ]");
					s.nextLine();
				}
			} while (!(menu == 1 || menu == 2 || menu == 3 || menu == 0));

			switch (menu) // 서비스에 있는 메소드 호출
			{
			case 1: // 관리자 로그인
				admin.login();
				break;
			case 2: // 회원 로그인
				user.login();
				break;
			case 3:
				NoticeService.getInstance().newNotice();
				break;
			case 0: // 프로그램 종료
				System.out.println("프로그램 종료");
				break;
			}

		} while (menu != 0);

	}
}