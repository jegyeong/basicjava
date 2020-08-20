package d_array;

import java.util.Arrays;

public class Sort {

	public static void main(String[] args) {
		/*
		 * << 정렬 >>
		 * - 선택정렬 : 첫번째 숫자부터 그 뒤의 모든 숫자들과 비교해서 작은수와 자리 바꾸기를 반복해
		 * 			앞에서부터 작은수를 채워나가는 방식
		 * - 버블정렬 : 첫번째 숫자부터 바로 뒷 숫자와 비교해서 작은수와 자리 바꾸기를 반복해
		 * 			뒤에서부터 큰수를 채워나가는 방식
		 * - 삽입정렬 : 두번째 숫자부터 그 앞의 모든 숫자들과 비교해서 큰수들을 뒤로 밀고
		 * 			중간에 삽입하는 방식
		 * 
		 * << 석차구하기 >>
		 * - 모든 점수가 1등으로 시작해서 다른 점수들과 비교해 자신의 점수가 작으면 1씩 증가시키는 방식
		 */
		
		int[] numbers = new int[10];
		
		for(int i = 0; i < numbers.length; i++){
			numbers[i] = i + 1;
		}
		
		shuffle(numbers);
		System.out.println(Arrays.toString(numbers));
		
//		printRank(numbers); //석차구하기
//		selectSort(numbers); //선택정렬
//		bubbleSort(numbers); //버블정렬
		insertSort(numbers); //삽입정렬
		System.out.println(Arrays.toString(numbers));
	}

	private static void insertSort(int[] numbers) {
		/*
		 * i j
		 * 1,0
		 * 2,1  2,0
		 * 3,2  3,1  3,0
		 * 4,3  4,2  4,1  4,0
		 * 5,4  5,3  5,2  5,1  5,0
		 * 6,5  6,4  6,3  6,2  6,1  6,0
		 * 7,6  7,5  7,4  7,3  7,2  7,1  7,0
		 * 8,7  8,6  8,5  8,4  8,3  8,2  8,1  8,0
		 * 9,8  9,7  9,6  9,5  9,4  9,3  9,2  9,1  9,0
		 */
		
		for(int i = 1; i < numbers.length; i++){
			int temp = numbers[i];
			int j = 0;
			for(j = i - 1; j >= 0; j--){
				if(temp < numbers[j]){
					numbers[j + 1] = numbers[j];
				}else{
					break;
				}
			}
			numbers[j + 1] = temp;
		}
	}

	private static void bubbleSort(int[] numbers) {
		/*
		 * 0,1  1,2  2,3  3,4  4,5  5,6  6,7  7,8  8,9
		 * 0,1  1,2  2,3  3,4  4,5  5,6  6,7  7,8
		 * 0,1  1,2  2,3  3,4  4,5  5,6  6,7
		 * 0,1  1,2  2,3  3,4  4,5  5,6
		 * 0,1  1,2  2,3  3,4  4,5
		 * 0,1  1,2  2,3  3,4
		 * 0,1  1,2  2,3
		 * 0,1  1,2
		 * 0,1
		 */
		
		for(int i = 0; i < numbers.length - 1; i++){
			boolean changed = false;
			for(int j = 0; j < numbers.length - i - 1; j++){
				if(numbers[j] > numbers[j + 1]){
					int temp = numbers[j];
					numbers[j] = numbers[j + 1];
					numbers[j + 1] = temp;
					changed = true;
				}
			}
			if(!changed){
				break;
			}
		}
	}

	private static void selectSort(int[] numbers) {
		/*
		 * i j
		 * 0,1  0,2  0,3  0,4  0,5  0,6  0,7  0,8  0,9
		 * 1,2  1,3  1,4  1,5  1,6  1,7  1,8  1,9
		 * 2,3  2,4  2,5  2,6  2,7  2,8  2,9
		 * 3,4  3,5  3,6  3,7  3,8  3,9
		 * 4,5  4,6  4,7  4,8  4,9
		 * 5,6  5,7  5,8  5,9
		 * 6,7  6,8  6,9
		 * 7,8  7,9
		 * 8,9
		 */
		for(int i = 0; i < numbers.length - 1; i++){
			for(int j = i + 1; j < numbers.length; j++){
				if(numbers[i] > numbers[j]){
					int temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}
			}
		}
	}

	private static void printRank(int[] numbers) {
		int[] rank = new int[numbers.length];
		
		for(int i = 0; i < rank.length; i++){
			rank[i] = 1;
		}
		
		for(int i = 0; i < numbers.length; i++){
			for(int j = 0; j < numbers.length; j++){
				if(numbers[i] < numbers[j]){
					rank[i]++;
				}
			}
		}
		System.out.println(Arrays.toString(rank));
	}

	private static void shuffle(int[] numbers) {
		for(int i = 0; i < numbers.length * 10; i++){
			int random = (int)(Math.random() * numbers.length);
			
			int temp = numbers[0];
			numbers[0] = numbers[random];
			numbers[random] = temp;
		}
	}

}









