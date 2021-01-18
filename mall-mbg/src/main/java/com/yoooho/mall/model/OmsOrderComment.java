package com.yoooho.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class OmsOrderComment implements Serializable {
    @ApiModelProperty(value = "评论ID")
    private Long id;

    @ApiModelProperty(value = "用户ID")
    private Long uid;

    @ApiModelProperty(value = "订单ID")
    private Long oid;

    @ApiModelProperty(value = "唯一id")
    private String unique;

    @ApiModelProperty(value = "产品id")
    private Long productId;

    @ApiModelProperty(value = "某种商品类型(普通商品、秒杀商品")
    private Integer replyType;

    @ApiModelProperty(value = "商品分数")
    private Boolean productScore;

    @ApiModelProperty(value = "服务分数")
    private Boolean serviceScore;

    @ApiModelProperty(value = "评论内容")
    private String comment;

    @ApiModelProperty(value = "评论时间")
    private Date addTime;

    @ApiModelProperty(value = "管理员回复内容")
    private String merchantReplyContent;

    @ApiModelProperty(value = "管理员回复时间")
    private Date merchantReplyTime;

    @ApiModelProperty(value = "0未删除1已删除")
    private Boolean isDel;

    @ApiModelProperty(value = "0未回复1已回复")
    private Boolean isReply;

    @ApiModelProperty(value = "评论图片")
    private String pics;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public String getUnique() {
        return unique;
    }

    public void setUnique(String unique) {
        this.unique = unique;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getReplyType() {
        return replyType;
    }

    public void setReplyType(Integer replyType) {
        this.replyType = replyType;
    }

    public Boolean getProductScore() {
        return productScore;
    }

    public void setProductScore(Boolean productScore) {
        this.productScore = productScore;
    }

    public Boolean getServiceScore() {
        return serviceScore;
    }

    public void setServiceScore(Boolean serviceScore) {
        this.serviceScore = serviceScore;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getMerchantReplyContent() {
        return merchantReplyContent;
    }

    public void setMerchantReplyContent(String merchantReplyContent) {
        this.merchantReplyContent = merchantReplyContent;
    }

    public Date getMerchantReplyTime() {
        return merchantReplyTime;
    }

    public void setMerchantReplyTime(Date merchantReplyTime) {
        this.merchantReplyTime = merchantReplyTime;
    }

    public Boolean getIsDel() {
        return isDel;
    }

    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
    }

    public Boolean getIsReply() {
        return isReply;
    }

    public void setIsReply(Boolean isReply) {
        this.isReply = isReply;
    }

    public String getPics() {
        return pics;
    }

    public void setPics(String pics) {
        this.pics = pics;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", uid=").append(uid);
        sb.append(", oid=").append(oid);
        sb.append(", unique=").append(unique);
        sb.append(", productId=").append(productId);
        sb.append(", replyType=").append(replyType);
        sb.append(", productScore=").append(productScore);
        sb.append(", serviceScore=").append(serviceScore);
        sb.append(", comment=").append(comment);
        sb.append(", addTime=").append(addTime);
        sb.append(", merchantReplyContent=").append(merchantReplyContent);
        sb.append(", merchantReplyTime=").append(merchantReplyTime);
        sb.append(", isDel=").append(isDel);
        sb.append(", isReply=").append(isReply);
        sb.append(", pics=").append(pics);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}