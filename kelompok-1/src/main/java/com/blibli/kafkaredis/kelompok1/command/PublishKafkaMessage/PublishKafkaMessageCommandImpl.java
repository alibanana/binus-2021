package com.blibli.kafkaredis.kelompok1.command.PublishKafkaMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class PublishKafkaMessageCommandImpl implements PublishKafkaMessageCommand {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public Mono<Void> execute(List<String> topicMessageList) {
        kafkaTemplate.send(topicMessageList.get(0), topicMessageList.get(1));
        return null;
    }
}
