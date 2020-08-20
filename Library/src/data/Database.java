package data;

import java.util.ArrayList;

import vo.BookVO;
import vo.NoticeVO;
import vo.OutBookVO;
import vo.ReadingRoomListVO;
import vo.ReadingRoomVO;
import vo.UserVO;

public class Database {

	private static Database instance;

	private Database() {
	}

	public static Database getInstance() {
		if (instance == null) {
			instance = new Database();
		}
		return instance;
	}

	public ArrayList<UserVO> tb_user = new ArrayList<>();

	{
		UserVO user = new UserVO();
		user.setUserType(true);
		// setusertype는 boolean타입이므로 true/false 입력
		user.setUserID("admin");
		user.setUserPass("12345");
		user.setUserName("관리자");
		user.setUserPhone("010-1234-5678");
		user.setUserAddress("대전 광역시 중구 대흥동");
		tb_user.add(user);
		
		user = new UserVO();
		user.setUserID("ddj5432");
		user.setUserPass("1234");
		user.setUserName("동동주");
		user.setUserPhone("010-9876-5432");
		user.setUserAddress("대전 광역시 유성구 봉명동 987-7");
		tb_user.add(user);

		user = new UserVO();
		user.setUserID("ldb1572");
		user.setUserPass("1234");
		user.setUserName("이동백");
		user.setUserPhone("010-1231-1572");
		user.setUserAddress("대전 광역시 유성구 지족동 123-1");
		tb_user.add(user);

		user = new UserVO();
		user.setUserID("kth5564");
		user.setUserPass("1234");
		user.setUserName("김태희");
		user.setUserPhone("010-4121-5564");
		user.setUserAddress("대전 광역시 대덕구 대덕대로 12");
		tb_user.add(user);

		user = new UserVO();
		user.setUserID("kth0012");
		user.setUserPass("1234");
		user.setUserName("김태희");
		user.setUserPhone("010-5167-0012");
		user.setUserAddress("대전광역시 유성구 은구비로 100-223");
		tb_user.add(user);

		user = new UserVO();
		user.setUserID("kdw4567");
		user.setUserPass("1234");
		user.setUserName("강동원");
		user.setUserPhone("010-5674-4567");
		user.setUserAddress("대전광역시 유성구 대학로163번길 67");
		tb_user.add(user);

		user = new UserVO();
		user.setUserID("dmj0505");
		user.setUserPass("1234");
		user.setUserName("단무지");
		user.setUserPhone("010-6754-0505");
		user.setUserAddress("대전광역시 유성구 대학로163번길 67");
		tb_user.add(user);

		user = new UserVO();
		user.setUserID("kno3690");
		user.setUserPass("1234");
		user.setUserName("김네오");
		user.setUserPhone("010-9876-3690");
		user.setUserAddress("대전광역시 유성구 대학로163번길 67");
		tb_user.add(user);

		user = new UserVO();
		user.setUserID("apc9126");
		user.setUserPass("1234");
		user.setUserName("어피치");
		user.setUserPhone("010-7475-9126");
		user.setUserAddress("대전광역시 유성구 대학로163번길 67");
		tb_user.add(user);

		user = new UserVO();
		user.setUserID("pro7530");
		user.setUserPass("1234");
		user.setUserName("박라온");
		user.setUserPhone("010-6563-7530");
		user.setUserAddress("대전광역시 유성구 대학로163번길 67");
		tb_user.add(user);

		user = new UserVO();
		user.setUserID("kch1288");
		user.setUserPass("1234");
		user.setUserName("김철희");
		user.setUserPhone("010-1234-1288");
		user.setUserAddress("대전광역시 유성구 대학로163번길 67");
		tb_user.add(user);

		user = new UserVO();
		user.setUserID("ljk8282");
		user.setUserPass("1234");
		user.setUserName("이제경");
		user.setUserPhone("010-1234-8282");
		user.setUserAddress("대전광역시 유성구 대학로163번길 67");
		tb_user.add(user);

	}

	public ArrayList<NoticeVO> tb_notice = new ArrayList<>();

