package com.skysport.inerfaces.action;

import com.skysport.core.action.CommonAction;
import com.skysport.core.bean.DataTablesInfo;
import com.skysport.core.model.seqno.service.IncrementNumber;
import com.skysport.inerfaces.bean.SpInfo;
import com.skysport.inerfaces.model.system.sp.helper.SpInfoHelper;
import com.skysport.inerfaces.model.system.sp.service.ISpManageService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 此类描述的是：
 *
 * @author: zhangjh
 * @version: 2015年4月29日 下午5:34:47
 */
@Scope("prototype")
@Controller
@RequestMapping("/system/sp")
public class SpManageAction extends CommonAction<String, Object, SpInfo> {
    @Resource(name = "spManageService")
    private ISpManageService spManageService;
    @Resource(name = "incrementNumber")
    private IncrementNumber incrementNumber;

    /**
     * 此方法描述的是：展示list页面	 *
     *
     * @author: zhangjh
     * @version: 2015年4月29日 下午5:34:53
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public ModelAndView search() throws Exception {
        ModelAndView mav = new ModelAndView("/system/sp/list2");
        return mav;
    }


    /**
     * 此方法描述的是：
     *
     * @author: zhangjh
     * @version: 2015年4月29日 下午5:34:53
     */
    @RequestMapping(value = "/search")
    @ResponseBody
    public Map<String, Object> search(HttpServletRequest request)
            throws Exception {
        // HashMap<String, String> paramMap = convertToMap(params);
        DataTablesInfo dataTablesInfo = convertToDataTableQrInfo(request);
        // 总记录数
        int recordsTotal = spManageService.listSPInfosCounts();
        int recordsFiltered = recordsTotal;
        if (!StringUtils.isBlank(dataTablesInfo.getSearchValue())) {
            recordsFiltered = spManageService
                    .listFilteredSPInfosCounts(dataTablesInfo);
        }
        int draw = Integer.parseInt(request.getParameter("draw"));
        List<SpInfo> spInfos = spManageService.searchSP(dataTablesInfo);
        Map<String, Object> resultMap = buildSearchJsonMap(spInfos,
                recordsTotal, recordsFiltered, draw);

        return resultMap;
    }

    /**
     * 此方法描述的是：
     *
     * @author: zhangjh
     * @version: 2015年4月29日 下午5:35:09
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> edit( SpInfo spInfo, HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {
        spManageService.edit(spInfo);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("code", "0");
        resultMap.put("message", "更新成功");
        return resultMap;
    }


    /**
     * 此方法描述的是：
     *
     * @author: zhangjh
     * @version: 2015年4月29日 下午5:35:09
     */
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> add(SpInfo spInfo, HttpServletRequest request,
                                   HttpServletResponse response) throws Exception {
        SpInfoHelper.SINGLETONE.setSpId(incrementNumber, spInfo);
        spManageService.add(spInfo);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("code", "0");
        resultMap.put("message", "新增成功");
        return resultMap;
    }


    /**
     * @param spId     供应商id
     * @param request  请求信息
     * @param response 返回信息
     * @return 根据供应商id找出供应商详细信息
     */
    @RequestMapping(value = "/spinfo/{spId}", method = RequestMethod.GET)
    @ResponseBody
    public SpInfo querySpNo(@PathVariable String spId, HttpServletRequest request, HttpServletResponse response) {
        SpInfo spInfo = spManageService.querySpInfoBySpId(spId);
        return spInfo;
    }

    /**
     * @param spId
     * @return
     */
    @RequestMapping(value = "/del/{spId}", method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object>  del(@PathVariable String spId) {
        spManageService.del(spId);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("code", "0");
        resultMap.put("message", "删除成功");
        return resultMap;
    }


}
