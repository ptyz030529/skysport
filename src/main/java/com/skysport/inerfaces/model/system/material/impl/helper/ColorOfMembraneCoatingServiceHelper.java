package com.skysport.inerfaces.model.system.material.impl.helper;

import com.skysport.core.bean.system.SelectItem2;
import com.skysport.core.instance.SystemBaseInfo;
import com.skysport.inerfaces.model.system.material.impl.ColorOfMembraneCoatingServiceImpl;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * 类说明:
 * Created by zhangjh on 2015/7/7.
 */
public enum ColorOfMembraneCoatingServiceHelper {
    SINGLETONE;

    public void refreshSelect(ApplicationContext appContext) {
        ColorOfMembraneCoatingServiceImpl colorOfMembraneCoatingService = (ColorOfMembraneCoatingServiceImpl) appContext.getBean("colorOfMembraneCoatingService");
        List<SelectItem2> comocItems = colorOfMembraneCoatingService.querySelectList(null);
        SystemBaseInfo.SINGLETONE.pushBom("comocItems", comocItems);
    }
}
