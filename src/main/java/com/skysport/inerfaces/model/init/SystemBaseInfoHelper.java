package com.skysport.inerfaces.model.init;

import com.skysport.inerfaces.model.system.area.helper.AreaManageServiceHelper;
import com.skysport.inerfaces.model.system.category.CategoryManageServiceHelper;
import com.skysport.inerfaces.model.system.customer.helper.CustomerManageServiceHelper;
import com.skysport.inerfaces.model.system.material.impl.helper.*;
import com.skysport.inerfaces.model.system.material_classic.MaterialClassicManageServiceHelper;
import com.skysport.inerfaces.model.system.material_type.MaterialTypeManageServiceHelper;
import com.skysport.inerfaces.model.system.product_type.ProductTypeManageServiceHelper;
import com.skysport.inerfaces.model.system.series.SeriesManageServiceHelper;
import com.skysport.inerfaces.model.system.sex.SexManageServiceHelper;
import com.skysport.inerfaces.model.system.sp.helper.SpInfoHelper;
import com.skysport.inerfaces.model.system.year_conf.YearConfManageServiceHelper;
import org.springframework.context.ApplicationContext;

/**
 * 类说明:
 * Created by zhangjh on 2015/7/6.
 */
public enum SystemBaseInfoHelper {
    /**
     * 单例
     */
    SINGLETONE;


    public void initSystemBaseInfo(ApplicationContext appContext) {


        //年份列表
        YearConfManageServiceHelper.SINGLETONE.refreshSelect(appContext);
        //客户信息
        CustomerManageServiceHelper.SINGLETONE.refreshSelect(appContext);

        //区域信息
        AreaManageServiceHelper.SINGLETONE.refreshSelect(appContext);

        //系列
        SeriesManageServiceHelper.SINGLETONE.refreshSelect(appContext);

        //性别属性
        SexManageServiceHelper.SINGLETONE.refreshSelect(appContext);

        //材料类型
        MaterialTypeManageServiceHelper.SINGLETONE.refreshSelect(appContext);

        //供应商列表
        SpInfoHelper.SINGLETONE.refreshSelect(appContext);



        //材质列表
        MaterialClassicManageServiceHelper.SINGLETONE.refreshSelect(appContext);

        //品类级别
        CategoryManageServiceHelper.SINGLETONE.refreshSelect(appContext);
//        // 颜色列表
//        PantoneManageServiceImpl pantoneManageService = (PantoneManageServiceImpl) appContext.getBean("pantoneManageService");
//        List<SelectItem> pantoneItems = pantoneManageService.querySelectList("");
//        SystemBaseInfo.SINGLETONE.pushBom("pantoneItems", pantoneItems);

        // 品名列表
        ProductTypeManageServiceHelper.SINGLETONE.refreshSelect(appContext);

        // 纱支密度列表

        SpecificationServiceHelper.SINGLETONE.refreshSelect(appContext);

        // 染色方式列表
        DyeServiceHelper.SINGLETONE.refreshSelect(appContext);

        // 后整理列表
        FinishServiceHelper.SINGLETONE.refreshSelect(appContext);

        // 复合或涂层列表
        BondingLaminationCoatingServiceHelper.SINGLETONE.refreshSelect(appContext);

        // 膜或涂层的材质列表
        MaterialOfMembraneCoatingServicHelper.SINGLETONE.refreshSelect(appContext);

        // 膜或涂层的颜色列表
        ColorOfMembraneCoatingServiceHelper.SINGLETONE.refreshSelect(appContext);

        // 透湿程度列表
        WaterVapourPermeabilityServiceHelper.SINGLETONE.refreshSelect(appContext);

        // 膜的厚度列表
        MembraneThicknessServiceHelper.SINGLETONE.refreshSelect(appContext);

        // 贴膜或涂层工艺列表
        WorkmanshipOfBondingLaminatingCoatingServiceHelper.SINGLETONE.refreshSelect(appContext);

        // 物料位置列表
        MaterialPositionServiceHelper.SINGLETONE.refreshSelect(appContext);

        //
        MaterialUnitServiceHelper.SINGLETONE.refreshSelect(appContext);


    }
}
