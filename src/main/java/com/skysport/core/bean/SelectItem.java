package com.skysport.core.bean;

/**
 * 下拉列表
 * Created by zhangjh on 2015/6/8.
 */
public abstract class SelectItem implements CommonVo {
    private String natrualkey;
    private String name;

    public String getNatrualkey() {
        return natrualkey;
    }

    public void setNatrualkey(String natrualkey) {
        this.natrualkey = natrualkey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
