package com.skysport.inerfaces.model.system.area.impl;

import com.skysport.inerfaces.bean.CustomerInfo;
import com.skysport.inerfaces.dao.AreaManageDao;
import com.skysport.inerfaces.model.system.common.service.impl.CommonServiceImpl;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zhangjh on 2015/6/9.
 */
@Service("areaManageService")
public class AreaManageServiceImpl extends CommonServiceImpl<CustomerInfo> implements InitializingBean {
    @Resource(name = "areaManageDao")
    private AreaManageDao<CustomerInfo> areaManageDao;

    @Override
    public void afterPropertiesSet() throws Exception {
        commonDao = areaManageDao;
    }
}