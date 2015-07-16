package com.skysport.inerfaces.model.system.material.impl;

import com.skysport.inerfaces.bean.MaterialInfo;
import com.skysport.inerfaces.mapper.MaterialManageMapper;
import com.skysport.inerfaces.model.system.material.IMaterialManageService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类说明:
 * Created by zhangjh on 2015/7/13.
 */
@Component("materialManageService")
public class MaterialManageServiceImpl implements IMaterialManageService {

    @Resource(name = "materialManageMapper")
    private MaterialManageMapper materialManageMapper;

    @Override
    public MaterialInfo saveFabricFun(MaterialInfo info) {
        return materialManageMapper.saveFabricFun(info);
    }

    @Override
    public void addBatch(List<MaterialInfo> fabricItems) {
        materialManageMapper.addBatch(fabricItems);
    }

    @Override
    public List<MaterialInfo> queryFabricByBomId(String bomId) {
        return null;
    }


}
