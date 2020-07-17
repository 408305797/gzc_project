package com.example.test;

public enum Test {

    S_STATUS(0,"已开始"),
    M_status(1,"进行中"),
    E_status(2,"已结束");

    int status_id;
    String des;


    Test(int status_id, String des) {
        this.status_id = status_id;
        this.des = des;
    }
    public static Test getTest(int status_id){
        for(Test testStatus:values()){
            if(status_id == testStatus.status_id){
                return testStatus;
            }
        }
        return S_STATUS;
    }
}
