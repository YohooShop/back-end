package com.yoooho.mall.service.Impl;



import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.yoooho.mall.common.exception.BadRequestException;
import com.yoooho.mall.domian.AlipayConfig;
import com.yoooho.mall.repository.AlipayRepository;
import com.yoooho.mall.service.AlipayService;
import com.yoooho.mall.vo.TradeVo;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@Service
@CacheConfig(cacheNames = "alipay")
@SuppressWarnings("all")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class AlipayServiceImpl implements AlipayService {

    private final AlipayRepository alipayRepository;

    public AlipayServiceImpl(AlipayRepository alipayRepository) {
        this.alipayRepository = alipayRepository;
    }

    @Override
    public String toPayAsPc(AlipayConfig alipay, TradeVo trade) throws Exception {

        if(alipay.getId() == null){
            throw new BadRequestException("请先添加相应配置，再操作");
        }
        AlipayClient alipayClient = getAlipayClient();

        // 创建API对应的request(电脑网页版)
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();

        // 订单完成后返回的页面和异步通知地址
        request.setReturnUrl(alipay.getReturnUrl() + '?' + "orderSn=" + trade.getOutTradeNo());
        request.setNotifyUrl(alipay.getNotifyUrl());

        Map<String, Object> parMap = new HashMap<String, Object>();
        parMap.put("out_trade_no",trade.getOutTradeNo());
        parMap.put("subject",trade.getSubject());
        parMap.put("total_amount",trade.getTotalAmount());
        parMap.put("product_code","FAST_INSTANT_TRADE_PAY");
        parMap.put("body",trade.getBody());
        request.setBizContent(JSON.toJSONString(parMap));
        // 填充订单参数
//        request.setBizContent("{" +
//                "    \"out_trade_no\":\""+trade.getOutTradeNo()+"\"," +
//                "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," +
//                "    \"total_amount\":"+trade.getTotalAmount()+"," +
//                "    \"subject\":\""+trade.getSubject()+"\"," +
//                "    \"body\":\""+trade.getBody()+"\"," +
//                "    \"extend_params\":{" +
//                "    \"sys_service_provider_id\":\""+alipay.getSysServiceProviderId()+"\"" +
//                "    }"+
//                "  }");//填充业务参数
//        // 调用SDK生成表单, 通过GET方式，口可以获取url
        return alipayClient.pageExecute(request, "GET").getBody();

    }

    @Override
    public String toPayAsWeb(AlipayConfig alipay, TradeVo trade) throws Exception {
        if(alipay.getId() == null){
            throw new BadRequestException("请先添加相应配置，再操作");
        }
        AlipayClient alipayClient = getAlipayClient();

        double money = Double.parseDouble(trade.getTotalAmount());
        double maxMoney = 5000;
        if(money <= 0 || money >= maxMoney){
            throw new BadRequestException("测试金额过大");
        }
        // 创建API对应的request(手机网页版)
        AlipayTradeWapPayRequest request = new AlipayTradeWapPayRequest();
        request.setReturnUrl(alipay.getReturnUrl());
        request.setNotifyUrl(alipay.getNotifyUrl());
        Map<String, Object> parMap = new HashMap<String, Object>();
        parMap.put("out_trade_no",trade.getOutTradeNo());
        parMap.put("subject",trade.getSubject());
        parMap.put("total_amount",trade.getTotalAmount());
//        parMap.put("total_amount","0.01");
        parMap.put("product_code","QUICK_WAP_WAY");
        parMap.put("body",trade.getBody());
        request.setBizContent(JSON.toJSONString(parMap));

//        request.setBizContent("{" +
//                "    \"out_trade_no\":\""++"\"," +
//                "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," +
//                "    \"total_amount\":"++"," +
//                "    \"subject\":\""+"\"," +
//                "    \"body\":\""++"\"," +
//                "  }");
        return alipayClient.pageExecute(request,"GET").getBody();
    }

    @Override
    @Cacheable(key = "'1'")
    public AlipayConfig find() {
        Optional<AlipayConfig> alipayConfig = alipayRepository.findById(1L);
        return alipayConfig.orElseGet(AlipayConfig::new);
    }

    @Override
    @CachePut(key = "'1'")
    @Transactional(rollbackFor = Exception.class)
    public AlipayConfig update(AlipayConfig alipayConfig) {
        return alipayRepository.save(alipayConfig);
    }

    @Override
    public AlipayClient getAlipayClient(){
        AlipayConfig alipayConfig = find();
        AlipayClient alipayClient;
        alipayClient = new DefaultAlipayClient(alipayConfig.getGatewayUrl(),
                alipayConfig.getAppId(), alipayConfig.getPrivateKey(),
                alipayConfig.getFormat(), alipayConfig.getCharset(), alipayConfig.getPublicKey(),
                alipayConfig.getSignType());
        return alipayClient;
    }

}
