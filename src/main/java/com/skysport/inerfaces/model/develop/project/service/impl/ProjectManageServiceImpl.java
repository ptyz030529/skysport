package com.skysport.inerfaces.model.develop.project.service.impl;

import com.skysport.core.exception.CnfwsyException;
import com.skysport.core.model.seqno.service.IncrementNumber;
import com.skysport.inerfaces.bean.develop.ProjectBomInfo;
import com.skysport.inerfaces.bean.develop.ProjectInfo;
import com.skysport.inerfaces.constant.ApplicationConstant;
import com.skysport.inerfaces.constant.develop.DevelopmentReturnConstant;
import com.skysport.inerfaces.form.develop.ProjectQueryForm;
import com.skysport.inerfaces.mapper.ProjectManageMapper;
import com.skysport.inerfaces.model.common.impl.CommonServiceImpl;
import com.skysport.inerfaces.model.develop.project.helper.ProjectManageHelper;
import com.skysport.inerfaces.model.develop.project.service.IProjectCategoryManageService;
import com.skysport.inerfaces.model.develop.project.service.IProjectItemManageService;
import com.skysport.inerfaces.model.develop.project.service.IProjectManageService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类说明:
 * Created by zhangjh on 2015/7/13.
 */
@Service("projectManageService")
public class ProjectManageServiceImpl extends CommonServiceImpl<ProjectInfo> implements IProjectManageService, InitializingBean {


    @Resource(name = "projectManageMapper")
    private ProjectManageMapper projectManageMapper;
    @Resource(name = "projectCategoryManageService")
    private IProjectCategoryManageService projectCategoryManageService;
    @Resource(name = "projectItemManageService")
    private IProjectItemManageService projectItemManageService;

    @Resource(name = "incrementNumber")
    private IncrementNumber incrementNumber;


    @Override
    public void afterPropertiesSet() {
        commonDao = projectManageMapper;
    }


    @Override
    public String queryCurrentSeqNo(ProjectInfo info) {

        return projectManageMapper.queryCurrentSeqNo(info);

    }

    @Override
    public void add(ProjectInfo info) {

        //新增项目时组装项目名等信息
        info = ProjectManageHelper.buildProjectInfo(incrementNumber, info);
        //组装项目品类信息
        info = ProjectManageHelper.buildProjectCategoryInfo(info);

        //大项目新增
        //增加主项目信息
        super.add(info);

        //增加项目的品类信息
        projectCategoryManageService.addBatch(info.getCategoryInfos());

        List<ProjectBomInfo> projectBomInfos = ProjectManageHelper.buildProjectBomInfosByProjectInfo(info);

        //增加子项目
        projectItemManageService.addBatch(projectBomInfos);


        projectItemManageService.addBatchBomInfo(projectBomInfos);


    }

    /**
     * 项目编号是由年份+客户+地域+系列+NNN构成，但是上面的信息可能会更改，如果按照这个这个规则，项目编号应该要更改才对，但目前的处理方式是，项目编号和序号都不改变
     *
     * @param info
     */
    @Override
    public void edit(ProjectInfo info) {
        ProjectInfo infoInDb = super.queryInfoByNatrualKey(info.getNatrualkey());

        if (infoInDb.getStatus() == ApplicationConstant.PROJECT_CANOT_EDIT) {
            throw new CnfwsyException(DevelopmentReturnConstant.PROJECT_CANNOT_EDIT.getCode(), DevelopmentReturnConstant.PROJECT_CANNOT_EDIT.getMsg());
        }

        //判断bom有没有生成，如果bom已生成，不能修改项目信息
//        if(){
//            throw new CnfwsyException("100001","bom已生成，不能修改项目信息");
//        }

        info = ProjectManageHelper.buildProjectInfo(incrementNumber, info);

        //更新t_project表
        super.edit(info);

        //删除项目相关的所有信息
        projectManageMapper.delInfoAboutProject(info.getNatrualkey());

        info = ProjectManageHelper.buildProjectCategoryInfo(info);
        //增加项目的品类信息
        projectCategoryManageService.addBatch(info.getCategoryInfos());

        List<ProjectBomInfo> projectBomInfos = ProjectManageHelper.buildProjectBomInfosByProjectInfo(info);

        //增加子项目
        projectItemManageService.addBatch(projectBomInfos);


        projectItemManageService.addBatchBomInfo(projectBomInfos);


    }

    @Override
    public void addBomInfo(ProjectInfo info) {
        projectManageMapper.addBomInfo(info);
    }

    @Override
    public void updateBomInfo(ProjectInfo info) {
        projectManageMapper.updateBomInfo(info);
    }

    @Override
    public int listFilteredInfosCounts(ProjectQueryForm queryForm) {
        return projectManageMapper.listFilteredInfosCounts(queryForm);
    }

    @Override
    public List<ProjectInfo> searchInfos(ProjectQueryForm queryForm) {
        return projectManageMapper.searchInfos(queryForm);
    }

    @Override
    public void updateProjectStatus(String projectId, int status) {
        projectManageMapper.updateProjectStatus(projectId, status);
    }
}
