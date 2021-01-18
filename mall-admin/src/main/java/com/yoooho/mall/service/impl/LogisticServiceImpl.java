package com.yoooho.mall.service.impl;

import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.express.dao.ExpressInfo;
import com.yoooho.mall.express.service.OrderExpressService;
import com.yoooho.mall.mapper.KdnExpressCompanyMapper;
import com.yoooho.mall.mapper.OmsLogisticOrderMapper;
import com.yoooho.mall.mapper.OmsOrderMapper;
import com.yoooho.mall.model.KdnExpressCompany;
import com.yoooho.mall.model.KdnExpressCompanyExample;
import com.yoooho.mall.model.OmsOrder;
import com.yoooho.mall.service.LogisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Service
public class LogisticServiceImpl implements LogisticService {
    @Autowired
    KdnExpressCompanyMapper kdnExpressCompanyMapper;

    @Autowired
    OmsLogisticOrderMapper logisticOrderMapper;

    @Autowired
    OmsOrderMapper orderMapper;
    @Autowired
    OrderExpressService orderExpressService;

    // 电商ID
    private String EBusinessID = "test1610260";

    @Override
    public List logisticCompanyList() {
        KdnExpressCompanyExample expressCompanyExample = new KdnExpressCompanyExample();
       List list = kdnExpressCompanyMapper.selectByExample(expressCompanyExample);
        return list;
    }

    @Override
    public CommonResult subscribeLogistic(String shipperCode, String logisticCode,
                                          String senderName, String senderProvinceName, String senderCityName, String senderExpAreaName, String senderAddress, String senderTel, String senderMob,
                                          String receiverName, String receiverProvinceName, String receiverCityName, String receiverExpAreaName, String receiverAddress,String receiverTel, String receiverMob,
                                          String commodityName, Long orderId,  String orderSn) {

//        LogisticRequestData logisticRequestData = new LogisticRequestData();
//        logisticRequestData.setLogisticCode(logisticCode);
//        logisticRequestData.setShipperCode(shipperCode);
//        logisticRequestData.setOrderCode(orderSn);
//
//        LogisticSender logisticSender = new LogisticSender();
//        logisticSender.setAddress(senderAddress);
//        logisticSender.setName(senderName);
//        logisticSender.setExpAreaName(senderExpAreaName);
//        logisticSender.setProvinceName(senderProvinceName);
//        logisticSender.setCityName(senderCityName);
//        logisticRequestData.setSender(logisticSender);
//
//        LogisticReceiver logisticReceiver = new LogisticReceiver();
//        logisticReceiver.setName(receiverName);
//        logisticReceiver.setAddress(receiverAddress);
//        logisticReceiver.setCityName(receiverCityName);
//        logisticReceiver.setExpAreaName(receiverExpAreaName);
//        logisticReceiver.setProvinceName(receiverProvinceName);
//        logisticReceiver.setCityName(receiverCityName);
//        logisticRequestData.setReceiver(logisticReceiver);
//
//        LogisticCommodity commodity = new LogisticCommodity();
//        commodity.setGoodsName(commodityName);
//        logisticRequestData.setCommodity(commodity);
//
//        KdniaoSubscribeAPI kdniaoSubscribeAPI = new KdniaoSubscribeAPI();
//        String res = "";
//        try {
//           res = kdniaoSubscribeAPI.orderTracesSubByJson(logisticRequestData);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return CommonResult.success(res);
        return null;
    }

    @Override
    public void analysisPushLogisticData(HttpServletRequest req, HttpServletResponse resp) throws Exception {
//        KdniaoSubscribeAPI kdniaoSubscribeAPI = new KdniaoSubscribeAPI();
//        Object o = kdniaoSubscribeAPI.analysisPushLogisticData(req, resp);
    }

