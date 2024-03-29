package com.example.helloboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class HelloController {
    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    public String hello(String name) {
        if (name == null || name.length() == 0) throw new IllegalArgumentException();
        return helloService.sayHello(name);
    }

    @GetMapping("/count")
    public String count(String name) {
        return String.valueOf(helloService.countOf(name));
    }
}
