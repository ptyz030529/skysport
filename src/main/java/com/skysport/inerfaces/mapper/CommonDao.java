package com.skysport.inerfaces.mapper;

import com.skysport.core.bean.system.SelectItem;
import com.skysport.core.bean.query.DataTablesInfo;

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

    List<SelectItem> querySelectList(String name);
}
