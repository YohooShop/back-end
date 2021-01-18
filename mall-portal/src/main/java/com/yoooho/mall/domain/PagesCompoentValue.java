package com.yoooho.mall.domain;

import lombok.Data;

import java.util.List;

@Data
public class PagesCompoentValue {
    private Integer advert_id;
    private Integer id;
    private String image;
    private String link;
    private List children;
    private List meta;
    private String name;
    private String type;
}
