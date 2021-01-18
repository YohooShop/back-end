package com.yoooho.mall.service;

public interface SeckillService {
    public String createSeckillPath(long goodsId);
    public boolean checkPath( long goodsId, String path);
    public Object getKillResult(Long userId, long goodsId);
    ;

}
