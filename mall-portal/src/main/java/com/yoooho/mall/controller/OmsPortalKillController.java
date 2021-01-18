package com.yoooho.mall.controller;


import com.yoooho.mall.access.AccessLimit;
import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.mapper.PmsProductSeckillMapper;
import com.yoooho.mall.model.OmsOrder;
import com.yoooho.mall.model.PmsProductSeckill;
import com.yoooho.mall.rabbitmq.MQSecKillSender;
import com.yoooho.mall.rabbitmq.SecKillMessage;
import com.yoooho.mall.common.redis.GoodsKey;
import com.yoooho.mall.service.*;
import com.yoooho.mall.service.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/goods")
@RestController
@CrossOrigin
public class OmsPortalKillController implements InitializingBean {

    /***
     * 一、拼团有效期
     *
     * 请在拼团有效期内完成拼团，如果在有效期内，未达成相应参团人数，则拼团失败。如果距离活动结束时间小于拼团有效期时，则以拼团有效期为准。
     *
     * 二、拼团成功
     *
     * 拼团有效期内，支付的用户达到参团人数，则拼团成功
     *
     * 三、拼团失败
     *
     * 拼团有效期后，未达成相应参团人数的团，则该团失败，拼团失败的课程订单，系统会在1-7个 工作日内处理退款，系统处理后1-10个工作日内原路退回原支付账户中
     *
     * 四、等待拼团如何退款？
     *
     * 拼团中状态暂不支持退款申请，若拼团失败后会自动退回
     *
     * */


    /**
     * 系统的初始化，把秒杀商品的库存数量加载到Redis中；
     * 内存中判断商品是否秒杀完、Redis预减库存、判断是否重复秒杀、入队操作。
     * */

    @Autowired
    SeckillProductServer productService;

    @Autowired
    RedisService redisService;

    @Autowired
    OmsPortalOrderService orderService;

    @Autowired
    UmsMemberService memberService;

    @Autowired
    SeckillService seckillService;

    @Autowired
    MQSecKillSender sender;



    @Autowired
    PmsProductSeckillMapper seckillMapper;
    private HashMap<Long, Boolean> localOverMap = new HashMap<Long, Boolean>();


    /**
     * 系统初始化,初始化的时候把数据库中的库存加载进redis缓存中
     */

    @Override
    public void afterPropertiesSet() throws Exception {
        List<PmsProductSeckill> seckillList = productService.listKillGoods();
        if (seckillList == null) {
            return;
        }
        for (PmsProductSeckill productSeckill : seckillList) {
            redisService.set(GoodsKey.getKillGoodsStock, ""+productSeckill.getId(), productSeckill.getStock());
            localOverMap.put(productSeckill.getId(), false);
        }
    }

    public void resetSeckillProduct(Long goodsId) {
        PmsProductSeckill productSeckill = seckillMapper.selectByPrimaryKey(goodsId);

        //查询已经秒杀的订单

        //实际redis中的库存
        int stock = productSeckill.getStock();
        redisService.set(GoodsKey.getKillGoodsStock, ""+productSeckill.getId(), stock);
        if (stock > 0) {
            localOverMap.put(productSeckill.getId(), false);
        }else {
            localOverMap.put(productSeckill.getId(), true);
        }

    }

    //安全优化1：隐藏秒杀接口，实现防刷。
    @AccessLimit(seconds=5, maxCount=5, needLogin=true)//安全优化3：自定义注解，限流防刷
    @RequestMapping(value = "/kill/path",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult killPath(@RequestParam("goodsId")long goodsId) {
        String path = seckillService.createSeckillPath(goodsId);
        Map map = new HashMap();
        map.put("path",path);
        return CommonResult.success(map);
    }

    @PostMapping(value = "/{path}/kill")
    @ResponseBody
    public CommonResult kill(@RequestParam("goodsId")Long goodsId, @PathVariable("path") String path){
        //验证path
        boolean check = seckillService.checkPath(goodsId, path);
        if (!check) {
            return CommonResult.failed("path参数错误");
        }
//        //内存标记，减少redis访问
        boolean over = localOverMap.get(goodsId);
        if (over) {
            return CommonResult.failed("商品秒杀光了");
        }
        //预减库存
        long stock = redisService.decr(GoodsKey.getKillGoodsStock, "" + goodsId, 1);//10
        if (stock < 0) {
            localOverMap.put(goodsId, true);
            return CommonResult.failed("商品秒杀光了");
        }
       // 判断是否已经秒杀到了
        OmsOrder order = orderService.getKillOrderByUserIdGoodsId(memberService.getCurrentMember().getId(), goodsId);
        if (order != null) {
            return CommonResult.failed("已经秒杀到了");
        }
        //入队
        SecKillMessage mm = new SecKillMessage();
        mm.setUserId(memberService.getCurrentMember().getId());
        mm.setGoodsId(goodsId);
        sender.sendMessage(mm);
        return CommonResult.success("排队中");
    }

    // 接口优化5：客户端轮询，是否秒杀成功。
    /**
     * orderId：成功
     * -1：秒杀失败
     * 0： 排队中
     * */

    @RequestMapping(value="/killResult", method= RequestMethod.POST)
    @ResponseBody
    public CommonResult killResult(
                                      @RequestParam("goodsId")long goodsId) {
       Long userId = memberService.getCurrentMember().getId();
       Object res = seckillService.getKillResult(userId,goodsId);
       return CommonResult.success(res);
    }



}
