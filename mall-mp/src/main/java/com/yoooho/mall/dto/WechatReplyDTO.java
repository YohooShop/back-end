package com.yoooho.mall.dto;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalTime;

@Data
public class WechatReplyDTO implements Serializable {
    // 微信关键字回复id

    private Long id;

    private String matchValue;

    private String replyType;

    private String replyContent;

    private Integer status;

    private Timestamp updateTime;

    private LocalTime effectTimeStart;

    private LocalTime  effectTimeEnd;

    private int exactMatch;


    private String ruleName;


    private String desc;

    private int priority;
}
