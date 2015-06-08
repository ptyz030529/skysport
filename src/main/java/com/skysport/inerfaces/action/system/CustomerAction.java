package com.skysport.inerfaces.action.system;

import com.skysport.core.action.CommonAction;
import com.skysport.core.bean.DataTablesInfo;
import com.skysport.core.model.seqno.service.IncrementNumber;
import com.skysport.inerfaces.bean.CustomerInfo;
import com.skysport.inerfaces.constant.TableNameConstant;
import com.skysport.inerfaces.helper.CommonHelper;
import com.skysport.inerfaces.model.system.common.service.ICommonService;
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
 * 客户信息
 * Created by zhangjh on 2015/6/3.
 */
@Scope("prototype")
@Controller
@RequestMapping("/system/customer")
public class CustomerAction extends  CommonAction<String, Object, CustomerInfo>  {

    @Resource(name = "customerManageService")
    private ICommonService customerManageService;

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
        ModelAndView mav = new ModelAndView("/system/customer/list");
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
        int recordsTotal = customerManageService.listInfosCounts();
        int recordsFiltered = recordsTotal;
        if (!StringUtils.isBlank(dataTablesInfo.getSearchValue())) {
            recordsFiltered = customerManageService.listFilteredInfosCounts(dataTablesInfo);
        }
        int draw = Integer.parseInt(request.getParameter("draw"));
        List<CustomerInfo> customerInfos = customerManageService.searchInfos(dataTablesInfo);
        Map<String, Object> resultMap = buildSearchJsonMap(customerInfos, recordsTotal, recordsFiltered, draw);

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
    public Map<String, Object> edit(CustomerInfo customerInfo, HttpServletRequest request,
                                    HttpServletResponse respones) throws Exception {
        customerManageService.edit(customerInfo);
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
    public Map<String, Object> add(CustomerInfo customerInfo, HttpServletRequest request,
                                   HttpServletResponse recustomeronse) throws Exception {
        String currentNo =  customerManageService.queryCurrentSeqNo();
        //设置ID
        customerInfo.setNatrualkey(CommonHelper.SINGLETONE.getNextSeqNo(TableNameConstant.CUSTOMER_INFO, currentNo,incrementNumber));
        customerManageService.add(customerInfo);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("code", "0");
        resultMap.put("message", "新增成功");
        return resultMap;
    }


    /**
     * @param natrualKey     供应商id
     * @param request       请求信息
     * @param recustomeronse 返回信息
     * @return 根据供应商id找出供应商详细信息
     */
    @RequestMapping(value = "/info/{natrualKey}", method = RequestMethod.GET)
    @ResponseBody
    public CustomerInfo queryCustomerNo(@PathVariable String natrualKey, HttpServletRequest request, HttpServletResponse recustomeronse) {
        CustomerInfo customerInfo = (CustomerInfo) customerManageService.queryInfoByNatrualKey(natrualKey);
        return customerInfo;
    }

    /**
     * @param natrualKey
     * @return
     */
    @RequestMapping(value = "/del/{natrualKey}", method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> del(@PathVariable String natrualKey) {
        customerManageService.del(natrualKey);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("code", "0");
        resultMap.put("message", "删除成功");
        return resultMap;
    }


}
