package org.bookstore.action;

import java.util.Date;
import java.util.Map;

import org.bookstore.model.Book;
import org.bookstore.model.Orderitem;
import org.bookstore.model.Orders;
import org.bookstore.model.Users;
import org.bookstore.service.IBookService;
import org.bookstore.service.IOrderService;
import org.bookstore.service.impl.BookService;
import org.bookstore.tool.Cart;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShopAction extends ActionSupport{

	private IBookService bookService;
	private IOrderService orderService;
	private Integer bookid;
	private Integer quantity;
	
	public IBookService getBookService() {
		return bookService;
	}

	public void setBookService(IBookService bookService) {
		this.bookService = bookService;
	}

	public IOrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(IOrderService orderService) {
		this.orderService = orderService;
	}

	public Integer getBookid() {
		return bookid;
	}

	public void setBookid(Integer bookid) {
		this.bookid = bookid;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String addToCart() throws Exception {
		Book book=bookService.getBookById(bookid);
		Orderitem orderitem=new Orderitem();
		orderitem.setBook(book);
		orderitem.setQuantity(quantity);
		Map session=(Map) ActionContext.getContext().getSession();	
		Cart cart=(Cart) session.get("cart");
		if(cart==null){
			cart=new Cart();
		}
		cart.addBook(bookid, orderitem);
		session.put("cart", cart);
		return "success";
	}
	
	public String updateCart() throws Exception {
		Map session=(Map) ActionContext.getContext().getSession();	
		Cart cart=(Cart) session.get("cart");
		cart.updateCart(bookid, quantity);
		session.put("cart", cart);
		return "success";
	}
	
	public String checkout() throws Exception {
		Map session=ActionContext.getContext().getSession();
		Users user=(Users) session.get("user");
		Cart cart=(Cart) session.get("cart");
		//如果用户没有登录
		if(user==null) {
			return ActionSupport.ERROR;
		}
		Orders order=new Orders();
		order.setOrderdate(new Date());
		order.setUsers(user);
		for(java.util.Iterator<Orderitem> it=cart.getItems().values().iterator();it.hasNext();){
			Orderitem orderitem=(Orderitem)it.next();
			orderitem.setOrders(order);
			order.getOrderitems().add(orderitem);
		}
		orderService.saveOrder(order);
		Map request=(Map) ActionContext.getContext().get("request");
		request.put("order", order);
		return "success";
	}
}
