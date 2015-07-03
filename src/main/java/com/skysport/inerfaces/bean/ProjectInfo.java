package com.skysport.inerfaces.bean;

import com.skysport.core.bean.SelectItem;

/**
 * 类说明:
 * Created by zhangjh on 2015/7/2.
 */
public class ProjectInfo extends SelectItem {
    private String id;
    private String remark;
    private String updateTime;
    private int delFlag;
    private String projectId;
    private String projectName;
    private String yearCode;
    private String customerId;
    private String areaId;
    private String seriesId;
    private String creater;
    private String createTime;
    private String version;
    /**
     * 推销样交期
     */
    private String sampleDelivery;
    /**
     * 是否需要打色样
     */
    private int isNeedSwatch;
    /**
     * 是否需要预报价
     */
    private int isNeedPreOffer;
    /**
     * 需要预报价的时间
     */
    private String needPreOfferDate;
    /**
     * 产品描述收到时间
     */
    private String sketchReceivedDate;
    /**
     * 文件位置
     */
    private String fileLocation;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getRemark() {
        return remark;
    }

    @Override
    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String getUpdateTime() {
        return updateTime;
    }

    @Override
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public int getDelFlag() {
        return delFlag;
    }

    @Override
    public void setDelFlag(int delFlag) {
        this.delFlag = delFlag;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getYearCode() {
        return yearCode;
    }

    public void setYearCode(String yearCode) {
        this.yearCode = yearCode;
    }

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

    public String getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(String seriesId) {
        this.seriesId = seriesId;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSampleDelivery() {
        return sampleDelivery;
    }

    public void setSampleDelivery(String sampleDelivery) {
        this.sampleDelivery = sampleDelivery;
    }

    public int getIsNeedSwatch() {
        return isNeedSwatch;
    }

    public void setIsNeedSwatch(int isNeedSwatch) {
        this.isNeedSwatch = isNeedSwatch;
    }

    public int getIsNeedPreOffer() {
        return isNeedPreOffer;
    }

    public void setIsNeedPreOffer(int isNeedPreOffer) {
        this.isNeedPreOffer = isNeedPreOffer;
    }

    public String getNeedPreOfferDate() {
        return needPreOfferDate;
    }

    public void setNeedPreOfferDate(String needPreOfferDate) {
        this.needPreOfferDate = needPreOfferDate;
    }

    public String getSketchReceivedDate() {
        return sketchReceivedDate;
    }

    public void setSketchReceivedDate(String sketchReceivedDate) {
        this.sketchReceivedDate = sketchReceivedDate;
    }

    public String getFileLocation() {
        return fileLocation;
    }

    public void setFileLocation(String fileLocation) {
        this.fileLocation = fileLocation;
    }
}