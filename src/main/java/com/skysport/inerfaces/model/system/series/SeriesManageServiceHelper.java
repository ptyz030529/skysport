package com.skysport.inerfaces.model.system.series;

import com.skysport.core.bean.system.SelectItem;
import com.skysport.core.instance.SystemBaseInfo;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * 类说明:
 * Created by zhangjh on 2015/7/7.
 */
public enum SeriesManageServiceHelper {
    SINGLETONE;

    public void refreshSelect(ApplicationContext appContext) {
        SeriesManageServiceImpl seriesManageService = (SeriesManageServiceImpl) appContext.getBean("seriesManageService");
        List<SelectItem> seriesItems = seriesManageService.querySelectList(null);
        SystemBaseInfo.SINGLETONE.pushBom("seriesItems", seriesItems);
        SystemBaseInfo.SINGLETONE.pushProject("seriesItems", seriesItems);
    }
}
