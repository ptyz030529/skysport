package com.skysport.inerfaces.bean.material;

import com.skysport.core.bean.CommonBean;

/**
 * 类说明:染色工艺（匹染、色织等）
 * Created by zhangjh on 2015/6/23.
 */
public class DyeInfo extends CommonBean {
    /**
     * id
     */
    private String id;
    /**
     * 染色方式Id
     */
    private String dyeId;
    /**
     * 染色名称
     */
    private String dyeName;
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

    public String getDyeId() {
        return dyeId;
    }

    public void setDyeId(String dyeId) {
        this.dyeId = dyeId;
    }

    public String getDyeName() {
        return dyeName;
    }

    public void setDyeName(String dyeName) {
        this.dyeName = dyeName;
    }
}
