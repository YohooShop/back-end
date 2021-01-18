package com.yoooho.mall.controller;

import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.domian.EmailConfig;
import com.yoooho.mall.service.EmailService;
import com.yoooho.mall.vo.EmailVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/email")
@Api(tags = "工具：邮件管理")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping
    @ResponseBody
    public CommonResult get(){
        return CommonResult.success(emailService.find());
    }


    @PutMapping
    @ApiOperation("配置邮件")
    @ResponseBody
    @PreAuthorize("hasAuthority('tools:email:config')")
    public CommonResult emailConfig(@Validated @RequestBody EmailConfig emailConfig){
        emailService.update(emailConfig,emailService.find());
        return CommonResult.success("更新邮件配置成功");
    }

    @PostMapping
    @ApiOperation("发送邮件")
    @PreAuthorize("hasAuthority('tools:email:send')")
    public CommonResult send(@Validated @RequestBody EmailVo emailVo) throws Exception {
        emailService.send(emailVo,emailService.find());
        return  CommonResult.success("发送邮件成功");
    }
}
