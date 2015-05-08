package com.cnfwsy.inerfaces.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cnfwsy.core.bean.DataTablesInfo;
import com.cnfwsy.inerfaces.bean.SpInfo;

/**
 * 
 * @author: zhangjh
 * @version:2015年5月5日 下午5:43:26
 */
@Component("spManageDao")
public interface SpManageDao {
	/**
	 * 
	 * @param spInfo
	 * @return
	 */
	public List<SpInfo> querySpInfo(SpInfo spInfo);

	/**
	 * 查询供应商的总记录数
	 * 
	 * @return 供应商的总记录数
	 */
	public int listSPInfosCounts();

	/**
	 * 查询含有过滤条件的供应商的总记录数
	 * 
	 * @param dataTablesInfo
	 *            DataTablesInfo
	 * @return 含有过滤条件的供应商的总记录数
	 */
	public int listFilteredSPInfosCounts(DataTablesInfo dataTablesInfo);

	/**
	 * 按照过滤条件查询供应商信息
	 * 
	 * @param dataTablesInfo
	 * @return 供应商信息
	 */
	public List<SpInfo> searchSP(DataTablesInfo dataTablesInfo);

	public void updateSp(SpInfo spInfo);
}
