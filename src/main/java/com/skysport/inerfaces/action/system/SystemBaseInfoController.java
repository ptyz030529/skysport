package com.skysport.inerfaces.action.system;

import com.skysport.core.bean.system.SelectItem;
import com.skysport.core.instance.SystemBaseInfo;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 类说明:
 * Created by zhangjh on 2015/7/14.
 */
@Scope("prototype")
@Controller
@RequestMapping("/system/baseinfo")
public class SystemBaseInfoController {

    /**
     * 此方法描述的是：
     *
     * @author: zhangjh
     * @version: 2015年4月29日 下午5:34:53
     */
    @RequestMapping(value = "/bom_select")
    @ResponseBody
    public Map<String, List<SelectItem>> bomSelectItem() {
        Map<String, List<SelectItem>> systemBaseMaps = SystemBaseInfo.SINGLETONE.rtnBomInfoMap();
        return systemBaseMaps;
    }

    /**
     * 此方法描述的是：
     *
     * @author: zhangjh
     * @version: 2015年4月29日 下午5:34:53
     */
    @RequestMapping(value = "/project_select")
    @ResponseBody
    public Map<String, List<SelectItem>> projectSelectItem() {
        Map<String, List<SelectItem>> systemBaseMaps = SystemBaseInfo.SINGLETONE.rtnProjectInfoMap();
        return systemBaseMaps;
    }
}
