package h_useful;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateClass {

	public static void main(String[] args) {
		Date today = new Date(); //현재 날짜
		System.out.println(today);
		
		//날짜 -> 포멧 -> 문자열
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss.sss");
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf4 = new SimpleDateFormat("yy-MM-dd hh:mm:ss a");
		
		System.out.println(sdf1.format(today));
		System.out.println(sdf2.format(today));
		System.out.println(sdf3.format(today));
		System.out.println(sdf4.format(today));
		
		//문자열 -> 포멧 -> 날짜
		String str = "2020년 1월 11일";
		SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy년 MM월 dd일");
		try {
			Date dateStr = sdf5.parse(str);
			System.out.println(sdf1.format(dateStr));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Calendar cal = Calendar.getInstance();
		
		//날짜 셋팅
		cal.setTime(new Date());
		cal.set(2020, 0, 10); //2020/1/10(월은 0부터 시작)
		System.out.println(sdf3.format(cal.getTime()));
		
		cal.add(Calendar.YEAR, 1);
		cal.add(Calendar.MONTH, 2);
		cal.add(Calendar.DAY_OF_MONTH, -3);
		cal.add(Calendar.HOUR, 3);
		cal.add(Calendar.MINUTE, 5);
		cal.add(Calendar.SECOND, -10);
		
		System.out.println(sdf3.format(cal.getTime()));
	}

}








