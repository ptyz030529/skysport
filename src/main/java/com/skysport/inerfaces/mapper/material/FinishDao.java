package com.skysport.inerfaces.mapper.material;

import com.skysport.inerfaces.bean.material.FinishInfo;
import com.skysport.inerfaces.mapper.CommonDao;
import org.springframework.stereotype.Component;

/**
 * 类说明:
 * Created by zhangjh on 2015/6/25.
 */
@Component("finishDao")
public interface FinishDao extends CommonDao<FinishInfo> {
}