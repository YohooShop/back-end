package com.yoooho.mall.dao;

import com.yoooho.mall.dto.OmsOrderDeliveryParam;
import com.yoooho.mall.dto.OmsOrderDetail;
import com.yoooho.mall.dto.OmsOrderQueryParam;
import com.yoooho.mall.model.OmsOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单自定义查询Dao
 * Created by yoooho on 2019/10/12.
 */
public interface OmsOrderDao {
    /**
     * 条件查询订单
     */
    List<OmsOrder> getList(@Param("queryParam") OmsOrderQueryParam queryParam);

    /**
     * 批量发货
     */
    int delivery(@Param("list") List<OmsOrderDeliveryParam> deliveryParamList);

    /**
     * 获取订单详情
     */
    OmsOrderDetail getDetail(@Param("id") Long id);
    OmsOrderDetail  getDetailByOrderSn(@Param("orderSn") String orderSn);
    List selectOrderCountAndOrderAmount(@Param("beginTime") String beginTime, @Param("endTime")String endTime);
}
