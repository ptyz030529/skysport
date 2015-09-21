package com.skysport.inerfaces.mapper;

import com.skysport.inerfaces.bean.basic.YearConfInfo;
import org.springframework.stereotype.Component;

/**
 * Created by zhangjh on 2015/6/17.
 */
@Component("yearConfManageDao")
public interface YearConfManageMapper extends CommonDao<YearConfInfo> {
    
}
