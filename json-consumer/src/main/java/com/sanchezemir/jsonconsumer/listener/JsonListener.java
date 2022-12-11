package com.sanchezemir.jsonconsumer.listener;

import com.sanchezemir.jsonconsumer.model.Payment;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class JsonListener {

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "create-group", containerFactory = "jsonContainerFactory")
    public void antiFraud(@Payload Payment payment) {
        log.info("Payment received: {}", payment.toString());
        Thread.sleep(2000);

        log.info("Validando fraude ...");
        Thread.sleep(2000);

        log.info("compra aprovada ...");
        Thread.sleep(2000);
    }

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "pdf-group", containerFactory = "jsonContainerFactory")
    public void pdfGenerator( @Payload Payment payment ) {
        Thread.sleep(3000);
        log.info("Generando PDF ... de id: {}", payment.getId());
        Thread.sleep(3000);
    }

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "email-group", containerFactory = "jsonContainerFactory")
    public void sendEmail(  ) {
        Thread.sleep(3000);
        log.info("Enviando email confirmación ...");
    }

}
