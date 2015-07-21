package com.skysport.inerfaces.action.develop;

import com.skysport.core.action.TableListQueryAction;
import com.skysport.core.constant.DictionaryTypeConstant;
import com.skysport.core.model.resp.BaseRespHelper;
import com.skysport.inerfaces.bean.BomInfo;
import com.skysport.inerfaces.bean.ProjectInfo;
import com.skysport.inerfaces.form.develop.BomQueryForm;
import com.skysport.inerfaces.model.develop.bom.IBomManageService;
import com.skysport.inerfaces.model.develop.bom.helper.BomManageHelper;
import com.skysport.inerfaces.model.system.fabrics.IFabricsService;
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
import java.util.List;
import java.util.Map;

/**
 * Bom
 * Created by zhangjh on 2015/6/23.
 */
@Scope("prototype")
@Controller
@RequestMapping("/development/bom")
public class BomAction extends TableListQueryAction<String, Object, BomInfo> {

    @Resource(name = "fabricsManageService")
    private IFabricsService fabricsManageService;

    @Resource(name = "bomManageService")
    private IBomManageService bomManageService;

    /**
     * 此方法描述的是：展示list页面	 *
     *
     * @author: zhangjh
     * @version: 2015年4月29日 下午5:34:53
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public ModelAndView search() throws Exception {
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
    public ModelAndView add() throws Exception {
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
    public ModelAndView add(@PathVariable String natrualKey) throws Exception {
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
        bomQueryForm.setDataTablesInfo(convertToDataTableQrInfo(DictionaryTypeConstant.PROJECT_TABLE_COLULMN, request));
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
     * 组装剩余信息
     *
     * @param infos
     */
    private void buildLastInfos(List<BomInfo> infos) {
        if (null == infos || infos.isEmpty()) return;
        List<ProjectInfo> projectInfos = null;
    }


    /**
     * @param info BomInfo
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> saveBom(BomInfo info) {


        //保存BOM信息
        BomInfo exitBom = bomManageService.queryInfoByNatrualKey(info.getNatrualkey());

        if (null == exitBom) {
            bomManageService.add(info);
        } else {
            bomManageService.edit(info);
        }

        //后台删除前台已删除的面料

        fabricsManageService.addBatch(info.getFabricItems());
        //保存面料信息(先删除所有面料，再新增所有面料)


        //保存 辅料信息


        //保存成衣厂信息
        Map<String, Object> rtnMap = buildCallBackMap(BaseRespHelper.SINGLETONE.dealSucess(), null);

        return rtnMap;
    }


}
