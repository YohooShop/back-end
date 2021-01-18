package com.yoooho.mall.service;

import com.yoooho.mall.dto.PmsProductKillQueryParam;
import com.yoooho.mall.dto.PmsProductSeckillParam;
import com.yoooho.mall.model.PmsProductSeckill;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;


public interface PmsProductSeckillService {

    public int addSeckillProduct(PmsProductSeckillParam pmsProductSeckillParam);

    public Map<String,Object> list(PmsProductKillQueryParam queryParam, Pageable pageable);

    /**
     * 分页查询商品
     */
    List<PmsProductSeckill> list(PmsProductKillQueryParam queryParam, Integer pageSize, Integer pageNum);

    public void  update(PmsProductSeckillParam pmsProductSeckillParam);

    public PmsProductSeckill  getInfo(Long id);

    public int delect(Long id);
}
