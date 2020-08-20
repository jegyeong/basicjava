package game.sutvivarGame;

import java.util.Scanner;

public class StartClas {
	Scanner s = new Scanner(System.in);
	
	public void Start(){
		System.out.println(" 게임을 시작합니다. ");
		System.out.println(" 게임을 시작합니다. ");
		System.out.println(" 게임을 시작합니다. ");
		System.out.println(" 게임의 설명을 듣기 위해서 아무키나 눌러주세요. ");
		
		
		
		s.nextLine();
		
		System.out.println(" 게임을 시작하면 캐릭터를 선택해야 합니다. ");
		System.out.println(" 각 캐릭터는 각자의 고유 능력을 보유합니다. ");
		System.out.println(" 캐릭터의 능력치를 확인하고 싶다면 해당 캐릭터의 선택번호를 한번 더 추가하세요 ");
		System.out.println(" 예시) 1번 캐릭터의 정보를 보고싶다. 11를 입력한다. ");
		System.out.println(" 계속 진행하기 위해서 아무키나 눌러주세요.");
		
		s.nextLine();
	
		System.out.println(" =============================================================");
		System.out.println("              기본적인 규칙");
		System.out.println(" 캐릭터마다 각자 갖고 있는 공격력과 Hp가 다릅니다.");
		System.out.println(" 1.공격 2.방어 3.기모으기 4.스킬 선택지가 있습니다.");
		System.out.println(" 공격은 기본적으로 공격포인트가 있어야 공격이 가능합니다.");
		System.out.println(" 방어는 언제든 사용가능합니다. 상대방의 공격을 무력화합니다.");
		System.out.println(" 기모으기는 공격포인트를 쌓을 수 있습니다. 공격을 당할 수 있습니다.");
		System.out.println(" 스킬은 각 캐릭터가 갖고 있는 특수기술입니다. 사용하기 위해 적당한 포인트가 필요합니다.");
		System.out.println(" 상대방이 공격을 할 지, 방어를 할 지, 포인트를 모을 지를 예상하여 공격하는 것이");
		System.out.println(" 핵심인 게임입니다. ");
		System.out.println(" 이기면 포인트가 1000이 쌓이고, 10턴 안에 이기면 2000을 받게 됩니다.");
		System.out.println(" 지게 된다면 포인트를 받지 못합니다.");
		System.out.println(" 계속 진행하기 위해서 아무키나 눌러주세요.");
		System.out.println(" =============================================================");
		
		 s.nextLine();
		
		
		
	}

}
