package com.skysport.inerfaces.model.system.material_classic;

import com.skysport.core.bean.system.SelectItem;
import com.skysport.core.instance.SystemBaseInfo;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * 类说明:
 * Created by zhangjh on 2015/7/7.
 */
public enum MaterialClassicManageServiceHelper {

    SINGLETONE;

    public void refreshSelect(ApplicationContext appContext) {
        MaterialClassicManageServiceImpl materialClassicManageService = (MaterialClassicManageServiceImpl) appContext.getBean("materialClassicManageService");
        List<SelectItem> materialClassicItems = materialClassicManageService.querySelectList(null);
        SystemBaseInfo.SINGLETONE.pushBom("materialClassicItems", materialClassicItems);
    }


}
