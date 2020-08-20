package e_oop;

public class AirConditioner {
	
	boolean power; //전원
	int temperature; //온도
	int airVolume; //풍량
	
	AirConditioner(){
		power = false;
		temperature = 24;
		airVolume = 1;
	}
	
	void power(){
		power = !power;
	}
	
	void temperatureUp(){
		if(power){
			if(temperature < 30){
				temperature++;
			}
		}
	}
	
	void temperatureDown(){
		if(power && 18 < temperature){
			temperature--;
		}
	}
	
	void airVolume(){
		if(power && 3 < ++airVolume){
			airVolume = 1;
		}
	}
	
	//온도가 18 ~ 30 까지만 변경할 수 있게 해주시고,
	//전원을 켰을때만 버튼들이 작동되도록 메서드들을 변경해주세요.
	
	public static void main(String[] args) {
		AirConditioner ac = new AirConditioner();
		
		ac.power();
		System.out.println("power : " + ac.power);
		
		ac.temperatureUp();
		System.out.println("temperature : " + ac.temperature);
		
		ac.temperatureDown();
		System.out.println("temperature : " + ac.temperature);
		
		ac.airVolume();
		System.out.println("airVolume : " + ac.airVolume);
	}
	
}















