package e_oop;

public class VariableInit {

	//명시적 초기화
	int var = 10;
	
	static int classVar = 20;
	
	static {
		classVar = 30;
	}
	
	//초기화 블럭 : 여러 문장이 필요한 초기화를 해야할 때 사용한다.
	{
		var = 10;
//		for(int i = 1; i <= 10; i++){
//			var += i;
//		}
	}
	
	/*
	 * << 생성자 >>
	 * - 클래스와 같은 이름의 메서드
	 * - 객체를 생성하면서 필요한 작업이 있을때 사용한다.(인스턴스 변수 초기화)
	 * - 파라미터를 받아서 초기화 하고싶을 때 사용한다.
	 * - 클래스에 생성자는 반드시 하나 이상 존재해야 한다.
	 * - 직접 선언해주지 않으면 컴파일러가 기본 생성자를 만들어준다.
	 * - 생성자는 리턴타입이 없다.
	 */
	
	VariableInit(int var){
		this.var = var;
		for(int i = 1; i <= var; i++){
			this.var += i;
		}
		//this : 클래스의 인스턴스 주소가 저장된 변수
		//인스턴스 변수와 지역변수의 이름이 같을 때 둘을 구분하기 위해
		//인스턴스 변수 앞에 붙여서 사용한다.
	}
	
	//오버로딩 : 같은 이름의 메서드를 정의하는 것
	//파라미터의 갯수나 타입이 달라야 한다.
	VariableInit(){
//		for(int i = 1; i <= 100; i++){
//			this.var += i;
//		}
		this(100); //VariableInit(int var)
		//this() : 생성자에서 다른 생성자를 호출할때 사용한다.
		//this() 이전의 코드가 의미 없는 코드가 될 수 있기 때문에 this()는
		//생성자의 첫줄에서만 사용할 수 있다.
		
		VariableInit variableInit = new VariableInit();
		VariableInit variableInit2 = new VariableInit(100);
	}
	
}












