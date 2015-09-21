package com.skysport.inerfaces.mapper;

import com.skysport.inerfaces.bean.basic.CustomerInfo;
import org.springframework.stereotype.Component;

/**
 * Created by zhangjh on 2015/6/3.
 */
@Component("customerManageDao")
public interface CustomerManageMapper extends CommonDao<CustomerInfo>{

}
