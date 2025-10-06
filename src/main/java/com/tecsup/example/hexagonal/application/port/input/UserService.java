package com.tecsup.example.hexagonal.application.port.input;

import com.tecsup.example.hexagonal.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User createUser(User newUser);

    User findUser(Long id);

    List<User> findByFatherLastname(String fatherLastname);
    Optional<User> findByDni(String dni);
    List<User> findByAgeLessThan(int age);
}
