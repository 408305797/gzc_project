package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.VO.DataVO;
import com.example.VO.ListVo;
import com.example.VO.ResultVO;
import com.example.cache.RedisUtils;
import com.example.entity.DemoEntity;
import com.example.service.DemoService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.JsonObject;
import kafka.utils.Json;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/demoController")
@Slf4j
public class DemoController{

    @Autowired
    private DemoService demoService;
    @Autowired
    private RedisUtils redisUtils;

    @RequestMapping("/insert")
    public void insertEntity(){
        DemoEntity demoEntity = new DemoEntity();
        demoEntity.setAddr("上海");
        demoEntity.setAge(19);
        demoEntity.setName("兔子");
        demoEntity.setCreateTime(new Date());
        demoEntity.setUpdateTime(new Date());
        DemoEntity demoEntity1 = demoService.insertIntoEntity(demoEntity);
        System.out.println(demoEntity1.getAge());
        log.info("貌似插入成功了！");
    }
//    @RequestMapping(value = "/delete",method = RequestMethod.GET)
//    public void delete(@RequestParam("id") int id){
//        demoService.deleteEntity(id);
//        log.info("restful调用删除成功！");
//    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public void delete(@PathVariable("id") int id){
        demoService.deleteEntity(id);
        log.info("restful调用删除成功！");
    }

    @RequestMapping(value="/find",method = RequestMethod.GET)
    public List<DemoEntity> findEntity(){
        List<DemoEntity> demoEntityList = demoService.findDemoEntityList();
        if(demoEntityList.size()>0){
            for(DemoEntity demoEntityList1:demoEntityList){
                redisUtils.getJedis().lpush("key1",demoEntityList1.getName());
            }
            redisUtils.getJedis().set("name","张三");
            String set = redisUtils.getJedis().set("NAME", "李四", "NX", "PX", 5000);
            String set1 = redisUtils.getJedis().set("AGE", "33", "NX", "PX", 20000);
            System.out.println(set);
            System.out.println(redisUtils.getJedis().lrange("key1",0,-1));
            return demoEntityList;
        }
        return null;
    }
    @RequestMapping(value="/testVo",method = RequestMethod.GET)
    public ResultVO test(){
        ResultVO resultVO = new ResultVO();
        DataVO dataVO = new DataVO();
        ListVo listVo = new ListVo();
        dataVO.setPhone("222");
        dataVO.setName("11");
        dataVO.setAge("11");
        dataVO.setAddr("jd");
        listVo.setNumber("22");
        listVo.setTitle("第一种");
        listVo.setList(Arrays.asList(dataVO));
        resultVO.setCode("200");
        resultVO.setMessage("-----------");
        resultVO.setData(listVo);
        return resultVO;
    }
    @RequestMapping(value = "/findOne",method = RequestMethod.GET)
    public JSONObject finDemoEntity(@RequestParam int id){
       DemoEntity demoEntity = demoService.getOneOnly(id);
       JSONObject jsonObject = (JSONObject) JSONObject.toJSON(demoEntity);

       return jsonObject;
    }
    @RequestMapping("/testHttp")
    public String getHttp(){
        log.info("------------------------");
        RestTemplate restTemplate = new RestTemplate();
        String forObject = restTemplate.getForObject("http://192.168.157.128:8081/demoHttp/demo", String.class);
        System.out.println(forObject);
        return forObject;
    }
}
