package com.yoooho.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class WechatArticle implements Serializable {
    private Integer id;

    @ApiModelProperty(value = "分类id")
    private String cid;

    @ApiModelProperty(value = "文章标题")
    private String title;

    @ApiModelProperty(value = "文章作者")
    private String author;

    @ApiModelProperty(value = "文章图片")
    private String imageInput;

    @ApiModelProperty(value = "文章简介")
    private String synopsis;

    @ApiModelProperty(value = "文章分享标题")
    private String shareTitle;

    @ApiModelProperty(value = "文章分享简介")
    private String shareSynopsis;

    @ApiModelProperty(value = "浏览次数")
    private String visit;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "原文链接")
    private String url;

    @ApiModelProperty(value = "状态")
    private Byte status;

    @ApiModelProperty(value = "添加时间")
    private String addTime;

    @ApiModelProperty(value = "是否隐藏")
    private String hide;

    @ApiModelProperty(value = "管理员id")
    private Integer adminId;

    @ApiModelProperty(value = "商户id")
    private Integer merId;

    @ApiModelProperty(value = "产品关联id")
    private Integer productId;

    @ApiModelProperty(value = "是否热门(小程序)")
    private Byte isHot;

    @ApiModelProperty(value = "tinyint unsigned")
    private Byte isBanner;

    @ApiModelProperty(value = "文章管理ID")
    private String mediaId;

    private String content;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImageInput() {
        return imageInput;
    }

    public void setImageInput(String imageInput) {
        this.imageInput = imageInput;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
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

    public String getVisit() {
        return visit;
    }

    public void setVisit(String visit) {
        this.visit = visit;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getHide() {
        return hide;
    }

    public void setHide(String hide) {
        this.hide = hide;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Integer getMerId() {
        return merId;
    }

    public void setMerId(Integer merId) {
        this.merId = merId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Byte getIsHot() {
        return isHot;
    }

    public void setIsHot(Byte isHot) {
        this.isHot = isHot;
    }

    public Byte getIsBanner() {
        return isBanner;
    }

    public void setIsBanner(Byte isBanner) {
        this.isBanner = isBanner;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", cid=").append(cid);
        sb.append(", title=").append(title);
        sb.append(", author=").append(author);
        sb.append(", imageInput=").append(imageInput);
        sb.append(", synopsis=").append(synopsis);
        sb.append(", shareTitle=").append(shareTitle);
        sb.append(", shareSynopsis=").append(shareSynopsis);
        sb.append(", visit=").append(visit);
        sb.append(", sort=").append(sort);
        sb.append(", url=").append(url);
        sb.append(", status=").append(status);
        sb.append(", addTime=").append(addTime);
        sb.append(", hide=").append(hide);
        sb.append(", adminId=").append(adminId);
        sb.append(", merId=").append(merId);
        sb.append(", productId=").append(productId);
        sb.append(", isHot=").append(isHot);
        sb.append(", isBanner=").append(isBanner);
        sb.append(", mediaId=").append(mediaId);
        sb.append(", content=").append(content);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}