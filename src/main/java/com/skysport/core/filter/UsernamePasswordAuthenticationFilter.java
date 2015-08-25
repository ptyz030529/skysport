package com.skysport.core.filter;

import com.skysport.core.constant.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 类说明:
 * Created by zhangjh on 2015/8/21.
 */
public class UsernamePasswordAuthenticationFilter {
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = new Authentication();
        return authentication;
    }
}
