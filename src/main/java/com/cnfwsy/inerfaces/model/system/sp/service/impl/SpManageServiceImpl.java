package com.cnfwsy.inerfaces.model.system.sp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cnfwsy.core.bean.DataTablesInfo;
import com.cnfwsy.inerfaces.bean.SpInfo;
import com.cnfwsy.inerfaces.dao.SpManageDao;
import com.cnfwsy.inerfaces.model.system.sp.service.ISpManageService;

/**
 * 
 * 此类描述的是：
 * 
 * @author: zhangjh
 * @version: 2015年4月29日 下午5:39:59
 */
@Service("spManageService")
public class SpManageServiceImpl implements ISpManageService {
	@Resource(name = "spManageDao")
	private SpManageDao spManageDao;

	@Override
	public List<SpInfo> listSP(SpInfo spInfo) {
		
		return null;
	}

	/**
	 * 查询spinfo的总记录数
	 */
	@Override
	public int listSPInfosCounts() {
		return spManageDao.listSPInfosCounts();
	}

	/**
	 * 按条件查询spinfo的所有信息
	 */
	@Override
	public int listFilteredSPInfosCounts(DataTablesInfo dataTablesInfo) {
		// // 获取请求次数
		// int draw = 0;
		// draw = dataTablesInfo.getDraw();
		// // 数据起始位置
		// int start = dataTablesInfo.getStart();
		// // 数据长度
		// int length = dataTablesInfo.getLength();

		return spManageDao.listFilteredSPInfosCounts(dataTablesInfo);
	}

	/**
	 * 查询spinfo的所有信息
	 */
	@Override
	public List<SpInfo> searchSP(DataTablesInfo dataTablesInfo) {
		return spManageDao.searchSP(dataTablesInfo);
	}

	public SpManageDao getSpManageDao() {
		return spManageDao;
	}

	public void setSpManageDao(SpManageDao spManageDao) {
		this.spManageDao = spManageDao;
	}

}
