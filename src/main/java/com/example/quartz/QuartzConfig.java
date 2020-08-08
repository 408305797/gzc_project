package com.example.quartz;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.SchedulingException;

@Configuration
public class QuartzConfig {


    @Autowired
    private Scheduler scheduler;
    /**
     * 开启任务
     * @throws SchedulingException
     */
    public String startJob() throws SchedulerException{
        startJob(scheduler);
        scheduler.start();
        return "end";
    }
    public String getJobInfo(String name,String group) throws SchedulerException {
        TriggerKey triggerKey = new TriggerKey(name, group);
        CronTrigger cronTrigger = (CronTrigger) scheduler.getTrigger(triggerKey);
        System.out.println(String.format("time:%s,state:%s", cronTrigger.getCronExpression(),
                scheduler.getTriggerState(triggerKey).name()));
        return String.format("time:%s,state:%s", cronTrigger.getCronExpression(),
                scheduler.getTriggerState(triggerKey).name());
    }

    private void startJob(Scheduler scheduler) throws SchedulerException {
        // 通过JobBuilder构建JobDetail实例，JobDetail规定只能是实现Job接口的实例
        // JobDetail 是具体Job实例
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class).withIdentity("myJob", "myJob").build();
         // 基于表达式构建触发器
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/10 * * * * ?");
        // CronTrigger表达式触发器 继承于Trigger
        // TriggerBuilder 用于构建触发器实例
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("myJob", "myJob")
                 .withSchedule(cronScheduleBuilder).build();
        scheduler.scheduleJob(jobDetail, cronTrigger);
    }

    public void removeJob(String name,String group)throws SchedulerException{
        JobKey jobKey = new JobKey(name,group);
        JobDetail jobDetail = scheduler.getJobDetail(jobKey);
        if(jobDetail == null){
            return;
        }
        scheduler.deleteJob(jobKey);

    }

}
