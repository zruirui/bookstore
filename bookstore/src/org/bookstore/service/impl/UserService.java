package org.bookstore.service.impl;

import org.bookstore.dao.IUserDAO;
import org.bookstore.model.Users;
import org.bookstore.service.IUserService;

public class UserService implements IUserService {

	private IUserDAO userDAO;
	
	public IUserDAO getUserDAO() {
		return userDAO;
	}
	
	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	//���桢ע���û���Ϣ
	@Override
	public void saveUser(Users user) {
		userDAO.save(user);
	}
	
	//��֤��¼�û���Ϣ
	@Override
	public Users validateUser(String username, String password) {
		return userDAO.validateUser(username, password);
	}

	@Override
	public boolean existUser(String username) {
		return userDAO.existUser(username);
	}

}