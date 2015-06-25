package com.skysport.inerfaces.model.system.material.impl;

import com.skysport.inerfaces.bean.material.FinishInfo;
import com.skysport.inerfaces.dao.material.FinishDao;
import com.skysport.inerfaces.model.system.common.service.impl.CommonServiceImpl;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

/**
 * 类说明:
 * Created by zhangjh on 2015/6/25.
 */
@Component("finishService")
public class FinishServiceImpl  extends CommonServiceImpl<FinishInfo> implements InitializingBean {
    @Resource(name = "finishDao")
    private FinishDao finishDao;

    @Override
    public void afterPropertiesSet() throws Exception {
        commonDao = finishDao;
    }
}
