package com.codify.codifygitproject.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/codify_5")
public class Cody5Controller {

    @GetMapping(value = "/setName")
    public ResponseEntity<String> getHello(@RequestParam("name") String name) {

        if (Objects.isNull(name) || name.isEmpty()) {
            throw new IllegalArgumentException("Параметр <name> не должен быть пустым");
        }
        if (!name.matches("^(?!^\\s+$).{4,}$")) {
            throw new IllegalArgumentException("Параметр <name> не должен содержать только пробелы!");
        }
        return ResponseEntity.ok("Hello " + name);
    }
}
