package com.yoooho.mall.controller;

import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.common.annotation.AnonymousAccess;
import com.yoooho.mall.domain.PromotionKillProduct;
import com.yoooho.mall.service.SeckillProductServer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "ProductController", description = "秒杀商品接口")
@RequestMapping("/goods")
@RestController
@CrossOrigin
public class KillProductController {

    @Autowired
    private SeckillProductServer seckillProductServer;
    @ApiOperation("秒杀商品详情")
    @RequestMapping(value = "/kill/detail/{id}", method = RequestMethod.GET)
    @AnonymousAccess
    @ResponseBody
    public CommonResult<PromotionKillProduct> killContent(@PathVariable Long id) throws Exception {
        PromotionKillProduct killProduct = seckillProductServer.getKillProductDetail(id);
        return CommonResult.success(killProduct);
    }

    @ApiOperation("今日秒杀场景")
    @RequestMapping(value = "/kill/sence", method = RequestMethod.GET)
    @AnonymousAccess
    @ResponseBody
    public CommonResult killSenceContent() throws Exception {
        return CommonResult.success(seckillProductServer.getKillSence());
    }

    @ApiOperation("今日秒杀场景内的商品")
    @RequestMapping(value = "/kill/sence/detail/{id}", method = RequestMethod.GET)
    @AnonymousAccess
    @ResponseBody
    public CommonResult killSenceDetailContent(@PathVariable Long id) throws Exception {
        return CommonResult.success(seckillProductServer.killSenceDetailContent(id));
    }

}
