package com.skysport.inerfaces.mapper;

import com.skysport.inerfaces.bean.FabricsInfo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 类说明:
 * Created by zhangjh on 2015/6/29.
 */
@Component("fabricsManageDao")
public interface FabricsManageDao extends CommonDao<FabricsInfo> {
    List<FabricsInfo> queryFabricByBomId(String bomId);


    void delDetail(String natrualkey);


    void delSp(String natrualkey);

    void addDetailBatch(List<FabricsInfo> fabricItems);

    void addDosageBatch(List<FabricsInfo> fabricItems);

    void addSpBatch(List<FabricsInfo> fabricItems);

    void delDosage(String natrualkey);
}
