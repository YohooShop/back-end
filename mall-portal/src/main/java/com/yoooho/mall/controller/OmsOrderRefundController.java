package com.yoooho.mall.controller;

import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.model.UmsMember;
import com.yoooho.mall.service.OmsOrderRefundService;
import com.yoooho.mall.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@Api(tags = "OmsOrderRefundController", description = "退款")
@RequestMapping("/orderRefund")
public class OmsOrderRefundController {
    @Autowired
    OmsOrderRefundService omsOrderRefundService;
    @Autowired
    UmsMemberService memberService;
    @ApiOperation("退款信息生成确认单信息")
    @RequestMapping(value = "/apply",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult apply(@RequestParam("orderId") Long orderId, @RequestParam("reason") String reason){
        UmsMember member = memberService.getCurrentMember();
        return omsOrderRefundService.applyRefund(orderId, reason,member.getId());
    }

    @ApiOperation("退款列表")
    @RequestMapping(value = "/list",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult list(@RequestParam("pages") int pages,@RequestParam("size") int size){
        return omsOrderRefundService.applyRefundList(pages, size);
    }
}
