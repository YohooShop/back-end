package com.yoooho.mall.controller;

import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.domian.LocalStorage;
import com.yoooho.mall.service.LocalStorageService;
import com.yoooho.mall.service.dto.LocalStorageQueryCriteria;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Api(tags = "工具：本地存储管理")
@RestController
@RequestMapping("/api/localStorage")
public class LocalStorageController {
    private final LocalStorageService localStorageService;

    public LocalStorageController(LocalStorageService localStorageService) {
        this.localStorageService = localStorageService;
    }

    @ApiOperation("查询文件")
    @GetMapping
    @ResponseBody
    @PreAuthorize("@el.check('storage:list')")
    public CommonResult getLocalStorages(LocalStorageQueryCriteria criteria, Pageable pageable){
        return  CommonResult.success(localStorageService.queryAll(criteria,pageable));
    }


    @ApiOperation("导出数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('storage:list')")
    public void download(HttpServletResponse response, LocalStorageQueryCriteria criteria) throws IOException {
        localStorageService.download(localStorageService.queryAll(criteria), response);
    }

    @ApiOperation("c")
    @PostMapping
    @ResponseBody
    @PreAuthorize("@el.check('storage:add')")
    public CommonResult create(@RequestParam String name, @RequestParam("file") MultipartFile file){
        return CommonResult.success(localStorageService.create(name, file));
    }

    @ApiOperation("修改文件")
    @PutMapping
    @ResponseBody
    @PreAuthorize("@el.check('storage:edit')")
    public CommonResult update(@Validated @RequestBody LocalStorage resources){
        localStorageService.update(resources);
        return CommonResult.success("");
    }

    @DeleteMapping
    @ApiOperation("多选删除")
    @PreAuthorize("@el.check('storage:del')")
    @ResponseBody
    public CommonResult deleteAll(@RequestBody Long[] ids) {
        localStorageService.deleteAll(ids);
        return CommonResult.success("");
    }
}
