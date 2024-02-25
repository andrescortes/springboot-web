package com.curso.springboot.webapp.controllers;

import com.curso.springboot.webapp.models.User;
import com.curso.springboot.webapp.models.dto.UserDto;
import com.curso.springboot.webapp.transformers.UserTransformer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashSet;
import java.util.Set;

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
                .email("j@j.com")
                .build();
        UserDto dto = userTransformer.toDto(user, "Hello World spring boot");
        model.addAttribute("user", dto);
        return "details";
    }

    @GetMapping("/users")
    public String details2(ModelMap model) {
        Set<UserDto> users = new HashSet<>();
        User user = User.builder()
                .name("john")
                .lastname("doe")
                .email("j@j.com")
                .build();
        User user2 = User.builder()
                .name("carl")
                .lastname("dom")
                .email("c@c.com")
                .build();
        User user3 = User.builder()
                .name("john")
                .lastname("doe")
                .email("j@j.com")
                .build();
        UserDto dto = userTransformer.toDto(user, "User 1");
        UserDto dto2 = userTransformer.toDto(user2, "User 2");
        UserDto dto3 = userTransformer.toDto(user3, "User 3");

        users.add(dto);
        users.add(dto2);
        users.add(dto3);
        model.addAttribute("users", users);
        return "users";
    }
}
