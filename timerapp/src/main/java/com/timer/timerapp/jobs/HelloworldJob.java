package com.timer.timerapp.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class HelloworldJob implements Job  {
    private static final Logger log = LoggerFactory.getLogger(HelloworldJob.class);

    @Override
    public void execute(JobExecutionContext context){
       log.info("Hello World 1");
        
    }
}