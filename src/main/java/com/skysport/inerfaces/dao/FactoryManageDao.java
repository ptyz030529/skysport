package com.skysport.inerfaces.dao;

import org.springframework.stereotype.Component;

/**
 * Created by zhangjh on 2015/6/9.
 */
@Component("factoryManageDao")
public interface FactoryManageDao<FactoryInfo> extends CommonDao<FactoryInfo> {
}
