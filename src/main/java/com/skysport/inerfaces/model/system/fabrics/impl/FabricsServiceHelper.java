package com.skysport.inerfaces.model.system.fabrics.impl;

import com.skysport.core.bean.system.SelectItem;
import com.skysport.core.instance.SystemBaseInfo;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * 类说明:
 * Created by zhangjh on 2015/7/7.
 */
public enum FabricsServiceHelper {
    SINGLETONE;

    public void refreshSelect(ApplicationContext appContext) {
        FabricsServiceImpl fabricsManageService = (FabricsServiceImpl) appContext.getBean("fabricsManageService");
        List<SelectItem> fabricsItems = fabricsManageService.querySelectList(null);
        SystemBaseInfo.SINGLETONE.pushBom("fabricsItems", fabricsItems);
    }
}
