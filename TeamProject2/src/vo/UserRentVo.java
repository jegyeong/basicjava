package vo;


public class UserRentVo {
	String rentDate;			//대여일
	String returnDate;			//반납일		예정
	String rentTime;			//대여시간
	String returnTime;			//반납시간	예정
	
	String vSeries,vName;		//차형,차종
	String rentVNum;			//렌트한 차량번호
	String userId;				//대여자 아이디
	String rentNum;				//렌트 고유번호
	String actualReturnDate;	//실제 반납일
	String actualReturnTime;	//실제 반납시간
	int rentPrice;				//렌트대여료
	
	public UserRentVo() {
		super();
	}
	public String getRentDate() {
		return rentDate;
	}
	public void setRentDate(String rentDate) {
		this.rentDate = rentDate;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	public String getRentTime() {
		return rentTime;
	}
	public void setRentTime(String rentTime) {
		this.rentTime = rentTime;
	}
	public String getReturnTime() {
		return returnTime;
	}
	public void setReturnTime(String returnTime) {
		this.returnTime = returnTime;
	}
	
	public String getvSeries() {
		return vSeries;
	}
	public void setvSeries(String vSeries) {
		this.vSeries = vSeries;
	}
	public String getvName() {
		return vName;
	}
	public void setvName(String vName) {
		this.vName = vName;
	}
	public String getRentVNum() {
		return rentVNum;
	}
	public void setRentVNum(String rentVNum) {
		this.rentVNum = rentVNum;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRentNum() {
		return rentNum;
	}
	public void setRentNum(String rentNum) {
		this.rentNum = rentNum;
	}
	
	public String getActualReturnDate() {
		return actualReturnDate;
	}
	public void setActualReturnDate(String actualReturnDate) {
		this.actualReturnDate = actualReturnDate;
	}
	public String getActualReturnTime() {
		return actualReturnTime;
	}
	public void setActualReturnTime(String actualReturnTime) {
		this.actualReturnTime = actualReturnTime;
	}
	public int getRentPrice() {
		return rentPrice;
	}
	public void setRentPrice(int rentPrice) {
		this.rentPrice = rentPrice;
	}
	
}
