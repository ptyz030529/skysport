package com.skysport.inerfaces.mapper;

import org.springframework.stereotype.Component;

/**
 * Created by zhangjh on 2015/6/16.
 */
@Component("seriesManageDao")
public interface SeriesManageDao<SeriesInfo> extends CommonDao<SeriesInfo> {
}
