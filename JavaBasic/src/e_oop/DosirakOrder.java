package e_oop;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;



//기능1. 시스템 날짜 (Sysdate)에서 오늘의 일(Date) 값을 가져와, 날짜 = 당번에 매칭되는 학생을 반환
//기능2. 도시락 개당 3500=>10개당1개값 할인 (21명이므로 최대 20개)
//도시락 값 *인원수 그리고 걷은 돈에서 -하여 필요한 돈, 거스름돈 출력


public class DosirakOrder {
	static TestToday td = new TestToday();
	String[] students = {"","남아름", "박기완", "박선정", "박정민", "박혜진", "송효진", "심주영", "연지은", "이제경", "이혁진", "임수진", "전다희","정영수", "정주환", "홍종욱"
							, "강현철", "김우경", "김종완", "김준우", "김철희", "김태유"};					//1달마다 관리자가 당번에 맞게 배열 값만 수정하여 갱신
	
	
	public static void main(String[] args) {
		
		
		DosirakOrder dso = new DosirakOrder();	 // 도시락 오더 매소드 생성
		int money = 0;                           // 걷은 돈 변수
		int count = 0;                           // 도시락 시키는 사람 수 변수
		int overDay = 0;                         // 더 코딩을 이해하여 프로그램을 확장시킨다면, 이번 달에 당번을 다음달에도 유지시키기 위해 생성해둔 변수 
	
			
		if(td.monthday()%dso.students.length >= 1 && td.monthday()%dso.students.length<=dso.students.length && overDay ==0 ){               //오늘의 당번 찾아내기
				System.out.println(dso.students[td.monthday()] + " 학생이 돈을 걷어야합니다.\n");				                                    //날짜가져오는 클래스에서 날짜와 문자열의 학생 매칭
			}else{
				System.out.println(dso.students[td.monthday() - dso.students.length] + " 학생이 돈을 걷어야합니다.");                               //예)21명의 학생이 넘어가는 22일부터 
				overDay = td.monthday() - dso.students.length;                                                                              // 22번째 학생은 (오늘의 날짜 - 전체 학생수)의 인덱스에 해당하는 학생 
			}                                                                                                                               //달력은 1일 부터 시작하기 때문에 배열 첫 인덱스 0은 ""로 처리,,
		
		
		Scanner c = new Scanner(System.in);
		
		System.out.println("오늘 도시락 시키는 사람 수를 입력해주세요.>");
		count = Integer.parseInt(c.nextLine());	
		
		if (calculator(count)==0){                                                              //3. 계산 객체에서 0을 리턴받았을때 출력문으로 예외처리 -> 이후 강제 프로그램 종료
			System.out.println("반 인원에 맞지않는 잘못 입력된 값입니다. 프로그램을 재실행해주세요.");
			System.exit(0);
		}else{
			System.out.println(calculator(count) + " 원을 지불해야 합니다.\n");                         //4. 정상적인 값 입력시 지불해야 할 돈 출력
		}
		
		System.out.println("걷은 돈을 입력해주세요.>");                                                  //5. 메인함수의 마지막 부분 걷은 돈으로 거스름돈 구하는 부분
		money = Integer.parseInt(c.nextLine());	                                                
		
		if(calculator(count) < money){                                                           //6. 걷은돈(money)에서 계산 객체에서 리턴받은 인트값을빼서 거스름돈으로 출력 
			System.out.println("거스름돈은" + (money-calculator(count)) + " 원 입니다.\n");
		}
		else if(calculator(count) > money){                       
			System.out.println("돈을 부족하게 걷었습니다. 확인하고 다시 걷어주세요");
		}
	}
		
		static int calculator(int count){                                                        //1.계산하는 클래스 int count(도시락 시키는 사람수)를 받아와 조건에 따라 int값을 반환
			
			DosirakOrder dso = new DosirakOrder();
			int decicount = count / 10 ;
			
			if(count < dso.students.length && decicount ==0){
				return count*3500;
			}
			else if(count < dso.students.length && decicount !=0 ){
				return (count-decicount)*3500;				
			}else{
				return 0;                                                                      // 2.decimal은 10번째마다 학생수 / 10의 몫으로 카운팅되는 변수이며 사용자가 학생수보다 더 많이 인원을 입력했을경우 0반환
			}
		}
	
		
	public static class TestToday{

		int extractday;

		int monthday(){
		     
	      SimpleDateFormat stoday = new SimpleDateFormat("dd");

	      Calendar c1 = Calendar.getInstance();
		
		 String strDay = stoday.format(c1.getTime());
		 
		 extractday = Integer.parseInt(strDay);                                              // 0. strDay 값을 int값으로 extractday에 입력

	         
	        return extractday;

	    }
		
	}
		
}

