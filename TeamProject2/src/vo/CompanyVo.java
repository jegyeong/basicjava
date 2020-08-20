package vo;

public class CompanyVo {
	String userId;
	String coName,coTel,coAddr;
	String coNum,coSerialNum;  // cpSerialNum = Date("yyyyMMdd") +coNum

	public CompanyVo() {
		super();
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCoName() {
		return coName;
	}
	public void setCoName(String coName) {
		this.coName = coName;
	}
	public String getCoTel() {
		return coTel;
	}
	public void setCoTel(String coTel) {
		this.coTel = coTel;
	}
	public String getCoAddr() {
		return coAddr;
	}
	public void setCoAddr(String coAddr) {
		this.coAddr = coAddr;
	}
	public String getCoNum() {
		return coNum;
	}
	public void setCoNum(String coNum) {
		this.coNum = coNum;
	}
	public String getCoSerialNum() {
		return coSerialNum;
	}
	public void setCoSerialNum(String coSerialNum) {
		this.coSerialNum = coSerialNum;
	}	

}
