package com.skysport.inerfaces.model.develop.project.service.impl;

import com.skysport.inerfaces.bean.ProjectBomInfo;
import com.skysport.inerfaces.bean.system.MainColor;
import com.skysport.inerfaces.mapper.ProjectManageMapper;
import com.skysport.inerfaces.model.common.impl.CommonServiceImpl;
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
public class ProjectManageServiceImpl<T> extends CommonServiceImpl<T> implements IProjectManageService<T>, InitializingBean {
    @Resource(name = "projectManageMapper")
    private ProjectManageMapper<T> projectManageMapper;


    @Resource(name = "mainColorService")
    private IMainColorService<MainColor> mainColorService;


    @Override
    public void afterPropertiesSet() throws Exception {
        commonDao = projectManageMapper;
    }


    @Override
    public String queryCurrentSeqNo(T info) {
        return projectManageMapper.queryCurrentSeqNo(info);
    }

    @Override
    public void add(T info) {
        //增加主项目信息
        super.add(info);
        //增加项目BOM信息
        addBomInfo(info);

        List<MainColor> mainColorList = MainColorHelper.SINGLETONE.turnMainColorStrToList((ProjectBomInfo) info);

        //
        mainColorService.add(mainColorList);


    }

    @Override
    public void edit(T info) {
        super.edit(info);
        updateBomInfo(info);
    }

    @Override
    public void addBomInfo(T info) {
        projectManageMapper.addBomInfo(info);
    }

    @Override
    public void updateBomInfo(T info) {
        projectManageMapper.updateBomInfo(info);
    }
}
