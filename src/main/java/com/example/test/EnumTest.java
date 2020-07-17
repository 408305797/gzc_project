package com.example.test;

import org.springframework.boot.SpringBootVersion;
import org.springframework.core.SpringVersion;

import java.util.HashMap;
import java.util.Map;

public class EnumTest {
    public static void main(String[] args) {
        System.out.println(SpringBootVersion.getVersion());
        int status = 2;

//        System.out.println(Test.S_STATUS.des);
//        System.out.println(Test.getTest(status).des);
        Map<Integer,String> map = new HashMap<Integer, String>();
        map.put(Test.getTest(status).status_id,Test.getTest(status).des);
//        System.out.println(map.get(Test.getTest(status).status_id));
        System.out.println(new EnumTest().toTest(status));
    }
    public String toTest(int status){
        if(status ==2){
            return Test.getTest(status).des;
        }
        return null;
    }
}
