package com.data.agent.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Record implements Serializable {
    private static final long serialVersionUID = 3744173369822496325L;

    @JsonProperty(value = "Data", required = true)
    private String data;
    @JsonProperty(value = "PartitionKey", required = true)
    private String partitionKey;
}
