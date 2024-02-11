package com.curso.springboot.webapp.controllers;

import com.curso.springboot.webapp.models.User;
import com.curso.springboot.webapp.models.dto.UserDto;
import com.curso.springboot.webapp.transformers.UserTransformer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    private final UserTransformer userTransformer;

    public UserController(UserTransformer userTransformer) {
        this.userTransformer = userTransformer;
    }

    @GetMapping("/details")
    public String details(Model model) {
        User user = User.builder()
                .name("john")
                .lastname("doe")
                .build();
        UserDto dto = userTransformer.toDto(user, "Hello World spring boot");
        model.addAttribute("user", dto);
        model.addAttribute("age", "33");
        return "details";
    }
}
