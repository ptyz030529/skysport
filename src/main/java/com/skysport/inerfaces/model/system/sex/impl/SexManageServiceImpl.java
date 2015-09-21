package com.skysport.inerfaces.model.system.sex.impl;

import com.skysport.inerfaces.bean.basic.SexInfo;
import com.skysport.inerfaces.mapper.SexManageMapper;
import com.skysport.inerfaces.model.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
/**
 * Created by zhangjh on 2015/6/9.
 */
@Service("sexManageService")
public class SexManageServiceImpl extends CommonServiceImpl<SexInfo> implements InitializingBean {
    @Resource(name = "sexManageDao")
    private SexManageMapper sexManageMapper;

    @Override
    public void afterPropertiesSet()  {
        commonDao = sexManageMapper;
    }
}
