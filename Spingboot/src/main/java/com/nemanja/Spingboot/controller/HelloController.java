package com.nemanja.Spingboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/")
public class HelloController {
    @Value("${welcome.message}")
    private String welcomeMessage;
    @GetMapping
    public String helloWorld(){
        return welcomeMessage;
    }
}
