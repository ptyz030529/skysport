package com.skysport.inerfaces.model.system.fabrics.impl;

import com.skysport.inerfaces.bean.FabricsInfo;
import com.skysport.inerfaces.mapper.FabricsManageDao;
import com.skysport.inerfaces.model.common.impl.CommonServiceImpl;
import com.skysport.inerfaces.model.system.fabrics.IFabricsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类说明:面料相关的业务处理
 * Created by zhangjh on 2015/6/29.
 */
@Service("fabricsManageService")
public class FabricsServiceImpl extends CommonServiceImpl<FabricsInfo> implements IFabricsService, InitializingBean {
    @Resource(name = "fabricsManageDao")
    private FabricsManageDao fabricsManageDao;

    @Override
    public void afterPropertiesSet() throws Exception {
        commonDao = fabricsManageDao;
    }

    @Override
    public List<FabricsInfo> queryFabricByBomId(String bomId) {
        return fabricsManageDao.queryFabricByBomId(bomId);
    }

    @Override
    public void updateBatch(List<FabricsInfo> fabricItems) {
        if (null == fabricItems || fabricItems.isEmpty()) {
            return;
        }
        //先删除所有面料，再新增
        for (FabricsInfo fabricsInfo : fabricItems) {
            if (StringUtils.isNotBlank(fabricsInfo.getNatrualkey())) {
                fabricsManageDao.del(fabricsInfo.getNatrualkey());
                fabricsManageDao.delDetail(fabricsInfo.getNatrualkey());
                fabricsManageDao.delDosage(fabricsInfo.getNatrualkey());
                fabricsManageDao.delSp(fabricsInfo.getNatrualkey());
            }
        }
        fabricsManageDao.addBatch(fabricItems);
        //新增面料详细
        fabricsManageDao.addDetailBatch(fabricItems);
        //新增面料用量
        fabricsManageDao.addDosageBatch(fabricItems);
        //新增面料供应商信息
        fabricsManageDao.addSpBatch(fabricItems);

    }


}