	{
		// 제목 12자이내 //내용 20자이내 //작성자 3자 //날짜 2020.10.10
		NoticeVO notice = new NoticeVO();
		notice = new NoticeVO();
		notice.setTitle("열람실 내 정숙");
		notice.setContents("모두가 사용하는 공간을 정숙하게 사용해주세요.");
		notice.setWriter("관리자");
		notice.setWriteDate("2020.01.01");
		tb_notice.add(notice);

		notice = new NoticeVO();
		notice.setTitle("분리수거 안내");
		notice.setContents("플라스틱,유리,종이 및 분리수거 철저히해주세요.");
		notice.setWriter("관리자");
		notice.setWriteDate("2020.01.17");
		tb_notice.add(notice);

		notice = new NoticeVO();
		notice.setTitle("설날휴무");
		notice.setContents("1/24 ~ 1/27 도서관 휴무입니다.");
		notice.setWriter("관리자");
		notice.setWriteDate("2020.01.20");
		tb_notice.add(notice);

		notice = new NoticeVO();
		notice.setTitle("열람실 음식물 반입금지");
		notice.setContents("열람실 내 음식물 반입을 금지합니다.");
		notice.setWriter("관리자");
		notice.setWriteDate("2020.01.22");
		tb_notice.add(notice);

		notice = new NoticeVO();
		notice.setTitle("도서 장기 미납자");
		notice.setContents("박*정,임*진,김*희 위 3명 안내데스크로 와주세요.");
		notice.setWriter("관리자");
		notice.setWriteDate("2020.01.23");
		tb_notice.add(notice);

	}
	public ArrayList<BookVO> tb_book = new ArrayList<>();
	{
		BookVO book = new BookVO();

		book = new BookVO();
		book.setTitle("철학이 필요한 순간");
		book.setWriter("스벤 브링크만");
		book.setCompany("다산초당 ");
		book.setCode(100001);
		book.setPublish("20190712");
		tb_book.add(book);

		book = new BookVO();
		book.setTitle("장회익의 자연철학 강의");
		book.setWriter("장회익");
		book.setCompany("청림출판");
		book.setCode(100002);
		book.setPublish("20190920");
		tb_book.add(book);

		book = new BookVO();
		book.setTitle("언어철학");
		book.setWriter("콜린 맥긴");
		book.setCompany("b");
		book.setCode(100003);
		book.setPublish("20191101");
		tb_book.add(book);

		book = new BookVO();
		book.setTitle("고요할수록 밝아지는 것들 ");
		book.setWriter("혜민");
		book.setCompany("수오서재");
		book.setCode(200001);
		book.setPublish("20181205");
		tb_book.add(book);

		book = new BookVO();
		book.setTitle("오늘도 펭수, 내일도 펭수 ");
		book.setWriter("펭수");
		book.setCompany("EBS");
		book.setCode(200002);
		book.setPublish("20191220");
		tb_book.add(book);

		book = new BookVO();
		book.setTitle("바디 : 우리 몸 안내서 ");
		book.setWriter("빌브라이슨");
		book.setCompany("까치(까치글방)");
		book.setCode(300001);
		book.setPublish("20200110");
		tb_book.add(book);

		book = new BookVO();
		book.setTitle("식물의 책 ");
		book.setWriter("이소영");
		book.setCompany("책읽는수요일");
		book.setCode(300002);
		book.setPublish("20191025");
		tb_book.add(book);

		book = new BookVO();
		book.setTitle("왜 우리는 살찌는가");
		book.setWriter("게리타우브스");
		book.setCompany("알마");
		book.setCode(300003);
		book.setPublish("20200106");
		tb_book.add(book);

		book = new BookVO();
		book.setTitle("고양이와 배우는 기발한 미술사");
		book.setWriter("니아굴드");
		book.setCompany("자유의길");
		book.setCode(400001);
		book.setPublish("20190310");
		tb_book.add(book);

		book = new BookVO();
		book.setTitle("우리말 문법론 ");
		book.setWriter("고영근,구본관");
		book.setCompany("집문당");
		book.setCode(500001);
		book.setPublish("20180220");
		tb_book.add(book);

		book = new BookVO();
		book.setTitle("해리포터와 마법사의 돌");
		book.setWriter("JK롤링");
		book.setCompany("블룸즈베리 퍼블리싱");
		book.setCode(800001);
		book.setPublish("20141218");
		tb_book.add(book);

		book = new BookVO();
		book.setTitle("우리가 빛의 속도로 갈 수 없다면");
		book.setWriter("김초엽");
		book.setCompany("허블");
		book.setCode(800002);
		book.setPublish("20190624");
		tb_book.add(book);

		book = new BookVO();
		book.setTitle("작가들의 비밀스러운 삶");
		book.setWriter("기욤뮈소");
		book.setCompany("밝은세상");
		book.setCode(800003);
		book.setPublish("20191121");
		tb_book.add(book);

		book = new BookVO();
		book.setTitle("설민석의 조선왕조실록");
		book.setWriter("설민석");
		book.setCompany("세계사");
		book.setCode(900001);
		book.setPublish("20160725");
		tb_book.add(book);

		book = new BookVO();
		book.setTitle("백범일지");
		book.setWriter("김구");
		book.setCompany("돌베개");
		book.setCode(900002);
		book.setPublish("20051105");
		tb_book.add(book);

		book = new BookVO();
		book.setTitle("우린 너무 몰랐다");
		book.setWriter("김용옥");
		book.setCompany("통나무");
		book.setCode(900003);
		book.setPublish("20190128");
		tb_book.add(book);
	}

