package com.yoooho.mall.controller;

import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.config.WxMpConfiguration;
import com.yoooho.mall.model.WxAppConfig;
import com.yoooho.mall.model.WxOfficialAccountConfig;
import com.yoooho.mall.model.WxPayConfig;
import com.yoooho.mall.service.SystemConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Api(tags = "商城:配置管理")
@RestController
@RequestMapping("api")
public class SystemConfigController {

    @Autowired
    SystemConfigService systemConfigService;

    @ApiOperation(value = "查询")
    @GetMapping(value = "/systemConfig/officialAccount")
   // @PreAuthorize("@el.check('admin','YXSYSTEMCONFIG_ALL','YXSYSTEMCONFIG_SELECT')")
    public CommonResult getSystemConfigs(){
        return CommonResult.success(systemConfigService.queryWXOfficialAccountConfig());
    }


    @ApiOperation(value = "新增或修改")
    @PostMapping(value = "/systemConfig/officialAccount")
    //@PreAuthorize("@el.check('admin','YXSYSTEMCONFIG_ALL','YXSYSTEMCONFIG_CREATE')")
    public CommonResult create(@RequestBody WxOfficialAccountConfig officialAccountConfig){
        //重新配置微信相关
       WxOfficialAccountConfig oldConfig = systemConfigService.queryWXOfficialAccountConfig();
       if (oldConfig.getAppid() != null) {
           WxMpConfiguration.removeWxMpService(oldConfig);
//           WxPayConfiguration.removeWxPayService();
       }
//        if( RedisKeyEnum.WXPAY_MCHID.getValue().equals(key) || RedisKeyEnum.WXAPP_APPID.getValue().equals(key)){
//            WxPayConfiguration.removeWxPayService();
//        }


        systemConfigService.updateWxOfficialAccountConfig(officialAccountConfig);
        return CommonResult.success("");
    }


    @ApiOperation(value = "查询")
    @GetMapping(value = "/systemConfig/wxpay")
    // @PreAuthorize("@el.check('admin','YXSYSTEMCONFIG_ALL','YXSYSTEMCONFIG_SELECT')")
    public CommonResult getSystemConfigsWXPay(){

        return CommonResult.success(systemConfigService.queryWXPayConfig());
    }
    @ApiOperation(value = "新增或修改")
    @PostMapping(value = "/systemConfig/wxpay")
    public CommonResult create(@RequestBody WxPayConfig wxPayConfig){
        systemConfigService.updateWxPayConfig(wxPayConfig);
        return CommonResult.success("");
    }

    @ApiOperation(value = "查询")
    @GetMapping(value = "/systemConfig/wxapp")
    // @PreAuthorize("@el.check('admin','YXSYSTEMCONFIG_ALL','YXSYSTEMCONFIG_SELECT')")
    public CommonResult getSystemConfigsWXApp(){

        return CommonResult.success(systemConfigService.queryWXAPPConfig());
    }
    @ApiOperation(value = "新增或修改")
    @PostMapping(value = "/systemConfig/wxapp")
    public CommonResult create(@RequestBody WxAppConfig config){
        systemConfigService.updateWxAppConfig(config);
        return CommonResult.success("");
    }

}
