package com.yoooho.mall.service;

import com.yoooho.mall.common.CommonResult;

import com.yoooho.mall.domain.ConfirmOrderResult;
import com.yoooho.mall.domain.KillOrderParam;
import com.yoooho.mall.domain.OrderParam;
import com.yoooho.mall.domain.PinkOrderParam;

import com.yoooho.mall.model.OmsOrder;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 前台订单管理Service
 * Created by yoooho on 2019/8/30.
 */
public interface OmsPortalOrderService {


    Object getFaceOrder(Long orderId);
    Object generateFaceOrder(Long orderId);
    /**
     * 根据用户购物车信息生成确认单信息
     */
    ConfirmOrderResult generateConfirmOrder(List<Long> ids, Integer orderType, Long orderId);

    /**
     * 根据提交信息生成普通订单
     */
    @Transactional
    CommonResult generateOrder(List<Long> ids);

    Object updateOrderInfo(OrderParam orderParam);

    Object getOrderInfo(Long orderId);
    /**
     * 根据提交信息生成，秒杀订单
     */
    @Transactional
    CommonResult generateKillOrder(KillOrderParam orderParam);

    /**
     * 根据提交信息生成，团购订单
     */
    CommonResult generatePinkOrder(PinkOrderParam orderParam);

    /**
     * 支付成功后的回调
     */
    @Transactional
    CommonResult paySuccess( String outTradeNo, String tradeNo);

    /**
     * 自动取消超时订单
     */
    @Transactional
    CommonResult cancelTimeOutOrder();

    /**
     * 取消单个超时订单
     */
    @Transactional
    void cancelOrder(Long orderId);

    /**
     * 发送延迟消息取消订单
     */
    void sendDelayMessageCancelOrder(Long orderId);

    void sendDelayMessageCancelOrder(OmsOrder order);
    /**
     * 获取订单详情
     * */
    CommonResult getOrderDetail(Long id);

    /**
     * 获取订单详情
     * */
    CommonResult getOrderDetailBySn(String orderSn);

    /***
     * 删除订单
     * */

    CommonResult delOrder(Long id);

    /**
     * 确认收货
     */
    CommonResult confirmReceiptOrder(Long id);



    /**
     *
     * app获取支付订单
     */
    CommonResult pay (Long orderId, int payType);

    /**
     * h5
     * */

    Object payWeb(Long orderId, int payType);


    /**
     * 小程序
     * */


    Object  payOrderSP(Long orderId, String openId);

    Object payOrderJS(Long orderId, String openId);


    /**
     * 更新支付后的订单(1 -- 支付宝， 2---微信)
     * */
    boolean updateOrderByPaySuccess(String outTradeNo,String trade_no, int payType, int paySource);


    /***
     * 获取订单
     * */

    CommonResult getOrders(int orderType, int pages, int size);


   OmsOrder getKillOrderByUserIdGoodsId(Long userId, Long goodsId);

    OmsOrder getPinkOrderByUserIdGoodsId(Long userId, Long goodsId);
   /**
    * 支付订单信息
    * */
   OmsOrder payOrderInfo(Long id);
}
