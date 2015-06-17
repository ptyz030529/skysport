package com.skysport.inerfaces.dao;

import org.springframework.stereotype.Component;

/**
 * Created by zhangjh on 2015/6/17.
 */
@Component("materialTypeManageDao")
public interface MaterialTypeManageDao<MaterialTypeInfo> extends   CommonDao<MaterialTypeInfo> {
}
