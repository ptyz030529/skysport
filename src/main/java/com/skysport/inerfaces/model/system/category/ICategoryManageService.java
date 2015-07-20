package com.skysport.inerfaces.model.system.category;

import com.skysport.core.bean.system.SelectItem2;
import com.skysport.inerfaces.model.common.ICommonService;

import java.util.List;

/**
 * 类说明:
 * Created by zhangjh on 2015/7/14.
 */
public interface ICategoryManageService<T> extends ICommonService<T> {
    List<SelectItem2> querySelectListByLevelId(String levelId);
}
