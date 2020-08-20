package service;

import java.text.*;
import java.util.*;
import vo.BookVO;
import vo.OutBookVO;
import dao.BookDao;
import dao.OutBookDao;
import data.Session;

public class BookService {

	private static BookService instance;

	private BookService() {
	}

	public static BookService getInstance() {
		if (instance == null) {
			instance = new BookService();
		}
		return instance;
	}

	Scanner s = new Scanner(System.in);

	public void Search() {
		String a = "";
		do {
			System.out.println("------[도서검색]------");
			System.out.println("검색어를 입력해주세요. (뒤로가기 : 0)");
			a = s.nextLine();
			BookDao bDao = BookDao.getInstance();
			// 데이터 베이스 책 리스트 가져오기
			ArrayList<BookVO> bList = bDao.selectbooklist();
			// 검색된 도서 담을 배열 선언
			ArrayList<BookVO> sList = new ArrayList<>();
			// a가 0이면 뒤로가기
			if (!a.equals("0")) {
				// DB 책리스트 for 문으로 검색어와 모두 대조
				for (int i = 0; i < bList.size(); i++) {
					// i번 인덱스의 북 VO 담기
					BookVO book = bList.get(i);
					// 모든 정보 ser 스트링에 담기
					String ser = book.getCode() + book.getCompany()
							+ book.getTitle() + book.getWriter()
							+ book.getPublish();
					boolean o = false;
					// 입력받은 검색어 하나하나 대조
					for (int j = 0; j < a.length(); j++) {
						// o 초기화 (한글자라도 미포함시 검색결과에서 제외하기 위함)
						o = false;
						// 검색어 공백이거나 ser에 포함시 true
						if (a.substring(j, j + 1).equals(" ")
								|| ser.contains(a.substring(j, j + 1))) {
							o = true;
							continue;
						}
						// 검색어가 ser에 미포함시 o가 false 이므로 조건문 탈출
						if (!o)
							break;
					}
					// o가 true로 나오면 모든 검색어가 존재하므로 정보 추가 아닐시 추가 없이 다음 책으로 넘어감
					if (o) {
						sList.add(book);
					}
				}
				// 검색결과 존재시 표현/대여창
				if (sList.size() != 0) {
					print(sList);
					rent(sList);
				} else {
					System.out.println("[ 일치하는 도서가 없습니다 ]");
				}
			}
		} while (!a.equals("0"));

	}

	public void print(ArrayList<BookVO> sList) {
		// 검색해서 담은 자료들을 출력시키는 메소드
		// 꼭 검색이 아니여도 tb_booklist를 받아 출력하는 메소드
		OutBookDao oDao = OutBookDao.getInstance();
		System.out
				.println("-----------------------------------------------------");
		System.out.println("번호\t도서명\t저자\t출판사\t도서코드\t출판일\t대출여부/반납예정일");
		System.out
				.println("-----------------------------------------------------");
		for (int i = 0; i < sList.size(); i++) {
			BookVO book = sList.get(i);
			OutBookVO oBook = new OutBookVO();
			oBook = oDao.selectOutBook(book);
			// 빌리고 반납 안하면 대출중 표현
			if (oBook.getGiveDate() != null && oBook.getReturnDate() == null) {
				System.out.println(i + 1 + "\t" + book.getTitle() + "\t"
						+ book.getWriter() + "\t" + book.getCompany() + "\t"
						+ book.getCode() + "\t" + book.getPublish() + "\t"
						+ "대출중/" + oBook.getGiveDate());
			} else {
				System.out.println(i + 1 + "\t" + book.getTitle() + "\t"
						+ book.getWriter() + "\t" + book.getCompany() + "\t"
						+ book.getCode() + "\t" + book.getPublish() + "\t대출가능");
			}
		}

	}

