package com.skysport.inerfaces.model.system.material.impl;

import com.skysport.inerfaces.bean.material.DyeInfo;
import com.skysport.inerfaces.dao.material.DyeDao;
import com.skysport.inerfaces.model.system.common.service.impl.CommonServiceImpl;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

/**
 * 类说明:
 * Created by zhangjh on 2015/6/25.
 */
@Component("dyeService")
public class DyeServiceImpl  extends CommonServiceImpl<DyeInfo> implements InitializingBean {
    @Resource(name = "dyeDao")
    private DyeDao dyeDao;

    @Override
    public void afterPropertiesSet() throws Exception {
        commonDao = dyeDao;
    }
}
