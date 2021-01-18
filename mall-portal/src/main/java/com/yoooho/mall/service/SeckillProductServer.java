package com.yoooho.mall.service;

import com.yoooho.mall.domain.HomeFlashPromotion;
import com.yoooho.mall.domain.PromotionKillProduct;
import com.yoooho.mall.model.PmsProductSeckill;

import java.util.List;

public interface SeckillProductServer {
    public PromotionKillProduct getKillProductDetail(Long id) throws  Exception;
    public PmsProductSeckill getKillProduct(Long id) throws Exception;
    public List<PmsProductSeckill> listKillGoods();

    /***
     * 判断商品是否在秒杀中
     */
    public boolean killProductIsKilling (Long id, Long userId) throws Exception;



    public List getKillSence();

    public HomeFlashPromotion killSenceDetailContent(Long id);
}