	public void rent(ArrayList<BookVO> sList) {
		// 대여메소드

		OutBookDao oDao = OutBookDao.getInstance();
		BookVO rent = null;
		int check = lateCheck();
		// latecheck 메소드가 3이라면
		// 연체시 check 3
		if (check == 3) {
			System.out.println("[ 연체로 인해 대여할 수 없습니다 ]");
			return;
		}
		// 정상시 0
		if (check == 0) {
			do {
				System.out.print("대여할 도서 번호> ");
				try {
					int r = Integer.parseInt(s.nextLine());
					rent = sList.get(r - 1);
				} catch (Exception e) {
					System.out.println("[ 잘못된 값을 입력하였습니다 ]");
					print(sList);
				}
			} while (rent == null);
			// 빌리고 반납 안한 책을 골랐을때
			if (oDao.selectOutBook(rent).getRentDate() != null
					&& oDao.selectOutBook(rent).getReturnDate() == null) {
				System.out.println("[ 이미 대출중인 도서입니다 ]");
				return;
			}
			int choice = -1;
			// 절대눌리지 않을 값을 부여
			// 0으로 했을경우 뒤로가기가 실행되기때문에
			do {
				do {
					System.out.println(rent.getTitle()
							+ " 을/를 대여하시겠습니까?\n 1 : 대여\n 2 : 취소");
					try {
						choice = Integer.parseInt(s.nextLine());
					} catch (Exception e) {
					}
					if (!(choice == 1 || choice == 2)) {
						System.out.println("[ 잘못된 값을 입력하였습니다 ]");
						s.nextLine();
					}
				} while (!(choice == 1 || choice == 2));
			} while (choice < 0);

			if (choice == 1) {
				SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MM.dd");
				Calendar cal = setCal();

				OutBookVO rentO = new OutBookVO();
				rentO.setOutCode(rent.getCode());
				rentO.setRentDate(sdf1.format(cal.getTime()));
				cal.add(Calendar.DAY_OF_MONTH, 14);
				// cal(현재날짜) 14일 더함
				rentO.setGiveDate(sdf1.format(cal.getTime()));
				rentO.setRenter(Session.loginUser.getUserID());
				oDao.insertOutBook(rentO);

				System.out.println("[ " + rent.getTitle() + " 대여 되었습니다 ]");
			} else
				System.out.println("[ 취소되었습니다 ]");

		}
		if (check == 2)
			System.out.println("[ 대출 가능한 권수를 초과하였습니다 ]");

	}

	public int lateCheck() {
		OutBookDao oDao = OutBookDao.getInstance();
		ArrayList<OutBookVO> cList = oDao.checkOutBook(Session.loginUser);
		ArrayList<OutBookVO> aList = oDao.checkOutBookall(Session.loginUser);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		Date today = new Date();
		Date dateGive = new Date();
		Date dateRe = new Date();
		Calendar cal = setCal();
		cal.add(Calendar.DAY_OF_MONTH, -3);
		Date by = cal.getTime();
		int rtn = 0;
		// 연체중 확인
		for (int i = 0; i < cList.size(); i++) {
			String give = cList.get(i).getGiveDate();
			try {
				dateGive = sdf.parse(give);
			} catch (ParseException e) {
			}

			if (dateGive.after(today))
				continue;
			// 다음번 반복문을 수행
			// 반납예정일 해당날짜보다 뒤면은 연체가 아니다 .
			System.out.println("[ "
					+ BookDao.getInstance().selectBook(cList.get(i)).getTitle()
					+ "을 연체중입니다 ]");
			rtn = 3;
			continue;
			// ??? 쓸데가 있나 ???
		}
		if (rtn == 3)
			return rtn;

		// 유저가 연체를 해서 대여불가기간을 계산하는 반복문
		for (int i = 0; i < aList.size(); i++) {
			// alist : 내가 빌린 도서들의 전체목록
			// 그중 반납 한것을 전부 비교
			if (aList.get(i).getReturnDate() != null) {
				String re = aList.get(i).getReturnDate();
				String give = aList.get(i).getGiveDate();
				try {
					dateRe = sdf.parse(re);
					dateGive = sdf.parse(give);
				} catch (ParseException e) {
				}

				if (dateRe.after(dateGive)) {
					// 반납기간을 계산해서
					long diff = dateRe.getTime() - dateGive.getTime();
					long diffday = diff / (24 * 60 * 60 * 1000);
					cal.setTime(dateRe);
					cal.add(Calendar.DAY_OF_MONTH, (int) diffday);
					by = by.after(cal.getTime()) ? by : cal.getTime();
				}
			}
		}

		cal = setCal();
		if (by.after(cal.getTime())) {
			// 반납기간이 연체가 된 경우 출력
			System.out.println("[ 연체로 인해 " + sdf.format(by)
					+ " 까지 대여/연장 불가입니다 ]");
			System.out.println();
			return 3;
			// re3 = 연체
		}
		if (cList.size() == 0)
			return 0;
		// 대여중인 도서 권수 확인
		if (cList.size() == 2)
			return 2;
		// re2 = 두권 빌렸을때
		return rtn;
	}

