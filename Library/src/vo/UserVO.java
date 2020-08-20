package vo;

public class UserVO {

	//회원관련변수
 
    private boolean UserType; //회원권한
    private String userID; //사용자아이디     
    private String userPass; //사용자 비밀번호
    private String userName; //사용자 실명
    private String userPhone; //사용자 휴대전화
    private String userAddress; //사용자 주소
 
	public boolean isUserType() {
		return UserType;
	}
	public void setUserType(boolean userType) {
		UserType = userType;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
    

    }