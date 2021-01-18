package com.yoooho.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class OmsLogistic implements Serializable {
    private Integer id;

    @ApiModelProperty(value = "订单id")
    private Integer orderId;

    private String ebusinessid;

    private String ordercode;

    private String logisticcode;

    private Integer shippercode;

    private String traces;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getEbusinessid() {
        return ebusinessid;
    }

    public void setEbusinessid(String ebusinessid) {
        this.ebusinessid = ebusinessid;
    }

    public String getOrdercode() {
        return ordercode;
    }

    public void setOrdercode(String ordercode) {
        this.ordercode = ordercode;
    }

    public String getLogisticcode() {
        return logisticcode;
    }

    public void setLogisticcode(String logisticcode) {
        this.logisticcode = logisticcode;
    }

    public Integer getShippercode() {
        return shippercode;
    }

    public void setShippercode(Integer shippercode) {
        this.shippercode = shippercode;
    }

    public String getTraces() {
        return traces;
    }

    public void setTraces(String traces) {
        this.traces = traces;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orderId=").append(orderId);
        sb.append(", ebusinessid=").append(ebusinessid);
        sb.append(", ordercode=").append(ordercode);
        sb.append(", logisticcode=").append(logisticcode);
        sb.append(", shippercode=").append(shippercode);
        sb.append(", traces=").append(traces);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}