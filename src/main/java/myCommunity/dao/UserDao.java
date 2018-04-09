package myCommunity.dao;

import myCommunity.entity.User;

public interface UserDao {
	
	
	User checkLogin(String username,String password);
	void addUser(User user);

}
