package com.skysport.inerfaces.model.system.material.impl;

import com.skysport.inerfaces.bean.basic.MaterialUnitInfo;
import com.skysport.inerfaces.mapper.material.MaterialUnitManageDao;
import com.skysport.inerfaces.model.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 类说明:
 * Created by zhangjh on 2015/6/25.
 */
@Component("materialUnitService")
public class MaterialUnitServiceImpl extends CommonServiceImpl<MaterialUnitInfo> implements InitializingBean {
    @Resource(name = "materialUnitManageDao")
    private MaterialUnitManageDao materialUnitManageDao;

    @Override
    public void afterPropertiesSet()  {
        commonDao = materialUnitManageDao;
    }
}
