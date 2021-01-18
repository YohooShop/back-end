package com.yoooho.mall.controller;

import com.yoooho.mall.common.CommonPage;
import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.dto.PmsProductCombQueryParam;
import com.yoooho.mall.dto.PmsProductKillQueryParam;
import com.yoooho.mall.dto.PmsProductQueryParam;
import com.yoooho.mall.model.PmsProduct;
import com.yoooho.mall.model.PmsProductCombination;
import com.yoooho.mall.model.PmsProductSeckill;
import com.yoooho.mall.service.PmsProductCombService;
import com.yoooho.mall.service.PmsProductSeckillService;
import com.yoooho.mall.service.PmsProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(tags = "商品统一管理")


@RestController
@RequestMapping(value = "/product/manager")
public class ProductController {

    @Autowired
    private PmsProductService productService;

    @Autowired
    private PmsProductSeckillService productSeckillService;

    @Autowired
    PmsProductCombService combService;

    @ApiOperation("查询商品")
    @RequestMapping(value = "/list/{type}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getList(PmsProductQueryParam productQueryParam,
                                                     @PathVariable(value = "type") Integer type,
                                                     @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                     @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        Object  page = null;

        if (type == null) {
            type = 0;
        }
        //普通商品
        if (type== 0) {
            List<PmsProduct> productList = productService.list(productQueryParam, pageSize, pageNum);
            page = CommonPage.restPage(productList);
        }

        //团购商品
        if (type == 1) {
            PmsProductCombQueryParam queryParam =new PmsProductCombQueryParam();
            queryParam.setKeyword(productQueryParam.getKeyword());
           List<PmsProductCombination> combinations = combService.list(queryParam,pageSize,pageNum);
            page = CommonPage.restPage(combinations);
        }
        //秒杀商品
        if (type == 2) {
            PmsProductKillQueryParam pmsProductKillQueryParam = new PmsProductKillQueryParam();
            pmsProductKillQueryParam.setKeyword(productQueryParam.getKeyword());
            List<PmsProductSeckill> seckillList =  productSeckillService.list(pmsProductKillQueryParam,pageSize,pageNum);
            page = CommonPage.restPage(seckillList);
        }
        return  CommonResult.success(page);
    }
}
