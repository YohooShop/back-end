package com.yoooho.mall.dao;

import com.yoooho.mall.model.OmsOrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单商品信息自定义Dao
 * Created by yoooho on 2019/9/3.
 */
public interface PortalOrderItemDao {
    int insertList(@Param("list") List<OmsOrderItem> list);

    List selectList(@Param("orderId") Long orderId);
}
