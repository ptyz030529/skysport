package com.skysport.inerfaces.model.system.material;

import com.skysport.inerfaces.bean.MaterialInfo;

import java.util.List;

/**
 * 类说明:
 * Created by zhangjh on 2015/7/13.
 */
public interface IMaterialManageService {

    public MaterialInfo saveFabricFun(MaterialInfo info);

    void addBatch(List<MaterialInfo> fabricItems);

    public List<MaterialInfo> queryFabricByBomId(String bomId);

}
