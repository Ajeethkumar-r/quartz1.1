package com.timer.timerapp.executer;

import com.timer.timerapp.info.TimerInfo;
import com.timer.timerapp.timerScheduler.SchedulerFactory;
import com.timer.timerapp.jobs.HelloworldJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainScheduler {
    
    private SchedulerFactory schedulerFactory;

    @Autowired
    public MainScheduler( SchedulerFactory schedulerFactory ){

    }

    public void runHelloWolrd(){

        TimerInfo info = new TimerInfo();
        info.setTotalFireCount(5);
        info.setIntialOffsetMs(2000);
        info.setRepeatIntervalMs(4000);
        info.setCallbackData("I am runnig");

        // execution of scheduled job with timer info
        schedulerFactory.schedule(HelloworldJob.class, info);
    }

}
