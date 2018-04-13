package com.example.demo;

import com.example.demo.Components.MainGrid;
import com.example.demo.domen.EventDAO;
import com.example.demo.domen.EventRepository;

import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

import org.springframework.beans.factory.annotation.Autowired;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@SpringUI
public class MainUI extends UI {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    EventDAO eventDAO;

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        MainGrid mainGrid = new MainGrid( eventRepository, eventDAO);
        setContent(mainGrid);
        Notification.show(Page.getCurrent().getLocation().getHost());
    }


}
