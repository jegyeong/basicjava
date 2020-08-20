package i_collection;

import java.util.ArrayList;

public class ArrayListClass {

	public static void main(String[] args) {
		/*
		 * add()	: 마지막 위치에 객체를 추가
		 * get()	: 지정된 위치의 객체를 반환
		 * set()	: 지정된 위치에 주어진 객체를 저장(수정)
		 * remove()	: 지정된 위치의 객체를 제거
		 * size()	: 저장된 객체의 수 반환
		 */
		
		ArrayList<Object> list = new ArrayList<Object>();
		
		list.add(10);
		list.add("abc");
		list.add(true);
		list.add(new ArrayListClass());
		
		ArrayList<String> list2 = new ArrayList<>();
		
		list2.add("abc");
		list2.add("123");
		list2.add("가나다");
		list2.set(1, "456");
		
		for(int i = 0; i < list2.size(); i++){
			System.out.println(list2.get(i));
		}
		
		list2.remove(0);
		//리스트에 저장된 값을 삭제하면 그뒤의 모든 값의 인덱스가 당겨진다.
		System.out.println(list2.get(0));
		System.out.println(list2.get(1));
		
		ArrayList<ArrayList<Integer>> list3 = new ArrayList<>(); //2차원 배열
		
		ArrayList<Integer> list4 = new ArrayList<>();
		list4.add(10);
		list4.add(20);
		list4.add(30);
		
		list3.add(list4);
		
		list4 = new ArrayList<>();
		list4.add(40);
		list4.add(50);
		list4.add(60);
		
		list3.add(list4);
		System.out.println(list4);
		
//		list4.add(4, 80);
//		System.out.println(list4);
		
		//정수를 저장할 수 있는 ArrayList를 생성해 값을 5번 저장해주세요.
		ArrayList<Integer> list5 = new ArrayList<>();
		list5.add(50);
		list5.add(30);
		list5.add(80);
		list5.add(90);
		list5.add(60);
		
		//위에서 만든 ArrayList에 저장된 값들의 합계와 평균을 출력해주세요.
		int sum = 0;
		double avg = 0;
		
		for(int i = 0; i < list5.size(); i++){
			sum += list5.get(i);
		}
		avg = (double)sum / list5.size();
		System.out.println(list5);
		System.out.println("합계 : " + sum + " / 평균 : " + avg);
		
		//위에서 만든 ArrayList에 저장된 값들 중 최소값과 최대값을 출력해주세요.
		int min = list5.get(0);
		int max = list5.get(0);
		
		for(int i = 0; i < list5.size(); i++){
			if(list5.get(i) < min){
				min = list5.get(i);
			}
			if(max < list5.get(i)){
				max = list5.get(i);
			}
		}
		System.out.println("최소값 : " + min + " / 최대값 : " + max);
	}

}








