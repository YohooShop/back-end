package com.yoooho.mall.controller;

import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.domain.OrderParam;
import com.yoooho.mall.domain.ConfirmOrderResult;
import com.yoooho.mall.model.OmsOrder;
import com.yoooho.mall.service.OmsPortalOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 订单管理Controller
 * Created by yoooho on 2019/8/30.
 */
@RestController
@CrossOrigin
@Api(tags = "OmsPortalOrderController",description = "订单管理")
@RequestMapping("/order")
public class OmsPortalOrderController {
    @Autowired
    private OmsPortalOrderService portalOrderService;

    @ApiOperation("根据购物车选择的商品信息生成确认单信息")
    @RequestMapping(value = "/generateConfirmOrder",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<ConfirmOrderResult> generateConfirmOrder(@RequestParam("ids")List<Long> ids,@RequestParam("orderType") Integer orderType,@RequestParam("orderId") Long orderId){
        ConfirmOrderResult confirmOrderResult = portalOrderService.generateConfirmOrder(ids, orderType,orderId);
        return CommonResult.success(confirmOrderResult);
    }

    @ApiOperation("当面付订单生成")
    @RequestMapping(value = "/generateFaceOrder",method = RequestMethod.POST)
    @ResponseBody
    public Object generateFaceOrder(Long orderId){
        return portalOrderService.generateFaceOrder(orderId);
    }

    @ApiOperation("获取面付订单信息")
    @RequestMapping(value = "/getFaceOrder",method = RequestMethod.POST)
    @ResponseBody
    public Object getFaceOrder(Long orderId){
        return  CommonResult.success(portalOrderService.getFaceOrder(orderId));
    }

    @ApiOperation("根据购物车选择的商品信息生成订单")
    @RequestMapping(value = "/generateOrder",method = RequestMethod.POST)
    @ResponseBody
    public Object generateOrder(OrderParam orderParam){
        return portalOrderService.generateOrder(orderParam.getIds());
    }

    @ApiOperation("更新商品信息订单")
    @RequestMapping(value = "/updateOrderInfo",method = RequestMethod.POST)
    @ResponseBody
    public Object updateOrderInfo(OrderParam orderParam){
        return portalOrderService.updateOrderInfo(orderParam);
    }
    @ApiOperation("获取订单信息")
    @RequestMapping(value = "/getOrderInfo",method = RequestMethod.GET)
    @ResponseBody
    public Object getOrderInfo(Long orderId){
        return portalOrderService.getOrderInfo(orderId);
    }

    @ApiOperation("自动取消超时订单")
    @RequestMapping(value = "/cancelTimeOutOrder",method = RequestMethod.POST)
    @ResponseBody
    public Object cancelTimeOutOrder(){
        return portalOrderService.cancelTimeOutOrder();
    }

    @ApiOperation("取消订单")
    @RequestMapping(value = "/cancelOrder",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult cancelOrder(Long orderId){
        portalOrderService.cancelOrder(orderId);
        return CommonResult.success(null);
    }

    @ApiOperation("获取订单列表")
    @RequestMapping(value = "/orders",method = RequestMethod.POST)
    @ResponseBody
    public Object orders(@RequestParam("orderType") int orderType,@RequestParam("pages") int pages,@RequestParam("size") int size) {
        return portalOrderService.getOrders(orderType, pages, size);
    }

    @ApiOperation("获取订单详情")
    @RequestMapping(value = "/orderDetail",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult orderDetail( @RequestParam("id")Long id){
       return   portalOrderService.getOrderDetail(id);
    }

    @ApiOperation("获取订单详情")
    @RequestMapping(value = "/orderDetailBySn",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult orderDetailBySn( @RequestParam("orderSn")String orderSn){
        return   portalOrderService.getOrderDetailBySn(orderSn);
    }

    @ApiOperation("删除订单")
    @RequestMapping(value = "/delOrder",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delOrder( @RequestParam("id")Long id){
        return   portalOrderService.delOrder(id);
    }


    @ApiOperation("确定收货")
    @RequestMapping(value = "/confirmReceiptOrder",method = RequestMethod.POST)

    @ResponseBody
    public CommonResult confirmReceiptOrder( @RequestParam("id")Long id){
        return   portalOrderService.confirmReceiptOrder(id);
    }

    @ApiOperation("支付订单信息")
    @RequestMapping(value = "/payOrderInfo",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult payOrderInfo( @RequestParam("id")Long id){
        OmsOrder omsOrder = portalOrderService.payOrderInfo(id);
        Map map = new HashMap();
        map.put("payAmount",omsOrder.getPayAmount());
        map.put("shoppingType",omsOrder.getShoppingType());
        return   CommonResult.success(map);
    }


}
