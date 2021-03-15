package com.blibli.kafkaredis.kelompok1.command.GetRedisKeys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import javax.lang.model.type.NullType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Component
public class GetRedisKeysCommandImpl implements GetRedisKeysCommand {

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Override
    public Mono<List<String>> execute(NullType nullType) {
        redisTemplate.setDefaultSerializer(new StringRedisSerializer());
        Set<Object> keys = redisTemplate.keys("test-*");

        if (keys != null) {
            List<String> keysList = new ArrayList<>();
            Iterator<Object> it = keys.iterator();
            while (it.hasNext()) {
                String data = it.next().toString();
                keysList.add(data);
            }
            return Mono.just(keysList);
        }
        return null;
    }
}
