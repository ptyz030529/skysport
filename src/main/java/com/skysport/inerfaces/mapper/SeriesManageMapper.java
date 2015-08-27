package com.skysport.inerfaces.mapper;

import com.skysport.inerfaces.bean.system.SeriesInfo;
import org.springframework.stereotype.Component;

/**
 * Created by zhangjh on 2015/6/16.
 */
@Component("seriesManageDao")
public interface SeriesManageMapper extends CommonDao<SeriesInfo> {
}
