package com.yoooho.mall.domain;

import com.yoooho.mall.model.PmsProductSeckill;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * 首页当前秒杀场次信息
 * Created by yoooho on 2019/1/28.
 */
@Getter
@Setter
public class HomeFlashPromotion {
    private Date startTime;
    private Date endTime;
    private Date nextStartTime;
    private Date nextEndTime;
    //属于该秒杀活动的商品
    private List<PmsProductSeckill> productList;
}
