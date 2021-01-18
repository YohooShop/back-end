package com.yoooho.mall.dao;

import com.yoooho.mall.domain.OmsOrderDetail;
import com.yoooho.mall.model.OmsOrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 前台订单自定义Dao
 */
public interface PortalOrderDao {
    /**
     * 获取订单及下单商品详情
     */
    OmsOrderDetail getDetail(@Param("orderId") Long orderId);

   List <OmsOrderDetail> getKillOrdersByMemberId(@Param("killId") Long killId, @Param("memberId") Long memberId);
    /**
     * 修改 pms_sku_stock表的锁定库存及真实库存
     */
    int updateSkuStock(@Param("itemList") List<OmsOrderItem> orderItemList);


    /**
     * 更新已买的数据
     * */

    int updateSaleCount(@Param("itemList") List<OmsOrderItem> orderItemList);


    /**
     * 获取超时订单
     * @param minute 超时时间（分）
     */
    List<OmsOrderDetail> getTimeOutOrders(@Param("minute") Integer minute,@Param("orderType") Integer orderType);

    /**
     * 批量修改订单状态
     */
    int updateOrderStatus(@Param("ids") List<Long> ids,@Param("status") Integer status);

    /**
     * 解除取消订单的库存锁定
     */
    int releaseSkuStockLock(@Param("itemList") List<OmsOrderItem> orderItemList);



}
