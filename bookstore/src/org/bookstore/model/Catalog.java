package org.bookstore.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Catalog entity. @author MyEclipse Persistence Tools
 */

public class Catalog implements java.io.Serializable {

	// Fields

	private Integer catalogid;
	private String catalogname;
	private Set books=new HashSet();
	// Constructors

	/** default constructor */
	public Catalog() {
	}

	/** full constructor */
	public Catalog(String catalogname) {
		this.catalogname = catalogname;
	}

	// Property accessors

	public Integer getCatalogid() {
		return this.catalogid;
	}

	public void setCatalogid(Integer catalogid) {
		this.catalogid = catalogid;
	}

	public String getCatalogname() {
		return this.catalogname;
	}

	public void setCatalogname(String catalogname) {
		this.catalogname = catalogname;
	}

	public Set getBooks() {
		return books;
	}

	public void setBooks(Set books) {
		this.books = books;
	}

}