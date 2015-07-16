package com.skysport.inerfaces.mapper;

import org.springframework.stereotype.Component;

/**
 * 类说明:
 * Created by zhangjh on 2015/7/13.
 */
@Component("projectManageMapper")
public interface ProjectManageMapper<P> extends CommonDao<P> {
    String queryCurrentSeqNo(P info);

    void addBomInfo(P info);

    void updateBomInfo(P info);
}
