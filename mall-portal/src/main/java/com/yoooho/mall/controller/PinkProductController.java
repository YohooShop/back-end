package com.yoooho.mall.controller;

import com.yoooho.mall.access.AccessLimit;
import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.common.annotation.AnonymousAccess;
import com.yoooho.mall.common.redis.GoodsKey;
import com.yoooho.mall.domain.PromotionPinkProduct;

import com.yoooho.mall.mapper.PmsProductCombinationMapper;
import com.yoooho.mall.model.PmsProductCombination;
import com.yoooho.mall.model.UmsMember;
import com.yoooho.mall.rabbitmq.MQPinkSender;
import com.yoooho.mall.rabbitmq.PinkMessage;
import com.yoooho.mall.service.PinkProductService;
import com.yoooho.mall.service.PinkService;
import com.yoooho.mall.service.RedisService;
import com.yoooho.mall.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@Api(tags = "ProductController", description = "拼团商品接口")
@RequestMapping("/goods")
public class PinkProductController implements InitializingBean {

    @Autowired
    private PinkProductService productService;
    @Autowired
    PinkService pinkService;
    @Autowired
    RedisService redisService;
    @Autowired
    UmsMemberService memberService;
    @Autowired
    PmsProductCombinationMapper productCombinationMapper;
    @Autowired
    MQPinkSender sender;

    private HashMap<Long, Boolean> localOverMap = new HashMap<Long, Boolean>();
    /**
     * 系统初始化,初始化的时候把数据库中的库存加载进redis缓存中
     */

    @Override
    public void afterPropertiesSet() throws Exception {
        List<PmsProductCombination> seckillList = productService.listPinkGoods();
        if (seckillList == null) {
            return;
        }
        for (PmsProductCombination productCombination : seckillList) {
            redisService.set(GoodsKey.getPinkGoodsStock, ""+productCombination.getId(), productCombination.getStock()-productCombination.getLockStock());
            localOverMap.put(productCombination.getId(), false);
        }
    }

    public void resetPinkProduct(Long goodsId) {
        PmsProductCombination productCombination = productCombinationMapper.selectByPrimaryKey(goodsId);

        //查询已经秒杀的订单

        //实际redis中的库存
        int stock = productCombination.getStock() -productCombination.getLockStock();
        redisService.set(GoodsKey.getKillGoodsStock, ""+productCombination.getId(), stock);
        if (stock > 0) {
            localOverMap.put(productCombination.getId(), false);
        }else {
            localOverMap.put(productCombination.getId(), true);
        }

    }

    //安全优化1：隐藏团购接口，实现防刷。
    @AccessLimit(seconds=5, maxCount=5, needLogin=true)//安全优化3：自定义注解，限流防刷
    @RequestMapping(value = "/pink/path",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult killPath(@RequestParam("goodsId")long goodsId) {
        String path = pinkService.createPinkPath(goodsId);
        Map map = new HashMap();
        map.put("path",path);
        return CommonResult.success(map);
    }
    // 接口优化5：客户端轮询，是否团购成功。
    @PostMapping(value = "/{path}/pink")
    @ResponseBody
    public CommonResult pink(@RequestParam("goodsId")Long goodsId, @PathVariable("path") String path,
                             @RequestParam("pinkType")  Integer pinkType, @RequestParam(value = "pinkId", required = false)  Long pinkId) throws Exception {
        //验证path
        boolean check = pinkService.checkPath(goodsId, path);
        if (!check) {
            return CommonResult.failed("path参数错误");
        }
        //        //内存标记，减少redis访问
        boolean over = localOverMap.get(goodsId);
        if (over) {
            return CommonResult.failed("商品团购光了");
        }
        //预减库存
        long stock = redisService.decr(GoodsKey.getPinkGoodsStock, "" + goodsId, 1);//10
        if (stock < 0) {
            localOverMap.put(goodsId, true);
            return CommonResult.failed("商品团购光了");
        }
        // 判断是否能进行下单
        UmsMember member = memberService.getCurrentMember();
        int state = pinkService.canPinkGoods(member.getId(),goodsId);
        if (state != 0) {
            return CommonResult.failed("不能拼团该商品");
        }
        //入队
        PinkMessage mm = new PinkMessage();
        mm.setUserId(memberService.getCurrentMember().getId());
        mm.setGoodsId(goodsId);
        mm.setPinkType(pinkType);
        mm.setPinkId(pinkId);
        sender.sendMessage(mm);
        return CommonResult.success("排队中");
    }

    /**
     * orderId：成功
     * -1：团购失败
     * 0： 排队中
     * */

    @ApiOperation("拼团商品详情")
    @RequestMapping(value = "/pink/detail/{id}", method = RequestMethod.GET)
    @AnonymousAccess
    @ResponseBody
    public CommonResult pinkContent(@PathVariable Long id)throws Exception {
        PromotionPinkProduct pinkProduct = productService.getPinkProductDetail(id);
        return CommonResult.success(pinkProduct);
    }

    @ApiOperation("拼团详情")

    @RequestMapping(value = "/pink/info/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult pinkInfoContent(@PathVariable Long id)throws Exception {
        Object object = productService.getPinkProductInfo(id);
        return CommonResult.success(object);
    }
    // 接口优化5：客户端轮询，是否秒杀成功。
    /**
     * orderId：成功
     * -1：秒杀失败
     * 0： 排队中
     * */

    @RequestMapping(value="/pinkResult", method= RequestMethod.POST)
    @ResponseBody
    public CommonResult killResult(
            @RequestParam("goodsId")long goodsId) {
        Long userId = memberService.getCurrentMember().getId();
        Object res = pinkService.getPinkResult(userId,goodsId);
        return CommonResult.success(res);
    }

}
