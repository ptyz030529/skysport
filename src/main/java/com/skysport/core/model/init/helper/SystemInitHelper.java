package com.skysport.core.model.init.helper;

import org.springframework.context.ApplicationContext;

/**
 * 系统启动，加载初始化信息
 * @author: zhangjh
 * @version:2015年5月6日 下午4:30:54
 */
public enum SystemInitHelper {
	SINGLETONE;

	public void init(ApplicationContext appContext) {
		// 初始化数据字典信息
		DictionaryHelper.SINGLETONE.initDictionary(appContext);
	}



}
