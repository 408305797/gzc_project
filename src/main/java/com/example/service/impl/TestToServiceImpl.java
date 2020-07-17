package com.example.service.impl;

import com.example.dao.TestToRedisDao;
import com.example.entity.TestToRedisEntity;
import com.example.service.TestToRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestToServiceImpl implements TestToRedisService {
    @Autowired
    private TestToRedisDao testToRedisDao;

    public List<TestToRedisEntity> findTestToRedisEntity() {
        List<TestToRedisEntity> testToRedisEntities = testToRedisDao.findAll();
        return testToRedisEntities;
    }
}
