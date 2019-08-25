package org.bookstore.dao;

import org.bookstore.model.Users;

public interface IUserDAO {

	public void save(Users user); //保存、注册用户信息
	public Users validateUser(String username,String password); //验证登录用户信息
	public boolean existUser(String username);
}
