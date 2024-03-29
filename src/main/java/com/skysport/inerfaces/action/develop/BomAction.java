package com.skysport.inerfaces.action.develop;

import com.skysport.core.action.BaseAction;
import com.skysport.core.constant.DictionaryKeyConstant;
import com.skysport.inerfaces.bean.develop.BomInfo;
import com.skysport.inerfaces.bean.develop.QuotedInfo;
import com.skysport.inerfaces.form.develop.BomQueryForm;
import com.skysport.inerfaces.model.develop.bom.IBomManageService;
import com.skysport.inerfaces.model.develop.bom.helper.BomManageHelper;
import com.skysport.inerfaces.model.develop.quoted.service.IQuotedService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Bom
 * Created by zhangjh on 2015/6/23.
 */
@Scope("prototype")
@Controller
@RequestMapping("/development/bom")
public class BomAction extends BaseAction<String, Object, BomInfo> {

    @Resource(name = "bomManageService")
    private IBomManageService bomManageService;

    @Resource(name = "quotedService")
    private IQuotedService quotedService;

    /**
     * 此方法描述的是：展示list页面	 *
     *
     * @author: zhangjh
     * @version: 2015年4月29日 下午5:34:53
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public ModelAndView search() {
        ModelAndView mav = new ModelAndView("/development/bom/bom-list");
        return mav;
    }

    /**
     * 此方法描述的是：展示list页面	 *
     *
     * @author: zhangjh
     * @version: 2015年4月29日 下午5:34:53
     */
    @RequestMapping(value = "/bom-add")
    @ResponseBody
    public ModelAndView add() {
        ModelAndView mav = new ModelAndView("/development/bom/bom-add");
        return mav;
    }

    /**
     * 此方法描述的是：展示add页面
     *
     * @author: zhangjh
     * @version: 2015年4月29日 下午5:34:53
     */
    @RequestMapping(value = "/add/{natrualKey}", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView add(@PathVariable String natrualKey) {
        ModelAndView mav = new ModelAndView("/development/bom/bom-add");
        mav.addObject("natrualkey", natrualKey);
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
    public Map<String, Object> search(HttpServletRequest request) {
        //组件queryFory的参数
        BomQueryForm bomQueryForm = new BomQueryForm();
        bomQueryForm.setDataTablesInfo(convertToDataTableQrInfo(DictionaryKeyConstant.PROJECT_TABLE_COLULMN, request));
        BomInfo bomInfo = new BomInfo();
        bomQueryForm.setBomInfo(bomInfo);
        BomManageHelper.buildBomQueryForm(bomQueryForm, request);

        // 总记录数
        int recordsTotal = bomManageService.listInfosCounts();
        int recordsFiltered = recordsTotal;

        if (!StringUtils.isBlank(bomQueryForm.getDataTablesInfo().getSearchValue())) {
            recordsFiltered = bomManageService.listFilteredInfosCounts(bomQueryForm);
        }

        int draw = Integer.parseInt(request.getParameter("draw"));

        List<BomInfo> infos = bomManageService.searchInfos(bomQueryForm);
        BomManageHelper.turnIdToName(infos);
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
    public Map<String, Object> edit(@RequestBody BomInfo info) {
        info.setBomId(info.getNatrualkey());
        bomManageService.edit(info);
        Map resultMap = rtnSuccessResultMap(MSG_UPDATE_SUCCESS);
        return resultMap;
    }


    /**
     * @param natrualKey 主键id
     * @return 根据主键id找出详细信息
     */
    @RequestMapping(value = "/info/{natrualKey}", method = RequestMethod.GET)
    @ResponseBody
    public BomInfo queryCustomerNo(@PathVariable String natrualKey) {

        BomInfo info = bomManageService.queryInfoByNatrualKey(natrualKey);


        QuotedInfo quotedInfo = quotedService.queryInfoByNatrualKey(natrualKey);

        info.setQuotedInfo(quotedInfo);



        return info;
    }

}
