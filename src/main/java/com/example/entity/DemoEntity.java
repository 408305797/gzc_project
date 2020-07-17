package com.example.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "sh_demo")
@Data
public class DemoEntity implements Serializable {

    private static final long serialVersionUID = -505713792817519552L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column
    String name;
    @Column
    int age;
    @Column
    String addr;
    @Column(name = "create_time")
    Date createTime;
    @Column(name = "update_time")
    Date updateTime;

}
