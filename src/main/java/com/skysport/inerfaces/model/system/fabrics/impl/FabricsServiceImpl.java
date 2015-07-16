package com.skysport.inerfaces.model.system.fabrics.impl;

import com.skysport.inerfaces.bean.FabricsInfo;
import com.skysport.inerfaces.bean.MaterialInfo;
import com.skysport.inerfaces.mapper.FabricsManageDao;
import com.skysport.inerfaces.model.common.impl.CommonServiceImpl;
import com.skysport.inerfaces.model.system.fabrics.IFabricsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类说明:面料相关的业务处理
 * Created by zhangjh on 2015/6/29.
 */
@Service("fabricsManageService")
public class FabricsServiceImpl extends CommonServiceImpl<FabricsInfo> implements IFabricsService<FabricsInfo> {
    @Resource(name = "fabricsManageDao")
    private FabricsManageDao fabricsManageDao;


    @Override
    public void addBatch(List<MaterialInfo> fabricItems) {
        fabricsManageDao.addBatch(fabricItems);
    }

    @Override
    public List<MaterialInfo> queryFabricByBomId(String bomId) {
        return fabricsManageDao.queryFabricByBomId(bomId);
    }

    @Override
    public void updateBatch(List<MaterialInfo> fabricItems) {
        fabricsManageDao.updateBatch(fabricItems);
    }


}