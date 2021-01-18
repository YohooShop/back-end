package com.yoooho.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 订单发货参数
 * Created by yoooho on 2019/10/12.
 */
@Getter
@Setter
public class OmsOrderDeliveryParam {
    @ApiModelProperty("订单id")
    private Long orderId;
    @ApiModelProperty("物流公司")
    private String deliveryCompany;
    @ApiModelProperty("物流公司编号")
    private String deliveryCode;
    @ApiModelProperty("物流单号")
    private String deliverySn;
    @ApiModelProperty("发件人姓名")
    private String senderName;
    @ApiModelProperty("发件城市")
    private String senderCity;
    @ApiModelProperty("发件地区")
    private String senderRegion;
    @ApiModelProperty("发件地址详情")
    private String senderDetailAddress;
    @ApiModelProperty("发件电话")
    private String senderTel;
    @ApiModelProperty("发件省份")
    private String senderProvince;
    @ApiModelProperty("是否在线下单，0不是，1是")
    private int  onLineStatus;
    @ApiModelProperty("付款方式，现付，到付，月结，第三方")
    private String payType;
    @ApiModelProperty("快件类型，标准快件")
    private String expType;
    @ApiModelProperty("商品名称")
    private String commodityName;
}
