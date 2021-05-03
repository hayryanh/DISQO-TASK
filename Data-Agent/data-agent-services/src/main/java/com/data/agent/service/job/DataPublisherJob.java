package com.data.agent.service.job;

import com.data.agent.common.model.DataPipeResponseModel;
import com.data.agent.service.PublisherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;

@Slf4j
@Component
public class DataPublisherJob {
    @Autowired
    private PublisherService service;

    @Scheduled(fixedDelay = 15000)
    public void publishData() {
        try {
            Optional<DataPipeResponseModel> responseModel = service.publishData();
            responseModel.ifPresent(model -> log.info("Failed PayloadRecord Count in Published stream {}", model.getFailedRecordCount()));
        } catch (IOException e) {
            log.error("Data Pipe publishing error: {}", e.getMessage(), e);
        }
    }
}
