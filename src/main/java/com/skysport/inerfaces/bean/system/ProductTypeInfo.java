package com.skysport.inerfaces.bean.system;import com.skysport.core.bean.SelectItem;/** * 品名 */public class ProductTypeInfo extends SelectItem {    private String id;    /**     *     */    private String productTypeId;    private String productTypeName;    private String materialTypeId;    private String materialTypeName;    private int delFlag;    private String updateTime;    private String remark;    public String getUpdateTime() {        return updateTime;    }    public void setUpdateTime(String updateTime) {        this.updateTime = updateTime;    }    public String getId() {        return id;    }    public void setId(String id) {        this.id = id;    }    public String getProductTypeId() {        return productTypeId;    }    public void setProductTypeId(String productTypeId) {        this.productTypeId = productTypeId;    }    public String getProductTypeName() {        return productTypeName;    }    public void setProductTypeName(String productTypeName) {        this.productTypeName = productTypeName;    }    public String getMaterialTypeId() {        return materialTypeId;    }    public void setMaterialTypeId(String materialTypeId) {        this.materialTypeId = materialTypeId;    }    public String getMaterialTypeName() {        return materialTypeName;    }    public void setMaterialTypeName(String materialTypeName) {        this.materialTypeName = materialTypeName;    }    public int getDelFlag() {        return delFlag;    }    public void setDelFlag(int delFlag) {        this.delFlag = delFlag;    }    public String getRemark() {        return remark;    }    public void setRemark(String remark) {        this.remark = remark;    }}