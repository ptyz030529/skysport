package com.skysport.inerfaces.bean;

import com.skysport.core.bean.SelectItem;

/**
 * 类说明:
 * Created by zhangjh on 2015/7/2.
 */
public class ProjectBaseInfo extends SelectItem {
    private String id;
    private String remark;
    private String updateTime;
    private int delFlag;
    private String projectId;
    private String projectName;
    private String categoryAid;
    private String categoryAname;
    private String categoryBid;
    private String categoryBname;
    private int collectionNumber;
    private String mainColorIds;

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

    public String getCategoryAid() {
        return categoryAid;
    }

    public void setCategoryAid(String categoryAid) {
        this.categoryAid = categoryAid;
    }

    public String getCategoryAname() {
        return categoryAname;
    }

    public void setCategoryAname(String categoryAname) {
        this.categoryAname = categoryAname;
    }

    public String getCategoryBid() {
        return categoryBid;
    }

    public void setCategoryBid(String categoryBid) {
        this.categoryBid = categoryBid;
    }

    public String getCategoryBname() {
        return categoryBname;
    }

    public void setCategoryBname(String categoryBname) {
        this.categoryBname = categoryBname;
    }

    public int getCollectionNumber() {
        return collectionNumber;
    }

    public void setCollectionNumber(int collectionNumber) {
        this.collectionNumber = collectionNumber;
    }

    public String getMainColorIds() {
        return mainColorIds;
    }

    public void setMainColorIds(String mainColorIds) {
        this.mainColorIds = mainColorIds;
    }
}
