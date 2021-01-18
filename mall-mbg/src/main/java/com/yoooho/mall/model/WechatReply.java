package com.yoooho.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class WechatReply implements Serializable {
    private Long id;

    @ApiModelProperty(value = "关键字")
    private String matchValue;

    @ApiModelProperty(value = "回复类型")
    private String replyType;

    @ApiModelProperty(value = "回复数据")
    private String replyContent;

    @ApiModelProperty(value = "0=不可用  1 =可用")
    private Integer status;

    @ApiModelProperty(value = "是否隐藏")
    private Integer hide;

    @ApiModelProperty(value = "规则名称")
    private String ruleName;

    @ApiModelProperty(value = "是否精确匹配")
    private Integer exactMatch;

    @ApiModelProperty(value = "备注说明")
    private String desc;

    @ApiModelProperty(value = "生效起始时间")
    private Date effectTimeStart;

    @ApiModelProperty(value = "生效结束时间")
    private Date effectTimeEnd;

    @ApiModelProperty(value = "规则优先级")
    private Date updateTime;

    @ApiModelProperty(value = "修改时间")
    private Integer priority;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatchValue() {
        return matchValue;
    }

    public void setMatchValue(String matchValue) {
        this.matchValue = matchValue;
    }

    public String getReplyType() {
        return replyType;
    }

    public void setReplyType(String replyType) {
        this.replyType = replyType;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getHide() {
        return hide;
    }

    public void setHide(Integer hide) {
        this.hide = hide;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public Integer getExactMatch() {
        return exactMatch;
    }

    public void setExactMatch(Integer exactMatch) {
        this.exactMatch = exactMatch;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getEffectTimeStart() {
        return effectTimeStart;
    }

    public void setEffectTimeStart(Date effectTimeStart) {
        this.effectTimeStart = effectTimeStart;
    }

    public Date getEffectTimeEnd() {
        return effectTimeEnd;
    }

    public void setEffectTimeEnd(Date effectTimeEnd) {
        this.effectTimeEnd = effectTimeEnd;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", matchValue=").append(matchValue);
        sb.append(", replyType=").append(replyType);
        sb.append(", replyContent=").append(replyContent);
        sb.append(", status=").append(status);
        sb.append(", hide=").append(hide);
        sb.append(", ruleName=").append(ruleName);
        sb.append(", exactMatch=").append(exactMatch);
        sb.append(", desc=").append(desc);
        sb.append(", effectTimeStart=").append(effectTimeStart);
        sb.append(", effectTimeEnd=").append(effectTimeEnd);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", priority=").append(priority);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}