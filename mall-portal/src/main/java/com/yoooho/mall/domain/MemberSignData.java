package com.yoooho.mall.domain;

import lombok.Data;

@Data
public class MemberSignData {
    private boolean  sign;
    private String date;
    private Long time;
    private Integer day;
    private String week;
    private String current;
}
