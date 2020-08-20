package i_collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMapClass {

	public static void main(String[] args) {
		/*
		 * put()	: 지정된 키와 값을 저장
		 * get()	: 지정된 키의 값을 반환(없으면 null)
		 * remove()	: 지정된 키로 저장된 값을 제거
		 * keySet()	: 저장된 모든 키를 Set으로 반환
		 */
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("title", "제목입니다.");
		map.put("content", "내용입니다.");
		map.put("user", "홍길동");
		map.put("date", "2020-01-13 10:33");
		
		System.out.println(map.get("title"));
		System.out.println(map.get("content"));
		System.out.println(map.get("user"));
		System.out.println(map.get("date"));
		
		map.put("user", "이순신");
		System.out.println(map.get("user"));
		
		map.remove("user");
		System.out.println(map.get("user"));
		
		Set<String> keys = map.keySet();
		for(String key : keys){
			String value = map.get(key);
			System.out.println(key + " : " + value);
		}
		
		ArrayList<HashMap<String, String>> list = new ArrayList<>();
		
		HashMap<String, String> map1 = new HashMap<>();
		map1.put("LPROD_ID", "1");
		map1.put("LPROD_GU", "P101");
		map1.put("LPROD_NM", "컴퓨터제품");
		list.add(map1);
		
		map1 = new HashMap<>();
		map1.put("LPROD_ID", "1");
		map1.put("LPROD_GU", "P101");
		map1.put("LPROD_NM", "컴퓨터제품");
		list.add(map1);
		
		map1 = new HashMap<>();
		map1.put("LPROD_ID", "1");
		map1.put("LPROD_GU", "P101");
		map1.put("LPROD_NM", "컴퓨터제품");
		list.add(map1);
		
		map1 = new HashMap<>();
		map1.put("LPROD_ID", "1");
		map1.put("LPROD_GU", "P101");
		map1.put("LPROD_NM", "컴퓨터제품");
		list.add(map1);
		
		map1 = new HashMap<>();
		map1.put("LPROD_ID", "1");
		map1.put("LPROD_GU", "P101");
		map1.put("LPROD_NM", "컴퓨터제품");
		list.add(map1);
		
		System.out.println("-----------------------------------------");
		for(String key : list.get(0).keySet()){
			System.out.print(key + "\t");
		}
		System.out.println();
		System.out.println("-----------------------------------------");
		for(int i = 0; i < list.size(); i++){
			HashMap<String, String> m = list.get(i);
			Set<String> keySet = m.keySet();
			Iterator<String> itr = keySet.iterator();
			while(itr.hasNext()){
				String key = itr.next();
				String value = m.get(key);
				System.out.print(value + "\t\t");
			}
		}
		for(HashMap<String, String> m : list){
			for(String key : m.keySet()){
				System.out.print(m.get(key) + "\t\t");
			}
			System.out.println();
		}
		System.out.println("-----------------------------------------");
	}

}








