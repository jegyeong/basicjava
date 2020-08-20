package service;

public class IntegerCheck {
	public static boolean checkInt(String temp){
		boolean check = false;
		if(!temp.equals("")){
			for (int i = 0; i < temp.length(); i++) {
				if (temp.charAt(i) < '0' || temp.charAt(i) > '9') {
					System.out.println("숫자를 입력해주세요.");
					return false;
				}else{
					check = true;
				}
			}
		}else {
			System.out.println("숫자를 입력해주세요.");
			return false;
		}
		
		return check;
	}
	public static boolean checkInt(String temp,int a, int b){
		boolean check = false;
		if(!temp.equals("")){
			for (int i = 0; i < temp.length(); i++) {
				if (temp.charAt(i) < '0' || temp.charAt(i) > '9') {
					System.out.println("숫자를 입력해주세요.");
					return false;
				}else{
					check = true;
				}
			}
			if(check){
				if(Integer.parseInt(temp) >= a&&Integer.parseInt(temp) <= b){
					check = true;
				}else{
					System.out.println("범위가 잘못되었습니다.");
					System.out.println("("+a+" ~ "+b+")");
					return false;
				}
			}
		}else {
			System.out.println("숫자를 입력해주세요.");
			return false;
		}
		
		return check;
		
	}
	public static boolean checkInt(String temp,int a){
		boolean check = false;
		
		if(!temp.equals("")){
			for (int i = 0; i < temp.length(); i++) {
				if (temp.charAt(i) < '0' || temp.charAt(i) > '9') {
					System.out.println("숫자를 입력해주세요.");
					return false;
				}else{
					check = true;
				}
			}
			if(check){
				if(Integer.parseInt(temp)>= 0&&Integer.parseInt(temp) <= a){
					check = true;
				}else{
					System.out.println("범위가 잘못되었습니다.");
					System.out.println("(0"+" ~ "+a+")");
					return false;
				}
			}
		}else {
			System.out.println("숫자를 입력해주세요.");
			return false;
		}
		
		return check;
		
	}
}
