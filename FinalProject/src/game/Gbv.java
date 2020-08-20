package game;

import java.util.Date;
import java.util.Scanner;

import vo.MileageVo;
import vo.UserVo;
import dao.MileageDao;

import data.Session;

public class Gbv {
	
private static Gbv instance;
	private Gbv() {
    	
    	
	}

	public static Gbv getInstance() {
		if (instance == null) {
			instance = new Gbv();
		}
		return instance;

	}
	int count = 0;
	int computer = 0;  //렌덤 가위 바위 보
	int user = 0;      //입력 가위 바위 보
	int coin = 0;      //반복 횟수
	int mileage  = 0;   //점수
	String comStr=""; //가위 바위 보 출력 :컴퓨터
	String userStr="";//가위 바위 보 출력 :유저
	String comStr1=""; //묵 찌 빠 출력 :컴퓨터
	String userStr1="";//묵 찌 빠 출력 :유저
	String comStr2=""; //묵 찌 빠 가위 바위 보 출력 :컴퓨터
	String userStr2="";//묵 찌 빠 가위 바위 보 출력 :유저
	Scanner sc = new Scanner(System.in);

  
   public void start(){ //가위바위보 시작
	   Boolean check = false; 
        //게임 시작
        System.out.println("===============GAME START================");
        System.out.println("어떤걸 내시겠습니까? 가위[1] 바위[2] 보[3]");
     do{
            //1~3의 랜덤 숫자
             computer =(int)(Math.random()*3)+1;
            //사용자 입력값
             user = sc.nextInt();
            //컴퓨터 값
            if(computer == 1) {
                comStr="가위";
                comStr1="찌에";               
            }else if(computer == 2) {
                comStr="바위";
                comStr1="묵에";
            }else if(computer == 3) {
                comStr="보";
                comStr1="빠에";
            }else {
                comStr="시스템 오류";
            }
            //유저의 값
            if(user == 1) {
                userStr="가위";
               
            }else if(user == 2) {
                userStr="바위";
               
            }else if(user == 3) {
                userStr="보";
                
            }else {
                userStr="손가락 오류";
            }
            System.out.println("[유저] "+userStr+"  =VS= "+comStr+" [컴퓨터]");
            if(user >= 1 && user <= 3) {
                if((computer == 1 && user == 2) || (computer == 2 && user == 3) || (computer == 3 && user == 1)) {
                	
                	System.out.print("[가위...");
                	try {
						Thread.sleep(300);      //딜레이 0.7초
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
                	System.out.print("바위...");
                	try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
                	System.out.println("보..!]");
                	try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
                    System.out.println("[승리]");     //이겼을때 : 다음 묵찌바에 (찌에 찌에) 
                    if(userStr.equals("가위")){
                    	userStr1="찌";
                    }else if(userStr.equals("바위")){
                    	userStr1="묵";
                    	
                    }else if(userStr.equals("보")){
                    	userStr1="빠";
                    }
                    check= !check;
                    start2();//win
                    
                    
                }else if(computer == user) {
                	System.out.print("[가위...");
                	try {
    					Thread.sleep(300);
    				} catch (InterruptedException e) {
    					e.printStackTrace();
    				}
                   	System.out.print("바위...");
                   	try {
    					Thread.sleep(300);
    				} catch (InterruptedException e) {
    					e.printStackTrace();
    				}
                   	System.out.println("보..!]");
                   	try {
    					Thread.sleep(300);
    				} catch (InterruptedException e) {
    					e.printStackTrace();
    				}
                    System.out.println("[무승부]");
                    System.out.println("=========================================");
                    System.out.println("어떤걸 내시겠습니까? 가위[1] 바위[2] 보[3]");
                  
                    
                }else {
                	System.out.print("[가위...");
                	try {
    					Thread.sleep(300);
    				} catch (InterruptedException e) {
    					e.printStackTrace();
    				}
                   	System.out.print("바위...");
                   	try {
    					Thread.sleep(300);
    				} catch (InterruptedException e) {
    					e.printStackTrace();
    				}
                   	System.out.println("보..!]");
                   	try {
    					Thread.sleep(300);
    				} catch (InterruptedException e) {
    					e.printStackTrace();
    				}
                	
                    System.out.println("[패배]");   //졌을때 : 다음 묵찌빠에 (찌에 찌에) 
                    if(comStr.equals("가위")){
                    	comStr1="찌";
                    }else if(comStr.equals("바위")){
                    	comStr1="묵"; 	
                    }else if(comStr.equals("보")){
                    	comStr1="빠";
                    }
                    check= !check;
                    start3();//lose
                }
            }   
     }while(!check);
            
     System.out.println("================GAME END=================");
     return;
 
        }
   void start2(){// 묵찌빠 승
	   System.out.println("★★★★★★★★★★★[승]묵찌빠 START★★★★★★★★★★★★");
       System.out.println("어떤걸 내시겠습니까? 가위[1] 바위[2] 보[3]");
      
           //1~3의 랜덤 숫자
            computer =(int)(Math.random()*3)+1;
           //사용자 입력값
            user = sc.nextInt();
           //컴퓨터 값
           if(computer == 1) {
               comStr="가위";
               comStr2="찌";
           }else if(computer == 2) {
               comStr="바위";
               comStr2="묵";
           }else if(computer == 3) {
               comStr="보";
               comStr2="빠";
           }else {
               comStr="시스템 오류";
           }
           //유저의 값
           if(user == 1) {
               userStr="가위";
               userStr2="찌";
           }else if(user == 2) {
               userStr="바위";
               userStr2="묵";
           }else if(user == 3) {
               userStr="보";
               userStr2="빠";
           }else {
               userStr="손가락 오류";
           }
           System.out.println("[유저] "+userStr+"  =VS= "+comStr+" [컴퓨터]");
           if(user >= 1 && user <= 3) {
               if((computer == 1 && user == 2) || (computer == 2 && user == 3) || (computer == 3 && user == 1)) {
            	   
            	   System.out.print("["+userStr1+"에...");
               	try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
               	System.out.print(userStr1+"에...");
               	try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
               	System.out.println(userStr2+"!!!]");
               	try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
            	   System.out.println("[승리]");
                   System.out.println("[가위바위보 다시]");
                   if(userStr2.equals("찌")){
                   	userStr1="찌";
                   }else if(userStr2.equals("묵")){
                   	userStr1="묵";                   	
                   }else if(userStr2.equals("빠")){
                   	userStr1="빠";
                   }
                   start2();//win 한번더
                   
               }else if(computer == user) {
            	   
            	   System.out.print("["+userStr1+"에...");
                  	try {
   					Thread.sleep(300);
   				} catch (InterruptedException e) {
   					e.printStackTrace();
   				}
                  	System.out.print(userStr1+"에...");
                  	try {
   					Thread.sleep(300);
   				} catch (InterruptedException e) {
   					e.printStackTrace();
   				}
                  	System.out.println(userStr2+"!!!]");
                  	try {
   					Thread.sleep(300);
   				} catch (InterruptedException e) {
   					e.printStackTrace();
   				}
                   System.out.println("[승리 랜덤 마일리지]");
                   start4();//렌덤 마일리지
                   
               }else {
            	   System.out.print("["+userStr1+"에...");
                  	try {
   					Thread.sleep(300);
   				} catch (InterruptedException e) {
   					e.printStackTrace();
   				}
                  	System.out.print(userStr1+"에...");
                  	try {
   					Thread.sleep(300);
   				} catch (InterruptedException e) {
   					e.printStackTrace();
   				}
                  	System.out.println(userStr2+"!!!]");
                  	try {
   					Thread.sleep(300);
   				} catch (InterruptedException e) {
   					e.printStackTrace();
   				}
                   System.out.println("[패배]");
                   System.out.println("[가위바위보 다시]");
                   if(comStr2.equals("찌")){
                   	comStr1="찌";
                   }else if(comStr2.equals("묵")){
                   	comStr1="묵"; 	
                   }else if(comStr2.equals("빠")){
                   	comStr1="빠";
                   }
                   start3();//lose
               }
           }   
           
           

   }
   void start3(){// 묵찌빠 패
	   System.out.println("★★★★★★★★★★★[패]묵찌빠 START★★★★★★★★★★★★");
       System.out.println("어떤걸 내시겠습니까? 가위[1] 바위[2] 보[3]");
       
    	   
       
           //1~3의 랜덤 숫자
            computer =(int)(Math.random()*3)+1;
           //사용자 입력값
            user = sc.nextInt();
           //컴퓨터 값
           if(computer == 1) {
               comStr="가위";
               comStr2="찌";
           }else if(computer == 2) {
               comStr="바위";
               comStr2="묵";
           }else if(computer == 3) {
               comStr="보";
               comStr2="빠";
           }else {
               comStr="시스템 오류";
           }
           //유저의 값
           if(user == 1) {
               userStr="가위";
               userStr2="찌";
           }else if(user == 2) {
               userStr="바위";
               userStr2="묵";
           }else if(user == 3) {
               userStr="보";
               userStr2="빠";
           }else {
               userStr="손가락 오류";
           }
           System.out.println("[유저] "+userStr+"  =VS= "+comStr+" [컴퓨터]");
           if(user >= 1 && user <= 3) {
               if((computer == 1 && user == 2) || (computer == 2 && user == 3) || (computer == 3 && user == 1)) {
            	  
            	   System.out.print("["+comStr1+"에...");
                  	try {
   					Thread.sleep(300);
   				} catch (InterruptedException e) {
   					e.printStackTrace();
   				}
                  	System.out.print(comStr1+"에...");
                  	try {
   					Thread.sleep(300);
   				} catch (InterruptedException e) {
   					e.printStackTrace();
   				}
                  	System.out.println(comStr2+"!!!]");
                  	try {
   					Thread.sleep(300);
   				} catch (InterruptedException e) {
   					e.printStackTrace();
   				}
            	   System.out.println("[승리]");
                   System.out.println("[가위바위보 다시]");
                   if(userStr2.equals("찌")){
                      	userStr1="찌";
                      }else if(userStr2.equals("묵")){
                      	userStr1="묵";                   	
                      }else if(userStr2.equals("빠")){
                      	userStr1="빠";
                      }

                   start2();//win 한번더
                   
               }else if(computer == user) {
            	   System.out.print("["+comStr1+"에...");
                 	try {
  					Thread.sleep(300);
  				} catch (InterruptedException e) {
  					e.printStackTrace();
  				}
                 	System.out.print(comStr1+"에...");
                 	try {
  					Thread.sleep(300);
  				} catch (InterruptedException e) {
  					e.printStackTrace();
  				}
                 	System.out.println(comStr2+"!!!]");
                 	try {
  					Thread.sleep(300);
  				} catch (InterruptedException e) {
  					e.printStackTrace();
  				}
                   System.out.println("[패배 기본 마일리지]");
                   start5();//패배 1 마일리지
                   
               }else {
            	   System.out.print("["+comStr1+"에...");
                 	try {
  					Thread.sleep(300);
  				} catch (InterruptedException e) {
  					e.printStackTrace();
  				}
                 	System.out.print(comStr1+"에...");
                 	try {
  					Thread.sleep(300);
  				} catch (InterruptedException e) {
  					e.printStackTrace();
  				}
                 	System.out.println(comStr2+"!!!]");
                 	try {
  					Thread.sleep(300);
  				} catch (InterruptedException e) {
  					e.printStackTrace();
  				}
                   System.out.println("[패배]");
                   System.out.println("[가위바위보 다시]");
                   if(comStr2.equals("찌")){
                      	comStr1="찌";
                      }else if(comStr2.equals("묵")){
                      	comStr1="묵"; 	
                      }else if(comStr2.equals("빠")){
                      	comStr1="빠";
                      }
                   start3();//lose
               }
           }   
           
           

   }
	   
   void start4(){ //렌덤 마일리지 적립 적립
	
	    MileageDao mileagedao = MileageDao.getInstance();
	    UserVo user = Session.loginUser;
	    String userKey = user.getId();
	    MileageVo mileageInfo = new MileageVo();
		   
		Date date =new Date();
		computer = (int) (Math.random() * 15) + 5;
		mileage += computer;
		mileageInfo.setId(Session.loginUser.getId());
	    mileageInfo.setDate(date);//게임 종료 시간 입력
	    mileageInfo.setId(userKey);//유저 아이디
	    mileageInfo.setMiliage(computer);//획득마일리지
	    mileageInfo.setContents("묵찌빠 승리");
	    mileagedao.insertMileage(mileageInfo); // 마일리지 정보 넣어주기 
	    	
		System.out.println("획득 마일리지 : "+computer);
		System.out.println("누적 마일리지 : " + mileage);
	
   }
   
   void start5(){ //패배 1마일리지 적립 적립
	 
	   MileageDao mileagedao = MileageDao.getInstance();
	   UserVo user = Session.loginUser;
	   String userKey = user.getId();
	   MileageVo mileageInfo = new MileageVo();
	   
	   Date date =new Date();
	   computer=1;
	   mileage +=computer;
		mileageInfo.setId(Session.loginUser.getId());
		mileageInfo.setDate(date);// 게임 종료 시간 입력
		mileageInfo.setId(userKey);// 유저 아이디
		mileageInfo.setMiliage(1);// 획득마일리지
		mileageInfo.setContents("묵찌빠 패배");
		mileagedao.insertMileage(mileageInfo); // 마일리지 정보 넣어주기
	    	
	   System.out.println("획득 마일리지 : "+computer);
	   System.out.println("누적 마일리지 : "+mileage);
	  
   }
 }

