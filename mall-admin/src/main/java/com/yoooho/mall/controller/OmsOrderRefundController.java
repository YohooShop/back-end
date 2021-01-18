package com.yoooho.mall.controller;

import com.yoooho.mall.common.CommonPage;
import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.dto.OmsRefundQueryParam;
import com.yoooho.mall.model.OmsOrderRefund;

import com.yoooho.mall.service.OmsOrderRefundService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Api(tags = "OmsOrderRefundController", description = "退款管理")
@RequestMapping("/orderRefund")
public class OmsOrderRefundController {
    @Autowired
    private OmsOrderRefundService refundService;

    @ApiOperation("分页查询退款申请")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<OmsOrderRefund>> list(OmsRefundQueryParam queryParam,
                                                         @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                         @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<OmsOrderRefund> refundList = refundService.list(queryParam, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(refundList));
    }

    @ApiOperation("退款申请详情")
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult  detail(@PathVariable Long id) {
        return refundService.detail(id);
    }


    @ApiOperation("修改退款申请状态")
    @RequestMapping(value = "/update/status/{id}", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('oms:orderRefund:update')")
    @ResponseBody
    public CommonResult updateStatus(@PathVariable Long id, @RequestParam("status") int status) {
        int count = refundService.updateStatus(id, status);
        if (count > 0){
            return CommonResult.success("");
        }else {
            return CommonResult.failed();
        }
    }



}
