package com.skysport.inerfaces.mapper.material;

import com.skysport.inerfaces.bean.basic.MaterialPositionInfo;
import com.skysport.inerfaces.mapper.CommonDao;
import org.springframework.stereotype.Component;

/**
 * 类说明:
 * Created by zhangjh on 2015/7/2.
 */
@Component("materialPositionManageDao")
public interface MaterialPositionManageDao extends CommonDao<MaterialPositionInfo> {
}
