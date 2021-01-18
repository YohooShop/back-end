package com.yoooho.mall.express.domain;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
* @author hupeng
* @date 2019-12-12
*/
@Entity
@Data
@Table(name="kdn_express_company")
public class KDNExpressCompany implements Serializable {

    // 快递公司id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    // 快递公司简称
    @Column(name = "company_code",unique = true,nullable = false)
    @NotBlank(message = "快递公司编号不能为空")
    private String code;

    // 快递公司全称
    @Column(name = "company_name",nullable = false)
    @NotBlank(message = "快递公司名称不能为空")
    private String name;

    // 排序
    @Column(name = "sort",nullable = false)
    @NotNull(message = "排序必填")
    private Integer sort;

    // 是否显示
    @Column(name = "is_show",insertable = false)
    private Integer isShow;

    @Column(name = "icon",insertable = false)
    private String icon;

    @Column(name = "tel",insertable = false)
    private String tel;


    public void copy(KDNExpressCompany source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
