package com.skysport.inerfaces.model.system.material.impl.helper;

import com.skysport.core.bean.system.SelectItem2;
import com.skysport.core.instance.SystemBaseInfo;
import com.skysport.inerfaces.model.system.material.impl.WaterVapourPermeabilityServiceImpl;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * 类说明:
 * Created by zhangjh on 2015/7/7.
 */
public enum WaterVapourPermeabilityServiceHelper {
    SINGLETONE;

    public void refreshSelect(ApplicationContext appContext) {
        WaterVapourPermeabilityServiceImpl waterVapourPermeabilityService = (WaterVapourPermeabilityServiceImpl) appContext.getBean("waterVapourPermeabilityService");
        List<SelectItem2> wvpItems = waterVapourPermeabilityService.querySelectList(null);
        SystemBaseInfo.SINGLETONE.pushBom("wvpItems", wvpItems);
    }
}
