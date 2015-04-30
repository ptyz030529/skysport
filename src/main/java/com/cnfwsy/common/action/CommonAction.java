package com.cnfwsy.common.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * �����������ǣ�
 * 
 * @author: zhangjh
 * @version: 2015��4��30�� ����4:34:05
 */
public class CommonAction<T> {
	/**
	 * 
	 * �˷����������ǣ�
	 * 
	 * @author: zhangjh
	 * @version: 2015��4��30�� ����4:34:11
	 */
	public <T> Map<String, Object> buildJsonMap(List<T> results,
			int recordsTotal, int recordsFiltered, int draw) {
		Map<String, Object> info = new HashMap<String, Object>();
		info.put("data", results);
		info.put("recordsTotal", recordsTotal);
		info.put("recordsFiltered", recordsFiltered);
		info.put("draw", draw);
		return info;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
