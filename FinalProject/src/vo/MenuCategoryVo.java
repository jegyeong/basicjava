package vo;

public class MenuCategoryVo {//pk추가 순서
	
	private int no;//pk
	private String menu;//카테고리 이름
	private boolean state = true;//출력 유무
	

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	
}
