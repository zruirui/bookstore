package org.bookstore.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.bookstore.dao.BaseDAO;
import org.bookstore.dao.IUserDAO;
import org.bookstore.model.Users;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDAO extends BaseDAO implements IUserDAO {

	//保存、注册用户信息
	@Override
	public void save(Users user) {
		Session session=getSession();
		Transaction ts=session.beginTransaction();
		session.save(user);
		ts.commit();
		session.close();
	}

	//验证登录用户信息
	@Override
	public Users validateUser(String username, String password) {
		String hql="from Users u where u.username=? and u.password=?";
		Session session=getSession();
		Query query=session.createQuery(hql);
		query.setParameter(0, username);
		query.setParameter(1, password);
		List users=query.list();
		Iterator it=users.iterator();
		while(it.hasNext()){
			if(users.size()!=0){
				Users user=(Users) it.next();
				return user;
			}
		}
		session.close();
		return null;
	}

	@Override
	public boolean existUser(String username) {
		String hql="from Users u where u.username=?";
		Session session=getSession();
		Query query=session.createQuery(hql);
		query.setParameter(0, username);
		List users=query.list();
		if(users.size()>0){
			return true;
		}else{
			return false;
		}
	}

}
