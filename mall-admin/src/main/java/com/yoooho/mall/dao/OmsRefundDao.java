package com.yoooho.mall.dao;

import com.yoooho.mall.dto.OmsRefundQueryParam;
import com.yoooho.mall.dto.OmsRefundResult;
import com.yoooho.mall.model.OmsOrderRefund;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OmsRefundDao {

    List<OmsOrderRefund>getList(@Param("queryParam") OmsRefundQueryParam queryParam);

    List<OmsRefundResult> getDetail(Long id);
}
