package com.yoooho.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class PmsProductSeckill implements Serializable {
    @ApiModelProperty(value = "商品秒杀产品表id")
    private Long id;

    @ApiModelProperty(value = "商品id")
    private Long productId;

    @ApiModelProperty(value = "推荐图")
    private String pic;

    @ApiModelProperty(value = "轮播图")
    private String albumPics;

    @ApiModelProperty(value = "活动标题")
    private String name;

    @ApiModelProperty(value = "简介")
    private String description;

    @ApiModelProperty(value = "价格")
    private BigDecimal price;

    @ApiModelProperty(value = "原价")
    private BigDecimal originalPrice;

    @ApiModelProperty(value = "返多少积分")
    private Integer giftPoint;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "库存")
    private Integer stock;

    @ApiModelProperty(value = "销量")
    private Integer sale;

    @ApiModelProperty(value = "单位名")
    private String unitName;

    @ApiModelProperty(value = "邮费")
    private BigDecimal postage;

    @ApiModelProperty(value = "开始时间")
    private Integer startTime;

    @ApiModelProperty(value = "结束时间")
    private Integer stopTime;

    @ApiModelProperty(value = "添加时间")
    private String addTime;

    @ApiModelProperty(value = "是否包邮")
    private Integer postageStatus;

    @ApiModelProperty(value = "热门推荐")
    private Integer hotStatus;

    @ApiModelProperty(value = "删除 0未删除1已删除")
    private Integer deleteStatus;

    @ApiModelProperty(value = "最多秒杀几个")
    private Integer num;

    @ApiModelProperty(value = "显示")
    private Integer isShow;

    @ApiModelProperty(value = "时间段id")
    private Integer timeId;

    private Date endTimeDate;

    private Date startTimeDate;

    @ApiModelProperty(value = "1")
    private Integer status;

    @ApiModelProperty(value = "锁住库存")
    private Integer lockStock;

    @ApiModelProperty(value = "内容")
    private String detailHtml;

    private String detailMobileHtml;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getAlbumPics() {
        return albumPics;
    }

    public void setAlbumPics(String albumPics) {
        this.albumPics = albumPics;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Integer getGiftPoint() {
        return giftPoint;
    }

    public void setGiftPoint(Integer giftPoint) {
        this.giftPoint = giftPoint;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public BigDecimal getPostage() {
        return postage;
    }

    public void setPostage(BigDecimal postage) {
        this.postage = postage;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getStopTime() {
        return stopTime;
    }

    public void setStopTime(Integer stopTime) {
        this.stopTime = stopTime;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public Integer getPostageStatus() {
        return postageStatus;
    }

    public void setPostageStatus(Integer postageStatus) {
        this.postageStatus = postageStatus;
    }

    public Integer getHotStatus() {
        return hotStatus;
    }

    public void setHotStatus(Integer hotStatus) {
        this.hotStatus = hotStatus;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    public Integer getTimeId() {
        return timeId;
    }

    public void setTimeId(Integer timeId) {
        this.timeId = timeId;
    }

    public Date getEndTimeDate() {
        return endTimeDate;
    }

    public void setEndTimeDate(Date endTimeDate) {
        this.endTimeDate = endTimeDate;
    }

    public Date getStartTimeDate() {
        return startTimeDate;
    }

    public void setStartTimeDate(Date startTimeDate) {
        this.startTimeDate = startTimeDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getLockStock() {
        return lockStock;
    }

    public void setLockStock(Integer lockStock) {
        this.lockStock = lockStock;
    }

    public String getDetailHtml() {
        return detailHtml;
    }

    public void setDetailHtml(String detailHtml) {
        this.detailHtml = detailHtml;
    }

    public String getDetailMobileHtml() {
        return detailMobileHtml;
    }

    public void setDetailMobileHtml(String detailMobileHtml) {
        this.detailMobileHtml = detailMobileHtml;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", productId=").append(productId);
        sb.append(", pic=").append(pic);
        sb.append(", albumPics=").append(albumPics);
        sb.append(", name=").append(name);
        sb.append(", description=").append(description);
        sb.append(", price=").append(price);
        sb.append(", originalPrice=").append(originalPrice);
        sb.append(", giftPoint=").append(giftPoint);
        sb.append(", sort=").append(sort);
        sb.append(", stock=").append(stock);
        sb.append(", sale=").append(sale);
        sb.append(", unitName=").append(unitName);
        sb.append(", postage=").append(postage);
        sb.append(", startTime=").append(startTime);
        sb.append(", stopTime=").append(stopTime);
        sb.append(", addTime=").append(addTime);
        sb.append(", postageStatus=").append(postageStatus);
        sb.append(", hotStatus=").append(hotStatus);
        sb.append(", deleteStatus=").append(deleteStatus);
        sb.append(", num=").append(num);
        sb.append(", isShow=").append(isShow);
        sb.append(", timeId=").append(timeId);
        sb.append(", endTimeDate=").append(endTimeDate);
        sb.append(", startTimeDate=").append(startTimeDate);
        sb.append(", status=").append(status);
        sb.append(", lockStock=").append(lockStock);
        sb.append(", detailHtml=").append(detailHtml);
        sb.append(", detailMobileHtml=").append(detailMobileHtml);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}