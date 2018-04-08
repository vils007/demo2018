package com.example.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Random;

/**
 * Created on 02.04.2018.
 * используем spring-retry
 * /health по этому адресу будет 'не стабильный' сервис 50/50
 */

@Controller
public class PulseController {

    @RequestMapping ("/pulse")
    public ResponseEntity<String> getHealth(){
        Random random = new Random();
        int randomInt = random.nextInt(2);
        if (randomInt == 1){
            return new ResponseEntity<String>("INTERNAL_SERVER_ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<String>("OK", HttpStatus.OK);
    }

}
