package e_oop;

import java.util.Scanner;

public class BlackJack {

				//카드 개수 13
				String [] cardnum = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10",
									  "K","j", "Q"};
				
				//K = 10
				//J = 10
				//Q = 10
				//A = 1

				//딜러 플레이어 카드 소지 개수
				String[] dealer = new String[2];
				String[] player = new String[2];
				
				//딜러 플레이어 점수 계산
				int dealerscore = 0;
				int playerscore = 0;
				
				//딜러 플레이어 점수 합산
				int dealertotal = 0;
				int playertotal = 0;
				
				//딜러 카드 분배 
				void dealershuffle(){
				for(int i = 0; i<dealer.length; i++){
					int num = (int)(Math.random()*13);
					dealer[i] = cardnum[num];	
					
				}
				}
				//딜러 카드  점수 계산
				void count(){
				for(int i =0; i<=1; i++){	
				if(dealer[i]=="K"){
				dealerscore = 10;
				}
				else if(dealer[i]=="Q"){
					dealerscore = 10;
				}
				else if(dealer[i]=="j"){
					dealerscore = 10;
				}	
				else if(dealer[i]=="A"){
					dealerscore = 1;
				}	
				else if(dealer[i]=="1"){
					dealerscore = 1;
				}	
				else if(dealer[i]=="2"){
					dealerscore = 2;
				}	
				else if(dealer[i]=="3"){
					dealerscore = 3;
				}	
				else if(dealer[i]=="4"){
					dealerscore = 4;
				}	
				else if(dealer[i]=="5"){
					dealerscore = 5;
				}	
				else if(dealer[i]=="6"){
					dealerscore = 6;
				}	
				else if(dealer[i]=="7"){
					dealerscore = 7;
				}	
				else if(dealer[i]=="8"){
					dealerscore = 8;
				}	
				else if(dealer[i]=="9"){
					dealerscore = 9;
				}	
				else if(dealer[i]=="10"){
					dealerscore = 10;
				}
				dealertotal += dealerscore;
			}
	}

				//플레이어 카드 분배
				void playershuffle(){
				for(int j = 0; j<=1; j++){
					int num1 = (int)(Math.random()*13);
					player[j] = cardnum[num1];
				}
				
				}
				
				//플레이어 카드 점수 계산
				void playercount(){
				for(int j = 0; j<player.length; j++){
				if(player[j]=="K"){
				playerscore = 10;
				}
				else if(player[j]=="Q"){
					playerscore = 10;
					
				}
				else if(player[j]=="j"){
					playerscore = 10;
					
				}	
				else if(player[j]=="A"){
					playerscore = 11;
					
				}	
				else if(player[j]=="1"){
					playerscore = 1;
				
				}	
				else if(player[j]=="2"){
					playerscore = 2;
					
				}	
				else if(player[j]=="3"){
					playerscore = 3;
					
				}	
				else if(player[j]=="4"){
					playerscore = 4;
					
				}	
				else if(player[j]=="5"){
					playerscore = 5;
					
				}	
				else if(player[j]=="6"){
					playerscore = 6;
					
				}	
				else if(player[j]=="7"){
					playerscore = 7;
					
				}	
				else if(player[j]=="8"){
					playerscore = 8;
					
				}	
				else if(player[j]=="9"){
					playerscore = 9;
				}	
				else if(player[j]=="10"){
					playerscore = 10;	
				}
				playertotal += playerscore;
			}
		}
				
						
				//카드 더 받기	
				
				public static void main(String[] args){
				BlackJack bj = new BlackJack();
				
				bj.dealershuffle();
				System.out.println("딜러의 카드는 : " +bj.dealer[0]+ ", " + bj.dealer[1] + " 입니다");
				bj.count();
				System.out.println("딜러의 점수는 : " + bj.dealertotal);
				bj.playershuffle();
				System.out.println("플레이어의 카드는 : " + bj.player[0]+", "+ bj.player[1]+ " 입니다");
				bj.playercount();
				System.out.println("플레이어의 카드는 : " + bj.playertotal);
					
				bj.shuffleadd();
					
					
				}
				
				void shuffleadd(){
					boolean stop = false;
					int num1 = (int)(Math.random()*13);
					String add = cardnum[num1];
					
				Scanner shuffle = new Scanner(System.in);
				
				
				do{
					System.out.println("카드를 더 받으시겠습니까?(y/n)");
					String answer = shuffle.nextLine();
					if(answer.equals("y")){
						int num = (int)(Math.random()*11)+1;
						System.out.println("플레이어의 추가 카드 : " + num);
						playertotal = playertotal + num;
						if(playertotal>21){
							System.out.println("플레이어의 점수 초과로 딜러가 이겼습니다.");
							stop = true;
							break;
							
						}
					}else{
//						여기서 누가이겼는지 계산
						
						if(dealertotal>playertotal){
							System.out.println("딜러가 이겼습니다.");
						}else if(playertotal>dealertotal){
							System.out.println("플레이어가 이겼습니다.");
						}else{
							System.out.println("재경기를 위해서 다시 시작해 주십시오");
						}
						stop = true;
					}
					
				}while(stop == false);
				}
		}
	

