package com.data.agent.service.publisher;

import com.data.agent.common.model.DataPipeRequestModel;
import com.data.agent.model.pipe.GenDataPipeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "${client.config.kinesis.id}", url = "${client.config.kinesis.url}")
public interface DataPipeFeignPublisher {

    @RequestMapping(method = RequestMethod.PUT, path = "${client.config.kinesis.path}", produces = MediaType.APPLICATION_JSON_VALUE)
    GenDataPipeResponse publishRecord(@RequestBody final DataPipeRequestModel request);
}
