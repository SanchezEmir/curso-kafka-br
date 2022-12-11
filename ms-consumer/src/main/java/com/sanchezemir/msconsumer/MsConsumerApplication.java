package com.sanchezemir.msconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class MsConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsConsumerApplication.class, args);
    }

}
