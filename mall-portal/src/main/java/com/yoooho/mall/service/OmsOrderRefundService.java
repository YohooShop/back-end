package com.yoooho.mall.service;

import com.yoooho.mall.common.CommonResult;

public interface OmsOrderRefundService {

    /**
     * 申请退款
     * */
    public CommonResult applyRefund(Long orderId, String reason , Long userId);

    public CommonResult applyRefundList(int pages, int size);
}
