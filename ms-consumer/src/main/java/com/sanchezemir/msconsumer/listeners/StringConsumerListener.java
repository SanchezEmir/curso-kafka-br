package com.sanchezemir.msconsumer.listeners;

import com.sanchezemir.msconsumer.custom.StringConsumerCustomListener;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class StringConsumerListener {

    /*@KafkaListener(groupId = "br-group-1",
            topicPartitions = {
                @TopicPartition(topic = "br-topic", partitions = {"0"})
            },
            containerFactory = "listenerContainerFactory")
    public void create(String message){
        log.info("CREATE ::: Message received: {}", message);
    }*/

    @SneakyThrows
    @StringConsumerCustomListener(groupId = "br-group-1")
    public void create(String message) {
        log.info("CREATE ::: Message received: {}", message);
        throw new IllegalArgumentException("Exception ....");
    }

    /*@KafkaListener(groupId = "br-group-1",
            topicPartitions = {
                    @TopicPartition(topic = "br-topic", partitions = {"1"})
            },
            containerFactory = "listenerContainerFactory")*/
    @StringConsumerCustomListener(groupId = "br-group-1")
    public void log(String message) {
        log.info("LOG ::: Message received: {}", message);
    }

    //    @KafkaListener(groupId = "br-group-2", topics = "br-topic", containerFactory = "listenerContainerFactory")
    @KafkaListener(groupId = "br-group-2", topics = "br-topic",containerFactory = "validMsgContainerFactory")
    public void history(String message) {
        log.info("HISTORY ::: Message received: {}", message);
    }

}
