package com.yoooho.mall.controller;

import com.yoooho.mall.common.CommonPage;
import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.model.CmsSubject;
import com.yoooho.mall.model.CmsSubjectCategory;
import com.yoooho.mall.service.CmsSubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品专题Controller
 * Created by yoooho on 2019/6/1.
 */
@Controller
@Api(tags = "CmsSubjectController", description = "商品专题管理")
@RequestMapping("/subject")
public class CmsSubjectController {
    @Autowired
    private CmsSubjectService subjectService;

    @ApiOperation("获取全部商品专题")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<CmsSubject>> listAll() {
        List<CmsSubject> subjectList = subjectService.listAll();
        return CommonResult.success(subjectList);
    }

    @ApiOperation(value = "根据专题名称分页获取专题")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<CmsSubject>> getList(@RequestParam(value = "keyword", required = false) String keyword,
                                                        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                        @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        List<CmsSubject> subjectList = subjectService.list(keyword, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(subjectList));
    }

    @ApiOperation(value = "专题详情")
    @RequestMapping(value = "/subjectDetail/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getSubjectDetail(@PathVariable("id") Long id) {
         CmsSubject subject = subjectService.getSubjectDetail(id);
        return CommonResult.success(subject);
    }

    @ApiOperation(value = "添加专题")
    @RequestMapping(value = "/addSubject", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('sub:subject:create')")
    @ResponseBody
    public CommonResult addSubject(@RequestBody CmsSubject subject) {
        int count = subjectService.addSubject(subject);
        if (count == 0){
            return CommonResult.failed();
        }else {
            return CommonResult.success("");
        }
    }

    @ApiOperation(value = "更新专题")
    @RequestMapping(value = "/updateSubject/{id}", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('sub:subject:update')")
    @ResponseBody
    public CommonResult updateSubject(@RequestBody CmsSubject subject,@PathVariable("id") Long id) {
        subject.setId(id);
        int count = subjectService.updateSubject(subject);
        if (count == 0){
            return CommonResult.failed();
        }else {
            return CommonResult.success("");
        }
    }

    @ApiOperation(value = "专题分类")
    @RequestMapping(value = "/cateList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getSubCateList() {
        List<CmsSubjectCategory> subjectCategories = subjectService.subCateList();
        return CommonResult.success(subjectCategories);
    }

    @ApiOperation(value = "添加专题分类")
    @RequestMapping(value = "/addCate", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('sub:subjectcate:create')")
    @ResponseBody
    public CommonResult addCate(@RequestBody CmsSubjectCategory subjectCategory) {
        int count = subjectService.addCate(subjectCategory);
        if (count == 0){
            return CommonResult.failed();
        }else {
            return CommonResult.success("");
        }
    }

    @ApiOperation(value = "更新专题分类")
    @RequestMapping(value = "/updateCate/{id}", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('sub:subjectcate:update')")
    @ResponseBody
    public CommonResult updateCate(@RequestBody CmsSubjectCategory subjectCategory, @PathVariable("id") Long id) {
        subjectCategory.setId(id);
        int count = subjectService.updateCate(subjectCategory);
        if (count == 0){
            return CommonResult.failed();
        }else {
            return CommonResult.success("");
        }
    }

    @ApiOperation(value = "专题分类详情")
    @RequestMapping(value = "/cateDetail", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult cateDetail(Long id) {
        return CommonResult.success(subjectService.getCateDetail(id));
    }

    @ApiOperation(value = "专题是否显示")
    @RequestMapping(value = "/update/showStatus", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('sub:subject:update')")
    @ResponseBody
    public CommonResult showStatus(@RequestParam("ids") List<Long> ids, @RequestParam("showStatus") Integer showStatus) {
        int count = subjectService.showStatus(ids,showStatus);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation(value = "专题分类显示")
    @RequestMapping(value = "/cate/update/showStatus", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('sub:subjectcate:update')")
    @ResponseBody
    public CommonResult showSubjectCateStatus(@RequestParam("ids") List<Long> ids, @RequestParam("showStatus") Integer showStatus) {
        int count = subjectService.showSubjectCateStatus(ids,showStatus);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
    @ApiOperation(value = "专题分类排序")
    @RequestMapping(value = "/cate/updateSort", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('sub:subjectcate:update')")
    @ResponseBody
    public CommonResult updateSubjectCateSort(@RequestParam("id") Long id, @RequestParam("sort") Integer sort) {
        int count = subjectService.updateSubjectCateSort(id,sort);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }


}
