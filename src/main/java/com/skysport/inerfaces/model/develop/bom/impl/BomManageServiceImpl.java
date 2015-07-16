package com.skysport.inerfaces.model.develop.bom.impl;

import com.skysport.inerfaces.mapper.BomManageMapper;
import com.skysport.inerfaces.form.develop.BomQueryForm;
import com.skysport.inerfaces.model.common.impl.CommonServiceImpl;
import com.skysport.inerfaces.model.develop.bom.IBomManageService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类说明:
 * Created by zhangjh on 2015/7/13.
 */
@Service("bomManageService")
public class BomManageServiceImpl<T> extends CommonServiceImpl<T> implements IBomManageService<T>, InitializingBean {

    @Resource(name = "bomManageMapper")
    private BomManageMapper<T> bomManageMapper;

    @Override
    public void afterPropertiesSet() throws Exception {
        commonDao = bomManageMapper;
    }

    @Override
    public int listFilteredInfosCounts(BomQueryForm bomQueryForm) {
        return commonDao.listFilteredInfosCounts(bomQueryForm);
    }

    @Override
    public List<T> searchInfos(BomQueryForm bomQueryForm) {
        return commonDao.searchInfos(bomQueryForm);
    }

}
