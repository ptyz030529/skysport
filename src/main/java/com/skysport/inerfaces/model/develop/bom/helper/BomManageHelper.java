package com.skysport.inerfaces.model.develop.bom.helper;

import com.skysport.inerfaces.bean.BomInfo;
import com.skysport.inerfaces.bean.ProjectBomInfo;
import com.skysport.inerfaces.form.develop.BomQueryForm;
import com.skysport.inerfaces.model.develop.bom.IBomManageService;

import javax.servlet.http.HttpServletRequest;

/**
 * 类说明:
 * Created by zhangjh on 2015/7/13.
 */
public class BomManageHelper {

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
     * 自动生成Bom信息，并保存
     *
     * @param bomManageService BomManageService
     * @param info             项目信息
     */
    public static void autoCreateBomInfoAndSave(IBomManageService<BomInfo> bomManageService, ProjectBomInfo info) {

    }
}
