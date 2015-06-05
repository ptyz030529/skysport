package com.skysport.inerfaces.action.system;
import com.skysport.core.action.CommonAction;
import com.skysport.core.bean.DataTablesInfo;
import com.skysport.core.model.seqno.service.IncrementNumber;
import com.skysport.inerfaces.bean.PantoneInfo;
import com.skysport.inerfaces.constant.TableNameConstant;
import com.skysport.inerfaces.helper.CommonHelper;
import com.skysport.inerfaces.model.system.pantone.service.IPantoneManageService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangjh on 2015/6/4.
 */
@Scope("prototype")
@Controller
@RequestMapping("/system/pantone")
public class PantoneManageAction extends CommonAction<String, Object, PantoneInfo> {

    @Resource(name = "pantoneManageService")
    private IPantoneManageService pantoneManageService;

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
        ModelAndView mav = new ModelAndView("/system/pantone/list2");
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
        int recordsTotal = pantoneManageService.listPantoneInfosCounts();
        int recordsFiltered = recordsTotal;
        if (!StringUtils.isBlank(dataTablesInfo.getSearchValue())) {
            recordsFiltered = pantoneManageService.listFilteredPantoneInfosCounts(dataTablesInfo);
        }
        int draw = Integer.parseInt(request.getParameter("draw"));
        List<PantoneInfo> pantoneInfos = pantoneManageService.searchPantoneInfos(dataTablesInfo);
        Map<String, Object> resultMap = buildSearchJsonMap(pantoneInfos, recordsTotal, recordsFiltered, draw);

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
    public Map<String, Object> edit(PantoneInfo pantoneInfo, HttpServletRequest request,
                                    HttpServletResponse respones) throws Exception {
        pantoneManageService.edit(pantoneInfo);
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
    public Map<String, Object> add(PantoneInfo pantoneInfo, HttpServletRequest request,
                                   HttpServletResponse repantoneonse) throws Exception {
        //设置ID
        pantoneInfo.setPantoneId(CommonHelper.SINGLETONE.getFullSeqNo(TableNameConstant.Pantone_INFO, incrementNumber));
        pantoneManageService.add(pantoneInfo);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("code", "0");
        resultMap.put("message", "新增成功");
        return resultMap;
    }


    /**
     * @param pantoneId     供应商id
     * @param request       请求信息
     * @param repantoneonse 返回信息
     * @return 根据供应商id找出供应商详细信息
     */
    @RequestMapping(value = "/info/{pantoneId}", method = RequestMethod.GET)
    @ResponseBody
    public PantoneInfo queryPantoneNo(@PathVariable String pantoneId, HttpServletRequest request, HttpServletResponse repantoneonse) {
        PantoneInfo pantoneInfo = pantoneManageService.queryPantoneInfoByPantoneId(pantoneId);
        return pantoneInfo;
    }

    /**
     * @param pantoneId
     * @return
     */
    @RequestMapping(value = "/del/{pantoneId}", method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> del(@PathVariable String pantoneId) {
        pantoneManageService.del(pantoneId);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("code", "0");
        resultMap.put("message", "删除成功");
        return resultMap;
    }

}
