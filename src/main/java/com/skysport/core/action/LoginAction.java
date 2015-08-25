package com.skysport.core.action;

import com.skysport.core.bean.permission.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Scope("prototype")
@Controller
@RequestMapping("/")
public class LoginAction {

    @RequestMapping(value = "/login")
    @ResponseBody
    public ModelAndView getProducts(User user, HttpServletRequest request,
                                    HttpServletResponse response) {

        ModelAndView mav = new ModelAndView("main");
        return mav;

    }

}
