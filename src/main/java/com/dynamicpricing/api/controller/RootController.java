package com.dynamicpricing.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

    @GetMapping("/")
    public String root() {
        return "Welcome to the Dynamic Pricing API!" + "\n" + "ONE OF MY FIRST EVER SOLO PROJECTS WATCH ME FUCKING WORK";
    }
}

