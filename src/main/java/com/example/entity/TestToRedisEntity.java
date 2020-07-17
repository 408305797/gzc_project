package com.example.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="test_redis")
@Data
public class TestToRedisEntity {

    @Id
    private String id;
    @Column
    private String name;
    @Column
    private String age;
    @Column
    private String phone;
    @Column
    private String email;
}