	public void myRent() {
		ArrayList<OutBookVO> bookO = OutBookDao.getInstance().checkOutBook(
				Session.loginUser);
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MM.dd");
		OutBookVO obook = new OutBookVO();
		//대출한 도서를 불러들여 저장할 배열
		Date obookday = new Date();
		//그 도서에대한 날짜 저장
		Date give = new Date();
		//반납해야하는 날짜 
		Date re = new Date();
		//실제 대여일 
		int b = -1;
		if (bookO.size() == 0) {
//			 UserService.getInstance().mypage2();
			System.out.println("[ 반납/연장할 도서가 없습니다 ]");
			s.nextLine();
			return;
		} else {
			do {
//				 UserService.getInstance().mypage2();

				System.out.println("번호\t도서명\t\t\t\t출판사\t\t작가명\t\t대여일\t\t반납예정일");
				System.out
						.println("------------------------------------------------------------------------------------");
				for (int i = 0; i < bookO.size(); i++) {
					BookVO book = BookDao.getInstance()
							.selectBook(bookO.get(i));
					System.out
							.printf(i + 1 + "\t" + "%-40s\t", book.getTitle());// 제목
					System.out.print(book.getCompany() + "\t\t");
					System.out.printf("%-10s\t", book.getWriter());// 제목
					System.out.println(bookO.get(i).getRentDate() + "\t"
							+ bookO.get(i).getGiveDate());
				}
				System.out.print("반납/연장 하실 도서 번호를 입력하세요 > ");
				try {
					b = Integer.parseInt(s.nextLine());
					obook = bookO.get(b - 1);
				} catch (Exception e) {
				}
				if (obook.getRentDate() == null) {
					System.out.println("[ 잘못된 값을 입력하였습니다 ]");
					s.nextLine();
				}
			} while (obook.getRentDate() == null);
			b = -1;
			try {
				give = sdf1.parse(obook.getGiveDate());
				re = sdf1.parse(obook.getRentDate());
				// 심플데이트 포멧을 이용했을때 스트링으로 형변환 시키는 데 yyyy.mm.dd _> 인식을 못함
			} catch (ParseException e) {
			}
			long diff = give.getTime() - re.getTime();
			long diffday = diff / (24 * 60 * 60 * 1000);

			int a = lateCheck();
			if (a == 3) {
				do {
					System.out.println();
					System.out.println("[ 회원님은 연체로 인해 반납만 가능합니다 ]");
					System.out.println("1 : 반납\n0 : 뒤로가기");
					try {
						b = Integer.parseInt(s.nextLine());
					} catch (Exception e) {
					}
					if (!(b == 1 || b == 0)) {
						System.out.println("[ 잘못된 값을 입력하였습니다 ]");
						s.nextLine();
					}
				} while (!(b == 1 || b == 0));

				switch (b) {
				case 1:
					obook.setReturnDate(sdf1.format(setCal().getTime()));
					System.out.println("[ 도서가 반납되었습니다 ]");
					return;
				case 0:
					return;
				}
			} 
			else if (diffday > 14)
			{
				do {
					System.out.println();
					System.out.println("[ 이미 연장한 도서 입니다 ]");
					System.out.println("[ 반납만 가능합니다 ]");
					System.out.println("1 : 반납\n0 : 뒤로가기");
					try {
						b = Integer.parseInt(s.nextLine());
					} catch (Exception e) {
					}
					if (!(b == 1 || b == 0))
					{
						System.out.println("[ 잘못된 값을 입력하였습니다 ]");
						s.nextLine();
					}
				} while (!(b == 1 || b == 0));

				switch (b) {
				case 1:
					obook.setReturnDate(sdf1.format(setCal().getTime()));
					System.out.println("[ 도서가 반납되었습니다 ]");
					return;
				case 0:
					return;
				}
			}
			else {
				do {
					System.out.println("1 : 반납\n2 : 연장\n0 : 뒤로가기");
					try {
						b = Integer.parseInt(s.nextLine());
					} catch (Exception e) {
					}
					if (!(a == 1 || a == 2 || a == 0))
						System.out.println("[ 잘못된 값을 입력하였습니다 ]");
				} while (!(a == 1 || a == 2 || a == 0));

				switch (b) {
				case 1:
					obook.setReturnDate(sdf1.format(setCal().getTime()));
					System.out.println("[ 도서가 반납되었습니다 ]");
					return;
				case 2:
					Calendar cal = setCal();
					cal.add(Calendar.DAY_OF_MONTH, 7);
					Date day = cal.getTime();
					try {
						obookday = sdf1.parse(obook.getGiveDate());
					} catch (ParseException e) {
					}
					if (day.after(obookday)) {
						obook.setGiveDate(sdf1.format(cal.getTime()));
						System.out.println("[ 반납기한이 "
								+ sdf1.format(cal.getTime()) + "로 연장되었습니다 ]");
						// cal.getTime date 형식으로 넣어준다.
						return;
					} else {
						System.out.println("[ 반납기한이 연장기한보다 이후입니다 ]");
						s.nextLine();
						return;
					}

				case 0:
					return;
				}

			}
		}

	}

