package org.bookstore.action;

import java.util.Map;

import org.bookstore.model.Users;
import org.bookstore.service.IUserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{

	private Users user;
	private IUserService userService;
	
	//���桢ע���û���Ϣ
	public String register() throws Exception{
		Users user1=new Users();
		user1.setUsername(user.getUsername());
		user1.setPassword(user.getPassword());
		user1.setSex(user.getSex());
		user1.setAge(user.getAge());
		userService.saveUser(user1);
		return "success";
	}

	//��֤��¼�û���Ϣ
	public String execute() throws Exception{
		Users user2=userService.validateUser(user.getUsername(),user.getPassword());		
		if(user2!=null){
			Map session=ActionContext.getContext().getSession();
			session.put("user", user2);
			return "success";
		}else{
			return "error";
		}
	}
	
	//ע���û�
	public String logout() throws Exception{
		Map session=ActionContext.getContext().getSession();
		session.remove("user"); //���û������session���Ƴ�
		return "success";
	}
	
	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
}
