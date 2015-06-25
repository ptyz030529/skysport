package com.skysport.inerfaces.bean.material;

import com.skysport.core.bean.CommonBean;

/**
 * 类说明:后整理（所添加的功能性助剂）
 * Created by zhangjh on 2015/6/25.
 */
public class FinishInfo extends CommonBean {
    private String id;
    private String finishId;
    private String finishName;
    private int levelId;
    private String remark;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFinishId() {
        return finishId;
    }

    public void setFinishId(String finishId) {
        this.finishId = finishId;
    }

    public String getFinishName() {
        return finishName;
    }

    public void setFinishName(String finishName) {
        this.finishName = finishName;
    }
}
