package com.example.cache;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

@Component
public class RedisTest {

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.password}")
    private String password;

    public void aaa(){
        System.out.println(host);
    }

    public static void main(String[] args) {
        new RedisTest().aaa();
//        System.out.println(host);
//        Jedis jedis = new Jedis(host);



//        jedis.auth(password);
//        System.out.println(jedis.ping());
    }
}
