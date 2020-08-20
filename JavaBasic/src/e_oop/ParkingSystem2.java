package e_oop;

import java.util.Arrays;
import java.util.Scanner;

public class ParkingSystem2 {

	/*
	 * 주차요금 정산기 
	 * 
	 * */
	String myCarNum;
	String[] parkArea = new String[4];
	int myCarPosition = 0;
	int count = 0;
	static Scanner scan = new Scanner(System.in);
	static ParkingSystem2 ps = new ParkingSystem2();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			while(true){
				ps.init();	
			}
	}
	//메뉴 보여주기
	
	private void init(){
		if(count ==4){
			System.out.println("만차입니다. 출차만 가능합니다");
			System.out.println("-----------------");
			System.out.println("2. 출차하기");
		}else{
			System.out.println("다음을 선택해 주십시요.");
			System.out.println("-----------------");
			System.out.println("1. 주차하기");
			System.out.println("2. 출차하기");
			
		}
		
		System.out.println("-----------------");
		
		
		int a = Integer.parseInt(scan.nextLine());
		
		selectNum(a);
			
	}
	
	//선택시 로직
	private void selectNum(int a){
		
		switch (a) {
		case 1:
			//주차하기
			if(count == 4){
				System.out.println("만차입니다 다시 선택해 주세요");
			}else{
				inParking();
			}
			
			break;
		case 2:
			//출차하기
			outParking();
			break;
		case 3:
			//카드계산
			break;
		case 4:
			//현금계산
			break;
		case 0:
			System.exit(0);
			break;
		default:
			break;
		}
	}
	
	private void inParking(){
		boolean finish = false;
		
		do{
			for(int i = 0; i<parkArea.length; i++){
				System.out.println(parkArea[i]);
			}
			
			System.out.println("차번호를 입력하여 주십시오");
			String txt = scan.nextLine();
			if(txt.length()==7 || txt.length() == 8){
			
				for(int i = 0; i < parkArea.length; i++){
					if(txt == parkArea[i]){
						System.out.println("이미 있는 차입니다.다시 입력해 주세요.");
						finish = true;
					}else{
						if(parkArea[i] == null){
							parkArea[i] = txt;
							count++;
							finish = true;
							break;
					}else{
						
						}
					}
						
				}
				
			}
			
		}while (finish == false);
	}
	private void outParking(){
			boolean finish = false;
			
			/*배열에서 이 차번호가 있는지 확인하고 있을경우 selectPay로 이동
			 * 없을시에 없다는 경고 문구 표시후 다시 차번호 입력으로 이동
			 * */
			do{
				
			System.out.println("차번호를 입력하여 주십시요.");
			String getText = new String();
			
			getText = scan.nextLine();
		
			myCarNum = getText;
			boolean b = Arrays.asList(ps.parkArea).contains(getText);
	        if(b==true){
	        	for(int i = 0; i <ps.parkArea.length; i++){
					if(getText.equals(ps.parkArea[i])){
						
							ps.myCarPosition = i;
							
							System.out.println("차는 지금 " + ps.myCarPosition + "번째 공간에 있습니다.");
							ps.selectPay();
							finish = true;
							break;
						}else{
							
						}
					}
						
	        }else{
	        	System.out.println("없는 차번호 입니다. 다시 입력해 주세요.");
	        	break;
	        }
		}while(finish == false);
	}
	private void selectPay(){
		boolean finish = false;
		do{
			System.out.println("-----------------");
			System.out.println("정산방법을 선택해 주세요.");
			System.out.println(" 1 : 현금 계산");
			System.out.println(" 2 : 카드 계산" );
			String getText = scan.nextLine();
			
			switch (getText) {
			case "1":
				System.out.println("현금계산을 택하셨습니다.");
				ps.selectCash();
				finish = true;
				
				break;
			case "2":
				ps.selectCredit();
				System.out.println("카드계산을 택하셨습니다.");
				finish = true;
				break;
			default:
				System.out.println("잘못 선택 하셨습니다.");
				break;
			}
		}while(finish == false);
	}
	void selectCash(){
		System.out.println("현금결제 창 입니다.");
		/* 1. 현금일 경우 selectCash로 이동 받는 금액이 얼마인지와 내야할 금액이 얼마인지를 비교후 잔액을 표시한 후 출차 완료 표시(finishPay)
		 * 1-1. 만약 내야하는 금액보다 입력한 금액이 작을경우 금액이 잘 못 됐다는 문구 표현 및 모자라는 금액 출력.
		 * 
		 */
		int a = 3000;
		int b = 0;
		System.out.println("결제 비용은 "+ a + "원 입니다.");
		System.out.println(a + "원을 넣어 주십시요.");
		String getText = new String();
		getText = scan.nextLine();
		b = Integer.parseInt(getText);
		if(b == a){
			ps.finishPay();
		}else if(b > a){
			int c = b - a;
			System.out.println("거스름돈은"+ c + "원 입니다.");
			ps.finishPay();
		}else if(b < a){
			int d = a-b;
			System.out.println("잔액이" + d + "원 모자랍니다.");
			System.out.println(d + "원을 추가로 넣어주세요.");
			scan = new Scanner(System.in);
			getText = scan.nextLine();
			int e = Integer.parseInt(getText);
			ps.changeCash(d, e);
		}
		
		
		
	}
	void changeCash(int a, int b){
		int change = a;
		
		if(change == b){
			
			ps.finishPay();

		}else{
			int c = change-b;
			change = c;
			int d;
			System.out.println(c + "원이 모자랍니다.\n 추가요금을 넣어주세요.");
			String getText = new String();
			Scanner scan = new Scanner(System.in);
			
			getText = scan.nextLine();
			b = Integer.parseInt(getText);
			
		}
	}
	void selectCredit(){
		boolean finish = false;
		do{
			System.out.println("카드결제 창입니다.");
			/* 2. 카드 일 경으 selectCredit 으로 이동 후 카드번호  16 자리 와 유효기간을 입력하게 한후 마지막으로 cvc 번호를 입력하는 구문출력.
			 * 2-1. 만약 카드번호를 잘못 입력하거나 숫자열이 아닐경우 잘못된 정보라는 문구와 함께 다시 카드번호를 입력하는 구문 출력
			 * 2-2. 만약 유효하지 않은 카드 번호일경우 유효하지 않는 번호라는 문구와 함께 다시 카드번호 입력하는 구문 출력
			 * 2-3. 모든게 정상적으로 진행 되었을때 finishPay로 이동.
			 * 
			 * 3. 특정 카드 번호를 미리 지정해놓고 그 카드번호가 입력 되었을때가 정상으로 처리되는 것으로 가정해놓는다.
			 *  ex) 1234 1234 1234 1234 12/23 123
			 */
			int a = 3000;
			int b = 0;
			System.out.println("결제 비용은 "+ a + "원 입니다.");
			System.out.println("카드번호를 적어 주십시요.");
			String getText = new String();
			Scanner scan = new Scanner(System.in);
			
			getText = scan.nextLine();
			
			if(getText.length()==16){
				ps.finishPay();
				finish = true;
			}else{
				System.out.println("카드번호가 잘못 되었습니다. \n 다시 입력하여 주십시요.");
				ps.selectCredit();
				finish = true;
			}
		}while(finish == false);
	}
	
	
	
	void finishPay(){
		
		
		System.out.println("차량번호 " + ps.myCarNum + "의 주차요금이 정상 처리되었습니다 \n 안녕히 가십시요.");
		
		boolean b = Arrays.asList(ps.parkArea).contains(ps.myCarNum);
        if(b==true){
        	ps.parkArea[ps.myCarPosition] = null;
        }else{
        	System.out.println("찾지 못하였습니다");
        	ps.outParking();
        }
        ps.myCarNum = "";
        ps.myCarPosition = 0;
		
	}
}

