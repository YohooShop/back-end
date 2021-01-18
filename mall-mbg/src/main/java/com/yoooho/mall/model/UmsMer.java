package com.yoooho.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class UmsMer implements Serializable {
    private Long id;

    @ApiModelProperty(value = "商户所在省")
    private String province;

    @ApiModelProperty(value = "商户所在市")
    private String city;

    @ApiModelProperty(value = "商户所在区")
    private String district;

    @ApiModelProperty(value = "商户详细地址")
    private String address;

    @ApiModelProperty(value = "商户电话")
    private String merchantName;

    @ApiModelProperty(value = "添加时间")
    private Date addTime;

    @ApiModelProperty(value = "审核时间")
    private Date applyTime;

    @ApiModelProperty(value = "通过时间")
    private Date successTime;

    @ApiModelProperty(value = "未通过原因")
    private String failMessage;

    @ApiModelProperty(value = "未通过时间")
    private Date failTime;

    @ApiModelProperty(value = "-1 审核未通过 0未审核 1审核通过")
    private Boolean status;

    @ApiModelProperty(value = "0 = 开启 1= 关闭")
    private Byte isLock;

    @ApiModelProperty(value = "是否删除")
    private String isDel;

    @ApiModelProperty(value = "头像")
    private String icon;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Date getSuccessTime() {
        return successTime;
    }

    public void setSuccessTime(Date successTime) {
        this.successTime = successTime;
    }

    public String getFailMessage() {
        return failMessage;
    }

    public void setFailMessage(String failMessage) {
        this.failMessage = failMessage;
    }

    public Date getFailTime() {
        return failTime;
    }

    public void setFailTime(Date failTime) {
        this.failTime = failTime;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Byte getIsLock() {
        return isLock;
    }

    public void setIsLock(Byte isLock) {
        this.isLock = isLock;
    }

    public String getIsDel() {
        return isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", district=").append(district);
        sb.append(", address=").append(address);
        sb.append(", merchantName=").append(merchantName);
        sb.append(", addTime=").append(addTime);
        sb.append(", applyTime=").append(applyTime);
        sb.append(", successTime=").append(successTime);
        sb.append(", failMessage=").append(failMessage);
        sb.append(", failTime=").append(failTime);
        sb.append(", status=").append(status);
        sb.append(", isLock=").append(isLock);
        sb.append(", isDel=").append(isDel);
        sb.append(", icon=").append(icon);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
