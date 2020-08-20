package i_collection;

import java.util.ArrayList;

public class Score {

	public static void main(String[] args) {
		ArrayList<String> students = new ArrayList<>();
		students.add("박혜진");
		students.add("정주환");
		students.add("이혁진");
		students.add("김태유");
		students.add("김종완");
		students.add("강현철");
		students.add("박선정");
		students.add("김준우");
		students.add("박기완");
		students.add("박정민");
		students.add("남아름");
		students.add("전다희");
		students.add("송효진");
		students.add("심주영");
		students.add("김우경");
		students.add("임수진");
		students.add("연지은");
		students.add("정영수");
		students.add("이제경");
		students.add("홍종욱");
		students.add("김철희");
		
		ArrayList<String> subjects = new ArrayList<>();
		subjects.add("Java");
		subjects.add("Oracle");
		subjects.add("HTML");
		subjects.add("CSS");
		subjects.add("JQuery");
		subjects.add("JSP");
		
		ArrayList<ArrayList<Double>> scores = new ArrayList<>();
		
		for(int i = 0; i < students.size(); i++){
			ArrayList<Double> list = new ArrayList<>();
			list.add(1.0);
			for(int j = 0; j < subjects.size(); j++){
				list.add((int)(Math.random() * 51) + 50.0);
			}
			scores.add(list);
		}
		
		//총점 평균을 구한다.
		for(int i = 0; i < scores.size(); i++){
			ArrayList<Double> score = scores.get(i);
			int sum = 0;
			for(int j = 1; j < score.size(); j++){
				sum += score.get(j);
			}
			score.add((double)sum);
			score.add((double)sum / subjects.size());
		}
		
		//석차를 구한다.
		for(int i = 0; i < scores.size(); i++){
			for(int j = 0; j < scores.size(); j++){
				int sumIdx = subjects.size() + 1;
				if(scores.get(i).get(sumIdx) < scores.get(j).get(sumIdx)){
					scores.get(i).set(0, scores.get(i).get(0) + 1);
				}
			}
		}
		
		//석차대로 정렬한다.
		for(int i = 0; i < scores.size() - 1; i++){
			boolean changed = false;
			for(int j = 0; j < scores.size() - 1 - i; j++){
				if(scores.get(j).get(0) > scores.get(j + 1).get(0)){
					ArrayList<Double> temp = scores.get(j);
					scores.set(j, scores.get(j + 1));
					scores.set(j + 1, temp);
					
					String tempName = students.get(j);
					students.set(j, students.get(j + 1));
					students.set(j + 1, tempName);
					
					changed = true;
				}
			}
			if(!changed) break;
		}
		
		//출력한다.
		System.out.print("석차\t이름");
		for(int i = 0; i < subjects.size(); i++){
			System.out.print("\t" + subjects.get(i));
		}
		System.out.println("\t총점\t평균");
		for(int i = 0; i < scores.size(); i++){
			ArrayList<Double> score = scores.get(i);
			for(int j = 0; j < score.size(); j++){
				if(j == score.size() - 1){
					System.out.print(score.get(j) + "\t");
				}else{
					System.out.print((int)(double)score.get(j) + "\t");
				}
				if(j == 0){
					System.out.print(students.get(i) + "\t");
				}
			}
			System.out.println();
		}
	}

}










