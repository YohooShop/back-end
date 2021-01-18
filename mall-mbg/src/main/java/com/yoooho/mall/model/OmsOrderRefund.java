package com.yoooho.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OmsOrderRefund implements Serializable {
    private Long id;

    private Long orderId;

    private String orderSn;

    private Date createTime;

    private String memberUsername;

    @ApiModelProperty(value = "0->未退款；1->退款中；2->已退款；3-已取消")
    private Integer status;

    private Date handleTime;

    private String reason;

    private BigDecimal returnAmount;

    private String handleMan;

    private Long handleId;

    private String refundSn;

    private Long memberId;

    @ApiModelProperty(value = "1.线下退款，2平台退款")
    private Integer refundMode;

    @ApiModelProperty(value = "1.支付宝，2微信")
    private Integer refundRoute;

    private String outRefundNo;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getMemberUsername() {
        return memberUsername;
    }

    public void setMemberUsername(String memberUsername) {
        this.memberUsername = memberUsername;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(Date handleTime) {
        this.handleTime = handleTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public BigDecimal getReturnAmount() {
        return returnAmount;
    }

    public void setReturnAmount(BigDecimal returnAmount) {
        this.returnAmount = returnAmount;
    }

    public String getHandleMan() {
        return handleMan;
    }

    public void setHandleMan(String handleMan) {
        this.handleMan = handleMan;
    }

    public Long getHandleId() {
        return handleId;
    }

    public void setHandleId(Long handleId) {
        this.handleId = handleId;
    }

    public String getRefundSn() {
        return refundSn;
    }

    public void setRefundSn(String refundSn) {
        this.refundSn = refundSn;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Integer getRefundMode() {
        return refundMode;
    }

    public void setRefundMode(Integer refundMode) {
        this.refundMode = refundMode;
    }

    public Integer getRefundRoute() {
        return refundRoute;
    }

    public void setRefundRoute(Integer refundRoute) {
        this.refundRoute = refundRoute;
    }

    public String getOutRefundNo() {
        return outRefundNo;
    }

    public void setOutRefundNo(String outRefundNo) {
        this.outRefundNo = outRefundNo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orderId=").append(orderId);
        sb.append(", orderSn=").append(orderSn);
        sb.append(", createTime=").append(createTime);
        sb.append(", memberUsername=").append(memberUsername);
        sb.append(", status=").append(status);
        sb.append(", handleTime=").append(handleTime);
        sb.append(", reason=").append(reason);
        sb.append(", returnAmount=").append(returnAmount);
        sb.append(", handleMan=").append(handleMan);
        sb.append(", handleId=").append(handleId);
        sb.append(", refundSn=").append(refundSn);
        sb.append(", memberId=").append(memberId);
        sb.append(", refundMode=").append(refundMode);
        sb.append(", refundRoute=").append(refundRoute);
        sb.append(", outRefundNo=").append(outRefundNo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}