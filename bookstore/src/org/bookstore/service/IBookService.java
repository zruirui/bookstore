package org.bookstore.service;

import java.util.List;

import org.bookstore.model.Book;

public interface IBookService {

	public List getNewBook(); //��ȡ�����б�
	public List getBookByCatalogidPaging(Integer catalogid, int pageNow, int pageSize); //��ҳ��ѯĳ���ͼ��
	public int getTotalByCatalog(Integer catalogid); //�õ�ĳ���ͼ�������
	public List getRequiredBookByName(String name); //����������ȡͼ����Ϣ
	public Book getBookById(Integer bookid); //���ݱ�ID��ȡ��Ӧ��ͼ��
}
