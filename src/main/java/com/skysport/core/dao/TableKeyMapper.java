package com.skysport.core.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * Created by zhangjh on 2015/6/1.
 */
@Component("tableKeyMapper")
public interface TableKeyMapper {

    public int nextVal(@Param(value = "name") String name);
}
