package org.bookstore.dao.impl;

import org.bookstore.dao.BaseDAO;
import org.bookstore.dao.IOrderDAO;
import org.bookstore.model.Orders;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OrderDAO extends BaseDAO implements IOrderDAO {

	//±£´æ¶©µ¥
	@Override
	public Orders saveOrder(Orders order) {
		Session session=getSession();
		Transaction ts=session.beginTransaction();
		session.save(order);
		ts.commit();
		session.close();
		return order;
	}

}
