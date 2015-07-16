package com.skysport.inerfaces.model.develop.project.helper;

import com.skysport.inerfaces.bean.ProjectBomInfo;
import com.skysport.inerfaces.form.develop.ProjectQueryForm;

import javax.servlet.http.HttpServletRequest;

/**
 * 类说明:
 * Created by zhangjh on 2015/7/13.
 */
public class ProjectManageHelper {
    public static void buildBomQueryForm(ProjectQueryForm queryForm, HttpServletRequest request) {


    }


    /**
     * 构建项目序列号对应的主键：年份+客户+地域+系列
     *
     * @param info
     * @return
     */
    public static String buildKindName(ProjectBomInfo info) {
        StringBuilder stringBuilder = new StringBuilder(16);
        stringBuilder.append(info.getYearCode());
        stringBuilder.append(info.getCustomerId());
        stringBuilder.append(info.getAreaId());
        stringBuilder.append(info.getSeriesId());
        return stringBuilder.toString();

    }
}
