package com.skysport.inerfaces.model.develop.fabric.impl;

import com.skysport.core.model.seqno.service.IncrementNumber;
import com.skysport.inerfaces.bean.develop.BomInfo;
import com.skysport.inerfaces.bean.develop.FabricsInfo;
import com.skysport.inerfaces.bean.join.FabricsJoinInfo;
import com.skysport.inerfaces.constant.ApplicationConstant;
import com.skysport.inerfaces.mapper.FabricsManageMapper;
import com.skysport.inerfaces.model.common.impl.CommonServiceImpl;
import com.skysport.inerfaces.model.develop.fabric.IFabricsService;
import com.skysport.inerfaces.utils.BuildSeqNoHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 类说明:面料相关的业务处理
 * Created by zhangjh on 2015/6/29.
 */
@Service("fabricsManageService")
public class FabricsServiceImpl extends CommonServiceImpl<FabricsInfo> implements IFabricsService, InitializingBean {
    @Resource(name = "fabricsManageDao")
    private FabricsManageMapper fabricsManageDao;

    @Resource(name = "incrementNumber")
    private IncrementNumber incrementNumber;

    @Override
    public void afterPropertiesSet() {
        commonDao = fabricsManageDao;
    }

    @Override
    public List<FabricsInfo> queryFabricByBomId(String bomId) {
        return fabricsManageDao.queryFabricByBomId(bomId);
    }

    @Override
    public List<FabricsInfo> queryFabricList(String natrualKey) {
        return fabricsManageDao.queryFabricList(natrualKey);
    }

    @Override
    public void updateBatch(List<FabricsJoinInfo> fabricItems, BomInfo bomInfo) {

//        if (null == fabricItems || fabricItems.isEmpty()) {
//            return;
//        }

        //找出被删除的面料id，并删除
        String bomId = StringUtils.isBlank(bomInfo.getNatrualkey()) ? bomInfo.getBomId() : bomInfo.getNatrualkey();

        deleteFabircsByIds(fabricItems, bomId);

        if (null != fabricItems) {
            //面料id存在，修改；面料id不存在则新增
            for (FabricsJoinInfo fabricsJoinInfo : fabricItems) {

                String fabricId = fabricsJoinInfo.getFabricsInfo().getFabricId();

                //有id，更新
                if (StringUtils.isNotBlank(fabricId)) {
                    setFabricId(fabricsJoinInfo, fabricId, bomId);
                    fabricsManageDao.updateInfo(fabricsJoinInfo.getFabricsInfo());
                    fabricsManageDao.updateDetail(fabricsJoinInfo.getFabricsDetailInfo());
                    fabricsManageDao.updateDosage(fabricsJoinInfo.getMaterialUnitDosage());
                    fabricsManageDao.updateSp(fabricsJoinInfo.getMaterialSpInfo());
                }
                //无id，新增
                else {
                    String kind_name = buildKindName(bomInfo, fabricsJoinInfo);
                    String seqNo = BuildSeqNoHelper.SINGLETONE.getFullSeqNo(kind_name, incrementNumber, ApplicationConstant.MATERIAL_SEQ_NO_LENGTH);
                    //年份+客户+地域+系列+NNN
                    fabricId = kind_name + seqNo;
                    setFabricId(fabricsJoinInfo, fabricId, bomId);
                    fabricsManageDao.add(fabricsJoinInfo.getFabricsInfo());
                    //新增面料详细
                    fabricsManageDao.addDetail(fabricsJoinInfo.getFabricsDetailInfo());
                    //新增面料用量
                    fabricsManageDao.addDosage(fabricsJoinInfo.getMaterialUnitDosage());
                    //新增面料供应商信息
                    fabricsManageDao.addSp(fabricsJoinInfo.getMaterialSpInfo());
                }
            }
        }

    }


    private void setFabricId(FabricsJoinInfo fabricsJoinInfo, String fabricId, String bomId) {

        fabricsJoinInfo.getFabricsInfo().setFabricId(fabricId);
        fabricsJoinInfo.getFabricsInfo().setNatrualkey(fabricId);
        fabricsJoinInfo.getFabricsInfo().setBomId(bomId);
        fabricsJoinInfo.getFabricsDetailInfo().setFabricId(fabricId);
        fabricsJoinInfo.getMaterialUnitDosage().setMaterialId(fabricId);
        fabricsJoinInfo.getMaterialSpInfo().setMaterialId(fabricId);
    }

    /**
     * 构建面料id:材料类别+供应商代码+年份+材质+品名+序号
     *
     * @param bomInfo
     * @param fabricsJoinInfo
     * @return
     */
    private String buildKindName(BomInfo bomInfo, FabricsJoinInfo fabricsJoinInfo) {
        StringBuilder stringBuilder = new StringBuilder();
        String materialTypeId = StringUtils.isBlank(fabricsJoinInfo.getFabricsInfo().getMaterialTypeId()) ? ApplicationConstant.FABRIC_MATERIAL_TYPE_ID : fabricsJoinInfo.getFabricsInfo().getMaterialTypeId();
        stringBuilder.append(materialTypeId);
        stringBuilder.append(fabricsJoinInfo.getFabricsInfo().getSpId());
        stringBuilder.append(fabricsJoinInfo.getFabricsInfo().getYearCode());
        stringBuilder.append(fabricsJoinInfo.getFabricsInfo().getProductTypeId());
        return stringBuilder.toString();

    }

    /**
     * 找出被删除的面料id，并删除
     *
     * @param fabricItems
     * @param bomId
     */
    private void deleteFabircsByIds(List<FabricsJoinInfo> fabricItems, String bomId) {
        List<String> allFabricIds = fabricsManageDao.selectAllFabricId(bomId);
        List<String> needToSaveFabricId = buildNeedSaveFabricId(fabricItems);
        allFabricIds.removeAll(needToSaveFabricId);
        if (null != allFabricIds && !allFabricIds.isEmpty()) {
            fabricsManageDao.deleteFabircsByIds(allFabricIds);
        }

    }

    private List<String> buildNeedSaveFabricId(List<FabricsJoinInfo> fabricItems) {
        List<String> needToSaveFabricId = new ArrayList<String>();
        if (null != fabricItems) {
            for (FabricsJoinInfo fabricsJoinInfo : fabricItems) {
                String fabricId = fabricsJoinInfo.getFabricsInfo().getFabricId();
                needToSaveFabricId.add(fabricId);
            }
        }
        return needToSaveFabricId;
    }


}