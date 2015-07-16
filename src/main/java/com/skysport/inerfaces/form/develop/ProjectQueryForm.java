package com.skysport.inerfaces.form.develop;

import com.skysport.core.bean.query.DataTablesInfo;
import com.skysport.inerfaces.bean.ProjectBomInfo;

/**
 * 类说明:项目查询表单
 * Created by zhangjh on 2015/7/13.
 */
public class ProjectQueryForm extends DataTablesInfo{

    private ProjectBomInfo projectBomInfo;
    private String startDate;
    private String endDate;

    public ProjectBomInfo getProjectBomInfo() {
        return projectBomInfo;
    }

    public void setProjectBomInfo(ProjectBomInfo projectBomInfo) {
        this.projectBomInfo = projectBomInfo;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
