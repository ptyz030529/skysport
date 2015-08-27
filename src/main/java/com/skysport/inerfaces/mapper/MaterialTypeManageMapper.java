package com.skysport.inerfaces.mapper;

import com.skysport.inerfaces.bean.system.MaterialTypeInfo;
import org.springframework.stereotype.Component;

/**
 * Created by zhangjh on 2015/6/17.
 */
@Component("materialTypeManageDao")
public interface MaterialTypeManageMapper extends   CommonDao<MaterialTypeInfo> {
}
