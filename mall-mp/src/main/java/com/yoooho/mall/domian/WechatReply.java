package com.yoooho.mall.domian;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalTime;

@Entity
@Data
@Table(name="wechat_reply")
public class WechatReply implements Serializable {

    // 微信关键字回复id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // 关键字
    @Column(name = "match_value",unique = true,nullable = false)
    private String matchValue;

    // 回复类型
    @Column(name = "reply_type",nullable = false)
    private String replyType;

    // 回复数据
    @Column(name = "reply_content",nullable = false)
    private String replyContent;

    // 0=不可用  1 =可用
    @Column(name = "`status`",nullable = false)
    private Integer status;

    @CreationTimestamp
    @Column(name = "update_time")
    private Timestamp updateTime;

    @Column(name = "effect_time_start")
    private LocalTime effectTimeStart;


    @Column(name = "effect_time_end")
    private LocalTime  effectTimeEnd;

    @Column(name = "exact_match")
    private int exactMatch;

    @Column(name = "rule_name")
    private String ruleName;

    @Column(name = "`desc`")
    private String desc;

    // 是否隐藏
    @Column(name = "hide",nullable = false)
    private Integer hide;

    @Column(name = "priority")
    private String priority;
    public void copy(WechatReply source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
