package com.codify.codifygitproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/codify_5")
public class Cody5Controller {

    @GetMapping
    public String getHello(@RequestParam("name") String name){
        if(name == null || name.isEmpty()){
            return "Должен быть заполнен параметр";
        }
        return "Hello " + name;
    }
}