	public Calendar setCal() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal;
	}

	public void best() {
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MM.dd");
		ArrayList<BookVO> best = new ArrayList<>();
		OutBookDao obook = OutBookDao.getInstance();
		BookDao book = BookDao.getInstance();
		ArrayList<BookVO> blist = book.selectbooklist();
		ArrayList<OutBookVO> olist = obook.selectOutBookList();
		BookVO bv;
		Calendar cal = setCal();
		cal.set(Calendar.DAY_OF_MONTH, 1);
		int s = 0;
		int end = 0;
		for (int i = 0; i < blist.size(); i++) {
			s = 0;
			bv = blist.get(i);
			for (int j = 0; j < olist.size(); j++) {
				if (bv.getCode() == olist.get(j).getOutCode()) {
					try {
						cal.add(Calendar.DAY_OF_MONTH, -1);
						if (cal.getTime().after(
								sdf1.parse(olist.get(j).getRentDate()))) {
							cal.add(Calendar.MONTH, -1);
							if (cal.getTime().before(
									sdf1.parse(olist.get(j).getRentDate()))) {
								s++;
							}
							cal.add(Calendar.MONTH, 1);
							cal.add(Calendar.DAY_OF_MONTH, 1);
						}
					} catch (ParseException e) {
					}

				}
			}
			if (s == end) {
				best.add(bv);
				continue;
			}
			if (s > end) {
				end = s;
				best = new ArrayList<>();
				best.add(bv);
			} else {
				continue;
			}
		}
		// System.out.println("도서명\t\t\t\t출판사\t\t작가명\t\t대여횟수");
		System.out.println("★ 인기 대출도서 ★ ");
		for (int i = 0; i < best.size(); i++) {
			// System.out.printf("%-40s\t", best.get(i).getTitle());// 제목
			// System.out.print(best.get(i).getCompany() + "\t\t");
			// System.out.printf("%-10s\t", best.get(i).getWriter());// 제목
			System.out.println("< " + best.get(i).getTitle() + " >");

			// System.out.println(end);
		}

	}

	public void newBook() { // 신간도서

		BookDao bDao = BookDao.getInstance();
		ArrayList<BookVO> bList = bDao.selectbooklist();
		ArrayList<BookVO> sList = new ArrayList<>();

		long diff = 0L;
		long diffDays = 0L;
		for (int i = 0; i < bList.size(); i++) {
			DateFormat sdFormat = new SimpleDateFormat("yyyyMMdd");
			Date nowDate = new Date();
			BookVO book = bList.get(i);

			String today = sdFormat.format(nowDate);
			String Pday = book.getPublish();

			try {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
				Date beginDate = formatter.parse(today);
				Date endDate = formatter.parse(Pday);

				// 시간차이를 시간,분,초를 곱한 값으로 나누면 하루 단위가 나옴
				diff = beginDate.getTime() - endDate.getTime();
				diffDays = diff / (24 * 60 * 60 * 1000);

			} catch (ParseException e) {
				e.printStackTrace();
			}

			if (diffDays < 90) { // 60일 이하인 도서 출력해보기.
				sList.add(book);
			}

		}
		Collections.shuffle(sList);
		System.out.println("★ 추천 신간도서 ★ ");
		try {
			System.out.println("< " + sList.get(0).getTitle() + " >");
		} catch (Exception e) {
			System.out.println("[ 이번달 신간도서가 없습니다 ]");
		}
	}

}