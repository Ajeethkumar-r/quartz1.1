package com.timer.timerapp.util;
import com.timer.timerapp.info.TimerInfo;

import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;

import java.util.Date;

// it consit of jobDetail which holds jobBuilder( JobDtaMap ), TrrigerBuilder  this have instance of our job and trigger and it will use by our Scheduler
public class JobFactoryUtil {
    private JobFactoryUtil(){

    }
    
    public static JobDetail buildJobDetail( final Class jobClass, TimerInfo info ){
        final JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put(jobClass.getSimpleName(), info );

        return JobBuilder
        .newJob(jobClass)
        .withIdentity( jobClass.getSimpleName() )
        .setJobData(jobDataMap)
        .build();  

    }

    public static Trigger buildTrigger( final Class jobClass, final TimerInfo info ){

        SimpleScheduleBuilder  builder =  SimpleScheduleBuilder.simpleSchedule().withIntervalInMilliseconds(info.getRepeatIntervalMs());

        if( info.isRepeatForever() ){
            // if repeatforEver is true we don't need to specify totalcount
            builder =  builder.repeatForever();
        }else {
            // this should define our scheduler to run no.of times in total 
            builder = builder.withRepeatCount(info.getTotalFireCount()-1);
        }

        return TriggerBuilder
        .newTrigger()
        .withIdentity( jobClass.getSimpleName() )
        .withSchedule( builder )
        .startAt( new Date( System.currentTimeMillis() + info.getIntialOffsetMs() ) )
        .build();
    }
}
