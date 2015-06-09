package com.skysport.inerfaces.model.system.common.service.impl;

import com.skysport.core.bean.CommonBean;
import com.skysport.core.bean.DataTablesInfo;
import com.skysport.inerfaces.dao.CommonDao;
import com.skysport.inerfaces.model.system.common.service.ICommonService;

import java.util.List;

/**
 * Created by zhangjh on 2015/6/8.
 */
public class CommonServiceImpl<T> implements ICommonService<T> {
    public CommonDao<T> commonDao;

    @Override
    public int listInfosCounts() {
        return commonDao.listInfosCounts();
    }

    @Override
    public int listFilteredInfosCounts(DataTablesInfo dataTablesInfo) {
        return commonDao.listFilteredInfosCounts(dataTablesInfo);
    }

    @Override
    public List<T> searchInfos(DataTablesInfo dataTablesInfo) {
        return commonDao.searchInfos(dataTablesInfo);
    }

    @Override
    public void edit(T t) {
        commonDao.updateInfo(t);
    }

    @Override
    public T queryInfoByNatrualKey(String natrualKey) {
        return commonDao.queryInfo(natrualKey);
    }

    @Override
    public void add(T t) {
        commonDao.add(t);
    }

    @Override
    public void del(String natrualKey) {
        commonDao.del(natrualKey);
    }

    @Override
    public String queryCurrentSeqNo() {
        return commonDao.queryCurrentSeqNo();
    }

    @Override
    public List<CommonBean> querySelectList() {
        return commonDao.querySelectList();
    }
}
