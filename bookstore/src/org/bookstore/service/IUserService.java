package org.bookstore.service;

import org.bookstore.model.Users;

public interface IUserService {

	public void saveUser(Users user);
	public Users validateUser(String username,String password);
	public boolean existUser(String username);
}
