package com.skysport.core.instance;

import com.skysport.core.bean.system.SelectItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类说明:
 * Created by zhangjh on 2015/7/6.
 */
public enum SystemBaseInfo {
    SINGLETONE;
    private Map<String, List<SelectItem>> bomBuildInfoMaps = new HashMap<String, List<SelectItem>>();
    private Map<String, List<SelectItem>> projectBuildInfoMaps = new HashMap<String, List<SelectItem>>();

    public void pushBom(String key, List<SelectItem> values) {
        bomBuildInfoMaps.put(key, values);
    }


    public List<SelectItem> popBom(String key) {
        return bomBuildInfoMaps.get(key);
    }

    public Map<String, List<SelectItem>> rtnBomInfoMap() {
        return bomBuildInfoMaps;
    }

    public void pushProject(String key, List<SelectItem> values) {
        projectBuildInfoMaps.put(key, values);
    }


    public List<SelectItem> popProject(String key) {
        return projectBuildInfoMaps.get(key);
    }

    public Map<String, List<SelectItem>> rtnProjectInfoMap() {
        return projectBuildInfoMaps;
    }


}
