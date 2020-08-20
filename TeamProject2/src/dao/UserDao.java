package dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import vo.UserRentVo;
import vo.UserVo;
import Session.UserSession;
import database.Database;

public class UserDao {
	
	Database db = Database.getInstance();
	UserSession session = new UserSession();
//	public boolean checkUserId(String id) {
//		boolean result = true;
//		for(int i = 0; i< checkUserList().size(); i++) {
//			if(!checkUserList().get(i).getUserId().equals(id)) {
//				result = false;
//			}
//		}
//		return result;
//	}
	
	public int getUserMileage(String id){
		int mileage = 0;
		UserVo uvo = new UserVo();
		for(int i =0; i< db.userList.size(); i++){
			if(id.equals(db.userList.get(i).getUserId())){
				mileage = db.userList.get(i).getUserMileage();
				break;
			}
		}
		
		return mileage;
	}
	public void setUserMileage(String id,int mileage){
		for(int i =0; i< db.userList.size(); i++){
			if(id.equals(db.userList.get(i).getUserId())){
				db.userList.get(i).setUserMileage(mileage);
				break;
			}
		}
	}
	
	
	


	//유저중복찾기
	public boolean checkUserId(String userId){
		boolean isNotFind = false;
			for(int i = 0; i< db.userList.size(); i++){
				if(!userId.equals(db.userList.get(i).getUserId())){
					isNotFind = false;//중복 아이디 없음
			}else{
				isNotFind = true; //중복 아이디 있음
				break;
			}	
		}
		return isNotFind;
	}
		

	
	public boolean checkLoginuser(String userId,String userPass) {
		boolean isNotFind = false;
		for(int i = 0; i< db.userList.size(); i++){
			if(userId.equals(db.userList.get(i).getUserId())
					&&userPass.equals(db.userList.get(i).getUserPass())){
				isNotFind = true;//중복 아이디 있음
				break;
			}else{
				isNotFind = false; //중복 아이디 없음	
			}	
		}
		return isNotFind;
	}

	
	
	public void insertUser(UserVo user){
		db.userList.add(user);
		
	}
	
	public ArrayList<UserVo> checkUserList() {
		return db.userList;
	}
	


