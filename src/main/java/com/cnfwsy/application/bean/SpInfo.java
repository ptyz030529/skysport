package com.cnfwsy.application.bean;

import org.springframework.stereotype.Component;

import com.cnfwsy.common.bean.PageInfo;

/**
 * 
 * @author zhangjh
 *
 */
@Component("spInfo")
public class SpInfo extends PageInfo {
	private int id;
	private String spId;
	private String name;
	private String address;

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

}
