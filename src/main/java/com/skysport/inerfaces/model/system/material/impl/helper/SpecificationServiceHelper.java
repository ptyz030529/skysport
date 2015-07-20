package com.skysport.inerfaces.model.system.material.impl.helper;

import com.skysport.core.bean.system.SelectItem2;
import com.skysport.core.instance.SystemBaseInfo;
import com.skysport.inerfaces.model.system.material.impl.SpecificationServiceImpl;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * 类说明:
 * Created by zhangjh on 2015/7/7.
 */
public enum SpecificationServiceHelper {
    SINGLETONE;

    public void refreshSelect(ApplicationContext appContext) {
        SpecificationServiceImpl specificationService = (SpecificationServiceImpl) appContext.getBean("specificationService");
        List<SelectItem2> specficationItems = specificationService.querySelectList(null);
        SystemBaseInfo.SINGLETONE.pushBom("specficationItems", specficationItems);
    }
}
