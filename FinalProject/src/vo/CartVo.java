package vo;



public class CartVo {//pk

	// 결제메뉴 : 결제메뉴번호, 결제번호, 메뉴번호, 수량
	
	private int no;//오더번호 (pk)
	private int paymentNo;//결제번호
	private int foodNo;//음식번호
	private int count;//수량
	
	
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
	public int getFoodNo() {
		return foodNo;
	}
	public void setFoodNo(int foodNo) {
		this.foodNo = foodNo;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
}
