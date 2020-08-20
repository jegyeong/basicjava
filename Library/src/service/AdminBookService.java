package service;

import java.util.ArrayList;
import java.util.*;
import vo.BookVO;
import dao.BookDao;

public class AdminBookService {

	private static AdminBookService instance;

	// UserService 를 instanceBookService변수로 선언

	private AdminBookService() {
	} // 생성자를 초기화 //private접근금지

	public static AdminBookService getInstance() {
		if (instance == null)
		// 값이 이미 있으면 null을 생성하지 않는다.
		{
			instance = new AdminBookService();// 생성
		}
		return instance;
	}

	Scanner s = new Scanner(System.in);

	private BookDao bookDao = BookDao.getInstance();

	// 출력
	public void booklist() {
		ArrayList<BookVO> booklist = bookDao.selectbooklist();

		System.out
				.println("----------------------------------------------------------------------");
		System.out.println("도서코드\t도서명\t\t\t저자\t\t출판일\t\t출판사");
		System.out
				.println("----------------------------------------------------------------------");
		for (int i = 0; i < booklist.size(); i++) {
			BookVO book = booklist.get(i);
			System.out.printf("%-6s\t", book.getCode());// 도서코드
			if (book.getTitle().length() > 10)
				System.out.printf("%-30s\t", book.getTitle().substring(0, 9));// 제목
			else
				System.out.printf("%-30s\t", book.getTitle());// 제목
			System.out.printf("%-15s\t", book.getWriter());// 저자
			System.out.printf("%-15s\t", book.getPublish());// 출판일
			System.out.printf("%-20s\n", book.getCompany());// 출판사

		}

		System.out
				.println("----------------------------------------------------------------------");
		System.out.println("  \t\t ◀ 1       2      3      4      5 ▶");
	}

	public void bookS() {
		int a = -1;

		do {
			booklist();

			System.out.println();
			System.out.println("---------[도서관리]---------");
			System.out.println("1. 도서등록");
			System.out.println("2. 도서수정 및 삭제");
			System.out.println("0. 뒤로가기");
			System.out.println("--------------------------");
			System.out.println("번호 > ");

			try {
				a = Integer.parseInt(s.nextLine());
			} catch (Exception e) {
			}

			switch (a) {
			case 1:
				bookjoin();
				break;
			case 2:
				booksearch();
				break;
			case 0:
				break;
			default:
				System.out.println("[ 잘못된 값을 입력하였습니다 ]");
				s.nextLine();
			}
		} while (a != 0);
	}

	public void bookjoin() { // 책추가
		int code = -1;
		BookVO booklist = new BookVO();
		do {
			System.out.println();
			System.out.println("-----[도서 등록]-----");
			System.out.println("도서코드 > (6자리)");
			try {
				code = Integer.parseInt(s.nextLine());
			} catch (Exception e) {
			}
			if (code < 100000 || code > 999999) {
				System.out.println("[ 잘못된 값을 입력하였습니다 ]");
				s.nextLine();
			}
		} while (code < 100000 || code > 999999);

		booklist.setCode(code);
		BookVO bookCheck = bookDao.selectbook(booklist);

		if (bookCheck == null) {
			System.out.println("도서명 > ");
			String title = s.nextLine();
			booklist.setTitle(title);

			System.out.println("저자 > ");
			String writer = s.nextLine();
			booklist.setWriter(writer);

			System.out.println("출판일 > (YYYYMMDD)");
			String publish = s.nextLine();
			booklist.setPublish(publish);

			System.out.println("출판사 > ");
			String company = s.nextLine();
			booklist.setCompany(company);

			BookDao.getInstance().insertBook(booklist);
		}

		else {
			System.out.println("[ 이미 등록된 코드 입니다 ]");
			System.out.println();
		}
	}

