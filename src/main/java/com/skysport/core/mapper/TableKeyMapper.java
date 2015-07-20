package com.skysport.core.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by zhangjh on 2015/6/1.
 */
@Component("tableKeyMapper")
public interface TableKeyMapper {

    public int nextVal(@Param(value = "name") String name);

    public void nextVal(Map<String, Object> paramsMap);

    void nextVal2(Map<String, Object> paramsMap);
}
