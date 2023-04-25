package com.demo.grpcdemo.controller;

import com.demo.grpcdemo.greetingservice.GreetingServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {
    @Autowired
    GreetingServiceClient greetingServiceClient;

    @GetMapping("/greet/{id}")
    public String getAuthor(@PathVariable String message) {
        return greetingServiceClient.greet(message);
    }


}
