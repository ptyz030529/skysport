package com.skysport.core.model.seqno.service;

/**
 * Created by zhangjh on 2015/6/1.
 */
public interface  IncrementNumber {
    public int nextVal(String name);

    public int reset();

}
