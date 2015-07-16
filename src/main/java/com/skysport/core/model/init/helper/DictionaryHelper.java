package com.skysport.core.model.init.helper;

import com.skysport.core.bean.system.DictionaryInfo;
import com.skysport.core.model.init.service.IDictionaryService;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * Created by zhangjh on 2015/6/1.
 */
public enum DictionaryHelper {
    /**
     * 单例
     */
    SINGLETONE;

    /**
     * @param appContext 上下文
     */
    public void initDictionary(ApplicationContext appContext) {
        IDictionaryService service = (IDictionaryService) appContext.getBean("dictionaryService");
        List<DictionaryInfo> dictionaries = service.queryAllDictionaries();
        initDictionaryMap(dictionaries);
    }



    public void initDictionaryMap(List<DictionaryInfo> dictionaries) {
        for (int index = 0; index < dictionaries.size(); index++) {
            DictionaryInfo dictionary = dictionaries.get(index);
            com.skysport.core.instance.DictionaryInfo.SINGLETONE.initDictionaryMap(dictionary);
        }

    }


}
