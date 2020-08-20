package e_oop;

import java.util.Scanner;

public class MBTI {
	public static void main(String[] args){
	Scanner s = new Scanner(System.in);
	
	
//	E(외향): y / I(내향) : n 
//	나는 말하기를 좋아해 실수 할때가 종종 있다 (y/n)
//	오랜 시간 혼자 일하다 보면 외롭고 지루하다 (y/n)
//	나는 활동적인 편이다 (y/n)
//	
//	N(직관): y / S(감각) : n

//	
//	F(감정) y / T(사고) n

//	
//	J(판단) y/  P(인식) n

	int EorI =0;
	int NorS =0;
	int ForT =0;
	int JorP =0;
	
	
//	E(외향): y / I(내향) : n 
	
	System.out.println("나는 말하기를 좋아해 실수 할때가 종종 있다 (y/n)");
	String input1 = s.nextLine();
	if (input1.equalsIgnoreCase ("Y")){
		EorI += 1;
	}
	else if (input1.equalsIgnoreCase ("N")){
		EorI -= 1;
	}
	else System.out.println("Y(y)또는N(n)으로만 입력하시오");
	
	
	System.out.println("오랜 시간 혼자 일하다 보면 외롭고 지루하다 (y/n)");
	String input2 = s.nextLine();
	if (input2.equalsIgnoreCase ("Y")){
		EorI += 1;
	}
	else if (input2.equalsIgnoreCase ("N")){
		EorI -= 1;
	}
	else System.out.println("Y(y)또는N(n)으로만 입력하시오");
	
	
	System.out.println("나는 활동적인 편이다 (y/n)");
	String input3 = s.nextLine();
	if (input3.equalsIgnoreCase ("Y")){
		EorI += 1;
	}
	else if (input3.equalsIgnoreCase ("N")){
		EorI -= 1;
	}
	else System.out.println("Y(y)또는N(n)으로만 입력하시오");
	
	
	
	
	
	
	
//	N(직관): y / S(감각) : n

	
	System.out.println("나는 경험으로 판단하는것을 좋아한다. (y/n)");
	String input4 = s.nextLine();
	if (input4.equalsIgnoreCase ("Y")){
		NorS += 1;
	}
	else if (input4.equalsIgnoreCase ("N")){
		NorS -= 1;
	}
	else System.out.println("Y(y)또는N(n)으로만 입력하시오");
	
	
	System.out.println("나는 추상적인 표현보다 사실적 묘사를 잘한다. (y/n)");
	String input5 = s.nextLine();
	if (input5.equalsIgnoreCase ("Y")){
		NorS += 1;
	}
	else if (input5.equalsIgnoreCase ("N")){
		NorS -= 1;
	}
	else System.out.println("Y(y)또는N(n)으로만 입력하시오");
	
	
	System.out.println("나는 약도를 구체적으로 그릴수 있다. (y/n)");
	String input6 = s.nextLine();
	if (input6.equalsIgnoreCase ("Y")){
		NorS += 1;
	}
	else if (input6.equalsIgnoreCase ("N")){
		NorS -= 1;
	}
	else System.out.println("Y(y)또는N(n)으로만 입력하시오");
	
	
	
	
	
	
	
	
//	F(감정) y / T(사고) n
//	
//	
//	
	
	System.out.println("나는 공감능력이 좋은 편이다 . (y/n)");
	String input7 = s.nextLine();
	if (input7.equalsIgnoreCase ("Y")){
		ForT += 1;
	}
	else if (input7.equalsIgnoreCase ("N")){
		ForT -= 1;
	}
	else System.out.println("Y(y)또는N(n)으로만 입력하시오");
	
	
	System.out.println("나는 상황보다 타인의 감정을 고려한 의사결정을 내린다. (y/n)");
	String input8 = s.nextLine();
	if (input8.equalsIgnoreCase ("Y")){
		ForT += 1;
	}
	else if (input8.equalsIgnoreCase ("N")){
		ForT -= 1;
	}
	else System.out.println("Y(y)또는N(n)으로만 입력하시오");
	
	
	System.out.println("나는 경쟁하기보다  포기하고 양보하는 편이다. (y/n)");
	String input9 = s.nextLine();
	if (input9.equalsIgnoreCase ("Y")){
		ForT += 1;
	}
	else if (input9.equalsIgnoreCase ("N")){
		ForT -= 1;
	}
	else System.out.println("Y(y)또는N(n)으로만 입력하시오");
	
	
	
	
	
//	J(판단) y/  P(인식) n
//	나는 친구들과 여행시 계획을 주도적으로 세우는 편이다. 
//	나는 정리정돈이 잘 되어있어 물건을 잘 찾는다. 
//	나는 계획을 변경하면 마음이 불편하다. 
	
	
	System.out.println("나는 친구들과 여행시 계획을 주도적으로 세우는 편이다. (y/n)");
	String inpu1 = s.nextLine();
	if (inpu1.equalsIgnoreCase ("Y")){
		JorP += 1;
	}
	else if (inpu1.equalsIgnoreCase ("N")){
		JorP -= 1;
	}
	else System.out.println("Y(y)또는N(n)으로만 입력하시오");
	
	
	System.out.println("나는 정리정돈이 잘 되어있어 물건을 잘 찾는다. (y/n)");
	String inpu2 = s.nextLine();
	if (inpu2.equalsIgnoreCase ("Y")){
		JorP += 1;
	}
	else if (inpu2.equalsIgnoreCase ("N")){
		JorP -= 1;
	}
	else System.out.println("Y(y)또는N(n)으로만 입력하시오");
	
	
	System.out.println("나는 계획을 변경하면 마음이 불편하다. (y/n)");
	String inpu3 = s.nextLine();
	if (inpu3.equalsIgnoreCase ("Y")){
		JorP += 1;
	}
	else if (inpu3.equalsIgnoreCase ("N")){
		JorP -= 1;
	}
	else System.out.println("Y(y)또는N(n)으로만 입력하시오");
	
	
	
	
	
	
	
	
	
	String a = null;
	String b = null;
	String c = null;
	String d = null;
	
	if (EorI>=1){
		a = "E";
	}
	else if (EorI<0){
		a = "I";
	}
	
	
	if (NorS>=1){
		b = "S";
	}
	else if (NorS<0){
		b = "N";
	}
	
	
	
	if (ForT>=1){
		c = "F";
	}
	else if (ForT<0){
		c = "T";
	}
			
	
	if (JorP>=1){
		d = "J";
	}
	else if (JorP<0){
		d = "P";
	}
				
			System.out.println("당신의 MBTI타입은"+a+b+c+d);
			
	
	
	
	
	
	String result;
	
	switch(a+b+c+d){
	
	case "ISTJ" : System.out.print(result= "당신은 소금형입니다\n"
											+"대표 인물 : 조지 워싱턴, 조지 부시\n"
											+"대표 표현 : 세상의 소금, 완벽주의자\n"
											+"ISTJ 선호경향이 있는 사람들은 매우 신뢰성이 있고, 사실에 대한 완전하고, 현실적이고, \n"
											+ "실용적인 면을 가지고 있습니다. 어떠한 분량의 사실이라도 몰두하고, 기억하며, 이용하고,\n"
											+ "정확도에 대해 매우 세심합니다. 위기상황에 대처할 때에도 차분하며 안정되어 있습니다.\n"
											+ "그들이 어떤 사람인가를 아는 데는 상당한 시간이 걸립니다. 그들은 외면적으로 볼 때 차분하게 보이지만,\n"
											+ "내면적으로는 상당히 바쁩니다.");
	break;
	
	case "ISTP" : System.out.print(result= "당신은 백과사전형입니다\n"
			+ "대표 인물 : 톰 크루즈, 제임스 딘\n"
			+"대표 표현 : 백과사전형, 관망주의자, 모험가\n"
			+"조용하고 말이 없으며 논리적이고 분석적이고 객관적으로 인생을 관찰하는 유형입니다.\n"
			+ "사실적인 정보를 조직하기 좋아하는 반면 일과 관계 되지 않는 이상 자신을 개방하지 않는 편입니다.\n"
			+ "그래서 가까운 친구들 외에는 대체로 사람들과 사귀지 않는 편입니다.\n"
			+ "일상생활에 있어 매우 적응력이 강합니다.");
	break;
	
	case "ESTP" : System.out.print(result= "당신은활동가형입니다\n"
			+"대표 인물 : 고갱, 어니스트 헤밍웨이, 잭 니콜슨\n"
			+"대표 표현 : 활동가, 호인호걸형\n"
			+"ESTP 선호경향을 지닌 사람들은 관대하고 느긋하며 어떤 사람이나 사건에 대해서 별로 선입관을 갖지 않으며 개방적입니다.\n"
			+"자신에게나 타인에게 있어 관용적이며, 일을 있는 그대로 보고 받아들입니다.\n"
			+ "그래서 갈등이나 긴장이 일어나는 상황을 잘 무마하는 능력이 있습니다.\n"
			+ "‘꼭 이렇게 되어야 하고, 저렇게 되어야 된다.’라는 규범을 적용하기보다 누구나 만족할 수 있는 해결책을 모색합니다.\n"
			+ "또한 타협하고 적응하는 능력이 있습니다. 주의집중을 현재 상황에 맞추고, \n"
			+ "현실을 있는 그대로 보는 이 유형의 자연스러운 경향으로 인해 현실적으로 야기되는 문제 해결에 뛰어난 능력을 발휘하기도 합니다");
	break;
			
	case "ESTJ" : System.out.print(result= "당신은사업가형입니다\n"
			+"대표 인물 : 해리 S 트루먼, 존 D 록펠러\n"
			+"대표 표현 : 사업가, 행정가, 관리자\n"
			+"ESTJ 선호경향이 있는 사람들은 일을 조직하고 프로젝트를 계획하고 출범시키는 능력이 뛰어납니다.\n"
			+ "현실적이고 사실적이며 체계적, 논리적으로 사업이나 조직체를 이끌어가는 타고난 재능을 가졌기 때문입니다.\n"
			+ "혼돈스러운 상태나 불분명한 상태 또는 실용성이 없는 분야에는 큰 흥미가 없습니다. \n"
			+ "그러나 필요시에는 언제나 응용하는 힘이 있습니다. 분명한 규칙을 중요시하고 그에 따라 행동하고 일을 추진하고 완성해 나갑니다.\n"
			+ "어떤 계획이나 결정을 내릴 때 확고한 사실에 바탕을 두고 이행합니다. \n"
			+ "대체로 결과를 현재 볼 수 있는 일을 즐기는 편입니다.");
	break;
	
	case "ISFJ" : System.out.print(result= "당신은전통주의형입니다\n"
			+"대표 인물 : 찰스 디킨스, 마이클 조던\n"
			+"대표 표현 : 전통주의자, 보수주의자\n"
			+"ISFJ유형은 책임감이 강하고 온정적이며 헌신적입니다. \n"
			+ "세부적이고 치밀성과 반복을 요하는 일을 끝까지 해 나가는 인내력이 높습니다.\n"
			+ "이들이 가진 침착성과 인내력은 가정이나 집단에 안정성을 가져다줍니다.\n"
			+ "다른 사람의 사정을 고려하며 자신과 타인의 감정의 흐름에 민감합니다. \n"
			+ "일처리에 있어 현실감각을 가지고 실제적이고 조직적으로 이행합니다. \n"
			+ "경험을 통해서 자신이 틀렸다고 인정하기까지 어떠한 난관이 있어도 꾸준히 밀고 나가는 유형입니다. \n"
			+ "온순하고 차분합니다.");
	break;
	
	case "ISFP" : System.out.print(result= "당신은 성인군자형입니다\n"
			+"대표 인물 : 베토벤, 마리 앙루와트, 마를린 먼로\n"
			+"대표 표현 : 성인군자, 유유자적\n"
			+"ISFP형을 선호하는 사람들은 말보다는 행동으로 따뜻함을 나타내며, 마음이 따뜻하고 동정적입니다.\n"
			+ "마치 양털안감을 넣은 오버코트처럼 속마음이 따뜻한 사람들입니다. \n"
			+ "그러나 상대방을 잘 알게 될 때까지 이 따뜻함을 잘 드러내지 않는 경향이 있습니다.");
	break;
	
	case "ESFP" : System.out.print(result= "당신은 사교형입니다\n"
			+"대표 인물 : 골디 혼, 밥 호프\n"
			+"대표 표현 : 사교형, 낙천주의자\n"
			+"ESFP유형은 친절하고 수용적이며 현실적이고 실제적입니다. \n"
			+ "어떤 상황에도 잘 적응하며 타협적입니다. 선입견이 별로 없으며 개방적이고 관용적이며 대체로 사람들을 잘 받아들입니다. \n"
			+ "주위에서 진행되고 있는 일들을 알고자 하고 또한 열심히 참견하고 끼어들곤 합니다.\n"
			+ "다른 사람의 일이나 활동에 관심이 많으며 새로운 사건 혹은 물건에도 관심과 호기심이 많기 때문입니다. \n"
			+ "이론이나 책을 통해 배우기보다 경험 등의 실생활을 통해 배우는 것을 선호합니다.");
	break;

	
	case "ESFJ" : System.out.print(result= "당신은 친선도모형입니다\n"
			+"대표 인물 : 빌 클린턴, 데니 글로버\n"
			+"대표 표현 : 친선도모, 현대판 현모양처\n"
			+"ESFJ유형은 유난히 동정심과 동료애가 많습니다. \n"
			+ "친절하고 재치가 있으며, 다른 사람들에게 관심을 쏟고 인화를 도모하는 일을 중요하게 여깁니다.\n"
			+ "양심적이고 정리정돈을 잘합니다. 참을성이 많고 다른 사람들을 잘 돕습니다. \n"
			+ "또한 다른 사람들의 지지를 받으면 일에 열중합니다. \n"
			+ "그러나 다른 사람들의 무관심한 태도에는 민감합니다.");

	break;
	
	case "INFJ" : System.out.print(result= "당신은 예언자형입니다\n"
			+"대표 인물 : 테레사 수녀, 마틴 루터 킹\n"
			+"대표 표현 : 예언자, 통찰력\n"
			+"INFJ유형의 사람들은 창의력과 통찰력이 뛰어납니다.\n"
			+ "강한 직관력으로 의미와 진실된 관계를 추구합니다. \n"
			+ "뛰어난 영감으로 말없이 타인에게 영향력을 끼칩니다. 독창성과 사적인 독립심이 강합니다. \n"
			+ "또한 확고한 신념과 뚜렷한 원리원칙을 생활 속에 가지고 있으면서 공동의 이익을 가져오는 일에 심혈을 기울입니다. \n"
			+ "인화와 동료애를 중시하는 경향으로 존경을 받고 사람들이 따릅니다. \n"
			+ "열정과 신념으로 자신들이 믿는 영감을 구현 시켜 나갈 때 위대한 정신적 지도자들이 이 유형에서 많이 나옵니다.\n"
			+ "남에게 강요하기보다 행동과 권유로 사람들의 마음을 움직여 따르게 만드는 지도력이 있습니다.");

	break;
	
	case "INFP" : System.out.print(result= "당신은 이상주의형입니다\n"
			+"대표 인물 : 윌리엄 세익스피어, 헬런 켈러\n"
			+"대표 표현 : 이상주의자, 몽상가\n"
			+"INFP유형은 마음이 따뜻하나, 상대방을 잘 알기 전에는 표현을 잘하지 않습니다.\n"
			+ "조용하며, 자신이 관계하는 사람이나 일에 대하여 강하고 성실합니다.\n"
			+ "또한 자신이 지향하는 이상에 대하여는 정열적인 신념을 지니고 있습니다.");

	break;

	
	
	
	
	case "ENFP" : System.out.print(result= "당신은 스파크형입니다\n"
			+"ENFP 유형은 열성적이고 창의적입니다. \n"
			+ "풍부한 상상력과 영감을 가지고 새로운 프로젝트를 잘 시작합니다. \n"
			+ "풍부한 충동적 에너지를 가지고 즉흥적으로 일을 재빠르게 해결하는 솔선수범력과 상상력이 있습니다.\n"
			+ "관심이 있는 일이면 무엇이든 척척 해내는 열성파입니다. \n"
			+ "뛰어난 통찰력으로 그 사람 안에 있는 성장 발전할 가능성을 들여다봅니다.\n"
			+ "또한 자신의 열성으로 다른 사람들도 어떤 프로젝트에 흥미를 가지게 하고 다른 사람을 잘 도와줍니다.");

	break;


			
	case "ENFJ" : System.out.print(result= "당신은 언변능숙형입니다\n"
			+"ENFJ 유형은 동정심과 동료애가 많으며, 친절하고 재치 있습니다.\n"
			+ "민첩하고 참을성이 많고 성실합니다. 사람들과의 인화를 중요시 여기며, 다른 사람들의 의견을 존중하고 그 가치를 봅니다. \n"
			+ "공동의 선(善)을 위해서는 대체로 상대방 의견에 동의하는 경향이 있습니다.\n"
			+ "새로운 아이디어에 대한 호기심이 많습니다. 쓰기 보다는 말로써 생각을 잘 표현합니다. \n"
			+ "편안하고 능란하게 계획을 제시하거나 조직을 이끌어 가는 능력이 있습니다.");

	break;

	
	
	case "INTJ" : System.out.print(result= "당신은 과학자형입니다\n"
			+"INTJ유형은 행동과 사고에 있어 독창적입니다. 내적인 신념과 비전은 산이라도 움직일 만큼 강합니다.\n"
			+ "16가지 유형 중에서 가장 독립적이고 단호합니다. 때때로 어떤 문제에 대하여 아주 고집에 셉니다. \n"
			+ "자신이 가진 영감과 목적을 실현시키려는 의지와 결단력과 인내심을 가지고 있습니다.\n"
			+ "자신과 타인의 능력을 중요시하며, 목적달성을 위하여 온 시간과 노력을 다 바쳐 일합니다. \n"
			+ "직관력과 통찰력이 활용되는 분야에서 능력을 발휘하는 편입니다.");



	break;

	
	case "INTP" : System.out.print(result= "당신은 아이디어형입니다\n"
			+"INTP 선호경향이 있는 사람들은 조용하고 과묵하나 관심이 있는 분야에 대해서는 말을 잘합니다.\n"
			+ "사람들을 중심으로 한 가치보다는 아이디어에 관심이 많으며 매우 분석적이고 논리적이며 객관적 비평을 잘합니다.\n"
			+ "일의 원리와 아이디어에 관심이 많으며, 실체보다는 실체가 안고 있는 가능성에 관심이 많습니다. \n"
			+ "이해가 빠르고 높은 직관력으로 통찰하는 재능과 지적 관심이 많습니다.\n"
			+ "개인적인 인간관계나 파티 혹은 잡담 등에는 흥미가 별로 없습니다. \n"
			+ "사람을 사귀는 데 있어서 그들은 보통 아이디어를 토론하고 나누는 소수의 가까운 사람들을 주위에 두고 있습니다.\n"
			+ "때로 어떤 아이디어에 몰입하여 주위에서 돌아가고 있는 일을 모를 때가 많습니다.");


	break;

	
	case "ENTP" : System.out.print(result= "당신은발명가형입니다\n"
			+"ENTP유형은 독창적인 혁신가이며, 창의력이 풍부하고 항상 새로운 가능성을 찾고 새로운 시도를 즐기는 유형입니다. \n"
			+ "넓은 안목을 가지고 있으며 다방면에 재능이 있습니다. 풍부한 상상력과 어떤 프로젝트를 시도하는 솔선력이 강합니다. \n"
			+ "민첩하고 여러 가지 일에 재능을 발휘하며 자신감이 넘쳐 납니다. 사람들의 동향에 대해 기민하고 박식한 편입니다.\n"
			+ "다른 사람을 판단하기보다 이해하려고 노력합니다.");

	break;

	
	case "ENTJ" : System.out.print(result= "당신은 지도자형입니다\n"
			+"ENTJ 유형은 활동적이며 행정적인 일과 장기계획을 선호하며 논리적이고 분석적입니다. \n"
			+ "사전 준비를 철저히 하며 계획하고 조직하고 체계적으로 목적달성을 추진시키는 지도자들이 많습니다.\n"
			+ "비능률적이거나 확실치 않는 상황에 대해서는 별로 인내심이 없습니다. \n"
			+ "그러나 상황이 필요로 할 때는 강하게 대처합니다. 솔직하고 결정력과 통솔력이 있으며, 거시적 안목으로 일을 밀고 나갑니다. \n"
			+ "관념 자체에 집중하는 경향이 있으며, 관념 이면의 사람에게는 관심이 별로 없습니다.");

	break;

	
	
	
	
	
	
	
	
	
	
	}}}
	
	
	
	
	
	