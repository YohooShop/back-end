package com.yoooho.mall.service;

import com.yoooho.mall.domain.OmsOrderReturnApplyParam;

/**
 * 订单退货管理Service
 * Created by yoooho on 2019/10/17.
 */
public interface OmsPortalOrderReturnApplyService {
    /**
     * 提交申请
     */
    int create(OmsOrderReturnApplyParam returnApply);
}
