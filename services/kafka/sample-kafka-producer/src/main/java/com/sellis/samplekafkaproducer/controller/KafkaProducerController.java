package com.sellis.samplekafkaproducer.controller;

import com.sellis.kafka.commons.model.TestPayload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.IntStream;

/**
 * Description
 *
 * @author sellis
 */
@RestController
public class KafkaProducerController {
    private static final Logger logger = LoggerFactory.getLogger(KafkaProducerController.class);

    private final KafkaTemplate<String, Object> template;
    private final String topicName;

    private final int messagesPerRequest;

    public KafkaProducerController(
            KafkaTemplate<String, Object> template,
            @Value("${app.topic-name}") String topicName,
            @Value("${app.messages-per-request}") int messagesPerRequest
    ) {
        this.template = template;
        this.topicName = topicName;
        this.messagesPerRequest = messagesPerRequest;
    }

    @GetMapping("/send")
    public String hello() throws Exception {
//        CountDownLatch latch = new CountDownLatch(messagesPerRequest);
        IntStream.range(0, messagesPerRequest)
                .forEach(i -> this.template.send(topicName, String.valueOf(i),
                        new TestPayload("Test payload", i))
                );

        //noinspection ResultOfMethodCallIgnored
//        latch.await(60, TimeUnit.SECONDS);

        logger.info("All messages sent");

        return "All messages sent";
    }
}
