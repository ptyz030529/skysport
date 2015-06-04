package com.skysport.inerfaces.dao;

import com.skysport.core.bean.DataTablesInfo;
import com.skysport.inerfaces.bean.SpInfo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 
 * @author: zhangjh
 * @version:2015年5月5日 下午5:43:26
 */
@Component("spManageDao")
public interface SpManageDao {
	/**
	 * 
	 * @param spId
	 * @return
	 */
	public SpInfo querySpInfo(String spId);

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

	public void add(SpInfo spInfo);

	void del(String spId);
}
