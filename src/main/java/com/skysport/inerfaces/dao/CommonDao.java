package com.skysport.inerfaces.dao;

import com.skysport.core.bean.DataTablesInfo;

import java.util.List;

/**
 * Created by zhangjh on 2015/6/8.
 */
public interface CommonDao<T> {

    public int listInfosCounts();

    public int listFilteredInfosCounts(DataTablesInfo dataTablesInfo);

    public List<T> searchInfos(DataTablesInfo dataTablesInfo);

    public void updateInfo(T t);

    public <T> T queryInfo(String natrualKey);

    public void add(T t);

    public void del(String natrualKey);

    public String queryCurrentSeqNo();
}
