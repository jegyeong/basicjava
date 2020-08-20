
package game;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import vo.MileageVo;
import vo.UserVo;
import dao.MileageDao;

import data.Session;

public class YouCanDo {
	private static YouCanDo instance;
	private YouCanDo() {
    	
    	
	}

	public static YouCanDo getInstance() {
		if (instance == null) {
			instance = new YouCanDo();
		}
		return instance;

	}

	int ranDom1=0;
	int countPoint=0;
	int countM=0;
	int coin=0;
	int check=0;
	int mileage=0;
	int tMileage=0;
	Scanner sc = new Scanner(System.in);
	
	Random oRandom = new Random();

	public void start1(){
		String[] stepOne = {"abc","bdc","cbb","dff","fff"};
		int ranDom1 = oRandom.nextInt(stepOne.length);	    

		System.out.println("======야! 너두! 영타 200 할수있어!!!=======");
		try {
			Thread.sleep(700);      //딜레이 0.7초
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("출력된 영어를 입력하시오!!!");
		try {
			Thread.sleep(700);      //딜레이 0.7초
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.print("3..");
		
		try {
			Thread.sleep(700);      //딜레이 0.7초
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.print("2..");
		try {
			Thread.sleep(700);      //딜레이 0.7초
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.print("1..");
		try {
			Thread.sleep(700);      //딜레이 0.7초
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("======GameStrat!!======");
		
	
		
		
		  
		Boolean check = false;	
		do{
			
		System.out.println("Lv.1 문제 : "+stepOne[ranDom1]);
		System.out.println("위의 문제를 입력하시오.");
		String answer= sc.nextLine();
		if(answer.equals(stepOne[ranDom1])){
	
			System.out.println("정답입니다!!");
			
			start2();
			check = !check;
		}
		else if(!answer.equals(stepOne[ranDom1])) {
			--countPoint;
			
			System.out.println("틀렸습니다 ㅠㅠ");
		}
		
		}while(!check);
		 
		System.out.println("======게임이 종료 되었습니다.======");
		return;
	}
		
		void start2(){
			String[] stepOne = {"Drinking"
							   ,"chicken"
							   ,"Beer"
							   ,"Pizza Hut"
							   ,"hamburger"};
			int ranDom1 = oRandom.nextInt(stepOne.length);
			System.out.println("======야! 너두! 영타 200 할수있어!!!======");
			try {
				Thread.sleep(700);      //딜레이 0.7초
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("출력된 영어를 입력하시오!!!");
			try {
				Thread.sleep(700);      //딜레이 0.7초
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print("3...");
			try {
				Thread.sleep(700);      //딜레이 0.7초
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print("2,,,");
			try {
				Thread.sleep(700);      //딜레이 0.7초
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print("1,,,");
			try {
				Thread.sleep(700);      //딜레이 0.7초
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("======GameStart!!!======");
			   Boolean check = false; 

			do{
				
				System.out.println("Lv.2 문제 : "+stepOne[ranDom1]);
				System.out.println("위의 문제를 입력하시오.");
				String answer= sc.nextLine();
				if(answer.equals(stepOne[ranDom1])){
					
					System.out.println("정답입니다!!");
					start3();
					check = !check;
				}else if(!answer.equals(stepOne[ranDom1])){
					--countPoint;

					System.out.println("틀렸습니다 ㅠㅠ");
				}
				}while(!check);
		}
		
		
		void start3(){
			String[] stepOne = {"I want to eat chicken"
							   ,"I want to exercise"
							   ,"I want to go home"
							   ,"I want to sleep"
							   ,"I want to play a game"};
			int ranDom1 = oRandom.nextInt(stepOne.length);
			System.out.println("======야! 너두! 영타 200 할수있어!!!======");
			try {
				Thread.sleep(700);      //딜레이 0.7초
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("출력된 영어를 입력하시오!!!");
			try {
				Thread.sleep(700);      //딜레이 0.7초
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print("3...");
			try {
				Thread.sleep(700);      //딜레이 0.7초
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print("2,,,");
			try {
				Thread.sleep(700);      //딜레이 0.7초
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print("1,,,");
			try {
				Thread.sleep(700);      //딜레이 0.7초
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("======GameStart!!!======");
			   Boolean check = false; 

			do{
				
				System.out.println("Lv.3 문제 : "+stepOne[ranDom1]);
				System.out.println("위의 문제를 입력하시오.");
				String answer= sc.nextLine();
				if(answer.equals(stepOne[ranDom1])){
					
					System.out.println("정답입니다!!");
					start4();
					check = !check ;
				}else if(!answer.equals(stepOne[ranDom1])){
					--countPoint;
					System.out.println("틀렸습니다 ㅠㅠ");
				}
				}while(!check);
		}
	


	void start4() {
		
		MileageDao mileagedao = MileageDao.getInstance();
		UserVo user = Session.loginUser;
		String userKey = user.getId();
		MileageVo mileageInfo = new MileageVo();

		Date date = new Date();

		countM = 15;
		mileage = countM + countPoint;
		mileageInfo.setId(Session.loginUser.getId());
		mileageInfo.setDate(date);// 게임 종료 시간 입력
		mileageInfo.setId(userKey);// 유저 아이디
		mileageInfo.setMiliage(mileage);// 획득마일리지
		mileageInfo.setContents("영타200 달성^^");
		mileagedao.insertMileage(mileageInfo); // 마일리지 정보 넣어주기

		System.out.println("---------------------------------------");
		System.out.println("획득 마일리지 : " + mileage);
		System.out.println("---------------------------------------");
	}
















}
