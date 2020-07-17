package com.example.service.impl;

import com.example.dao.DemoDao;
import com.example.dao.TestToRedisDao;
import com.example.entity.DemoEntity;
import com.example.entity.TestToRedisEntity;
import com.example.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DemoServiceImpl implements DemoService{
    @Autowired
    private DemoDao demoDao;
    @Autowired
    private TestToRedisDao testToRedisDao;

    @Transactional
    public DemoEntity insertIntoEntity(DemoEntity demoEntity) {
        return demoDao.save(demoEntity);
    }

    @Override
    @Transactional
    public void deleteEntity(int id) {
        demoDao.deleteById(id);
    }

    @Override
    public List<DemoEntity> findDemoEntityList() {
        List<DemoEntity> demoEntityList = demoDao.findAll();
        return demoEntityList;
    }

    @Override
    public DemoEntity getOneOnly(int id) {
        return demoDao.getOne(id);
    }

}
