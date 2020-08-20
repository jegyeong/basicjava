package h_useful;

public class MathClass {

	public static void main(String[] args) {
		/*
		 * round()	: 반올림
		 * ceil()	: 올림
		 * floor()	: 내림
		 * abs()	: 절대값
		 * random()	: double 난수 발생(0.0 ~ 1.0 미만)
		 */
		
		double d1 = 0.55;
		double d2 = -0.55;
		
		System.out.println(Math.round(d1));
		System.out.println(Math.round(d2));
		
		System.out.println(Math.ceil(d1));
		System.out.println(Math.ceil(d2));
		
		System.out.println(Math.floor(d1));
		System.out.println(Math.floor(d2));
		
		System.out.println(Math.abs(d1));
		System.out.println(Math.abs(d2));
		
		for(int i = 0; i < 30; i++){
			int random = getRandom(5, 10);
			System.out.print(random + " ");
		}
	}
	
	public static int getRandom(int from, int to){
		return (int)(Math.random() * (Math.abs(to - from) + 1)) + Math.min(from, to);
	}

}









