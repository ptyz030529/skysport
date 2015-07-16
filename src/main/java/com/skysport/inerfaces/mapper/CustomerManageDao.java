package com.skysport.inerfaces.mapper;

import com.skysport.inerfaces.bean.system.CustomerInfo;
import org.springframework.stereotype.Component;

/**
 * Created by zhangjh on 2015/6/3.
 */
@Component("customerManageDao")
public interface CustomerManageDao extends CommonDao<CustomerInfo>{

}
