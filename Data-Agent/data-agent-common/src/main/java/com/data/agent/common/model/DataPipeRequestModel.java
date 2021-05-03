package com.data.agent.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DataPipeRequestModel implements Serializable {
    private static final long serialVersionUID = 3951660413554408257L;

    @NonNull
    @EqualsAndHashCode.Include
    @JsonProperty(value = "PayloadRecord", required = true)
    private List<Record> records;
    @JsonProperty(value = "StreamName", required = true)
    private String streamName;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{")
                .append("\"Records\": [");
        for (int i = 0; i < records.size(); i++) {
            Record record = records.get(i);
            builder.append("{\"Data\":\"")
                    .append(record.getData()).append("\",")
                    .append("\"PartitionKey\":\"")
                    .append(record.getPartitionKey()).append("\"}");

            if (records.size() > 1 && i < records.size()) {
                builder.append(",");
            }
        }
        builder.append("],")
                .append("\"StreamName\":")
                .append("\"").append(streamName).append("\"}");

        return builder.toString();
    }
}
