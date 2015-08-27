package com.skysport.inerfaces.model.system.material_classic.impl;

import com.skysport.inerfaces.bean.system.MaterialClassicInfo;
import com.skysport.inerfaces.mapper.MaterialClassicManageMapper;
import com.skysport.inerfaces.model.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zhangjh on 2015/6/9.
 */
@Service("materialClassicManageService")
public class MaterialClassicManageServiceImpl extends CommonServiceImpl<MaterialClassicInfo> implements InitializingBean {
    @Resource(name = "materialClassicManageDao")
    private MaterialClassicManageMapper materialClassicManageDao;

    @Override
    public void afterPropertiesSet()  {
        commonDao = materialClassicManageDao;
    }
}
