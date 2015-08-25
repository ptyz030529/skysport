package com.skysport.inerfaces.action.system;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 类说明:权限分配
 * Created by zhangjh on 2015/8/17.
 */
@Scope("prototype")
@Controller
@RequestMapping("/system/permission")
public class PermissionAction {

    @RequestMapping(value = "/show")
    @ResponseBody
    public ModelAndView show() {
        ModelAndView mav = new ModelAndView("system/permission/permission");
        return mav;
    }


    @RequestMapping(value = "/user-tab/{tabNo}")
    @ResponseBody
    public ModelAndView userTab(@PathVariable String tabNo) {
        ModelAndView mav = new ModelAndView("/system/permission/user-tab");
        mav.addObject("tabNo", tabNo);
        return mav;
    }

}
