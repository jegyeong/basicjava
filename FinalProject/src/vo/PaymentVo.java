package vo;

import java.util.Date;

public class PaymentVo {
	//날짜, 마일리지 정보, 회원  : 
	//테이블 , 매출 
	// 결제 : 결제번호, 회원ID, 결제일, 결제금액, 요청사항, 마일리지결제 ,테이블번호
	
	
	private int no;//오더번호 (pk)
	private int paymentNo;//결제번호
	private Date date;//결제일
	private String id;//회원Id
	private String requests;//요청사항
	private int milieage;//마일리지
	private int tableNo;//테이블 번호


	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getPaymentNo() {
		return paymentNo;
	}
	public void setPaymentNo(int paymentNo) {
		this.paymentNo = paymentNo;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRequests() {
		return requests;
	}
	public void setRequests(String requests) {
		this.requests = requests;
	}
	public int getMilieage() {
		return milieage;
	}
	public void setMilieage(int milieage) {
		this.milieage = milieage;
	}
	public int getTableNo() {
		return tableNo;
	}
	public void setTableNo(int tableNo) {
		this.tableNo = tableNo;
	}
	
	
}
