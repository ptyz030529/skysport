package com.skysport.inerfaces.model.system.main_color;

import com.skysport.inerfaces.bean.basic.MainColor;

import java.util.List;

/**
 * 类说明:
 * Created by zhangjh on 2015/7/15.
 */
public interface IMainColorService {
    public List<MainColor> queryMainColorList(String projectId);

    public void add(List<MainColor> mainColorList);

    void delete(String natrualkey);



}
