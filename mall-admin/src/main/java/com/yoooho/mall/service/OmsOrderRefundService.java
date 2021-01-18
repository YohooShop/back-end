package com.yoooho.mall.service;



import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.dto.OmsRefundQueryParam;
import com.yoooho.mall.model.OmsOrderRefund;

import java.util.List;

public interface OmsOrderRefundService {
    /**
     * 查询申请列表
     */
    public List<OmsOrderRefund> list(OmsRefundQueryParam queryParam, Integer pageSize, Integer pageNum);

    public CommonResult detail(Long id);

    public int updateStatus(Long id, int status);
}
