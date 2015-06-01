package com.skysport.core.dao;

import com.skysport.core.bean.Dictionary;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 
 * @author: zhangjh
 * @version:2015年5月6日 下午4:07:33
 */
@Component("dictionaryMapper")
public interface DictionaryMapper {
	public List<Dictionary> searchDictionary();
}
