package com.skysport.inerfaces.model.system.material_classic;

import com.skysport.inerfaces.bean.system.MaterialClassicInfo;
import com.skysport.inerfaces.dao.MaterialClassicManageDao;
import com.skysport.inerfaces.model.system.common.service.impl.CommonServiceImpl;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zhangjh on 2015/6/9.
 */
@Service("materialClassicManageService")
public class MaterialClassicManageServiceImpl extends CommonServiceImpl<MaterialClassicInfo> implements InitializingBean {
    @Resource(name = "materialClassicManageDao")
    private MaterialClassicManageDao<MaterialClassicInfo> materialClassicManageDao;

    @Override
    public void afterPropertiesSet() throws Exception {
        commonDao = materialClassicManageDao;
    }
}
