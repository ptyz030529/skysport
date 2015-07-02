package com.skysport.inerfaces.model.system.factory;

import com.skysport.inerfaces.bean.system.FactoryInfo;
import com.skysport.inerfaces.dao.FactoryManageDao;
import com.skysport.inerfaces.model.system.common.service.impl.CommonServiceImpl;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zhangjh on 2015/6/9.
 */
@Service("factoryManageService")
public class FactoryManageServiceImpl extends CommonServiceImpl<FactoryInfo> implements InitializingBean {
    @Resource(name = "factoryManageDao")
    private FactoryManageDao<FactoryInfo> factoryManageDao;

    @Override
    public void afterPropertiesSet() throws Exception {
        commonDao = factoryManageDao;
    }
}
