package f_oop2.ex_abstract;

public abstract class Animal {
	
	public static void main(String[] args) {
		Animal a = new Dog();
	}
	
	void run(){
		System.out.println("달려갑니다.");
	}
	
	abstract void bark();
	
}

class Dog extends Animal{

	@Override
	void bark() {
		
		System.out.println("멍멍!!");
	}
	
}









