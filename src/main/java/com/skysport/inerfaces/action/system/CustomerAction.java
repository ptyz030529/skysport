package com.skysport.inerfaces.action.system;
import com.skysport.core.action.CommonAction;
import com.skysport.core.bean.DataTablesInfo;
import com.skysport.core.model.seqno.service.IncrementNumber;
import com.skysport.inerfaces.bean.CutomerInfo;
import com.skysport.inerfaces.constant.TableNameConstant;
import com.skysport.inerfaces.helper.CommonHelper;
import com.skysport.inerfaces.model.system.customer.service.ICustomerManageService;
import org.apache.commons.lang3.StringUtils;
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
 * 客户信息
 * Created by zhangjh on 2015/6/3.
 */
public class CustomerAction extends CommonAction {
    @Resource(name = "customerManageService")
    private ICustomerManageService customerManageService;
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
        ModelAndView mav = new ModelAndView("/system/cutomer/list");
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
        int recordsTotal = customerManageService.listCutomerInfosCounts();
        int recordsFiltered = recordsTotal;
        if (!StringUtils.isBlank(dataTablesInfo.getSearchValue())) {
            recordsFiltered = customerManageService
                    .listFilteredCutomerInfosCounts(dataTablesInfo);
        }
        int draw = Integer.parseInt(request.getParameter("draw"));
        List<CutomerInfo> cutomerInfos = customerManageService.searchCutomer(dataTablesInfo);
        Map<String, Object> resultMap = buildSearchJsonMap(cutomerInfos,
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
    public Map<String, Object> edit(CutomerInfo cutomerInfo, HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {
        customerManageService.edit(cutomerInfo);
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
    public Map<String, Object> add(CutomerInfo cutomerInfo, HttpServletRequest request,
                                   HttpServletResponse response) throws Exception {
        //设置ID
        cutomerInfo.setCutomerId(CommonHelper.SINGLETONE.getFullSeqNo(TableNameConstant.SP_INFO, incrementNumber));
        customerManageService.add(cutomerInfo);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("code", "0");
        resultMap.put("message", "新增成功");
        return resultMap;
    }


    /**
     * @param cutomerId     供应商id
     * @param request  请求信息
     * @param response 返回信息
     * @return 根据供应商id找出供应商详细信息
     */
    @RequestMapping(value = "/cutomerinfo/{cutomerId}", method = RequestMethod.GET)
    @ResponseBody
    public CutomerInfo querySpNo(@PathVariable String cutomerId, HttpServletRequest request, HttpServletResponse response) {
        CutomerInfo cutomerInfo = customerManageService.queryCutomerByCutomerId(cutomerId);
        return cutomerInfo;
    }

    /**
     * @param cutomerId
     * @return
     */
    @RequestMapping(value = "/del/{cutomerId}", method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> del(@PathVariable String cutomerId) {
        customerManageService.del(cutomerId);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("code", "0");
        resultMap.put("message", "删除成功");
        return resultMap;
    }

}
