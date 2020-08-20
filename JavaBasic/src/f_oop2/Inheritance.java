package f_oop2;

public class Inheritance {
	
	public static void main(String[] args) {
		/*
		 * << 상속 >>
		 * - 기존의 클래스를 물려받아 새로운 클래스를 만드는 것이다.
		 * - 자식클래스명 extends 부모클래스명 {}
		 * - 부모 클래스의 생성자와 초기화블럭을 제외한 모든 멤버를 물려받는다.
		 * - 하나의 클래스만 상속받을 수 있다.
		 * - 상속받지 않는 모든 클래스는 Object 클래스를 상속받는다.
		 * - 자식 클래스는 부모 클래스의 멤버 외의 새로운 멤버를 가질 수 있으므로
		 * 	 자식 클래스는 부모 클래스보다 크거나 같다.
		 * - 두개 이상의 클래스를 만드는데 공통된 멤버가 있는 경우 부모클래스로 만든다.
		 * 
		 * << super >>
		 * - 부모 클래스의 인스턴스 주소가 저장된 변수이다.
		 * - 부모 클래스의 멤버와 자식 클래스의 멤버의 이름이 중복될때 둘을 구분하기 위해 사용한다.
		 * 
		 * << super() >>
		 * - 생성자에서 부모 클래스의 생성자를 호출하기 위해 사용하낟.
		 * - 자식 클래스 생성자의 첫줄에 super()가 있어야 한다.
		 * - 없으면 컴파일러가 자동으로 추가한다.
		 * 
		 * << 오버라이딩 >>
		 * - 상속받은 메서드의 내용을 재정의하는 것이다.
		 * - 상속받은 메서드와 리턴타입, 메서드명, 파라미터가 같아야 한다.
		 * - 상속받은 메서드보다 좁은 범위의 접근제어자로 변경 할 수 없다.
		 * - 상속받은 메서드보다 많은 예외를 선언할 수 없다.
		 * - static을 빼거나 더할 수 없다.
		 * 
		 * << 다형성 >>
		 * - 상속으로 인해 여러가지 형태를 가지게 되는 특징을 말한다.
		 * - 부모타입으로 생성된 객체는 부모타입에 정의된 멤버만 사용 가능하다.
		 * - 부모타입과 자식타입은 서로 형변환이 가능하다.
		 * - 자식타입 > 부모타입 : Up-casting(생략가능)
		 * - 부모타입 > 자식타입 : Down-casting(생략불가)
		 * - 부모와 자식에 동일한 메서드가 있는 경우 자식의 메서드를 사용한다.
		 * - 부모와 자식에 동일한 멤버변수가 있는 경우 부모타입에서는 부모의 변수를
		 *   자식타입에서는 자식의 변수를 사용한다.
		 * 
		 * << 접근제어자 >>
		 * - 외부로부터 데이터를 보호하거나 감추기 위해 사용한다.
		 * - public : 접근에 제한이 없다.
		 * - protected : 같은 패키지, 그리고 상속받은 클래스에서 접근이 가능하다.
		 * - default : 같은 패키지에서만 접근이 가능하다.
		 * - private : 클래스 내에서만 접근이 가능하다.
		 * 
		 * << Singleton(싱글톤 패턴) >>
		 * - 객체 생성을 제한하여 하나의 객체만 사용하게 하는 디자인 패턴이다.
		 * - 객체들간에 객체를 공유하기 위해 사용한다.
		 */
		
		AccessModifier am = new AccessModifier();
		
		System.out.println(am.publicVar);
		am.publicMethod();
		
		System.out.println(am.protectedVar);
		am.protectedMethod();
		
		System.out.println(am.defaultVar);
		am.defaultMethod();
		
//		System.out.println(am.privateVar);
		
		Time t = new Time();
//		t.setHour(100000);
//		t.setMinute(100000);
		t.setSecond(100000);
		
		System.out.println(t); //3:46:40
		
		Singleton s = Singleton.getInstance();
		
		System.out.println(new Inheritance());
		System.out.println(new Inheritance());
		
		System.out.println(Singleton.getInstance());
		System.out.println(Singleton.getInstance());
	}

}







