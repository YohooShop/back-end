package com.yoooho.mall.express.service.dto;

import lombok.Data;

import java.io.Serializable;


/**
* @author hupeng
* @date 2019-12-12
*/
@Data
public class KDNExpressCompanyDTO implements Serializable {

    // 快递公司id
    private Integer id;

    // 快递公司简称
    private String code;

    // 快递公司全称
    private String name;

    // 排序
    private Integer sort;

    // 是否显示
    private Integer isShow;

    private String icon;

    private String tel;
}
