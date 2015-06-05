package com.skysport.inerfaces.model.system.customer.service.impl;

import com.skysport.core.bean.DataTablesInfo;
import com.skysport.inerfaces.bean.CutomerInfo;
import com.skysport.inerfaces.dao.CustomerManageDao;
import com.skysport.inerfaces.model.system.customer.service.ICustomerManageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * Created by zhangjh on 2015/6/3.
 */
@Service("customerManageService")
public class CustomerManageServiceImpl implements ICustomerManageService {
    @Resource(name = "customerManageDao")
    private CustomerManageDao customerManageDao;
    @Override
    public int listCutomerInfosCounts() {
        return customerManageDao.listCutomerInfosCounts();
    }

    @Override
    public int listFilteredCutomerInfosCounts(DataTablesInfo dataTablesInfo) {
        return customerManageDao.listFilteredCutomerInfosCounts(dataTablesInfo);
    }

    @Override
    public List<CutomerInfo> searchCutomer(DataTablesInfo dataTablesInfo) {
        return customerManageDao.searchCutomer(dataTablesInfo);
    }

    @Override
    public void edit(CutomerInfo cutomerInfo) {
        customerManageDao.edit(cutomerInfo);
    }

    @Override
    public void add(CutomerInfo cutomerInfo) {
        customerManageDao.add(cutomerInfo);
    }

    @Override
    public CutomerInfo queryCutomerByCutomerId(String cutomerId) {
        return customerManageDao.queryCutomerByCutomerId(cutomerId);
    }

    @Override
    public void del(String cutomerId) {
        customerManageDao.del(cutomerId);
    }
}
