package com.yoooho.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class WxOfficialAccountConfig implements Serializable {
    private Long id;

    private String appid;

    private String appsecret;

    private String token;

    private String encodingaeskey;

    private String api;

    private String shareTitle;

    private String shareSynopsis;

    private String shareImg;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getAppsecret() {
        return appsecret;
    }

    public void setAppsecret(String appsecret) {
        this.appsecret = appsecret;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEncodingaeskey() {
        return encodingaeskey;
    }

    public void setEncodingaeskey(String encodingaeskey) {
        this.encodingaeskey = encodingaeskey;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public String getShareTitle() {
        return shareTitle;
    }

    public void setShareTitle(String shareTitle) {
        this.shareTitle = shareTitle;
    }

    public String getShareSynopsis() {
        return shareSynopsis;
    }

    public void setShareSynopsis(String shareSynopsis) {
        this.shareSynopsis = shareSynopsis;
    }

    public String getShareImg() {
        return shareImg;
    }

    public void setShareImg(String shareImg) {
        this.shareImg = shareImg;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", appid=").append(appid);
        sb.append(", appsecret=").append(appsecret);
        sb.append(", token=").append(token);
        sb.append(", encodingaeskey=").append(encodingaeskey);
        sb.append(", api=").append(api);
        sb.append(", shareTitle=").append(shareTitle);
        sb.append(", shareSynopsis=").append(shareSynopsis);
        sb.append(", shareImg=").append(shareImg);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}