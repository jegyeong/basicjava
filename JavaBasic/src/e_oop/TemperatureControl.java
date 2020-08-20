package e_oop;

import java.util.Scanner;

public class TemperatureControl {
	
	//찜질방 온도 조절
	
	boolean water;
	static int temperature;  //36~38 적절온도
	static int complain;
	
//	int clean;
//	int countTime;

	
	TemperatureControl(){
		water = false;
		temperature = (int)(Math.random()*5)+22;  //22~27도 사이값 랜덤추출
		complain = 0;
	}
	
	void water(){
		water = !water;
		if(water){
			System.out.println("온천탕 물이 채워졌습니다.");
		}else{
			System.out.println("온천탕에 물이 없습니다. 물을 채워주세요");
		}
	}
	
	void temperatureUp(){
		if(water){
			int num = (int)(Math.random()*12)+1;  //1~12사이
			temperature += num;
			if(temperature<36 || temperature>38){
				complain++; //complain();
			}else if(temperature >= 36 && temperature <= 38){  //적정 온도 도달
				System.out.println("물 온도가 아주 적절합니다! 우수직원 칭찬카드가 +1 되셨습니다.");
				System.out.println("물온도가 24도로 낮아졌습니다. 다시 온도를 맞추시겠습니까?");
//				System.exit(0);  //메소드 내에서 프로그램 종료함수
			}
		}else{
			System.out.println("물을 먼저 채워주세요!");
		}
	}
	
	void temperatureDown(){
		if(water){
			int num = (int)(Math.random()*12)+1;  //1~12사이
			temperature -= num;
			
			if(temperature<36 || temperature>38){
				complain++; //complain();
			}
		}else{
			System.out.println("물을 먼저 채워주세요!");
		}
	}
	
	
	
	public static void main(String[] args) {
		
		TemperatureControl tc = new TemperatureControl();
		System.out.println("당신은 온천탕 직원입니다. 물 온도를 적절하게 맞춰주세요(36~38도 사이).");
		System.out.println("5번안에 온도를 적절하게 맞추지 못하면 당신은 해고됩니다.");
		
		//현재 온도 나타냄
		System.out.println("현재 물온도: " + temperature);
		
/*		System.out.println("1.물채우기 또는 물비우기 \n2.온도+ \n3. 온도- \n0.종료");
		System.out.println("------------------------------------------------------");*/
		
		int praise=0;  //우수 직원 칭찬 카드
		
		do{
			Scanner sc = new Scanner(System.in);
			if(temperature >= 36 && temperature <= 38){
				tc.temperatureUp();
				String input2 = sc.nextLine();
				if(input2.equals("y")){
					praise++;
					temperature = 24;
					continue;
				}else if(input2.equals("n")){
					break;
				}
			}
			
			System.out.println("1.물채우기 또는 물비우기 \n2.온도+ \n3.온도- \n0.종료");
			int input = Integer.parseInt(sc.nextLine());
			switch(input){
				case 1: 
					tc.water(); 
					break;
				case 2: 
					tc.temperatureUp();
					System.out.println("현재 물온도: " + temperature + ", 컴플레인 횟수: " + complain + ", 우수직원 칭찬카드: "+praise);
					break;
				case 3:
					tc.temperatureDown();
					System.out.println("현재 물온도: " + temperature + ", 컴플레인 횟수: " + complain+", 우수직원 칭찬카드: "+praise);
					break;
				case 0: 
					System.out.println("프로그램이 종료되었습니다."); 
					break;
			}
			if(complain>=5){
				System.out.println("손님들에게 컴플레인을 총 5번 받으셨습니다. 당신은 해고되셨습니다.");
				break;
			}
		}while(true);
		
		
	}
	
}





