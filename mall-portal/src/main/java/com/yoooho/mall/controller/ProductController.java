package com.yoooho.mall.controller;

import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.common.annotation.AnonymousAccess;
import com.yoooho.mall.domain.PromotionProduct;
import com.yoooho.mall.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@Api(tags = "ProductController", description = "商品接口")
@RequestMapping("/goods")
public class ProductController {

    @Autowired
    private ProductService productService;

    @ApiOperation("商品详情")
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    @AnonymousAccess
    @ResponseBody
    public CommonResult<PromotionProduct> content(@PathVariable Long id) throws Exception {
        PromotionProduct promotionProduct = productService.getProductDetail(id);
        return CommonResult.success(promotionProduct);
    }







}
