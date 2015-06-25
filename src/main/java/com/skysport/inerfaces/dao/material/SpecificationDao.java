package com.skysport.inerfaces.dao.material;

import com.skysport.inerfaces.bean.material.SpecificationInfo;
import com.skysport.inerfaces.dao.CommonDao;
import org.springframework.stereotype.Component;

/**
 * 类说明:
 * Created by zhangjh on 2015/6/25.
 */
@Component("specificationDao")
public interface SpecificationDao extends CommonDao<SpecificationInfo> {
}
