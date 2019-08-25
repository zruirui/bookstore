package org.bookstore.service;

import java.util.List;

import org.bookstore.model.Book;

public interface IBookService {

	public List getNewBook(); //获取新书列表
	public List getBookByCatalogidPaging(Integer catalogid, int pageNow, int pageSize); //分页查询某类别图书
	public int getTotalByCatalog(Integer catalogid); //得到某类别图书的总数
	public List getRequiredBookByName(String name); //根据书名获取图书信息
	public Book getBookById(Integer bookid); //根据表单ID获取相应的图书
}
