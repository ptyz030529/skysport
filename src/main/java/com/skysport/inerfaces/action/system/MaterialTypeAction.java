package com.skysport.inerfaces.action.system;

import com.skysport.core.action.BaseAction;
import com.skysport.core.bean.query.DataTablesInfo;
import com.skysport.core.bean.system.SelectItem;
import com.skysport.core.constant.DictionaryKeyConstant;
import com.skysport.core.model.seqno.service.IncrementNumber;
import com.skysport.inerfaces.bean.system.MaterialTypeInfo;
import com.skysport.inerfaces.constant.TableNameConstant;
import com.skysport.inerfaces.helper.BuildSeqNoHelper;
import com.skysport.inerfaces.model.common.ICommonService;
import com.skysport.inerfaces.model.system.material_type.MaterialTypeManageServiceHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类描述的是：材料类别
 * Created by zhangjh on 2015/6/17.
 */
@Scope("prototype")
@Controller
@RequestMapping("/system/material_type")
public class MaterialTypeAction extends BaseAction<String, Object, MaterialTypeInfo> {


    @Resource(name = "materialTypeManageService")
    private ICommonService materialTypeManageService;

    @Resource(name = "incrementNumber")
    private IncrementNumber incrementNumber;

    /**
     * 此方法描述的是：展示list页面
     *
     * @author: zhangjh
     * @version: 2015年4月29日 下午5:34:53
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public ModelAndView search()  {
        ModelAndView mav = new ModelAndView("/system/material_type/list");
        return mav;
    }


    /**
     * 此方法描述的是：查询数据集
     *
     * @author: zhangjh
     * @version: 2015年4月29日 下午5:34:53
     */
    @RequestMapping(value = "/search")
    @ResponseBody
    public Map<String, Object> search(HttpServletRequest request)
             {
        // HashMap<String, String> paramMap = convertToMap(params);
        DataTablesInfo dataTablesInfo = convertToDataTableQrInfo(DictionaryKeyConstant.MATERIAL_TYPE_TABLE_COLUMN, request);
        // 总记录数
        int recordsTotal = materialTypeManageService.listInfosCounts();
        int recordsFiltered = recordsTotal;
        if (!StringUtils.isBlank(dataTablesInfo.getSearchValue())) {
            recordsFiltered = materialTypeManageService.listFilteredInfosCounts(dataTablesInfo);
        }
        int draw = Integer.parseInt(request.getParameter("draw"));
        List<MaterialTypeInfo> material_typeInfos = materialTypeManageService.searchInfos(dataTablesInfo);
        Map<String, Object> resultMap = buildSearchJsonMap(material_typeInfos, recordsTotal, recordsFiltered, draw);

        return resultMap;
    }

    /**
     * 此方法描述的是：编辑信息
     *
     * @author: zhangjh
     * @version: 2015年4月29日 下午5:35:09
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> edit(MaterialTypeInfo material_typeInfo, HttpServletRequest request,
                                    HttpServletResponse respones)  {
        materialTypeManageService.edit(material_typeInfo);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("code", "0");
        resultMap.put("message", "更新成功");
        return resultMap;
    }


    /**
     * 此方法描述的是：新增
     *
     * @author: zhangjh
     * @version: 2015年4月29日 下午5:35:09
     */
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> add(MaterialTypeInfo material_typeInfo,HttpServletRequest request)  {
        String currentNo = materialTypeManageService.queryCurrentSeqNo();
        //设置ID
        material_typeInfo.setNatrualkey(BuildSeqNoHelper.SINGLETONE.getNextSeqNo(TableNameConstant.MATERIAL_TYPE_INFO, currentNo, incrementNumber));
        materialTypeManageService.add(material_typeInfo);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("code", "0");
        resultMap.put("message", "新增成功");

        ApplicationContext appContext = RequestContextUtils.getWebApplicationContext(request);
        MaterialTypeManageServiceHelper.SINGLETONE.refreshSelect(appContext);
        return resultMap;
    }


    /**
     * @param natrualKey 主键id
     * @return 根据主键id找出详细信息
     */
    @RequestMapping(value = "/info/{natrualKey}", method = RequestMethod.GET)
    @ResponseBody
    public MaterialTypeInfo queryCustomerNo(@PathVariable String natrualKey) {
        MaterialTypeInfo material_typeInfo = (MaterialTypeInfo) materialTypeManageService.queryInfoByNatrualKey(natrualKey);
        return material_typeInfo;
    }

    /**
     * @param natrualKey
     * @return 删除
     */
    @RequestMapping(value = "/del/{natrualKey}", method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> del(@PathVariable String natrualKey) {
        materialTypeManageService.del(natrualKey);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("code", "0");
        resultMap.put("message", "删除成功");
        return resultMap;
    }

    /**
     * @param request
     * @return
     */
    @RequestMapping(value = "/select", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> querySelectList(HttpServletRequest request) {
        String name = request.getParameter("name");
        List<SelectItem> commonBeans = materialTypeManageService.querySelectList(name);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("items", commonBeans);
        resultMap.put("total_count", commonBeans.size());
        return resultMap;
    }
}
