package com.curso.springboot.webapp.controllers;

import com.curso.springboot.webapp.models.ParamDto;
import com.curso.springboot.webapp.models.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping("/detail2")
    public Map<String, Object> detailsMap() {
        Map<String, Object> model = new HashMap<>();
        User user = User.builder()
                .name("john")
                .lastname("doe")
                .build();
        model.put("title", "Hello World spring boot");
        model.put("user", user);
        model.put("age", "33");
        return model;
    }

    @GetMapping("/detail-users")
    public List<User> detailList() {
        User user = User.builder()
                .name("john")
                .lastname("doe")
                .build();

        User user2 = User.builder()
                .name("john2")
                .lastname("doe2")
                .build();
        return Arrays.asList(user, user2);
    }

    @GetMapping("/params")
    public ParamDto params(HttpServletRequest request) {
        ParamDto dto = new ParamDto();
        dto.setMessage(request.getParameter("message"));
        dto.setCode(Integer.parseInt(request.getParameter("code")));
        return dto;
    }
}
