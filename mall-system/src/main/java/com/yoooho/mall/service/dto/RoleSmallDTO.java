package com.yoooho.mall.service.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Zheng Jie
 * @date 2019-11-23
 */
@Data
public class RoleSmallDTO implements Serializable {

    private Long id;

    private String name;

    private Integer level;

    private String dataScope;
}
