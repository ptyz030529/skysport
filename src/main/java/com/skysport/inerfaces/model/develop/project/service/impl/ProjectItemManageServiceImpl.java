package com.skysport.inerfaces.model.develop.project.service.impl;

import com.skysport.core.model.seqno.service.IncrementNumber;
import com.skysport.inerfaces.bean.develop.ProjectBomInfo;
import com.skysport.inerfaces.bean.system.MainColor;
import com.skysport.inerfaces.form.develop.ProjectQueryForm;
import com.skysport.inerfaces.mapper.ProjectItemManageMapper;
import com.skysport.inerfaces.model.common.impl.CommonServiceImpl;
import com.skysport.inerfaces.model.develop.bom.IBomManageService;
import com.skysport.inerfaces.model.develop.bom.helper.BomManageHelper;
import com.skysport.inerfaces.model.develop.project.helper.ProjectManageHelper;
import com.skysport.inerfaces.model.develop.project.service.IProjectItemManageService;
import com.skysport.inerfaces.model.system.main_color.IMainColorService;
import com.skysport.inerfaces.model.system.main_color.helper.MainColorHelper;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类说明:
 * Created by zhangjh on 2015/7/13.
 */
@Service("projectItemManageService")
public class ProjectItemManageServiceImpl extends CommonServiceImpl<ProjectBomInfo> implements IProjectItemManageService, InitializingBean {
    @Resource(name = "projectItemManageMapper")
    private ProjectItemManageMapper projectItemManageMapper;
    @Resource(name = "bomManageService")
    private IBomManageService bomManageService;

    @Resource(name = "mainColorService")
    private IMainColorService mainColorService;
    @Resource(name = "incrementNumber")
    private IncrementNumber incrementNumber;


    @Override
    public void afterPropertiesSet() {
        commonDao = projectItemManageMapper;
    }


    @Override
    public String queryCurrentSeqNo(ProjectBomInfo info) {
        return projectItemManageMapper.queryCurrentSeqNo(info);
    }

    @Override
    public void add(ProjectBomInfo info) {
//        LocalDate today = LocalDate.now();
        String name = ProjectManageHelper.buildProjectName(info);
        info.setName(name);
        info.setProjectName(name);

        //增加主项目信息
        super.add(info);

        //增加项目BOM信息
        addBomInfo(info);

        List<MainColor> mainColorList = MainColorHelper.SINGLETONE.turnMainColorStrToList(info);

        //增加项目主颜色信息
        mainColorService.add(mainColorList);


        //生成BOM信息并保存
        BomManageHelper.autoCreateBomInfoAndSave(bomManageService, incrementNumber, info);



    }

    /**
     * 项目编号是由年份+客户+地域+系列+NNN构成，但是上面的信息可能会更改，如果按照这个这个规则，项目编号应该要更改才对，但目前的处理方式是，项目编号和序号都不改变
     *
     * @param info
     */
    @Override
    public void edit(ProjectBomInfo info) {

        String seqNo = queryInfoByNatrualKey(info.getNatrualkey()).getSeqNo();
        info.setSeqNo(seqNo);

//        String name = ProjectManageHelper.buildProjectName(info);
//        info.setName(name);
//        info.setProjectName(name);

        //更新t_project表
        super.edit(info);
        //更新t_project_bominfo表
        updateBomInfo(info);

        //增加项目主颜色信息
        mainColorService.delete(info.getNatrualkey());

        List<MainColor> mainColorList = MainColorHelper.SINGLETONE.turnMainColorStrToList(info);

        //增加项目主颜色信息

        mainColorService.add(mainColorList);


        info =  super.queryInfoByNatrualKey(info.getNatrualkey());
        bomManageService.delByProjectId(info.getNatrualkey());
        //生成BOM信息并保存
        BomManageHelper.autoCreateBomInfoAndSave(bomManageService, incrementNumber, info);



    }

    @Override
    public void addBomInfo(ProjectBomInfo info) {
        projectItemManageMapper.addBomInfo(info);
    }

    @Override
    public void updateBomInfo(ProjectBomInfo info) {
        projectItemManageMapper.updateBomInfo(info);
    }

    @Override
    public int listFilteredInfosCounts(ProjectQueryForm queryForm) {
        return projectItemManageMapper.listFilteredInfosCounts(queryForm);
    }

    @Override
    public List<ProjectBomInfo> searchInfos(ProjectQueryForm queryForm) {
        return projectItemManageMapper.searchInfos(queryForm);
    }

    @Override
    public void addBatchBomInfo(List<ProjectBomInfo> info) {
        projectItemManageMapper.addBatchBomInfo(info);
    }
}
