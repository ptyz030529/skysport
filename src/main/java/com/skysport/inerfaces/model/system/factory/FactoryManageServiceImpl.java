package com.skysport.inerfaces.model.system.factory;

import com.skysport.inerfaces.bean.basic.FactoryInfo;
import com.skysport.inerfaces.mapper.FactoryManageMapper;
import com.skysport.inerfaces.model.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zhangjh on 2015/6/9.
 */
@Service("factoryManageService")
public class FactoryManageServiceImpl extends CommonServiceImpl<FactoryInfo> implements InitializingBean {
    @Resource(name = "factoryManageMapper")
    private FactoryManageMapper factoryManageDao;

    @Override
    public void afterPropertiesSet()  {
        commonDao = factoryManageDao;
    }
}
