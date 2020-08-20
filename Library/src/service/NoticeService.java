package service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import vo.NoticeVO;
import dao.NoticeDao;

public class NoticeService {

	private static NoticeService instance;

	private NoticeService() {
	}

	public static NoticeService getInstance() {
		if (instance == null) {
			instance = new NoticeService();
		}
		return instance;
	}

	NoticeVO su;
	Scanner s = new Scanner(System.in);

	// public void noticeMain() {
	//
	// ArrayList<NoticeVO> noticeList = NoticeDao.getInstance()
	// .selectNoticeList();
	// System.out.println();
	// System.out.println("-------------------공지목록-----------------------");
	// System.out.println("번호\t제목\t내용\t날짜\t작성자");
	// for (int i = 0; i < noticeList.size(); i++) {
	// NoticeVO notice = noticeList.get(i);
	// notice.setNoticeNum(i+1);
	// System.out.println(notice.getNoticeNum() + "\t" + notice.getTitle() +
	// "\t"
	// + notice.getContents() + "\t" + notice.getWriteDate()
	// + "\t" + notice.getWriter());
	// }
	// System.out.println("------------------------------------------------");
	// }

	public static void noticeList() {
		ArrayList<NoticeVO> NoticeList = NoticeDao.getInstance()
				.selectNoticeList();
		System.out
				.printf("--------------------------------------------------------");
		System.out.printf("---------------------------------\n");
		System.out.println("번호\t제목\t\t\t\t내용\t\t\t작성자\t작성날짜");
		System.out
				.printf("--------------------------------------------------------");
		System.out.printf("---------------------------------\n");
		for (int t = 0; t < NoticeList.size(); t++) {
			NoticeVO notice = NoticeList.get(t);

			System.out.printf("%-10s", t + 1);
			System.out.printf("%-15.15s\t", notice.getTitle());
			System.out.printf("%-30.30s\t", notice.getContents());
			System.out.printf("%-5s\t", notice.getWriter());
			System.out.printf("%-15s\n", notice.getWriteDate());
			System.out
					.printf("--------------------------------------------------------");
			System.out.printf("---------------------------------\n");
		}
		// 회원전체의 목록을 가져와야한다.
	}

	public void NoticeStart() {
		int a = -1;

		do {
			do {
				noticeList();
				System.out.println("-----[공지사항관리]-----");
				System.out.println("1.공지등록");
				System.out.println("2.공지수정 및 삭제 ");
				System.out.println("0.뒤로가기");
				System.out.println("------------------");
				System.out.print("번호 > ");
				try {

					a = Integer.parseInt(s.nextLine());
				} catch (Exception e) {

				}
				if (!(a == 1 || a == 2 || a == 0)) {
					System.out.println("[ 잘못된 값을 입력하였습니다 ]");
					s.nextLine();
				}
			} while (!(a == 1 || a == 2 || a == 0));

			switch (a) {
			case 1:
				noticeadd();
				break;
			case 2:
				noticeManage();
				break;
			case 0:
				break;

			}

		} while (a != 0);

	}

	public void noticeadd() {

		NoticeVO notice = new NoticeVO();
		System.out.println("[ 공지사항 추가 ]");

		System.out.println("제목 >");
		String a = s.nextLine();
		notice.setTitle(a);

		System.out.println("내용 > ");
		a = s.nextLine();
		notice.setContents(a);

		notice.setWriter("관리자");

		DateFormat sdFormat = new SimpleDateFormat("yyyy.MM.dd");
		Date nowDate = new Date();
		String today = sdFormat.format(nowDate);
		notice.setWriteDate(today);

		NoticeDao.getInstance().insertNotice(notice);
		System.out.println("[ 새로운 공지가 등록되었습니다 ]");
	}

