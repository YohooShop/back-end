package com.yoooho.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class AlipayConfig implements Serializable {
    private Integer id;

    @ApiModelProperty(value = "应用ID")
    private String appId;

    @ApiModelProperty(value = "编码")
    private String charset;

    @ApiModelProperty(value = "类型 固定格式json")
    private String format;

    @ApiModelProperty(value = "网关地址")
    private String gatewayUrl;

    @ApiModelProperty(value = "异步回调")
    private String notifyUrl;

    @ApiModelProperty(value = "回调地址")
    private String returnUrl;

    @ApiModelProperty(value = "签名方式")
    private String signType;

    @ApiModelProperty(value = "商户号")
    private String sysServiceProviderId;

    private String inputCharset;

    @ApiModelProperty(value = "私钥")
    private String privateKey;

    @ApiModelProperty(value = "支付宝公钥")
    private String publicKey;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getGatewayUrl() {
        return gatewayUrl;
    }

    public void setGatewayUrl(String gatewayUrl) {
        this.gatewayUrl = gatewayUrl;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getSysServiceProviderId() {
        return sysServiceProviderId;
    }

    public void setSysServiceProviderId(String sysServiceProviderId) {
        this.sysServiceProviderId = sysServiceProviderId;
    }

    public String getInputCharset() {
        return inputCharset;
    }

    public void setInputCharset(String inputCharset) {
        this.inputCharset = inputCharset;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", appId=").append(appId);
        sb.append(", charset=").append(charset);
        sb.append(", format=").append(format);
        sb.append(", gatewayUrl=").append(gatewayUrl);
        sb.append(", notifyUrl=").append(notifyUrl);
        sb.append(", returnUrl=").append(returnUrl);
        sb.append(", signType=").append(signType);
        sb.append(", sysServiceProviderId=").append(sysServiceProviderId);
        sb.append(", inputCharset=").append(inputCharset);
        sb.append(", privateKey=").append(privateKey);
        sb.append(", publicKey=").append(publicKey);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}