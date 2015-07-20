package com.skysport.inerfaces.model.develop.project.service;

import com.skysport.inerfaces.bean.ProjectBomInfo;
import com.skysport.inerfaces.form.develop.ProjectQueryForm;
import com.skysport.inerfaces.model.common.ICommonService;

import java.util.List;

/**
 * 类说明:
 * Created by zhangjh on 2015/7/13.
 */
public interface IProjectManageService extends ICommonService<ProjectBomInfo> {

    String queryCurrentSeqNo(ProjectBomInfo t);

    void addBomInfo(ProjectBomInfo t);

    void updateBomInfo(ProjectBomInfo t);

    int listFilteredInfosCounts(ProjectQueryForm queryForm);

    List<ProjectBomInfo> searchInfos(ProjectQueryForm queryForm);
}
