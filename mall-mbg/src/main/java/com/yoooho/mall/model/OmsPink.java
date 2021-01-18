package com.yoooho.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;

public class OmsPink implements Serializable {
    private Long id;

    @ApiModelProperty(value = "拼团产品id")
    private Long cid;

    @ApiModelProperty(value = "产品id")
    private Long pid;

    @ApiModelProperty(value = "拼图总人数")
    private Integer people;

    @ApiModelProperty(value = "拼团产品单价")
    private BigDecimal price;

    @ApiModelProperty(value = "开始时间")
    private Long addTime;

    @ApiModelProperty(value = "结束时间")
    private Long stopTime;

    @ApiModelProperty(value = "团长id")
    private Long kId;

    @ApiModelProperty(value = "状态0未开始，1进行中2已完成3未完成")
    private Integer status;

    @ApiModelProperty(value = "订单ID")
    private Long orderId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Integer getPeople() {
        return people;
    }

    public void setPeople(Integer people) {
        this.people = people;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getAddTime() {
        return addTime;
    }

    public void setAddTime(Long addTime) {
        this.addTime = addTime;
    }

    public Long getStopTime() {
        return stopTime;
    }

    public void setStopTime(Long stopTime) {
        this.stopTime = stopTime;
    }

    public Long getkId() {
        return kId;
    }

    public void setkId(Long kId) {
        this.kId = kId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", cid=").append(cid);
        sb.append(", pid=").append(pid);
        sb.append(", people=").append(people);
        sb.append(", price=").append(price);
        sb.append(", addTime=").append(addTime);
        sb.append(", stopTime=").append(stopTime);
        sb.append(", kId=").append(kId);
        sb.append(", status=").append(status);
        sb.append(", orderId=").append(orderId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}