	public int showUserMileage(String userId) {
		int mileage = 0;
		for(int i = 0; i< db.userList.size(); i++) {
			if(userId.equals(db.userList.get(i).getUserId())) {
				mileage = db.userList.get(i).getUserMileage();
				break;
			
			}else {
				mileage = 0;
			}
		}
		return mileage;
	}
	public ArrayList<UserRentVo> userRentList(String userId){
		
		
		ArrayList<UserRentVo> tempArray = new ArrayList<>();
		Date today = new Date();
		Date finishedRented = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd",Locale.KOREA);
		if(db.userRentList.size()!=0) {
			for (int i = 0; i < db.userRentList.size(); i++) {
				
				
				if (userId.equals(db.userRentList.get(i).getUserId())) {
					
					UserRentVo urvo = new UserRentVo();
					urvo.setUserId(db.userRentList.get(i).getUserId());
					urvo.setvSeries(db.userRentList.get(i).getvSeries());
					urvo.setvName(db.userRentList.get(i).getvName());
					urvo.setRentVNum(db.userRentList.get(i).getRentVNum());
					urvo.setRentDate(db.userRentList.get(i).getRentDate());
					urvo.setRentTime(db.userRentList.get(i).getRentTime());
					urvo.setReturnDate(db.userRentList.get(i).getReturnDate());
					urvo.setReturnTime(db.userRentList.get(i).getReturnTime());
					urvo.setRentNum(db.userRentList.get(i).getRentNum());
					urvo.setActualReturnDate(db.userRentList.get(i).getActualReturnDate());
					urvo.setActualReturnTime(db.userRentList.get(i).getActualReturnTime());
					urvo.setRentPrice(db.userRentList.get(i).getRentPrice());
					tempArray.add(urvo);
					
				}//for문 끝
			}
		}else {
				System.out.println("대여내역이 존재하지 않습니다.");
				System.out.println("이전메뉴로 이동합니다.");
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return tempArray;
	}
	
	public void showRentInfos(String id,String rentVNum){ //상세내역전체출력
		String coSerialNum = null;
		for(int i = 0; i<db.coVehicleList.size();i++){
			if(rentVNum.equals(db.coVehicleList.get(i).getCoVNumber())){
				coSerialNum = db.coVehicleList.get(i).getCoSerialNum();
			}
		}
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
	}
	
	public void rentVehicleInfo(String id,String rentVNum){ //렌트한 차량정보
		
		for(int i=0;i<db.userRentList.size();i++){
			if(id.equals(db.userRentList.get(i).getUserId())&&
					rentVNum.equals(db.userRentList.get(i).getRentVNum())){
				
				System.out.println();
				System.out.println(" 대여번호	: "+ db.userRentList.get(i).getRentNum());
				System.out.println(" 차형	: "+ db.userRentList.get(i).getvSeries());
				System.out.println(" 차종	: "+ db.userRentList.get(i).getvName());
				System.out.println(" 차량번호 	: "+ db.userRentList.get(i).getRentVNum());
				
				break;
			}
		}
	}	
	
	
	public void durationInfo(UserRentVo vo){ //렌트기간정보
				
		DateFormat ex_Date = new SimpleDateFormat("yyyyMMdd",Locale.KOREA);
		DateFormat exactDate = new SimpleDateFormat("yyyy년 MM월 dd일 ",Locale.KOREA);
		DateFormat ex_Hour = new SimpleDateFormat("HH:mm",Locale.KOREA);
		DateFormat exactHour = new SimpleDateFormat("HH시 mm분",Locale.KOREA);
		String rentDate = null;
		String returnDate = null;
		String actualDate = null;
		String rentTime = null;
		String returnTime = null;
		String actualTime = null;
				rentDate = vo.getRentDate();
				returnDate = vo.getReturnDate();
				actualDate = vo.getActualReturnDate();
				rentTime = vo.getRentTime();
				returnTime = vo.getReturnTime();
				actualTime = vo.getActualReturnTime();
				
				
				String startDate = "";		String startHour = "";
				String endDate = "";		String endHour = "";
				String overDate = "";		String overHour = "";

				Date dateStart = new Date();		Date hourStart = null;
				Date dateEnd = null;		Date hourEnd = null;
				Date dateOver = null;		Date hourOver = null;
				
				//여기서부터 널포인트다...
				//날짜형식으로 date객체를 만듬
				try {
					dateStart = ex_Date.parse(rentDate);
					dateEnd = ex_Date.parse(returnDate);
				
					hourStart = ex_Hour.parse(rentTime);
					hourEnd = ex_Hour.parse(returnTime);
					if(!actualDate.equals("")){
					dateOver = ex_Date.parse(actualDate);
					hourOver = ex_Hour.parse(actualTime);
					}
					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//변환시킨 date객체를 원하는 날짜형식으로 다시 변환
				startDate = exactDate.format(dateStart);
				endDate = exactDate.format(dateEnd);
				
				startHour = exactHour.format(hourStart);
				endHour = exactHour.format(hourEnd);
				if(!actualDate.equals("")){
				overDate = exactDate.format(dateOver);
				overHour = exactHour.format(hourOver);
				}	
				System.out.println(" 대여기간 : "+ startDate+" "+ startHour);
				System.out.println(" 반납일자 : "+endDate+ " "+endHour);
				if(!actualDate.equals("")){
				System.out.println(" 실반납일	 : "+ overDate +" "+ overHour);
				}
				int overCharge = 0, totalCharge =0;
				if(!actualDate.equals("")){
					long diffD = dateOver.getTime() - dateEnd.getTime(); //초과일-예정반납일 = 초과시간
					long diffDays = diffD/(24*60*60*1000);	//일단위 표현
	
					double diffH = (double)hourOver.getTime()-hourEnd.getTime();
					long diffHour = (long)diffH/(60*60*1000);	//시간단위 표현
	
					int perHour = vo.getRentPrice() / 24; //1시간기준-625
					
					
					if(diffH%(60*60*1000) == 0){
						System.out.println(" 초과시간	: "+diffDays+"일 "+diffHour+"시간");
						overCharge = (int)(perHour * (diffHour+(diffDays*24)));
						totalCharge = overCharge+vo.getRentPrice();
						
					}else{
						System.out.println(" 초과시간	: "+diffDays+"일 "+(diffHour+1)+"시간");
						overCharge = (int)(perHour * (diffHour+1+(diffDays*24)));
						totalCharge = overCharge+vo.getRentPrice();
					}
				}
//				System.out.println(" 결제금액	: "+ db.userRentList.get(i).getRentPrice()+"원");
//				System.out.println(" 추가금액	: "+ overCharge+"원");
				if(!actualDate.equals("")){
				System.out.println(" 최종금액 	: "+ totalCharge+"원"
									+"  [대여금액 : "+ vo.getRentPrice()+"원  "
									+"/ 추가금액 : "+ overCharge+"원]");
				}
				System.out.println();
				System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
				
	}

	public void rentCompInfo(String coSerialNum) { // 렌트차량의 회사정보

		for (int j = 0; j < db.companyList.size(); j++) {
			if (coSerialNum.equals(db.companyList.get(j).getCoSerialNum())) {
				System.out.println();
				System.out.println(" 업체명	: "+ db.companyList.get(j).getCoName());
				System.out.println(" 전화번호	: "+ db.companyList.get(j).getCoTel());
				System.out.println(" 회사주소	: "+ db.companyList.get(j).getCoAddr());
				break;
			}
		}
		
	}
	
	
	public ArrayList<UserRentVo> allRentedList(){
		
		return db.userRentList;
	}
	public void setUserAcutalRentVo(UserRentVo urvo) {
		for(int i = 0; i<db.userRentList.size();i++){
			if(urvo.getUserId().equals( db.userRentList.get(i).getUserId() ) &&
					urvo.getRentVNum().equals( db.userRentList.get(i).getRentVNum()) &&
					urvo.getRentNum().equals(db.userRentList.get(i).getRentNum())){
				System.out.println("바뀌기전 : " + db.userRentList.get(i).getActualReturnDate());
				db.userRentList.get(i).setActualReturnDate(urvo.getActualReturnDate());
				db.userRentList.get(i).setActualReturnTime(urvo.getActualReturnTime());
				System.out.println("바뀐후 : " + db.userRentList.get(i).getActualReturnDate());
				break;
			}
		}
		
	}
	public void insertUserRentVo(UserRentVo urvo){
		db.userRentList.add(urvo);
	}
}
