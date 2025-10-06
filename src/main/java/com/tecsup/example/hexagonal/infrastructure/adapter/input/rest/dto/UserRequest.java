package com.tecsup.example.hexagonal.infrastructure.adapter.input.rest.dto;

import com.tecsup.example.hexagonal.domain.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    private String name;
    private String fatherLastname;
    private String email;
    private String password;

    private String motherLastname;
    private Integer age;
    private String dni;
    private String phone;
    private Role role;
}
