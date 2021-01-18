package com.yoooho.mall.controller;

import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.domain.MemberSignData;
import com.yoooho.mall.service.UmsMemberSignService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
@Api(tags = " UmsMemberSignController", description = "签到")
@RequestMapping("/member/sign")
public class UmsMemberSignController {

    @Autowired
    UmsMemberSignService memberSignService;
    @ApiOperation("签到日历")
    @GetMapping
    @ResponseBody
    public CommonResult signList(String date) {
        List<MemberSignData> memberSignList = memberSignService.getMemberSignData(date);
        int cuntinueDays = memberSignService.signContinueDay();
        Map map = new HashMap();
        map.put("days",memberSignList);
        map.put("cuntinueDays",cuntinueDays);
        return CommonResult.success(map);
    }

    @ApiOperation("签到")
    @PostMapping
    @ResponseBody
    public CommonResult addSign() {
        return CommonResult.success(memberSignService.sign());
    }


}
