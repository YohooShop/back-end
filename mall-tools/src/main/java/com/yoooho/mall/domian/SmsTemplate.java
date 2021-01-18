package com.yoooho.mall.domian;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name="aliyun_sms_template")
public class SmsTemplate {
    // 模板id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // 模板编号
    @Column(name = "`key`",nullable = false)
    private Integer key;

    // 模板名
    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "region_id",nullable = false)
    private String regionId;

    @Column(name = "endpoint_name",nullable = false)
    private String endpointName;

    @Column(name = "access_key_id",nullable = false)
    private String accessKeyId;

    @Column(name = "access_secret",nullable = false)
    private String accesSecret;

    @Column(name = "sign_name",nullable = false)
    private String  signName;


    @Column(name = "`desc`",nullable = false)
    private String  desc;

    @Column(name = "create_time",nullable = false)
    private Date  createTime;

    @Column(name = "status", nullable = false)
    private int status;
    @Column(name = "template_code", nullable = false)
    private String templateCode;
    public void copy(SmsTemplate source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
