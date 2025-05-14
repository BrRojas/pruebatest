package com.pruebatest.pruebatest.Service;

import com.pruebatest.pruebatest.Entity.UserRepository;
import com.pruebatest.pruebatest.Model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.verify;


import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void shouldSaveUser(){
        User user = new User(null, "Braian");
        User savedUser = new User(1L, "Braian");

        when(userRepository.save(user)).thenReturn(savedUser);

        User result = userService.saveUser(user);

        assertEquals(1L, result.getId());
        assertEquals("Braian", result.getName());
        verify(userRepository).save(user);
    }

    @Test
    void shouldGetAllUsers() {
        List<User> users = List.of(
                new User(1L, "Braian"),
                new User(2L, "Vicky")
        );

        when(userRepository.findAll()).thenReturn(users);

        List<User> result = userService.getAllUsers();

        assertEquals(2, result.size());
        assertEquals("Vicky", result.get(1).getName());
        verify(userRepository).findAll();
    }

    @Test
    void shouldGetUserById() {
        Long id = 1L;
        User user = new User(id, "Braian");

        when(userRepository.findById(id)).thenReturn(Optional.of(user));

        Optional<User> result = userService.getUserById(id);

        assertTrue(result.isPresent());
        assertEquals("Braian", result.get().getName());
        verify(userRepository).findById(id);
    }

    @Test
    void shouldReturnEmptyWhenUserNotFound() {
        Long id = 99L;

        when(userRepository.findById(id)).thenReturn(Optional.empty());

        Optional<User> result = userService.getUserById(id);

        assertTrue(result.isEmpty());
        verify(userRepository).findById(id);
    }

    @Test
    void shouldDeleteUser() {
        Long id = 1L;

        userService.deleteUser(id);

        verify(userRepository).deleteById(id);
    }
}
