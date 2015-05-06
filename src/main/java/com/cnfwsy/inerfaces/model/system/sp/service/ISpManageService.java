package com.cnfwsy.inerfaces.model.system.sp.service;

import java.util.List;

import com.cnfwsy.core.bean.DataTablesInfo;
import com.cnfwsy.inerfaces.bean.SpInfo;

/**
 * 
 * 此类描述的是：
 * 
 * @author: zhangjh
 * @version: 2015年4月29日 下午5:41:06
 */
public interface ISpManageService {

	List<SpInfo> listSP(SpInfo spInfo);

	int listSPInfosCounts();

	/**
	 * 
	 * @param dataTablesInfo
	 * @return
	 */
	int listFilteredSPInfosCounts(DataTablesInfo dataTablesInfo);

	/**
	 * 
	 * @param dataTablesInfo
	 * @return
	 */
	List<SpInfo> searchSP(DataTablesInfo dataTablesInfo);

}
