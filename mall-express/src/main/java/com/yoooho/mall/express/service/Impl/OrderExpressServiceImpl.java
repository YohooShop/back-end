package com.yoooho.mall.express.service.Impl;

import com.yoooho.mall.express.dao.ExpressInfo;
import com.yoooho.mall.express.repository.OrderExpressInfoRepository;
import com.yoooho.mall.express.service.ExpressService;
import com.yoooho.mall.express.service.OrderExpressService;
import com.yoooho.mall.mapper.OmsOrderMapper;
import com.yoooho.mall.model.OmsOrder;
import com.yoooho.mall.model.OmsOrderExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderExpressServiceImpl implements OrderExpressService {

    @Autowired
    OmsOrderMapper omsOrderMapper;
    @Autowired
    ExpressService expressService;

    @Autowired
    OrderExpressInfoRepository orderExpressInfoRepository;

    @Override
    public void queryOrderExpress() {
        OmsOrderExample orderExample = new OmsOrderExample();
        orderExample.createCriteria().andStatusEqualTo(2).andDeleteStatusEqualTo(0).andShoppingTypeEqualTo(1);
        List<OmsOrder> orders = omsOrderMapper.selectByExample(orderExample);
        for (OmsOrder order:
             orders) {
            ExpressInfo expressInfo = expressService.getExpressInfo(order.getOrderSn(),order.getDeliveryCode(),order.getDeliverySn());
            if (expressInfo.isSuccess()){
                //保存到MongoDB
                save(expressInfo);
            }
        }
    }

    public void save(ExpressInfo expressInfo) {
        if(getExpressInfo(expressInfo.getOrderCode()) != null) {
            orderExpressInfoRepository.deleteByOrderCode(expressInfo.getOrderCode());
        }
        orderExpressInfoRepository.insert(expressInfo);
    }

     public ExpressInfo getExpressInfo(String orderSn) {
       List<ExpressInfo> expressInfos = orderExpressInfoRepository.findByOrderCode(orderSn);
       if (expressInfos.size() == 0){
           return null;
       }
       return expressInfos.get(0);
    }

}
