package e_oop;

public class Monster {
	
	String name;
	int hp;
	int attack;
	int defence;
	
	Monster(String n, int h, int a, int d){
		name = n;
		hp = h;
		attack = a;
		defence = d;
	}
	
	String n(){
		return name;
	}
	int h(){
		return hp;
	}
	int a(){
		return attack;
	}
	int d(){
		return defence;
	}
	

}

