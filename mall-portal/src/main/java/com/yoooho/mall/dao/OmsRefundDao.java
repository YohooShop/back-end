package com.yoooho.mall.dao;


import com.yoooho.mall.dto.OmsRefundResult;
import com.yoooho.mall.model.OmsOrderRefund;

import java.util.List;

public interface OmsRefundDao {

    List<OmsOrderRefund>getList(Long member_id);

    List<OmsRefundResult> getDetail(Long id);
}
