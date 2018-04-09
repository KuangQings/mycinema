package myCommunity.web.action;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import myCommunity.dao.UserDao;
import myCommunity.entity.Role;
import myCommunity.entity.User;

@Component
@Scope("prototype")
public class UserAction extends ActionSupport{
	
	@Autowired
	private  UserDao  dao;
	
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	private String message;
	public String getMessage() {
		return message;
	}

	public String checkLogin() {
		User loginUser=dao.checkLogin(user.getUsername(),user.getPassword());
		if(loginUser!=null) {
			Map<String,Object> session = ActionContext.getContext().getSession();
			session.put("loginUser", loginUser);
			return SUCCESS;
		}else {
			this.message = "用户名或密码有误";
			return INPUT;
		}
	}
	
	public String loginOut() {
		Map<String,Object> session = ActionContext.getContext().getSession();
		session.remove("loginUser");
		 return SUCCESS;
	}
	
	
	public String reginster() {
		Role role = new Role(1, null);
		role.setId(1);
		user.setGrade(0);
		user.setRole(role);
		user.setStatus(true);
		user.setSignature("新用户哦");
		dao.addUser(user);
		return SUCCESS;
	}
	

}
