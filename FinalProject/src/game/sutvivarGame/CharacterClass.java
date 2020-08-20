package game.sutvivarGame;



abstract class CharacterClass {

}
	
	


class Character1 extends CharacterClass{ // 상대방이 공격한다는 것을 예측해서 특수기술을 쓰면 내 자신의 체력은 그대로고 상대방은 나의 2배의 체력이 닳음

	private static Character1 instance; // instance가 변수

	private Character1() {
	}

	public static Character1 getInstance() {
		if (instance == null) {
			instance = new Character1();
		}
		return instance;

	}

	int health = 9;
	int power = 2;
	int point = 0;
	int skillpoint = 3;
	
	void info() {
		System.out.println("박정민 fast(24)");
		System.out.print("Health : ");
		for (int i = 0; i < health; i++) {
			System.out.print("■ ");
		}
		System.out.println("("+health+")");
		System.out.print("\nPower : ");
		for (int i = 0; i < power; i++) {
			System.out.print("★");
		}
		System.out.println("\nSkill : 굉장해 엄청난 한방 ");
		
		System.out.print("            상대방에게 자신의 공격력 2배의 데미지를 입힌다. ");
		System.out.print("\n            만약 상대방이 방어를 했다면, 자신의 공격력만큼 피해를 준다. ");
	}
	
}

class Character2 { // 2배 정도 강하게 맞춤. 혹은 자신 체력이 없어진 만큼 증가 공격을 넣어준다.
	private static Character2 instance; // instance가 변수

	private Character2() {
	}

	public static Character2 getInstance() {
		if (instance == null) {
			instance = new Character2();
		}
		return instance;

	}
	
	int health = 7;
	int power = 2;
	int point = 1;
	int skillpoint = 3;
	
	void info() {
		System.out.println("김준우 (26)");
		
		System.out.print("Health : ");
		for (int i = 0; i < health; i++) {
			System.out.print("■ ");
		}
		System.out.println("("+health+")");
		System.out.print("\nPower : ");
		for (int i = 0; i < power; i++) {
			System.out.print("★");
		}
		System.out.print("\nSkill : 물약 모드");
		System.out.println("\n         물약 모드에서는 힘이 2배로 증가한다.");
		System.out.println("         사용하기 위해 필요한 포인트는 3개이다.");
	}
	

}

class Character3 {
	
	
	int health = 8;
	int power = 5;
	int point = 0;
	int skillpoint = 2;
	
	void info() {
		System.out.println("김기완 (27)");
		System.out.print("Health : ");
		for (int i = 0; i < health; i++) {
			System.out.print("■ ");
		}
		System.out.println("("+health+")");
		System.out.print("\nPower : ");
		for (int i = 0; i < power; i++) {
			System.out.print("★");
		}
		System.out.print("\nSkill : 회복하기");
		System.out.println("\n        자신의 체력을 3만큼 회복한다.");
		System.out.println("         사용하기 위해 필요한 포인트는 3개이다.");
	}
	
	
}



