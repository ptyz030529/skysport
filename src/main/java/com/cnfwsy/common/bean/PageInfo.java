package com.cnfwsy.common.bean;

/**
 * 
 * �����������ǣ�
 * 
 * @author: zhangjh
 * @version: 2015��4��29�� ����5:44:37
 */
public class PageInfo {
	/**
	 * ��ʼ��¼
	 */
	private int start = 1;
	/**
	 * ÿҳ��¼��
	 */
	private int limit = 20;
	/**
	 * ҳ���������
	 */
	private int draw;

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

}
