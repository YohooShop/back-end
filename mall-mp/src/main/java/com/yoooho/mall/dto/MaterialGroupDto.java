package com.yoooho.mall.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
@Data
public class MaterialGroupDto implements Serializable {
    /** PK */
    private String id;

    /** 逻辑删除标记（0：显示；1：隐藏） */
    private String delFlag;

    /** 创建时间 */
    private Timestamp createTime;

    /** 创建者ID */
    private String createId;

    /** 分组名 */
    private String name;

}
