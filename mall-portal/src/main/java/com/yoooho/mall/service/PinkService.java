package com.yoooho.mall.service;

import com.yoooho.mall.common.CommonResult;

public interface PinkService {
   String createPinkPath(Long goodsId);
   boolean checkPath(long goodsId, String path);
   public int canPinkGoods(Long userId, Long goodsId) throws Exception;
   public boolean canNewPink(Long goodId);
   public boolean canPink(Long pinkId);
   void cancelPink(Long id);
   CommonResult cancelTimeOutPink();

   public Object getPinkResult(Long userId, long goodsId);


   public Object minePink(Integer type, Integer page,  Integer size);
}
