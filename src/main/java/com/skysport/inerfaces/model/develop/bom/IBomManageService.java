package com.skysport.inerfaces.model.develop.bom;

import com.skysport.inerfaces.form.develop.BomQueryForm;
import com.skysport.inerfaces.model.common.ICommonService;

import java.util.List;

/**
 * 类说明:
 * Created by zhangjh on 2015/7/13.
 */
public interface IBomManageService<T> extends ICommonService<T> {

    public int listFilteredInfosCounts(BomQueryForm bomQueryForm);

    public List<T> searchInfos(BomQueryForm bomQueryForm);
}
