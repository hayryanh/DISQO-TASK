package com.data.agent.common.util;

import com.data.agent.common.model.payload.PayloadDataPipe;
import com.data.agent.common.model.payload.PayloadRecord;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.*;

@Slf4j
public final class PipeDataUtil {

    public static final String STREAM_NAME = "data-collection-pipe";

    private static final long EVENT_TYPE_ID = 1;
    private static final int USER_MAX_COUNT = 5;
    private static final int SCREEN_WIDTH = 800;
    private static final int SCREEN_HEIGHT = 600;

    private static final Random random = new Random();

    private PipeDataUtil() {
        throw new UnsupportedOperationException();
    }

    public static String buildPipeData() throws IOException {
        PayloadDataPipe pipe = PayloadDataPipe.builder().build();
        List<PayloadRecord> payloadRecords = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            PayloadRecord payloadRecord = PayloadRecord.builder()
                    .userId(randLong(USER_MAX_COUNT))
                    .eventTypeId(EVENT_TYPE_ID)
                    .screenWidth(randLong(SCREEN_WIDTH))
                    .screenHeight(randLong(SCREEN_HEIGHT))
                    .viewSource("http://amazon.com")
                    .actionTimeStamp(System.currentTimeMillis())
                    .build();

            payloadRecords.add(payloadRecord);
        }
        pipe.setPayloadRecords(payloadRecords);

        return Base64.getEncoder().encodeToString(toJSON(pipe).getBytes());
    }

    public static String genPartitionKey() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    private static long randLong(final int upperBound) {
        return random.nextInt(upperBound);
    }

    private static String toJSON(PayloadDataPipe pipe) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(pipe);
    }
}
