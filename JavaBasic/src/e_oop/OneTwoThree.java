package e_oop;

import java.util.Scanner;

public class OneTwoThree {
	Scanner s = new Scanner(System.in);
	
	int p1 = 10000;
	int p2 = 10000;
	int p3 = 10000;
	int n2;
	int n3;
	int m2;
	int m3;
	void enemy(){
	//적들 번호선택
	n2 = (int)(Math.random() * 3 + 1);
	n3 = (int)(Math.random() * 3 + 1);
	
	//적들 배팅액
	m2 = (int)(Math.random() * 10 + 1) * 100;
	m3 = (int)(Math.random() * 10 + 1) * 100;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		OneTwoThree one = new OneTwoThree();
		int x = 1;
		System.out.println("게임을 시작하지.(Let's play the game.)");
		while (true) {
			if (x == 1) {
				System.out.println("1, 2, 3 중 번호를 정해주세요.");
				int a = Integer.parseInt(s.nextLine());
				x = one.sun(a);
			} else if (x == 2) {
				System.out.println("고광렬이 오야입니다. 1, 2, 3 중 번호를 정해주세요.");
				int c = Integer.parseInt(s.nextLine());
				System.out.println("배팅액을 정해주세요. (100원 ~ 1000원)");
				int d = Integer.parseInt(s.nextLine());
				x = one.sun2(c, d);
			} else {
				System.out.println("곽철용이 오야입니다. 1, 2, 3 중 번호를 정해주세요.");
				int c = Integer.parseInt(s.nextLine());
				System.out.println("배팅액을 정해주세요. (100원 ~ 1000원)");
				int d = Integer.parseInt(s.nextLine());
				x = one.sun3(c, d);
			}
			if (one.p1 <= 0 || one.p2 <= 0 || one.p3 <= 0)
				break;
		}
		System.out.println("게임이 종료되었습니다.");
		if(one.p1 <= 0) System.out.println("당신은 파산하였습니다.");
		if(one.p2 <= 0) System.out.println("고광렬은 파산하였습니다.");
		if(one.p3 <= 0) System.out.println("곽철용은 파산하였습니다.");
	}
	
	
	
	
	
	//내가 오야일때
	int sun(int a){
		enemy();
		if(a != n2 && a != n3){
			p1 += m2 + m3;
			p2 -= m2;
			p3 -= m3;
			System.out.println("현재금액 : ");
			System.out.println("당신 : " + p1 + "\t선택한 번호 : " + a);
			System.out.println("고광렬 : " + p2 + "\t선택한 번호 : " + n2 + "\t배팅한 금액 : " + m2);
			System.out.println("곽철용 : " + p3 + "\t선택한 번호 : " + n3 + "\t배팅한 금액 : " + m3);
			return 1;
		}else if(a == n2 && a != n3){
			p1 += m3 - m2;
			p2 += m2;
			p3 -= m3;
			System.out.println("현재금액 : ");
			System.out.println("당신 : " + p1 + "\t선택한 번호 : " + a);
			System.out.println("고광렬 : " + p2 + "\t선택한 번호 : " + n2 + "\t배팅한 금액 : " + m2);
			System.out.println("곽철용 : " + p3 + "\t선택한 번호 : " + n3 + "\t배팅한 금액 : " + m3);
			return 2;
		}else if(a != n2 && a == n3){
			p1 += m2 - m3;
			p2 -= m2;
			p3 += m3;
			System.out.println("현재금액 : ");
			System.out.println("당신 : " + p1 + "\t선택한 번호 : " + a);
			System.out.println("고광렬 : " + p2 + "\t선택한 번호 : " + n2 + "\t배팅한 금액 : " + m2);
			System.out.println("곽철용 : " + p3 + "\t선택한 번호 : " + n3 + "\t배팅한 금액 : " + m3);
			return 2;
			}else{
			p1 -= m2 + m3;
			p2 += m2;
			p3 += m3;
			System.out.println("현재금액 : ");
			System.out.println("당신 : " + p1 + "\t선택한 번호 : " + a);
			System.out.println("고광렬 : " + p2 + "\t선택한 번호 : " + n2 + "\t배팅한 금액 : " + m2);
			System.out.println("곽철용 : " + p3 + "\t선택한 번호 : " + n3 + "\t배팅한 금액 : " + m3);
			return 2;
		}
	}
	
