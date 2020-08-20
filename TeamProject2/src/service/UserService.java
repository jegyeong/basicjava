package service;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import vo.UserRentVo;
import vo.UserVo;
import Session.UserSession;
import dao.UserDao;

public class UserService {
	UserSession session = new UserSession();
	Scanner scan = new Scanner(System.in);
	
	public boolean chkPattern(String input,int mode) {
		boolean regexChk = false;
		switch(mode){
		case 1:	//아이디
			String userIdRegex = "^[a-z0-9_]{5,15}\\W{0}$"; //소문자,숫자 5~15자리&특수문자x
			boolean userIdChk = Pattern.matches(userIdRegex, input);
			if(userIdChk==true)
				regexChk = true; break;
		case 2:	//패스워드
			String userPassRegex ="(?=.*[A-Za-z\\d])(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{10,20}";//대소문자,숫자 10~20자리&특수문자 1개이상포함
			boolean userPassChk = Pattern.matches(userPassRegex,input);
			if(userPassChk==true)
				regexChk = true; break;
		case 3:	//이름
			String userNameRegex = "^[가-힣]{2,5}$";//한글3~4자,특수문자x
			boolean userNameChk = Pattern.matches(userNameRegex, input);
			if(userNameChk==true)
				regexChk = true; break;
		case 4:	//전화번호
			String userPhoneRegex = "^(02|051|053|032|062|042|052|044|031|033|043|041|063|061|054|055|064|011|010|070)-\\d{3,4}-\\d{3,4}|(02|010|070)\\d{3,4}\\d{3,4}$";
			boolean userPhoneChk = Pattern.matches(userPhoneRegex, input);
			if(userPhoneChk==true)
				regexChk = true; break;
		case 5: //사업자번호
			String coNumRegex = "[0-9]{3}[0-9]{2}[0-9]{5}|[0-9]{3}-[0-9]{2}-[0-9]{5}";
			boolean coNumChk = Pattern.matches(coNumRegex, input);
			if(coNumChk==true)
				regexChk = true; break;
		case 6: //카드번호
			String cardRegex = "[0-4]{4}\\s[0-4]{4}\\s[0-4]{4}\\s[0-4]{4}";
			boolean cardNumChk = Pattern.matches(cardRegex, input);
			if(cardNumChk==true)
				regexChk = true; break;
		case 7: //카드유효기간번호	mm / yy
			String yymmRegex = "[0-1]{1}[0-2]{1}/[2-9]{1}[0-9]{1}";
			boolean yymmNumChk = Pattern.matches(yymmRegex, input);
			if(yymmNumChk==true)
				regexChk = true; break;
		case 8: //카드유효기간번호	mm / yy
			String cvcRegex = "[0-9]{3}";
			boolean cvcNumChk = Pattern.matches(cvcRegex, input);
			if(cvcNumChk==true)
				regexChk = true; break;
		default :
			break;
		}
		return regexChk;
	}
	
