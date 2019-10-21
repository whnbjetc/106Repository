package com.icss.normal.util;

import java.util.List;

public class PageResult<T> {

	private int currentPage;// 当前页码
	private int totalPage;// 总页数
	private int pageSize;// 每页显示数量
	private List<T> list;// 数据的集合
	private int count;//总记录数

	public PageResult(){}
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	
	@Override
	public String toString() {
		return "PageResult [currentPage=" + currentPage + ", totalPage="
				+ totalPage + ", pageSize=" + pageSize + ", list=" + list
				+ ", count=" + count + "]";
	}

	public PageResult(int currentPage, int totalPage, int pageSize, List<T> list) {
		this.currentPage = currentPage;
		this.totalPage = totalPage;
		this.pageSize = pageSize;
		this.list = list;
	}


}
