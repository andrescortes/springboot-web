package com.curso.springboot.webapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping("/detail2")
    public Map<String, Object> details() {
        Map<String, Object> model = new HashMap<>();
        model.put("title", "Hello World spring boot");
        model.put("name", "john");
        model.put("lastname", "doe");
        model.put("age", "33");
        return model;
    }
}
