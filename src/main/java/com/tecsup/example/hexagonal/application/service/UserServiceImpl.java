package com.tecsup.example.hexagonal.application.service;

import com.tecsup.example.hexagonal.application.port.input.UserService;
import com.tecsup.example.hexagonal.application.port.output.UserRepository;
import com.tecsup.example.hexagonal.domain.exception.InvalidUserDataException;
import com.tecsup.example.hexagonal.domain.exception.UserNotFoundException;
import com.tecsup.example.hexagonal.domain.model.Role;
import com.tecsup.example.hexagonal.domain.model.User;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User createUser(User newUser) {

        // Validation logic can be added here
        validateUserInput(newUser);

        // Set default values
        if (newUser.getRole() == null)
            newUser.setRole(Role.USER);

        // Save the user using the repository
        User user = this.userRepository.save(newUser);

        //user.setName("Margot"); // Garbage line for testing purposes

        return user;

    }
    @Override
    public User findUser(Long id) {

        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid user ID");
        }

        User user = this.userRepository.findById(id)
                .orElseThrow( ()-> new UserNotFoundException(id) );

        return user;
    }
    @Override
    public List<User> findByFatherLastname(String fatherLastname) {
        return userRepository.findByFatherLastname(fatherLastname);
    }

    @Override
    public Optional<User> findByDni(String dni) {
        return userRepository.findByDni(dni);
    }

    @Override
    public List<User> findByAgeLessThan(int age) {
        return userRepository.findByAgeLessThan(age);
    }
    private void validateUserInput(User newUser) {

        if (!newUser.hasValidName())
            throw new InvalidUserDataException("Invalid email");

        if (!newUser.hasValidEmail())
            throw new InvalidUserDataException("Invalid email");
    }
}