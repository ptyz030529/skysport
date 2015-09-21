package com.skysport.inerfaces.model.system.material_type.impl;

import com.skysport.inerfaces.bean.basic.MaterialTypeInfo;
import com.skysport.inerfaces.mapper.MaterialTypeManageMapper;
import com.skysport.inerfaces.model.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zhangjh on 2015/6/9.
 */
@Service("materialTypeManageService")
public class MaterialTypeManageServiceImpl extends CommonServiceImpl<MaterialTypeInfo> implements InitializingBean {
    @Resource(name = "materialTypeManageDao")
    private MaterialTypeManageMapper materialTypeManageDao;

    @Override
    public void afterPropertiesSet()  {
        commonDao = materialTypeManageDao;
    }
}
