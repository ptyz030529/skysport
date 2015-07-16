package com.skysport.core.action;

import com.skysport.core.bean.BaseResp;

import java.util.HashMap;
import java.util.Map;

/**
 * 类说明:
 * Created by zhangjh on 2015/7/13.
 */
public class BaseController<T> {

    public <T> Map<String, Object> buildCallBackMap(BaseResp resp, T t) {
        Map<String, Object> rtnMap = new HashMap<>();
        rtnMap.put("resp", resp);
        rtnMap.put("data", t);
        return rtnMap;
    }


}
