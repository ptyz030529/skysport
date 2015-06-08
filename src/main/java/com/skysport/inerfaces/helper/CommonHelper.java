package com.skysport.inerfaces.helper;

import com.skysport.core.constant.DictionaryTypeConstant;
import com.skysport.core.instance.DictionaryInfo;
import com.skysport.core.model.seqno.helper.IncrementNumberHelper;
import com.skysport.core.model.seqno.service.IncrementNumber;

/**
 * 通用处理类
 * Created by zhangjh on 2015/6/3.
 */
public enum CommonHelper {
    /**
     * 单例
     */
    SINGLETONE;

    /**
     * 将递增的序列号转成指定长度的序列号（采用左侧补0）
     *
     * @param incrementNumber IncrementNumber
     */
    public String getFullSeqNo(String kind_name, IncrementNumber incrementNumber) {
        int nextVal = incrementNumber.nextVal(kind_name);
        int length = Integer.parseInt(DictionaryInfo.SINGLETONE.getDictionaryValue(DictionaryTypeConstant.SEQ_NO_LENGTH, kind_name));
        String fullSeqNo = IncrementNumberHelper.SINGLETONE.formatSeqNo(length, nextVal);
        return fullSeqNo;
    }

    public String getNextSeqNo(String kind_name,String currentSeqNo, IncrementNumber incrementNumber){
        String nextSeqNo = "";
        int length = Integer.parseInt(DictionaryInfo.SINGLETONE.getDictionaryValue(DictionaryTypeConstant.SEQ_NO_LENGTH, kind_name));
        int nextVal = incrementNumber.nextVal(kind_name,length,currentSeqNo);


        return String.valueOf(nextVal);
    }
}
