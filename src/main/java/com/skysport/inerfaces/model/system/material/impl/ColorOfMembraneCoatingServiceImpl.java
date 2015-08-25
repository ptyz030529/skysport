package com.skysport.inerfaces.model.system.material.impl;

import com.skysport.inerfaces.bean.material.ColorOfMembraneCoatingInfo;
import com.skysport.inerfaces.mapper.material.ColorOfMembraneCoatingDao;
import com.skysport.inerfaces.model.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

/**
 * 类说明:
 * Created by zhangjh on 2015/6/25.
 */
@Component("colorOfMembraneCoatingService")
public class ColorOfMembraneCoatingServiceImpl extends CommonServiceImpl<ColorOfMembraneCoatingInfo> implements InitializingBean {
    @Resource(name = "colorOfMembraneCoatingDao")
    private ColorOfMembraneCoatingDao colorOfMembraneCoatingDao;

    @Override
    public void afterPropertiesSet()  {
        commonDao = colorOfMembraneCoatingDao;
    }

}
