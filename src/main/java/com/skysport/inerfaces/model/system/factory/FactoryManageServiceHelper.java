package com.skysport.inerfaces.model.system.factory;

import com.skysport.core.bean.system.SelectItem2;
import com.skysport.core.instance.SystemBaseInfo;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * 类说明:
 * Created by zhangjh on 2015/7/7.
 */
public enum FactoryManageServiceHelper {
    SINGLETONE;

    public void refreshSelect(ApplicationContext appContext) {
        FactoryManageServiceImpl factoryManageService = (FactoryManageServiceImpl) appContext.getBean("factoryManageService");
        List<SelectItem2> factoryItems = factoryManageService.querySelectList(null);
        SystemBaseInfo.SINGLETONE.pushBom("factoryItems", factoryItems);
    }
}
