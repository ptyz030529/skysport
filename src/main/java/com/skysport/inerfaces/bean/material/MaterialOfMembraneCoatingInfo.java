package com.skysport.inerfaces.bean.material;

import com.skysport.core.bean.CommonBean;

/**
 * 类说明:膜或涂层的材质（PU膜、TPU膜、PTE膜、PTFE膜、PU涂层、PA涂层，等等）
 * Created by zhangjh on 2015/6/25.
 */
public class MaterialOfMembraneCoatingInfo extends CommonBean {

    private String id;
    private String mcId;
    private String mcName;
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

    public String getMcId() {
        return mcId;
    }

    public void setMcId(String mcId) {
        this.mcId = mcId;
    }

    public String getMcName() {
        return mcName;
    }

    public void setMcName(String mcName) {
        this.mcName = mcName;
    }


}
