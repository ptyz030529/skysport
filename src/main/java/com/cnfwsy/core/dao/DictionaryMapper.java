package com.cnfwsy.core.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cnfwsy.core.bean.Dictionary;

/**
 * 
 * @author: zhangjh
 * @version:2015年5月6日 下午4:07:33
 */
@Component("dictionaryMapper")
public interface DictionaryMapper {

	public List<Dictionary> searchDictionary();
}
