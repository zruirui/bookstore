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

	//��ȡ�����б�
	@Override
	public List getNewBook() {
		return bookDAO.getNewBook();
	}

	//��ҳ��ѯĳ���ͼ��
	@Override
	public List getBookByCatalogidPaging(Integer catalogid, int pageNow, int pageSize) {
		return bookDAO.getBookByCatalogidPaging(catalogid, pageNow, pageSize);
	}

	//�õ�ĳ���ͼ�������
	@Override
	public int getTotalByCatalog(Integer catalogid) {
		return bookDAO.getTotalByCatalog(catalogid);
	}

	//����������ȡͼ����Ϣ
	@Override
	public List getRequiredBookByName(String name) {
		return bookDAO.getRequiredBookByName(name);
	}

	//���ݱ�ID��ȡ��Ӧ��ͼ��
	@Override
	public Book getBookById(Integer bookid) {
		return bookDAO.getBookById(bookid);
	}

}
