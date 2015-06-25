package com.skysport.inerfaces.bean.material;

import com.skysport.core.bean.CommonBean;

/**
 * 类说明:透湿程度（高透、中透、低透、不透气）
 * Created by zhangjh on 2015/6/25.
 */
public class WaterVapourPermeabilityInfo extends CommonBean {
    private String id;
    private String wvpId;
    private String wvpName;
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

    public String getWvpId() {
        return wvpId;
    }

    public void setWvpId(String wvpId) {
        this.wvpId = wvpId;
    }

    public String getWvpName() {
        return wvpName;
    }

    public void setWvpName(String wvpName) {
        this.wvpName = wvpName;
    }
}
