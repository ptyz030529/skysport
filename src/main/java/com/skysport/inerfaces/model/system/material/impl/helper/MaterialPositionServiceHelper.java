package com.skysport.inerfaces.model.system.material.impl.helper;

import com.skysport.core.bean.system.SelectItem2;
import com.skysport.core.instance.SystemBaseInfo;
import com.skysport.inerfaces.model.system.material.impl.MaterialPositionServiceImpl;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * 类说明:
 * Created by zhangjh on 2015/7/7.
 */
public enum MaterialPositionServiceHelper {
    SINGLETONE;

    public void refreshSelect(ApplicationContext appContext) {
        MaterialPositionServiceImpl materialPositionService = (MaterialPositionServiceImpl) appContext.getBean("materialPositionService");
        List<SelectItem2> positionItems = materialPositionService.querySelectList(null);
        SystemBaseInfo.SINGLETONE.pushBom("positionItems", positionItems);
    }
}
