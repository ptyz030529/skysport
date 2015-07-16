package com.skysport.inerfaces.model.system.series;

import com.skysport.inerfaces.bean.system.SeriesInfo;
import com.skysport.inerfaces.mapper.SeriesManageDao;
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
    private SeriesManageDao<SeriesInfo> seriesManageDao;

    @Override
    public void afterPropertiesSet() throws Exception {
        commonDao = seriesManageDao;
    }
}
