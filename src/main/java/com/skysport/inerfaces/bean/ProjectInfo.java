package com.skysport.inerfaces.bean;

import java.util.List;

/**
 * 类说明:
 * Created by zhangjh on 2015/8/26.
 */
public class ProjectInfo extends ProjectBomInfo {

    private List<ProjectCategoryInfo> categoryInfos;

    public List<ProjectCategoryInfo> getCategoryInfos() {
        return categoryInfos;
    }

    public void setCategoryInfos(List<ProjectCategoryInfo> categoryInfos) {
        this.categoryInfos = categoryInfos;
    }
}
