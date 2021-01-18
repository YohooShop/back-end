package com.yoooho.mall.dto;

import com.yoooho.mall.model.PmsProductCombination;
import lombok.Data;

@Data
public class PmsProductCombResult extends PmsProductCombination {
    //参与人数
    private Integer countPeopleAll;
    //成团人数
    private Integer countPeoplePink;

    //访问人数
    private Integer countPeopleBrowse;
}