	public void noticeManage() {
		String a;
		noticeList();

		System.out.println("검색 > (제목 or 내용)");
		a = s.nextLine();

		NoticeDao notice = NoticeDao.getInstance();
		// int a = 122;
		ArrayList<NoticeVO> tb_notice = notice.selectNoticeList();
		// 변수선언, 배열인데 거기에는 NoticeVO가 담길거란다.
		// notice에 담긴 객체를 사용함. 그안에있는 메소드는 데이터베이스의 노티스 정보를
		// 받아다주는 다오에 있던 그 메소드잖아 ㅠㅠㅠㅠㅠㅠㅠㅠㅠ
		ArrayList<NoticeVO> search = new ArrayList<>();
		boolean o = false;

		for (int i = 0; i < tb_notice.size(); i++) {
			NoticeVO search2 = tb_notice.get(i);
			String ser = search2.getTitle() + search2.getContents()
					+ search2.getWriter() + search2.getWriteDate();

			for (int j = 0; j < a.length(); j++) {
				o = false;
				if (a.substring(j, j + 1) == " ") {
					continue;
				}
				for (int k = 0; k < ser.length(); k++) {
					if (a.substring(j, j + 1).equals(ser.substring(k, k + 1))) {
						o = true;
						break;
					}
				}
				if (!o)
					break;

				if (o) {
					search.add(search2);
					System.out
							.println("-----------------------------------------------");
					int z = search.size();
					System.out.println(z + "/" + search2.getTitle() + "/"
							+ search2.getContents() + "/" + search2.getWriter()
							+ "/" + search2.getWriteDate());

					System.out
							.println("-----------------------------------------------");
					search2 = new NoticeVO();
					break;
				}
			}
		}
		if (search.size() == 0) {
			System.out.println("[ 검색 결과가 없습니다 ]");
			return;
		}

		int z = -1;
		do {
			System.out.println("수정 또는 삭제할 공지 번호를 선택 >");
			try {
				z = Integer.parseInt(s.nextLine());
				su = search.get(z - 1);
				// 위에 검색결과(search2)는 위에서 search 에 담겨있고, 그것을 빼서 다시 su 라는 변수에
				// 담은 상태이다.
			} catch (Exception e) {
				System.out.println("[ 잘못된 값을 입력하였습니다 ]");
			}
		} while (su == null);

		do {
			do {

				System.out.println("어떤 기능을 수행하시겠습니까?");
				System.out.println("1.제목 수정");
				System.out.println("2.내용 수정");
				System.out.println("3.공지 삭제");
				System.out.println("0.뒤로 가기");
				System.out.println("----------------------");
				System.out.print("번호 > ");
				try {
					z = Integer.parseInt(s.nextLine());
				} catch (Exception e) {
				}
				if (!(z == 1 || z == 2 || z == 3 || z == 0)) // 괄호
				{
					System.out.println("[ 잘못된 값을 입력하였습니다 ]");
					s.nextLine();
				}
			} while (!(z == 1 || z == 2 || z == 3 || z == 0));

			switch (z) {
			case 1:
				String b1;
				System.out.println("[ 다음 공지의 제목을 변경합니다 ]");
				System.out
						.printf("--------------------------------------------------------");
				System.out.printf("---------------------------------\n");
				System.out.println(su.getTitle() + "/" + su.getContents() + "/"
						+ su.getWriter() + "/" + su.getWriteDate());
				System.out
						.printf("--------------------------------------------------------");
				System.out.printf("---------------------------------\n");
				System.out.println("제목 >");

				DateFormat sdFormat = new SimpleDateFormat("yyyy.MM.dd");
				Date nowDate = new Date();
				String today = sdFormat.format(nowDate);

				b1 = s.nextLine();
				su.setTitle(b1);
				su.setWriteDate(today);

				System.out.println("[ 수정되었습니다 ]" + "\n" + su.getTitle() + "/"
						+ su.getContents() + "/" + su.getWriter() + "/"
						+ su.getWriteDate());

				break;

			case 2:
				String b2;
				System.out.println("[ 다음 공지의 내용을 변경합니다 ]");
				System.out
						.printf("--------------------------------------------------------");
				System.out.printf("---------------------------------\n");
				System.out.println(su.getTitle() + "/" + su.getContents() + "/"
						+ su.getWriter() + "/" + su.getWriteDate());
				System.out
						.printf("--------------------------------------------------------");
				System.out.printf("---------------------------------\n");
				System.out.println("변경할 내용 >");

				DateFormat sdFormat2 = new SimpleDateFormat("yyyy.MM.dd");
				Date nowDate2 = new Date();
				String today2 = sdFormat2.format(nowDate2);

				b2 = s.nextLine();
				su.setContents(b2);
				su.setWriteDate(today2);

				System.out.println("[ 수정되었습니다 ]" + "\n" + su.getTitle() + "/"
						+ su.getContents() + "/" + su.getWriter() + "/"
						+ su.getWriteDate());
				break;

			case 3:

				NoticeDao.getInstance().deleteNotice(su);
				System.out.println("[ 삭제되었습니다 ]");
				System.out.println();
				noticeList();
				break;
			case 0:
				break;

			}
		} while (z != 0);
	}

	public void newNotice() {
		noticeList();
		System.out.println("이전 페이지로 > ('0')");
		s.nextLine();

	}
}