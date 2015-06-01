package com.skysport.core.model.init.helper;

import com.skysport.core.bean.Dictionary;
import com.skysport.core.instance.DictionaryInfo;
import com.skysport.core.model.init.service.IDictionaryService;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * Created by Administrator on 2015/6/1.
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
        List<Dictionary> dictionaries = service.queryAllDictionaries();
        initDictionaryMap(dictionaries);
    }

    public void initDictionaryMap(List<Dictionary> dictionaries) {
        for (int index = 0; index < dictionaries.size(); index++) {
            Dictionary dictionary = dictionaries.get(index);
            DictionaryInfo.SINGLETONE.initDictionaryMap(dictionary);
        }

    }
}
