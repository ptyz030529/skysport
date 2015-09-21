package com.skysport.inerfaces.mapper;

import com.skysport.inerfaces.bean.basic.SexInfo;
import org.springframework.stereotype.Component;

/**
 * Created by zhangjh on 2015/6/17.
 */
@Component("sexManageDao")
public interface SexManageMapper extends CommonDao<SexInfo> {

}
