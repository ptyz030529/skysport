package com.skysport.inerfaces.model.system.material.impl.helper;

import com.skysport.core.bean.system.SelectItem2;
import com.skysport.core.instance.SystemBaseInfo;
import com.skysport.inerfaces.model.system.material.impl.MembraneThicknessServiceImpl;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * 类说明:
 * Created by zhangjh on 2015/7/7.
 */
public enum MembraneThicknessServiceHelper {
    SINGLETONE;

    public void refreshSelect(ApplicationContext appContext) {
        MembraneThicknessServiceImpl membraneThicknessService = (MembraneThicknessServiceImpl) appContext.getBean("membraneThicknessService");
        List<SelectItem2> mtItems = membraneThicknessService.querySelectList(null);
        SystemBaseInfo.SINGLETONE.pushBom("mtItems", mtItems);
    }
}
