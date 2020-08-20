package dao;

import java.util.ArrayList;

import vo.UserVO;
import data.Database;

public class UserDao {
	
	private static UserDao instance;
	
	private UserDao(){}
	
	public static UserDao getInstance(){
		if(instance == null){
			instance = new UserDao();
		}
		return instance;
	}

	Database database = Database.getInstance();

	public UserVO selectUser(UserVO param) {
		UserVO rtnUser = null;
		for(int i = 0; i < database.tb_user.size(); i++){
			UserVO user = database.tb_user.get(i);
			boolean flag = true;
			if(param.getUserID() != null)
				if(!param.getUserID().equals(user.getUserID())) flag = false;
			
			if(param.getUserPass() != null)
			if(!param.getUserPass().equals(user.getUserPass())) flag = false;
			
			if(param.getUserName() != null)
				if(!param.getUserName().equals(user.getUserName())) flag = false;
			if(flag) {
				rtnUser = user;
				break;
			}
		}
		return rtnUser;
	}
	public void insertUser(UserVO user) {
		database.tb_user.add(user);
	}
	public ArrayList<UserVO> selectUserList() {
		return database.tb_user;
	}
	public void deleteUser(UserVO user)
	{
		database.tb_user.remove(user);
	}
	

}
