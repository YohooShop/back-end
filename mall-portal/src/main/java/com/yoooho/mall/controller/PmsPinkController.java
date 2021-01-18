package com.yoooho.mall.controller;

import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.service.PinkService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@Api(tags = "PmsPinkController", description = "拼团接口")
@RequestMapping("/pink")
public class PmsPinkController {
    @Autowired
    PinkService pinkService;
    @GetMapping(value = "/mine/{type}")
    @ResponseBody
    public CommonResult minePink(  @PathVariable("type")   Integer type, @RequestParam("page") Integer page, @RequestParam(value = "size",defaultValue = "10") Integer size) {
        return CommonResult.success(pinkService.minePink(type, page, size));
    }

}
