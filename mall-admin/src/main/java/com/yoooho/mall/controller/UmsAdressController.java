package com.yoooho.mall.controller;

import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.model.UmsSenderAddress;
import com.yoooho.mall.service.UmsSenderAddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Api(tags = "OmsAdressController", description = "发货地址管理")
@RequestMapping("/address")
public class UmsAdressController {


    @Autowired
    UmsSenderAddressService senderAddressService;

    @ApiOperation("添加发货地址")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestBody UmsSenderAddress address) {
        int count = senderAddressService.add(address);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取发货地址列表")
    @RequestMapping(value = "/addressList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult list(){
        List list = senderAddressService.addressList();
        return CommonResult.success(list);
    }

    @ApiOperation("获取发货地址详情")
    @RequestMapping(value = "/addressDetail", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult addressDetail(Long addressId){
        UmsSenderAddress address = senderAddressService.addressDetail(addressId);
        return CommonResult.success(address);
    }

    @ApiOperation("更新发货地址详情")
    @RequestMapping(value = "/updateAddress/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateAddress(@RequestBody UmsSenderAddress address,@PathVariable Long id){
        address.setId(id);
        int count = senderAddressService.updateAddress(address);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("删除发货地址")
    @RequestMapping(value = "/delAddress/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delAddress(@PathVariable Long id){
        int count = senderAddressService.delAddress(id);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("更新默认发货地址")
    @RequestMapping(value = "/defaultAddress", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult defaultAddress(Long id, int state){
        int count = senderAddressService.defaultAddress(id, state);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }




}
