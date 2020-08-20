import java.util.ArrayList;
import java.util.Arrays;


public class Random {

	public static void main(String[] args) {
		//[3, 2, 4, 1]
		int[] arr = new int[]{1, 2, 3, 4};
		
		for(int i = 0; i < 100; i++){
			int ran = (int)(Math.random() * arr.length);
			int temp = arr[0];
			arr[0] = arr[ran];
			arr[ran] = temp;
		}
		
		System.out.println(Arrays.toString(arr));
		
//		ArrayList<String> students = new ArrayList<>();
//		
//		students.add("박혜진");
//		students.add("정주환");
//		students.add("이혁진");
//		students.add("김태유");
//		students.add("김종완");
//		students.add("강현철");
//		students.add("박선정");
//		students.add("김준우");
//		students.add("박기완");
//		students.add("박정민");
//		students.add("남아름");
//		students.add("전다희");
//		students.add("송효진");
//		students.add("심주영");
//		students.add("김우경");
//		students.add("임수진");
//		students.add("연지은");
//		students.add("정영수");
//		students.add("이제경");
//		students.add("홍종욱");
//		students.add("김철희");
//		
////		for(int i = 0; i < 100; i++){
////			int random = (int)(Math.random() * students.size());
////			String temp = students.get(0);
////			students.set(0, students.get(random));
////			students.set(random, temp);
////		}
////		for(int i = 0; i < 13; i++){
////			System.out.println("[5-" + (i + 1) + "] : " + students.get(i));
////		}
//		
//		int random = (int)(Math.random() * students.size());
//		System.out.println(students.get(random));
	}

}
