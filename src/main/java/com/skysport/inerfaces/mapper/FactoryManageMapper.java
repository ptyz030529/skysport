package com.skysport.inerfaces.mapper;

import com.skysport.inerfaces.bean.system.FactoryInfo;
import org.springframework.stereotype.Component;

/**
 * Created by zhangjh on 2015/6/9.
 */
@Component("factoryManageMapper")
public interface FactoryManageMapper extends CommonDao<FactoryInfo> {
}
