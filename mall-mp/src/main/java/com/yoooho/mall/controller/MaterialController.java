package com.yoooho.mall.controller;

import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.common.utils.SecurityUtils;
import com.yoooho.mall.domian.Material;
import com.yoooho.mall.dto.MaterialQueryCriteria;
import com.yoooho.mall.service.MaterialService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "商城:素材管理管理")
@RestController
@RequestMapping("/api/material")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @GetMapping(value = "/page")
    @ApiOperation("查询素材管理")
    public CommonResult getYxMaterials(MaterialQueryCriteria criteria, Pageable pageable){
        return CommonResult.success(materialService.queryAll(criteria,pageable));
    }

    @PostMapping
    @ApiOperation("新增素材管理")
    @ResponseBody
    public CommonResult create(@Validated @RequestBody Material resources){
        resources.setCreateId(SecurityUtils.getUsername());
        return CommonResult.success(materialService.create(resources));
    }

    @PutMapping
    @ApiOperation("修改素材管理")
    @ResponseBody
    public CommonResult update(@Validated @RequestBody Material resources){
        materialService.update(resources);
        return CommonResult.success("");
    }

    @ApiOperation("删除素材管理")
    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public CommonResult deleteAll(@PathVariable String id) {
        materialService.deleteById(id);
        return CommonResult.success("");
    }


}
