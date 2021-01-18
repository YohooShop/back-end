package com.yoooho.mall.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yoooho.mall.common.CommonPage;
import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.common.constant.ShopConstants;
import com.yoooho.mall.dto.PmsStoreQueryParam;
import com.yoooho.mall.model.PmsStore;
import com.yoooho.mall.model.PmsStoreConfig;
import com.yoooho.mall.service.PmsStoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/store")
@Api(tags = "PmsProductController", description = "门店管理")
public class PmsStoreController {
    @Autowired
    PmsStoreService storeService;

    @ApiOperation("设置门店配置")
    @RequestMapping(value = "/setconfig", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult setconfig(@RequestBody PmsStoreConfig storeConfig) {
        List<PmsStoreConfig> list = storeService.queryStoreConfigAll();
        int res;
        if (list.size() == 0) {
            res = storeService.addStoreConfig(storeConfig);
        } else {
            storeConfig.setId(list.get(0).getId());
            res = storeService.updateStoreConfig(storeConfig);
        }
        if (res == 1) {
            return CommonResult.success("");
        } else {
            return CommonResult.failed();
        }
    }
    @ApiOperation("获取门店配置")
    @RequestMapping(value = "/getconfig", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getconfig(){
            List<PmsStoreConfig> list = storeService.queryStoreConfigAll();
            if (list.size() == 0){
                return CommonResult.success(new PmsStoreConfig());
            }else {
                return CommonResult.success(list.get(0));
            }
    }

    @ApiOperation("获取门店列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult list(PmsStoreQueryParam queryParam, Pageable pageable){
        CommonPage commonPage = storeService.queryStoreList(queryParam, pageable);

        Map<String,Object> map = new LinkedHashMap<>(2);
        map.put("content",commonPage.getList());
        map.put("totalElements",commonPage.getTotal());
        return CommonResult.success(map);
    }

    @GetMapping(value = "all")
    @ApiOperation("查询门店")
//    @PreAuthorize("@el.check('yxSystemStore:list')")
    public CommonResult getAllStores(PmsStoreQueryParam queryParam){
        return CommonResult.success(storeService.queryStoreAll(queryParam));
    }
    @ApiOperation("获取经纬度")
    @PostMapping(value = "/getL")
    @ResponseBody
    public CommonResult getL(@Validated @RequestBody String jsonStr){
        List <PmsStoreConfig> storeConfigs = storeService.queryStoreConfigAll();
        if (storeConfigs.size() == 0 || storeConfigs.get(0).getMapKey() == null) {
            return CommonResult.failed("请先配置腾讯地图key");
        }
        JSONObject jsonObject = JSON.parseObject(jsonStr);
        String addr = jsonObject.getString("addr");
        String url = StrUtil.format("?address={}&key={}",addr,storeConfigs.get(0).getMapKey());
        String json = HttpUtil.get(ShopConstants.QQ_MAP_URL+url);
        return CommonResult.success(JSON.parseObject(json));
    }

    @ApiOperation("添加门店")
    @PostMapping(value = "/addStore")
    @ResponseBody
    public  CommonResult addStore(@Validated @RequestBody PmsStore store) {
      int res = storeService.addStore(store);
      if (res == 0) {
          return CommonResult.failed();
      }else {
          return CommonResult.success("");
      }
    }

    @ApiOperation("修改门店信息")
    @PostMapping(value = "/updateStore")
    @ResponseBody
    public  CommonResult updateStore(@Validated @RequestBody  PmsStore store) {
        int res = storeService.updateStore(store);
        if (res == 0) {
            return CommonResult.failed();
        }else {
            return CommonResult.success("");
        }
    }
    @ApiOperation("删除门店")
    @DeleteMapping
    public CommonResult deleteAll(@RequestBody Long[] ids) {
        storeService.delStores(ids);
        return CommonResult.success("");
    }
    @ApiOperation("导出数据")
    @GetMapping(value = "/list/download")
    public void download(HttpServletResponse response, PmsStoreQueryParam queryParam) throws IOException {
        storeService.download(storeService.queryStoreAll(queryParam), response);
    }
}
