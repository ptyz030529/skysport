package com.skysport.inerfaces.bean.material;

import com.skysport.core.bean.CommonBean;

/**
 * 类说明:膜的厚度（以mm为单位，0.012mm、0.015mm、0.018mm，等等）
 * Created by zhangjh on 2015/6/25.
 */
public class MembraneThicknessInfo extends CommonBean {
    private String id;
    private String mtId;
    private String mtName;
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

    public String getMtId() {
        return mtId;
    }

    public void setMtId(String mtId) {
        this.mtId = mtId;
    }

    public String getMtName() {
        return mtName;
    }

    public void setMtName(String mtName) {
        this.mtName = mtName;
    }
}
