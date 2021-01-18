package com.yoooho.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;

public class OmsPinkBuyer implements Serializable {
    private Long id;

    @ApiModelProperty(value = "买家ID")
    private Long buyerId;

    @ApiModelProperty(value = "团购ID")
    private Long pinkId;

    @ApiModelProperty(value = "订单ID")
    private Long orderId;

    @ApiModelProperty(value = "团购数量")
    private Integer pinkNum;

    @ApiModelProperty(value = "团购价格")
    private BigDecimal pinkPrice;

    @ApiModelProperty(value = "团购金额")
    private BigDecimal pinkAmt;

    @ApiModelProperty(value = "状态(1完成 -0取消)")
    private Boolean pinkStatus;

    @ApiModelProperty(value = "团购时间")
    private Long pinkTime;

    @ApiModelProperty(value = "是否退款 0未退款 1已退款")
    private Boolean isRefund;

    @ApiModelProperty(value = "是否发送模板消息0未发送1已发送")
    private Boolean isTpl;

    @ApiModelProperty(value = "买家名字")
    private String buyerName;

    @ApiModelProperty(value = "买家头像")
    private String buyerIcon;

    @ApiModelProperty(value = "支付状态：0待支付， 1已支付")
    private Integer payStatus;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public Long getPinkId() {
        return pinkId;
    }

    public void setPinkId(Long pinkId) {
        this.pinkId = pinkId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getPinkNum() {
        return pinkNum;
    }

    public void setPinkNum(Integer pinkNum) {
        this.pinkNum = pinkNum;
    }

    public BigDecimal getPinkPrice() {
        return pinkPrice;
    }

    public void setPinkPrice(BigDecimal pinkPrice) {
        this.pinkPrice = pinkPrice;
    }

    public BigDecimal getPinkAmt() {
        return pinkAmt;
    }

    public void setPinkAmt(BigDecimal pinkAmt) {
        this.pinkAmt = pinkAmt;
    }

    public Boolean getPinkStatus() {
        return pinkStatus;
    }

    public void setPinkStatus(Boolean pinkStatus) {
        this.pinkStatus = pinkStatus;
    }

    public Long getPinkTime() {
        return pinkTime;
    }

    public void setPinkTime(Long pinkTime) {
        this.pinkTime = pinkTime;
    }

    public Boolean getIsRefund() {
        return isRefund;
    }

    public void setIsRefund(Boolean isRefund) {
        this.isRefund = isRefund;
    }

    public Boolean getIsTpl() {
        return isTpl;
    }

    public void setIsTpl(Boolean isTpl) {
        this.isTpl = isTpl;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerIcon() {
        return buyerIcon;
    }

    public void setBuyerIcon(String buyerIcon) {
        this.buyerIcon = buyerIcon;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", buyerId=").append(buyerId);
        sb.append(", pinkId=").append(pinkId);
        sb.append(", orderId=").append(orderId);
        sb.append(", pinkNum=").append(pinkNum);
        sb.append(", pinkPrice=").append(pinkPrice);
        sb.append(", pinkAmt=").append(pinkAmt);
        sb.append(", pinkStatus=").append(pinkStatus);
        sb.append(", pinkTime=").append(pinkTime);
        sb.append(", isRefund=").append(isRefund);
        sb.append(", isTpl=").append(isTpl);
        sb.append(", buyerName=").append(buyerName);
        sb.append(", buyerIcon=").append(buyerIcon);
        sb.append(", payStatus=").append(payStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}