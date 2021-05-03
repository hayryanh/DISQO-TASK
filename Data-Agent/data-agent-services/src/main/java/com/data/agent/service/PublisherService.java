package com.data.agent.service;

import com.data.agent.common.model.DataPipeResponseModel;
import com.data.agent.service.publisher.DataPipePublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Slf4j
@Service
public class PublisherService {

    @Autowired
    private DataPipePublisher publisher;

    public Optional<DataPipeResponseModel> publishData() throws IOException {
        return publisher.publishData();
    }
}
