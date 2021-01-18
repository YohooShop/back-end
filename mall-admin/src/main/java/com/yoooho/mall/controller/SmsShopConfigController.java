package com.yoooho.mall.controller;

import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.model.SmsShopConfig;
import com.yoooho.mall.service.SmsShopConfigService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/shopconfig")
public class SmsShopConfigController {

    @Autowired
    SmsShopConfigService shopConfigService;
    @ApiOperation("保存")
    @PostMapping
    @ResponseBody
    public CommonResult save(@RequestBody SmsShopConfig smsShopConfig){
        int res =shopConfigService.save(smsShopConfig);
        if (res == 0) {
            return CommonResult.failed();
        }else {
            return CommonResult.success("");
        }
    }

    @ApiOperation("获取")
    @GetMapping
    @ResponseBody
    public CommonResult get(){
        return CommonResult.success(shopConfigService.get());
    }

}
