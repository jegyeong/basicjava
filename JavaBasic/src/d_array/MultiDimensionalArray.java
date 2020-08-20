package d_array;

import java.util.Arrays;

public class MultiDimensionalArray {

	public static void main(String[] args) {
		/*
		 * << 다차원 배열 >>
		 * - 배열안에 배열이 저장되어 있는 형태이다.
		 */
		
		int[][] numbers = new int[2][3]; //2칸짜리 배열안에 각 칸마다 3칸짜리 배열이 생성된다.
		int numbers2[][] = new int[][]{ {1, 2, 3}, {4, 5, 6} };
		int[] numbers3[] = { {1, 2, 3}
						   , {4, 5, 6}
						   , {7, 8, 9} };
		
		int[] a1 = {1, 2, 3}; //1차원
		int[][] a2 = { {1, 2}, {1, 2, 3}, {4} }; //2차원
		int[][][] a3 = { { {5}, {6,7,8} } }; //3차원
		
		
		int[][] numbers4 = new int[3][]; //가변 배열
		numbers4[0] = new int[3];
		numbers4[1] = new int[4];
		numbers4[2] = new int[10]; //길이를 다르게 지정할 수 있다.
		
		
//		numbers[0] = 10; //1차원에 값을 저장할 수 없다.
		numbers[0] = new int[5]; //1차원에 배열을 저장할 수 있다.
		numbers[0][0] = 10; //2차원에 값을 저장할 수 있다.
		numbers[0][1] = 20;
		numbers[1][0] = 100;
		
		System.out.println(numbers.length);
		System.out.println(numbers[1].length); //2차원 배열의 길이
		
		for(int i = 0; i < numbers.length; i++){
			for(int j = 0; j < numbers[i].length; j++){
				System.out.println(numbers[i][j]);
				/*[3][2]
				 * { {1, 2}
				 * , {4, 5}
				 * , {7, 8} }
				 */
			}
		}
		
		System.out.println(Arrays.toString(numbers));
		
		for(int i = 0; i < numbers.length; i++){
			System.out.println(Arrays.toString(numbers[i]));
		}
		
		int[][] scores = new int[3][5]; //int[학생수][과목수]
		int[] sum = new int[scores.length]; //총점
		double[] avg = new double[scores.length]; //평균
		
		for(int i = 0; i < scores.length; i++){
			for(int j = 0; j < scores[i].length; j++){
				scores[i][j] = (int)(Math.random() * 100) + 1;
			}
			System.out.println(Arrays.toString(scores[i]));
		}
		
		//총점과 평균을 구해주세요.
		for(int i = 0; i < scores.length; i++){
			for(int j = 0; j < scores[i].length; j++){
				sum[i] += scores[i][j];
			}
			avg[i] = (double)sum[i] / scores[i].length;
			System.out.println("총점 : " + sum[i] + " / 평균 : " + avg[i]);
		}
	}

}










