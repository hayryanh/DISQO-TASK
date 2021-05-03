package com.data.agent.common.model.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

import java.io.Serializable;

@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PayloadRecord implements Serializable {
    private static final long serialVersionUID = -7991378779346462913L;

    @JsonProperty
    @NonNull
    private Long userId;
    @JsonProperty
    @NonNull
    private Long eventTypeId;
    @JsonProperty
    private Long screenWidth;
    @JsonProperty
    private Long screenHeight;
    @JsonProperty
    private String viewSource;
    @JsonProperty
    @NonNull
    private Long actionTimeStamp;
}
