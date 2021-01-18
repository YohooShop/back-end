package com.yoooho.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class AliyunSmsTemplate implements Serializable {
    private Long id;

    @ApiModelProperty(value = "描述")
    private String name;

    private String endpointName;

    @ApiModelProperty(value = "1是验证码")
    private Integer key;

    private String regionId;

    private String accessKeyId;

    private String accessSecret;

    @ApiModelProperty(value = "短信签名-可在短信控制台中找到")
    private String signName;

    @ApiModelProperty(value = "描述")
    private String desc;

    private Date createTime;

    @ApiModelProperty(value = "0不可用，1可以用")
    private Integer status;

    @ApiModelProperty(value = "必填:短信模板")
    private String templateCode;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEndpointName() {
        return endpointName;
    }

    public void setEndpointName(String endpointName) {
        this.endpointName = endpointName;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessSecret() {
        return accessSecret;
    }

    public void setAccessSecret(String accessSecret) {
        this.accessSecret = accessSecret;
    }

    public String getSignName() {
        return signName;
    }

    public void setSignName(String signName) {
        this.signName = signName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", endpointName=").append(endpointName);
        sb.append(", key=").append(key);
        sb.append(", regionId=").append(regionId);
        sb.append(", accessKeyId=").append(accessKeyId);
        sb.append(", accessSecret=").append(accessSecret);
        sb.append(", signName=").append(signName);
        sb.append(", desc=").append(desc);
        sb.append(", createTime=").append(createTime);
        sb.append(", status=").append(status);
        sb.append(", templateCode=").append(templateCode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}