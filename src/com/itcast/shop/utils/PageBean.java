package com.itcast.shop.utils;

import java.util.List;

/**
 * ��ҳ��ķ�װ
 * @author: ��
 * @param <T>
 */
public class PageBean<T> {
	private int page;	//��ǰҳ��
	private int	totalCount;	//�ܼ�¼��
	private int totalPage;	//��ҳ��
	private int limit;	//ÿҳ��ʾ�ļ�¼��
	private List<T> list;	//ÿҳ��ʾ�����ݼ���
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	
}
