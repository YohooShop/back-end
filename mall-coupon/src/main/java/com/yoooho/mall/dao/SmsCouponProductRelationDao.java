package com.yoooho.mall.dao;

import com.yoooho.mall.model.SmsCouponProductRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 优惠券和产品关系自定义Dao
 * Created by yoooho on 2019/8/28.
 */
public interface SmsCouponProductRelationDao {
    int insertList(@Param("list")List<SmsCouponProductRelation> productRelationList);
}
