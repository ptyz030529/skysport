package com.skysport.inerfaces.mapper.material;

import com.skysport.inerfaces.bean.material.WaterVapourPermeabilityInfo;
import com.skysport.inerfaces.mapper.CommonDao;
import org.springframework.stereotype.Component;

/**
 * 类说明:
 * Created by zhangjh on 2015/6/25.
 */
@Component("waterVapourPermeabilityDao")
public interface WaterVapourPermeabilityDao extends CommonDao<WaterVapourPermeabilityInfo> {
}
