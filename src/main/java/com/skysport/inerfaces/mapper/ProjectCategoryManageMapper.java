package com.skysport.inerfaces.mapper;

import com.skysport.inerfaces.bean.develop.ProjectCategoryInfo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 类说明:
 * Created by zhangjh on 2015/8/26.
 */
@Component("projectCategoryManageMapper")
public interface ProjectCategoryManageMapper  extends CommonDao<ProjectCategoryInfo> {


    List<ProjectCategoryInfo> queryProjectCategoryInfo(String natrualKey);
}
