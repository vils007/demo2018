package com.example.demo.service;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Администратор on 02.04.2018.
 */
@Service
public class PulseService {
    private RestTemplate restTemplate = new RestTemplate();

    private int count;
    public void clearCount(){
        count = 0;
    }

    @Retryable(maxAttempts = 10, value = RuntimeException.class, backoff = @Backoff(delay = 500, multiplier = 2))
    public String getPulse() {
        count++;
        return restTemplate.getForObject("http://localhost:8080/pulse",String.class) + ". Retry = " + count;
    }

    @Recover
    public String recover(){
        return "NOT OK";
    }
}
