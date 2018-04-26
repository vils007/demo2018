package com.example.demo.controllers;

import com.example.demo.domen.EventDAO;
import com.example.demo.domen.EventDTO;
import com.example.demo.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created on 06.04.2018.
 */
@RestController
public class EventController {


    @Autowired
    private EventDAO eventDAO;

    @Autowired
    private EventService eventService;

    private static final Logger log = LoggerFactory.getLogger(EventController.class);

    private static final String DELETE_BY_ID = "/delete_by_id";
    private static final String FIND_BY_TYPE = "/type/{type}";
    private static final String ALL_EVENT = "/event";
    private static final String TYPE = "event controller";

    @RequestMapping(value = ALL_EVENT, method = RequestMethod.GET)
    public List<EventDTO> getAllEvent() {
        Iterable<EventDTO> list = eventDAO.findAll();
        List<EventDTO> result = new ArrayList<EventDTO>();
        for (EventDTO l : list) result.add(l);
        return result;
    }

    @RequestMapping(value = FIND_BY_TYPE, method = RequestMethod.GET)
    public List<EventDTO> findByType(@PathVariable String type) {
        Iterable<EventDTO> list = eventDAO.findByType(type);
        List<EventDTO> result = new ArrayList<EventDTO>();
        for (EventDTO l : list) result.add(l);
        return result;
    }

    @RequestMapping(value = ALL_EVENT, method = RequestMethod.POST)
    public void addEvent(@RequestBody String description) {
        eventService.addEvent(description,TYPE);
    }

    @RequestMapping(value = DELETE_BY_ID, method = RequestMethod.DELETE)
    public String delete(@PathVariable long id) {
        try {
            eventService.deleteEventById(id);
        }
        catch (Exception ex) {
            return "Error deleting the news: " + ex.toString();
        }
        return id + " :Ok";
    }

}
