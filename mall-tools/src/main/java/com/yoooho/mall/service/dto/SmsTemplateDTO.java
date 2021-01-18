package com.yoooho.mall.service.dto;

import lombok.Data;

import java.util.Date;

@Data
public class SmsTemplateDTO {
    // 模板id

    private Long id;

    // 模板编号

    private Integer key;

    // 模板名

    private String name;


    private String regionId;


    private String endpointName;


    private String accessKeyId;


    private String accesSecret;


    private String  signName;


    private String  desc;

    private Date createTime;

    private int status;

    private String templateCode;
}
