package com.skysport.inerfaces.mapper;

import com.skysport.inerfaces.bean.system.ProductTypeInfo;
import org.springframework.stereotype.Component;

/**
 * Created by zhangjh on 2015/6/9.
 */
@Component("productTypeManageDao")
public interface ProductTypeManageMapper extends CommonDao<ProductTypeInfo> {
}
