package com.yoooho.mall.controller;

import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.dto.StoreStaffQueryParam;
import com.yoooho.mall.model.PmsStoreStaff;
import com.yoooho.mall.service.StoreStaffService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Api(tags = "门店店员管理")
@RestController
@RequestMapping(value = "/store/staff")
public class PmsStoreStaffController {

    @Autowired
    StoreStaffService storeStaffService;
    @ApiOperation("导出数据")
    @GetMapping(value = "/download")
//    @PreAuthorize("@el.check('yxSystemStoreStaff:list')")
    public void download(HttpServletResponse response, StoreStaffQueryParam criteria) throws IOException {
        storeStaffService.download(storeStaffService.queryAll(criteria), response);
    }

    @GetMapping
    @ApiOperation("查询门店店员")
//    @PreAuthorize("@el.check('yxSystemStoreStaff:list')")
    public CommonResult getStoreStaffs(StoreStaffQueryParam  criteria, Pageable pageable){

        return CommonResult.success(storeStaffService.queryAll(criteria, pageable));
    }

    @PostMapping

    @ApiOperation("新增门店店员")
//    @PreAuthorize("@el.check('yxSystemStoreStaff:add')")
    public CommonResult create(@Validated @RequestBody PmsStoreStaff resources){

        return CommonResult.success(storeStaffService.create(resources));
    }

    @PutMapping

    @ApiOperation("修改门店店员")
//    @PreAuthorize("@el.check('yxSystemStoreStaff:edit')")
    public CommonResult update(@Validated @RequestBody PmsStoreStaff resources){
        storeStaffService.update(resources);
        return CommonResult.success("");
    }


    @ApiOperation("删除门店店员")
//    @PreAuthorize("@el.check('yxSystemStoreStaff:del')")
    @DeleteMapping
    public CommonResult deleteAll(@RequestBody Long[] ids) {
        //if(StrUtil.isNotEmpty("22")) throw new BadRequestException("演示环境禁止操作");
        storeStaffService.deleteAll(ids);
        return CommonResult.success("");
    }
}
