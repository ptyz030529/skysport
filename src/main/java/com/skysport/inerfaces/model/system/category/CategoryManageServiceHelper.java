package com.skysport.inerfaces.model.system.category;

import com.skysport.core.bean.system.SelectItem;
import com.skysport.core.instance.SystemBaseInfo;
import com.skysport.inerfaces.constant.SystemInfoConstant;
import com.skysport.inerfaces.model.system.category.impl.CategoryManageServiceImpl;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * 类说明:
 * Created by zhangjh on 2015/7/7.
 */
public enum CategoryManageServiceHelper {
    SINGLETONE;

    public void refreshSelect(ApplicationContext appContext) {
        CategoryManageServiceImpl categoryManageService = (CategoryManageServiceImpl) appContext.getBean("categoryManageService");
        List<SelectItem> categoryAItems = categoryManageService.querySelectListByLevelId(SystemInfoConstant.CATEGORY_A_LEVEL);
        List<SelectItem> categoryBItems = categoryManageService.querySelectListByLevelId(SystemInfoConstant.CATEGORY_B_LEVEL);
        SystemBaseInfo.SINGLETONE.pushProject("categoryAItems", categoryAItems);
        SystemBaseInfo.SINGLETONE.pushProject("categoryBItems", categoryBItems);
    }
}
