package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Администратор on 02.04.2018.
 */
@Service
public class PulseService {
    private RestTemplate restTemplate = new RestTemplate();
    public String getPulse() {
        return restTemplate.getForObject("http://localhost:8080/pulse",String.class);
    }
}
