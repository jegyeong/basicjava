package service;

import java.util.Scanner;

import Session.UserSession;

public class MainService {
	private static MainService instance;
	private MainService() {
		super();
	}
	public static MainService getInstance() {
	if(instance == null) {instance = new MainService();}return instance;}
	NoticeService nsv = new NoticeService();
	GuestService gsv= new GuestService();
	UserService usv = new UserService();
	CompanyService csv= new CompanyService();
	MasterService msv = new MasterService();
	VehicleService vsv = new VehicleService();
	public Scanner scan = new Scanner(System.in);
	UserSession session = new UserSession();
	SearchService search = new SearchService();
	ReviewService rsv = new ReviewService();
	public void showMenus() {
		int select;
		do {
				//회원로그인
				if(session.loginUserType == 1) {
					//유저
					System.out.println("〓〓〓〓〓〓〓   메뉴   〓〓〓〓〓〓〓");
					System.out.println("1. 자동차 검색");
					System.out.println("2. 자동차 반납");
					System.out.println("3. 자동차 대여내역");
					System.out.println("4. 마일리지확인");
					System.out.println("5. 공지사항");
					System.out.println("6. 로그아웃");
					System.out.println("0. 프로그램 종료");
				}else if(session.loginUserType == 2){
					//사업
					System.out.println("〓〓〓〓〓〓〓   메뉴   〓〓〓〓〓〓〓");
					System.out.println("1. 차량등록");
					System.out.println("2. 차량관리");
					System.out.println("3. 대여해줄 목록");
					System.out.println("4. 업체리뷰보기");
					System.out.println("5. 공지사항");
					System.out.println("6. 로그아웃");
					System.out.println("0. 프로그램 종료");
				}else if(session.loginUserType == 3){
					//관리자
					System.out.println("〓〓〓〓〓〓〓   메뉴  〓〓〓〓〓〓〓");
					System.out.println("1. 업체관리");
					System.out.println("2. 사용자관리");
					System.out.println("3. 공지사항관리");
					System.out.println("4. 로그아웃");
					System.out.println("0. 프로그램 종료");
				}else if(session.loginUserType == 0){
					//비회원
					System.out.println("〓〓〓〓〓〓〓   메뉴   〓〓〓〓〓〓〓");
					System.out.println("1. 자동차 검색");
					System.out.println("2. 로그인");
					System.out.println("3. 회원가입");
					System.out.println("4. 공지사항");
					System.out.println("0. 프로그램 종료");
				}
			select = Integer.parseInt(scan.nextLine());
			switch (session.loginUserType) {
			case 1:controlUserMenu(select);break;
			case 2:controlCompanyMenu(select);break;
			case 3:	controlMasterMenu(select);break;
			case 0:controlGuestMenu(select);break;
			default:break;
			}
		}while(select!=0);
	}
	//사용자
	private void controlUserMenu(int select) {
		switch (select) {
		case 0:	System.exit(0);break;
		case 1:	search.selectRentDate();break;	//자동차 검색	-종욱 + 리뷰 + 결제
		case 2:	csv.showReturnMenu();break;		//자동차반납	-태유
		case 3:	usv.showUserRentList();break;	//자동차 대여내역 -주영
		case 4:	usv.chkMileage();break;			//마일리지확인
		case 5:	nsv.showNoticeList();break;		//공지사항
		case 6:	usv.logOut();break;				//로그아웃
		default:break;
		}
	}
	//사업체
	private void controlCompanyMenu(int select) {;
		switch (select) {
		case 0:	System.exit(0);break;
		case 1:	csv.showcovehicleMenu();break;	//차등록		-태유
		case 2:	csv.showControlMenu();break;	//차관리/삭제	-태유
		case 3:	csv.showReservations();break;							//대여해줄목록
		case 4: rsv.searchReview(0);break;		//업체관련 리뷰보기
		case 5:	nsv.showNoticeList();break;		//공지사항	
		case 6:	usv.logOut();break;				//로그아웃
		default:break;
		}
	}
	//관리자
	private void controlMasterMenu(int select) {	
		switch (select) {
		case 0:	System.exit(0);break;
		case 1: msv.companyManagement();break;	//업체관리
		case 2:	msv.userManagement();break;		//사용자관리
		case 3:	msv.noticeManagement();break;	//공지사항관리
		case 4:	msv.masterLogout();break;		//로그아웃
		default:break;
		}
	}
	//비회원
	private void controlGuestMenu(int select) {
		switch (select) {
		case 0:	System.exit(0);break;
		case 1: search.selectRentDate();break;		//자동차검색
		case 2:	usv.logIn();break;				//로그인
		case 3:	usv.selectUserType();break;		//회원가입
		case 4:	nsv.showNoticeList();break;		//공지사항
		default:break;
		}
	}








}
