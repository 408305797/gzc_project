package com.example.kafka;


import kafka.message.Message;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.Producer;

import java.util.Properties;

public class ProducerKafka {
    public static  void main(String[] args)
    {
        Properties props=new Properties();

        //broker地址
        props.put("bootstrap.servers", "192.168.157.128:9092");
        //请求的时候需要验证
        props.put("acks", "all");
        //请求失败需要重试jps

        props.put("retries", "0");
        //内存缓存区大小
        props.put("buffer.memory", 33554432);
        //指定消息key序列化方式
        props.put("key.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        //指定消息本身的序列化方式
        props.put("value.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        Producer<String,String> producer = new KafkaProducer<>(props);
        String message ="demo:"+System.currentTimeMillis();
        for (int i = 0; i < 100; i++)
            producer.send(new ProducerRecord<String, String>("demo", Integer.toString(i), message+"序号"+i));

        producer.close();
    }
}
