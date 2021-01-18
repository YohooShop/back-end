package com.yoooho.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class WechatMsg implements Serializable {
    private Long id;

    @ApiModelProperty(value = "微信用户ID")
    private String openid;

    @ApiModelProperty(value = "消息方向")
    private Byte inOut;

    @ApiModelProperty(value = "消息类型")
    private String msgType;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    private String detail;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Byte getInOut() {
        return inOut;
    }

    public void setInOut(Byte inOut) {
        this.inOut = inOut;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", openid=").append(openid);
        sb.append(", inOut=").append(inOut);
        sb.append(", msgType=").append(msgType);
        sb.append(", createTime=").append(createTime);
        sb.append(", detail=").append(detail);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}