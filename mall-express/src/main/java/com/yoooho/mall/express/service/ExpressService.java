package com.yoooho.mall.express.service;

import com.yoooho.mall.express.config.ExpressProperties;
import com.yoooho.mall.express.dao.ExpressInfo;

/**
 * 物流查询服务
 * <p>
 * 快递鸟即时查询API http://www.kdniao.com/api-track
 */
public interface ExpressService{

    void setProperties(ExpressProperties properties);
    /**
     * 获取物流供应商名
     *
     * @param vendorCode
     * @return
     */
   String getVendorName(String vendorCode);

    /**
     * 获取物流信息
     *
     * @param OrderCode
     * @param ShipperCode
     * @return
     */
   ExpressInfo getExpressInfo(String OrderCode, String ShipperCode, String LogisticCode);


}
