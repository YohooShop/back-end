package com.yoooho.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class SmsHomeNav implements Serializable {
    private Long id;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "链接地址")
    private String url;

    @ApiModelProperty(value = "小程序路由")
    private String mpUrl;

    @ApiModelProperty(value = "uniapp路由")
    private String uniappUrl;

    @ApiModelProperty(value = "图标地址")
    private String icon;

    @ApiModelProperty(value = "是否显示（1显示,0不显示）")
    private Integer status;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMpUrl() {
        return mpUrl;
    }

    public void setMpUrl(String mpUrl) {
        this.mpUrl = mpUrl;
    }

    public String getUniappUrl() {
        return uniappUrl;
    }

    public void setUniappUrl(String uniappUrl) {
        this.uniappUrl = uniappUrl;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", url=").append(url);
        sb.append(", mpUrl=").append(mpUrl);
        sb.append(", uniappUrl=").append(uniappUrl);
        sb.append(", icon=").append(icon);
        sb.append(", status=").append(status);
        sb.append(", sort=").append(sort);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}