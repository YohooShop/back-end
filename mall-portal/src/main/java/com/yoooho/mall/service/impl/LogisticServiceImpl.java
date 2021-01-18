package com.yoooho.mall.service.impl;

import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.express.dao.ExpressInfo;
import com.yoooho.mall.express.service.OrderExpressService;
import com.yoooho.mall.mapper.KdnExpressCompanyMapper;
import com.yoooho.mall.mapper.OmsOrderMapper;
import com.yoooho.mall.model.KdnExpressCompany;
import com.yoooho.mall.model.KdnExpressCompanyExample;
import com.yoooho.mall.model.OmsOrder;
import com.yoooho.mall.service.LogisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LogisticServiceImpl implements LogisticService {

    @Autowired
    OmsOrderMapper orderMapper;
    @Autowired
    OrderExpressService orderExpressService;
    @Autowired
    KdnExpressCompanyMapper kdnExpressCompanyMapper;
    @Override
    public CommonResult logisticstOrder(Long id) {

        OmsOrder order = orderMapper.selectByPrimaryKey(id);

        //物流状态
        ExpressInfo expressInfo = orderExpressService.getExpressInfo(order.getOrderSn());
        KdnExpressCompanyExample kdnExpressCompanyExample = new KdnExpressCompanyExample();
        kdnExpressCompanyExample.createCriteria().andCompanyCodeEqualTo(order.getDeliveryCode());
        List<KdnExpressCompany> kdnExpressCompanies = kdnExpressCompanyMapper.selectByExample(kdnExpressCompanyExample);
        String logo = "";
        String tel ="";
        if (kdnExpressCompanies.size() >0) {
           logo = kdnExpressCompanies.get(0).getIcon();
           tel = kdnExpressCompanies.get(0).getTel();
        }
        Map map =  new HashMap();;
        map.put("postNo",order.getDeliverySn());
        map.put("expressInfo",expressInfo);
        map.put("expPhone",tel);
        map.put("logo",logo);
        map.put("postName",order.getDeliveryCompany());
        map.put("addr",order.getReceiverProvince() + order.getReceiverCity() + order.getReceiverRegion() + order.getReceiverDetailAddress());
        return CommonResult.success(map);
    }
}
