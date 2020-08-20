package e_oop;

public class ClassMaker2 {
	
	//전역변수 하나를 선언하고 명시적으로 초기화 해주세요.
	String color = "red";
	
	//위에서 선언한 전역변수를 초기화 블럭을 사용해 초기화 해주세요.
//	{
//		color = "blue";
//	}
	
	static int a = 0;
	static void a(){
		
	}
	
	//위에서 선언한 전역변수를 생성자의 파라미터를 사용해 초기화 해주세요.
	ClassMaker2(String color){
		this.color = color;
		System.out.println(a);
		a();
	}
	
	
	//위에서 선언한 전역변수를 생성자를 하나 더 만들어서 초기화 해주세요.
	ClassMaker2(){
//		this("black");
	}
	
	public static void main(String[] args) {
//		System.out.println(color);
		ClassMaker2 cm2 = new ClassMaker2();
		System.out.println(cm2.color);
		
		cm2 = new ClassMaker2("blue");
		System.out.println(cm2.color);
	}
}








