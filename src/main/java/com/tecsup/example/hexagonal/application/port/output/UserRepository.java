package com.tecsup.example.hexagonal.application.port.output;

import com.tecsup.example.hexagonal.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    User save(User user);

    Optional<User> findById(Long id);

    Optional<User> findByEmail(String email);

    List<User> findByFatherLastname(String fatherLastname);
    Optional<User> findByDni(String dni);
    List<User> findByAgeLessThan(int age);
}
