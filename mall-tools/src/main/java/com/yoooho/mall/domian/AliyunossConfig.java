package com.yoooho.mall.domian;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
@Data
@Entity
@Table(name = "aliyunoss_config")
public class AliyunossConfig implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**外网Endpoint*/
    @NotBlank
    @Column(name = "endpoint")
    private String endpoint;

    /**oss对外服务的访问域名*/
    @NotBlank
    @Column(name = "host")
    private String host;

    /**Region中文名称*/
    @NotBlank
    @Column(name = "zone")
    private String zone;

    /**访问身份验证中用到用户标识*/
    @NotBlank
    @Column(name = "access_keyId")
    private String accessKeyId;

    /**用户用于加密签名字符串和oss用来验证签名字符串的密钥*/
    @NotBlank
    @Column(name = " access_keySecre")
    private String  accessKeySecre;

    /**oss的存储空间*/
    @NotBlank
    @Column(name = " bucket_name")
    private String  bucketName;

    /**上传文件大小(M)*/
    @NotBlank
    @Column(name = " maxSize")
    private String  maxSize = "10";

    /**签名有效期(S)*/
    @NotBlank
    @Column(name = "expire")
    private String  expire = "300";

    /**文件上传成功后的回调地址*/
    @NotBlank
    @Column(name = "callback")
    private String  callback = "/aliyun/oss/callback";

    /**上传文件夹路径前缀*/
//    @NotBlank
    @Column(name = "prefix")
    private String  prefix;

    /** 空间类型：公开/私有 */
    private String type = "公开";

}
