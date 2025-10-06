package com.tecsup.example.hexagonal.infrastructure.adapter.output.persistence.mapper;


import com.tecsup.example.hexagonal.domain.model.User;
import com.tecsup.example.hexagonal.infrastructure.adapter.input.rest.dto.UserRequest;
import com.tecsup.example.hexagonal.infrastructure.adapter.input.rest.dto.UserResponse;
import com.tecsup.example.hexagonal.infrastructure.adapter.output.persistence.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserEntity toEntity(User domain);

    User toDomain(UserEntity entity);
    List<User> toDomainList(List<UserEntity> entities);

    @Mapping(target = "id", ignore = true) // New users don't have ID
    @Mapping(target = "name", source = "name")
    @Mapping(target = "email", source = "email")
    User toDomain(UserRequest request);
    UserResponse toResponse(User createUser);
    List<UserResponse> toResponseList(List<User> users);
}
