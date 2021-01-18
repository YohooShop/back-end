package com.yoooho.mall.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;


@Data
public class DeptDTO extends DictQueryCriteria.DeptDTO implements Serializable {

    private Long id;

    private String name;

    @NotNull
    private Boolean enabled;

    private Long pid;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<DictQueryCriteria.DeptDTO> children;

    private Timestamp createTime;

    public String getLabel() {
        return name;
    }
}
