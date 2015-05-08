package com.cnfwsy.core.model.init.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cnfwsy.core.bean.Dictionary;
import com.cnfwsy.core.dao.DictionaryMapper;
import com.cnfwsy.core.model.init.service.ISystemInitService;

/**
 * 
 * @author: zhangjh
 * @version:2015年5月6日 下午4:08:46
 */
@Service("systemInitService")
public class SystemInitServiceImpl implements ISystemInitService {
	
	@Resource(name = "dictionaryMapper")
	private DictionaryMapper dictionaryMapper;

	@Override
	public List<Dictionary> queryAllDictionaries() {
		return dictionaryMapper.searchDictionary();
	}

	public DictionaryMapper getDictionaryMapper() {
		return dictionaryMapper;
	}

	public void setDictionaryMapper(DictionaryMapper dictionaryMapper) {
		this.dictionaryMapper = dictionaryMapper;
	}

}
