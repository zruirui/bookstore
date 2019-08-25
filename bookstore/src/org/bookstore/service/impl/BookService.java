package org.bookstore.service.impl;

import java.util.List;

import org.bookstore.dao.IBookDAO;
import org.bookstore.model.Book;
import org.bookstore.service.IBookService;

public class BookService implements IBookService {

	private IBookDAO bookDAO;
	
	public IBookDAO getBookDAO() {
		return bookDAO;
	}

	public void setBookDAO(IBookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}

	//获取新书列表
	@Override
	public List getNewBook() {
		return bookDAO.getNewBook();
	}

	//分页查询某类别图书
	@Override
	public List getBookByCatalogidPaging(Integer catalogid, int pageNow, int pageSize) {
		return bookDAO.getBookByCatalogidPaging(catalogid, pageNow, pageSize);
	}

	//得到某类别图书的总数
	@Override
	public int getTotalByCatalog(Integer catalogid) {
		return bookDAO.getTotalByCatalog(catalogid);
	}

	//根据书名获取图书信息
	@Override
	public List getRequiredBookByName(String name) {
		return bookDAO.getRequiredBookByName(name);
	}

	//根据表单ID获取相应的图书
	@Override
	public Book getBookById(Integer bookid) {
		return bookDAO.getBookById(bookid);
	}

}
