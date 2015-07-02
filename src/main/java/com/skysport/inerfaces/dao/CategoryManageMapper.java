package com.skysport.inerfaces.dao;

import com.skysport.inerfaces.bean.system.CategoryInfo;
import org.springframework.stereotype.Component;

/**
 * 类说明:
 * Created by zhangjh on 2015/7/2.
 */
@Component("categoryManageMapper")
public interface CategoryManageMapper extends CommonDao<CategoryInfo> {
}
