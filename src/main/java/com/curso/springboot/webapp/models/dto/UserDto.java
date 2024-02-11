package com.curso.springboot.webapp.models.dto;

import com.curso.springboot.webapp.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder(toBuilder = true)
public class UserDto {
    private String title;
    private User user;
}
