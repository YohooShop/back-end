package com.yoooho.mall.controller;

import com.yoooho.mall.common.CommonPage;
import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.dto.*;
import com.yoooho.mall.dto.*;
import com.yoooho.mall.model.OmsOrder;
import com.yoooho.mall.service.OmsOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 订单管理Controller
 * Created by yoooho on 2019/10/11.
 */
@Controller
@Api(tags = "OmsOrderController", description = "订单管理")
@RequestMapping("/order")
public class OmsOrderController {
    @Autowired
    private OmsOrderService orderService;

    @ApiOperation("查询订单")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<OmsOrder>> list(OmsOrderQueryParam queryParam,
                                                   @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                   @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<OmsOrder> orderList = orderService.list(queryParam, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(orderList));
    }

    @ApiOperation("批量发货")
    @RequestMapping(value = "/update/delivery", method = RequestMethod.POST)
    @ResponseBody
    @PreAuthorize("hasAuthority('oms:order:update')")
    public CommonResult delivery(@RequestBody List<OmsOrderDeliveryParam> deliveryParamList) {
        int count = orderService.delivery(deliveryParamList);

        //添加自动收货

        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("单个发货")
    @RequestMapping(value = "/update/one_delivery", method = RequestMethod.POST)
    @ResponseBody
    @PreAuthorize("hasAuthority('oms:order:update')")
    public CommonResult delivery(@RequestBody OmsOrderDeliveryParam deliveryParam) {
        List<OmsOrderDeliveryParam> deliveryParamList = new ArrayList<>();
        deliveryParamList.add(deliveryParam);
        int count = orderService.delivery(deliveryParamList);
        //添加自动收货
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("批量关闭订单")
    @RequestMapping(value = "/update/close", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('oms:order:update')")
    @ResponseBody
    public CommonResult close(@RequestParam("ids") List<Long> ids, @RequestParam String note) {
        int count = orderService.close(ids, note);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("单个关闭订单")
    @RequestMapping(value = "/update/one_close", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('oms:order:update')")
    @ResponseBody
    public CommonResult one_close(@RequestParam("id") Long id, @RequestParam String note) {
        List<Long> ids = new ArrayList<>();
        ids.add(id);
        int count = orderService.close(ids, note);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }


    @ApiOperation("批量删除订单")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('oms:order:del')")
    @ResponseBody
    public CommonResult delete(@RequestParam("ids") List<Long> ids) {
        int count = orderService.delete(ids);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("单个删除订单")
    @RequestMapping(value = "/one_delete", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('oms:order:del')")
    @ResponseBody
    public CommonResult oneDelete(@RequestParam Long id) {
        List<Long> ids = new ArrayList<>();
        ids.add(id);
        int count = orderService.delete(ids);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }


    @ApiOperation("获取订单详情:订单信息、商品信息、操作记录")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<OmsOrderDetail> detail(@PathVariable Long id) {
        OmsOrderDetail orderDetailResult = orderService.detail(id);
        return CommonResult.success(orderDetailResult);
    }

    @ApiOperation("修改收货人信息")
    @RequestMapping(value = "/update/receiverInfo", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('oms:order:update')")
    @ResponseBody
    public CommonResult updateReceiverInfo(@RequestBody OmsReceiverInfoParam receiverInfoParam) {
        int count = orderService.updateReceiverInfo(receiverInfoParam);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取订单详情:订单信息、商品信息、操作记录")
    @RequestMapping(value = "/orderSn/{orderSn}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<OmsOrderDetail> detailByOrderSn(@PathVariable String orderSn) {
        OmsOrderDetail orderDetailResult = orderService.detailByOrderSn(orderSn);
        return CommonResult.success(orderDetailResult);
    }


    @ApiOperation("修改订单费用信息")
    @RequestMapping(value = "/update/moneyInfo", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('oms:order:update')")
    @ResponseBody
    public CommonResult updateReceiverInfo(@RequestBody OmsMoneyInfoParam moneyInfoParam) {
        int count = orderService.updateMoneyInfo(moneyInfoParam);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("备注订单")
    @RequestMapping(value = "/update/note", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('oms:order:update')")
    @ResponseBody
    public CommonResult updateNote(@RequestParam("id") Long id,
                                   @RequestParam("note") String note,
                                   @RequestParam("status") Integer status) {
        int count = orderService.updateNote(id, note, status);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("订单完成")
    @RequestMapping(value = "/update/state", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('oms:order:update')")
    @ResponseBody
    public CommonResult updateState(@RequestParam("id") Long id,
                                   @RequestParam("status") Integer status) {
        int count = orderService.updateState(id, status);
        if (count > 0) {
            return CommonResult.success("");
        }
        return CommonResult.failed();
    }
}
