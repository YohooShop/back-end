package com.yoooho.mall.dao;

import com.yoooho.mall.dto.OmsOrderReturnApplyResult;
import com.yoooho.mall.dto.OmsReturnApplyQueryParam;
import com.yoooho.mall.model.OmsOrderReturnApply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单退货申请自定义Dao
 * Created by yoooho on 2019/10/18.
 */
public interface OmsOrderReturnApplyDao {
    /**
     * 查询申请列表
     */
    List<OmsOrderReturnApply> getList(@Param("queryParam") OmsReturnApplyQueryParam queryParam);

    /**
     * 获取申请详情
     */
    OmsOrderReturnApplyResult getDetail(@Param("id")Long id);
}
