package com.skysport.inerfaces.bean;

import com.skysport.core.bean.CommonBean;

/**
 * 区域表
 * Created by zhangjh on 2015/6/9.
 */
public class AreaInfo extends CommonBean {
    private String areaId ;
    private String remark;
    private String customerName;
    /**
     * 关联客户信息
     */
    private String customerId;
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
