package com.cnfwsy.core.model.init.helper;

import java.util.List;

import org.springframework.context.ApplicationContext;

import com.cnfwsy.core.bean.Dictionary;
import com.cnfwsy.core.instance.SytemInitInfo;
import com.cnfwsy.core.model.init.service.ISystemInitService;

/**
 * 
 * @author: zhangjh
 * @version:2015��5��6�� ����4:30:54
 */
public enum SystemInitHelper {
	SINGLETONE;

	public void init(ApplicationContext appContext) {
		// ��ʼ�������ֵ���Ϣ
		initDictionary(appContext);
	}

	private void initDictionary(ApplicationContext appContext) {
		ISystemInitService service = (ISystemInitService) appContext
				.getBean("systemInitService");
		List<Dictionary> dictionaries = service.queryAllDictionaries();
		initDictionaryMap(dictionaries);

	}

	private void initDictionaryMap(List<Dictionary> dictionaries) {
		for (int index = 0; index < dictionaries.size(); index++) {
			Dictionary dictionary = dictionaries.get(index);
			SytemInitInfo.SINGLETONE.initDictionaryMap(dictionary);
		}

	}

}
