package myCommunity.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import myCommunity.dao.UserDao;
import myCommunity.entity.Role;
import myCommunity.entity.User;


@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private HibernateTemplate db;
	 

	@Override
	public User checkLogin(String username, String password) {
		List<User> user = (List<User>) db.find("from User where username=? and password=?",username,password);
		return user.size()>0?user.get(0):null;
	}
	
	@Override
	public void addUser(User user) {
		 db.save(user);
		
	}


}
