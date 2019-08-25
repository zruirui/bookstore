package org.bookstore.action;

import java.util.List;
import java.util.Map;

import org.bookstore.service.IBookService;
import org.bookstore.service.ICatalogService;
import org.bookstore.tool.Pager;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BookAction extends ActionSupport{

	private ICatalogService catalogService;
	private IBookService bookService;
	private Integer catalogid;
	private String bookname;

	private int pageNow=1;
	
	public ICatalogService getCatalogService() {
		return catalogService;
	}

	public void setCatalogService(ICatalogService catalogService) {
		this.catalogService = catalogService;
	}

	public IBookService getBookService() {
		return bookService;
	}

	public void setBookService(IBookService bookService) {
		this.bookService = bookService;
	}

	public Integer getCatalogid() {
		return catalogid;
	}

	public void setCatalogid(Integer catalogid) {
		this.catalogid = catalogid;
	}
	
	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	//获取所有图书类别
	public String browseCatalog() throws Exception {
		List catalogs=catalogService.getAllCatalogs();
		Map request=(Map) ActionContext.getContext().get("request");
		request.put("catalogs", catalogs);
		return "success";
	}
	
	//获取新书列表
	public String newBook() throws Exception {
		List books=bookService.getNewBook();
		Map request=(Map) ActionContext.getContext().get("request");
		request.put("books", books);
		return "success";
	}
	
	//按类别查询图书
	public String browseBookPaging() throws Exception {		
		Pager pager=new Pager(getPageNow(),bookService.getTotalByCatalog(catalogid));
		List books=bookService.getBookByCatalogidPaging(catalogid, pageNow, pager.getPageSize());	
		Map request=(Map) ActionContext.getContext().get("request");		
		request.put("books", books);
		request.put("pager", pager);
		//购物车要返回继续购买时，需要记住返回的地址
		request.put("catalogid", catalogid);
		return "success";
	}
	
	//根据书名获取图书信息
	public String searchBook() throws Exception {
		List books=bookService.getRequiredBookByName(bookname);
		Map request=(Map) ActionContext.getContext().get("request");		
		request.put("books", books);
		return "success";
	}
}
