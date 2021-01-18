package com.yoooho.mall.express.service;

import com.yoooho.mall.express.dao.ExpressInfo;

public interface OrderExpressService {

    public void queryOrderExpress();
    public void save(ExpressInfo expressInfo);
    ExpressInfo getExpressInfo(String orderSn);
}
