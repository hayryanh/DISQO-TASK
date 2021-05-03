package com.data.agent.common.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DataPipeResponseModel implements Serializable {
    private static final long serialVersionUID = -4141471263820864565L;

    @JsonProperty
    private Integer FailedRecordCount;
    @JsonProperty
    private List<ResponseRecord> Records;
}
