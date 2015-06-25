package com.skysport.inerfaces.dao.material;

import com.skysport.inerfaces.bean.material.DyeInfo;
import com.skysport.inerfaces.dao.CommonDao;
import org.springframework.stereotype.Component;

/**
 * 类说明:
 * Created by zhangjh on 2015/6/25.
 */
@Component("dyeDao")
public interface DyeDao extends CommonDao<DyeInfo> {

}
