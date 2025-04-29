package com.ey.banking.viewTRansaction.service;

import com.ey.banking.viewTRansaction.entity.Transaction;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Data
@Service
public class KafkaProducerService {

    @Value("${kafka.transaction.topic}")
    private  String transactionTopic;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Async
    public void sendMessage(Transaction message) throws JsonProcessingException {
        kafkaTemplate.send(transactionTopic, objectMapper.writeValueAsString(message));
        System.out.println("Message sent to Kafka: " + message);
    }
}