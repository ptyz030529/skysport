package com.skysport.inerfaces.model.system.year_conf;

import com.skysport.inerfaces.bean.YearConfInfo;
import com.skysport.inerfaces.dao.YearConfManageDao;
import com.skysport.inerfaces.model.system.common.service.impl.CommonServiceImpl;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zhangjh on 2015/6/9.
 */
@Service("yearConfManageService")
public class YearConfManageServiceImpl extends CommonServiceImpl<YearConfInfo> implements InitializingBean {
    @Resource(name = "yearConfManageDao")
    private YearConfManageDao<YearConfInfo> yearConfManageDao;

    @Override
    public void afterPropertiesSet() throws Exception {
        commonDao = yearConfManageDao;
    }
}