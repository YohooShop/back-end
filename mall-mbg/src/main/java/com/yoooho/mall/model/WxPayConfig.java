package com.yoooho.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class WxPayConfig implements Serializable {
    private Integer id;

    @ApiModelProperty(value = "支付appId")
    private String appId;

    @ApiModelProperty(value = "商户秘钥")
    private String mchKey;

    @ApiModelProperty(value = "商户id")
    private String mchId;

    @ApiModelProperty(value = "证书地址")
    private String keyPath;

    @ApiModelProperty(value = "h5通知地址")
    private String notifyUrlH5;

    private String refundNotifyUrl;

    private String spbillCreateIp;

    @ApiModelProperty(value = "app通知地址")
    private String notifyUrlApp;

    @ApiModelProperty(value = "小程序通知地址")
    private String notifyUrlSp;

    @ApiModelProperty(value = "微信公众号通知地址")
    private String notifyUrlJs;

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

    public String getMchKey() {
        return mchKey;
    }

    public void setMchKey(String mchKey) {
        this.mchKey = mchKey;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getKeyPath() {
        return keyPath;
    }

    public void setKeyPath(String keyPath) {
        this.keyPath = keyPath;
    }

    public String getNotifyUrlH5() {
        return notifyUrlH5;
    }

    public void setNotifyUrlH5(String notifyUrlH5) {
        this.notifyUrlH5 = notifyUrlH5;
    }

    public String getRefundNotifyUrl() {
        return refundNotifyUrl;
    }

    public void setRefundNotifyUrl(String refundNotifyUrl) {
        this.refundNotifyUrl = refundNotifyUrl;
    }

    public String getSpbillCreateIp() {
        return spbillCreateIp;
    }

    public void setSpbillCreateIp(String spbillCreateIp) {
        this.spbillCreateIp = spbillCreateIp;
    }

    public String getNotifyUrlApp() {
        return notifyUrlApp;
    }

    public void setNotifyUrlApp(String notifyUrlApp) {
        this.notifyUrlApp = notifyUrlApp;
    }

    public String getNotifyUrlSp() {
        return notifyUrlSp;
    }

    public void setNotifyUrlSp(String notifyUrlSp) {
        this.notifyUrlSp = notifyUrlSp;
    }

    public String getNotifyUrlJs() {
        return notifyUrlJs;
    }

    public void setNotifyUrlJs(String notifyUrlJs) {
        this.notifyUrlJs = notifyUrlJs;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", appId=").append(appId);
        sb.append(", mchKey=").append(mchKey);
        sb.append(", mchId=").append(mchId);
        sb.append(", keyPath=").append(keyPath);
        sb.append(", notifyUrlH5=").append(notifyUrlH5);
        sb.append(", refundNotifyUrl=").append(refundNotifyUrl);
        sb.append(", spbillCreateIp=").append(spbillCreateIp);
        sb.append(", notifyUrlApp=").append(notifyUrlApp);
        sb.append(", notifyUrlSp=").append(notifyUrlSp);
        sb.append(", notifyUrlJs=").append(notifyUrlJs);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}