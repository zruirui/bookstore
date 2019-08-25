package org.bookstore.dao.impl;

import java.util.List;

import org.bookstore.dao.BaseDAO;
import org.bookstore.dao.ICatalogDAO;
import org.hibernate.Query;
import org.hibernate.Session;

public class CatalogDAO extends BaseDAO implements ICatalogDAO {

	//��ȡ����ͼ�����
	@Override
	public List getAllCatalogs() {
		String hql="from Catalog";
		Session session=getSession();
		Query query=session.createQuery(hql);
		List catalogs=query.list();
		session.close();
		return catalogs;
	}

}
