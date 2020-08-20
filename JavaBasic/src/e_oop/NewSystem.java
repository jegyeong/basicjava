package e_oop;

import java.util.Scanner;

public class NewSystem {
	
	
	


	public static void main(String[] args) throws InterruptedException {
		
	NewSystem sys = new NewSystem();
	
	sys.name();

	sys.name2();
	
	sys.start();
	
    
	System.out.println();
	System.out.println("게임이 완성되었습니다. 당신의 능력치는 아래와 같습니다.");
	
	sys.stats1();
	
	int i=0;
	while(true){
		
		i++;
		System.out.println(i+"번째 날이 지났습니다. "+sys.name+ "의 하루가 시작됬습니다.");
		
		sys.loading();
		
		
		sys.choice();
		sys.loading2();
		sys.loading();
		
		sys.eat();
		sys.loading2();
		System.out.println("당신의 상태를 확인하려면 엔터를 누르세요.");	
		sys.loading2();
		
        if(i%2 == 0 ){
        	sys.event();
        }
        sys.loading2();
        
		
		sys.stats1();
		sys.loading();
		
		sys.loading2();
		sys.finger();
		sys.loading2();
		
		
		
		
		
		
		
		if(sys.money > 50000){
            System.out.println("축하합니다. "+ sys.name+"님은 성공적인 교육을 맞췄습니다. 하지만 인생은 이제 시작입니다. ");
}
		
		if(sys.fatigue > 10){
			System.out.println("당신은 사망했습니다. 삼가 고인의 명복을 빕니다.");
			break;
		}
		if(sys.money < 0){
			System.out.println("돈이 없습니다. 당신의 집이 서울역으로 바뀌어 부득이하게 게임이 종료됩니다.");
			break;
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
		
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	Scanner s = new Scanner(System.in);
	String name;
	String loading;
	String name2;
	int fatigue;
	int stats;
	int money;
		NewSystem(){
			fatigue = 1;
			stats = 1;
			money = ((int)(Math.random()*10)+1) * 1000;
		}
	
	void name2(){
		System.out.println("당신의 경쟁자의 이름을 정해주세요.");
		name2 = s.nextLine();
	}
	
	void name(){
		System.out.println("이름을 입력하세요.");
		name = s.nextLine();
		
	}
	void loading(){
		
		System.out.println("진행하려면 엔터키를 누르세요.");
		loading = s.nextLine();
	}
void loading2(){
		
		
		loading = s.nextLine();
	}
	
	void start() throws InterruptedException{
		System.out.println("당신의 라이벌의 이름은 "+ name2 + "입니다. 아마도 당신의 앞길을 방해할 인간입니다.");
		Thread.sleep(1000);
		System.out.println("환영합니다." + name + "님. 당신은 오늘부터 대덕인력개발원 학생입니다." );
		Thread.sleep(1000);
		System.out.println("전력을 다해서 살아남아 돈을 5만원 만드세요. ");
		Thread.sleep(1000);
		System.out.println("피로도가 높은 선택을 하면 돈을 받을 확률도 높아집니다. ");
		Thread.sleep(1000);
		System.out.println("하지만 피로도가 10이상 되면 당신은 과로사로 사망합니다");
		Thread.sleep(1000);
		System.out.println("굿럭  ㅎㅎ");
		
		loading();
		System.out.println("Loading 중입니다.");
		Thread.sleep(2000);
		System.out.println();
		System.out.println("Loading 중입니다..");
		System.out.println("게임 팁: 순간의 선택에 최선을 다한다.");
		Thread.sleep(2000);
		System.out.println();
		System.out.println("Loading 중입니다...");
		System.out.println("게임 실행 시, 자동으로 돈이 랜덤으로 생성됩니다. 네. 인생은 운빨입니다.");
		Thread.sleep(2000);
		System.out.println();
		System.out.println("Loading 중입니다....");
		System.out.println("사실 로딩은 어그로예요. 뭐라도 해야죠");
		
		
	}
	void start1(){
		
	}
	
	
	void changemoney(int money){
		this.money = money;
	}
		
	void changestats(int stats){
			this.stats = stats;
		}
		
	void changefatigue(int fatigue){
		this.fatigue = fatigue;
	}
		
		
	void moneydown(){
		changemoney(money - 1000);
	}
    void stats1(){
    	
    	System.out.println("당신의 집중력: "+ stats + " 입니다." );
    	System.out.println("당신의 피로감: "+ fatigue +" 입니다.");
    	System.out.println("당신의 돈: "+ money +" 입니다.");
    	
    }
    
    void java(){
    	changefatigue(fatigue + 2);
    	changemoney(money + 1000 * stats);
    	
    }
    void oracle(){
    	changefatigue(fatigue + 2);
    	changemoney(money + 1000);
    }
    void study(){
    	changefatigue(fatigue + 2);
    	changemoney(money + 1000 * stats);
    	
    }
    void gohome(){
    	changefatigue(fatigue -1);
    	changestats(stats-1);
    }
    void taja(){
    	changestats(stats - (int)(Math.random()*2));
    	changemoney(money + 1000);
    }
    
    void choice(){
    	    
    	    System.out.println("지금 무엇을 하시겠습니까?");
    	    System.out.println("1번 자바를 열심히 한다.(피로감+1)(운빨로 돈을 받습니다)");
    	    System.out.println("2번 오라클을 열심히 한다.(피로감+1)(돈 + 1000)");
    	    System.out.println("3번 남아서 공부를 한다.(피로감+3)(돈 1000 * 집중력 )");
    	    System.out.println("4번 집으로 도주를 한다.(피로감-2)(집중력 -1)");
    	    System.out.println("5번 타자연습만 죙일한다.(피로감 0 or 1)(돈 500)");
    	    
    		int cho = s.nextInt();
    		switch(cho){
    		case 1 : java(); break;
    		case 2 : oracle(); break;
    		case 3 : study(); break;
    		case 4 : gohome(); break;
    		case 5 : taja(); break;
    		
    		
    	}
    }
    
    
    
 void dosirak(){
	 changemoney(money - 3500);
	 System.out.println("응. 역시 도시락이 국롤이지.");
        
    }

    void Starve(){
    	System.out.println("아... 배고프다..");
    }

    void myeongnyun(){
    	changemoney(money - 10000);
    	changefatigue(fatigue - 1);
    	changestats(stats+3);
    	System.out.println("무한으로 즐겨요~ 명륜진사갈비");
    }
    
    void eat(){
        System.out.println("지금은 식사시간 입니다. 무엇을 드시겠습니까");
        System.out.println("1. 도시락 : 3500원 ");
        System.out.println("2. 굶기   : 0원(피로감 +5) (집중력-1) " );
        System.out.println("3. 명륜진사갈비 : 10000원(집중력 +3)(피로감 -1)");

                       int cho1 = s.nextInt();
        		switch(cho1){
        		case 1 : if(money < 3500){
        			System.out.println("다시 선택하세요^^ 당신은 돈이 없습니다.");
        			eat();
        		}else{
        				dosirak();
        			}break;
        		case 2 : Starve(); break;
        		case 3 : if(money < 10000){
        			System.out.println("다시 선택하세요^^ 당신은 돈이 없습니다.");
        			eat();
        		}else{
        				myeongnyun();
        			}break;
        		
        }
}
    
    
    
    void game() throws InterruptedException{
    	String a;
    	System.out.println("가위!!!!!!");
		
		System.out.println("바위!!!!!!");
		Thread.sleep(1000);
		System.out.println("보!!!!!!");
		Thread.sleep(1000);
		System.out.println("가위/바위/보 중 하나를 선택하세요!!");
		a = s.nextLine();
		int you = (int)(Math.random()*3)+1; // 가위 1 바위 2 보 3
		if(you == 1 && a.equals("가위")){
			System.out.println("가위 : 가위 || 비겼습니다!!");
			game();
			}
		else if(you == 1 && a.equals("바위")){
			System.out.println("가위 : 바위 || 이겼습니다!! 배앰!!!!");
			changemoney(money + 2000);
		}
		else if(you == 1 && a.equals("보")){
			System.out.println("가위 : 보  || 당신은 졌습니다 ㅜㅜ.. 큰일났네!");
			changemoney(money - 2000);
		}
		
		
		
		else if(you == 2 && a.equals("가위")){
			System.out.println("바위  : 가위 || 당신은 졌습니다 ㅜㅜ.. 큰일났네!");
			changemoney(money - 2000);
		}
		else if(you == 2 && a.equals("바위")){
			System.out.println("바위  : 바위 || 비겼습니다!!");
			game();
		}		else if(you == 1 && a.equals("보")){
			System.out.println("바위 : 보  || 이겼습니다!! 배앰!!!!");
			changemoney(money + 2000);
		}
		
		
		else if(you == 3 && a.equals("가위")){
			System.out.println("보  : 가위 || 이겼습니다!! 배앰!!!!");
			changemoney(money + 2000);
		}
		else if(you == 3 && a.equals("바위")){
			System.out.println("보  : 바위 || 당신은 졌습니다 ㅜㅜ.. 큰일났네! ");
			changemoney(money - 2000);
		}		else if(you == 3 && a.equals("보")){
			System.out.println("보  : 보  ||비겼습니다!! 다시 !!!");
			game();
		}
		
		
    }
    void event() throws InterruptedException{
    	String a;
    	
    	
    	
    	System.out.println(name2 + "님이 2000원 돈 내기를 신청하셨습니다. 수락하시겠습니까? 네/아니오");
    	a = s.nextLine();
    	if(a.equals("네")){
    		System.out.println(name2 + "과 인생을 내건 가위바위보를 하시겠습니다. 신중하게 선택하세요. 한순간의 선택의 당신의 인생을 결정합니다. ");
    		Thread.sleep(1000);
    	    game();
    	
    			
    		}else{
    			System.out.println("와.. 개쫄보..");
    		}
    		
    		
    		
    		
    	}
    
    void finger() throws InterruptedException{
    	System.out.print("지문 입력중");
    	Thread.sleep(1000);
    	System.out.print(".");
    	Thread.sleep(1000);
    	System.out.print(".");
    	Thread.sleep(1000);
    	System.out.print(".");
    	Thread.sleep(1000);
    	
    	System.out.println();
    	System.out.println("지문 입력이 완료되었습니다!! 오늘 하루도 수고하셨습니다. 멘탈을 재정비하시고, 다음 날을 맞이하세요!!");
    	
    }
    	
    	
    }
