package com.yoooho.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.mapper.OmsOrderMapper;
import com.yoooho.mall.mapper.OmsOrderRefundMapper;
import com.yoooho.mall.mapper.UmsAdminSettingMapper;
import com.yoooho.mall.model.*;
import com.yoooho.mall.dao.OmsRefundDao;
import com.yoooho.mall.service.UmsMemberService;
import com.yoooho.mall.util.TemplatesUtil;
import com.yoooho.mall.service.OmsOrderRefundService;
import com.yoooho.mall.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OmsOrderRefundServiceImpl implements OmsOrderRefundService {

    @Autowired
    OmsOrderMapper omsOrderMapper;
    @Autowired
    OmsOrderRefundMapper omsOrderRefundMapper;
    @Autowired
    OmsRefundDao refundDao;
    @Autowired
    UmsMemberService memberService;

    @Autowired
    private UmsAdminSettingMapper umsAdminSettingMapper;
    @Override
    public CommonResult applyRefund(Long orderId, String reason, Long userId) {
       OmsOrder omsOrder = omsOrderMapper.selectByPrimaryKey(orderId);
      UmsMember member = memberService.getById(userId);
       if (omsOrder == null){
           return CommonResult.failed("订单不存在");
       }else {
           OmsOrderRefundExample omsOrderRefundExample = new OmsOrderRefundExample();
           List list = new ArrayList();
           list.add(0);
           list.add(1);
           list.add(2);
           omsOrderRefundExample.createCriteria().andOrderIdEqualTo(orderId).andStatusIn(list);
           List<OmsOrderRefund> orderRefunds = omsOrderRefundMapper.selectByExample(omsOrderRefundExample);
           if (orderRefunds.size() == 0){
               OmsOrderRefund orderRefund = new OmsOrderRefund();
               orderRefund.setCreateTime(new Date());
               orderRefund.setOrderId(orderId);
               orderRefund.setStatus(0);
               orderRefund.setMemberId(member.getId());
               orderRefund.setMemberUsername(member.getNickname());
               orderRefund.setReason(reason);
               orderRefund.setOrderSn(omsOrder.getOrderSn());
               orderRefund.setReturnAmount(omsOrder.getPayAmount());
               omsOrderRefundMapper.insert(orderRefund);

               //发送邮件通知下单成功

               UmsAdminSettingExample example = new UmsAdminSettingExample();
               List<UmsAdminSetting> adminSettings = umsAdminSettingMapper.selectByExample(example);
               if (adminSettings.size() > 0 && adminSettings.get(0).getNotificationFormMail().length() > 0 &&
                       adminSettings.get(0).getNotificationToMail().length() > 0) {
                   TemplatesUtil templatesUtil = new TemplatesUtil();
                   Map dataMap = new HashMap();
                   dataMap.put("title", "退款申请邮件");
                   dataMap.put("category", "用户发起退款申请");
                   dataMap.put("order_sn", omsOrder.getOrderSn());
                   dataMap.put("username", memberService.getCurrentMember().getNickname());
                   TemplatesUtil.sendSimpleOrderEmail(dataMap,adminSettings.get(0).getNotificationFormMail(),adminSettings.get(0).getNotificationToMail());
               }

               return CommonResult.success("申请退款成功");
           }else {

               return CommonResult.failed("申请退款已存在，不能重复");
           }
       }
    }

    @Override
    public CommonResult applyRefundList(int pages, int size) {
        PageHelper.startPage(pages,size);
        UmsMember member = memberService.getCurrentMember();
        return CommonResult.success( refundDao.getList(member.getId()));
    }
}
