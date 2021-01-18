package com.yoooho.mall.controller;

import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.domian.WechatTemplate;
import com.yoooho.mall.dto.WechatTemplateQueryCriteria;
import com.yoooho.mall.service.WechatTemplateService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class WechatTemplateController {
    @Autowired
    private  WechatTemplateService wechatTemplateService;


    @ApiOperation(value = "查询")
    @GetMapping(value = "/wechat/template")
//    @PreAuthorize("@el.check('admin','YXWECHATTEMPLATE_ALL','YXWECHATTEMPLATE_SELECT')")
    public CommonResult getYxWechatTemplates(WechatTemplateQueryCriteria criteria, Pageable pageable){
        return CommonResult.success(wechatTemplateService.queryAll(criteria,pageable)) ;
    }

    @ApiOperation(value = "新增")
    @PostMapping(value = "/wechat/template")
//    @PreAuthorize("@el.check('admin','YXWECHATTEMPLATE_ALL','YXWECHATTEMPLATE_CREATE')")
    public CommonResult create(@Validated @RequestBody WechatTemplate resources){
        //if(StrUtil.isNotEmpty("22")) throw new BadRequestException("演示环境禁止操作");
        return CommonResult.success(wechatTemplateService.create(resources));
    }

    @ApiOperation(value = "修改")
    @PutMapping(value = "/wechat/template")
//    @PreAuthorize("@el.check('admin','YXWECHATTEMPLATE_ALL','YXWECHATTEMPLATE_EDIT')")
    public CommonResult update(@Validated @RequestBody WechatTemplate resources){
        //if(StrUtil.isNotEmpty("22")) throw new BadRequestException("演示环境禁止操作");
        wechatTemplateService.update(resources);
        return CommonResult.success("");
    }

    @ApiOperation(value = "删除")
    @DeleteMapping(value = "/wechat/template/{id}")
//    @PreAuthorize("@el.check('admin','YXWECHATTEMPLATE_ALL','YXWECHATTEMPLATE_DELETE')")
    public CommonResult delete(@PathVariable Integer id){
        //if(StrUtil.isNotEmpty("22")) throw new BadRequestException("演示环境禁止操作");
        wechatTemplateService.delete(id);
        return CommonResult.success("");
    }



}
