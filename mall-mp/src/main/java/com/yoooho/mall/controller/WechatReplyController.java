package com.yoooho.mall.controller;

import cn.hutool.core.util.ObjectUtil;
import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.domian.WechatReply;
import com.yoooho.mall.dto.WechatReplyParams;
import com.yoooho.mall.dto.WechatReplyQueryCriteria;
import com.yoooho.mall.service.WechatReplyRuleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(tags = "商城:微信回復管理")
@RestController
@RequestMapping("api")
public class WechatReplyController {

    @Autowired
    private WechatReplyRuleService wechatReplyService;


    @ApiOperation(value = "查询列表")
    @GetMapping(value = "/wechat/replyList")
    @ResponseBody

    public CommonResult getWechatReplys(WechatReplyQueryCriteria criteria, Pageable pageable){
        return CommonResult.success(wechatReplyService.queryAll(criteria,pageable));
    }


    @ApiOperation(value = "查询")
    @GetMapping(value = "/wechat/reply/{id}")
    @ResponseBody
//    @PreAuthorize("@el.check('admin','YXWECHATREPLY_ALL','YXWECHATREPLY_SELECT')")
    public CommonResult getWechatReply(@PathVariable Integer id){
        return CommonResult.success(wechatReplyService.findById(id));
    }


    @ApiOperation(value = "新增自动回复")
    @PostMapping(value = "/wechat/reply")
    @ResponseBody
//    @PreAuthorize("@el.check('admin','YXWECHATREPLY_ALL','YXWECHATREPLY_CREATE')")
    public CommonResult create(@RequestBody WechatReplyParams wechatReply){
        //if(StrUtil.isNotEmpty("22")) throw new BadRequestException("演示环境禁止操作");

        WechatReply isExist = wechatReplyService.isExist(wechatReply.getMatchValue());
        if(ObjectUtil.isNull(isExist)){
            wechatReplyService.create(wechatReply);
        }else{
            wechatReply.setId(isExist.getId());
            wechatReplyService.update(wechatReply);
        }

        return CommonResult.success("");
    }
    @ApiOperation("批量修改删除状态")
    @RequestMapping(value = "/wechat/reply", method = RequestMethod.DELETE)
    @ResponseBody
    public CommonResult delete(@RequestParam("ids") List<Long> ids) throws Exception {
        wechatReplyService.delect(ids);
        return CommonResult.success("删除成功");
    }



}
