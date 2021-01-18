package com.yoooho.mall.vo;

import lombok.Data;

@Data
public class ExpressParam {
    //@NotBlank()
    private String orderCode;
    //快递公司编码
    private String shipperCode;
    //物流单号
    private String logisticCode;
}
