package com.skysport.inerfaces.model.system.pantone.service;

import com.skysport.core.bean.DataTablesInfo;
import com.skysport.inerfaces.bean.PantoneInfo;

import java.util.List;

/**
 * 
 * 此类描述的是：
 * 
 * @author: zhangjh
 * @version: 2015年4月29日 下午5:41:06
 */
public interface IPantoneManageService {


	
	/**
	 * @return
	 */
	public int listPantoneInfosCounts();

	/**
	 * 过滤条件的记录数
	 * @param dataTablesInfo
	 * @return 符合查询条件的pantone记录数
	 */
	public int listFilteredPantoneInfosCounts(DataTablesInfo dataTablesInfo);

	/**
	 * 
	 * @param dataTablesInfo
	 * @return 
	 */
	public List<PantoneInfo> searchPantoneInfos(DataTablesInfo dataTablesInfo);
	
	/**
	 * 
	 * @param pantoneInfo
	 */
	public void edit(PantoneInfo pantoneInfo);

	/**
	 *
	 * @param pantoneId
	 * @return 根据pantoneid找出供应商信息
	 */
	public PantoneInfo queryPantoneInfoByPantoneId(String pantoneId);

	public void add(PantoneInfo pantoneInfo);

	public void del(String pantoneId);
}
