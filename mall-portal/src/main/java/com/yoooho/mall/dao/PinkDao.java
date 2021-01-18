package com.yoooho.mall.dao;

import com.yoooho.mall.domain.OmsPinkBuyerDetail;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface PinkDao {
    /**
     * 获取超时的拼团
     */
    List<OmsPinkBuyerDetail> getTimeOutPinks();
    List<OmsPinkBuyerDetail> selectPink(@Param("userId") Long userId,@Param("status") Integer status);
}
