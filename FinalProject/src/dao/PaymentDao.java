package dao;

import java.util.ArrayList;

import vo.CartVo;
import vo.PaymentVo;
import data.Database;

public class PaymentDao {
	private static PaymentDao instance;

	private PaymentDao() {
		
	}

	public static PaymentDao getInstance() {
		if (instance == null) {
			instance = new PaymentDao();
		}
		return instance;

	}

	Database database = Database.getInstance();


	public void insertPayment(PaymentVo payment) {
		
		ArrayList<CartVo> notlist = notPaymentList();
		
		if(!database.tb_payment.isEmpty()){
			payment.setPaymentNo(database.tb_payment.get(database.tb_payment.size()-1).getPaymentNo()+1);//중복없이 기본키를 입력한다.
			
			for(int i = 0; i<notlist.size();i++){
				notlist.get(i).setPaymentNo(database.tb_payment.get(database.tb_payment.size()-1).getPaymentNo()+1);
			}
		}else{
			payment.setPaymentNo(100);
			for(int i = 0; i<notlist.size();i++){
				notlist.get(i).setPaymentNo(100);
			}
			
		}
		
		database.tb_payment.add(payment);
	}
	public void deletePayment(PaymentVo payment) {
		database.tb_payment.remove(payment);
	}
	public ArrayList<PaymentVo> selectPaymentList() {
		return database.tb_payment;
	}
	public PaymentVo searchPaymentNoInfo(int paymentNo){
		for(int i = 0 ; i < database.tb_payment.size();i++){
			if( database.tb_payment.get(i).getPaymentNo()==paymentNo){
				return database.tb_payment.get(i);
			}
		}
		
		return  null;
	}
	
	public ArrayList<CartVo> notPaymentList() {//결제 전인  cartVo를 list로 리런
		ArrayList<CartVo> notPayment  = new ArrayList<>();
		for(int i = 0; i < database.tb_cart.size();i++){
			if(database.tb_cart.get(i).getPaymentNo() == 0){ 
				notPayment.add(database.tb_cart.get(i));                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
			}
		}
		return notPayment;
	}
	
}
