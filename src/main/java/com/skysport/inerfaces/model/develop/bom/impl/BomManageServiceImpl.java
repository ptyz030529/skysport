package com.skysport.inerfaces.model.develop.bom.impl;

import com.skysport.inerfaces.bean.BomInfo;
import com.skysport.inerfaces.form.develop.BomQueryForm;
import com.skysport.inerfaces.mapper.BomManageMapper;
import com.skysport.inerfaces.model.common.impl.CommonServiceImpl;
import com.skysport.inerfaces.model.develop.bom.IBomManageService;
import com.skysport.inerfaces.model.system.fabrics.IFabricsService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类说明:
 * Created by zhangjh on 2015/7/13.
 */
@Service("bomManageService")
public class BomManageServiceImpl extends CommonServiceImpl<BomInfo> implements IBomManageService, InitializingBean {

    @Resource(name = "bomManageMapper")
    private BomManageMapper bomManageMapper;

    @Resource(name = "fabricsManageService")
    private IFabricsService fabricsManageService;

    @Override
    public void afterPropertiesSet() throws Exception {
        commonDao = bomManageMapper;
    }

    @Override
    public int listFilteredInfosCounts(BomQueryForm bomQueryForm) {
        return bomManageMapper.listFilteredInfosCounts(bomQueryForm);
    }

    @Override
    public List<BomInfo> searchInfos(BomQueryForm bomQueryForm) {
        return bomManageMapper.searchInfos(bomQueryForm);
    }

    @Override
    public void edit(BomInfo bomInfo) {

        super.edit(bomInfo);

        //保存面料信息
//        fabricsManageService.updateBatch(bomInfo.getFabricItems());

        //保存辅料信息


        //保存包装材料信息


        //保存成衣厂信息

    }

}
