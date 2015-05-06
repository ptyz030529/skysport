package com.cnfwsy.inerfaces.bean;

import org.springframework.stereotype.Component;

import com.cnfwsy.core.bean.PageInfo;

/**
 * 
 * @author zhangjh
 *
 */
@Component("spInfo")
public class SpInfo extends PageInfo {
	private int id;
	/**
	 * ��Ӧ�̱��
	 */
	private String spId;
	/**
	 * ��Ӧ������
	 */
	private String name;
	/**
	 * ��Ӧ������
	 */
	private String type;

	/**
	 * ����ʱ��
	 */
	private String cooperationTime;
	/**
	 * ��ַ
	 */
	private String address;
	/**
	 * ��ע
	 */
	private String remark;

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSpId() {
		return spId;
	}

	public void setSpId(String spId) {
		this.spId = spId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCooperationTime() {
		return cooperationTime;
	}

	public void setCooperationTime(String cooperationTime) {
		this.cooperationTime = cooperationTime;
	}

}
