package com.data.agent.common.model.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PayloadDataPipe implements Serializable  {
    private static final long serialVersionUID = 1959212314197441401L;
    @JsonProperty
    private List<PayloadRecord> payloadRecords;
}
