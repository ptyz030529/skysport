package com.skysport.inerfaces.model.system.fabrics.impl;

import com.skysport.inerfaces.bean.FabricsInfo;
import com.skysport.inerfaces.dao.FabricsManageDao;
import com.skysport.inerfaces.model.system.common.service.impl.CommonServiceImpl;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * 类说明:
 * Created by zhangjh on 2015/6/29.
 */
@Service("fabricsManageService")
public class FabricsServiceImpl extends CommonServiceImpl<FabricsInfo> implements InitializingBean {
    @Resource(name = "fabricsManageDao")
    private FabricsManageDao fabricsManageDao;

    @Override
    public void afterPropertiesSet() throws Exception {
        commonDao = fabricsManageDao;
    }
}