package com.curso.springboot.webapp.transformers;

import com.curso.springboot.webapp.models.User;
import com.curso.springboot.webapp.models.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserTransformer {

    UserDto toDto(User user, String title);
}
