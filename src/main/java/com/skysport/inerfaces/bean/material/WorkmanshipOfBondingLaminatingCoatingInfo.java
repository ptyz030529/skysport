package com.skysport.inerfaces.bean.material;

import com.skysport.core.bean.CommonBean;

/**
 * 类说明:贴膜或涂层工艺（离型纸转移贴膜、干法涂层、湿法涂层，等等）
 * Created by zhangjh on 2015/6/25.
 */
public class WorkmanshipOfBondingLaminatingCoatingInfo extends CommonBean {
    private String id;
    private String woblcid;
    private String woblcName;
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

    public String getWoblcid() {
        return woblcid;
    }

    public void setWoblcid(String woblcid) {
        this.woblcid = woblcid;
    }

    public String getWoblcName() {
        return woblcName;
    }

    public void setWoblcName(String woblcName) {
        this.woblcName = woblcName;
    }
}
