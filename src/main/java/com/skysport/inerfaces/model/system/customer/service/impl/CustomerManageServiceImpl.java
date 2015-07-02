package com.skysport.inerfaces.model.system.customer.service.impl;

import com.skysport.inerfaces.bean.system.CustomerInfo;
import com.skysport.inerfaces.dao.CustomerManageDao;
import com.skysport.inerfaces.model.system.common.service.impl.CommonServiceImpl;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zhangjh on 2015/6/3.
 */
@Service("customerManageService")
public class CustomerManageServiceImpl extends CommonServiceImpl<CustomerInfo> implements InitializingBean {
    @Resource(name = "customerManageDao")
    private CustomerManageDao customerManageDao;

    @Override
    public void afterPropertiesSet() throws Exception {
        commonDao = customerManageDao;
    }
}
