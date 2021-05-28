package com.gallery.utils;

import java.util.List;
/***
 * rows: how many items in one page;
 * page: current page;
 * this model is used in paging items. Our purpose is to save 
 * page data for later paintingDao's using.
 * @author dwang
 *
 */
public class PageModel {
	private int page;
	private int totalPages;
	private int rows; 
	private int totalRows;
	private int pageStartRow;
	private int pageEndRow;
	private boolean hasNextPage;
	private boolean hasPreviousPage;
	private List pageData;
	
	public PageModel() {}
	
	public PageModel(List data, int page, int rows) {
		this.page = page;
		this.rows = rows;
		totalRows = data.size();
		totalPages = new Double(Math.ceil(totalRows/(rows*1f))).intValue();
		pageStartRow = (page - 1)*rows;
		pageEndRow = page * rows;
		pageData = data.subList(pageStartRow, Math.min(pageEndRow, totalRows));
		hasPreviousPage = page > 1;
		hasNextPage = page < totalPages;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getPageStartRow() {
		return pageStartRow;
	}

	public void setPageStartRow(int pageStartRow) {
		this.pageStartRow = pageStartRow;
	}

	public int getPageEndRow() {
		return pageEndRow;
	}

	public void setPageEndRow(int pageEndRow) {
		this.pageEndRow = pageEndRow;
	}

	public boolean isHasNextPage() {
		return hasNextPage;
	}

	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

	public boolean isHasPreviousPage() {
		return hasPreviousPage;
	}

	public void setHasPreviousPage(boolean hasPreviousPage) {
		this.hasPreviousPage = hasPreviousPage;
	}

	public List getPageData() {
		return pageData;
	}

	public void setPageData(List pageData) {
		this.pageData = pageData;
	}
	
	

}
