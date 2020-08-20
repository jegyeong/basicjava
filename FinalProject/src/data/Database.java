package data;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import vo.CartVo;
import vo.FoodVo;
import vo.MenuCategoryVo;
import vo.MileageVo;
import vo.NoticeVo;
import vo.PaymentVo;
import vo.RecommendedMenuVo;
import vo.TableVo;
import vo.UserVo;

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

	public ArrayList<UserVo> tb_user = new ArrayList<UserVo>();
	public ArrayList<FoodVo> tb_food = new ArrayList<FoodVo>();
	public ArrayList<CartVo> tb_cart = new ArrayList<CartVo>();
	public ArrayList<MenuCategoryVo> tb_cartegory = new ArrayList<MenuCategoryVo>();
	public ArrayList<NoticeVo> tb_notice = new ArrayList<NoticeVo>();
	public ArrayList<PaymentVo> tb_payment = new ArrayList<PaymentVo>();
	public ArrayList<MileageVo> tb_Mileage = new ArrayList<MileageVo>();
	public ArrayList<RecommendedMenuVo> tb_rmenu = new ArrayList<RecommendedMenuVo>();
	public ArrayList<TableVo> tb_table = new ArrayList<TableVo>();
	
	{//추천메뉴 테이블
		RecommendedMenuVo rmenu = new RecommendedMenuVo();
		rmenu.setNo(0);
		rmenu.setFoodNo(0);
		rmenu.setContents("★BEST★차돌과 숙주의 최고의 조합 식감이 짱짱");
		tb_rmenu.add(rmenu);
		
		rmenu = new RecommendedMenuVo();
		rmenu.setNo(1);
		rmenu.setFoodNo(2);
		rmenu.setContents("★BEST★★BEST★★BEST★");
		tb_rmenu.add(rmenu);
	}
	{//유저 테이블 
		UserVo user = new UserVo();
		user.setId("admin");
		user.setPassword("admin");
		user.setName("관리자");
		user.setNum("비공개\t");
		user.setBirth("비공개");
		user.setMode(true);
		tb_user.add(user);
		
		user = new UserVo();
		user.setId("user01");
		user.setPassword("a");
		user.setName("김모군");
		user.setNum("010-6544-7897");
		user.setBirth("123456");
		tb_user.add(user);
		
		user = new UserVo();
		user.setId("user02");
		user.setPassword("aa");
		user.setName("김모양");
		user.setNum("010-1234-4567");
		user.setBirth("654321");
		tb_user.add(user);
		
		user = new UserVo();
		user.setId("user03");
		user.setPassword("aaa");
		user.setName("김모쯔");
		user.setNum("010-1234-4567");
		user.setBirth("654321");
		tb_user.add(user);
		
		
		user = new UserVo();
		user.setId("user033214");
		user.setPassword("aaaa");
		user.setName("김쯔모");
		user.setNum("010-1234-4567");
		user.setBirth("654321");
		tb_user.add(user);
		
		
		user = new UserVo();
		user.setId("user020215635244");
		user.setPassword("aaaaa");
		user.setName("어린이");
		user.setNum("010-0000-0000");
		user.setBirth("000000");
		tb_user.add(user);
		
		user = new UserVo();
		user.setId("user11234567892132");
		user.setPassword("aaaaa");
		user.setName("어린이");
		user.setNum("010-0000-0000");
		user.setBirth("000000");
		tb_user.add(user);
		
		
	}
	{//공지사항
		NoticeVo notice = new NoticeVo();
		notice.setContents("신규 가입시 마일리지를 1000원 지급해드립니다\n기간 : 2020/02/01 ~ ");
		notice.setDate(new Date());
		notice.setId("admin");
		notice.setNo(0);
		notice.setSubject("★가입축하★ 이벤트~");
		tb_notice.add(notice);
		notice = new NoticeVo();
		notice.setContents("나랏말싸미 듕귁에 달아 문자와로 서르 사맛디 아니할쎄\n이런 젼차로 어린 백셩이 니르고져 홀 배 이셔도\n"
				+ "마참내 제 뜨들 시러펴디 몯 할 노미 하니라\n내 이랄 위하야 어엿비 너겨 새로 스믈 여듧 짜랄 맹가노니"
				+ "\n사람마다 해여 수비 니겨 날로 쑤메 뼌한킈 하고져 할따라미니라");	
		notice.setDate(new Date());
		notice.setId("admin");
		notice.setNo(1);
		notice.setSubject("나랏말싸미");
		tb_notice.add(notice);
		
	}
	{//결제 테이블
		PaymentVo payment =new PaymentVo();
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, -15); // 현재 날짜에서 30일을 뺸다.
		
		payment.setDate(new Date(cal.getTimeInMillis()));
		payment.setId("a");
		payment.setMilieage(300);
		payment.setNo(0);
		payment.setPaymentNo(100);
		payment.setRequests("현금결제");
		tb_payment.add(payment);
		
		payment =new PaymentVo();
		cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, -15); // 현재 날짜에서 30일을 뺸다.
		
		payment.setDate(new Date(cal.getTimeInMillis()));
		payment.setId("a");
		payment.setMilieage(500);
		payment.setNo(0);
		payment.setPaymentNo(101);
		payment.setRequests("현금결제");
		tb_payment.add(payment);
		
		payment =new PaymentVo();
		cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.YEAR, -1);
		cal.add(Calendar.DATE, -15); //2019 1월		
		payment.setDate(new Date(cal.getTimeInMillis()));
		payment.setId("a");
		payment.setMilieage(500);
		payment.setNo(0);
		payment.setPaymentNo(102);
		payment.setRequests("카드결제");
		tb_payment.add(payment);
		
		
		payment =new PaymentVo();
		cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.YEAR, -1); //2019 2월
		payment.setDate(new Date(cal.getTimeInMillis()));
		payment.setId("a");
		payment.setMilieage(500);
		payment.setNo(0);
		payment.setPaymentNo(103);
		payment.setRequests("카드결제");
		tb_payment.add(payment);
		
		payment =new PaymentVo();
		cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.YEAR, -1); //2019 3월
		cal.add(Calendar.MONTH, 1);
		payment.setDate(new Date(cal.getTimeInMillis()));
		payment.setId("a");
		payment.setMilieage(500);
		payment.setNo(0);
		payment.setPaymentNo(104);
		payment.setRequests("카드결제");
		tb_payment.add(payment);
		
		payment =new PaymentVo();
		cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.YEAR, -1); //2019 4월
		cal.add(Calendar.MONTH, 2);
		payment.setDate(new Date(cal.getTimeInMillis()));
		payment.setId("a");
		payment.setMilieage(500);
		payment.setNo(0);
		payment.setPaymentNo(105);
		payment.setRequests("카드결제");
		tb_payment.add(payment);
		
		payment =new PaymentVo();
		cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.YEAR, -1); //2019 5월
		cal.add(Calendar.MONTH, 3);
		payment.setDate(new Date(cal.getTimeInMillis()));
		payment.setId("a");
		payment.setMilieage(500);
		payment.setNo(0);
		payment.setPaymentNo(106);
		payment.setRequests("카드결제");
		tb_payment.add(payment);
		
		payment =new PaymentVo();
		cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.YEAR, -1); //2019 6월
		cal.add(Calendar.MONTH, 4);
		payment.setDate(new Date(cal.getTimeInMillis()));
		payment.setId("a");
		payment.setMilieage(500);
		payment.setNo(0);
		payment.setPaymentNo(107);
		payment.setRequests("현금결제");
		tb_payment.add(payment);
		
		payment =new PaymentVo();
		cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.YEAR, -1); //2019 7월
		cal.add(Calendar.MONTH, 5);
		payment.setDate(new Date(cal.getTimeInMillis()));
		payment.setId("a");
		payment.setMilieage(100);
		payment.setNo(0);
		payment.setPaymentNo(108);
		payment.setRequests("현금결제");
		tb_payment.add(payment);
		
		payment =new PaymentVo();
		cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.YEAR, -1); //2019 8월
		cal.add(Calendar.MONTH, 6);
		payment.setDate(new Date(cal.getTimeInMillis()));
		payment.setId("a");
		payment.setMilieage(0);
		payment.setNo(0);
		payment.setPaymentNo(109);
		payment.setRequests("카드결제");
		tb_payment.add(payment);
		
		payment =new PaymentVo();
		cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.YEAR, -1); //2019 9월
		cal.add(Calendar.MONTH, 7);
		payment.setDate(new Date(cal.getTimeInMillis()));
		payment.setId("a");
		payment.setMilieage(0);
		payment.setNo(0);
		payment.setPaymentNo(110);
		payment.setRequests("현금결제");
		tb_payment.add(payment);
		
		payment =new PaymentVo();
		cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.YEAR, -1);//2019 10월
		cal.add(Calendar.MONTH, 8);
		payment.setDate(new Date(cal.getTimeInMillis()));
		payment.setId("a");
		payment.setMilieage(300);
		payment.setNo(0);
		payment.setPaymentNo(111);
		payment.setRequests("카드결제");
		tb_payment.add(payment);
		
		payment =new PaymentVo();
		cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.YEAR, -1);//2019 11월
		cal.add(Calendar.MONTH, 9);
		payment.setDate(new Date(cal.getTimeInMillis()));
		payment.setId("a");
		payment.setMilieage(200);
		payment.setNo(0);
		payment.setPaymentNo(112);
		payment.setRequests("현금결제");
		tb_payment.add(payment);
		
		payment =new PaymentVo();
		cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.YEAR, -1); //2019 12월
		cal.add(Calendar.MONTH, 10);
		payment.setDate(new Date(cal.getTimeInMillis()));
		payment.setId("a");
		payment.setMilieage(0);
		payment.setNo(0);
		payment.setPaymentNo(113);
		payment.setRequests("카드결제");
		tb_payment.add(payment);
		
		payment =new PaymentVo();
		cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.YEAR, -1); //2019 12월
		cal.add(Calendar.MONTH, 11);
		payment.setDate(new Date(cal.getTimeInMillis()));
		payment.setId("a");
		payment.setMilieage(0);
		payment.setNo(0);
		payment.setPaymentNo(114);
		payment.setRequests("현금결제");
		tb_payment.add(payment);
	}
	{//카트 테이블
		CartVo cart = new CartVo();
		cart.setCount(4);
		cart.setFoodNo(2);
		cart.setNo(0);
		cart.setPaymentNo(100);
		tb_cart.add(cart);
		
		cart = new CartVo();
		cart.setCount(2);
		cart.setFoodNo(7);
		cart.setNo(1);
		cart.setPaymentNo(100);
		tb_cart.add(cart);
		
		cart = new CartVo();
		cart.setCount(5);
		cart.setFoodNo(12);
		cart.setNo(2);
		cart.setPaymentNo(100);
		tb_cart.add(cart);
		
		cart = new CartVo();
		cart.setCount(5);
		cart.setFoodNo(9);
		cart.setNo(3);
		cart.setPaymentNo(101);
		tb_cart.add(cart);
		
		cart = new CartVo();
		cart.setCount(5);
		cart.setFoodNo(11);
		cart.setNo(4);
		cart.setPaymentNo(101);
		tb_cart.add(cart);
		
		cart = new CartVo();
		cart.setCount(5);
		cart.setFoodNo(13);
		cart.setNo(5);
		cart.setPaymentNo(101);
		tb_cart.add(cart);
		
		cart = new CartVo();
		cart.setCount(5);
		cart.setFoodNo(12);
		cart.setNo(6);
		cart.setPaymentNo(102);
		tb_cart.add(cart);
		
		cart = new CartVo();
		cart.setCount(5);
		cart.setFoodNo(9);
		cart.setNo(7);
		cart.setPaymentNo(102);
		tb_cart.add(cart);
		
		cart = new CartVo();
		cart.setCount(2);
		cart.setFoodNo(4);
		cart.setNo(8);
		cart.setPaymentNo(103);
		tb_cart.add(cart);
		
		cart = new CartVo();
		cart.setCount(5);
		cart.setFoodNo(10);
		cart.setNo(9);
		cart.setPaymentNo(103);
		tb_cart.add(cart);
		
		cart = new CartVo();
		cart.setCount(6);
		cart.setFoodNo(4);
		cart.setNo(10);
		cart.setPaymentNo(103);
		tb_cart.add(cart);
		
		cart = new CartVo();
		cart.setCount(8);
		cart.setFoodNo(12);
		cart.setNo(11);
		cart.setPaymentNo(104);
		tb_cart.add(cart);
		
		cart = new CartVo();
		cart.setCount(8);
		cart.setFoodNo(1);
		cart.setNo(12);
		cart.setPaymentNo(104);
		tb_cart.add(cart);
		
		cart = new CartVo();
		cart.setCount(18);
		cart.setFoodNo(7);
		cart.setNo(13);
		cart.setPaymentNo(104);
		tb_cart.add(cart);
		
		cart = new CartVo();
		cart.setCount(2);
		cart.setFoodNo(2);
		cart.setNo(14);
		cart.setPaymentNo(105);
		tb_cart.add(cart);
		
		cart = new CartVo();
		cart.setCount(40);
		cart.setFoodNo(15);
		cart.setNo(15);
		cart.setPaymentNo(105);
		tb_cart.add(cart);
		
		cart = new CartVo();
		cart.setCount(1);
		cart.setFoodNo(1);
		cart.setNo(16);
		cart.setPaymentNo(106);
		tb_cart.add(cart);
		
		cart = new CartVo();
		cart.setCount(18);
		cart.setFoodNo(6);
		cart.setNo(17);
		cart.setPaymentNo(106);
		tb_cart.add(cart);
		
		cart = new CartVo();
		cart.setCount(28);
		cart.setFoodNo(9);
		cart.setNo(18);
		cart.setPaymentNo(106);
		tb_cart.add(cart);
		
		cart = new CartVo();
		cart.setCount(8);
		cart.setFoodNo(3);
		cart.setNo(19);
		cart.setPaymentNo(106);
		tb_cart.add(cart);
		
		cart = new CartVo();
		cart.setCount(40);
		cart.setFoodNo(16);
		cart.setNo(20);
		cart.setPaymentNo(107);
		tb_cart.add(cart);
		
		cart = new CartVo();
		cart.setCount(4);
		cart.setFoodNo(5);
		cart.setNo(21);
		cart.setPaymentNo(107);
		tb_cart.add(cart);
		
		cart = new CartVo();
		cart.setCount(11);
		cart.setFoodNo(11);
		cart.setNo(22);
		cart.setPaymentNo(108);
		tb_cart.add(cart);
		
		cart = new CartVo();
		cart.setCount(3);
		cart.setFoodNo(20);
		cart.setNo(23);
		cart.setPaymentNo(108);
		tb_cart.add(cart);
		
		cart = new CartVo();
		cart.setCount(6);
		cart.setFoodNo(15);
		cart.setNo(24);
		cart.setPaymentNo(108);
		tb_cart.add(cart);
		
		cart = new CartVo();
		cart.setCount(5);
		cart.setFoodNo(12);
		cart.setNo(25);
		cart.setPaymentNo(109);
		tb_cart.add(cart);
		
		cart = new CartVo();
		cart.setCount(8);
		cart.setFoodNo(17);
		cart.setNo(26);
		cart.setPaymentNo(109);
		tb_cart.add(cart);
		
		cart = new CartVo();
		cart.setCount(18);
		cart.setFoodNo(2);
		cart.setNo(27);
		cart.setPaymentNo(110);
		tb_cart.add(cart);
		
		cart = new CartVo();
		cart.setCount(2);
		cart.setFoodNo(10);
		cart.setNo(28);
		cart.setPaymentNo(110);
		tb_cart.add(cart);
		
		cart = new CartVo();
		cart.setCount(16);
		cart.setFoodNo(16);
		cart.setNo(29);
		cart.setPaymentNo(110);
		tb_cart.add(cart);
		
		cart = new CartVo();
		cart.setCount(5);
		cart.setFoodNo(6);
		cart.setNo(30);
		cart.setPaymentNo(110);
		tb_cart.add(cart);
		
		cart = new CartVo();
		cart.setCount(3);
		cart.setFoodNo(3);
		cart.setNo(31);
		cart.setPaymentNo(111);
		tb_cart.add(cart);
		
		cart = new CartVo();
		cart.setCount(8);
		cart.setFoodNo(8);
		cart.setNo(32);
		cart.setPaymentNo(111);
		tb_cart.add(cart);
		
		cart = new CartVo();
		cart.setCount(8);
		cart.setFoodNo(7);
		cart.setNo(33);
		cart.setPaymentNo(112);
		tb_cart.add(cart);
		
		cart = new CartVo();
		cart.setCount(3);
		cart.setFoodNo(1);
		cart.setNo(34);
		cart.setPaymentNo(112);
		tb_cart.add(cart);
		
		cart = new CartVo();
		cart.setCount(8);
		cart.setFoodNo(1);
		cart.setNo(35);
		cart.setPaymentNo(113);
		tb_cart.add(cart);
		
		cart = new CartVo();
		cart.setCount(6);
		cart.setFoodNo(8);
		cart.setNo(36);
		cart.setPaymentNo(113);
		tb_cart.add(cart);
		
		cart = new CartVo();
		cart.setCount(18);
		cart.setFoodNo(15);
		cart.setNo(37);
		cart.setPaymentNo(113);
		tb_cart.add(cart);
		
		cart = new CartVo();
		cart.setCount(3);
		cart.setFoodNo(19);
		cart.setNo(38);
		cart.setPaymentNo(113);
		tb_cart.add(cart);
		
		cart = new CartVo();
		cart.setCount(8);
		cart.setFoodNo(20);
		cart.setNo(39);
		cart.setPaymentNo(113);
		tb_cart.add(cart);
		
		cart = new CartVo();
		cart.setCount(4);
		cart.setFoodNo(10);
		cart.setNo(40);
		cart.setPaymentNo(113);
		tb_cart.add(cart);
		
		cart = new CartVo();
		cart.setCount(1);
		cart.setFoodNo(3);
		cart.setNo(41);
		cart.setPaymentNo(114);
		tb_cart.add(cart);	
		
		
		cart = new CartVo();
		cart.setCount(2);
		cart.setFoodNo(7);
		cart.setNo(42);
		cart.setPaymentNo(114);
		tb_cart.add(cart);
		
		cart = new CartVo();
		cart.setCount(5);
		cart.setFoodNo(12);
		cart.setNo(43);
		cart.setPaymentNo(114);
		tb_cart.add(cart);
		
	}
	{//마일리지테이블
		MileageVo mileage = new MileageVo();
		mileage.setDate(new Date());
		mileage.setId("a");
		mileage.setMiliage(500);
		mileage.setContents("순차적인 출력 실험 0");
		mileage.setNo(0);
		tb_Mileage.add(mileage);
		
		mileage = new MileageVo();
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, -29); 
		
		mileage.setDate(new Date(cal.getTimeInMillis()));
		mileage.setId("a");
		mileage.setMiliage(500);
		mileage.setContents("순차적인 출력 실험 1");
		mileage.setNo(1);
		tb_Mileage.add(mileage);
		
		
		mileage = new MileageVo();
		cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, -30); // 현재 날짜에서 30일을 뺸다.
		
		mileage.setDate(new Date(cal.getTimeInMillis()));
		mileage.setId("a");
		mileage.setMiliage(1000);
		mileage.setContents("회원가입");
		mileage.setNo(2);
		tb_Mileage.add(mileage);
		
	
		
	}
	{//카테고리 테이블 
		MenuCategoryVo menu = new MenuCategoryVo();
		menu.setNo(0);
		menu.setMenu("볶음/탕");
		tb_cartegory.add(menu);
		
		menu = new MenuCategoryVo();
		menu.setNo(1);
		menu.setMenu("마른안주");
		tb_cartegory.add(menu);
		
		menu = new MenuCategoryVo();
		menu.setNo(2);
		menu.setMenu("과일안주");
		tb_cartegory.add(menu);
		
		menu = new MenuCategoryVo();
		menu.setNo(3);
		menu.setMenu("주류");
		tb_cartegory.add(menu);
		
		menu = new MenuCategoryVo();
		menu.setNo(99);
		menu.setMenu("기타");
		tb_cartegory.add(menu);
		
		menu = new MenuCategoryVo();
		menu.setNo(4);
		menu.setMenu("음료");
		tb_cartegory.add(menu);
		
		
	}
	{//음식 테이블
		FoodVo food = new FoodVo();
		food.setNo(0);
		food.setCategory(0);
		food.setName("제육볶음");
		food.setPrice(8000);
		tb_food.add(food);

		food = new FoodVo();
		food.setNo(1);
		food.setCategory(0);
		food.setName("차돌숙주볶음차돌숙주볶음차돌숙주볶음차돌숙주볶음");
		food.setPrice(8000);
		tb_food.add(food);

		food = new FoodVo();
		food.setNo(2);
		food.setCategory(0);
		food.setName("낙지볶음");
		food.setPrice(9000);
		tb_food.add(food);

		food = new FoodVo();
		food.setNo(3);
		food.setCategory(0);
		food.setName("닭볶음탕");
		food.setPrice(10000);
		tb_food.add(food);

		food = new FoodVo();
		food.setNo(4);
		food.setCategory(0);
		food.setName("어묵탕");
		food.setPrice(5000);
		tb_food.add(food);

		food = new FoodVo();
		food.setNo(5);
		food.setCategory(1);
		food.setName("먹태");
		food.setPrice(10000);
		tb_food.add(food);

		food = new FoodVo();
		food.setNo(6);
		food.setCategory(1);
		food.setName("땅콩");
		food.setPrice(5000);
		tb_food.add(food);

		food = new FoodVo();
		food.setNo(7);
		food.setCategory(1);
		food.setName("쥐포");
		food.setPrice(5000);
		tb_food.add(food);

		food = new FoodVo();
		food.setNo(8);
		food.setCategory(1);
		food.setName("오징어");
		food.setPrice(9000);
		tb_food.add(food);

		food = new FoodVo();
		food.setNo(9);
		food.setCategory(1);
		food.setName("모듬마른안주");
		food.setPrice(12000);
		tb_food.add(food);

		food = new FoodVo();
		food.setNo(10);
		food.setCategory(2);
		food.setName("메론");
		food.setPrice(8000);
		tb_food.add(food);

		food = new FoodVo();
		food.setNo(11);
		food.setCategory(2);
		food.setName("황도");
		food.setPrice(5000);
		tb_food.add(food);

		food = new FoodVo();
		food.setNo(12);
		food.setCategory(2);
		food.setName("화채");
		food.setPrice(12000);
		tb_food.add(food);

		food = new FoodVo();
		food.setNo(13);
		food.setCategory(2);
		food.setName("모둠과일안주");
		food.setPrice(12000);
		tb_food.add(food);

		food = new FoodVo();
		food.setNo(14);
		food.setCategory(3);
		food.setName("소주");
		food.setPrice(4000);
		tb_food.add(food);

		food = new FoodVo();
		food.setNo(15);
		food.setCategory(3);
		food.setName("맥주");
		food.setPrice(4000);
		tb_food.add(food);

		food = new FoodVo();
		food.setNo(16);
		food.setCategory(3);
		food.setName("청하");
		food.setPrice(5000);
		tb_food.add(food);

		food = new FoodVo();
		food.setNo(17);
		food.setCategory(3);
		food.setName("심술");
		food.setPrice(6000);
		tb_food.add(food);

		food = new FoodVo();
		food.setNo(18);
		food.setCategory(4);
		food.setName("콜라");
		food.setPrice(1000);
		tb_food.add(food);

		food = new FoodVo();
		food.setNo(19);
		food.setCategory(4);
		food.setName("사이다");
		food.setPrice(1000);
		tb_food.add(food);

		food = new FoodVo();
		food.setNo(20);
		food.setCategory(4);
		food.setName("초코우유");
		food.setPrice(2000);
		tb_food.add(food);
	}
	{//테이블 테이블
		TableVo table = new TableVo();
		  table.setTablenumber(1);
		  table.setPossiblepeople(4);
		  tb_table.add(table);
		  
		  table = new TableVo();
		  table.setTablenumber(2);
		  table.setPossiblepeople(4);
		  tb_table.add(table);
		  
		  table = new TableVo();
		  table.setTablenumber(3);
		  table.setPossiblepeople(6);
		  
		  tb_table.add(table);
		  table = new TableVo();
		  table.setTablenumber(4);
		  table.setPossiblepeople(2);
		  
		  tb_table.add(table);
		  table = new TableVo();
		  table.setTablenumber(5);
		  table.setPossiblepeople(4);
		  
		  tb_table.add(table);
		  table = new TableVo();
		  table.setTablenumber(6);
		  table.setPossiblepeople(3);
		  
		  tb_table.add(table);
		  table = new TableVo();
		  table.setTablenumber(7);
		  table.setPossiblepeople(2);
		  table.setEnterpeople(2);
		  table.setUserId("aa");
		  tb_table.add(table);
		  
		  table = new TableVo();
		  table.setTablenumber(7);
		  table.setPossiblepeople(7);
		  table.setEnterpeople(2);
		  table.setUserId("aaa");
		  tb_table.add(table);
		  
		  table = new TableVo();
		  table.setTablenumber(9);
		  table.setPossiblepeople(2);
		  table.setEnterpeople(2);
		  table.setUserId("aaaa");
		  tb_table.add(table);
		  
	}
}
