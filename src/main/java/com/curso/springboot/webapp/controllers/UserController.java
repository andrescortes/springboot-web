package com.curso.springboot.webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model) {
        model.addAttribute("title", "Hello World spring boot");
        model.addAttribute("name", "john");
        model.addAttribute("lastname", "doe");
        return "details";
    }
}
