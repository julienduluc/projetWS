package com.springboot.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.example.demo.interceptors.ApplicationContext;

@RestController
public class UserController {
    private ApplicationContext applicationContext;

    public UserController(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @GetMapping(value = "/utilisateurs")
    @ResponseBody
    ApplicationContext getContext() {
        return this.applicationContext;
    }
}
