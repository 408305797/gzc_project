package com.example.controller;

import com.example.cache.RedisUtils;
import com.example.entity.TestToRedisEntity;
import com.example.service.TestToRedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/testToRedis")
@Slf4j
public class TestToRedisController {

    @Autowired
    private TestToRedisService testToRedisService;
    @Autowired
    private RedisUtils redisUtils;

    @RequestMapping(value = "/findToRedis",method = RequestMethod.GET)
    public String findAllEntity(){
        long beginTime = 0;
        long endTime = 0;
        List<TestToRedisEntity> testToRedisEntity = testToRedisService.findTestToRedisEntity();
        beginTime = new Date().getTime();//开始计时

//        for(TestToRedisEntity testToRedisEntityOne:testToRedisEntity ){
//
//        }
        redisUtils.getJedis().set("testToRedisEntity",testToRedisEntity.toString());
//        redisUtils.getJedis().del("testToRedisEntity");
        endTime = new Date().getTime();
        log.info("--------写入Redis耗时:"+ (endTime-beginTime)+"毫秒---------------------");
        return "success";
    }
}
