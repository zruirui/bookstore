package org.bookstore.service.impl;

import java.util.List;

import org.bookstore.dao.ICatalogDAO;
import org.bookstore.service.ICatalogService;

public class CatalogService implements ICatalogService {

	private ICatalogDAO catalogDAO;
		
	public ICatalogDAO getCatalogDAO() {
		return catalogDAO;
	}

	public void setCatalogDAO(ICatalogDAO catalogDAO) {
		this.catalogDAO = catalogDAO;
	}

	//获取所有图书类别
	@Override
	public List getAllCatalogs() {
		return catalogDAO.getAllCatalogs();
	}

}
