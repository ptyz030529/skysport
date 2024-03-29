package com.skysport.inerfaces.model.system.material.impl.helper;

import com.skysport.core.bean.system.SelectItem2;
import com.skysport.core.instance.SystemBaseInfo;
import com.skysport.inerfaces.model.system.material.impl.MaterialUnitServiceImpl;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * 类说明:
 * Created by zhangjh on 2015/7/7.
 */
public enum MaterialUnitServiceHelper {
    SINGLETONE;

    public void refreshSelect(ApplicationContext appContext) {
        MaterialUnitServiceImpl materialUnitService = (MaterialUnitServiceImpl) appContext.getBean("materialUnitService");
        List<SelectItem2> unitItems = materialUnitService.querySelectList(null);
        SystemBaseInfo.SINGLETONE.pushBom("unitItems", unitItems);
    }
}
