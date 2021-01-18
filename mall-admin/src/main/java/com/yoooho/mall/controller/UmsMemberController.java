package com.yoooho.mall.controller;

import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.dto.UmsMemberQueryParam;
import com.yoooho.mall.service.UmsMemberService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/member")
public class UmsMemberController {

    @Autowired
    UmsMemberService memberService;
    @GetMapping
    @ApiOperation("查询会员")
    public CommonResult getStoreStaffs(UmsMemberQueryParam criteria, Pageable pageable){

        return CommonResult.success(memberService.queryAll(criteria, pageable));
    }
}
