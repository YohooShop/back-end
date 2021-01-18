package com.yoooho.mall.domian;

import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "aliyunoss_content")
public class AliyunOssContent  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** 文件名 */
    @Column(name = "name")
    private String key;

    /** 空间名 */
    private String bucket;

    /** 大小 */
    private String size;

    /** 文件地址 */
    private String url;

    private String suffix;

    /** 空间类型：公开/私有 */
    private String type = "公开";

    @UpdateTimestamp
    @Column(name = "update_time")
    private Timestamp updateTime;
}
