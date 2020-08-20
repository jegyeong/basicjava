package vo;

public class BookVO {
	
	//도서
	
	private String title; //책제목
    private String writer; //저자
    private String company; //출판사
    private int code; //도서코드
    private String publish; //출판일  
  
    
    public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public void setPublish(String publish) {
		this.publish = publish;
	}
	
	public String getPublish() {
		return publish;
	}
    
    
    
}

