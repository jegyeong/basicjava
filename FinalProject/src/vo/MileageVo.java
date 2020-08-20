package vo;

import java.util.Date;

public class MileageVo {
	private int no;//pk
	private String id;//유저아이디
	private int miliage;//마일리지
	private String  contents;//내용 
	private Date date;//날짜
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getMiliage() {
		return miliage;
	}
	public void setMiliage(int miliage) {
		this.miliage = miliage;
	}
	
}
