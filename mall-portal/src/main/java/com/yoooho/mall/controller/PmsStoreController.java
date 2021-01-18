package com.yoooho.mall.controller;

import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.common.annotation.AnonymousAccess;
import com.yoooho.mall.model.PmsStore;
import com.yoooho.mall.service.PmsStoreService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/store")
@CrossOrigin
public class PmsStoreController {

    @Autowired
    PmsStoreService storeService;

    @ApiOperation("获取门店列表")
    @RequestMapping(value = "/listall", method = RequestMethod.GET)
    @AnonymousAccess
    @ResponseBody
    public CommonResult listall(){
        List<PmsStore> stores= storeService.queryStoreAll();
        return CommonResult.success(stores);
    }

    @ApiOperation("获取门店详情")
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    @AnonymousAccess
    @ResponseBody
    public CommonResult list( @PathVariable("id") Long id){
        PmsStore store = storeService.queryStoreDetail(id);

        return CommonResult.success(store);
    }

}
