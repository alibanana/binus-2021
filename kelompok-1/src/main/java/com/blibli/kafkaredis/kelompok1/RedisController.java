package com.blibli.kafkaredis.kelompok1;

import com.blibli.kafkaredis.kelompok1.command.AddRedisKeyValue.AddRedisKeyValueCommand;
import com.blibli.kafkaredis.kelompok1.command.GetRedisKeys.GetRedisKeysCommand;
import com.blibli.kafkaredis.kelompok1.commandExecutor.CommandExecutor;
import com.blibli.kafkaredis.kelompok1.command.GetRedisValueByKey.GetRedisValueByKeyCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@RestController
public class RedisController {

    @Autowired
    private CommandExecutor commandExecutor;

    @GetMapping(path = "/redis/keys")
    public Mono<List<String>> getKeys() {
        return commandExecutor.execute(GetRedisKeysCommand.class, null);
    }

    @GetMapping(path = "/redis/keys/{key}")
    public Mono<String> getValueByKey(@PathVariable String key) {
        return commandExecutor.execute(GetRedisValueByKeyCommand.class, key);
    }


    @PostMapping(path = "/redis/keys")
    public Mono<Void> addKeyValue(@RequestParam String key, @RequestParam String value) {
        return commandExecutor.execute(AddRedisKeyValueCommand.class, Arrays.asList(key, value));
    }

}
