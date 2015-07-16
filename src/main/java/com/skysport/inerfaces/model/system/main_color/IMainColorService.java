package com.skysport.inerfaces.model.system.main_color;

import java.util.List;

/**
 * 类说明:
 * Created by zhangjh on 2015/7/15.
 */
public interface IMainColorService<T> {
    public List<T> queryMainColorList(String projectId);

    public void add(List<T> mainColorList);


}
