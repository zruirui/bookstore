package org.bookstore.model;

/**
 * Book entity. @author MyEclipse Persistence Tools
 */

public class Book implements java.io.Serializable {

	// Fields

	private Integer bookid;
	private String bookname;
	private Integer price;
	private String picture;
	//private Integer catalogid;
	private Catalog catalog; 

	// Constructors

	/** default constructor */
	public Book() {
	}

	/** full constructor */
	public Book(String bookname, Integer price, String picture,
			Catalog catalog) {
		this.bookname = bookname;
		this.price = price;
		this.picture = picture;
		this.catalog = catalog;
	}

	// Property accessors

	public Integer getBookid() {
		return this.bookid;
	}

	public void setBookid(Integer bookid) {
		this.bookid = bookid;
	}

	public String getBookname() {
		return this.bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Catalog getCatalog() {
		return catalog;
	}

	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}

	/*public Integer getCatalogid() {
		return this.catalogid;
	}

	public void setCatalogid(Integer catalogid) {
		this.catalogid = catalogid;
	}*/
	

}