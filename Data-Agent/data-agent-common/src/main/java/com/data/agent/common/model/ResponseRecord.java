package com.data.agent.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseRecord implements Serializable {
    private static final long serialVersionUID = -4501423137927742788L;

    @JsonProperty
    private String SequenceNumber;
    @JsonProperty
    private String ShardId;
}
