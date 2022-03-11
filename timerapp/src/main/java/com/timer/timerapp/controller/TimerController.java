package com.timer.timerapp.controller;

import com.timer.timerapp.executer.MainScheduler;

import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/api")
public class TimerController {
    
    private MainScheduler exeFile;

    @Autowired
    public  TimerController(MainScheduler exeFile){
        this.exeFile = exeFile;
    }

    @RequestMapping( method = RequestMethod.POST, value="/run" )
    public void runHelloWolrd(){
        exeFile.runHelloWolrd();
    }

}
