package com.skysport.inerfaces.dao.material;

import com.skysport.inerfaces.bean.system.MaterialPositionInfo;
import com.skysport.inerfaces.dao.CommonDao;
import org.springframework.stereotype.Component;

/**
 * 类说明:
 * Created by zhangjh on 2015/7/2.
 */
@Component("materialPositionManageDao")
public interface MaterialPositionManageDao extends CommonDao<MaterialPositionInfo> {
}
