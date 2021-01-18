package com.yoooho.mall.domain;

import lombok.Data;

import java.util.List;

@Data
public class PagesCompoent {
    private String name;
    private boolean isShowTitle;
    private String title;
    private String type;
    private List <PagesCompoentValue> value;
}
