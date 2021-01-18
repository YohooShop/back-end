package com.yoooho.mall.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.yoooho.mall.common.annotation.Query;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

/**
 * @author Zheng Jie
 * 公共查询类
 */
@Data
public class DictQueryCriteria {

    @Query(blurry = "name,remark")
    private String blurry;

    /**
    * @author Zheng Jie
    * @date 2019-03-25
    */
    @Data
    public static class DeptDTO implements Serializable {

        private Long id;

        private String name;

        @NotNull
        private Boolean enabled;

        private Long pid;

        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private List<DeptDTO> children;

        private Timestamp createTime;

        public String getLabel() {
            return name;
        }
    }

    /**
    * @author Zheng Jie
    * @date 2019-03-25
    */
    @Data
    public static class DeptQueryCriteria{

        @Query(type = Query.Type.IN, propName="id")
        private Set<Long> ids;

        @Query(type = Query.Type.INNER_LIKE)
        private String name;

        @Query
        private Boolean enabled;

        @Query
        private Long pid;

        @Query(type = Query.Type.BETWEEN)
        private List<Timestamp> createTime;
    }

    /**
    * @author Zheng Jie
    * @date 2019-6-10 16:32:18
    */
    @Data
    public static class DeptSmallDTO implements Serializable {

        private Long id;

        private String name;
    }
}