	//내가 오야가 아닐때
	int sun2(int a, int b){
		enemy();
		if(n2 != a && n2 != n3){
			p1 -= b;
			p2 += b + m3;
			p3 -= m3;
			System.out.println("현재금액 : ");
			System.out.println("당신 : " + p1 + "\t선택한 번호 : " + a + "\t배팅한 금액 : " + b);
			System.out.println("고광렬 : " + p2 + "\t선택한 번호 : " + n2);
			System.out.println("곽철용 : " + p3 + "\t선택한 번호 : " + n3 + "\t배팅한 금액 : " + m3);
			return 2;
		}else if(n2 == a && n2 != n3){
			p1 += b;
			p2 += m3 - b;
			p3 -= m3;
			System.out.println("현재금액 : ");
			System.out.println("당신 : " + p1 + "\t선택한 번호 : " + a + "\t배팅한 금액 : " + b);
			System.out.println("고광렬 : " + p2 + "\t선택한 번호 : " + n2);
			System.out.println("곽철용 : " + p3 + "\t선택한 번호 : " + n3 + "\t배팅한 금액 : " + m3);
			return 3;
		}else if(n2 != a && n2 == n3){
			p1 -= b;
			p2 += b - m3;
			p3 += m3;
			System.out.println("현재금액 : ");
			System.out.println("당신 : " + p1 + "\t선택한 번호 : " + a + "\t배팅한 금액 : " + b);
			System.out.println("고광렬 : " + p2 + "\t선택한 번호 : " + n2);
			System.out.println("곽철용 : " + p3 + "\t선택한 번호 : " + n3 + "\t배팅한 금액 : " + m3);
			return 3;
		}else{
			p1 += b;
			p2 -= b + m3;
			p3 += m3;
			System.out.println("현재금액 : ");
			System.out.println("당신 : " + p1 + "\t선택한 번호 : " + a + "\t배팅한 금액 : " + b);
			System.out.println("고광렬 : " + p2 + "\t선택한 번호 : " + n2);
			System.out.println("곽철용 : " + p3 + "\t선택한 번호 : " + n3 + "\t배팅한 금액 : " + m3);
			return 3;
		}
	}
	int sun3(int a, int b){
		enemy();
		if(n3 != a && n3 != n2){
			p1 -= b;
			p2 -= m2;
			p3 += b + m2;
			System.out.println("현재금액 : ");
			System.out.println("당신 : " + p1 + "\t선택한 번호 : " + a + "\t배팅한 금액 : " + b);
			System.out.println("고광렬 : " + p2 + "\t선택한 번호 : " + n2 + "\t배팅한 금액 : " + m2);
			System.out.println("곽철용 : " + p3 + "\t선택한 번호 : " + n3);
			return 3;
		}else if(n3 == a && n3 != n2){
			p1 += b;
			p2 -= m2;
			p3 += m2 - b;
			System.out.println("현재금액 : ");
			System.out.println("당신 : " + p1 + "\t선택한 번호 : " + a + "\t배팅한 금액 : " + b);
			System.out.println("고광렬 : " + p2 + "\t선택한 번호 : " + n2 + "\t배팅한 금액 : " + m2);
			System.out.println("곽철용 : " + p3 + "\t선택한 번호 : " + n3);
			System.out.println("당신이 오야입니다.");
			return 1;
		}else if(n3 != a && n3 == n2){
			p1 -= b;
			p2 += m2;
			p3 += b - m2;
			System.out.println("현재금액 : ");
			System.out.println("당신 : " + p1 + "\t선택한 번호 : " + a + "\t배팅한 금액 : " + b);
			System.out.println("고광렬 : " + p2 + "\t선택한 번호 : " + n2 + "\t배팅한 금액 : " + m2);
			System.out.println("곽철용 : " + p3 + "\t선택한 번호 : " + n3);
			System.out.println("당신이 오야입니다.");
			return 1;
		}else{
			p1 += b;
			p2 += m2;
			p3 -= b + m2;
			System.out.println("현재금액 : ");
			System.out.println("당신 : " + p1 + "\t선택한 번호 : " + a + "\t배팅한 금액 : " + b);
			System.out.println("고광렬 : " + p2 + "\t선택한 번호 : " + n2 + "\t배팅한 금액 : " + m2);
			System.out.println("곽철용 : " + p3 + "\t선택한 번호 : " + n3);
			System.out.println("당신이 오야입니다.");
			return 1;
		}
	}

}
