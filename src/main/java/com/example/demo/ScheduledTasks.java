package com.example.demo;

import com.example.demo.service.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTasks {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    @Autowired
    EventService eventService;

    @Scheduled(fixedRate = 500000)
    public void reportCurrentTime() {

        eventService.addEvent("Task event fix rate = 500000", "scheduler");
        log.info(("The time is now " + dateFormat.format(new Date())));
    }

}
