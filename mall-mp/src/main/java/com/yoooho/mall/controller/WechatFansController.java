package com.yoooho.mall.controller;

import com.yoooho.mall.common.CommonPage;
import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.model.WechatFans;
import com.yoooho.mall.service.WechatFansService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(tags = "商城:微信粉丝管理")
@RestController
@RequestMapping("api/wechat/fans")
public class WechatFansController {

    @Autowired
    WechatFansService wechatFansService;
    /**
     * 同步用户列表
     */

    @ApiOperation(value = "同步")
    @PostMapping(value = "/sync")
    //@PreAuthorize("@el.check('admin','YXARTICLE_ALL','YXARTICLE_SELECT')")
    public CommonResult sync(){
        wechatFansService.syncFans();
        return CommonResult.success("同步成功");
    }

    /**
     * 列表
     */
    @GetMapping("/list")
    @ResponseBody
    public CommonResult list(@RequestParam Map<String, Object> params) {
      List<WechatFans> wechatFansList = wechatFansService.queryPage(params);
      return CommonResult.success(CommonPage.restPage(wechatFansList));
    }

    /**
     * 列表
     */
    @PostMapping("/listByIds")
    @ResponseBody
//    @RequiresPermissions("wx:wxuser:list")
    public CommonResult listByIds(@RequestParam("ids") List<String> openids){
        List<WechatFans> users = wechatFansService.listByIds(openids);
        return CommonResult.success(users);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{openid}")

    public CommonResult info(@PathVariable("openid") String openid) {
       WechatFans fans = wechatFansService.getById(openid);
       return CommonResult.success(fans);
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    public CommonResult delete(@RequestParam("ids") List<String> ids) {
        wechatFansService.removeByIds(ids);
        return CommonResult.success("删除粉丝成功");
    }

}
