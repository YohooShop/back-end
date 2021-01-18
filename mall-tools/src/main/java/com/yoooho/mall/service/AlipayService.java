package com.yoooho.mall.service;


import com.alipay.api.AlipayClient;
import com.yoooho.mall.domian.AlipayConfig;
import com.yoooho.mall.vo.TradeVo;

/**
 * @author Zheng Jie
 * @date 2019-12-31
 */
public interface AlipayService {

    /**
     * 处理来自PC的交易请求
     * @param alipay 支付宝配置
     * @param trade 交易详情
     * @return String
     * @throws Exception 异常
     */
    String toPayAsPc(AlipayConfig alipay, TradeVo trade) throws Exception;

    /**
     * 处理来自手机网页的交易请求
     * @param alipay 支付宝配置
     * @param trade 交易详情
     * @return String
     * @throws Exception 异常
     */
    String toPayAsWeb(AlipayConfig alipay, TradeVo trade) throws Exception;

    /**
     * 查询配置
     * @return AlipayConfig
     */
    AlipayConfig find();

    /**
     * 更新配置
     * @param alipayConfig 支付宝配置
     * @return AlipayConfig
     */
    AlipayConfig update(AlipayConfig alipayConfig);

    public AlipayClient getAlipayClient();
}