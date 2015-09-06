package com.skysport.inerfaces.model.develop.project.service;

import com.skysport.inerfaces.bean.ProjectCategoryInfo;
import com.skysport.inerfaces.model.common.ICommonService;

import java.util.List;

/**
 * 类说明:
 * Created by zhangjh on 2015/8/26.
 */
public interface IProjectCategoryManageService extends ICommonService<ProjectCategoryInfo> {

    List<ProjectCategoryInfo> queryProjectCategoryInfo(String natrualKey);
}
