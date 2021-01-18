package com.yoooho.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class WechatTemplate implements Serializable {
    @ApiModelProperty(value = "模板id")
    private Long id;

    @ApiModelProperty(value = "模板编号")
    private String tempkey;

    @ApiModelProperty(value = "模板名")
    private String name;

    @ApiModelProperty(value = "模板ID")
    private String tempid;

    @ApiModelProperty(value = "添加时间")
    private String addTime;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "模板内容")
    private String content;

    private String openUrl;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTempkey() {
        return tempkey;
    }

    public void setTempkey(String tempkey) {
        this.tempkey = tempkey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTempid() {
        return tempid;
    }

    public void setTempid(String tempid) {
        this.tempid = tempid;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOpenUrl() {
        return openUrl;
    }

    public void setOpenUrl(String openUrl) {
        this.openUrl = openUrl;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", tempkey=").append(tempkey);
        sb.append(", name=").append(name);
        sb.append(", tempid=").append(tempid);
        sb.append(", addTime=").append(addTime);
        sb.append(", status=").append(status);
        sb.append(", content=").append(content);
        sb.append(", openUrl=").append(openUrl);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}