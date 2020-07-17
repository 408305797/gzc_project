package com.example.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.*;

@Slf4j
public class Consumer {
    public static void main(String[] args) {
        Properties props=new Properties();

        props.put("bootstrap.servers", "192.168.157.128:9092");
        //每个消费者分配独立的组号
        props.put("group.id","test");
        //如果value合法，则自动提交偏移量
        props.put("enable.auto.commit", "true");
        props.put("auto.offset.reset","earliest");
        //设置多久一次更新被消费消息的偏移量
        //这个参数有可能导致consumer获取不到数据
        props.put("auto.commit.interval.ms", "1000");

        //设置会话响应的时间，超过这个时间kafka可以选择放弃消费或者消费下一条消息
        props.put("session.timeout.ms", "30000");
//        props.put("max.poll.records",10);

        props.put("key.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);

//        consumer.subscribe(Arrays.asList("test"));
        consumer.subscribe(Collections.singletonList("demo"));
//        System.out.println(props.get("auto.offset.reset"));
//        System.out.println();
        int i = 0;
        List<String> list =  new ArrayList<>();
//        while (true) {
        ConsumerRecords<String, String> records = consumer.poll(1000);
        System.out.println(records.count());
        for (ConsumerRecord<String, String> record : records) {
//                    System.out.println(record.topic());


            System.out.println(record.offset()+":"+record.value());
        }
//        try {
//            while (true) {
//                for (ConsumerRecord<String, String> record : records) {
////                    System.out.println(record.topic());
////                    log.info("offset = %d, key = %s, value = %s\n", record.offset(), record.key(), record.value());
//                    // print the offset,key and value for the consumer records.
//            System.out.printf("offset = %d, key = %s, value = %s\n",
//                    record.offset(), record.key(), record.value());
////                    list.add(record.value());
////        }
//                }
//            }
//        }catch (Exception e){
//            consumer.close();
//        }
    }
}
