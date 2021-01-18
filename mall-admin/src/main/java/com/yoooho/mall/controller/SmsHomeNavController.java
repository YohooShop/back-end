package com.yoooho.mall.controller;

import com.yoooho.mall.common.CommonPage;
import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.model.SmsHomeNav;
import com.yoooho.mall.service.SmsHomeNavService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/home/nav")
@Api(tags = "SmsHomeNavController", description = "首页品牌管理")
public class SmsHomeNavController {
    @Autowired
    SmsHomeNavService homeNavService;
    @ApiOperation("添加首页导航")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
//    @PreAuthorize("hasAuthority('sms:nav:create')")
    @ResponseBody
    public CommonResult create(@RequestBody SmsHomeNav homeBrandList) {
        int count = homeNavService.create(homeBrandList);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("删除")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
//    @PreAuthorize("hasAuthority('sms:nav:del')")
    @ResponseBody
    public CommonResult delete(@RequestParam("ids") List<Long> ids) {
        int count = homeNavService.delete(ids);
        if (count > 0)
            return CommonResult.success(count);
        return CommonResult.failed();
    }

    @ApiOperation("修改上下线状态")
//    @PreAuthorize("hasAuthority('sms:nav:update')")
    @RequestMapping(value = "/update/status/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateStatus(@PathVariable Long id, Integer status) {
        int count = homeNavService.updateStatus(id, status);
        if (count > 0)
            return CommonResult.success(count);
        return CommonResult.failed();
    }

    @ApiOperation("获取详情")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<SmsHomeNav> getItem(@PathVariable Long id) {
        SmsHomeNav homeNav = homeNavService.getItem(id);
        return CommonResult.success(homeNav);
    }

    @ApiOperation("修改")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
//    @PreAuthorize("hasAuthority('sms:advertise:update')")
    @ResponseBody
    public CommonResult update(@PathVariable Long id, @RequestBody SmsHomeNav homeNav) {
        int count = homeNavService.update(id, homeNav);
        if (count > 0)
            return CommonResult.success(count);
        return CommonResult.failed();
    }

    @ApiOperation("分页查询")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult list(@RequestParam(value = "name", required = false) String name,
                                                           @RequestParam(value = "size", defaultValue = "5") Integer pageSize,
                                                           @RequestParam(value = "page", defaultValue = "1") Integer pageNum) {
        List<SmsHomeNav> homeNavList = homeNavService.list(name, pageSize, pageNum);
        CommonPage result = CommonPage.restPage(homeNavList);
        Map<String,Object> map = new LinkedHashMap<>(2);
        map.put("content",homeNavList);
        map.put("totalElements",result.getTotal());
        return CommonResult.success(map);
    }
}
