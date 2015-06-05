package com.skysport.inerfaces.model.system.customer.service;

import com.skysport.core.bean.DataTablesInfo;
import com.skysport.inerfaces.bean.CutomerInfo;

import java.util.List;

/**
 * Created by zhangjh on 2015/6/3.
 */
public interface ICustomerManageService {

    int listCutomerInfosCounts();

    int listFilteredCutomerInfosCounts(DataTablesInfo dataTablesInfo);

    List<CutomerInfo> searchCutomer(DataTablesInfo dataTablesInfo);

    void edit(CutomerInfo cutomerInfo);

    void add(CutomerInfo cutomerInfo);

    CutomerInfo queryCutomerByCutomerId(String cutomerId);

    void del(String cutomerId);
}