    @Override
    public CommonResult creatOrder(String shipperCode, String logisticCode,
                                   String senderName, String senderProvinceName, String senderCityName, String senderExpAreaName, String senderAddress, String senderTel, String senderMob,
                                   String receiverName, String receiverProvinceName, String receiverCityName, String receiverExpAreaName, String receiverAddress,String receiverTel, String receiverMob,
                                   String commodityName, String expType, String payType, Long orderId, String orderSn) {

//        LogisticOrderData logisticRequestData = new LogisticOrderData();
//        logisticRequestData.setLogisticCode(logisticCode);
//        logisticRequestData.setShipperCode(shipperCode);
//        logisticRequestData.setOrderCode(orderSn);
//        logisticRequestData.setPayType(payType);
//        logisticRequestData.setExpType(expType);
//
//        LogisticSender logisticSender = new LogisticSender();
//        logisticSender.setAddress(senderAddress);
//        logisticSender.setName(senderName);
//        logisticSender.setCityName(senderCityName);
//        logisticSender.setExpAreaName(senderExpAreaName);
//        logisticSender.setProvinceName(senderProvinceName);
//        logisticSender.setTel(senderTel);
//        logisticSender.setMobile(senderMob);
//        logisticRequestData.setSender(logisticSender);
//
//        LogisticReceiver logisticReceiver = new LogisticReceiver();
//        logisticReceiver.setName(receiverName);
//        logisticReceiver.setAddress(receiverAddress);
//        logisticReceiver.setCityName(receiverCityName);
//        logisticReceiver.setExpAreaName(receiverExpAreaName);
//        logisticReceiver.setProvinceName(receiverProvinceName);
//        logisticReceiver.setTel(receiverTel);
//        logisticReceiver.setMobile(receiverMob);
//        logisticRequestData.setReceiver(logisticReceiver);
//
//        LogisticCommodity  commodity = new LogisticCommodity();
//        commodity.setGoodsName(commodityName);
//        logisticRequestData.setCommodity(commodity);
//
//        KdniaoSubscribeAPI kdniaoSubscribeAPI = new KdniaoSubscribeAPI();
//        String res = "";
//        try {
//            res = kdniaoSubscribeAPI.orderOnlineByJson(logisticRequestData);
//            Map map = new Gson().fromJson(res, HashMap.class);
//            if ( Boolean.parseBoolean(map.get("Success").toString())) {
//                Map orderMap = (Map) map.get("Order");
//                logisticCode = (String) orderMap.get("LogisticCode");
//                OmsLogisticOrder logisticOrder = new OmsLogisticOrder();
//                logisticOrder.setCommodityName(commodityName);
//                logisticOrder.setCreatime(new Date());
//                logisticOrder.setExpType(expType);
//                logisticOrder.setPayType(payType);
//                logisticOrder.setLogisticCode(logisticCode);
//                logisticOrder.setShipperCode(shipperCode);
//
//                logisticOrder.setReceiverName(receiverName);
//                logisticOrder.setReceiverAddress(receiverAddress);
//                logisticOrder.setReceiverCity(receiverCityName);
//                logisticOrder.setReceiverExparea(receiverExpAreaName);
//                logisticOrder.setReceiverProvince(receiverProvinceName);
//                logisticOrder.setReceiverName(receiverName);
//                logisticOrder.setReceiverCity(receiverCityName);
//                logisticOrder.setReceiverTel(receiverTel);
//                logisticOrder.setReceiverMobile(receiverMob);
//
//                logisticOrder.setSenderAddress(senderAddress);
//                logisticOrder.setSenderCity(senderCityName);
//                logisticOrder.setSenderName(senderName);
//                logisticOrder.setSenderExparea(senderExpAreaName);
//                logisticOrder.setSenderProvince(senderProvinceName);
//                logisticOrder.setSenderTel(senderTel);
//                logisticOrder.setSenderMobile(senderMob);
//                logisticOrder.setOrderId(orderId);
//                logisticOrder.setOrderSn(orderSn);
//
//
//                logisticOrder.setKdnOrderCode((String) orderMap.get("KDNOrderCode"));
//                logisticOrder.setPrintTemplate((String) map.get("PrintTemplate"));
//                logisticOrder.setPackageName((String) map.get("PackageName"));
//                logisticOrderMapper.insertSelective(logisticOrder);
//
//                //加入物流跟踪
//                subscribeLogistic(shipperCode, logisticCode, senderName, senderProvinceName, senderCityName, senderExpAreaName, senderAddress, senderTel, senderMob, receiverName, receiverProvinceName, receiverCityName, receiverExpAreaName, receiverAddress, receiverTel, receiverMob, commodityName, orderId, orderSn);
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return CommonResult.success(res);

        return null;
    }

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
