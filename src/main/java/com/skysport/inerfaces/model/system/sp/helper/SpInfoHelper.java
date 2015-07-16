package com.skysport.inerfaces.model.system.sp.helper;

import com.skysport.core.bean.system.SelectItem;
import com.skysport.core.instance.SystemBaseInfo;
import com.skysport.inerfaces.model.system.sp.service.impl.SpManageServiceImpl;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * Created by zhangjh on 2015/6/1.
 */
public enum SpInfoHelper {
    /**
     *
     */
    SINGLETONE;

    public void refreshSelect(ApplicationContext appContext) {
        SpManageServiceImpl spManageService = (SpManageServiceImpl) appContext.getBean("spManageService");
        List<SelectItem> spItems = spManageService.querySelectList(null);
        SystemBaseInfo.SINGLETONE.pushBom("spItems", spItems);
    }
}
