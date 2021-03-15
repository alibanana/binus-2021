package com.blibli.kafkaredis.kelompok1.command.GetRedisValueByKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class GetRedisValueByKeyCommandImpl implements GetRedisValueByKeyCommand {

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Override
    public Mono<String> execute(String key) {
        Object redisObject = redisTemplate.opsForValue().get(key);
        if (redisObject != null) {
            return Mono.just(redisObject.toString());
        }
        return null;
    }
}
