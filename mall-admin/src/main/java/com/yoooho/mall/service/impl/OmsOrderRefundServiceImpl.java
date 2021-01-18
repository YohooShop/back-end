package com.yoooho.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.dto.OmsRefundQueryParam;
import com.yoooho.mall.dao.OmsRefundDao;
import com.yoooho.mall.mapper.OmsOrderMapper;
import com.yoooho.mall.mapper.OmsOrderRefundMapper;
import com.yoooho.mall.mapper.UmsMemberWxofficeMapper;
import com.yoooho.mall.model.*;
import com.yoooho.mall.model.OmsOrder;
import com.yoooho.mall.service.AliPayOrderSerivce;
import com.yoooho.mall.service.Impl.TemplateService;
import com.yoooho.mall.service.OmsOrderRefundService;
import com.yoooho.mall.service.OmsOrderService;
import com.yoooho.mall.service.WXPayService;
import com.yoooho.mall.model.OmsOrderRefund;
import com.yoooho.mall.model.UmsMemberWxoffice;
import com.yoooho.mall.model.UmsMemberWxofficeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OmsOrderRefundServiceImpl implements OmsOrderRefundService {
    @Autowired
    OmsRefundDao refundDao;
    @Autowired
    OmsOrderRefundMapper omsOrderRefundMapper;
    @Autowired
    OmsOrderMapper omsOrderMapper;
    @Autowired
    OmsOrderService omsOrderService;
    @Autowired
    AliPayOrderSerivce aliPayOrderSerivce;
    @Autowired
    WXPayService payService;

    @Autowired
    UmsMemberWxofficeMapper memberWxofficeMapper;
    @Autowired
    TemplateService templateService;
    @Override
    public List<OmsOrderRefund> list(OmsRefundQueryParam queryParam, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        return refundDao.getList(queryParam);
    }

    @Override
    public CommonResult detail(Long id) {
        return CommonResult.success(refundDao.getDetail(id).get(0));
    }

    @Override
    public int updateStatus(Long id, int status) {
       OmsOrderRefund omsOrderRefund = omsOrderRefundMapper.selectByPrimaryKey(id);
        if (status == 1){
           OmsOrder omsOrder = omsOrderMapper.selectByPrimaryKey(omsOrderRefund.getOrderId());
           if (omsOrder.getPayType() == 1) {
               String result = aliPayOrderSerivce.refundOrder(omsOrder,id);
               if (!result.equals("SUCCESS")){
                   return 0;
               }else {
                   List ids = new ArrayList();
                   ids.add(omsOrder.getId());
                   omsOrderService.close(ids,"退款");
                   omsOrderRefund.setStatus(2);
                   omsOrderRefund.setHandleTime(new Date());
               }
           }
           if (omsOrder.getPayType() == 2) {
               try {
                   payService.refundOrder(omsOrder,id);
               } catch (Exception e) {
                   e.printStackTrace();
                   return 0;
               }
               omsOrderRefund.setStatus(1);
           }
            //微信通知客户
            UmsMemberWxofficeExample memberWxofficeExample = new UmsMemberWxofficeExample();
            memberWxofficeExample.createCriteria().andUserIdEqualTo(omsOrderRefund.getMemberId());
            List<UmsMemberWxoffice> memberWxoffices = memberWxofficeMapper.selectByExample(memberWxofficeExample);
            if (memberWxoffices.size() != 0) {
                UmsMemberWxoffice memberWxoffice = memberWxoffices.get(0);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//注意月份是MM
                String date = simpleDateFormat.format(new Date());
                templateService.refundSuccessNotice(String.valueOf(omsOrderRefund.getId()),omsOrderRefund.getOrderSn(),omsOrder.getPayAmount().toString(),memberWxoffice.getOpenId(),date);
            }
        }else {
            omsOrderRefund.setStatus(3);
        }
        return omsOrderRefundMapper.updateByPrimaryKeySelective(omsOrderRefund);
    }
}
