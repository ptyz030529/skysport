package com.skysport.inerfaces.model.system.product_type.impl;

import com.skysport.inerfaces.bean.system.ProductTypeInfo;
import com.skysport.inerfaces.mapper.ProductTypeManageMapper;
import com.skysport.inerfaces.model.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zhangjh on 2015/6/9.
 */
@Service("productTypeManageService")
public class ProductTypeManageServiceImpl extends CommonServiceImpl<ProductTypeInfo> implements InitializingBean {
    @Resource(name = "productTypeManageDao")
    private ProductTypeManageMapper productTypeManageDao;

    @Override
    public void afterPropertiesSet()  {
        commonDao = productTypeManageDao;
    }
}
