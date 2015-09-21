package com.skysport.inerfaces.model.develop.quoted.service.impl;

import com.skysport.core.instance.DictionaryInfo;
import com.skysport.core.utils.UpDownUtils;
import com.skysport.inerfaces.bean.develop.QuotedInfo;
import com.skysport.inerfaces.constant.ApplicationConstant;
import com.skysport.inerfaces.mapper.QuotedInfoMapper;
import com.skysport.inerfaces.model.common.impl.CommonServiceImpl;
import com.skysport.inerfaces.model.develop.quoted.helper.QuotedServiceHelper;
import com.skysport.inerfaces.model.develop.quoted.service.IQuotedService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * 说明:
 * Created by zhangjh on 2015/9/17.
 */
@Service("quotedService")
public class QuotedServiceImpl extends CommonServiceImpl<QuotedInfo> implements IQuotedService, InitializingBean {

    @Resource(name = "quotedInfoMapper")
    private QuotedInfoMapper quotedInfoMapper;

    @Override
    public void afterPropertiesSet() throws Exception {
        commonDao = quotedInfoMapper;
    }


    @Override
    public void updateOrAdd(QuotedInfo quotedInfo) {
        //查询BOM是否有对应的报价表
        QuotedInfo quotedInfo1 = queryInfoByNatrualKey(quotedInfo.getBomId());
        if (null == quotedInfo1) {
            //查询项目和子项目id
            QuotedInfo quotedInfo2 = quotedInfoMapper.queryIds(quotedInfo.getBomId());
            quotedInfo.setProjectId(quotedInfo2.getProjectId());
            quotedInfo.setProjectItemId(quotedInfo2.getProjectItemId());
            quotedInfoMapper.add(quotedInfo);
        } else {
            quotedInfoMapper.updateInfo(quotedInfo);
        }
    }

    /**
     * 下载文件
     *
     * @param request
     * @param response
     * @param natrualkeys
     * @throws IOException
     */
    @Override
    public void download(HttpServletRequest request, HttpServletResponse response, String natrualkeys) throws IOException {
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        List<String> itemIds = Arrays.asList(natrualkeys.split(","));
        List<QuotedInfo> quotedInfos = quotedInfoMapper.queryListByProjectItemIds(itemIds);

        String ctxPath = new StringBuilder().append(DictionaryInfo.SINGLETONE.getDictionaryValue(ApplicationConstant.FILE_PATH, ApplicationConstant.BASE_PATH)).append(ApplicationConstant.FILE_SEPRITER).append(year).append(ApplicationConstant.FILE_SEPRITER)
                .append(DictionaryInfo.SINGLETONE.getDictionaryValue(ApplicationConstant.FILE_PATH, ApplicationConstant.DEVELOP_PATH)).toString();

        String fileName = itemIds.get(0) + "-报价表.xls";
        //完整文件路径
        String downLoadPath = ctxPath + File.separator + fileName;

        QuotedServiceHelper.createFile(fileName, ctxPath, ApplicationConstant.BOM_QUOTED_TITILE, quotedInfos);


        UpDownUtils.download(request, response, fileName, downLoadPath);


    }
}
