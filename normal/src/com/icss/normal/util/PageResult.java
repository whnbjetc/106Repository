package com.icss.normal.util;

import java.util.List;

public class PageResult<T> {

	private int currentPage;// ��ǰҳ��
	private int totalPage;// ��ҳ��
	private int pageSize;// ÿҳ��ʾ����
	private List<T> list;// ���ݵļ���
	private int count;//�ܼ�¼��

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