	public void selectUserType() {
		boolean isFinished = false;
		boolean isSelect = false;
		System.out.println("〓〓〓〓〓〓〓   회원가입  〓〓〓〓〓〓〓");
		System.out.println("당신은 사용자 /사업자 입니까?");
		System.out.println("1. 일반사용자");
		System.out.println("2. 렌트사업자");
		System.out.println("3. 뒤로가기");
		scan = new Scanner(System.in);		
		int typeInt = Integer.parseInt(scan.nextLine());
		if(typeInt>=1 && typeInt<=2) {
			try {
				switch(typeInt) {
				case 1:
					System.out.println("사용자를 선택 하셨습니다.");
					System.out.println("사용자 회원가입 창으로 이동합니다.");
					Thread.sleep(1500);
					createUser(typeInt);
					break;
				case 2:
					System.out.println("사업자를 선택 하셨습니다.");
					System.out.println("사업자 회원가입 창으로 이동합니다.");
					Thread.sleep(1500);
					createUser(typeInt);
					break;
					default:break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}else {
			return;
		}
	}
	private void createUser(int typeInt) {
		UserVo uvo = new UserVo();
		UserDao udao = new UserDao();
		uvo.setUserType(typeInt);
		boolean isFinished = false;
	do {
		System.out.println("\n 아이디를 입력해 주세요.\n");
		System.out.print(" 아이디 : ");
		String userId = scan.nextLine();
		boolean isIdUsed = chkPattern(userId,1);
		
		if(isIdUsed == true) {
			boolean userChk = udao.checkUserId(userId);
			if(userChk == false) {
				System.out.println(" 사용 가능한 아이디 입니다.");
				uvo.setUserId(userId);
				
				String userPass = createUserPass();
				String userName = createUserName();
				String userphone = createUserPhone();
				
				uvo.setUserPass(userPass);
				uvo.setUserName(userName);
				uvo.setUserPhone(userphone);
				uvo.setUserMileage(5000);
				udao.insertUser(uvo);
				System.out.println(" 회원 가입 기념으로 5000마일리지를 적립해 드립니다.");
				System.out.println(" 회원가입이 완료되었습니다.");
				if(typeInt == 1) {
					System.out.println(" 메인 화면으로 이동합니다.\n\n");
					isFinished = true;
					break;
					
				}else if(typeInt == 2) {
					CompanyService csv = new CompanyService();
					try {
						
						System.out.println(" 회사 정보를 등록하는 창으로 이동합니다.");
						Thread.sleep(1500);
						csv.createCompanyInfos(userId);
						isFinished = true;
						break;
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					isFinished = true;
					}else {
						
					}
				}else {
					System.out.println(" 이미 사용중인 아이디입니다.");
				}
			}else {
				System.out.println(" 5~15자리의 영문소문자,숫자만 사용 가능합니다.(특수문자 사용불가)");
			}
		}while(!isFinished);
		
		
	}

	private String createUserName() {
		boolean isFinished = false;
		String userName = null;
		do {
			System.out.println("\n 사용자 이름을 입력해 주세요 \n");
			System.out.print("이름 : ");
			userName = scan.nextLine();
			chkPattern(userName,3);
			
			if(chkPattern(userName,3)==true){
				System.out.println("입력 완료\n");
				isFinished = true;
				return userName;
			}
			else{
				System.out.println("한글만 사용가능합니다.");
				userName = null;
			}
		}while(!isFinished);
		return userName;
	}
	private String createUserPass() {
		boolean isFinished = false;
		String userPass = null;
		do {
			System.out.println("\n 사용하실 비밀번호를 입력해 주세요 \n");
			System.out.print("비밀번호 : ");
			userPass = scan.nextLine();
			System.out.print("비밀번호 확인 : ");
			String correct = scan.nextLine();
			
			chkPattern(userPass,2);
			if(chkPattern(userPass,2)==true&&
					userPass.equals(correct)){
				System.out.println("입력 완료\n");
				isFinished = true;
				return userPass;
			}
			else{
				System.out.println("10~20자리의 영문 대소문자와 숫자, 특수기호 1개이상만 사용 가능합니다.");
				userPass = null;
			}
			
		}while(!isFinished);
		
		return userPass;
	}
	private String createUserPhone() {
		String userPhone = null;
	do {
		System.out.println("\n 사용하시는 전화번호를 입력해 주세요 \n");
		System.out.print("전화번호 : ");
		userPhone = scan.nextLine();
		chkPattern(userPhone,4);
		if(chkPattern(userPhone,4)==true){
			userPhone = userPhone.replace("-", "");
			System.out.println("인증 완료\n");
			return userPhone;
		}else{
			System.out.println("올바른 형식의 번호가 아닙니다.");
			userPhone = null;
		}
		}while(userPhone == null);
	return userPhone;
	}
	public void logIn(){
		//아이디,비밀번호 입력
		System.out.println("〓〓〓〓〓〓〓   로그인   〓〓〓〓〓〓〓");
		System.out.print("아이디 : ");
		String userId = scan.nextLine();
		System.out.print("비밀번호 : ");
		String userPass = scan.nextLine();
		
		if(userId.equals("master")&& userPass.equals("master")){
			session.loginUserId = "master";
			session.loginUserPass = "master";
			session.loginUserType = 3;
			System.out.println("\n※당신은 관리자 계정으로 접근하셨습니다※");
            System.out.println("※데이터 관리에 유의하시기 바랍니다※\n");
            return;
		}
		
		
		
		UserVo user = new UserVo();
		user.setUserId(userId);
		user.setUserPass(userPass);
		UserDao udao = new UserDao();
		boolean userLoginChecked = udao.checkLoginuser(userId,userPass);
		
		if(userLoginChecked == false){			
			System.out.println("아이디 혹은 비밀번호를 잘못 입력하셨습니다.\n");
		}
		else{
			System.out.println("\n로그인 성공!!");
			//패스워드 확인 로직 구현
			System.out.println(userId+"님 환영합니다 :)\n");
			// UserList 에서 똑같은 아이디와 패스워드를 가진 인덱스 를 가져와서 세팅
			for(int i = 0; i< udao.checkUserList().size(); i++){
				if(userId.equals(udao.checkUserList().get(i).getUserId())
						&&userPass.equals(udao.checkUserList().get(i).getUserPass())){
					session.loginUserId = userId;
					session.loginUserPass = userPass;
					session.loginUserType = udao.checkUserList().get(i).getUserType();
					
				}
			}
		}
	}
	
	//로그아웃
	public void logOut() {
		
		session.loginUserId = "guest";
		session.loginUserPass = "guest123!";
		session.loginUserType=0;
		System.out.println("로그아웃이 완료되었습니다.");
		System.out.println("\n 메인화면으로 이동합니다.");
		startingThread();
	}
	
	public void chkMileage() {
		UserDao udao = new UserDao();
		String userId = session.loginUserId;
		int mileage = udao.showUserMileage(userId);
		System.out.println("보유하신 마일리지는 "+ mileage + " 입니다.");
		System.out.println(" 뒤로 가시려면 아무키나 입력해주세요.");
		String str= scan.nextLine();
		System.out.println("메인화면으로 이동합니다.");
		startingThread();
	}
	void startingThread() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void showUserRentList(){
		UserDao udao = new UserDao();
		
		ArrayList<UserRentVo> rented = udao.userRentList(session.loginUserId);
		System.out.println("순서 \t 차량번호 \t\t 대여일 \t\t 반납일\t\t실반납일");
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
		for(int i = 0; i< rented.size(); i++) {
			System.out.print(i+1+ " \t" + rented.get(i).getRentVNum() + " \t" + rented.get(i).getRentDate()
					+" \t"+rented.get(i).getReturnDate());
			if(rented.get(i).getActualReturnDate().equals("")) {
				System.out.println(" \t반납예정");
			}else {
				System.out.println(" \t"+rented.get(i).getActualReturnDate());
			}
			
		}
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
		System.out.println("뒤로가시려면 아무거나 입력해 주세요.");
		String str = scan.nextLine();
		
	}
}
