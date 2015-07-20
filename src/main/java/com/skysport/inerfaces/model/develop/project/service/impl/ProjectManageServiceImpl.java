package com.skysport.inerfaces.model.develop.project.service.impl;

import com.skysport.inerfaces.bean.ProjectBomInfo;
import com.skysport.inerfaces.bean.system.MainColor;
import com.skysport.inerfaces.form.develop.ProjectQueryForm;
import com.skysport.inerfaces.mapper.ProjectManageMapper;
import com.skysport.inerfaces.model.common.impl.CommonServiceImpl;
import com.skysport.inerfaces.model.develop.project.helper.ProjectManageHelper;
import com.skysport.inerfaces.model.develop.project.service.IProjectManageService;
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
@Service("projectManageService")
public class ProjectManageServiceImpl extends CommonServiceImpl<ProjectBomInfo> implements IProjectManageService, InitializingBean {
    @Resource(name = "projectManageMapper")
    private ProjectManageMapper projectManageMapper;


    @Resource(name = "mainColorService")
    private IMainColorService mainColorService;


    @Override
    public void afterPropertiesSet() throws Exception {
        commonDao = projectManageMapper;
    }


    @Override
    public String queryCurrentSeqNo(ProjectBomInfo info) {
        return projectManageMapper.queryCurrentSeqNo(info);
    }

    @Override
    public void add(ProjectBomInfo t) {
//        LocalDate today = LocalDate.now();
        String name = ProjectManageHelper.buildProjectName(t);
        t.setName(name);
        t.setProjectName(name);
        //增加主项目信息
        super.add(t);
        //增加项目BOM信息
        addBomInfo(t);
        List<MainColor> mainColorList = MainColorHelper.SINGLETONE.turnMainColorStrToList(t);
        //增加项目主颜色信息
        mainColorService.add(mainColorList);
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

        String name = ProjectManageHelper.buildProjectName(info);
        info.setName(name);
        info.setProjectName(name);

        //更新t_project表
        super.edit(info);
        //更新t_project_bominfo表
        updateBomInfo(info);

        //增加项目主颜色信息
        mainColorService.delete(info.getNatrualkey());
        List<MainColor> mainColorList = MainColorHelper.SINGLETONE.turnMainColorStrToList(info);
        //增加项目主颜色信息

        mainColorService.add(mainColorList);

    }

    @Override
    public void addBomInfo(ProjectBomInfo info) {
        projectManageMapper.addBomInfo(info);
    }

    @Override
    public void updateBomInfo(ProjectBomInfo info) {
        projectManageMapper.updateBomInfo(info);
    }

    @Override
    public int listFilteredInfosCounts(ProjectQueryForm queryForm) {
        return projectManageMapper.listFilteredInfosCounts(queryForm);
    }

    @Override
    public List<ProjectBomInfo> searchInfos(ProjectQueryForm queryForm) {
        return projectManageMapper.searchInfos(queryForm);
    }
}
