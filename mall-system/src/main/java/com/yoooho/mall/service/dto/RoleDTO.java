package com.yoooho.mall.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

/**
 * @author Zheng Jie
 * @date 2019-11-23
 */
@Data
public class RoleDTO implements Serializable {

    private Long id;

    private String name;

    private String dataScope;

    private Integer level;

    private String remark;

    private String permission;

    private Set<MenuDTO> menus;

    private Set<DictQueryCriteria.DeptDTO> depts;

    private Timestamp createTime;
}
