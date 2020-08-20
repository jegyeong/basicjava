package f_oop2;

public class Store {

	public static void main(String[] args) {
		//int String
		
		//배열 : 같은 타입의 데이터를 묶어서 사용하는 것
		//구조체(struct) : 다른 타입의 데이터를 묶어서 사용하는 것
		//클래스 : 다른 타입의 데이터를 묶어서 사용하는 것 + 관련 메서드
		
		
		
		
		Customer c = new Customer();
		
		Product p = new Desktop();
		p.info();
		c.buy(p);
		
		p = new TV();
		p.info();
		c.buy(p);
		
		c.showItem();
	}

}

class Product{
	String name;
	int price;
	
	Product(String name, int price){
		this.name = name;
		this.price = price;
	}
	
	void info(){
		System.out.println("------------------------");
		System.out.println("상품명 : " + name);
		System.out.println("금   액 : " + price + "원");
		System.out.println("------------------------");
	}
}

class Desktop extends Product{
	Desktop(){
		super("삼성 컴퓨터", 500000); //부모 클래스의 생성자 호출
	}
}

class TV extends Product{
	TV(){
		super("LG TV", 1000000);
	}
}

class Customer{
	int money = 2000000000;
	Product[] item = new Product[10]; //장바구니
	
	void buy(Product p){
		if(money < p.price){
			System.out.println("돈이 부족하다.");
			return;
		}
		
		money -= p.price;
		
		for(int i = 0; i < item.length; i++){
			if(item[i] == null){
				item[i] = p;
				break;
			}
		}
		System.out.println(p.name + "을 구매했다.");
	}
	
	void showItem(){
		System.out.println("--------- 장바구니 ----------");
		for(int i = 0; i < item.length; i++){
			if(item[i] != null){
				System.out.println(i + 1 + ". " + item[i].name);
			}
		}
		System.out.println("--------------------------");
	}
	
}










