package com.skysport.inerfaces.bean;import com.skysport.core.bean.CommonBean;/** * */public class MaterialTypeInfo extends CommonBean {    /**     *     */    private String id;    /**     *     */    private String materialTypeId;    /**     *     */    private String materialTypeCode;    /**     *     */    private String materialTypeName;    /**     *     */    private String levelId;    /**     *     */    private String delFlag;    /**     *     */    private String remark;    /**     *     */    private String updateTime;    public String getId() {        return id;    }    public void setId(String id) {        this.id = id;    }    public String getMaterialTypeId() {        return materialTypeId;    }    public void setMaterialTypeId(String materialTypeId) {        this.materialTypeId = materialTypeId;    }    public String getMaterialTypeCode() {        return materialTypeCode;    }    public void setMaterialTypeCode(String materialTypeCode) {        this.materialTypeCode = materialTypeCode;    }    public String getMaterialTypeName() {        return materialTypeName;    }    public void setMaterialTypeName(String materialTypeName) {        this.materialTypeName = materialTypeName;    }    public String getLevelId() {        return levelId;    }    public void setLevelId(String levelId) {        this.levelId = levelId;    }    public String getDelFlag() {        return delFlag;    }    public void setDelFlag(String delFlag) {        this.delFlag = delFlag;    }    public String getRemark() {        return remark;    }    public void setRemark(String remark) {        this.remark = remark;    }    public String getUpdateTime() {        return updateTime;    }    public void setUpdateTime(String updateTime) {        this.updateTime = updateTime;    }}