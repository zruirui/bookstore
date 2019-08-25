package org.bookstore.dao;

import org.bookstore.model.Users;

public interface IUserDAO {

	public void save(Users user); //���桢ע���û���Ϣ
	public Users validateUser(String username,String password); //��֤��¼�û���Ϣ
	public boolean existUser(String username);
}
