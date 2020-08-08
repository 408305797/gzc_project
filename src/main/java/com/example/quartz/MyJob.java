package com.example.quartz;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MyJob implements Job {
    @Autowired
    private Scheduler scheduler;

    public void start(){
        Date date = new Date();
        System.out.println("定时任务开始执行--------------------->"+date.getTime());
    }
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        start();
        System.out.println("---------------------");
        try {
            end();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
    public String end() throws SchedulerException{
        Date date = new Date();
        System.out.println("定时任务执行结束--------------------->"+date.getTime());
        scheduler.clear();
        return "end";
    }
}
