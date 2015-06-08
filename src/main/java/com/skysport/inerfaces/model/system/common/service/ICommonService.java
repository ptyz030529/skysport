package com.skysport.inerfaces.model.system.common.service;

import com.skysport.core.bean.DataTablesInfo;

import java.util.List;

/**
 * Created by zhangjh on 2015/6/8.
 */
public interface ICommonService<T> {

    /**
     * @return
     */
    public int listInfosCounts();

    /**
     * 过滤条件的记录数
     *
     * @param dataTablesInfo
     * @return 符合查询条件的pantone记录数
     */
    public int listFilteredInfosCounts(DataTablesInfo dataTablesInfo);

    /**
     * @param dataTablesInfo
     * @return
     */
    public List<T> searchInfos(DataTablesInfo dataTablesInfo);

    /**
     * @param t
     */
    public void edit(T t);

    /**
     * @param natrualkey
     * @return 根据natrualkey找出供应商信息
     */
    public <T> T queryInfoByNatrualKey(String natrualkey);

    public void add(T t);

    public void del(String natrualkey);

    String queryCurrentSeqNo();
}
