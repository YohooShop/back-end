package com.yoooho.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class UmsAdminSetting implements Serializable {
    private Integer id;

    @ApiModelProperty(value = "通知发送邮件地址")
    private String notificationFormMail;

    @ApiModelProperty(value = "通知接受邮件地址")
    private String notificationToMail;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNotificationFormMail() {
        return notificationFormMail;
    }

    public void setNotificationFormMail(String notificationFormMail) {
        this.notificationFormMail = notificationFormMail;
    }

    public String getNotificationToMail() {
        return notificationToMail;
    }

    public void setNotificationToMail(String notificationToMail) {
        this.notificationToMail = notificationToMail;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", notificationFormMail=").append(notificationFormMail);
        sb.append(", notificationToMail=").append(notificationToMail);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}