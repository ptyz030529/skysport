package com.skysport.inerfaces.model.develop.project.helper;

import com.skysport.core.bean.system.SelectItem2;
import com.skysport.core.constant.CharConstant;
import com.skysport.core.instance.SystemBaseInfo;
import com.skysport.core.model.seqno.service.IncrementNumber;
import com.skysport.core.utils.SeqCreateUtils;
import com.skysport.inerfaces.bean.ProjectBomInfo;
import com.skysport.inerfaces.bean.ProjectCategoryInfo;
import com.skysport.inerfaces.bean.ProjectInfo;
import com.skysport.inerfaces.constant.ApplicationConstant;
import com.skysport.inerfaces.helper.BuildSeqNoHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * 类说明:
 * Created by zhangjh on 2015/7/13.
 */
public class ProjectManageHelper {

    private ProjectManageHelper() {

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

    /**
     * 组装项目名称：年份+客户+系列+序列号
     *
     * @param t ProjectBomInfo
     * @return 项目名称
     */
    public static String buildProjectName(ProjectBomInfo t) {
        StringBuilder stringBuilder = new StringBuilder();

        //年份
        String name = getYearName(t);
        stringBuilder.append(name);
        stringBuilder.append(CharConstant.EMPTY);
        //客户
        name = getCustomerName(t);
        stringBuilder.append(name);
        stringBuilder.append(CharConstant.EMPTY);
        //系列
        name = getSeriesName(t);
        stringBuilder.append(name);
        stringBuilder.append(CharConstant.EMPTY);
        stringBuilder.append(t.getSeqNo());
        return stringBuilder.toString();
    }

    /**
     * 获取客户名称
     *
     * @param t
     * @return
     */
    private static String getCustomerName(ProjectBomInfo t) {
        List<SelectItem2> items;
        String id;
        String name;
        items = SystemBaseInfo.SINGLETONE.popBom("customerItems");
        id = t.getCustomerId();
        name = SystemBaseInfo.SINGLETONE.getName(items, id);
        return name;
    }

    /**
     * 获取系列名称
     *
     * @param t
     * @return
     */
    private static String getSeriesName(ProjectBomInfo t) {
        List<SelectItem2> items;
        String id;
        String name;
        items = SystemBaseInfo.SINGLETONE.popBom("seriesItems");
        id = t.getSeriesId();
        name = SystemBaseInfo.SINGLETONE.getName(items, id);
        return name;
    }

    /**
     * 获取年份名称
     *
     * @param t
     * @return
     */
    private static String getYearName(ProjectBomInfo t) {
        List<SelectItem2> items = SystemBaseInfo.SINGLETONE.popBom("yearItems");
        String id = t.getYearCode();
        return SystemBaseInfo.SINGLETONE.getName(items, id);
    }

    /**
     * 获取年份名称
     *
     * @param t ProjectBomInfo
     * @return
     */
    private static String getAreaName(ProjectBomInfo t) {
        List<SelectItem2> items = SystemBaseInfo.SINGLETONE.popBom("areaItems");
        String id = t.getAreaId();
        return SystemBaseInfo.SINGLETONE.getName(items, id);
    }


    /**
     * 将数据集合里面的id转换为Name(应该在ProjectBomInfo增加对应的name属性，但是这里采用重用id，不新增属性)
     *
     * @param infos List<ProjectBomInfo>
     */
    public static void turnIdToName(List<ProjectBomInfo> infos) {
        if (null != infos && !infos.isEmpty()) {
            for (ProjectBomInfo projectBomInfo : infos) {
                projectBomInfo.setAreaId(getAreaName(projectBomInfo));
                projectBomInfo.setSeriesId(getSeriesName(projectBomInfo));
                projectBomInfo.setCustomerId(getCustomerName(projectBomInfo));
                projectBomInfo.setYearCode(getYearName(projectBomInfo));
            }
        }


    }


    /**
     * @param incrementNumber
     * @param info
     */
    public static ProjectInfo buildProjectInfo(IncrementNumber incrementNumber, ProjectInfo info) {

        //构建项目id，名称等信息
        String kind_name = ProjectManageHelper.buildKindName(info);
        String seqNo = BuildSeqNoHelper.SINGLETONE.getFullSeqNo(kind_name, incrementNumber, ApplicationConstant.PROJECT_SEQ_NO_LENGTH);
        String projectId = SeqCreateUtils.newRrojectSeq(info.getSeriesId());
        //设置ID
        info.setNatrualkey(projectId);
        info.setSeqNo(seqNo);
//        LocalDate today = LocalDate.now();
        String name = ProjectManageHelper.buildProjectName(info);
        info.setName(name);
        info.setProjectName(name);

        List<ProjectCategoryInfo> categoryInfos = info.getCategoryInfos();
        if (null != categoryInfos && !categoryInfos.isEmpty()) {
            for (ProjectCategoryInfo categoryInfo : categoryInfos) {
                categoryInfo.setProjectId(projectId);
                categoryInfo.setProjectName(name);
            }
        }

        return info;
    }


    /**
     * 组装子项目信息
     *
     * @param info ProjectInfo
     * @return
     */
    public static List<ProjectBomInfo> buildProjectBomInfosByProjectInfo(ProjectInfo info) {
        List<ProjectBomInfo> projectBomInfos = new ArrayList<>();
        List<ProjectCategoryInfo> categoryInfos = info.getCategoryInfos();
        if (null != categoryInfos && !categoryInfos.isEmpty()) {
            for (ProjectCategoryInfo categoryInfo : categoryInfos) {
                ProjectBomInfo projectBomInfo = info;//直接将项目的大部分项目信息转存到子项目对象中
                projectBomInfo.setCategoryAid(categoryInfo.getCategoryAid());
                projectBomInfo.setCategoryBid(categoryInfo.getCategoryBid());

            }
        }

        return projectBomInfos;
    }
}
