package e_oop;

import java.util.Scanner;

public class TV {
	
	/*
	 * 기능에 해당하는 번호를 입력해주세요>
	 * 1. 전원
	 * 2. 채널+
	 * 3. 채널-
	 * 4. 음량+
	 * 5. 음량-
	 * 0. 종료
	 */
	
	public static void main(String[] args) {
		TV tv = new TV();
		Scanner s = new Scanner(System.in);
		int input = 0;
		do{
			System.out.println("기능에 해당하는 번호를 입력해주세요>");
			System.out.println("1. 전원");
			System.out.println("2. 채널+");
			System.out.println("3. 채널-");
			System.out.println("4. 음량+");
			System.out.println("5. 음량-");
			System.out.println("0. 종료");
			
			input = Integer.parseInt(s.nextLine());
			
			switch(input){
				case 1 : tv.power(); break;
				case 2 : tv.channelUp(); break;
				case 3 : tv.channelDown(); break;
				case 4 : tv.volumeUp(); break;
				case 5 : tv.volumeDown(); break;
				case 0 : System.out.println("종료되었습니다."); break;
			}
		}while(input != 0);
	}

	boolean power;
	int channel;
	int volume;
	
	final int MIN_CHANNEL = 1;
	final int MAX_CHANNEL = 100;
	final int MIN_VOLUME = 0;
	final int MAX_VOLUME = 10;
	
	TV(){
		power = false;
		channel = 1;
		volume = 5;
	}
	
	void power(){
		power = !power;
		System.out.println(power ? "TV 켜짐" : "TV 꺼짐");
	}
	
	void changeChannel(int channel){
		if(power){
			if(MIN_CHANNEL <= channel && channel <= MAX_CHANNEL){
				this.channel = channel;
			}
			System.out.println("채널. " + this.channel);
		}
	}
	
	void channelUp(){
		changeChannel(channel + 1);
	}
	
	void channelDown(){
		changeChannel(channel - 1);
	}
	
	void volumeUp(){
		if(power){
			if(volume < MAX_VOLUME){
				volume++;
			}
			showVolume(volume);
		}
	}
	
	void volumeDown(){
		if(power){
			if(MIN_VOLUME < volume){
				volume--;
			}
			showVolume(volume);
		}
	}
	
	void showVolume(int volume){
		System.out.print("음량. ");
		for(int i = MIN_VOLUME + 1; i <= MAX_VOLUME; i++){
			if(i <= volume){
				System.out.print("■");
			}else{
				System.out.print("□");
			}
		}
		System.out.println();
	}
	
	
}








//발표 : 프로그램 주제, 기능, 메서드 구성, 시연












