package com.skysport.inerfaces.constant;

/**
 * 类说明:
 * Created by zhangjh on 2015/7/14.
 */
public interface ApplicationConstant {
    String CATEGORY_A_LEVEL = "1";//一级品类
    String CATEGORY_B_LEVEL = "2";//二级品类

    int PROJECT_SEQ_NO_LENGTH = 4; //项目编号长度
    int BOM_SEQ_NO_LENGTH = 4; //BOM编号长度
    int MATERIAL_SEQ_NO_LENGTH = 5; //BOM编号长度


    String FABRIC_MATERIAL_TYPE_ID = "M";//面料
    String LIN_FABRIC_MATERIAL_TYPE_ID = "L";//里料
    String ACCESSORIE_MATERIAL_TYPE_ID = "F";//辅料
    String PAKING_MATERIAL_TYPE_ID = "B";//包装材料
    String FITTING_MATERIAL_TYPE_ID = "P";//配件
    String CLOTH_MATERIAL_TYPE_ID = "C";//成衣

    int PROJECT_CAN_EDIT = 0;
    int PROJECT_CANOT_EDIT = 1;


}
