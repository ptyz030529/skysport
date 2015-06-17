package com.skysport.inerfaces.model.system.product_type;

import com.skysport.inerfaces.bean.ProductTypeInfo;
import com.skysport.inerfaces.dao.MaterialTypeManageDao;
import com.skysport.inerfaces.model.system.common.service.impl.CommonServiceImpl;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zhangjh on 2015/6/9.
 */
@Service("materialTypeManageService")
public class ProductTypeManageServiceImpl extends CommonServiceImpl<ProductTypeInfo> implements InitializingBean {
    @Resource(name = "materialTypeManageDao")
    private MaterialTypeManageDao<ProductTypeInfo> materialTypeManageDao;

    @Override
    public void afterPropertiesSet() throws Exception {
        commonDao = materialTypeManageDao;
    }
}
