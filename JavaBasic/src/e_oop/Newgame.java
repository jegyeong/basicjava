package e_oop;


import java.util.Scanner;

public class Newgame {
	static String s="라디오";
	
//	void player(int num){
//	      
//	      for(int i=0; i<num; i++){
//	      }
//	      System.out.println("참가인원은"+num);
//	   }
//	 void name(String name,int num, int play[]){
//		 for(int i=0; i<num; i++){
//			 System.out.println("참가자의 이름을 입력하시오");
//		 }
//	 }
//	boolean word(String str) {
//		String[] name = new String[5];
//
//		for (int i = 0; i < name.length; i++) {
//			name[i] = str;
//		}
//		if (s.charAt(s.length() - 1) == str.charAt(0)) {
//			s = str;
//			System.out.println("다음단어는->" + s);
//			return true;
//		}
//		return false;
//	}
	
	boolean word(String str){
		
		if(s.charAt(s.length()-1)== str.charAt(0)){
			s=str;
			System.out.println("다음단어는->"+s);
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Newgame ng= new Newgame();
		Scanner sc= new Scanner(System.in);
		System.out.println("시작단어는 : "+s );
		String str= sc.next();
		
		int count=0;
		while(true){
		ng.word(str);
		str=sc.next();
		count++;
		if(ng.word(str)==false){
			System.out.println("잘못입력하셧습니다");
			System.out.println("반복실행 횟수는 : "+count);
			System.out.println("게임이 끝났습니다");
			break;
		}
		
		}
	
		
	}

}
