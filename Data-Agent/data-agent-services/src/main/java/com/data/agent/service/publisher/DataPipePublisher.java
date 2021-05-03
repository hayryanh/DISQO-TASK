package com.data.agent.service.publisher;

import com.data.agent.common.model.DataPipeRequestModel;
import com.data.agent.common.model.DataPipeResponseModel;
import com.data.agent.common.model.Record;
import com.data.agent.common.util.PipeDataUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collections;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@Component
public class DataPipePublisher {

    private final OkHttpClient okHttpClient;
    private final MediaType mediaType;

    @Value("${client.config.kinesis.url}")
    private String url;

    @Autowired
    public DataPipePublisher(OkHttpClient okHttpClient, MediaType mediaType) {
        this.okHttpClient = okHttpClient;
        this.mediaType = mediaType;
    }

    public Optional<DataPipeResponseModel> publishData() throws IOException {
        Response response = okHttpClient.newCall(buildRequest()).execute();
        Optional<ResponseBody> responseBody = Optional.ofNullable(response.body());
        ObjectMapper mapper = new ObjectMapper();
        DataPipeResponseModel responseModel = null;
        if (responseBody.isPresent()) {
            responseModel = mapper.readValue(responseBody.get().string(), DataPipeResponseModel.class);
        }

        return Optional.ofNullable(responseModel);
    }

    private Request buildRequest() throws IOException {
        return new Request.Builder()
                .url(url)
                .method(PUT.toString(), RequestBody.create(mediaType, buildModel()))
                .addHeader("Content-Type", "application/json")
                .build();
    }

    private String buildModel() throws IOException {
        return DataPipeRequestModel.builder()
                .streamName(PipeDataUtil.STREAM_NAME)
                .records(Collections.singletonList(Record.builder()
                        .data(PipeDataUtil.buildPipeData())
                        .partitionKey(PipeDataUtil.genPartitionKey())
                        .build()))
                .build().toString();
    }
}
