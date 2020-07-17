package com.example.dao;

import com.example.entity.TestToRedisEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestToRedisDao extends JpaRepository<TestToRedisEntity,String> {

}
