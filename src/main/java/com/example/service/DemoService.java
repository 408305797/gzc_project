package com.example.service;

import com.example.entity.DemoEntity;
import com.example.entity.TestToRedisEntity;

import java.util.List;

public interface DemoService {
    DemoEntity insertIntoEntity(DemoEntity demoEntity);
    void deleteEntity(int id);
    List<DemoEntity> findDemoEntityList();
    DemoEntity getOneOnly(int id);
}
