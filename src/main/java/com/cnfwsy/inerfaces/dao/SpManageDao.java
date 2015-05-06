package com.cnfwsy.inerfaces.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cnfwsy.core.bean.DataTablesInfo;
import com.cnfwsy.inerfaces.bean.SpInfo;

/**
 * 
 * @author: zhangjh
 * @version:2015��5��5�� ����5:43:26
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
	 * ��ѯ��Ӧ�̵��ܼ�¼��
	 * 
	 * @return ��Ӧ�̵��ܼ�¼��
	 */
	public int listSPInfosCounts();

	/**
	 * ��ѯ���й��������Ĺ�Ӧ�̵��ܼ�¼��
	 * 
	 * @param dataTablesInfo
	 *            DataTablesInfo
	 * @return ���й��������Ĺ�Ӧ�̵��ܼ�¼��
	 */
	public int listFilteredSPInfosCounts(DataTablesInfo dataTablesInfo);

	/**
	 * ���չ���������ѯ��Ӧ����Ϣ
	 * 
	 * @param dataTablesInfo
	 * @return ��Ӧ����Ϣ
	 */
	public List<SpInfo> searchSP(DataTablesInfo dataTablesInfo);
}
