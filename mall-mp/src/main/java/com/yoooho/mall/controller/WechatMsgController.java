package com.yoooho.mall.controller;


import com.yoooho.mall.common.CommonPage;
import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.domian.WxMsgReplyForm;
import com.yoooho.mall.model.WechatMsg;
import com.yoooho.mall.service.MsgReplyService;
import com.yoooho.mall.service.WechatMsgSevice;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(tags = "商城:微信菜單")
@RestController
@RequestMapping("api/wechat/msg")
public class WechatMsgController {
    @Autowired
    WechatMsgSevice msgSevice;

    @Autowired
    private MsgReplyService msgReplyService;
    /**
     * 列表
     */
    @GetMapping("/list")
//    @RequiresPermissions("wx:wxmsg:list")
    public CommonResult list(@RequestParam Map<String, Object> params){
        List<WechatMsg> msgs =msgSevice.queryPage(params);
        return CommonResult.success(CommonPage.restPage(msgs));
    }

    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    //@RequiresPermissions("wx:wxmsg:info")
    public CommonResult info(@PathVariable("id") Long id){
        WechatMsg wxMsg = msgSevice.getById(id);
        return CommonResult.success(wxMsg);
    }

    /**
     * 回复
     */
    @PostMapping("/reply")
//    @RequiresPermissions("wx:wxmsg:save")
    public CommonResult reply(@RequestBody WxMsgReplyForm form){

        msgReplyService.reply(form.getOpenid(),form.getReplyType(),form.getReplyContent());
        return CommonResult.success("");
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
//    @RequiresPermissions("wx:wxmsg:delete")
    public CommonResult delete(@RequestBody List<Long> ids){
       msgSevice.removeByIds(ids);
        return CommonResult.success("");
    }

}
