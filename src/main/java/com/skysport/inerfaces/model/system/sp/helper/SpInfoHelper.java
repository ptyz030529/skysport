package com.skysport.inerfaces.model.system.sp.helper;

/**
 * Created by zhangjh on 2015/6/1.
 */
public enum SpInfoHelper {
    /**
     *
     */
    SINGLETONE;

//    /**
//     *
//     * @param incrementNumber
//     * @param spinfo
//     */
//    public void setSpId(IncrementNumber incrementNumber, SpInfo spinfo) {
//        int seqNo = incrementNumber.nextVal(TableNameConstant.SP_INFO);
//        int length = Integer.parseInt(DictionaryInfo.SINGLETONE.getDictionaryValue(DictionaryTypeConstant.SEQ_NO_LENGTH, TableNameConstant.SP_INFO));
//        String spId = IncrementNumberHelper.SINGLETONE.formatSeqNo(length, seqNo);
//        spinfo.setSpId(spId);
//    }
}
