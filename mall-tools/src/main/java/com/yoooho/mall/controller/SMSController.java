package com.yoooho.mall.controller;

import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.domian.SmsTemplate;
import com.yoooho.mall.service.SMSService;
import com.yoooho.mall.service.dto.SMSQueryCriteria;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "工具：短信管理工具")
@RestController
@RequestMapping("/api/sms")
public class SMSController {

    @Autowired
    SMSService smsService;
    @ApiOperation(value = "查询")
    @GetMapping(value = "/list")
//    @PreAuthorize("@el.check('admin','YXWECHATTEMPLATE_ALL','YXWECHATTEMPLATE_SELECT')")
    public CommonResult getSmsTemplates(SMSQueryCriteria criteria, Pageable pageable){
        return CommonResult.success(smsService.queryAll(criteria,pageable)) ;
    }

    @ApiOperation(value = "添加")
    @PostMapping
//    @PreAuthorize("@el.check('admin','YXWECHATTEMPLATE_ALL','YXWECHATTEMPLATE_SELECT')")
    public CommonResult addSmsTemplates(@Validated @RequestBody SmsTemplate smsTemplate){
        if (smsService.add(smsTemplate) == 1){
            return CommonResult.success("");
        }else {
            return CommonResult.failed();
        }
    }

    @ApiOperation(value = "修改")
    @PutMapping
    public CommonResult editSmsTemplates(@Validated @RequestBody SmsTemplate smsTemplate){
        smsService.update(smsTemplate);
        return CommonResult.success("");
    }

    @ApiOperation(value = "删除")
    @DeleteMapping(value = "/{id}")
    public CommonResult delectSmsTemplates(@PathVariable Long id){
        smsService.delete(id);
        return CommonResult.success("");
    }

    @ApiOperation(value = "发送短信")
    @PostMapping(value = "/send")
//    @PreAuthorize("@el.check('admin','YXWECHATTEMPLATE_ALL','YXWECHATTEMPLATE_DELETE')")
    public CommonResult send(Long id, String content, String phoneNumbers){
        //if(StrUtil.isNotEmpty("22")) throw new BadRequestException("演示环境禁止操作");
        smsService.sendSMS(id, content,phoneNumbers);
        return CommonResult.success("");
    }

}
