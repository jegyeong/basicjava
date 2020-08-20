package game;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import service.IntegerCheck;
import vo.MileageVo;
import vo.UserVo;
import dao.MileageDao;
import data.Session;

public class Minesweeper {
	
	
	int mine_Num; // 마인 수 
	int array_Size;// 배열크기
	int betting_milieage;//배팅 마일리지
	int reward_Mileage; //보상 마일리지
	
	ArrayList<ArrayList<String>> mine_array = new ArrayList<>();; //마인이 들어있는 배열 
	
	Scanner scan = new Scanner(System.in);
	MileageDao mileageDao = MileageDao.getInstance();
	void play() {//게임 내용
		int count = 1;//진행횟수
		boolean play = true;//게임 반복실행 Boolean
		
		do {
			int input = 0; //입력받은 위치 값
			boolean check = false;
			String temp = "";
			do {//배열 위치를 입력받는 메서드
				
				System.out.println("-----------------------------------------------------");
				System.out.println("<<3X3입력 예시>>");
				System.out.println("  1  2  3");
				System.out.println("  4  5  6");
				System.out.println("  7  8  9");
				System.out.println("위치를 입력해주세요. :");
				System.out.println("-----------------------------------------------------");
				
				temp = scan.nextLine().trim();
				check = IntegerCheck.checkInt(temp, 1, (array_Size * array_Size));
				if (check&&!mine_array.get(Integer.parseInt(temp) - 1).get(2).equals("")){
					check = false;
					System.out.println("중복된 숫자입니다.");
				}
			} while (!check);//입력값이 숫자이면서 범위에 맞을시 종료된다.
			
			input = Integer.parseInt(temp);
			
			if (mine_array.get(input - 1).get(1).equals("boom")) {//입력한 값이 위치가 지뢰의 위치인 경우 메서드
				System.out.println("-----------------------------------------------------");
				System.out.println("지뢰를 밣으셨습니다.");
				mine_array.get(input - 1).set(0, "★");
				for (int i = 0; i < array_Size * array_Size; i++) {
					System.out.print(mine_array.get(i).get(0) + "\t");
					if ((i + 1) % array_Size == 0)
						System.out.println();
				}
				loseMileage();
				System.out.println("현재 보유 마일리지는 " + mileageDao.searchUserMileageSum(Session.loginUser.getId()) + " 입니다.");
				System.out.println("-----------------------------------------------------");
				play = false;
			} else {//입력한 값이 위치가 지뢰의 위치가아닌경우 메서드
				System.out.println("-----------------------------------------------------");
				System.out.println("지뢰가 아닙니다.");
				mine_array.get(input - 1).set(2, "cheak");
				mine_array.get(input - 1).set(0, "■");
				for (int i = 0; i < array_Size * array_Size; i++) {
					System.out.print(mine_array.get(i).get(0) + "\t");
					if ((i + 1) % array_Size == 0)
						System.out.println();
				}
				System.out.println("-----------------------------------------------------");
				
				reward(count++);
				
				if(count-1 ==array_Size*array_Size- mine_Num){//만약 모든 지뢰를 찾았을 때 메서드
					play= false;
					System.out.println("-----------------------------------------------------");
					System.out.println("모든 지뢰를 찾으셨습니다.");
					victoryMileage();
					System.out.println("획득마일리지 : "+reward_Mileage+" 입니다.");
					System.out.println("-----------------------------------------------------");
				}else{//아직  모든 지뢰를 찾지 못했을 때  메서드
					do {
						System.out.println("-----------------------------------------------------");
						System.out.println("현재 획득한 마일리지 : " + this.reward_Mileage);
						System.out.println("계속  : 1");
						System.out.println("종료  : 0");
						System.out.println("-----------------------------------------------------");
						temp = scan.nextLine().trim();
						check =IntegerCheck.checkInt(temp);
					} while (!check);
					
					if(Integer.parseInt(temp) == 1){
						System.out.println("계속 진행합니다.");
					}else if(Integer.parseInt(temp) ==0){
						play = false;
						System.out.println("-----------------------------------------------------");
						System.out.println("종료합니다.");
						System.out.println("획득한 마일리지는 : " + reward_Mileage
								+ "입니다.");
						victoryMileage();
						System.out.println("-----------------------------------------------------");
					}
				}
				
			}
		} while (play);
	}
	void createMineArray(){//마인이 들어가있는 Array를 생성한다.
		
		for(int i = 0; i < array_Size*array_Size; i++) {
			ArrayList<String> temp = new ArrayList<>();
			temp.add("□");
			temp.add("Nomal");
			temp.add("");
			mine_array.add(temp);
		}
		
		Set<Integer> min_Pos = new HashSet<Integer>(); 
		
		while(min_Pos.size()<mine_Num){
			min_Pos.add((int)(Math.random()*array_Size*array_Size));
		}
	
		
		Iterator<Integer> it = min_Pos.iterator();
		
		while(it.hasNext()){
			
			mine_array.get(it.next()).set(1, "boom");
		}
		
		
		for(int i = 0; i < array_Size*array_Size;i++){
			System.out.print(mine_array.get(i));
			if((i+1)%array_Size==0)
				System.out.println();
		}
		
	}
	void input_base(){//게임시작을 위한 기본 데이터를 수집한다.
		
		String temp ="";
		boolean check = false;
		do {
			System.out.println("-----------------------------------------------------");
			System.out.println("5를 입력시 5X5의 사각형의 배열이 생성된다.");
			System.out.println("입력범위는 3~6까지 입니다.");
			System.out.println("배열의 크기를  입력해주세요 : ");
			System.out.println("-----------------------------------------------------");
			
			temp = scan.nextLine().trim();
			check = IntegerCheck.checkInt(temp, 3, 6);
			
		} while (!check);////입력된 값이 3~6까지의 숫자인경우 종료
		array_Size = Integer.parseInt(temp);
		 
		do {
			System.out.println("-----------------------------------------------------");
			System.out.println("마인의 갯수 범위는 1 ~ "+((array_Size * array_Size) - 1)+" 입니다.");
			System.out.println("마인의 갯수를 입력해주세요: ");
			System.out.println("-----------------------------------------------------");
			
			 temp = scan.nextLine().trim();
			check = IntegerCheck.checkInt(temp, 1, (array_Size * array_Size) - 1);
			
		} while (!check);//입력된 값이 1 ~ 배열의 크기-1개 까지의 숫자인경우 종료 
		mine_Num = Integer.parseInt(temp);
		
		do {
			System.out.println("-----------------------------------------------------");
			System.out.println("보유 마일리지 : "+ mileageDao.searchUserMileageSum(Session.loginUser.getId()));
			System.out.println("최소금액은 100원 이상입니다. ");
			System.out.println("배당하고자 하는 마일리지를 입력해주세요 : ");
			System.out.println("-----------------------------------------------------");
						
			 temp = scan.nextLine().trim();
			check=IntegerCheck.checkInt(temp, 100, mileageDao.searchUserMileageSum(Session.loginUser.getId()));	
			
		} while (!check);//입력된 값이 100 ~ 최대 마일리지  까지의 숫자인경우 종료 
		betting_milieage = Integer.parseInt(temp);
	}
	public void start(){//start 호출시 실행
		MileageDao mileageDao = MileageDao.getInstance();
		int sum = mileageDao.searchUserMileageSum(Session.loginUser.getId());
		if(sum<=100){
			System.out.println("게임을 진행하기 위해서는 100마일리지 이상 필요합니다.");
			return;
		}
		input_base();
		createMineArray();
		play();
	}
	void victoryMileage(){
	
		MileageDao mileagedao = MileageDao.getInstance();
		UserVo user = Session.loginUser;
		String userKey = user.getId();
		MileageVo mileageInfo = new MileageVo();

		Date date = new Date();

		mileageInfo.setDate(date);// 게임 종료 시간 입력
		mileageInfo.setId(userKey);// 유저 아이디
		mileageInfo.setMiliage(reward_Mileage);// 획득마일리지
		mileageInfo.setContents("지뢰찾기 승리");
		mileagedao.insertMileage(mileageInfo); // 마일리지 정보 넣어주기
		mileagedao.searchUserMileage(Session.loginUser.getId());// 마일리지 정보 최신화

	}
	void loseMileage(){
		
		MileageDao mileagedao = MileageDao.getInstance();
		UserVo user = Session.loginUser;
		String userKey = user.getId();
		MileageVo mileageInfo = new MileageVo();

		Date date = new Date();

		mileageInfo.setDate(date);// 게임 종료 시간 입력
		mileageInfo.setId(userKey);// 유저 아이디
		mileageInfo.setMiliage(-betting_milieage);// 획득마일리지
		mileageInfo.setContents("지뢰찾기 패배");
		mileagedao.insertMileage(mileageInfo); // 마일리지 정보 넣어주기
		mileagedao.searchUserMileage(Session.loginUser.getId());// 마일리지 정보 최신화

	}
	void reward(int count){	// 보상을 계산하는 메서드
		if (array_Size == 3) {
			this.reward_Mileage += (int) (mine_Num * betting_milieage * 0.05 * count);		
		} else if (array_Size == 4) {
			this.reward_Mileage += (int) (mine_Num * betting_milieage * 0.06 * count);
		} else if (array_Size == 5) {
			this.reward_Mileage += (int) (mine_Num * betting_milieage * 0.07 * count);
		} else if (array_Size == 6) {
			this.reward_Mileage += (int) (mine_Num * betting_milieage * 0.08 * count);
		}
		
	}

	
	
	
	
}
