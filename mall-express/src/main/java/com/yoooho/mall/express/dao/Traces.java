/**
 * Copyright 2019 bejson.com
 */
package com.yoooho.mall.express.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Auto-generated: 2019-07-19 22:27:22
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */


@Data
public class Traces {

    @JsonProperty("AcceptStation")
    private String AcceptStation;
    @JsonProperty("AcceptTime")
    private String AcceptTime;

    @JsonProperty("Remark")
    private String Remark;

}
