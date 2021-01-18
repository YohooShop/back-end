package com.yoooho.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class SmsShopConfig implements Serializable {
    private Long id;

    @ApiModelProperty(value = "落地id")
    private Long homelandpageId;

    @ApiModelProperty(value = "是否启用首页落地配置")
    private Boolean startUsing;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHomelandpageId() {
        return homelandpageId;
    }

    public void setHomelandpageId(Long homelandpageId) {
        this.homelandpageId = homelandpageId;
    }

    public Boolean getStartUsing() {
        return startUsing;
    }

    public void setStartUsing(Boolean startUsing) {
        this.startUsing = startUsing;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", homelandpageId=").append(homelandpageId);
        sb.append(", startUsing=").append(startUsing);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}