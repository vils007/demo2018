package com.example.demo.service;


import com.example.demo.domen.EventDAO;
import com.example.demo.domen.EventDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;

@Service
public class EventService {

    EntityManager entityManager;

    @Autowired
    EventDAO eventDAO;

    private static final Logger log = LoggerFactory.getLogger(EventService.class);

    public List<EventDTO> findByDescription(String description) {
        return eventDAO.findByDescription(description);
    }

    public void addEvent(String description, String type) {
        Date date = new Date();
        EventDTO event = new EventDTO();
        event.setEventDt(date);
        event.setDescription(description);
        event.setType(type);
        eventDAO.save(event);
    }
}
