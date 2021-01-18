package com.yoooho.mall.controller;

import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.domian.WxFansBatchTaggingForm;
import com.yoooho.mall.domian.WxFansTagForm;
import com.yoooho.mall.service.WechatFansTagService;
import io.swagger.annotations.Api;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "商城:微信粉丝管理")
@RestController
@RequestMapping("api/wechat/fansTag")
public class WechatFansTagController {

    @Autowired
    WechatFansTagService wechatFansTagService;
    /**
     * 查询用户标签
     */
    @GetMapping("/list")
//    @RequiresPermissions("wx:wxuser:info")

    public CommonResult list() throws WxErrorException {
        return CommonResult.success(wechatFansTagService.getWxTags());
    }

    /**
     * 修改或新增标签
     */
    @PostMapping("/save")
//    @RequiresPermissions("wx:wxuser:save")

    public CommonResult save(@RequestBody WxFansTagForm form) throws WxErrorException{
        Long tagid = form.getId();
        if(tagid==null || tagid<=0){
            wechatFansTagService.creatTag(form.getName());
        }else {
            wechatFansTagService.updateTag(tagid,form.getName());
        }
        return CommonResult.success("");
    }

    /**
     * 删除标签
     */
    @PostMapping("/delete/{tagid}")
    public CommonResult delete(@PathVariable("tagid") Long tagid) throws WxErrorException{
        if(tagid==null || tagid<=0){
            return CommonResult.failed("标签ID不得为空");
        }
        wechatFansTagService.deleteTag(tagid);
        return CommonResult.success("");
    }

    /**
     * 批量给用户打标签
     */
    @PostMapping("/batchTagging")
    public CommonResult batchTagging(@RequestBody WxFansBatchTaggingForm form) throws WxErrorException{
        wechatFansTagService.batchTagging(form.getTagid(),form.getOpenidList());
        return CommonResult.success("");
    }

    /**
     * 批量移除用户标签
     */
    @PostMapping("/batchUnTagging")
//    @RequiresPermissions("wx:wxuser:save")
    public CommonResult batchUnTagging(@RequestBody WxFansBatchTaggingForm form) throws WxErrorException{
        wechatFansTagService.batchUnTagging(form.getTagid(),form.getOpenidList());
        return CommonResult.success("");
    }

}
