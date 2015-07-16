package com.skysport.inerfaces.model.system.year_conf;

import com.skysport.core.bean.system.SelectItem;
import com.skysport.core.instance.SystemBaseInfo;
import org.springframework.context.ApplicationContext;
import java.util.List;

/**
 * 类说明:
 * Created by zhangjh on 2015/7/7.
 */
public enum YearConfManageServiceHelper {
    SINGLETONE;
    public void refreshSelect(ApplicationContext appContext) {
        YearConfManageServiceImpl yearConfManageService = (YearConfManageServiceImpl) appContext.getBean("yearConfManageService");
        List<SelectItem> yearItems = yearConfManageService.querySelectList(null);
        SystemBaseInfo.SINGLETONE.pushBom("yearItems", yearItems);
        SystemBaseInfo.SINGLETONE.pushProject("yearItems", yearItems);
    }
}
