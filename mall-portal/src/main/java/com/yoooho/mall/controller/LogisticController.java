package com.yoooho.mall.controller;

import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.service.LogisticService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@Api(tags = "LogisticControllerr", description = "物流")
@RequestMapping("/logistic")
public class LogisticController {

    @Autowired
    LogisticService logisticService;

    @ApiOperation("获取快递信息")
    @RequestMapping(value = "/info",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult logisticstOrder(@RequestParam("id")Long id){
        return   logisticService.logisticstOrder(id);
    }

}
