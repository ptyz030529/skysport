package com.skysport.inerfaces.mapper;

import com.skysport.inerfaces.bean.system.AreaInfo;
import org.springframework.stereotype.Component;

/**
 * Created by zhangjh on 2015/6/9.
 */
@Component("areaManageDao")
public interface AreaManageDao extends CommonDao<AreaInfo> {

}
