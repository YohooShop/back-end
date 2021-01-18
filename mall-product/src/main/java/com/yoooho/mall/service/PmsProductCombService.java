package com.yoooho.mall.service;

import com.yoooho.mall.dto.PmsProductCombParam;
import com.yoooho.mall.dto.PmsProductCombQueryParam;
import com.yoooho.mall.model.PmsProductCombination;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface PmsProductCombService {

    public int addSeckillProduct(PmsProductCombParam pmsProductCombParam);

    public Map<String,Object> list(PmsProductCombQueryParam queryParam, Pageable pageable);

    public List<PmsProductCombination> list(PmsProductCombQueryParam queryParam, Integer pageSize, Integer pageNum);
    public void  update(PmsProductCombParam pmsProductCombParam);

    public  void updateStatus( Long id, boolean isShow);
    public PmsProductCombination getInfo(Long id);

    public int delect(Long id);
}
