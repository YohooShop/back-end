package com.yoooho.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class OmsLogisticOrder implements Serializable {
    private Integer id;

    private Long orderId;

    private String shipperCode;

    private String logisticCode;

    @ApiModelProperty(value = "发件人")
    private String senderName;

    @ApiModelProperty(value = "发件人电话与手机，必填一个")
    private String senderTel;

    @ApiModelProperty(value = "收件人电话与手机，必填一个")
    private String receiverTel;

    private String kdnOrderCode;

    @ApiModelProperty(value = "第三方订单号")
    private String thrOrderCode;

    @ApiModelProperty(value = "收件人")
    private String receiverName;

    @ApiModelProperty(value = "商品名称")
    private String commodityName;

    @ApiModelProperty(value = "邮费支付方式:1-现付，2-到付，3-月结，4-第三方支付(仅SF支持)")
    private String payType;

    @ApiModelProperty(value = "快递类型：1-标准快件")
    private String expType;

    @ApiModelProperty(value = "发件人电话与手机，必填一个")
    private String senderMobile;

    @ApiModelProperty(value = "收件人电话与手机，必填一个")
    private String receiverMobile;

    @ApiModelProperty(value = "发件省 (如广东省，不要缺少“省”； 如是直辖市，请直接传北京、上海等； 如是自治区，请直接传广西壮族自治区等)")
    private String senderProvince;

    @ApiModelProperty(value = "收件省 (如广东省，不要缺少“省”；如是直辖市，请直接传北京、上海等； 如是自治区，请直接传广西壮族自治区等)")
    private String receiverProvince;

    private String packageName;

    @ApiModelProperty(value = "发件市(如深圳市，不要缺少“市； 如是市辖区，请直接传北京市、上海市等”)")
    private String senderCity;

    @ApiModelProperty(value = "收件市(如深圳市，不要缺少“市”； 如果是市辖区，请直接传北京市、上海市等)")
    private String receiverCity;

    @ApiModelProperty(value = "发件区/县(如福田区，不要缺少“区”或“县”)")
    private String senderExparea;

    @ApiModelProperty(value = "收件区/县(如福田区，不要缺少“区”或“县”)")
    private String receiverExparea;

    private Date creatime;

    @ApiModelProperty(value = "订单编号")
    private String orderSn;

    private String printTemplate;

    @ApiModelProperty(value = "收件人详细地址")
    private String receiverAddress;

    @ApiModelProperty(value = "发件人详细地址")
    private String senderAddress;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getShipperCode() {
        return shipperCode;
    }

    public void setShipperCode(String shipperCode) {
        this.shipperCode = shipperCode;
    }

    public String getLogisticCode() {
        return logisticCode;
    }

    public void setLogisticCode(String logisticCode) {
        this.logisticCode = logisticCode;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderTel() {
        return senderTel;
    }

    public void setSenderTel(String senderTel) {
        this.senderTel = senderTel;
    }

    public String getReceiverTel() {
        return receiverTel;
    }

    public void setReceiverTel(String receiverTel) {
        this.receiverTel = receiverTel;
    }

    public String getKdnOrderCode() {
        return kdnOrderCode;
    }

    public void setKdnOrderCode(String kdnOrderCode) {
        this.kdnOrderCode = kdnOrderCode;
    }

    public String getThrOrderCode() {
        return thrOrderCode;
    }

    public void setThrOrderCode(String thrOrderCode) {
        this.thrOrderCode = thrOrderCode;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getExpType() {
        return expType;
    }

    public void setExpType(String expType) {
        this.expType = expType;
    }

    public String getSenderMobile() {
        return senderMobile;
    }

    public void setSenderMobile(String senderMobile) {
        this.senderMobile = senderMobile;
    }

    public String getReceiverMobile() {
        return receiverMobile;
    }

    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile;
    }

    public String getSenderProvince() {
        return senderProvince;
    }

    public void setSenderProvince(String senderProvince) {
        this.senderProvince = senderProvince;
    }

    public String getReceiverProvince() {
        return receiverProvince;
    }

    public void setReceiverProvince(String receiverProvince) {
        this.receiverProvince = receiverProvince;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getSenderCity() {
        return senderCity;
    }

    public void setSenderCity(String senderCity) {
        this.senderCity = senderCity;
    }

    public String getReceiverCity() {
        return receiverCity;
    }

    public void setReceiverCity(String receiverCity) {
        this.receiverCity = receiverCity;
    }

    public String getSenderExparea() {
        return senderExparea;
    }

    public void setSenderExparea(String senderExparea) {
        this.senderExparea = senderExparea;
    }

    public String getReceiverExparea() {
        return receiverExparea;
    }

    public void setReceiverExparea(String receiverExparea) {
        this.receiverExparea = receiverExparea;
    }

    public Date getCreatime() {
        return creatime;
    }

    public void setCreatime(Date creatime) {
        this.creatime = creatime;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public String getPrintTemplate() {
        return printTemplate;
    }

    public void setPrintTemplate(String printTemplate) {
        this.printTemplate = printTemplate;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orderId=").append(orderId);
        sb.append(", shipperCode=").append(shipperCode);
        sb.append(", logisticCode=").append(logisticCode);
        sb.append(", senderName=").append(senderName);
        sb.append(", senderTel=").append(senderTel);
        sb.append(", receiverTel=").append(receiverTel);
        sb.append(", kdnOrderCode=").append(kdnOrderCode);
        sb.append(", thrOrderCode=").append(thrOrderCode);
        sb.append(", receiverName=").append(receiverName);
        sb.append(", commodityName=").append(commodityName);
        sb.append(", payType=").append(payType);
        sb.append(", expType=").append(expType);
        sb.append(", senderMobile=").append(senderMobile);
        sb.append(", receiverMobile=").append(receiverMobile);
        sb.append(", senderProvince=").append(senderProvince);
        sb.append(", receiverProvince=").append(receiverProvince);
        sb.append(", packageName=").append(packageName);
        sb.append(", senderCity=").append(senderCity);
        sb.append(", receiverCity=").append(receiverCity);
        sb.append(", senderExparea=").append(senderExparea);
        sb.append(", receiverExparea=").append(receiverExparea);
        sb.append(", creatime=").append(creatime);
        sb.append(", orderSn=").append(orderSn);
        sb.append(", printTemplate=").append(printTemplate);
        sb.append(", receiverAddress=").append(receiverAddress);
        sb.append(", senderAddress=").append(senderAddress);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
