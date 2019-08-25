package org.bookstore.service.impl;

import org.bookstore.dao.IOrderDAO;
import org.bookstore.model.Orders;
import org.bookstore.service.IOrderService;

public class OrderService implements IOrderService {

	private IOrderDAO orderDAO;
	
	public IOrderDAO getOrderDAO() {
		return orderDAO;
	}

	public void setOrderDAO(IOrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}

	//±£´æ¶©µ¥
	@Override
	public Orders saveOrder(Orders order) {
		return orderDAO.saveOrder(order);
	}

}
