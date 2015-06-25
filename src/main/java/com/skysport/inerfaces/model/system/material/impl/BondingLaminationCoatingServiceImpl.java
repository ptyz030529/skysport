package com.skysport.inerfaces.model.system.material.impl;

import com.skysport.inerfaces.bean.material.BondingLaminationCoatingInfo;
import com.skysport.inerfaces.dao.material.BondingLaminationCoatingDao;
import com.skysport.inerfaces.model.system.common.service.impl.CommonServiceImpl;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

/**
 * 类说明:复合或涂层
 * Created by zhangjh on 2015/6/25.
 */
@Component("bondingLaminationCoatingService")
public class BondingLaminationCoatingServiceImpl extends CommonServiceImpl<BondingLaminationCoatingInfo> implements InitializingBean {
    @Resource(name = "bondingLaminationCoatingDao")
    private BondingLaminationCoatingDao bondingLaminationCoatingDao;

    @Override
    public void afterPropertiesSet() throws Exception {
        commonDao = bondingLaminationCoatingDao;
    }
}
