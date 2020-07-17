package com.example.demo;

public class Person {
    private Name name;
    private Street addr;
    public Person(Person originalPerson){
        this.name = originalPerson.name;
        this.addr = originalPerson.addr;
    }
}
