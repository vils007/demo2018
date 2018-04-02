package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Администратор on 02.04.2018.
 */
@Controller
public class MainController {

    @RequestMapping("/hello")
    public String showHelloWorld() {
        return "hello-world";
    }

}
