package com.skysport.inerfaces.model.system.material.impl.helper;

import com.skysport.core.bean.system.SelectItem2;
import com.skysport.core.instance.SystemBaseInfo;
import com.skysport.inerfaces.model.system.material.impl.BondingLaminationCoatingServiceImpl;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * 类说明:
 * Created by zhangjh on 2015/7/7.
 */
public enum BondingLaminationCoatingServiceHelper {
    SINGLETONE;

    public void refreshSelect(ApplicationContext appContext) {
        BondingLaminationCoatingServiceImpl bondingLaminationCoatingService = (BondingLaminationCoatingServiceImpl) appContext.getBean("bondingLaminationCoatingService");
        List<SelectItem2> blcItems = bondingLaminationCoatingService.querySelectList(null);
        SystemBaseInfo.SINGLETONE.pushBom("blcItems", blcItems);
    }
}
