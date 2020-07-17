package com.example.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

@Component
@Slf4j
public class RedisUtils {

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.password}")
    private String password;

    public Jedis getJedis(){
        Jedis jedis = new Jedis(host);
        jedis.auth(password);
        return jedis;
    }

}
