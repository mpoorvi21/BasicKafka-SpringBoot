package com.project.springboot_kafka.kafka;

import com.project.springboot_kafka.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);
    @Value("${spring.kafka.topic-json.name}")
    private String topicJsonName;

    @KafkaListener(topics = "${spring.kafka.topic-json.name}",groupId = "${spring.kafka.consumer.group-id}")
    public void consume(User user){
        LOGGER.info(String.format("JSON Message Recieved ->%s",user.toString()));

    }
}
