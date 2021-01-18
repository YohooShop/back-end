package com.yoooho.mall.dto;

import lombok.Data;

@Data
public class WechatArticleDTO {



    private Integer id;

    // 文章管理ID
    private String mediaId;

    // 分类id
    private String cid;

    // 文章标题
    private String title;

    // 文章作者
    private String author;

    // 文章图片
    private String imageInput;

    // 文章简介
    private String synopsis;

    private String content;

    // 文章分享标题
    private String shareTitle;

    // 文章分享简介
    private String shareSynopsis;

    // 浏览次数
    private String visit;

    // 排序
    private Integer sort;

    // 原文链接
    private String url;

    // 状态
    private Integer status;

    // 添加时间
    private String addTime;

    // 是否隐藏
    private Integer hide;

    // 管理员id
    private Integer adminId;

    // 商户id
    private Integer merId;

    // 产品关联id
    private Integer productId;

    // 是否热门(小程序)
    private Integer isHot;

    // 是否轮播图(小程序)
    private Integer isBanner;

    private String thumbMediaId;

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }
}
