package e_oop;

public class ClassMember {
	
	static String classVar = "클래스 변수";
	String instanceVar = "인스턴스 변수";
	
	static void classMethod(){
		System.out.println("클래스 메서드");
	}
	
	void instanceMethod(){
		System.out.println("인스턴스 메서드");
	}
}
