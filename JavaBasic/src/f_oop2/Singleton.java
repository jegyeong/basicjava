package f_oop2;

//싱글톤 패턴 : 객체의 생성을 제한하여 하나의 객체만 사용하게 하는 디자인 패턴
//객체들간에 객체를 공유하기 위해 사용한다.
public final class Singleton {

	private static Singleton instance;
	
	private Singleton(){
		
	}
	
	public static Singleton getInstance(){
		if(instance == null){
			instance = new Singleton();
		}
		return instance;
	}
	
}







