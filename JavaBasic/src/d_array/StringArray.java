package d_array;

import java.util.Scanner;

public class StringArray {

	public static void main(String[] args) {
		String s = new String("ABCD"); //참조형 타입을 초기화하는 방법
		String str = "ABCD"; //String은 특별히 간단하게 초기화 가능
		
		char[] charArray = str.toCharArray();
		System.out.println(charArray);
		
		/*
		 * << String의 주요 메서드 >>
		 * - equals()	: 문자열의 내용이 같은지 확인한다.
		 * - length()	: 문자열의 길이를 반환한다.
		 * - charAt()	: 문자열에서 해당 위치에 있는 문자를 반환한다.
		 * - substring(): 문자열에서 해당 범위에 있는 문자열을 반환한다.
		 * - indexOf()	: 문자열 내의 특정 문자열의 인덱스를 반환한다.
		 * - replace()	: 문자열 내의 특정 문자열을 원하는 문자열로 변경해 반환한다.
		 */
		
		for(int i = 0; i < str.length(); i++){
			System.out.println(str.charAt(i));
		}
		
		String revStr = ""; //str을 거꾸로 담을 변수
		//뒤에서부터 한글자씩 가져와서 새로운 변수에 더한다.
		//ABCD
		for(int i = str.length() - 1; i >= 0; i--){
			revStr += str.charAt(i);
			//revStr = revStr + str.charAt(i);
		}
		System.out.println(revStr);
		
		str = "0123456789";
		String sub1 = str.substring(3); //3번 인덱스부터 잘라서 반환한다.
		System.out.println(sub1);
		String sub2 = str.substring(5, 8); //5번 인덱스부터 8번 인덱스 전까지 잘라서 반환한다.
		System.out.println(sub2);
		
		str = "치킨 피자 돈까스 떡볶이";
		int idx = str.indexOf("피자"); //피자의 시작 인덱스를 반환한다.
		System.out.println(idx);
		
		idx = str.indexOf("짜장면");
		System.out.println(idx); //해당되는 문자열이 없는경우 -1을 반환한다.
		
		String[] menus = {
			"치킨 18000원",
			"피자 9900원",
			"돈까스 8000원",
			"떡볶이 500원"
		};
		
		for(int i = 0; i < menus.length; i++){
			String name = menus[i].substring(0, menus[i].indexOf(" "));
			System.out.println(name);
			
			//가격만 분리시켜 int형 변수에 담아주세요.
			int price = Integer.parseInt(
					menus[i].substring(
							menus[i].indexOf(" ") + 1, menus[i].indexOf("원")));
			System.out.println(price);
		}
		
		str = "123456789";
		str = str.replace("3", "짝");
		System.out.println(str);
		str = str.replace("6", "짝");
		System.out.println(str);
		str = str.replace("9", "짝");
		System.out.println(str);
		
		String pn = "010-2363-3647";
		//하이픈(-)을 제거해서 출력해주세요.
		pn = pn.replace("-", "");
		System.out.println(pn);
		
		//숫자를 입력받아 입력받은 숫자에 3자리 마다 콤마(,)를 붙여 출력해주세요.
		//1234567 -> 1,234,567
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자를 입력해주세요>");
		String number = sc.nextLine();
		String newNumber = "";
		
		int count = 0;
		
		for(int i = number.length() - 1; i >= 0; i--){
			newNumber = number.charAt(i) + newNumber;
			count++;
			if(count % 3 == 0 && count != number.length()){
				newNumber = "," + newNumber;
			}
		}
		System.out.println(newNumber);
	}

}









