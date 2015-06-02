package com.skysport.core.model.init.service.impl;

import com.skysport.core.bean.Dictionary;
import com.skysport.core.dao.DictionaryMapper;
import com.skysport.core.model.init.service.IDictionaryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2015/6/1.
 */
@Service("dictionaryService")
public class DictionaryServiceImpl implements IDictionaryService {
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