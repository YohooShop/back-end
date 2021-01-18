package com.yoooho.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class WechatArticleOrigin implements Serializable {
    private String mid;

    private String thumbMediaId;

    private String thumbUrl;

    private String author;

    private String title;

    private String contentSourceUrl;

    private String content;

    private String digest;

    private Boolean showcCoverPic;

    private String url;

    private Boolean needOpenComment;

    private Boolean onlyFansCanComment;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContentSourceUrl() {
        return contentSourceUrl;
    }

    public void setContentSourceUrl(String contentSourceUrl) {
        this.contentSourceUrl = contentSourceUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public Boolean getShowcCoverPic() {
        return showcCoverPic;
    }

    public void setShowcCoverPic(Boolean showcCoverPic) {
        this.showcCoverPic = showcCoverPic;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getNeedOpenComment() {
        return needOpenComment;
    }

    public void setNeedOpenComment(Boolean needOpenComment) {
        this.needOpenComment = needOpenComment;
    }

    public Boolean getOnlyFansCanComment() {
        return onlyFansCanComment;
    }

    public void setOnlyFansCanComment(Boolean onlyFansCanComment) {
        this.onlyFansCanComment = onlyFansCanComment;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", mid=").append(mid);
        sb.append(", thumbMediaId=").append(thumbMediaId);
        sb.append(", thumbUrl=").append(thumbUrl);
        sb.append(", author=").append(author);
        sb.append(", title=").append(title);
        sb.append(", contentSourceUrl=").append(contentSourceUrl);
        sb.append(", content=").append(content);
        sb.append(", digest=").append(digest);
        sb.append(", showcCoverPic=").append(showcCoverPic);
        sb.append(", url=").append(url);
        sb.append(", needOpenComment=").append(needOpenComment);
        sb.append(", onlyFansCanComment=").append(onlyFansCanComment);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}