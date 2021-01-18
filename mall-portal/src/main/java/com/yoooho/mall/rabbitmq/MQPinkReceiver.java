package com.yoooho.mall.rabbitmq;

import com.yoooho.mall.domain.PinkOrderParam;
import com.yoooho.mall.mapper.PmsProductCombinationMapper;
import com.yoooho.mall.model.PmsProductCombination;
import com.yoooho.mall.model.UmsMember;
import com.yoooho.mall.service.OmsPortalOrderService;
import com.yoooho.mall.service.PinkService;
import com.yoooho.mall.service.RedisService;
import com.yoooho.mall.service.UmsMemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MQPinkReceiver {
    private static Logger log = LoggerFactory.getLogger(MQSeckillReceiver.class);
    @Autowired
    RedisService redisService;
    @Autowired
    OmsPortalOrderService orderService;

    @Autowired
    PmsProductCombinationMapper productCombinationMapper;

    @Autowired
    UmsMemberService memberService;

    @Autowired
    PinkService pinkService;

    //接口优化4：请求出队
    @RabbitListener(queues=MQPinkConfig.PINK_QUEUE)
    public void miaoshaReceive(String message) {
        log.info("receive message:"+message);
        PinkMessage mm = redisService.stringToBean(message, PinkMessage.class);
        PmsProductCombination productCombination = productCombinationMapper.selectByPrimaryKey(mm.getGoodsId());
        if (productCombination == null) {
            return;
        }
        int stock = productCombination.getStock()-productCombination.getLockStock();
        if (stock <=0) {
            return;
        }

        // 判断是否能进行下单
        UmsMember member = memberService.getCurrentMember();
        int state = 0;
        try {
            state = pinkService.canPinkGoods(member.getId(),mm.getGoodsId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (state != 0) {
            return;
        }

        PinkOrderParam orderParam = new PinkOrderParam();
        orderParam.setId(mm.getGoodsId());
        orderParam.setPinkType(mm.getPinkType());
        orderParam.setUserId(mm.getUserId());
        orderParam.setPinkId(mm.getPinkId());
        orderService.generatePinkOrder(orderParam);
    }
}
