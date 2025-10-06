package com.tecsup.example.hexagonal.application.service;

import com.tecsup.example.hexagonal.application.port.output.UserRepository;
import com.tecsup.example.hexagonal.domain.exception.UserNotFoundException;
import com.tecsup.example.hexagonal.domain.model.Role;
import com.tecsup.example.hexagonal.domain.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private User user;

    @BeforeEach
    void setup() {
        user = new User(1L,
                "Juan",
                "juan@perez.com",
                "password123",
                true,
                "987654321",
                "12345678",
                "Perez",
                "Gomez",
                30,
                Role.USER);
    }

    @Test
    void createUser_ShouldReturnSavedUser() {
        User userToSave = new User(null, "Juan", "juan@perez.com", "password123", true, "987654321", "12345678", "Perez", "Gomez", 30, Role.USER);
        when(userRepository.save(any(User.class))).thenReturn(user);

        User createdUser = userService.createUser(userToSave);

        assertNotNull(createdUser);
        assertEquals(user.getId(), createdUser.getId());
        assertEquals(user.getName(), createdUser.getName());
    }

    @Test
    void findUser_ShouldReturnUser_WhenUserExists() {
        Long userId = 1L;
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        User foundUser = userService.findUser(userId);

        assertNotNull(foundUser);
        assertEquals(userId, foundUser.getId());
    }

    @Test
    void findUser_ShouldThrowUserNotFoundException_WhenUserDoesNotExist() {
        Long userId = 999L;
        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        assertThrows(UserNotFoundException.class, () -> userService.findUser(userId));
    }

    @Test
    void findByDni_ShouldReturnUser_WhenDniExists() {
        String dni = "12345678";
        when(userRepository.findByDni(dni)).thenReturn(Optional.of(user));

        Optional<User> result = userService.findByDni(dni);

        assertTrue(result.isPresent());
        assertEquals(dni, result.get().getDni());
    }

    @Test
    void findByFatherLastname_ShouldReturnUserList() {
        String lastname = "Perez";
        when(userRepository.findByFatherLastname(lastname)).thenReturn(Collections.singletonList(user));

        List<User> result = userService.findByFatherLastname(lastname);

        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
        assertEquals(lastname, result.get(0).getFatherLastname());
    }

    @Test
    void findByAgeLessThan_ShouldReturnUserList() {
        int age = 35;
        when(userRepository.findByAgeLessThan(age)).thenReturn(Collections.singletonList(user));

        List<User> result = userService.findByAgeLessThan(age);

        assertFalse(result.isEmpty());
        assertTrue(result.get(0).getAge() < age);
    }
}