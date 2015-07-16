package com.skysport.inerfaces.model.system.fabrics;

import com.skysport.inerfaces.bean.MaterialInfo;
import com.skysport.inerfaces.model.common.ICommonService;

import java.util.List;

/**
 * 类说明:
 * Created by zhangjh on 2015/7/13.
 */
public interface IFabricsService<T> extends ICommonService<T> {
    /**
     * 批量新增
     *
     * @param fabricItems
     */
    void addBatch(List<MaterialInfo> fabricItems);

    /**
     * 根据BOMid 查询所有的面料信息
     *
     * @param bomId bomId
     * @return 查询
     */
    public List<MaterialInfo> queryFabricByBomId(String bomId);

    /**
     * 批量修改
     *
     * @param fabricItems
     */
    public void updateBatch(List<MaterialInfo> fabricItems);
}
