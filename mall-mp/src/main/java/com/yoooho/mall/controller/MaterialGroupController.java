package com.yoooho.mall.controller;

import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.domian.MaterialGroup;
import com.yoooho.mall.dto.MaterialGroupQueryCriteria;
import com.yoooho.mall.service.MaterialGroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Pageable;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "商城:素材分组管理")
@RestController
@RequestMapping("/api/materialgroup")
public class MaterialGroupController {

    private final MaterialGroupService materialGroupService;

    public MaterialGroupController(MaterialGroupService materialGroupService) {
        this.materialGroupService = materialGroupService;
    }



    @GetMapping(value = "/page")
    @ApiOperation("查询素材分组")
    @ResponseBody
    public CommonResult getYxMaterialGroups(MaterialGroupQueryCriteria criteria, Pageable pageable){
        return CommonResult.success(materialGroupService.queryAll(criteria,pageable));
    }

    @PostMapping
    @ApiOperation("新增素材分组")
    @ResponseBody
    public CommonResult create(@Validated @RequestBody MaterialGroup resources){
        return CommonResult.success(materialGroupService.create(resources));
    }

    @PutMapping
    @ApiOperation("修改素材分组")
    @ResponseBody
    public CommonResult update(@Validated @RequestBody MaterialGroup resources){
        materialGroupService.update(resources);
        return CommonResult.success("");
    }

    @ApiOperation("删除素材分组")
    @DeleteMapping(value = "/{id}")
    public CommonResult deleteAll(@PathVariable String id) {
        materialGroupService.deleteById(id);
        return CommonResult.success("");
    }
}
