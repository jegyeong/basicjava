package service;

import java.util.ArrayList;
import java.util.Scanner;

import vo.UserVO;
import dao.UserDao;
import data.Session;

public class UserService {
	
	private static UserService instance;
	
	private UserService(){}
	
	public static UserService getInstance(){
		if(instance == null){
			instance = new UserService();
		}
		return instance;
	}

	Scanner s = new Scanner(System.in);
	
	private UserDao userDao = UserDao.getInstance();
	
	//회원가입
	public void join(){
		UserVO user = new UserVO();
		
		//사용자 정보 입력
		System.out.print("아이디 : ");
		String id = s.nextLine();
		
		user.setId(id);
		
		//아이디 중복 검사
		UserVO userCheck = userDao.selectUser(user);
		
		//없으면 회원가입
		if(userCheck == null){
			System.out.print("비밀번호 : ");
			String password = s.nextLine();
			System.out.print("이름 : ");
			String name = s.nextLine();
			
			user.setPassword(password);
			user.setName(name);
			
			userDao.insertUser(user);
			System.out.println("가입해주셔서 감사합니다.");
		}else{
			//있으면 아이디 중복
			System.out.println("아이디 중복");
		}
	}
	
	//로그인
	public void login(){
		//아이디, 비밀번호를 입력
		System.out.print("아이디 : ");
		String id = s.nextLine();
		System.out.print("비밀번호 : ");
		String password = s.nextLine();
		
		UserVO user = new UserVO();
		user.setId(id);
		user.setPassword(password);
		
		UserVO userCheck = userDao.selectUser(user);
		
		//없으면 로그인 실패
		if(userCheck == null){
			System.out.println("아이디 혹은 비밀번호를 잘못 입력하셨습니다.");
		}else{
			//있으면 로그인
			System.out.println("로그인 성공!!");
			System.out.println(userCheck.getName() + "님 환영합니다.");
			Session.loginUser = userCheck;
		}
	}
	
	//회원목록
	public void userList(){
		//회원 전체 조회
		ArrayList<UserVO> userList = userDao.selectUserList();
		
		//출력
		System.out.println("----------------------------");
		System.out.println("번호\t아이디\t이름");
		System.out.println("----------------------------");
		for(int i = 0; i < userList.size(); i++){
			UserVO user = userList.get(i);
			System.out.println(i + 1 + "\t" + user.getId() + "\t" + user.getName());
		}
		System.out.println("----------------------------");
	}
	
}








