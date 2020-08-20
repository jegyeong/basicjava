package service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import vo.CarOptionVo;
import vo.CoVehicleVo;
import vo.CompanyVo;
import Session.UserSession;
import dao.CoVehicleDao;
import dao.UserDao;

public class SearchService {
	public Scanner scan = new Scanner(System.in);
	CompanyService csv= new CompanyService();
	
	int select;
	int comSel;
	public void selectRentDate(){
		boolean isPossible = false;
		String rentDate;
		String rentTime;
		String returnDate;
		String returnTime;
		do {
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
		System.out.println("대여일을 입력해 주세요 ex)20200129");
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
		rentDate = scan.nextLine();
		isPossible = chkToday(rentDate);
		if(isPossible == true) {
			
		}else {
			System.out.println("익일날짜부터 입력 가능합니다.1");
		}
		}while(isPossible == false);
		
		
		do {
		isPossible = false;	
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
		System.out.println("대여시간을 입력해주세요 ex) 09:30");
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
		rentTime = scan.nextLine();
		isPossible = chkTime(rentTime);
		if(isPossible == false) {
			System.out.println("00:00 ~ 23:59 의 형식에 맞게 써 주세요");
		}
		}while(isPossible == false);
		
		do {
			isPossible = false;
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.println("반납일을 입력해 주세요 ex)20200129");
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			returnDate = scan.nextLine();
			isPossible = chkReturnDay(rentDate,returnDate);
			if(isPossible == true) {
				
			}else {
				System.out.println("익일날짜부터 입력 가능합니다.2");
			}
			}while(isPossible == false);
		do {
			isPossible = false;	
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.println("반납시간을 입력해주세요 ex) 09:30");
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			returnTime = scan.nextLine();
			isPossible = chkTime(returnTime);
			if(isPossible == false) {
				System.out.println("00:00 ~ 23:59 의 형식에 맞게 써 주세요");
			}
			}while(isPossible == false);
		
		getRentableVehicle(rentDate,rentTime,returnDate,returnTime);
		
	}
	boolean chkReturnDay(String rentDate, String returnDate) {
		 Date rent = new Date();
		 Date returnD = new Date();
		 boolean isFuture = false;
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd",Locale.KOREA);
			try {
				
				returnD = sdf.parse(returnDate);
				rent = sdf.parse(rentDate);
				if(returnD.getTime()>rent.getTime()) {
					isFuture = true;
					
				}else {
					isFuture = false;
					
				}
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
		return isFuture;
	}
	boolean chkToday(String rentDate) {
		 Date today = new Date();
		 Date rent = new Date();
		 boolean isFuture = false;
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd",Locale.KOREA);
			try {
				String thisday = sdf.format(today);
				today = sdf.parse(thisday);
				rent = sdf.parse(rentDate);
				if(today.getTime()<rent.getTime()) {
					isFuture = true;
					
				}else {
					isFuture = false;
					
				}
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
		return isFuture;
	}
	boolean chkTime(String time) {
		Pattern p = Pattern.compile("(0[0-9]|1[0-9]|2[0-3]):([0-5][0-9]$)");
		Matcher m = p.matcher(time);
		 
		return m.find();
	}
	public void getRentableVehicle(String rentDate,String rentTime,String returnDate, String returnTime) {
		VehicleService vsv = new VehicleService();
		
		
		
			System.out.println("〓〓〓〓〓〓  자동차 검색  〓〓〓〓〓〓");
			HashMap<String,String> map = vsv.searchVehicles();
			ArrayList<CompanyVo> temp = csv.getRentCompInfos(map);
			if(temp.size() == 0) {
				System.out.println("선택하신 차량을 소지한 업체가 없습니다. 다시 선택해 주시길 바랍니다.");
				return;
			}
			do {
			
			System.out.println("〓〓〓〓〓〓〓 대여 가능 업체 〓〓〓〓〓〓〓");
			for(int i = 0; i<temp.size(); i++){
				System.out.println(i+1+". " + temp.get(i).getCoName());
			}
			System.out.println("0. 메인으로 돌아가기");
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.println("원하시는 업체번호를 입력해 주세요.");
			select = Integer.parseInt(scan.nextLine());
			comSel = select;
			if(select == 0) {
				System.out.println("처음 화면으로 돌아갑니다.");
				return;
			}else {
				String coSerialNum = temp.get(select-1).getCoSerialNum();	
				//유저렌트 리스트와 컴패니비히클을 비교해서 대여 가능한 제품만 가져 올 수 있게 해야 한다.
				String coName = temp.get(select-1).getCoName();
				this.possibleCarListing(map,coName,coSerialNum,rentDate,returnDate,rentTime,returnTime);
			}
		}while(select!=0);
			
	}
	void possibleCarListing(HashMap<String,String> map, String coName, String coSerialNum,String rentDate,String returnDate,String rentTime,String returnTime) {
		UserDao udao = new UserDao();
		CoVehicleDao cvdao = new CoVehicleDao();
		CoVehicleVo vo;
		ArrayList<CoVehicleVo> rentableArray = new ArrayList<>();
		
		for(int j = 0; j< cvdao.getCoVehicleList(coSerialNum).size(); j++) {
			if(cvdao.getCoVehicleList(coSerialNum).get(j).getvSeries().equals(map.get("series"))&&
			   cvdao.getCoVehicleList(coSerialNum).get(j).getvName().equals(map.get("name"))) {
				//2개
				int getJ = 0;
				int getK = 0;
				boolean isInList = false;
				//같은 시리얼 넘버가 있으면 
				for( int k = 0; k< udao.allRentedList().size(); k++) {
					if(cvdao.getCoVehicleList(coSerialNum).get(j).getCoVNumber().equals(udao.allRentedList().get(k).getRentVNum())){	
						
						 isInList = true;
						 getJ = j;
						 getK = k;
						 break;
					}
				}
				if(isInList == false) {
					vo = new CoVehicleVo();
					vo.setCoSerialNum(coSerialNum);
					vo.setCoVNumber(cvdao.getCoVehicleList(coSerialNum).get(j).getCoVNumber());
					vo.setRentPrice(checkPay(rentDate,rentTime,returnDate,returnTime,cvdao.getCoVehicleList(coSerialNum).get(j).getRentPrice()));
					vo.setvName(cvdao.getCoVehicleList(coSerialNum).get(j).getvName());
					vo.setvSeries(cvdao.getCoVehicleList(coSerialNum).get(j).getvSeries());
					rentableArray.add(vo);
					
				}else {
					if(	!(translateDateType(rentDate).getTime() >= translateDateType(udao.allRentedList().get(getK).getRentDate()).getTime()				//대여일보다 크거나 반납일보다 작지않으면
							&&translateDateType(returnDate).getTime()<= translateDateType(udao.allRentedList().get(getK).getReturnDate()).getTime())	//( 대여일과 반납일 사이가 아니라면)
							&& translateDateType(udao.allRentedList().get(getK).getReturnDate()).getTime()< translateDateType(rentDate).getTime()			//반납 예정일이 선택대여일보다 작으면
							&&(udao.allRentedList().get(getK).getActualReturnDate()!=""&&translateDateType(udao.allRentedList().get(getK).getActualReturnDate()).getTime()
							< translateDateType(rentDate).getTime()))
						
							{
								//true
								vo = new CoVehicleVo();
								vo.setCoSerialNum(coSerialNum);
								vo.setCoVNumber(cvdao.getCoVehicleList(coSerialNum).get(getJ).getCoVNumber());
								vo.setRentPrice(checkPay(rentDate,rentTime,returnDate,returnTime,cvdao.getCoVehicleList(coSerialNum).get(getJ).getRentPrice()));
								vo.setvName(cvdao.getCoVehicleList(coSerialNum).get(getJ).getvName());
								vo.setvSeries(cvdao.getCoVehicleList(coSerialNum).get(getJ).getvSeries());
								rentableArray.add(vo);
								
							}
				}
				
				
			}
		}
			
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.println("번호 " + "\t" + "차종" + "\t\t" + "금액");
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			for(int i = 0; i< rentableArray.size(); i++) {
				
				System.out.println(i+1 +". \t" + rentableArray.get(i).getvName() + "\t\t"
						+ rentableArray.get(i).getRentPrice() + "원");				//일단 시간더하는 부분은 뺌 
			
			}
			System.out.println("01. 업체 리뷰보기");
			System.out.println("0. 뒤로가기");
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.println("원하시는 차량을 입력해 주세요");
			String caSel = scan.nextLine();
			int carSelect = 0;
			if(caSel.equals("0")) {
				return;
			}else if(caSel.equals("01")){
				ReviewService rsv = new ReviewService();
				rsv.searchReview(comSel);
			}else{
				carSelect = Integer.parseInt(caSel);
				UserSession session = new UserSession();
				int loginState;
				int selects = 0;
				do {
					loginState = session.loginUserType;
					if(loginState == 0) {
						UserService usv = new UserService();
						//회원가입, 혹은 로그인 보여줘야함
						System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
						System.out.println("로그인을 하여야만 결제 가능합니다.");
						System.out.println("회원가입이 필요하시다면 1번을 로그인이 필요하시면 2번을 눌러주세요.");
						System.out.println("1. 회원가입");
						System.out.println("2. 로그인");
						System.out.println("0. 처음으로 돌아가기");
						System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
						selects  = Integer.parseInt(scan.nextLine());						
						switch (selects) {
						case 0:
							select = 0;
							break;
						case 1:usv.selectUserType();break;
						case 2:usv.logIn();break;
						
						default:
							break;
						}
					
						
					}else {
						
						System.out.println("선택하신 차량 세부 정보입니다.");
						vo = new CoVehicleVo();
						vo.setCoSerialNum(rentableArray.get(carSelect-1).getCoSerialNum());
						vo.setCoVNumber(rentableArray.get(carSelect-1).getCoVNumber());
						vo.setRentPrice(rentableArray.get(carSelect-1).getRentPrice());
						vo.setvName(rentableArray.get(carSelect-1).getvName());
						vo.setvSeries(rentableArray.get(carSelect-1).getvSeries());
						CoVehicleDao codao = new CoVehicleDao();
						CarOptionVo covo = new CarOptionVo();
						covo = codao.getRentCarOptions(rentableArray.get(carSelect-1).getCoVNumber());
						System.out.println("〓〓〓〓〓〓   대여 정보   〓〓〓〓〓〓");
						System.out.println("시리즈 : " + vo.getvSeries());
						System.out.println("차종    : " + vo.getvName());
						System.out.println("차번호 : " + vo.getCoVNumber());
						System.out.println("업체명 : " + coName);
						System.out.println("대여일 : " + rentDate + " " + rentTime);
						System.out.println("반납일 : " + returnDate + " " + returnTime);
						
						System.out.println();
						System.out.println("〓〓〓〓〓〓   차량 옵션   〓〓〓〓〓〓");
						
						System.out.println(
								"운저석 에어백 : " + changeOX(covo.getDriveAirBag()) + "\n"+
								"조수석 에어백 : " + changeOX(covo.getAssistantAirBag()) + "\n"+
								"후방카메라     : " + changeOX(covo.getRearCamera()) + "\n"+
								"후방센서        : " + changeOX(covo.getRearSensor()) + "\n"+
								"블랙박스        : " + changeOX(covo.getBlackBox()) +"\n"+
								"후륜구동        : " + changeOX(covo.getFourWD()) +"\n"+
								"네비게이션     : " + changeOX(covo.getNavigation()) +"\n"+
								"리모트키        : " + changeOX(covo.getRemoteKey()) +"\n"+
								"스마트키        : " + changeOX(covo.getSmartKey()) +"\n"+
								"열선시트        : " + changeOX(covo.getHeatingSeat()) +"\n"+
								"통풍시트        : " + changeOX(covo.getCoolingSeat()) +"\n"+
								"선루프           : " + changeOX(covo.getSunRoof()) +"\n"+
								"블루투스        : " + changeOX(covo.getBluetooth()));
						
						System.out.println();
						System.out.println("〓〓〓〓〓〓   결제금액   〓〓〓〓〓〓");
						//여기서 날자수 계산해서 실제 결제 금액 가져와야함
						//그다음 다시 getRentPrice에 다시 담은다음 진행
						
						
						System.out.println("대여금액 : " +vo.getRentPrice() + "원");
						System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
						System.out.println();
						System.out.println("결제를 진행하시겠습니까?\n (아니오 선택시 업체 선택 페이지로 돌아갑니다.)");
						System.out.println("1. 예");
						System.out.println("2. 아니오");
						int paySelect = Integer.parseInt(scan.nextLine());
						switch (paySelect) {
						case 1:
							//paymentService
							PayService psv = new PayService();
							System.out.println("결제 창으로 이동합니다.");
							int done = psv.paymentForRent(vo,rentDate,rentTime,returnDate,returnTime);
							if(done == 0){
								select =0;
								selects = 0;
							}
							break;
						case 2:
							selects = 0;
							break;
						default:
							break;
						}
						
					}
						
				}while(selects!=0);
			}
	}
	
	String changeOX(int ox) {
		if(ox == 1) {
		return "O";	
		}else {
			return "X";
		}
		
	}
	private int checkPay(String rentDate, String rentTime,String returnDate,String returnTime,int rentPay) {
		String myRent = rentDate + " " + rentTime;
		String myReturn = returnDate + " " + returnTime;
		
		Date rentD = null;
		Date returnD = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd HH:mm",Locale.KOREA);
		try {
			rentD = format.parse(myRent);
			returnD = format.parse(myReturn);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
			//추가요금 발생
			long rentTerm = (returnD.getTime()-rentD.getTime())/(60*60*1000);
			int finalPay = (int)((rentPay/24) * rentTerm);
			return finalPay;
		
	
	}	
	public Date translateDateType(String str){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd",Locale.KOREA);
		try {
			date = sdf.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	

}
