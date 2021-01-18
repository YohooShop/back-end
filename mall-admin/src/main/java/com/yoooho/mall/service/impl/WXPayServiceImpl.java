package com.yoooho.mall.service.impl;

import com.yoooho.mall.mapper.OmsOrderRefundMapper;
import com.yoooho.mall.model.OmsOrder;
import com.yoooho.mall.model.OmsOrderRefund;
import com.yoooho.mall.model.OmsOrderRefundExample;
import com.yoooho.mall.service.WXPayService;
import com.yoooho.mall.service.WeChatPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class WXPayServiceImpl implements WXPayService {
    @Autowired
    WeChatPayService weChatPayService;

    @Autowired
    OmsOrderRefundMapper orderRefundMapper;
    @Override
    public boolean refundOrder(OmsOrder order, Long refundId) throws Exception{
        String out_refund_no = String.valueOf(new Date().getTime()) + String.valueOf(refundId);
        weChatPayService.refundOrder(out_refund_no,  (int) (order.getPayAmount().floatValue() * 100),order.getOuttradeno());
        //插入商户退款单号
        OmsOrderRefund omsOrderRefund = new OmsOrderRefund();
        omsOrderRefund.setId(refundId);
        omsOrderRefund.setOutRefundNo(out_refund_no);
        orderRefundMapper.updateByPrimaryKeySelective(omsOrderRefund);
        return true;
    }

    @Override
    public boolean refundBack(String out_refund_no){
        OmsOrderRefundExample example = new OmsOrderRefundExample();
        example.createCriteria().andOutRefundNoEqualTo(out_refund_no);
        OmsOrderRefund omsOrderRefund = new OmsOrderRefund();
        omsOrderRefund.setStatus(2);
        orderRefundMapper.updateByExampleSelective(omsOrderRefund,example);

        return true;
    }
}
