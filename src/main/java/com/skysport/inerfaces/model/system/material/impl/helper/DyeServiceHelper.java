package com.skysport.inerfaces.model.system.material.impl.helper;

import com.skysport.core.bean.system.SelectItem2;
import com.skysport.core.instance.SystemBaseInfo;
import com.skysport.inerfaces.model.system.material.impl.DyeServiceImpl;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * 类说明:
 * Created by zhangjh on 2015/7/7.
 */
public enum DyeServiceHelper {
    SINGLETONE;

    public void refreshSelect(ApplicationContext appContext) {
        DyeServiceImpl dyeService = (DyeServiceImpl) appContext.getBean("dyeService");
        List<SelectItem2> dyeItems = dyeService.querySelectList(null);
        SystemBaseInfo.SINGLETONE.pushBom("dyeItems", dyeItems);
    }
}
