package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
    
    @GetMapping
    public String hello() {
        String name = "Leonan";
        Integer age = 25;
        return "Hello from container "  + name + " " + age.toString();
    }
}
