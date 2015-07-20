package com.skysport.inerfaces.model.system.sex;

import com.skysport.core.bean.system.SelectItem2;
import com.skysport.core.instance.SystemBaseInfo;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * 类说明:
 * Created by zhangjh on 2015/7/7.
 */
public enum SexManageServiceHelper {
    SINGLETONE;
    public void refreshSelect(ApplicationContext appContext) {
        SexManageServiceImpl sexManageService = (SexManageServiceImpl) appContext.getBean("sexManageService");
        List<SelectItem2> sexItems = sexManageService.querySelectList(null);
        SystemBaseInfo.SINGLETONE.pushProject("sexItems", sexItems);
    }
}
