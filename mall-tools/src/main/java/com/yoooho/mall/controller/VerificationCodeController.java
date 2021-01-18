package com.yoooho.mall.controller;

import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.common.utils.YshopConstant;
import com.yoooho.mall.domian.VerificationCode;
import com.yoooho.mall.service.VerificationCodeService;
import com.yoooho.mall.vo.EmailVo;
import com.yoooho.mall.service.EmailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/code")
@Api(tags = "工具：验证码管理")
public class VerificationCodeController {

    private final VerificationCodeService verificationCodeService;

    private final EmailService emailService;

    public VerificationCodeController(VerificationCodeService verificationCodeService,  EmailService emailService) {
        this.verificationCodeService = verificationCodeService;
        this.emailService = emailService;
    }

    @PostMapping(value = "/resetEmail")
    @ApiOperation("重置邮箱，发送验证码")
    public CommonResult resetEmail(@RequestBody VerificationCode code) throws Exception {
        code.setScenes(YshopConstant.RESET_MAIL);
        EmailVo emailVo = verificationCodeService.sendEmail(code);
        emailService.send(emailVo,emailService.find());
        return CommonResult.success("发送验证码成功");
    }

    @PostMapping(value = "/email/resetPass")
    @ApiOperation("重置密码，发送验证码")
    public ResponseEntity<Object> resetPass(@RequestParam String email) throws Exception {
        VerificationCode code = new VerificationCode();
        code.setType("email");
        code.setValue(email);
        code.setScenes(YshopConstant.RESET_MAIL);
        EmailVo emailVo = verificationCodeService.sendEmail(code);
        emailService.send(emailVo,emailService.find());
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping(value = "/validated")
    @ApiOperation("验证码验证")
    public CommonResult validated(VerificationCode code){
       boolean sucess =  verificationCodeService.validated(code);
       if (sucess){
           return CommonResult.success("验证成功");
       }else {
           return CommonResult.failed();
       }
    }
}
