package e_oop;
import java.util.Scanner;


public class Samukgu {

	public static void main(String[] args) {
		// 369게임 1~99까지 정수 입력받고 정수에 3, 6, 9 중 하나가 있는 경우 "짝" 두개 "짝짝" 출력.

		while(true){
			System.out.println("1~99 사이의 숫자를 입력하세요.");
			
			Scanner s = new Scanner(System.in);
			
			int num = s.nextInt();
			int count = 0;
			int sam = num/10;
			int nam = num%10;
			
			if(sam==3||sam==6||sam==9){
				count++;
				if(nam==3||nam==6||nam==9){
					count++;
				}
			}else if(nam==3|nam==6||nam==9){
				count++;	
			}
			switch(count){
			case 1: System.out.println("짝");
			break;
			case 2: System.out.println("짝짝");
			break;
			}	
		}
	}
}
