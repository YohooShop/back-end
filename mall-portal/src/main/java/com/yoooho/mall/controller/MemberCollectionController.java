package com.yoooho.mall.controller;

import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.domain.MemberProductCollection;
import com.yoooho.mall.service.MemberCollectionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 会员收藏管理Controller
 * Created by yoooho on 2019/8/2.
 */
@Controller
@CrossOrigin
@Api(tags = "MemberCollectionController", description = "会员收藏管理")
@RequestMapping("/member/collection")
public class MemberCollectionController {
    @Autowired
    private MemberCollectionService memberCollectionService;

    @ApiOperation("添加商品收藏")
    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult addProduct(MemberProductCollection productCollection) {
        int count = memberCollectionService.addProduct(productCollection);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("删除收藏商品")
    @RequestMapping(value = "/deleteProduct", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult deleteProduct(Long productId) {
        int count = memberCollectionService.deleteProduct(productId);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("显示关注列表")
    @RequestMapping(value = "/listProduct", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<MemberProductCollection>> listProduct() {
        List<MemberProductCollection> memberProductCollectionList = memberCollectionService.listProduct();
        return CommonResult.success(memberProductCollectionList);
    }
}
