package com.timer.timerapp.timerScheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import com.timer.timerapp.info.TimerInfo;
  
import org.quartz.JobDetail;
import org.quartz.Trigger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import com.timer.timerapp.util.JobFactoryUtil;

@Service
public class SchedulerFactory{

    private static final Logger log = LoggerFactory.getLogger( SchedulerFactory.class );

    private final Scheduler scheduler;

    @Autowired
    public SchedulerFactory( Scheduler scheduler ){
        this.scheduler = scheduler;
    }


    //  schedule our job by getting the jobdetail and trigger using scheduleJob method
    public void schedule( final Class jobClass, TimerInfo info ){
         JobDetail jobDetail = JobFactoryUtil.buildJobDetail(jobClass, info);
         Trigger trigger = JobFactoryUtil.buildTrigger(jobClass, info); 

         try{
            scheduler.scheduleJob(jobDetail, trigger);
         }catch( SchedulerException e ){
            log.error(e.getMessage(), e);
         }
    }

    @PostConstruct
    public void init(){
        try{
            scheduler.start();
        } catch( SchedulerException se )
        {
            log.error( se.getMessage(), se );
        }
    }

    @PreDestroy
    public void preDestroy(){
        try{
            scheduler.shutdown();
        } catch( SchedulerException se )
        {
            log.error( se.getMessage(), se );
        }
    }
    
}
