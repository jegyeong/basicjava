package vo;


public class CoVehicleVo {
	String vSeries,vName;
	String coVNumber;
	int rentPrice;
	String coSerialNum;
	public CoVehicleVo() {
		super();
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

	public String getCoVNumber() {
		return coVNumber;
	}
	public void setCoVNumber(String coVNumber) {
		this.coVNumber = coVNumber;
	}
	public int getRentPrice() {
		return rentPrice;
	}
	public void setRentPrice(int rentPrice) {
		this.rentPrice = rentPrice;
	}
	public String getCoSerialNum() {
		return coSerialNum;
	}
	public void setCoSerialNum(String coSerialNum) {
		this.coSerialNum = coSerialNum;
	}
	
	
	
}
