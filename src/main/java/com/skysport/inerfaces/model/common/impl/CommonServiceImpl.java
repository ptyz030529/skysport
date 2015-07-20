package com.skysport.inerfaces.model.common.impl;

import com.skysport.core.bean.system.SelectItem2;
import com.skysport.core.bean.query.DataTablesInfo;
import com.skysport.inerfaces.mapper.CommonDao;
import com.skysport.inerfaces.model.common.ICommonService;
import org.apache.ibatis.annotations.Param;

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
    public List<SelectItem2> querySelectList(@Param(value = "name") String name) {
        return commonDao.querySelectList(name);
    }
}
