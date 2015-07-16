package com.skysport.inerfaces.mapper;

import com.skysport.inerfaces.bean.FabricsInfo;
import com.skysport.inerfaces.bean.MaterialInfo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 类说明:
 * Created by zhangjh on 2015/6/29.
 */
@Component("fabricsManageDao")
public interface FabricsManageDao extends CommonDao<FabricsInfo> {
    void addBatch(List<MaterialInfo> fabricItems);

    List<MaterialInfo> queryFabricByBomId(String bomId);

    void updateBatch(List<MaterialInfo> fabricItems);
}
