package e_oop;

public class Static {

	public static void main(String[] args) {
		/*
		 * << static >>
		 * - 객체 생성 없이 변수나 메서드를 사용하기 위해 붙인다.
		 * - 객체들간에 변수의 값을 공유하기 위해 붙인다.
		 * - static이 붙은 것 : 클래스 멤버(클래스 변수, 클래스 메서드)
		 * - 클래스 멤버 : 메모리에 클래스가 저장될 때 같이 저장된다.
		 * - static이 붙지 않은 것 : 인스턴스 멤버(인스턴스 변수, 인스턴스 메서드)
		 * - 인스턴스 멤버 : 메모리에 인스턴스가 저장될 때 같이 저장된다.
		 */
		
		//static이 붙은 메서드
		Math.random();
		System.out.println();
		
		System.out.println(ClassMember.classVar);
		ClassMember.classMethod();
		
		ClassMember cm1 = new ClassMember();
		System.out.println(cm1.instanceVar);
		cm1.instanceMethod();
		
		System.out.println(cm1.classVar);
		cm1.classMethod();
		//객체를 통해서도 클래스 멤버에 접근할 수 있지만 좋은 방법은 아니다.
		
		ClassMember cm2 = new ClassMember();
		cm2 = null;
		
		System.out.println("변경 전");
		System.out.println("cm1 : " + cm1.instanceVar);
		System.out.println("cm2 : " + cm2.instanceVar);
		
		cm2.instanceVar = "인스턴스 변수 변경";
		
		System.out.println("변경 후");
		System.out.println("cm1 : " + cm1.instanceVar);
		System.out.println("cm2 : " + cm2.instanceVar);
		
		System.out.println("변경 전");
		System.out.println("ClassMember : " + ClassMember.classVar);
		System.out.println("cm1 : " + cm1.classVar);
		System.out.println("cm2 : " + cm2.classVar);
		
		ClassMember.classVar = "클래스 변수 변경";
		
		System.out.println("변경 후");
		System.out.println("ClassMember : " + ClassMember.classVar);
		System.out.println("cm1 : " + cm1.classVar);
		System.out.println("cm2 : " + cm2.classVar);
	}

}











