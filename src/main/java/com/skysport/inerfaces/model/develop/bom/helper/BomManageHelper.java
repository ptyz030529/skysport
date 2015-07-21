package com.skysport.inerfaces.model.develop.bom.helper;

import com.skysport.core.constant.CharConstant;
import com.skysport.core.model.seqno.service.IncrementNumber;
import com.skysport.inerfaces.bean.BomInfo;
import com.skysport.inerfaces.bean.ProjectBomInfo;
import com.skysport.inerfaces.constant.SystemInfoConstant;
import com.skysport.inerfaces.form.develop.BomQueryForm;
import com.skysport.inerfaces.helper.BuildSeqNoHelper;
import com.skysport.inerfaces.model.develop.bom.IBomManageService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 类说明:
 * Created by zhangjh on 2015/7/13.
 */
public class BomManageHelper {
    static Logger logger = Logger.getLogger(BomManageHelper.class);

    /**
     * 自定义查询条件
     *
     * @param bomQueryForm
     * @param request
     */
    public static void buildBomQueryForm(BomQueryForm bomQueryForm, HttpServletRequest request) {
        bomQueryForm.getBomInfo().setProjectId(request.getParameter("projectId"));
        bomQueryForm.getBomInfo().setAreaId(request.getParameter("areaId"));

    }

    /**
     * 自动生成Bom信息，并保存DB
     *
     * @param bomManageService BomManageService
     * @param info             项目信息
     */
    public static void autoCreateBomInfoAndSave(IBomManageService bomManageService, IncrementNumber incrementNumber, ProjectBomInfo info) {
        String[] mainColors = info.getMainColorNames().split(CharConstant.COMMA);
        String[] sexIds = info.getSexIds().split(CharConstant.COMMA);
        String projectId = info.getNatrualkey();
        String customerId = info.getCustomerId();
        String areaId = info.getAreaId();
        String seriesId = info.getSeriesId();
        List<BomInfo> bomInfos = new ArrayList();
        for (String mainColor : mainColors) {
            for (String sexId : sexIds) {
                BomInfo bomInfo = new BomInfo();
                String kind_name = buildKindName(info);
                String seqNo = BuildSeqNoHelper.SINGLETONE.getFullSeqNo(kind_name, incrementNumber, SystemInfoConstant.BOM_SEQ_NO_LENGTH);
                //年份+客户+地域+系列+NNN
                String bomId = kind_name + seqNo;

                bomInfo.setMainColor(mainColor);
                bomInfo.setSexId(sexId);
                bomInfo.setProjectId(projectId);
                bomInfo.setCustomerId(customerId);
                bomInfo.setAreaId(areaId);
                bomInfo.setSeriesId(seriesId);
                bomInfo.setCollectionNum(seqNo);//款式
                bomInfo.setBomId(bomId);//
//                    bomInfo.setOfferAmount();
                bomInfo.setNatrualkey(bomId);
                logger.info(bomInfo);
                bomInfos.add(bomInfo);

            }
        }


        bomManageService.addBatch(bomInfos);


    }

    public static String buildKindName(ProjectBomInfo info) {
        return buildKindName(info.getNatrualkey(), info.getCategoryAid(), info.getCategoryBid());
    }

    public static String buildKindName(String projectId, String categoryAid, String categoryBid) {
        return new StringBuilder().append(projectId).append(categoryAid).append(categoryBid).toString();
    }
}
