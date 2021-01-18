package com.yoooho.mall.controller;

import com.yoooho.mall.common.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "AlipayController",description = "活动接口")
@RequestMapping("/user/action")
@RestController
public class ActionController {

    @ApiOperation("转盘抽奖列表接口")
    @RequestMapping(value = "/integralLucky",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult integralLucky(@RequestParam("mold") Long mold){

        Map map = new HashMap();
        map.put("id",4);
        map.put("mold",1);
        map.put("type",2);
        map.put("name","优惠券10元");
        map.put("amount","10元");
        map.put("scale","0.10");
        Map map1 = new HashMap();
        map1.put("id",5);
        map1.put("mold",1);
        map1.put("type",2);
        map1.put("name","优惠券5元");
        map1.put("amount","5元");
        map1.put("scale","0.20");

        Map map2 = new HashMap();
        map2.put("id",6);
        map2.put("mold",1);
        map2.put("type",0);
        map2.put("name","谢谢参与");
        map2.put("amount","5元");
        map2.put("scale","");

        List list = new ArrayList();
        list.add(map);
        list.add(map1);
        list.add(map2);

        Map resmap = new HashMap();
        resmap.put("lists",list);
        resmap.put("luckdraw",1);
        return CommonResult.success(resmap);
    }

    @ApiOperation("获取抽中奖品接口返回数据")
    @RequestMapping(value = "/winningPrize",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult winningPrize(@RequestParam("mold") Long mold){

        /**
         *     "id": 5,
         *     "mold": 1,                1 积分转盘抽奖     2现金转盘抽奖
         *     "type": 1,                中奖类型    1积分  2经验   3现金
         *     "name": "积分2点",        标题
         *     "amount": 2,            数额
         *     "scale": "0.50",        比例
         *     "createtime": 1553651481
         * */
        Map map = new HashMap();
        map.put("id",4);
        map.put("mold",1);
        map.put("type",2);
        map.put("name","优惠券10元");
        map.put("amount","10元");
        return CommonResult.success(map);
    }

}
