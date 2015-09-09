package com.skysport.inerfaces.model.develop.bom.impl;

import com.skysport.inerfaces.bean.develop.BomInfo;
import com.skysport.inerfaces.bean.develop.FabricsInfo;
import com.skysport.inerfaces.form.develop.BomQueryForm;
import com.skysport.inerfaces.mapper.BomManageMapper;
import com.skysport.inerfaces.model.common.impl.CommonServiceImpl;
import com.skysport.inerfaces.model.develop.bom.IBomManageService;
import com.skysport.inerfaces.model.develop.fabric.IFabricsService;
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
    public void afterPropertiesSet()  {
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
    public BomInfo queryInfoByNatrualKey(String natrualKey) {
        BomInfo bomInfo = super.queryInfoByNatrualKey(natrualKey);
        if (null != bomInfo) {
            //面料集合
            List<FabricsInfo> fabricItems = fabricsManageService.queryFabricList(natrualKey);

            //辅料集合


            //包材


            //成衣厂

            bomInfo.setFabrics(fabricItems);
        }
        return bomInfo;
    }

    @Override
    public void edit(BomInfo bomInfo) {

        super.edit(bomInfo);

        //保存面料信息
        fabricsManageService.updateBatch(bomInfo.getFabricItems(),bomInfo);

        //保存辅料信息


        //保存包装材料信息


        //保存成衣厂信息

    }

    @Override
    public void delByProjectId(String projectId) {
        bomManageMapper.delByProjectId(projectId);
    }

}
