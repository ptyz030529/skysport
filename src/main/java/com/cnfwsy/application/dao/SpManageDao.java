package com.cnfwsy.application.dao;

import java.util.List;

import com.cnfwsy.application.bean.SpInfo;
/**
 * 
		* @ClassName: SpManageDao
		* @Description: TODO
		* @author Comsys-zhangjh
		* @date 2015��4��29�� ����5:22:49
		*
 */

public interface SpManageDao {
	/**
	 * 
			* querySpInfo(������һ�仰�����������������)
			* TODO(����������������������� �C ��ѡ)
			* TODO(�����������������ִ������ �C ��ѡ)
			* TODO(�����������������ʹ�÷��� �C ��ѡ)
			* TODO(�����������������ע������ �C ��ѡ)
			*
			* @Title: querySpInfo
			* @Description: TODO
			* @param @param spInfo
			* @param @return �趨�ļ�
			* @return List<SpInfo> ��������
			* @throws
	 */
	public List<SpInfo> querySpInfo(SpInfo spInfo);
}
