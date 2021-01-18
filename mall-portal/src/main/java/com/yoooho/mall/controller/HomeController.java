package com.yoooho.mall.controller;

import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.common.annotation.AnonymousAccess;
import com.yoooho.mall.domain.HomeConfigResult;
import com.yoooho.mall.domain.HomeContentResult;
import com.yoooho.mall.domain.HomeNewContentResult;
import com.yoooho.mall.domain.PmsProductCategoryWithChildrenItem;
import com.yoooho.mall.model.*;
import com.yoooho.mall.service.HomeService;
import com.yoooho.mall.service.SubjectService;
import com.yoooho.mall.model.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 首页内容管理Controller
 * Created by yoooho on 2019/1/28.
 */
@RestController
@CrossOrigin
@Api(tags = "HomeController", description = "首页内容管理")
@RequestMapping("/home")

public class HomeController {
    @Autowired
    private HomeService homeService;

    @Autowired

    private SubjectService subjectService;

    @ApiOperation("获取首页配置信息")
    @RequestMapping(value = "/config", method = RequestMethod.GET)
    @AnonymousAccess
    @ResponseBody
    public CommonResult config() {
        HomeConfigResult result = homeService.config();
        return CommonResult.success(result);
    }

    @ApiOperation("首页内容页信息展示")
    @RequestMapping(value = "/content", method = RequestMethod.GET)
    @AnonymousAccess
    @ResponseBody
    public CommonResult<HomeContentResult> content() {
        HomeContentResult contentResult = homeService.content();
        return CommonResult.success(contentResult);
    }

    @ApiOperation("首页内容页信息展示")
    @RequestMapping(value = "/newcontent", method = RequestMethod.GET)
    @AnonymousAccess
    @ResponseBody
    public CommonResult  newContent() {
        HomeNewContentResult contentResult = homeService.newContent();
        return CommonResult.success(contentResult);
    }

    @ApiOperation("首页落地内容页信息展示")
    @RequestMapping(value = "/landPagesContent", method = RequestMethod.GET)
    @AnonymousAccess
    @ResponseBody
    public CommonResult  landPagesContent() {
        LandPages landPages = homeService.getLandHomePages();
        return CommonResult.success(landPages);
    }





    @ApiOperation("分页获取推荐商品")
    @RequestMapping(value = "/recommendProductList", method = RequestMethod.GET)
    @AnonymousAccess
    @ResponseBody
    public CommonResult<List<PmsProduct>> recommendProductList(@RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
                                                               @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<PmsProduct> productList = homeService.recommendProductList(pageSize, pageNum);
        return CommonResult.success(productList);
    }

    @ApiOperation("获取商品分类")
    @RequestMapping(value = "/productCate", method = RequestMethod.GET)
    @AnonymousAccess
    @ResponseBody
    public CommonResult<List<PmsProductCategoryWithChildrenItem>> getProductCate() {
        List<PmsProductCategoryWithChildrenItem> productCategory = homeService.getProductCate();
        return CommonResult.success(productCategory);
    }


    @ApiOperation("获取首页商品分类")
    @RequestMapping(value = "/productCateList/{parentId}", method = RequestMethod.GET)
    @AnonymousAccess
    @ResponseBody
    public CommonResult<List<PmsProductCategory>> getProductCateList(@PathVariable Long parentId) {
        List<PmsProductCategory> productCategoryList = homeService.getProductCateList(parentId);
        return CommonResult.success(productCategoryList);
    }

    @ApiOperation("根据分类获取专题")
    @RequestMapping(value = "/subjectList", method = RequestMethod.GET)
    @AnonymousAccess
    @ResponseBody
    public CommonResult<List<CmsSubject>> getSubjectList(@RequestParam(required = false) Long cateId,
                                                         @RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
                                                         @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<CmsSubject> subjectList = homeService.getSubjectList(cateId,pageSize,pageNum);
        return CommonResult.success(subjectList);
    }

    @ApiOperation("获取全部专题列表")
    @RequestMapping(value = "/subjectAllList", method = RequestMethod.GET)
    @AnonymousAccess
    @ResponseBody
    public CommonResult<List<CmsSubject>> getSubjectAllList(
                                                         @RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
                                                         @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<CmsSubject> subjectList = homeService.getSubjectAllList(pageSize,pageNum);
        return CommonResult.success(subjectList);
    }

    @ApiOperation("获取人气推荐商品")
    @RequestMapping(value = "/hotProductList", method = RequestMethod.GET)
    @AnonymousAccess
    @ResponseBody
    public CommonResult hotProductList(
            @RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List list = homeService.getHotProductList(pageSize,pageNum);
        return CommonResult.success(list);
    }

    @ApiOperation("获取全部新品推荐商品")
    @RequestMapping(value = "/newProductList", method = RequestMethod.GET)
    @AnonymousAccess
    @ResponseBody
    public CommonResult newProductList(
            @RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List list = homeService.getNewProductList(pageSize,pageNum);
        return CommonResult.success(list);
    }

    @ApiOperation("专题详情")
    @RequestMapping(value = "/subject/detail", method = RequestMethod.GET)
    @AnonymousAccess
    @ResponseBody
    public CommonResult  getSubjectDetail(@RequestParam(value = "subjectId") Long subjectId) {
        Object subject = subjectService.getSubjectDetail(subjectId);
        return CommonResult.success(subject);
    }

    @ApiOperation("专题下面的商品")
    @RequestMapping(value = "/subject/goods", method = RequestMethod.GET)
    @AnonymousAccess
    @ResponseBody
    public CommonResult getSubjectGoods(@RequestParam(value = "subjectId") Long subjectId,
                                                          @RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
                                                          @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        Object subjectGoods = subjectService.getSubjectGoods(subjectId, pageSize, pageNum);
        return CommonResult.success(subjectGoods);
    }



    @ApiOperation("获取商品列表")
    @RequestMapping(value = "/productList", method = RequestMethod.GET)
    @AnonymousAccess
    @ResponseBody
    public CommonResult<List<PmsProduct>> productList(@RequestParam(required = false) Long cateId,
                                                         @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
                                                         @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                      @RequestParam(value = "type", defaultValue = "0") Integer type) {
        List<PmsProduct> pmsProductList = homeService.getProductList(cateId,pageSize,pageNum,type);
        return CommonResult.success(pmsProductList);
    }


    @ApiOperation("获取拼团商品列表")
    @RequestMapping(value = "/pinkProductList", method = RequestMethod.GET)
    @AnonymousAccess
    @ResponseBody
    public CommonResult<List<PmsProductCombination>> pinkProductList(
                                                      @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
                                                      @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<PmsProductCombination> pmsProductList = homeService.getPinkProductList(pageSize,pageNum);
        return CommonResult.success(pmsProductList);
    }





}
