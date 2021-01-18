package com.yoooho.mall.dao;

import com.yoooho.mall.domain.SmsCouponHistoryDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 会员优惠券领取历史自定义Dao
 * Created by yoooho on 2019/8/29.
 */
public interface SmsCouponHistoryDao {
    List<SmsCouponHistoryDetail> getDetailList(@Param("memberId") Long memberId);

    List<SmsCouponHistoryDetail> selectUsedUserCoupon(@Param("memberId") Long memberId);
    List<SmsCouponHistoryDetail> selectEnableUseUserCoupon(@Param("memberId") Long memberId);
    List<SmsCouponHistoryDetail> selecteExpiredUserCoupon(@Param("memberId") Long memberId);

}
