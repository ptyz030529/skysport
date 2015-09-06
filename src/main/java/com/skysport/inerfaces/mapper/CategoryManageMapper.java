package com.skysport.inerfaces.mapper;

import com.skysport.core.bean.system.SelectItem2;
import com.skysport.inerfaces.bean.system.CategoryInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 类说明:
 * Created by zhangjh on 2015/7/2.
 */
@Component("categoryManageMapper")
public interface CategoryManageMapper extends CommonDao<CategoryInfo> {
    /**
     * 查询指定级别的品类
     *
     * @param levelId 级别的品类
     */
    List<SelectItem2> querySelectListByLevelId(String levelId);

    List<CategoryInfo> searchChildCategoryByCategoryId(@Param(value = "categoryId") String categoryId);
}
