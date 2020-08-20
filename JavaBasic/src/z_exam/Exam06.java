package z_exam;

public class Exam06 {

//	static double getDistance(int x, int y, int x1, int y1) {
//		return Math.sqrt((x - x1) * (x - x1) + (y - y1) * (y - y1));
//	}
	
	public static void change(String str) {
//		str += "456";
		str = "ABC456";
	}

	private static void change(MyPoint mp) {
		mp.x = 2;
	}

	public static void main(String[] args) {
		int value = 5;
		System.out.println(value+"의 절대값:"+abs(value));
		value = -10;
		System.out.println(value+"의 절대값:"+abs(value));
	}
	/*
	[6-24] 다음과 같이 정의된 메서드를 작성하고 테스트하시오.
	메서드명 : abs
	기 능 : 주어진 값의 절대값을 반환한다.
	반환타입 : int
	매개변수 : int value
	*/
	
	public static int abs (int value){
		return value <0? -value: value;
	}

	
	
	
	/*
	[6-23] 다음과 같이 정의된 메서드를 작성하고 테스트하시오.
	메서드명 : max
	기 능 : 주어진 int형 배열의 값 중에서 제일 큰 값을 반환한다.
	만일 주어진 배열이 null이거나 크기가 0인 경우, -999999를 반환한다.
	반환타입 : int
	매개변수 : int[] arr - 최대값을 구할 배열
	*/
	static int max(int[] arr){
		if(arr == null||arr.length==0)
			return -999999;
		else{
			for(int i = 0 ; i< arr.length-1;i++){
				for(int j = i; j< arr.length;j++){
					if(arr[i]>arr[j]){
						int temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
					}
				}
			}
			return arr[arr.length-1];
		}
	}
	
	
	
	
	
	/*
	[6-22] 다음과 같이 정의된 메서드를 작성하고 테스트하시오.
	메서드명 : isNumber
	기 능 : 주어진 문자열이 모두 숫자로만 이루어져있는지 확인한다.
	모두 숫자로만 이루어져 있으면 true를 반환하고,
	그렇지 않으면 false를 반환한다.
	만일 주어진 문자열이 null이거나 빈문자열“”이라면 false를 반환한다.
	반환타입 : boolean
	매개변수 : String str - 검사할 문자열
	[Hint] String클래스의 charAt(int i)메서드를 사용하면 문자열의 i번째 위치한 문자를 얻을 수 있다.
	*/
	static boolean isNumber(String str){
		for(int i = 0; i < str.length(); i++){
			char ch = str.charAt(i);
			if(ch < '0' || '9' < ch){
				return false;
			}
		}
		return true;
//		for(int i=0; i<str.length(); i++){
//			if(str.charAt(i)>='0' && str.charAt(i)<='9'){
//				continue;
//			}else{
//				return false;
//			}
//		}
//		return true;
		
	}
	
}
//class String {
//	char[] str;
//}
class MyPoint {
	int x;
	int y;

	MyPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	/*
	 * (1) 인스턴스메서드 getDistance를 작성하시오.
	 */
	double getDistance(int x, int y){
		return Math.sqrt((this.x -x) * (this.x - x) + (this.y - y) * (this.y - y));
	}
}


/*
[6-6] 두 점의 거리를 계산하는 getDistance()를 완성하시오.
[Hint] 제곱근 계산은 Math.sqrt(double a)를 사용하면 된다.
[연습문제]/ch6/Exercise6_6.java
class Exercise6_6 {
// 두 점 (x,y)와 (x1,y1)간의 거리를 구한다.
static double getDistance(int x, int y, int x1, int y1) {

(1) 알맞은 코드를 넣어 완성하시오.

 Math.sqrt((x-x1)*(x-x1) + (y-y1)*(y-y1))

}
public static void main(String args[]) {
System.out.println(getDistance(1,1,2,2));
}
}
*/





/*
[6-3] 다음과 같은 멤버변수를 갖는 Student클래스를 정의하시오.
타 입 변수명 설 명
String name 학생이름
int ban 반
int no 번호
int kor 국어점수
int eng 영어점수
int math 수학점수
*/
class Student{
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	/*
	[6-5] 다음과 같은 실행결과를 얻도록 Student클래스에 생성자와 info()를 추가하시오.
	[실행결과]
	홍길동,1,1,100,60,76,236,78.7
	*/
	Student(String name,int ban,int no,int kor,int eng,int math){
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	String info(){
		return name+","+ban+","+no+","+kor+","+eng+","+math+","+getTotal()+","+getAverage();
	}
	
	
	
	
	/*
	1. 메서드명 : getTotal
	기 능 : 국어(kor), 영어(eng), 수학(math)의 점수를 모두 더해서 반환한다.
	반환타입 : int
	매개변수 : 없음
	2. 메서드명 : getAverage
	기 능 : 총점(국어점수+영어점수+수학점수)을 과목수로 나눈 평균을 구한다.
	소수점 둘째자리에서 반올림할 것.
	반환타입 : float
	매개변수 : 없음
	*/
	int getTotal(){
		return kor+eng+math;
	}
	float getAverage(){
		return (int)((float)getTotal()/3*10+0.5f)/10f;
	}
}






/*
[6-1] 다음과 같은 멤버변수를 갖는 SutdaCard클래스를 정의하시오.
타 입 변수명 설 명
int num 카드의 숫자.(1~10사이의 정수)
boolean isKwang 광(光)이면 true, 아니면 false
*/

class SutdaCard{
	int num;
	boolean isKwang;
	
	
	SutdaCard(int num, boolean isKwang){
		this.num=num;
		this.isKwang=isKwang;
	}
	
	SutdaCard(){
		this(1, true);
//		this.num=1;
//		this.isKwang=true;
	}
	
	String info(){
		return num + (isKwang ? "K" : "");
	}
}