	public ArrayList<OutBookVO> tb_outBook = new ArrayList<>();

	{
		OutBookVO a = new OutBookVO();
		// (1)2/3기준 반납자
		// 두권 다 늦게 반납해서 10일동안 못빌리는 동동주 -10일동안 대여금지,2/3일 기준 대여금지
		a.setOutCode(100001);
		a.setRentDate("2020.01.01");
		a.setGiveDate("2020.01.15");
		a.setReturnDate("2020.01.25");
		a.setRenter("ddj5432");
		tb_outBook.add(a);

		a = new OutBookVO();
		a.setOutCode(100002);
		a.setRentDate("2020.01.01");
		a.setGiveDate("2020.01.15");
		a.setReturnDate("2020.01.25");
		a.setRenter("ddj5432");
		tb_outBook.add(a);

		// 두권 빌려서 잘 반납한 이동백
		a = new OutBookVO();
		a.setOutCode(100003);
		a.setRentDate("2020.01.01");
		a.setGiveDate("2020.01.15");
		a.setReturnDate("2020.01.13");
		a.setRenter("ldb1572");
		tb_outBook.add(a);

		a = new OutBookVO();
		a.setOutCode(200001);
		a.setRentDate("2020.01.01");
		a.setGiveDate("2020.01.15");
		a.setReturnDate("2020.01.13");
		a.setRenter("ldb1572");
		tb_outBook.add(a);

		// 한권 빌려서 한권 잘 반납한 이동백
		a = new OutBookVO();
		a.setOutCode(900002);
		a.setRentDate("2020.01.14");
		a.setGiveDate("2020.01.28");
		a.setReturnDate("2020.01.21");
		a.setRenter("ldb1572");
		tb_outBook.add(a);

		// 두권 빌려서 잘 반납한 김네오
		a = new OutBookVO();
		a.setOutCode(300002);
		a.setRentDate("2019.01.14");
		a.setGiveDate("2019.01.28");
		a.setReturnDate("2020.01.27");
		a.setRenter("kno3690");
		tb_outBook.add(a);

		a = new OutBookVO();
		a.setOutCode(400001);
		a.setRentDate("2019.01.14");
		a.setGiveDate("2019.01.28");
		a.setReturnDate("2020.01.27");
		a.setRenter("kno3690");
		tb_outBook.add(a);

		// 두권 빌려서 한권을 11일 늦게 반납한 김태희 -11일동안 대여금지
		a = new OutBookVO();
		a.setOutCode(900003);
		a.setRentDate("2020.01.04");
		a.setGiveDate("2020.01.19");
		a.setReturnDate("2020.01.12");
		a.setRenter("kth5564");
		tb_outBook.add(a);

		a = new OutBookVO();
		a.setOutCode(800002);
		a.setRentDate("2020.01.04");
		a.setGiveDate("2020.01.19");
		a.setReturnDate("2020.01.30");
		a.setRenter("kth5564");
		tb_outBook.add(a);

		// 2/3기준 미반납자 (책을 반납안했음!!)
		// 연체없이 대여중인 어피치
		a = new OutBookVO();
		a.setOutCode(100001);
		a.setRentDate("2020.02.01");
		a.setGiveDate("2020.02.15");
		a.setRenter("apc9126");
		tb_outBook.add(a);

		// 연체없이 두권 대여중인 단무지
		a = new OutBookVO();
		a.setOutCode(200002);
		a.setRentDate("2020.02.01");
		a.setGiveDate("2020.02.15");
		a.setRenter("dmj0505");
		tb_outBook.add(a);

		a = new OutBookVO();
		a.setOutCode(300001);
		a.setRentDate("2020.01.31");
		a.setGiveDate("2020.02.14");
		a.setRenter("dmj0505");
		tb_outBook.add(a);

		// 두권 빌려서 두권다 연체중인 김태희
		a = new OutBookVO();
		a.setOutCode(300002);
		a.setRentDate("2020.01.15");
		a.setGiveDate("2020.01.29");
		a.setRenter("kth0012");
		tb_outBook.add(a);

		a = new OutBookVO();
		a.setOutCode(400001);
		a.setRentDate("2020.01.15");
		a.setGiveDate("2020.01.29");
		a.setRenter("kth0012");
		tb_outBook.add(a);

		// 유저B 이제경 (1권 7일 이상 대여, 1권 7일 미만 대여)
		a = new OutBookVO();
		a.setOutCode(800002);
		a.setRentDate("2020.01.31");
		a.setGiveDate("2020.02.14");
		a.setRenter("ljk8282");
		tb_outBook.add(a);

		a = new OutBookVO();
		a.setOutCode(900002);
		a.setRentDate("2020.01.25");
		a.setGiveDate("2020.02.07");
		a.setRenter("ljk8282");
		tb_outBook.add(a);

		// 유저C 김철희 (1권 연체, 1권 노연체)

		a = new OutBookVO();
		a.setOutCode(200002);
		a.setRentDate("2020.01.17");
		a.setGiveDate("2020.01.31");
		a.setRenter("kch1288");
		tb_outBook.add(a);

		a = new OutBookVO();
		a.setOutCode(300003);
		a.setRentDate("2020.01.23");
		a.setGiveDate("2020.02.06");
		a.setRenter("kch1288");
		tb_outBook.add(a);

	}

