package com.yoooho.mall.dto;

import com.yoooho.mall.model.OmsOrder;
import com.yoooho.mall.model.OmsOrderItem;
import com.yoooho.mall.model.OmsOrderOperateHistory;
import com.yoooho.mall.model.PmsStore;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 订单详情信息
 * Created by yoooho on 2019/10/11.
 */
public class OmsOrderDetail extends OmsOrder {
    @Getter
    @Setter
    private List<OmsOrderItem> orderItemList;
    @Getter
    @Setter
    private List<OmsOrderOperateHistory> historyList;
    @Getter
    @Setter
    private PmsStore store;
}
