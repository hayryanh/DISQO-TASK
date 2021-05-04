package com.data.agent.service.test;

import com.data.agent.common.model.DataPipeResponseModel;
import com.data.agent.service.PublisherService;
import com.data.agent.service.publisher.DataPipePublisher;
import org.assertj.core.api.WithAssertions;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.Optional;

import static org.mockito.BDDMockito.willReturn;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class PublishServiceTest implements WithAssertions {
    @Mock
    private DataPipePublisher publisher;

    @InjectMocks
    private PublisherService service;

    @Test
    public void testPublishData() throws IOException {
        willReturn(Optional.of(DataPipeResponseModel.builder().build()))
                .given(publisher)
                .publishData();

        assertThat(service.publishData()).isNotEmpty();
    }
}
