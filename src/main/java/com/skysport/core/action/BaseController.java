package com.skysport.core.action;

import com.skysport.core.bean.BaseResp;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 类说明:
 * Created by zhangjh on 2015/7/13.
 */
public class BaseController<T> {

    protected transient Log logger = LogFactory.getLog(getClass());

    protected <T> Map<String, Object> buildCallBackMap(BaseResp resp, T t) {
        Map<String, Object> rtnMap = new HashMap<>();
        rtnMap.put("resp", resp);
        rtnMap.put("data", t);
        return rtnMap;
    }


}
