package com.cnfwsy.core.bean;

/**
 * jquery.datatables������̨����Ϣ
 * 
 * @author: zhangjh
 * @version:2015��5��5�� ����3:06:01
 */
public class DataTablesInfo {
	/**
	 * ��ǰҳ�Ŀ�ʼ��¼���±�
	 */
	private int start;
	/**
	 * һҳ�ĳ���
	 */
	private int length;
	/**
	 * �������
	 */
	private int draw;
	/**
	 * �������
	 */
	private String orderColumn;
	/**
	 * �����ǵ���
	 */
	private String orderDir;
	/**
	 * ��ѯ��Ϣ
	 */
	private String searchValue;

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public String getOrderColumn() {
		return orderColumn;
	}

	public void setOrderColumn(String orderColumn) {
		this.orderColumn = orderColumn;
	}

	public String getOrderDir() {
		return orderDir;
	}

	public void setOrderDir(String orderDir) {
		this.orderDir = orderDir;
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

}
