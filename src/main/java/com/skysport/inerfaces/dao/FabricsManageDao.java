package com.skysport.inerfaces.dao;

import com.skysport.inerfaces.bean.FabricsInfo;
import org.springframework.stereotype.Component;

/**
 * 类说明:
 * Created by zhangjh on 2015/6/29.
 */
@Component("fabricsManageDao")
public interface FabricsManageDao extends CommonDao<FabricsInfo> {
}
