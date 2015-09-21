package com.skysport.inerfaces.model.system.series.impl;

import com.skysport.inerfaces.bean.basic.SeriesInfo;
import com.skysport.inerfaces.mapper.SeriesManageMapper;
import com.skysport.inerfaces.model.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zhangjh on 2015/6/16.
 */
@Service("seriesManageService")
public class SeriesManageServiceImpl extends CommonServiceImpl<SeriesInfo> implements InitializingBean {
    @Resource(name = "seriesManageDao")
    private SeriesManageMapper seriesManageMapper;

    @Override
    public void afterPropertiesSet() {
        commonDao = seriesManageMapper;
    }
}
