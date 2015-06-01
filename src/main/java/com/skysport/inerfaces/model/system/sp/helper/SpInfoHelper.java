package com.skysport.inerfaces.model.system.sp.helper;

import com.skysport.core.constant.DictionaryTypeConstant;
import com.skysport.core.instance.DictionaryInfo;
import com.skysport.core.model.seqno.helper.IncrementNumberHelper;
import com.skysport.core.model.seqno.service.IncrementNumber;
import com.skysport.inerfaces.bean.SpInfo;
import com.skysport.inerfaces.constant.TableNameConstant;

/**
 * Created by zhangjh on 2015/6/1.
 */
public enum SpInfoHelper {
    /**
     *
     */
    SINGLETONE;

    public void setSpId(IncrementNumber incrementNumber, SpInfo spinfo) {
        int seqNo = incrementNumber.nextVal(TableNameConstant.SP_INFO);
        int length = Integer.parseInt(DictionaryInfo.SINGLETONE.getDictionaryValue(DictionaryTypeConstant.SEQ_NO_LENGTH, TableNameConstant.SP_INFO));
        String spId = IncrementNumberHelper.SINGLETONE.formatSeqNo(length, seqNo);
        spinfo.setSpId(spId);
    }
}
