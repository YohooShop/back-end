package com.yoooho.mall.dto;

import com.yoooho.mall.model.OmsCompanyAddress;
import com.yoooho.mall.model.OmsOrderReturnApply;
import lombok.Getter;
import lombok.Setter;

/**
 * 申请信息封装
 * Created by yoooho on 2019/10/18.
 */
public class OmsOrderReturnApplyResult extends OmsOrderReturnApply {
    @Getter
    @Setter
    private OmsCompanyAddress companyAddress;
}
