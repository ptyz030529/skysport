package com.skysport.inerfaces.model.system.category;

import com.skysport.inerfaces.bean.system.CategoryInfo;
import com.skysport.inerfaces.dao.CategoryManageMapper;
import com.skysport.inerfaces.model.system.common.service.impl.CommonServiceImpl;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zhangjh on 2015/6/9.
 */
@Service("categoryManageService")
public class CategoryManageServiceImpl extends CommonServiceImpl<CategoryInfo> implements InitializingBean {
    @Resource(name = "categoryManageMapper")
    private CategoryManageMapper categoryManageMapper;

    @Override
    public void afterPropertiesSet() throws Exception {
        commonDao = categoryManageMapper;
    }
}