	public void booksearch() {
		int a = -1;

		BookVO searchubook2 = new BookVO();
		do {
			do {
				System.out.println("수정 및 삭제할 도서의 코드> (숫자 6자리)");
				searchubook2 = new BookVO();
				try {
					a = Integer.parseInt(s.nextLine());
				} catch (Exception e) {
					System.out.println("[ 잘못된 값을 입력하였습니다 ]");
				}
				if (a != -1 && (a < 100000 || a > 999999)) {
					System.out.println("[ 잘못된 값을 입력하였습니다 ]");
					s.nextLine();
				}
			} while (a < 100000 || a > 999999);

			BookDao booklist = BookDao.getInstance();

			searchubook2.setCode(a);
			searchubook2 = booklist.selectbook(searchubook2);
			if (searchubook2 != null) {
				System.out.println();
				System.out.println("도서명 : " + searchubook2.getTitle() + "\n"
						+ "저자 : " + searchubook2.getWriter() + "\n" + "출판사 :"
						+ searchubook2.getCompany() + "\n" + "도서코드 :"
						+ searchubook2.getCode() + "\n" + "출판일 : "
						+ searchubook2.getPublish());

				do {
					System.out.println();
					do {
						System.out.println("------[도서 수정/삭제]------");
						System.out.println("1. 도서정보 수정");
						System.out.println("2. 도서정보 삭제");
						System.out.println("0. 뒤로가기");
						System.out.println("---------------------");
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
						a = -1;
						do {
							System.out.println();
							System.out.println("-----[도서 수정]-----");
							System.out.println("무엇을 수정하시겠습니까?");
							System.out.println("------------------");
							System.out.println("1.도서명 수정");
							System.out.println("2.도서저자 수정");
							System.out.println("3.도서출판사 수정");
							System.out.println("4.도서출판일 수정");
							System.out.println("0.뒤로가기");
							System.out.println("----------------");
							System.out.print("번호 > ");
							do {
								try {
									a = Integer.parseInt(s.nextLine());
								} catch (Exception e) {
								}
								if (!(a == 1 || a == 2 || a == 3 || a == 4 || a == 0))
									System.out.println("[ 잘못된 값을 입력하였습니다 ]");
							} while (!(a == 1 || a == 2 || a == 3 || a == 4 || a == 0));
							System.out.println("변경할 내용 >");
							switch (a) {
							case 1:
								titleedit(searchubook2);
								break;
							case 2:
								wriedit(searchubook2);
								break;
							case 3:
								comedit(searchubook2);
								break;
							case 4:
								pubedit(searchubook2);
								break;
							case 0:
								break;
							}
							System.out.println("-----[수정결과]--------------");
							System.out.println("도서명 : "
									+ searchubook2.getTitle() + "\n" + "저자 : "
									+ searchubook2.getWriter() + "\n" + "출판사 :"
									+ searchubook2.getCompany() + "\n"
									+ "도서코드 :" + searchubook2.getCode() + "\n"
									+ "출판일 : " + searchubook2.getPublish());
						} while (a != 0);
						break;
					case 2:
						delbook(searchubook2);
						return;
					case 0:
						break;
					}
				} while (a != 0);
			} else {
				System.out.println("[ 검색결과가 없습니다 ]");
			}
		} while (searchubook2 == null);

	}

	public void titleedit(BookVO searchubook2) {
		String b1;
		b1 = s.nextLine();
		searchubook2.setTitle(b1);

	}

	public void wriedit(BookVO searchubook2) {
		String b2;
		b2 = s.nextLine();
		searchubook2.setWriter(b2);

	}

	public void comedit(BookVO searchubook2) {
		String b3;
		b3 = s.nextLine();
		searchubook2.setCompany(b3);

	}

	public void pubedit(BookVO searchubook2) {
		String b5;
		b5 = s.nextLine();
		searchubook2.setPublish(b5);

	}

	public void delbook(BookVO searchbook) {

		BookDao.getInstance().delbook(searchbook);
		System.out.println("[ 삭제되었습니다 ]");

	}

}