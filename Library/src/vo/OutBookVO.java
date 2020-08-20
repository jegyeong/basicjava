package vo;

public class OutBookVO {
	
	private int outCode;
	private String rentDate; //대여날짜
	private String giveDate; //반납일
	private String returnDate;
	private String renter;
	
	
	public int getOutCode() {
		return outCode;
	}
	public void setOutCode(int outCode) {
		this.outCode = outCode;
	}
	public String getRentDate() {
		return rentDate;
	}
	public void setRentDate(String rentDate) {
		this.rentDate = rentDate;
	}
	public String getGiveDate() {
		return giveDate;
	}
	public void setGiveDate(String giveDate) {
		this.giveDate = giveDate;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	public String getRenter() {
		return renter;
	}
	public void setRenter(String renter) {
		this.renter = renter;
	}
	
	
	
	
}
