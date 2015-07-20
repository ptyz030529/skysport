package com.skysport.inerfaces.model.system.material.impl.helper;

import com.skysport.core.bean.system.SelectItem2;
import com.skysport.core.instance.SystemBaseInfo;
import com.skysport.inerfaces.model.system.material.impl.MaterialOfMembraneCoatingServiceImpl;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * 类说明:
 * Created by zhangjh on 2015/7/7.
 */
public enum MaterialOfMembraneCoatingServicHelper {
    SINGLETONE;
    public void refreshSelect(ApplicationContext appContext) {
        MaterialOfMembraneCoatingServiceImpl materialOfMembraneCoatingService = (MaterialOfMembraneCoatingServiceImpl) appContext.getBean("materialOfMembraneCoatingService");
        List<SelectItem2> momcItems = materialOfMembraneCoatingService.querySelectList(null);
        SystemBaseInfo.SINGLETONE.pushBom("momcItems", momcItems);
    }
}
