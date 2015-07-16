package com.skysport.inerfaces.model.system.material.impl.helper;

import com.skysport.core.bean.system.SelectItem;
import com.skysport.core.instance.SystemBaseInfo;
import com.skysport.inerfaces.model.system.material.impl.WorkmanshipOfBondingLaminatingCoatingServiceImpl;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * 类说明:
 * Created by zhangjh on 2015/7/7.
 */
public enum WorkmanshipOfBondingLaminatingCoatingServiceHelper {
    SINGLETONE;

    public void refreshSelect(ApplicationContext appContext) {
        WorkmanshipOfBondingLaminatingCoatingServiceImpl workmanshipOfBondingLaminatingCoatingService = (WorkmanshipOfBondingLaminatingCoatingServiceImpl) appContext.getBean("workmanshipOfBondingLaminatingCoatingService");
        List<SelectItem> wblcItems = workmanshipOfBondingLaminatingCoatingService.querySelectList(null);
        SystemBaseInfo.SINGLETONE.pushBom("wblcItems", wblcItems);
    }

}
