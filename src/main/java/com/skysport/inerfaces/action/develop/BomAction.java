package com.skysport.inerfaces.action.develop;

import com.skysport.core.action.TableListQueryAction;
import com.skysport.inerfaces.bean.BomInfo;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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

    /**
     * 此方法描述的是：展示list页面	 *
     *
     * @author: zhangjh
     * @version: 2015年4月29日 下午5:34:53
     */
    @RequestMapping(value = "/bom-add")
    @ResponseBody
    public ModelAndView search() throws Exception {
        ModelAndView mav = new ModelAndView("/development/bom/bom-add");
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
//        // HashMap<String, String> paramMap = convertToMap(params);
//        DataTablesInfo dataTablesInfo = convertToDataTableQrInfo(DictionaryTypeConstant.AREA_TABLE_COLULMN, request);
//        // 总记录数
//        int recordsTotal = areaManageService.listInfosCounts();
//        int recordsFiltered = recordsTotal;
//        if (!StringUtils.isBlank(dataTablesInfo.getSearchValue())) {
//            recordsFiltered = areaManageService.listFilteredInfosCounts(dataTablesInfo);
//        }
//        int draw = Integer.parseInt(request.getParameter("draw"));
        List<BomInfo> infos = new ArrayList<BomInfo>();
        Map<String, Object> resultMap = buildSearchJsonMap(infos, 0, 0, 1);

        return resultMap;
    }


}
