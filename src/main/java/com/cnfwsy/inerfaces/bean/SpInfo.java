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
	 * 供应商编号
	 */
	private String spId;
	/**
	 * 供应商名称
	 */
	private String name;
	/**
	 * 供应商类型
	 */
	private String type;

	/**
	 * 合作时间
	 */
	private String cooperationTime;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 备注
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
