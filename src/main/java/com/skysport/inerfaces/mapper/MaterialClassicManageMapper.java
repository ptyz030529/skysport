package com.skysport.inerfaces.mapper;

import com.skysport.inerfaces.bean.system.MaterialClassicInfo;
import org.springframework.stereotype.Component;

/**
 * Created by zhangjh on 2015/6/17.
 */
@Component("materialClassicManageDao")
public interface MaterialClassicManageMapper extends CommonDao<MaterialClassicInfo> {
}
