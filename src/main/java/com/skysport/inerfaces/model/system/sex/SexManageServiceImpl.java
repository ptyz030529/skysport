package com.skysport.inerfaces.model.system.sex;

import com.skysport.inerfaces.bean.system.SexInfo;
import com.skysport.inerfaces.mapper.SexManageDao;
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
    private SexManageDao<SexInfo> sexManageDao;

    @Override
    public void afterPropertiesSet()  {
        commonDao = sexManageDao;
    }
}
