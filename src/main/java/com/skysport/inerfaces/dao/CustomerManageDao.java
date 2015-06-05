package com.skysport.inerfaces.dao;

import com.skysport.core.bean.DataTablesInfo;
import com.skysport.inerfaces.bean.CutomerInfo;

import java.util.List;

/**
 * Created by zhangjh on 2015/6/3.
 */
public interface CustomerManageDao {
    public int listCutomerInfosCounts();

    public int listFilteredCutomerInfosCounts(DataTablesInfo dataTablesInfo);

    public List<CutomerInfo> searchCutomer(DataTablesInfo dataTablesInfo);

    public void edit(CutomerInfo cutomerInfo);

    public void add(CutomerInfo cutomerInfo);

    public CutomerInfo queryCutomerByCutomerId(String cutomerId);

    public void del(String cutomerId);
}
