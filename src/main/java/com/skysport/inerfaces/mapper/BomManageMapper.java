package com.skysport.inerfaces.mapper;

import com.skysport.inerfaces.bean.BomInfo;
import com.skysport.inerfaces.form.develop.BomQueryForm;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 类说明:
 * Created by zhangjh on 2015/7/13.
 */
@Component("bomManageMapper")
public interface BomManageMapper extends CommonDao<BomInfo> {

    public int listFilteredInfosCounts(BomQueryForm bomQueryForm);

    public List<BomInfo> searchInfos(BomQueryForm bomQueryForm);

}
