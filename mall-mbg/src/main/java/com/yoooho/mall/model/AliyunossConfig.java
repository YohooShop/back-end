package com.yoooho.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class AliyunossConfig implements Serializable {
    private Integer id;

    @ApiModelProperty(value = "外网Endpoint")
    private String endpoint;

    @ApiModelProperty(value = "访问身份验证中用到用户标识")
    private String accessKeyId;

    @ApiModelProperty(value = "用户用于加密签名字符串和oss用来验证签名字符串的密钥")
    private String accessKeySecre;

    @ApiModelProperty(value = "oss的存储空间")
    private String bucketName;

    @ApiModelProperty(value = "签名有效期(S)")
    private String expire;

    @ApiModelProperty(value = "上传文件大小(M)")
    private String maxSize;

    @ApiModelProperty(value = "文件上传成功后的回调地址")
    private String callback;

    @ApiModelProperty(value = "上传文件夹路径前缀")
    private String prefix;

    @ApiModelProperty(value = "oss对外服务的访问域名")
    private String host;

    @ApiModelProperty(value = "Region中文名称")
    private String zone;

    @ApiModelProperty(value = "空间类型：公开/私有 ")
    private String type;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessKeySecre() {
        return accessKeySecre;
    }

    public void setAccessKeySecre(String accessKeySecre) {
        this.accessKeySecre = accessKeySecre;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getExpire() {
        return expire;
    }

    public void setExpire(String expire) {
        this.expire = expire;
    }

    public String getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(String maxSize) {
        this.maxSize = maxSize;
    }

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", endpoint=").append(endpoint);
        sb.append(", accessKeyId=").append(accessKeyId);
        sb.append(", accessKeySecre=").append(accessKeySecre);
        sb.append(", bucketName=").append(bucketName);
        sb.append(", expire=").append(expire);
        sb.append(", maxSize=").append(maxSize);
        sb.append(", callback=").append(callback);
        sb.append(", prefix=").append(prefix);
        sb.append(", host=").append(host);
        sb.append(", zone=").append(zone);
        sb.append(", type=").append(type);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}