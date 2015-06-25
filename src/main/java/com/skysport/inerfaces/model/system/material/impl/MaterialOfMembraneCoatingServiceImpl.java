package com.skysport.inerfaces.model.system.material.impl;

import com.skysport.inerfaces.bean.material.MaterialOfMembraneCoatingInfo;
import com.skysport.inerfaces.dao.material.MaterialOfMembraneCoatingDao;
import com.skysport.inerfaces.model.system.common.service.impl.CommonServiceImpl;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

/**
 * 类说明:
 * Created by zhangjh on 2015/6/25.
 */
@Component("materialOfMembraneCoatingService")
public class MaterialOfMembraneCoatingServiceImpl  extends CommonServiceImpl<MaterialOfMembraneCoatingInfo> implements InitializingBean {
    @Resource(name = "materialOfMembraneCoatingDao")
    private MaterialOfMembraneCoatingDao materialOfMembraneCoatingDao;

    @Override
    public void afterPropertiesSet() throws Exception {
        commonDao = materialOfMembraneCoatingDao;
    }
}