	public ArrayList<ReadingRoomVO> tb_readingroom = new ArrayList<>();
	// 어드민 좌석 늘리기,줄이기,삭제
	{
		{
			ReadingRoomVO vo = new ReadingRoomVO();
			vo.setSeatNum(1);
			vo.setWhat("사용가능");
			tb_readingroom.add(vo);
		}

		{
			ReadingRoomVO vo = new ReadingRoomVO();
			vo.setSeatNum(2);
			vo.setWhat("사용가능");
			tb_readingroom.add(vo);
		}

		{
			ReadingRoomVO vo = new ReadingRoomVO();
			vo.setSeatNum(3);
			vo.setWhat("사용가능");
			tb_readingroom.add(vo);
		}

		{
			ReadingRoomVO vo = new ReadingRoomVO();
			vo.setSeatNum(4);
			vo.setWhat("사용가능");
			tb_readingroom.add(vo);
		}

		{
			ReadingRoomVO vo = new ReadingRoomVO();
			vo.setSeatNum(5);
			vo.setWhat("사용가능");
			tb_readingroom.add(vo);
		}

		{
			ReadingRoomVO vo = new ReadingRoomVO();
			vo.setSeatNum(6);
			vo.setWhat("사용가능");
			tb_readingroom.add(vo);
		}

		{
			ReadingRoomVO vo = new ReadingRoomVO();
			vo.setSeatNum(7);
			vo.setWhat("사용가능");
			tb_readingroom.add(vo);
		}

		{
			ReadingRoomVO vo = new ReadingRoomVO();
			vo.setSeatNum(8);
			vo.setWhat("사용가능");
			tb_readingroom.add(vo);
		}

		{
			ReadingRoomVO vo = new ReadingRoomVO();
			vo.setSeatNum(9);
			vo.setWhat("사용가능");
			tb_readingroom.add(vo);
		}

		{
			ReadingRoomVO vo = new ReadingRoomVO();
			vo.setSeatNum(10);
			// vo.setState("수리중");
			vo.setWhat("사용가능");
			tb_readingroom.add(vo);
		}

		{
			ReadingRoomVO vo = new ReadingRoomVO();
			vo.setSeatNum(11);
			vo.setWhat("사용가능");
			tb_readingroom.add(vo);
		}

		{
			ReadingRoomVO vo = new ReadingRoomVO();
			vo.setSeatNum(12);
			vo.setWhat("사용가능");
			tb_readingroom.add(vo);
		}

		{
			ReadingRoomVO vo = new ReadingRoomVO();
			vo.setSeatNum(13);
			vo.setWhat("사용가능");
			tb_readingroom.add(vo);
		}

		{
			ReadingRoomVO vo = new ReadingRoomVO();
			vo.setSeatNum(14);
			vo.setWhat("사용가능");
			tb_readingroom.add(vo);
		}

		{
			ReadingRoomVO vo = new ReadingRoomVO();
			vo.setSeatNum(15);
			vo.setWhat("사용가능");
			tb_readingroom.add(vo);
		}

		{
			ReadingRoomVO vo = new ReadingRoomVO();
			vo.setSeatNum(16);
			vo.setWhat("사용가능");
			tb_readingroom.add(vo);
		}

		{
			ReadingRoomVO vo = new ReadingRoomVO();
			vo.setSeatNum(17);
			vo.setWhat("사용가능");
			tb_readingroom.add(vo);
		}

		{
			ReadingRoomVO vo = new ReadingRoomVO();
			vo.setSeatNum(18);
			vo.setWhat("사용가능");
			tb_readingroom.add(vo);
		}

		{
			ReadingRoomVO vo = new ReadingRoomVO();
			vo.setSeatNum(19);
			vo.setWhat("사용가능");
			tb_readingroom.add(vo);
		}

		{
			ReadingRoomVO vo = new ReadingRoomVO();
			vo.setSeatNum(20);
			vo.setWhat("사용가능");
			tb_readingroom.add(vo);
		}
	}

	public ArrayList<ReadingRoomListVO> tb_readingroomlist = new ArrayList<>();
	// 유저 발급 좌석
	{
		ReadingRoomListVO vo = new ReadingRoomListVO();

		vo.setSeatNum(5);
		vo.setUserId("김철희");
		vo.setWhat("김철희");
		tb_readingroomlist.add(vo);

	}

}