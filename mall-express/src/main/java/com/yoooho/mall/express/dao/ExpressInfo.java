/**
 * Copyright 2019 bejson.com
 */
package com.yoooho.mall.express.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Auto-generated: 2019-07-19 22:27:22
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@Data
@Document
@ToString
public class ExpressInfo {

    @Id
    private String id;

    @Indexed
    @JsonProperty("OrderCode")
    private String orderCode;

    @JsonProperty("LogisticCode")
    private String logisticCode;
    @JsonProperty("ShipperCode")
    private String shipperCode;
    @JsonProperty("Traces")
    private List<Traces> traces;
    @JsonProperty("State")
    private String state;
    @JsonProperty("EBusinessID")
    private String eBusinessID;
    @JsonProperty("Success")
    private boolean success;
    @JsonProperty("Reason")
    private String reason;
    @JsonProperty("ShipperName")
    private String shipperName;
    @JsonProperty("Remark")
    private String remark;
}
