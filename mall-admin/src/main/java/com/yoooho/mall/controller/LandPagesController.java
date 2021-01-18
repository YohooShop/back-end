package com.yoooho.mall.controller;

import com.yoooho.mall.common.CommonPage;
import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.model.LandPages;
import com.yoooho.mall.service.LandPagesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@Api(tags = "LandPagesController", description = "落地页面管理")
@RequestMapping("/landpages")
public class LandPagesController {

    @Autowired
    LandPagesService landPagesService;
    @ApiOperation("新增")
    @PostMapping
    @ResponseBody
    public CommonResult add(@RequestBody LandPages landPages) {
        int res = landPagesService.add(landPages);
        if (res == 1) {
            return CommonResult.success("");
        }else {
            if (res == 2) {
                return CommonResult.failed("urlkey冲突");
            }
            return CommonResult.failed("新增失败");
        }
    }

    @ApiOperation("更新")
    @PutMapping
    @ResponseBody
    public CommonResult update(@RequestBody LandPages landPages) {
        int res = landPagesService.update(landPages);
        if (res == 1) {
            return CommonResult.success("");
        }else {
            return CommonResult.failed("更新失败");
        }
    }

    @ApiOperation("列表")
    @GetMapping
    @ResponseBody
    public CommonResult  list(@RequestParam(value = "size", defaultValue = "5") Integer pageSize,
                              @RequestParam(value = "page", defaultValue = "1") Integer pageNum) {
        List<LandPages>  landPagesList = landPagesService.list(pageSize, pageNum);

        CommonPage result = CommonPage.restPage(landPagesList);
        Map<String,Object> map = new LinkedHashMap<>(2);
        map.put("content",landPagesList);
        map.put("totalElements",result.getTotal());
        return CommonResult.success(map);
    }

    @ApiOperation("列表")
    @GetMapping(value = "/list")
    @ResponseBody
    public CommonResult  listAll() {
        List<LandPages>  landPagesList = landPagesService.listAll();
        return CommonResult.success(landPagesList);
    }

    @ApiOperation("详情")
    @GetMapping(value = "/{id}")
    @ResponseBody
    public CommonResult  info(@PathVariable Long id) {
        LandPages landPages = landPagesService.info(id);
        return CommonResult.success(landPages);
    }

    @ApiOperation("删除")
    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public CommonResult  delete(@PathVariable Long id) {
        int res = landPagesService.delete(id);
        if (res == 1) {
            return CommonResult.success("");
        }else {
            return CommonResult.failed("删除失败");
        }

    }

    @ApiOperation("更新状态")
    @PostMapping(value = "/updateStatus/{id}")
    @ResponseBody
    public CommonResult  updateStatus(@PathVariable Long id, boolean showStatus) {
        int res = landPagesService.updateStatus(id, showStatus);
        if (res == 1) {
            return CommonResult.success("");
        }else {
            return CommonResult.failed("更新状态失败");
        }

    }



}
