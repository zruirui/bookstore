package org.bookstore.dao.impl;

import java.util.List;

import org.bookstore.dao.BaseDAO;
import org.bookstore.dao.IBookDAO;
import org.bookstore.model.Book;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BookDAO extends BaseDAO implements IBookDAO {

	//获取新书列表
	@Override
	public List getNewBook() {
		String hql="from Book b";
		Session session=getSession();
		Query query=session.createQuery(hql);
		query.setFirstResult(0);
		query.setMaxResults(5);
		List books=query.list();
		session.close();
		return books;
	}

	//分页查询某类别图书
	@Override
	public List getBookByCatalogidPaging(Integer catalogid, int pageNow, int pageSize) {
		try{
			String hql="from Book b where b.catalog.catalogid=?";
			Session session=getSession();
			Transaction ts=session.beginTransaction();
			Query query=session.createQuery(hql);
			query.setParameter(0, catalogid);
			query.setFirstResult((pageNow-1)*pageSize);
			query.setMaxResults(pageSize);
			List books=query.list();
			ts.commit();
			session.close();
			return books;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}

	//得到某类别图书的总数
	@Override
	public int getTotalByCatalog(Integer catalogid) {
		Session session=getSession();
		Query query=session.createQuery("from Book b where b.catalog.catalogid=?");
		query.setParameter(0, catalogid);
		return query.list().size();
	}

	//根据书名获取图书信息
	@Override
	public List getRequiredBookByName(String name) {
		String hql="from Book b where b.bookname like ?";
		Session session=getSession();
		Transaction ts=session.beginTransaction();
		Query query=session.createQuery(hql);
		query.setParameter(0, "%"+name+"%");
		List books=query.list(); //获取符合条件的图书列表
		ts.commit();
		session.close();
		return books;
	}

	//根据表单ID获取相应的图书
	@Override
	public Book getBookById(Integer bookid) {
		String hql="from Book b where b.bookid=?";
		Session session=getSession();
		Transaction ts=session.beginTransaction();
		Query query=session.createQuery(hql);
		query.setParameter(0, bookid);
		query.setMaxResults(1);
		Book book=(Book) query.uniqueResult();		
		ts.commit();
		session.close();
		return book;
	}
	/*public Book getBookById(Integer bookid) {
		Session session=getSession();
		Transaction ts=session.beginTransaction();
		return (Book) session.get(Book.class, bookid);
	}*/

}
