package com.yoooho.mall.controller;

import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.dto.PmsProductKillQueryParam;
import com.yoooho.mall.dto.PmsProductSeckillParam;
import com.yoooho.mall.model.PmsProductSeckill;
import com.yoooho.mall.service.PmsProductSeckillService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Api(tags = "PmsProductController", description = "秒杀商品管理")
@RequestMapping("/product/seckill")
public class PmsProductSeckillController {

    @Autowired
    PmsProductSeckillService seckillService;

    @ApiOperation("创建商品")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
//    @PreAuthorize("hasAuthority('pms:product:seckill')")
    public CommonResult create(@RequestBody PmsProductSeckillParam productParam, BindingResult bindingResult) {
        int count = seckillService.addSeckillProduct(productParam);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }


    @ApiOperation("更新")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
//    @PreAuthorize("hasAuthority('pms:product:seckill')")
    public CommonResult update(@RequestBody PmsProductSeckillParam productParam, BindingResult bindingResult) {
        seckillService.update(productParam);
       return CommonResult.success("");
    }

    @ApiOperation("详情")
    @RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult update(@PathVariable("id") Long id) {
       PmsProductSeckill productSeckill =  seckillService.getInfo(id);
        return CommonResult.success(productSeckill);
    }

    @ApiOperation("商品列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody

    public CommonResult list(PmsProductKillQueryParam queryParam, Pageable pageable) {
        Map res = seckillService.list(queryParam, pageable);
        return CommonResult.success(res);
    }

    @ApiOperation("删除")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
//    @PreAuthorize("hasAuthority('pms:product:seckill')")
    public CommonResult delete(@PathVariable Long id) {
        seckillService.delect(id);
        return CommonResult.success("");
    }


}
