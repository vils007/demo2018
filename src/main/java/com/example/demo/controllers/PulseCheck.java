package com.example.demo.controllers;

import com.example.demo.service.PulseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Администратор on 02.04.2018.
 */
@RestController
public class PulseCheck {

    @Autowired
    private PulseService pulseService;

    @RequestMapping("/check-pulse")
    public String checkStatus(){
        return pulseService.getPulse();
    }
}
