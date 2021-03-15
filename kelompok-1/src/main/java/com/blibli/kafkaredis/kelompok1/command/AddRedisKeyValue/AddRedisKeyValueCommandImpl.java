package com.blibli.kafkaredis.kelompok1.command.AddRedisKeyValue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class AddRedisKeyValueCommandImpl implements AddRedisKeyValueCommand {

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Override
    public Mono<Void> execute(List<String> keyValueList) {
        redisTemplate.opsForValue().set(keyValueList.get(0), keyValueList.get(1));
        return null;
    }
}
