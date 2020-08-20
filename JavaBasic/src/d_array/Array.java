package d_array;

import java.util.Arrays;
import java.util.Scanner;

public class Array {

	public static void main(String[] args) {
		/*
		 * << 배열 >>
		 * - int[] number = new int[5]; //기본값으로 초기화된다.
		 * - int[] number = new int[]{10, 20, 30, 40, 50};
		 * - int[] number = {10, 20, 30, 40, 50};
		 */
		
		//배열은 참조형 타입이다.
		int[] array; //배열의 주소를 저장할 공간이 만들어진다.
		array = new int[5]; //배열이 생성되고 그 주소가 저장된다.
		//new : 새로운 저장공간 생성 및 주소 반환
		//int[5] : int를 저장할 수 있는 5개의 공간
		//배열 초기화시 기본값이 저장된다.
		
		System.out.println(array); //주소가 저장되어 있다.
		
		System.out.println(array[0]); //실제값에 접근하기 위해서는 index를 지정해줘야 한다.
		//index에는 int만 사용할 수 있다.(리터럴, 변수, 상수, 연산 등)
		//배열의 최대 크기는 int의 최대값(약20억)이다.
		
		String arrayStr = Arrays.toString(array);
		//배열의 모든 인덱스에 저장된 값을 문자열로 반환한다.
		System.out.println(arrayStr);
		
		int[] iArray1 = new int[]{1, 2, 3}; //값의 개수로 배열의 길이가 정해진다.
		int[] iArray2 = {1, 2, 3}; //선언과 초기화를 동시에 해야한다.
		int[] iArray3;
//		iArray3 = {1, 2, 3}; //컴파일 에러 발생
		
		array[0] = 10; //인덱스는 0부터 시작한다.
		array[1] = 20;
		array[2] = 30;
		array[3] = 40;
		array[4] = 50; //마지막 인덱스는 "배열의 길이 - 1"이다.
		
		//정수를 저장할 수 있는 길이가 10인 배열을 생성 및 초기화 해주세요.
		int[] arr = new int[10];
		
		//모든 인덱스에 있는 값을 변경해주세요.
		arr[0] = 10;
		arr[1] = 10;
		arr[2] = 10;
		arr[3] = 10;
		arr[4] = 10;
		arr[5] = 10;
		arr[6] = 10;
		arr[7] = 10;
		arr[8] = 10;
		arr[9] = 10;
		
		//모든 인덱스에 있는 값을 더해주세요.
		int sum = 0;
		sum += arr[0];
		sum += arr[1];
		sum += arr[2];
		sum += arr[3];
		sum += arr[4];
		sum += arr[5];
		sum += arr[6];
		sum += arr[7];
		sum += arr[8];
		sum += arr[9];
		System.out.println(sum);
		
		//index는 1씩 증가하는 규칙이 있어 for문과 함께 사용하기 좋다.
		for(int i = 0; i < array.length; i++){
			System.out.println(array[i]);
		}
		//배열의 길이를 알고있다고 숫자를 사용하는 것을 하드코딩이라고 한다.
		//길이를 알더라도 length를 사용하는 것이 더 좋은 코드이다.
		
		for(int i = 0; i < array.length; i++){
			array[i] = i + 1;
		}
		System.out.println(Arrays.toString(array));
		
		//배열에 숫자를 담고 합계와 평균을 구해보자.
		int[] numbers = new int[10];
		
		for(int i = 0; i < numbers.length; i++){
			numbers[i] = (int)(Math.random() * 100) + 1;
		}
		System.out.println(Arrays.toString(numbers));
		
		sum = 0; //합계
		double avg = 0; //평균
		for(int i = 0; i < numbers.length; i++){
			sum += numbers[i];
		}
		avg = (double)sum / numbers.length;
		System.out.println("합계 : " + sum + " / 평균 : " + avg);
		
		//향상된 for문
		for(int number : numbers){ //배열에 있는 값을 차례대로 변수에 넣는다.
			System.out.println(number);
		}
		
		//배열에 저장된 숫자들 중 최소값과 최대값을 찾아주세요.
		int min = numbers[0];
		int max = numbers[0];
		for(int i = 0; i < numbers.length; i++){
			if(numbers[i] < min){
				min = numbers[i];
			}
			if(max < numbers[i]){
				max = numbers[i];
			}
		}
		System.out.println("min : " + min + " / max : " + max);
		
		int[] shuffle = new int[30];
		for(int i = 0; i < shuffle.length; i++){
			shuffle[i] = i + 1;
		}
		System.out.println(Arrays.toString(shuffle));
		
		//배열의 값을 섞어주세요.
		//0번 인덱스 값과 랜덤 인덱스 값을 서로 교환한다.
		for(int i = 0; i < shuffle.length * 10; i++){
			int random = (int)(Math.random() * shuffle.length);
			int temp = shuffle[0];
			shuffle[0] = shuffle[random];
			shuffle[random] = temp;
		}
		System.out.println(Arrays.toString(shuffle));
		
		//1 ~ 10 사이의 난수를 500번 생성하고, 각 숫자가 생성된 횟수를 출력해주세요.
		int[] counts = new int[10];
		
		for(int i = 0; i < 500; i++){
			int random = (int)(Math.random() * 10) + 1;
			counts[random - 1]++;
			//1 2 3 4 5 6 7 8 9 10
			//0 1 2 3 4 5 6 7 8 9
		}
		
		for(int i = 0; i < counts.length; i++){
			System.out.println(i + 1 + " : " + counts[i]);
		}
		
		
		//위 문제의 최소값, 최대값, 반복횟수를 입력받아 각 숫자가 생성된 횟수를 출력해주세요.
		//Math.random() : 0 ~ 1미만(0.999999...)
		Scanner s = new Scanner(System.in);
		
		System.out.println("최소값>");
		int minNum = Integer.parseInt(s.nextLine());
		System.out.println("최대값>");
		int maxNum = Integer.parseInt(s.nextLine());
		System.out.println("반복횟수>");
		int repeat = Integer.parseInt(s.nextLine());
		
		counts = new int[maxNum - minNum + 1];
		
		for(int i = 0; i < repeat; i++){
			int random = (int)(Math.random() * (maxNum - minNum + 1)) + minNum;
			counts[random - minNum]++;
		}
		
		for(int i = 0; i < counts.length; i++){
			System.out.println(i + 1 + " : " + counts[i]);
		}
	}

}












