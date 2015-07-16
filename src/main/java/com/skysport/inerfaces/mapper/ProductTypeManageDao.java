package com.skysport.inerfaces.mapper;

import org.springframework.stereotype.Component;

/**
 * Created by zhangjh on 2015/6/9.
 */
@Component("productTypeManageDao")
public interface ProductTypeManageDao<ProductTypeInfo> extends CommonDao<ProductTypeInfo> {
}
