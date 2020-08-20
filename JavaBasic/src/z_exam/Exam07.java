package z_exam;

public class Exam07 {

	public static void main(String[] args) {
		MyTv2 t = new MyTv2();
		t.setChannel(10);
		System.out.println("CH:"+t.getChannel());
		t.setChannel(20);
		System.out.println("CH:"+t.getChannel());
		t.gotoPrevChannel();
		System.out.println("CH:"+t.getChannel());
		t.gotoPrevChannel();
		System.out.println("CH:"+t.getChannel());
	}

}

class MyTv2 {
	boolean isPowerOn;
	int channel;
	int volume;
	int temp;

	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;
	final int MAX_CHANNEL = 100;
	final int MIN_CHANNEL = 1;
	
	
	public boolean isPowerOn() {
		return isPowerOn;
	}
	public void setPowerOn(boolean isPowerOn) {
		this.isPowerOn = isPowerOn;
	}
	public int getChannel() {
		return channel;
	}
	public void setChannel(int channel) {
		if(channel <= MAX_CHANNEL && channel >= MIN_CHANNEL){
			temp = this.channel;
			this.channel = channel;
		}
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public void gotoPrevChannel(){
		setChannel(temp);
	}
	/*
	[7-11] 문제7-10에서 작성한 MyTv2클래스에 이전 채널(previous channel)로 이동하는
	기능의 메서드를 추가해서 실행결과와 같은 결과를 얻도록 하시오.
	[Hint] 이전 채널의 값을 저장할 멤버변수를 정의하라.
	메서드명 : gotoPrevChannel
	기 능 : 현재 채널을 이전 채널로 변경한다.
	반환타입 : 없음
	매개변수 : 없음
	*/
	
}
/*
[7-17] 아래 세 개의 클래스로부터 공통부분을 뽑아서 Unit이라는 클래스를 만들고, 이
클래스를 상속받도록 코드를 변경하시오.
*/
class Unit{
	int x, y;
	void move(int x, int y){}
	void stop() { /* 현재 위치에 정지 */ }
}
class Marine extends Unit { // 보병
	void stimPack() { /* 스팀팩을 사용한다.*/}
}
class Tank extends Unit { // 탱크
	void changeMode() { /* 공격모드를 변환한다. */}
}
class Dropship extends Unit { // 수송선
	void load() { /* 선택된 대상을 태운다.*/ }
	void unload() { /* 선택된 대상을 내린다.*/ }
}








