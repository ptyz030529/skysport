package com.skysport.inerfaces.model.system.material.impl;

import com.skysport.inerfaces.bean.basic.MaterialPositionInfo;
import com.skysport.inerfaces.mapper.material.MaterialPositionManageDao;
import com.skysport.inerfaces.model.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 类说明:
 * Created by zhangjh on 2015/6/25.
 */
@Component("materialPositionService")
public class MaterialPositionServiceImpl extends CommonServiceImpl<MaterialPositionInfo> implements InitializingBean {
    @Resource(name = "materialPositionManageDao")
    private MaterialPositionManageDao materialPositionManageDao;

    @Override
    public void afterPropertiesSet()  {
        commonDao = materialPositionManageDao;
    }
}
