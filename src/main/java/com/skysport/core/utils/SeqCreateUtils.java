package com.skysport.core.utils;

import org.junit.Test;

/**
 * 说明:
 * Created by zhangjh on 2015/8/24.
 */
public class SeqCreateUtils {
    public SeqCreateUtils() {
        super();
    }


    /**
     * 获取项目编号
     *
     * @param seriesId 系列id
     * @return 项目id:4位随机数+时间戳(号+月+年+秒+分+小时+毫秒)+系列id
     */
    public static String newRrojectSeq(String seriesId) {
        StringBuilder projectSeqNo = new StringBuilder();
        long randomNum = java.util.concurrent.ThreadLocalRandom.current().nextInt(1000, 10000);
        java.util.Date current = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("ddMMyyssmmHHSSS");
        String timestamp = sdf.format(current);
//        long timestamp = System.currentTimeMillis();
        projectSeqNo.append(randomNum).append(timestamp).append(seriesId);
        return projectSeqNo.toString();
    }

    /**
     * 获取BOM编号
     *
     * @return BOM编号:时间戳(年月号小时分秒毫秒)+2位随机数
     */
    public static String newBomSeq() {
        StringBuilder projectSeqNo = new StringBuilder();
        long randomNum = java.util.concurrent.ThreadLocalRandom.current().nextInt(10, 100);
        java.util.Date current = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyMMddHHmmssSSS");
        String timestamp = sdf.format(current);
        projectSeqNo.append(timestamp).append(randomNum);
        return projectSeqNo.toString();
    }


    /**
     * 获取物料编号
     *
     * @param matrialType 物料类型
     * @return 项目id:物料类型+时间戳(年月号小时分秒毫秒)+4位随机数
     */
    public static String newMaterialSeq(String matrialType) {
        StringBuilder projectSeqNo = new StringBuilder();
        long randomNum = java.util.concurrent.ThreadLocalRandom.current().nextInt(1000, 10000);
        java.util.Date current = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyMMddHHmmssSSS");
        String timestamp = sdf.format(current);
        projectSeqNo.append(matrialType).append(timestamp).append(randomNum);
        return projectSeqNo.toString();
    }

    @Test
    public void t1() {
        System.err.println("获取物料编号:" + newMaterialSeq("M"));
        for (int index = 0, len = 10; index++ < len; ) {
            System.err.println(index + "获取BOM 编号:" + newBomSeq());
        }

        System.err.println("获取项目编号:" + newRrojectSeq("0010"));
    }


}
