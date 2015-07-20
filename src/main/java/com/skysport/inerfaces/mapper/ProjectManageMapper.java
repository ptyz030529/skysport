package com.skysport.inerfaces.mapper;

import com.skysport.inerfaces.bean.ProjectBomInfo;
import com.skysport.inerfaces.form.develop.ProjectQueryForm;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 类说明:
 * Created by zhangjh on 2015/7/13.
 */
@Component("projectManageMapper")
public interface ProjectManageMapper extends CommonDao<ProjectBomInfo> {
    String queryCurrentSeqNo(ProjectBomInfo info);

    void addBomInfo(ProjectBomInfo info);

    void updateBomInfo(ProjectBomInfo info);

    int listFilteredInfosCounts(ProjectQueryForm queryForm);

    List<ProjectBomInfo> searchInfos(ProjectQueryForm queryForm);
}
