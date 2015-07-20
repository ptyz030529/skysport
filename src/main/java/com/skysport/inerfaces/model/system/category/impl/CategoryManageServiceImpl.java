package com.skysport.inerfaces.model.system.category.impl;

import com.skysport.core.bean.system.SelectItem2;
import com.skysport.inerfaces.bean.system.CategoryInfo;
import com.skysport.inerfaces.mapper.CategoryManageMapper;
import com.skysport.inerfaces.model.common.impl.CommonServiceImpl;
import com.skysport.inerfaces.model.system.category.ICategoryManageService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangjh on 2015/6/9.
 */
@Service("categoryManageService")
public class CategoryManageServiceImpl extends CommonServiceImpl<CategoryInfo> implements ICategoryManageService<CategoryInfo>, InitializingBean {
    @Resource(name = "categoryManageMapper")
    private CategoryManageMapper categoryManageMapper;

    @Override
    public void afterPropertiesSet() throws Exception {
        commonDao = categoryManageMapper;
    }


    @Override
    public List<SelectItem2> querySelectListByLevelId(String levelId) {
        return categoryManageMapper.querySelectListByLevelId(levelId);
    }


}
