package com.skysport.inerfaces.action.system.material;

import com.skysport.core.action.BaseAction;
import com.skysport.core.bean.system.SelectItem;
import com.skysport.core.bean.query.DataTablesInfo;
import com.skysport.core.constant.DictionaryTypeConstant;
import com.skysport.core.model.seqno.service.IncrementNumber;
import com.skysport.inerfaces.bean.material.BondingLaminationCoatingInfo;
import com.skysport.inerfaces.constant.TableNameConstant;
import com.skysport.inerfaces.helper.BuildSeqNoHelper;
import com.skysport.inerfaces.model.common.ICommonService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类说明:复合或涂层
 * Created by zhangjh on 2015/6/25.
 */
@Scope("prototype")
@Controller
@RequestMapping("/system/material/blc")
public class BondingLaminationCoatingAction extends BaseAction<String, Object, BondingLaminationCoatingInfo> {
    @Resource(name = "bondingLaminationCoatingService")
    private ICommonService bondingLaminationCoatingService;

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
        ModelAndView mav = new ModelAndView("/system/material/blc/list");
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
        DataTablesInfo dataTablesInfo = convertToDataTableQrInfo(DictionaryTypeConstant.BLC_TABLE_COLUMN, request);
        // 总记录数
        int recordsTotal = bondingLaminationCoatingService.listInfosCounts();
        int recordsFiltered = recordsTotal;
        if (!StringUtils.isBlank(dataTablesInfo.getSearchValue())) {
            recordsFiltered = bondingLaminationCoatingService.listFilteredInfosCounts(dataTablesInfo);
        }
        int draw = Integer.parseInt(request.getParameter("draw"));
        List<BondingLaminationCoatingInfo> infos = bondingLaminationCoatingService.searchInfos(dataTablesInfo);
        Map<String, Object> resultMap = buildSearchJsonMap(infos, recordsTotal, recordsFiltered, draw);

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
    public Map<String, Object> edit(BondingLaminationCoatingInfo areaInfo, HttpServletRequest request,
                                    HttpServletResponse respones) throws Exception {
        bondingLaminationCoatingService.edit(areaInfo);
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
    public Map<String, Object> add(BondingLaminationCoatingInfo areaInfo, HttpServletRequest request,
                                   HttpServletResponse reareaonse) throws Exception {
        String currentNo = bondingLaminationCoatingService.queryCurrentSeqNo();
        //设置ID
        areaInfo.setNatrualkey(BuildSeqNoHelper.SINGLETONE.getNextSeqNo(TableNameConstant.BLC_INFO, currentNo, incrementNumber));
        bondingLaminationCoatingService.add(areaInfo);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("code", "0");
        resultMap.put("message", "新增成功");
        return resultMap;
    }


    /**
     * @param natrualKey 主键id
     * @param request    请求信息
     * @param reareaonse 返回信息
     * @return 根据主键id找出详细信息
     */
    @RequestMapping(value = "/info/{natrualKey}", method = RequestMethod.GET)
    @ResponseBody
    public BondingLaminationCoatingInfo queryCustomerNo(@PathVariable String natrualKey, HttpServletRequest request, HttpServletResponse reareaonse) {
        BondingLaminationCoatingInfo areaInfo = (BondingLaminationCoatingInfo) bondingLaminationCoatingService.queryInfoByNatrualKey(natrualKey);
        return areaInfo;
    }

    /**
     * @param natrualKey
     * @return
     */
    @RequestMapping(value = "/del/{natrualKey}", method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> del(@PathVariable String natrualKey) {
        bondingLaminationCoatingService.del(natrualKey);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("code", "0");
        resultMap.put("message", "删除成功");
        return resultMap;
    }

    @RequestMapping(value = "/select", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> querySelectList(HttpServletRequest request) {
        String name = request.getParameter("name");
        List<SelectItem> commonBeans = bondingLaminationCoatingService.querySelectList(name);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("items", commonBeans);
        resultMap.put("total_count", commonBeans.size());
        return resultMap;
    }
}