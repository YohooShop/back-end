package com.yoooho.mall.domian;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Data
@Table(name="material_group")
public class MaterialGroup implements Serializable {

    /** PK */
    @Id
    @Column(name = "id")
    private String id;


    /** 逻辑删除标记（0：显示；1：隐藏） */
    @Column(name = "del_flag",nullable = false,insertable = false)
    private String delFlag;

    /** 创建时间 */
    @Column(name = "create_time",nullable = false)
    @CreationTimestamp
    private Timestamp createTime;


    /** 创建者ID */
    @Column(name = "create_id")
    private String createId;

    /** 分组名 */
    @Column(name = "name",nullable = false)
    @NotBlank
    private String name;

    public void copy(MaterialGroup source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
