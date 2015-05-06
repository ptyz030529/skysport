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
 * �����������ǣ�
 * 
 * @author: zhangjh
 * @version: 2015��4��29�� ����5:39:59
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
	 * ��ѯspinfo���ܼ�¼��
	 */
	@Override
	public int listSPInfosCounts() {
		return spManageDao.listSPInfosCounts();
	}

	/**
	 * ��������ѯspinfo��������Ϣ
	 */
	@Override
	public int listFilteredSPInfosCounts(DataTablesInfo dataTablesInfo) {
		// // ��ȡ�������
		// int draw = 0;
		// draw = dataTablesInfo.getDraw();
		// // ������ʼλ��
		// int start = dataTablesInfo.getStart();
		// // ���ݳ���
		// int length = dataTablesInfo.getLength();

		return spManageDao.listFilteredSPInfosCounts(dataTablesInfo);
	}

	/**
	 * ��ѯspinfo��������Ϣ
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
