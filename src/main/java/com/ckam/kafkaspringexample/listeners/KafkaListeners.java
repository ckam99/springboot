package com.ckam.kafkaspringexample.listeners;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(
            topics = "message-create",
            groupId = "sprintboot-kafka-fastapi"
    )
    void listener(String data){
        System.out.println("Received data from listener: "+ data + " :)");
    }
}
