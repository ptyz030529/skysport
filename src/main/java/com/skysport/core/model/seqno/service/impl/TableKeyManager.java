package com.skysport.core.model.seqno.service.impl;

import com.skysport.core.dao.TableKeyMapper;
import com.skysport.core.model.seqno.service.IncrementNumber;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangjh on 2015/6/1.
 */
@Service("incrementNumber")
public class TableKeyManager implements IncrementNumber {


    @Resource(name = "tableKeyMapper")
    private TableKeyMapper tableKeyMapper;

    @Override
    public int nextVal(String name) {
//        return tableKeyMapper.nextVal(name);
        Map<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("name", name);
        tableKeyMapper.nextVal(paramsMap);

        return (Integer) paramsMap.get("result");
    }

    @Override
    public int reset() {
        return 0;
    }
}
