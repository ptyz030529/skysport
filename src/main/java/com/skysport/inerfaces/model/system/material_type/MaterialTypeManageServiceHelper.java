package com.skysport.inerfaces.model.system.material_type;

import com.skysport.core.bean.system.SelectItem;
import com.skysport.core.instance.SystemBaseInfo;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * 类说明:
 * Created by zhangjh on 2015/7/7.
 */
public enum MaterialTypeManageServiceHelper {
    SINGLETONE;

    public void refreshSelect(ApplicationContext appContext) {
        //材料类别
        MaterialTypeManageServiceImpl materialTypeManageService = (MaterialTypeManageServiceImpl) appContext.getBean("materialTypeManageService");
        List<SelectItem>  materialTypeItems = materialTypeManageService.querySelectList(null);
        SystemBaseInfo.SINGLETONE.pushBom("materialTypeItems", materialTypeItems);
    }
}
