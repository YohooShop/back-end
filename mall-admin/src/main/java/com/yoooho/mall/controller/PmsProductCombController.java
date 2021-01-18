package com.yoooho.mall.controller;

import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.dto.PmsProductCombParam;
import com.yoooho.mall.dto.PmsProductCombQueryParam;

import com.yoooho.mall.model.PmsProductCombination;

import com.yoooho.mall.service.PmsProductCombService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api(tags = "PmsProductController", description = "秒杀商品管理")
@RequestMapping("/product/comb")
@RestController
public class PmsProductCombController {

    @Autowired
    PmsProductCombService combService;

    @ApiOperation("创建商品")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
//    @PreAuthorize("hasAuthority('pms:product:seckill')")
    public CommonResult create(@RequestBody PmsProductCombParam productParam, BindingResult bindingResult) {
        int count = combService.addSeckillProduct(productParam);
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
    public CommonResult update(@RequestBody PmsProductCombParam productParam, BindingResult bindingResult) {
        combService.update(productParam);
        return CommonResult.success("");
    }
    @ApiOperation("更新状态")
    @RequestMapping(value = "/updateStatus/{id}", method = RequestMethod.POST)
    @ResponseBody
//    @PreAuthorize("hasAuthority('pms:product:seckill')")
    public CommonResult updateStatus(@PathVariable Long id, boolean isShow) {
        combService.updateStatus(id,isShow);
        return CommonResult.success("");
    }
    @ApiOperation("详情")
    @RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult update(@PathVariable("id") Long id) {
        PmsProductCombination productCombination =  combService.getInfo(id);
        return CommonResult.success(productCombination);
    }

    @ApiOperation("商品列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody

    public CommonResult list(PmsProductCombQueryParam queryParam, Pageable pageable) {
        Map res = combService.list(queryParam, pageable);
        return CommonResult.success(res);
    }

    @ApiOperation("删除")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
//    @PreAuthorize("hasAuthority('pms:product:seckill')")
    public CommonResult delete(@PathVariable Long id) {
        combService.delect(id);
        return CommonResult.success("");
    }
}
