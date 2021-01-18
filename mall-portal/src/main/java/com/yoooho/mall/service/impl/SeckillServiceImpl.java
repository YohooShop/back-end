package com.yoooho.mall.service.impl;

import com.yoooho.mall.common.redis.SeckillKey;
import com.yoooho.mall.model.OmsOrder;
import com.yoooho.mall.service.OmsPortalOrderService;
import com.yoooho.mall.service.RedisService;
import com.yoooho.mall.service.SeckillService;
import com.yoooho.mall.service.UmsMemberService;
import com.yoooho.mall.util.MD5Util;
import com.yoooho.mall.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeckillServiceImpl implements SeckillService {

    @Autowired
    RedisService redisService;
    @Autowired
    UmsMemberService memberService;
    @Autowired
    OmsPortalOrderService portalOrderService;
    @Override
    public String createSeckillPath(long goodsId) {
        if (goodsId <=0){
            return  null;
        }
        String str = MD5Util.md5(UUIDUtil.uuid()+"123456");
        redisService.set(SeckillKey.getSeckillPath,""+memberService.getCurrentMember().getId()+"_"+goodsId,str);
        return str;
    }

    @Override
    public boolean checkPath(long goodsId, String path) {
        if(path == null) {
            return false;
        }
        Long  userId = memberService.getCurrentMember().getId();
        String pathOld = redisService.get(SeckillKey.getSeckillPath, ""+userId + "_"+ goodsId,  String.class);
        return path.equals(pathOld);
    }

    public Object getKillResult(Long userId, long goodsId) {
       OmsOrder omsOrder = portalOrderService.getKillOrderByUserIdGoodsId(userId, goodsId);
        if(omsOrder != null) {//秒杀成功
            return omsOrder.getId();
        }else {
            boolean isOver = getkillOver(goodsId);
            if(isOver) {
                return -1;
            }else {
                return 0;
            }
        }
    }
    private boolean getkillOver(long goodsId) {
        return redisService.exists(SeckillKey.isGoodsOver, ""+goodsId);
    }

}
