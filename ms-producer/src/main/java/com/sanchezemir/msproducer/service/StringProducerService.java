package com.sanchezemir.msproducer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Log4j2
@RequiredArgsConstructor
@Service
public class StringProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        kafkaTemplate.send("br-topic", message).addCallback(
                success -> {
                    if (success != null) {
                        log.info("Message sent successfully {}", message);
                        log.info("Partition {},Offset {}", success.getRecordMetadata().partition(), success.getRecordMetadata().offset());
//                        log.info("Imprime mensaje enviado: {}", success.getProducerRecord().value());
//                        log.info("Partition {}", success.getRecordMetadata().partition());
//                        log.info("Offset {}", success.getRecordMetadata().offset());
                    }
                },
                error -> log.info("Error sending message {}", error.getMessage())
        );
    }

}
