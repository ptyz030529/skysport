package com.cnfwsy.core.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cnfwsy.core.bean.Dictionary;

/**
 * 
 * @author: zhangjh
 * @version:2015��5��6�� ����4:07:33
 */
@Component("dictionaryMapper")
public interface DictionaryMapper {

	public List<Dictionary> searchDictionary();
}
