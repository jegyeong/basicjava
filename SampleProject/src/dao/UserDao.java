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
	
	public UserVO selectUser(UserVO param){
		UserVO rtnUser = null;
		for(int i = 0; i < database.tb_user.size(); i++){
			UserVO user = database.tb_user.get(i);
			boolean flag = true;
			if(param.getId() != null)
				if(!param.getId().equals(user.getId())) flag = false;
			if(param.getPassword() != null)
				if(!param.getPassword().equals(user.getPassword())) flag = false;
			if(param.getName() != null)
				if(!param.getName().equals(user.getName())) flag = false;
			if(flag){
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
	
}









