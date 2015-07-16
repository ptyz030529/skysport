package com.skysport.inerfaces.model.develop.project.service;

import com.skysport.inerfaces.model.common.ICommonService;

/**
 * 类说明:
 * Created by zhangjh on 2015/7/13.
 */
public interface IProjectManageService<T> extends ICommonService<T> {

    String queryCurrentSeqNo(T t);

    void addBomInfo(T t);

    void updateBomInfo(T t);
}
