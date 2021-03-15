package com.blibli.kafkaredis.kelompok1;

import com.blibli.kafkaredis.kelompok1.command.PublishKafkaMessage.PublishKafkaMessageCommand;
import com.blibli.kafkaredis.kelompok1.commandExecutor.CommandExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class KafkaController {

    @Autowired
    private CommandExecutor commandExecutor;

    @PostMapping(path = "/kafka/publish")
    public void publishMessage(@RequestParam String topic, @RequestParam String message){
        commandExecutor.execute(PublishKafkaMessageCommand.class, Arrays.asList(topic, message));
    }
}
