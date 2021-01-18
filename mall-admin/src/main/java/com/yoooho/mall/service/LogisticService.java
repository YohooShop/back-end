package com.yoooho.mall.service;

import com.yoooho.mall.common.CommonResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface LogisticService {

    List logisticCompanyList();

    CommonResult subscribeLogistic( String shipperCode, String logisticCode,
                                    String senderName, String senderProvinceName,
                                    String senderCityName, String senderExpAreaName,
                                    String senderAddress, String senderTel, String senderMob,
                                    String receiverName, String receiverProvinceName,
                                    String receiverCityName, String receiverExpAreaName,
                                    String receiverAddress, String receiverTel, String receiverMob,
                                    String commodityName,  Long orderId,  String orderSn);

    public void analysisPushLogisticData(HttpServletRequest req, HttpServletResponse resp)throws Exception;

    CommonResult creatOrder(String shipperCode, String logisticCode,
                            String senderName, String senderProvinceName,
                            String senderCityName, String senderExpAreaName,
                            String senderAddress,String senderTel, String senderMob,
                            String receiverName, String receiverProvinceName,
                            String receiverCityName, String receiverExpAreaName,
                            String receiverAddress, String receiverTel, String receiverMob,
                            String commodityName, String expType, String payType, Long orderId,  String orderSn);

    public CommonResult logisticstOrder(Long id);
}
