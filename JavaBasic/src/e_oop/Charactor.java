package e_oop;

public class Charactor {
	
	String name;
	int hp;
	int attack;
	int defence;
	
	Charactor(String n){
		name = n;
		hp = 200;
		attack = 25;
		defence = 10;
	}
	
	String n(){ //이름
		return name;
	}
	int h(){ //체력
		return hp;
	}
	int a(){ //공격력
		return attack;
	}
	int d(){ //방어력
		return defence;
	}

}
