package com.yoooho.mall.controller;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.common.exception.BadRequestException;
import com.yoooho.mall.config.WxMpConfiguration;
import com.yoooho.mall.model.WechatMenu;

import com.yoooho.mall.service.SystemConfigService;
import com.yoooho.mall.service.WechatMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.chanjar.weixin.common.bean.menu.WxMenu;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.menu.WxMpMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@Api(tags = "商城:微信菜單")
@RestController
@RequestMapping("api")
@SuppressWarnings("unchecked")
public class WechatMenuController {

    @Autowired
    private WechatMenuService wechatMenuService;

    @Autowired
    private SystemConfigService systemConfigService;


    @ApiOperation(value = "查询菜单")
    @GetMapping(value = "/wechat/menu")
    @ResponseBody
   // @PreAuthorize("@el.check('admin','YxWechatMenu_ALL','YxWechatMenu_SELECT')")
    public CommonResult getYxWechatMenus(){
        return CommonResult.success(wechatMenuService.findById("wechat_menus"));
    }


    @ApiOperation(value = "创建菜单")
    @PostMapping(value = "/wechat/menu")
//    @PreAuthorize("@el.check('admin','YxWechatMenu_ALL','YxWechatMenu_CREATE')")
    public CommonResult create(@RequestBody String jsonStr){
        //if(StrUtil.isNotEmpty("22")) throw new BadRequestException("演示环境禁止操作");
        JSONObject jsonObject = JSON.parseObject(jsonStr);
        String jsonButton = jsonObject.get("buttons").toString();
        WechatMenu wechatMenu = new WechatMenu();
        Boolean isExist = wechatMenuService.isExist("wechat_menus");
        WxMenu menu = JSONObject.parseObject(jsonStr, WxMenu.class);
        WxMpService wxService = WxMpConfiguration.getWxMpService(systemConfigService.queryWXOfficialAccountConfig());
        wechatMenu.setName("wechat_menus");
        if(isExist){
            wechatMenu.setResult(jsonButton);
            wechatMenuService.update(wechatMenu);
        }else {

            wechatMenu.setResult(jsonButton);
            wechatMenu.setAddTime(new Date());
            wechatMenuService.create(wechatMenu);
        }


        //创建菜单
        try {
            wxService.getMenuService().menuDelete();
            wxService.getMenuService().menuCreate(menu);
        } catch (WxErrorException e) {
            throw new BadRequestException(e.getMessage());
           // e.printStackTrace();
        }

        return CommonResult.success("");
    }

    @ApiOperation(value = "同步菜单")
    @GetMapping(value = "/wechat/menu/synchronize")
   // @PreAuthorize("@el.check('admin','YxWechatMenu_ALL','YxWechatMenu_CREATE')")
    @ResponseBody
     public CommonResult  synchronize(){
        WxMpService wxService = WxMpConfiguration.getWxMpService(systemConfigService.queryWXOfficialAccountConfig());
        try {
            WxMpMenu menu = wxService.getMenuService().menuGet();
            Boolean isExist = wechatMenuService.isExist("wechat_menus");

            String jsonButton = JSONObject.toJSONString(menu.getMenu().getButtons());
            WechatMenu wechatMenu = new WechatMenu();
            wechatMenu.setName("wechat_menus");
            if(isExist){
                wechatMenu.setResult(jsonButton);
                wechatMenuService.update(wechatMenu);
            }else {
                wechatMenu.setResult(jsonButton);
                wechatMenu.setAddTime(new Date());
                wechatMenuService.create(wechatMenu);
            }
            return CommonResult.success(wechatMenu);
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return CommonResult.failed();
    }

}
