package com.yoooho.mall.dto;

import com.yoooho.mall.common.annotation.Query;
import lombok.Data;



@Data
public class MaterialQueryCriteria {
    @Query
    private String groupId;
}
