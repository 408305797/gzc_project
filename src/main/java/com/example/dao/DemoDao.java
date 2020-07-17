package com.example.dao;

import com.example.entity.DemoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoDao extends JpaRepository<DemoEntity,Integer>{

    DemoEntity save(DemoEntity demoEntity);
}
