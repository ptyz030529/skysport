package com.skysport.inerfaces.model.system.main_color.impl;

import com.skysport.inerfaces.mapper.MainColorManageMapper;
import com.skysport.inerfaces.model.system.main_color.IMainColorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类说明:
 * Created by zhangjh on 2015/7/15.
 */
@Service("mainColorService")
public class MainColorServiceImpl<T> implements IMainColorService<T> {
    @Resource(name = "mainColorManageMapper")
    private MainColorManageMapper mainColorManageMapper;
    /**
     * 根据项目id查询出所有主颜色
     *
     * @param projectId
     * @return
     */
    @Override
    public List<T> queryMainColorList(String projectId) {
        return mainColorManageMapper.queryMainColorList(projectId);
    }

    /**
     * 保存项目中的主颜色信息
     *
     * @param mainColorList
     */
    @Override
    public void add(List<T> mainColorList) {
        mainColorManageMapper.add(mainColorList);
    }
}
