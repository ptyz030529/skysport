package com.cnfwsy.core.instance;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.cnfwsy.core.bean.Dictionary;
import com.cnfwsy.core.constant.CommonConstant;
import com.cnfwsy.core.constant.DictionaryTypeConstant;

/**
 * 系统初始化类
 * 
 * @author: zhangjh
 * @version:2015年5月6日 下午3:45:15
 */
public enum SytemInitInfo {

	/**
	 * 数据字典单例类
	 */
	SINGLETONE;

	/**
	 * 数据字典信息缓存
	 */
	private Map<String, Map<String, String>> dictionayMap = new ConcurrentHashMap<String, Map<String, String>>();

	private static final byte[] LOCK = new byte[0];

	public Map<String, Map<String, String>> getDictionayMap() {
		return dictionayMap;
	}

	public void initDictionaryMap(String type, Map<String, String> valueMap) {
		synchronized (LOCK) {
			dictionayMap.put(type, valueMap);
		}
	}

	public Map<String, String> getValueMapByTypeKey(String typeName) {
		return dictionayMap.get(typeName);
	}

	/**
	 * 初始化数据字段集合
	 * 
	 * @param dictionary
	 *            数据字段对象
	 */
	public void initDictionaryMap(Dictionary dictionary) {
		if (dictionary != null) {
			String type = dictionary.getType();
			String keyName = dictionary.getKeyName();
			String valueName = dictionary.getValueName();
			Map<String, String> valueMap = getDictionayMap().get(type);
			if (null == valueMap) {
				valueMap = new HashMap<String, String>();
				getDictionayMap().put(type, valueMap);
			}
			valueMap.put(keyName, valueName);
		}

	}

	/**
	 * 
	 * @param type
	 * @param key
	 * @return
	 */
	public String getDictionaryValue(String type, String key) {
		String value = CommonConstant.EMPTY;
		Map<String, String> valueMap = getDictionayMap().get(type);
		for (Map.Entry<String, String> entry : valueMap.entrySet()) {
			if (entry.getKey().equals(key)) {
				value = entry.getValue();
				break;
			}
		}
		return value;
	}

}
