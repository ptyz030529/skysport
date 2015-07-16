package com.skysport.inerfaces.model.system.product_type;

import com.skysport.core.bean.system.SelectItem;
import com.skysport.core.instance.SystemBaseInfo;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * 类说明:
 * Created by zhangjh on 2015/7/7.
 */
public enum ProductTypeManageServiceHelper {
    SINGLETONE;

    public void refreshSelect(ApplicationContext appContext) {
        ProductTypeManageServiceImpl productTypeManageService = (ProductTypeManageServiceImpl) appContext.getBean("productTypeManageService");
        List<SelectItem> productTypeItems = productTypeManageService.querySelectList(null);
        SystemBaseInfo.SINGLETONE.pushBom("productTypeItems", productTypeItems);
    }
}
