package com.cnfwsy.core.instance;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.cnfwsy.core.bean.Dictionary;

/**
 * ϵͳ��ʼ����
 * 
 * @author: zhangjh
 * @version:2015��5��6�� ����3:45:15
 */
public enum SytemInitInfo {

	/**
	 * �����ֵ䵥����
	 */
	SINGLETONE;

	/**
	 * �����ֵ���Ϣ����
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
	 * @param dictionary �����ֶζ���
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
}
