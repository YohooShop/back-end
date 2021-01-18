package com.yoooho.mall.controller;

import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.service.HomeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@Api(tags = "HomeController", description = "管理首页数据")
@RequestMapping("/home")
public class HomeController {
    @Autowired
    HomeService homeService;
    @ApiOperation("首页数据")
    @RequestMapping(value = "/data", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult homeData() {
        return homeService.homeData();
    }

    @ApiOperation("首页统计数据")
    @RequestMapping(value = "/statistics/data", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult statisticsData(@RequestParam("beginDate")Long beginDate, @RequestParam("endDate")Long endDate) {
        return homeService.statisticsData(beginDate, endDate);
    }
}
