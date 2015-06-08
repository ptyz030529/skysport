package com.skysport.inerfaces.dao;

import org.springframework.stereotype.Component;

/**
 * Created by zhangjh on 2015/6/3.
 */
@Component("customerManageDao")
public interface CustomerManageDao<CustomerInfo> extends CommonDao<CustomerInfo>{

}
